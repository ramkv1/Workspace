package com.rk.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

public class MockVsSpyTest {
	
	
	@Test
	public void testList() {
		List<String> listMock=Mockito.mock(ArrayList.class);
		List<String> listSpy=Mockito.spy(new ArrayList());
		listMock.add("table");
		listSpy.add("table");
		System.out.println(listMock.size()+"===="+listSpy.size());
	}
}
