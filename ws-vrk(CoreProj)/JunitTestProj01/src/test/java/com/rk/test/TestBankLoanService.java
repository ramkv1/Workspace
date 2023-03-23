package com.rk.test;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTimeout;

import java.time.Duration;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import com.rk.service.BankLoanService;

//@TestMethodOrder(value = OrderAnnotation.class)//Best
//@TestMethodOrder(value = MethodName.class)
//@TestMethodOrder(MethodOrderer.DisplayName.class)
@TestMethodOrder(value = MethodOrderer.Random.class)//Default
public class TestBankLoanService {
	private static BankLoanService service;
	
	@BeforeAll
	public static void setUpOnce() {
		System.out.println("TestBankLoanService.setUpOnce()");
		service=new BankLoanService();
	}
	/*
	 * @BeforeEach public void setUp() {
	 * System.out.println("TestBankLoanService.setUp()"); service=new
	 * BankLoanService();
	 * 
	 * }
	 */
	@Test
	@DisplayName("testing With Small NUmbers")
	//@Order(1)
	public void testcalSimpleIntrestAmountWithSmallNumbers() {
		System.out.println("TestBankLoanService.testcalSimpleIntrestAmountWithSmallNumbers()");
		float actual=service.calSimpleIntrestAmount(100000, 2, 12);//Actual
		float expected=24000;//Through Manual calculation
		assertEquals(actual,expected);
	}
	@Test
	@DisplayName("testing With Big NUmbers")//To give programmer choice names
	//@Order(2)
	public void testcalSimpleIntrestAmountWithBigNumbers() {
		float actual=service.calSimpleIntrestAmount(10000000, 2, 12);//Actual
		float expected=2400000;//Through Manual calculation
		/* assertEquals(actual,expected,0.70,"may Result not Matching"); */
		assertEquals(expected,actual,"may Result not Maching");
	}
	@Test
	@DisplayName("testing With InvalidInputs NUmbers")
	//@Order(1)
	public void testcalSimpleIntrestAmountWithInvalidInputs() {
		System.out.println("TestBankLoanService.testcalSimpleIntrestAmountWithInvalidInputs()");
		assertThrows(/*ArithmeticException*/IllegalArgumentException.class,()->{
			service.calSimpleIntrestAmount(0, 0, 0);
		},
		"May excetion raised is not macting"
		);
	}
	@Test
	@Disabled
	@DisplayName("Calculate SimpleIntrestAmountWithTimer")
	@Order(3)
	public void testcalSimpleIntrestAmountWithTimer() {
		System.out.println("TestBankLoanService.testcalSimpleIntrestAmountWithTimer()");
		BankLoanService service=new BankLoanService();
		assertTimeout(Duration.ofMillis(20000),()->{
			service.calSimpleIntrestAmount(10000000, 2, 12);
		});
	}
	@Test
	//@Order(0)
	public void testcalSimpleIntrestAmountForNoException() {
		System.out.println("TestBankLoanService.testcalSimpleIntrestAmountForNoException()");
	 assertDoesNotThrow(()->{
		 service.calSimpleIntrestAmount(1000000, 2, 12);
	 });
    }

	/*
	  @AfterEach public void clear() {
	  System.out.println("TestBankLoanService.clear()"); service=null; }
	 
	*/
	@AfterAll
	public static void clearOnce() {
		System.out.println("TestBankLoanService.clearOnce()");
		service=null;
	}
}