package com.inetBanking.testCases;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.inetBanking.pageObjects.AddCustomerPage;
import com.inetBanking.pageObjects.LoginPage;

public class TC_AddCustomerTest_003 extends BaseClass
{

	@Test
	public void addNewCustomer() throws InterruptedException, IOException
	{
		LoginPage lp=new LoginPage(driver);
		lp.setUsername(username);
		logger.info("User name is provided");
		lp.setPassword(password);
		logger.info("Passsword is provided");
		lp.ClickSubmit();

		Thread.sleep(3000);

		AddCustomerPage addcust=new AddCustomerPage(driver);

		addcust.clickAddNewCustomer();
		logger.info("clicked on new customer");

		logger.info("providing customer details....");


		addcust.custName("Jyesh");
		Thread.sleep(5000);
		addcust.custgender("male");
		addcust.custdob("11","17","1992");
		Thread.sleep(5000);
		addcust.custaddress("INDIA");
		addcust.custcity("Valsad");
		addcust.custstate("GJ");
		Thread.sleep(5000);
		addcust.custpinno("424190");
		addcust.custtelephoneno("7774950949");

		String email=randomestring()+"@gmail.com";
		addcust.custemailid(email);
		addcust.custpassword("khush");
		addcust.custsubmit();

		Thread.sleep(3000);

		logger.info("validation started....");

		boolean res=driver.getPageSource().contains("Customer Registered Successfully!!!");

		if(res==true)
		{
			Assert.assertTrue(true);
			logger.info("test case passed....");

		}
		else
		{
			logger.info("test case failed....");
			captureScreen(driver,"addNewCustomer");
			Assert.assertTrue(false);
		}

	}


}