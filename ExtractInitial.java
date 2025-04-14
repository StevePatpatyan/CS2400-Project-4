
import java.util.*;
import java.io.*;

/**
 * Extract the initial file and final files from the solution.
 * 
 * Code with //- in front of it is in the initial file, but not in the solution.
 * Code with //+ in front of it is code that was part of an intermediate solution
 *    but is not in the initial or final solutions
 * Code between //v and //^ has been added for the solution.
 * 
 * 
 * @author Charles Hoot 
 * @version 5.1
 */

//vvvvvvvvv REPLACEMENT vvvvvvvvvvvvvvvvvvvvvvv      
//vvvvvvvvv ADDED CODE vvvvvvvvvvvvvvvvvvvvvvvv       
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

//vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv        
// * @version 5.1 (Modified for the Solution)
//^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^

public class ExtractInitial {

    /**
     * Just a main program to do the job
     */
    public static void main(String args[]) {
        Scanner checkFile = null;
        Scanner inFile = null;
        PrintWriter outFile1 = null;
        PrintWriter outFile2 = null;
        PrintWriter outFile3 = null;


        boolean removeLines = false;

        Scanner keyboard = new Scanner(System.in);
        String fileName = "";
        boolean done = false;
        boolean createXXXInitialFile = false;

        System.out.print("Create an xxxInitial class in the current directory? ");
        String response = keyboard.next();

        if (response.toLowerCase().charAt(0) == 'y') {
            createXXXInitialFile = true;
        }

        System.out.print("What is the name of the file to process? (leave off the extension)");
        fileName = keyboard.next();

        while (!done) {
            boolean solnFile = false;
            try {
                checkFile = new Scanner(new File("src/" + fileName + ".java"));
                
                while (checkFile.hasNextLine() && !solnFile) {
                    String line = checkFile.nextLine();
                    
                    String firstThree = line.trim();
                    if (firstThree.startsWith("//v")) {
                        solnFile=true;
                    }
                }
                checkFile.close();

                if(solnFile)
                    System.out.println("This is a solution file.");
                
                inFile = new Scanner(new File("src/" + fileName + ".java"));
                outFile1 = new PrintWriter("InitialFiles/" + fileName + ".java");
                
                if (createXXXInitialFile) 
                    outFile2 = new PrintWriter("src/" + fileName + "Initial.java");
                
                if (solnFile)
                    outFile3 = new PrintWriter("SolutionFiles/" + fileName + ".java");

                while (inFile.hasNextLine()) {
                    String line = inFile.nextLine();
                    
                    String firstThree = line.trim();
                    if (firstThree.startsWith("//-")) {
                        outFile1.println(line.replace("//-", ""));
                        if (createXXXInitialFile) {
                            outFile2.println(line.replace("//-", "").replace(fileName, fileName + "Initial"));
                        // Do not write this line to final
                        }
                    } else if (firstThree.startsWith("//+")) {
                        // Don't write this line to initial
                        // Don't write this line to final
                    } else if (firstThree.startsWith("//v")) {
                        removeLines = true;
                        // Don't write this line to initial
                        if(solnFile)
                            outFile3.println(line);                        
                    } else if (firstThree.startsWith("//^")) {
                        removeLines = false;
                        // Don't write it to initial, but the next we will
                        if(solnFile)
                            outFile3.println(line);
                    } else if (removeLines == false) {
                        // Write it out
                        outFile1.println(line);
                        if (createXXXInitialFile) {
                            outFile2.println(line.replace(fileName, fileName + "Initial"));
                        }
                        if(solnFile)
                            outFile3.println(line);
                    } else {
                        // Remove lines is true
                        // only write this to the solution file
                        if(solnFile)
                            outFile3.println(line);
                    }
                }
            } // end try
            catch (Exception e) {
                System.out.println("There was an error processing the file " + fileName);
                System.out.println(e);
            }

            if (checkFile != null) {
                checkFile.close();
            }

            if (outFile1 != null) {
                outFile1.close();
            }

            if (createXXXInitialFile) {
                if (outFile2 != null) {
                    outFile2.close();
                }
            }
           
            if (outFile3 != null) {
                outFile3.close();
            }

            if (inFile != null) {
                inFile.close();
            }

            removeLines = false;

            System.out.println("Extraction completed");
            System.out.print("What is the name of the next file to process? (done if finished)");
            fileName = keyboard.next();
            if (fileName.equals("done")) {
                done = true;
            }
        }  // end while

        System.out.println("Bye");
    } // end main
}
