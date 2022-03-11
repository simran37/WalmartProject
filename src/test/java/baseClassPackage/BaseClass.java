package baseClassPackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.AttributedString;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class BaseClass {

	public static WebDriver driver;
	public static Properties prop = new Properties();
	
	public BaseClass()
	{
	try {
	FileInputStream file= new FileInputStream("/Users/jaura/eclipse-workspace/walmartFinalProject/src/test/java/environmentVariables/config.properties");
	prop.load(file);
	
	}
	catch(FileNotFoundException e)
	{
		e.printStackTrace();
	}
	catch(IOException a)
	{
		a.printStackTrace();
	}
	}
	public static void initiation(String webpage)
	{
		
		System.setProperty("webdriver.gecko.driver", "/Users/jaura/Downloads/geckodriver");
		driver= new FirefoxDriver();
	
	driver.manage().window().maximize();
	driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
	driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
	//if(webpage.equals("CreateAccountURL"))
	driver.get(prop.getProperty(webpage));
	//else if(webpage.equals("MainURL"))
	
}
	public static String []credentials()
	{
		 String [] signIn= {prop.getProperty("Email"),prop.getProperty("Password")};
	return signIn;
	}
	public static void screenshot(String res)
	{
		File file= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	
	try {
		FileUtils.copyFile(file, new File("/Users/jaura/Downloads/"+res+".jpg"));
	} catch (IOException e) {
		
		e.printStackTrace();
	}
	
	}
}