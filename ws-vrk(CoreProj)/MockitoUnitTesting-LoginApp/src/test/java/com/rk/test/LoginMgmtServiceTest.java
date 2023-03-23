package com.rk.test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Arrays;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import com.rk.dao.ILoginDAO;
import com.rk.service.ILoginMgmtService;
import com.rk.service.LoginMgmtServiceImpl;

public class LoginMgmtServiceTest {
	private static ILoginMgmtService loginService;
	private static ILoginDAO loginDAOMock;
	
	
	@BeforeAll
	public static void setUpOnce() {
		//Create Mock or fake or Dummy Object
		loginDAOMock=Mockito.mock(ILoginDAO.class);//MockMethod generates InMemory class Implementing
													//ILoginDAO(i) having null method definition for authentication(-,-) method
		System.out.println(loginDAOMock.getClass()+" ===="+Arrays.toString(loginDAOMock.getClass().getInterfaces()));
		//Create Service class Object
		loginService=new LoginMgmtServiceImpl(loginDAOMock);
	}
	@AfterAll
	public static void clearOnce() {
		loginDAOMock=null;
		loginService=null;
	}
	
	//test method
	@Test
	public void testLoginWithValidCredentials() {
		//Provide stub (Temporary functionalities) for DAO's authentication method
		Mockito.when(loginDAOMock.authenticate("raja", "rani")).thenReturn(1);
		assertTrue(loginService.login("raja", "rani"));
	}

	@Test
	public void testLoginWithInValidCredentials() {
		//Provide stub (Temporary functionalities) for DAO's authentication method
		Mockito.when(loginDAOMock.authenticate("raja", "rani1")).thenReturn(0);
		assertFalse(loginService.login("raja", "rani1"));
	}
	@Test
	public void testLoginWithNoCredentials() {
		assertThrows(IllegalArgumentException.class, ()->loginService.login("", ""));
	}
}
