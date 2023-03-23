package com.rk.main;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class PrinterTest 
{
   
    @Test
    public void testSingleton()
    {
    	Printer p1=Printer.getInstance();
    	Printer p2=Printer.getInstance();
		assertNotNull(p1);
		assertNotNull(p1);
		/*if(p1==null || p2==null) {
			fail("p1,p2 references must not be Null");//For manual error message
		}*/
    	assertSame(p1, p2);//assertSame==>checks given two references are pointing to same Object or not 
    }
}
