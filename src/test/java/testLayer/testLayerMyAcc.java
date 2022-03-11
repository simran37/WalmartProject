package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClassPackage.BaseClass;
import pomLayerPackage.PomClass;
import pomLayerPackage.PomMyAccount;

public class testLayerMyAcc extends BaseClass{

	PomMyAccount pom;
	
	
	public testLayerMyAcc()
	{
		super();
	}
	@BeforeMethod
	public void setUp() 
	{
		initiation("MainURL");
		pom=new PomMyAccount();
		pom.signIn(credentials()[0],credentials()[1]);
	}
	@Test
	public void check()
	{
		Assert.assertEquals(pom.proSettings(), "1");
	}
	@AfterMethod
	public void close()
	{
		driver.quit();
	}
	
	
}
