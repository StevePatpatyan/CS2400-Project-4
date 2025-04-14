 
/**
 * Test the recursive maximum.
 * 
 * @author Charles Hoot 
 * @version 5.0
 */
public class TestMax
{

    public static void main(String args[])
    {
        testForExceptions();
        testGoodValues();
    }
    
    public static void testForExceptions()
    {
        System.out.println("TESTING MAX TO SEE IF IT CATCHES BAD ARGUMENTS");
        
        RecursiveMaxOfArray rm = new RecursiveMaxOfArray();
        System.out.println("Trying a null array");
        int array[] = null;
        try
        {
            rm.max(array, 0, 0);
            System.out.println("*** Failed test (did not throw exception)");
        }
        catch(BadArgumentsForMaxException e)
        {
            System.out.println("    Passed test");
        }
        

        System.out.println("Trying an array of size 0");
        array = new int[0];
        try
        {
            rm.max(array, 0, 0);
            System.out.println("*** Failed test (did not throw exception)");
        }
        catch(BadArgumentsForMaxException e)
        {
            System.out.println("    Passed test");
        }
        
        System.out.println("Trying from less than 0");
        array = new int[5];
        try
        {
            rm.max(array, -1, 0);
            System.out.println("*** Failed test (did not throw exception)");
        }
        catch(BadArgumentsForMaxException e)
        {
            System.out.println("    Passed test");
        }


        System.out.println("Trying to greater than size");
        try
        {
            rm.max(array, 0, 5);
            System.out.println("*** Failed test (did not throw exception)");
        }
        catch(BadArgumentsForMaxException e)
        {
            System.out.println("    Passed test");
        }


        System.out.println("Trying from > to");
        try
        {
            rm.max(array, 1, 0);
            System.out.println("*** Failed test (did not throw exception)");
        }
        catch(BadArgumentsForMaxException e)
        {
            System.out.println("    Passed test");
        }  
        
        System.out.println();
        System.out.println();

    }
    

    public static void testGoodValues()
    {
        System.out.println("TESTING MAX TO SEE IF IT GETS THE CORRECT RESULTS");
        
        RecursiveMaxOfArray rm = new RecursiveMaxOfArray();
        int array[] = {4};
        int result;
        
        System.out.println("Trying an array of size 1");
        result = rm.max(array, 0, 0);        
        if(result==4)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 4");


        System.out.println("Trying an array of size 2, first is largest");
        int array2[] = {3, 2};
        result = rm.max(array2, 0, 1);        
        if(result==3)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 3");

        System.out.println("Trying an array of size 2, second is largest");
        int array3[] = {3, 4};
        result = rm.max(array3, 0, 1);        
        if(result==4)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 4");


        System.out.println("Trying an array of size 3, first is largest");
        int array4[] = {10, 3, 4};
        result = rm.max(array4, 0, 2);        
        if(result==10)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 10");


        System.out.println("Trying an array of size 3, second is largest");
        int array5[] = {10, 13, 4};
        result = rm.max(array5, 0, 2);        
        if(result==13)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 13");

        System.out.println("Trying an array of size 3, third is largest");
        int array6[] = {10, 13, 14};
        result = rm.max(array6, 0, 2);        
        if(result==14)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 14");


        System.out.println("Trying an array of size 20 (look at all values)");
        int array7[] = {10, 113, 25, 10, 35, 14, 29, 13, 14, 110, 13, 17, 34, 83, 9, 32, 44, 12, 90, 200};
        result = rm.max(array7, 0, 19);        
        if(result==200)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 200");

        System.out.println("Trying an array of size 20 (look at first third)");
        result = rm.max(array7, 0, 6);        
        if(result==113)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 113");

        System.out.println("Trying an array of size 20 (look at second third)");
        result = rm.max(array7, 7, 13);        
        if(result==110)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 110");
        
        System.out.println("Trying an array of size 20 (look at last third excluding the last value)");
        result = rm.max(array7, 13, 18);        
        if(result==90)
            System.out.println("    Passed test");
        else
            System.out.println("*** Failed test: returned " + result + " is not expect value of 90");
        
        System.out.println();
        System.out.println();
    }

}
