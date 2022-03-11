package testLayer;



import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClassPackage.BaseClass;
import pomLayerPackage.PomClass;


public class CreateAccount extends BaseClass {
	

		PomClass pom;
		public CreateAccount()
		{
			super();
		}
		@BeforeMethod
		public void initialsetup()
		{
			initiation("CreateAccountURL");
			pom=new PomClass();
		}
		
		@Test
		public void verifyURL()
		{
			
			Assert.assertEquals(pom.verifyHeading(), "Create an account");
		System.out.println("URL is correct");
		}
		
		@DataProvider
		public Object[][] validname()
		{
			String [][] result= {{"simran"},{"si"}};
			return result;
		}
		@Test(dataProvider="validname")
		public void Validfirstname(String firstname)
		{
			String message=pom.firstField(firstname);
            System.out.println(message);
			Assert.assertEquals(message, "First Name value is valid");
			
		}
		@DataProvider
		public Object[][] invalidname()
		{
			String [][] result= {{"s"},{""}};
			return result;
		}
		@Test(dataProvider="invalidname")
		public void InvalidFirstName(String firstname)
		{
			String message=pom.firstField(firstname);

			Assert.assertEquals(message, "error message is correct");
		}
		
		@Test(dataProvider="validname")
		public void Validlastname(String lastname)
		{
			String message=pom.lastnameField(lastname);
            System.out.println(message);
			Assert.assertEquals(message, "Last Name value is valid");
			
		}
		@Test(dataProvider="invalidname")
		public void InvalidlastName(String lastname)
		{
			String message=pom.lastnameField(lastname);

			Assert.assertEquals(message, "error message is correct");
		}
		@DataProvider
		public Object[][] phoneNumlist()
		{
			String [][]list= {{"1234567123"},{"1234"},{"4567892345176"},{""}};
			return list;
		}
		
		@Test(dataProvider="phoneNumlist")
		public void phoneNum(String number)
		{
			String res=pom.verifyPhone(number);
			if(res.equals("0"))
			{
				Assert.assertEquals(res, "Please enter a valid phone number.");
			}
			
		}
		@DataProvider
		public Object[][] emailList()
		{
			String[][]list= {{"simranjaura7@gmail.com"},{"simran7"},{"sim@gmail"},{"sim.com"},{"567@g.cn"}};
		return list;
		}
		@Test(dataProvider="emailList")
		public void emailID(String email)
		{
			String res=pom.verifyEmail(email);
			if(res.equals("0"))
			{
				Assert.assertEquals(res,"0");
			}
		}
		@DataProvider
		public Object[][] pwdlist()
		{
			String[][] list= {{"BasKet23@"},{"789#$@@"},{"$@@@@#"}};
		return list;
		}
		@Test(dataProvider="pwdlist")
		public void password(String pwd)
		{
			String res=pom.verifyPwd(pwd);
			Assert.assertEquals(res, "1");
		}
		@Test(dataProvider="pwdlist")
		public void pwdLen(String pwd)
		{
			String res=pom.verifyPwdLen(pwd);
			Assert.assertEquals(res, "1");;
		}
		@Test
		public void pwdShow() throws InterruptedException
		{
			Assert.assertEquals(pom.pwdEncrypt("basJ@34"), "1");
		}
		@Test
		public void verifytandc()
		{
			Assert.assertEquals(pom.tandc(), "1");
		}
		@Test
		public void checkboxEmails()
		{
			Assert.assertEquals(pom.checkboxMarketing(), "1");
		}
		@Test
		public void CreateAc() throws InterruptedException
		{  
			String res=pom.verifymyAcUrl("simran", "jaura", "jauradeep3@gmail.com", "Basket@12");
			
			Assert.assertEquals(res,"https://www.walmart.ca/my-account");
		}
		
		@AfterMethod
		public void quit()
		{
			driver.quit();
		}
		
		
	}


