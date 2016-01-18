package maven;

import org.junit.Assert;
import org.junit.Test;


public class MainTest{
  
    public MainTest(){
    }
    
    @Test
    public void testAdd1Plus1() 
    {
        int x  = 1 ; int y = 1;
        Assert.assertEquals(2, Main.add(x,y));
    }
}
