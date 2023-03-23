package com.rk.service;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AppTest 
{
	private LoginService service=new LoginService();
	
    @Test
    public void testwithValidCredentials()
    {
    	//get actual results
        String result=service.login("raja","rani");
        assertEquals("test1","Valid Credentials",result);
    }
    
    @Test
    public void testwithInValidCredentials() {
    	String result=service.login("raja", "rano");
    	assertEquals("test2","invalid Credentials",result);
    }
    
    
    @Test(expected = IllegalArgumentException.class)
    public void testWithNoCredentials() {
    	//get actual result
    	String result=service.login("", "");
    }
}
