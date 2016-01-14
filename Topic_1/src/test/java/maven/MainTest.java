package maven;

import junit.framework.TestCase;


public class MainTest  extends TestCase {
  
    public MainTest(String testName)    {
        super(testName);
    }
    
    public void test()
    {
        assertTrue(true);
    }
    
   
    public void testAdd1Plus1() 
    {
        int x  = 1 ; int y = 1;
        assertEquals(2, Main.add(x,y));
    }
}
