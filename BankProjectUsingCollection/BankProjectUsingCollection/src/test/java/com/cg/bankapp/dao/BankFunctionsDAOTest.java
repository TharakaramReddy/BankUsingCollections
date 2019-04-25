package com.cg.bankapp.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import com.cg.bankapp.model.CustomerDetails;
import com.cg.bankapp.model.TransactionDetails;

class BankDAOTest {

	 static BankDAO dao;
	 
	 	@BeforeAll
	 	public static void init() {
	 		dao=new BankDAOImpl();
	 	}
	
	 	@Test
		public void testLogin() {
			CustomerDetails customerDetails=dao.login(71234788, "pass");
			assertEquals(-1, customerDetails.getAccountNo());
		}
	@Test
	void testRegistration() {
		CustomerDetails customerDetails=new CustomerDetails();
		customerDetails.setFirstname("tharak");
		customerDetails.setLastname("reddy");
		customerDetails.setAadharCardNo("123412391235");
		customerDetails.setAddress("hyd");
		customerDetails.setBalance(399);
		customerDetails.setEmail("ram@gmil.com");
		customerDetails.setMobileNo("7512345678");
		customerDetails.setPanNo("1234567890");
		customerDetails.setPassword("tharak438");
	
		assertEquals(123456790,dao.registration(customerDetails));
	}
//	@Test
//	public void testLogin() {
//		CustomerDetails customerDetails=dao.login(123456790, "tharak438");
//		assertEquals(123456790, customerDetails.getAccountNo());
//	}
	@Test
	void testValidation() {
		assertEquals(true, dao.validation("12356788"));
	}
	
//	@Test
//	void testWithdraw() {
//		assertEquals(-1, dao.withdraw(123456788,-5 ));
//	}

	@Test
	void testDeposit() {
		assertEquals(499, dao.deposit(123456790, 100));
	}

		@Test
	void testFundTransfer() {
		TransactionDetails details=new TransactionDetails();
		details.setFromAccountNo(123456789);
		details.setToAccountNo(123456787);
		details.setamountTransfered(-1000);
		assertEquals(-1,dao.amountTransfer(details));
	}

}
