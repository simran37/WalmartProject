package pomLayerPackage;

import java.io.File;
import java.io.IOException;
import java.util.regex.Pattern;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import baseClassPackage.BaseClass;

public class PomClass extends BaseClass{
 
	@FindBy(css="#create-account-form > div > div:nth-child(6) > div.css-1alnb86.erl5ymg0 > button") WebElement ShowButton;
	@FindBy(id="firstName")WebElement firstname;
	@FindBy(id="lastName")WebElement lastname;
	@FindBy(id="phoneNumber")WebElement phone;
	@FindBy(id="email")WebElement emailid;
	@FindBy(id="password")WebElement password;
	@FindBy(xpath="//*[@id=\"create-account-form\"]/div/div[8]/div[1]/div/label")WebElement checkboxTandC;
	@FindBy(id="marketingPreference")WebElement checkboxOpt;
	@FindBy(css="#create-account-form > div > div.css-jd7gpz.e17nj3uo3 > button") WebElement createACbutton;
	
	public PomClass()
	{
		PageFactory.initElements(driver, this);
	}
	public String verifyHeading()
	{   
		String c = driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[1]")).getText();
		return c;
	}
	public String firstField(String name)
	{ String message="First Name value is valid";
	String Err1="error message is correct";
	String Err2="Incorrect error message";
		firstname.sendKeys(name);
		 
		 if(name.length()<2)
	{ 
			 lastname.click();
	
			 message =driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[2]/div")).getText();
			 System.out.println("Error message is: "+message);
			 if(name.isEmpty())
			 { 
				 if(message.contains("Please enter your first name."))
				 {System.out.println(Err1);
				  message=Err1;}
				 else
					 {System.out.println(Err2); 
					 message=Err2;
					 }
			 }
			 else if(name.length()>0 && message.equals("Please enter a valid first name."))
			 {System.out.println(Err1);
			 message=Err1;}
			 else
				 {System.out.println(Err2);
				 message=Err2;
				 }
			 }
	
		 return message;
	}

	public String lastnameField(String name)
	{ String message="Last Name value is valid";
	String Err1="error message is correct";
	String Err2="Incorrect error message";
		lastname.sendKeys(name);
		 
		 if(name.length()<2)
	{ 
			 phone.click();
	
			 message =driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[3]/div")).getText();
			 System.out.println("Error message is: "+message);
			 if(name.isEmpty())
			 { 
				 if(message.contains("Please enter your last name."))
				 {System.out.println(Err1);
				  message=Err1;}
				 else
					 {System.out.println(Err2); 
					 message=Err2;
					 }
			 }
			 else if(name.length()>0 && message.equals("Please enter a valid last name."))
			 {System.out.println(Err1);
			 message=Err1;}
			 else
				 {System.out.println(Err2);
				 message=Err2;
				 }
			 }
	
		 return message;
	}

public String verifyPhone(String number)
{   String flag="1";
	phone.sendKeys(number);
    emailid.click();
    
    String message= driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[4]/div[2]")).getText();
	
    if(!(message.isBlank() && ((number.length())==10 || number.length()==0)))
	{   
		System.out.println("Error message is: "+message);
		flag="0";
		return message;
	}
	else
	{
		System.out.println("Phone number is accepted");
	}
	
	return flag;
}

public String verifyEmail(String string)
{ String flag="1";
String emailRegx= "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";
 Pattern pattern= Pattern.compile(emailRegx);
	emailid.sendKeys(string);
	password.click();
	String message= driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[5]/div[2]")).getText();

if(pattern.matcher(string).matches() && message.isEmpty())
{
	System.out.println("Valid email address");
	return flag="0";
	
}
else if(!message.isEmpty())
{	System.out.println("Error message displayed is: "+message);
return flag="0";
}
else
	return flag;
}

public String verifyPwd(String pwd)
{ 
	String flag="0";
	//String [] pat= {"(?=.*[A-Z])","(?=.*[a-z])","(?=.*[0-9])","(?=.*[#@$%^&-])"};
	
	String pwdregx="(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9])(?=.*[#@$%^&-]).{6,}";
	String pwd1="(?=.*[A-Z])(?=.*[a-z]).{6,}|(?=.*[0-9])(?=.*[#@$%^&-]).{6,}|(?=.*[A-Z])(?=.*[#@$%^&-]).{6,}|(?=.*[a-z])(?=.*[#@$%^&-]).{6,}|(?=.*[a-z])(?=.*[0-9]).{6,}|(?=.*[A-Z])(?=.*[0-9]).{6,}";
	String pwd2="(?=.*[A-Z]).{6,}|(?=.*[a-z]).{6,}|(?=.*[0-9]).{6,}|(?=.*[#@$%^&-]).{6,}";
	Pattern pattern= Pattern.compile(pwdregx);
	Pattern pattern2= Pattern.compile(pwd1);
	Pattern pattern3= Pattern.compile(pwd2);
password.sendKeys(pwd);
emailid.click();
WebElement strength= driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[6]/div[3]/div[2]"));
if(pwd.length()>=6)
{
	
	
	if(pattern.matcher(pwd).matches())
	{
		System.out.println("Strength of "+pwd +" is: "+strength.getText());
		if(strength.getText().equals("Password Strength: strong"))
		{
			return flag="1";
		}
	}
	else if(pattern2.matcher(pwd).matches())
	{
		System.out.println("Strength of "+pwd +" is: "+strength.getText());
		if(strength.getText().equals("Password Strength: moderate"))
		{
			return flag="1";
		}
}
	else if(pattern3.matcher(pwd).matches())
	{
		System.out.println("Strength of "+pwd +" is: "+strength.getText());
		if(strength.getText().equals("Password Strength: weak"))
		{
			return flag="1";
		}
	}
	
}
else
	System.out.println("Invalid password");
return flag;
}
public String verifyPwdLen(String pwd)
{  String flag="0";
	password.sendKeys(pwd);
emailid.click();
	WebElement message= driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[6]/div[2]"));

	if(pwd.length()>=6 && message.getText().length()==0)
	{
		System.out.println("Password is valid");
		
		return flag="1";
			
		
	}
	else
	{
		
		System.out.println("Error message displayed: "+message.isDisplayed()+" Message is: "+message.getText());

        if(message.isDisplayed())
		{return flag="1";}
			
	}

return flag;


}

public String pwdEncrypt(String pwd) throws InterruptedException
{
	password.sendKeys(pwd);
	
	File file1= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	try {
		FileUtils.copyFile(file1,new File("/Users/jaura/Downloads/screenshot1.jpg"));
	} catch (IOException e) {
		e.printStackTrace();
	}
ShowButton.click();
Thread.sleep(2000);
File file2= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
try {
	FileUtils.copyFile(file2,new File("/Users/jaura/Downloads/screenshot2.jpg"));
} catch (IOException e) {
	e.printStackTrace();
}
	return "1";
	
}
public String tandc()
{ String flag="0";
	checkboxTandC.click();
	checkboxTandC.click();
	String c=driver.findElement(By.xpath("//*[@id=\"create-account-form\"]/div/div[8]/div[1]/div[2]")).getText();
	String d="You must read and accept Walmart’s Terms of Use to subscribe.";
if (c.equals(d))
{
	return flag="1";
	
}
else
	return flag;
}


public String checkboxMarketing()
{ String flag="0";
	String c=driver.findElement(By.xpath("//*[@id='create-account-form']/div/div[8]/div[2]")).getText();
if(c.contains("Optional:"))
{  System.out.println("Field is Optional");
	return flag="1";
}
else 
	return flag;

}

public String verifymyAcUrl(String fname, String lname,String  email,String pwd) throws InterruptedException
{
	firstname.sendKeys(fname);
	lastname.sendKeys(lname);
	emailid.sendKeys(email);
	password.sendKeys(pwd);
	
	JavascriptExecutor js= (JavascriptExecutor)driver;
	js.executeScript("arguments[0].scrollIntoView();", createACbutton);
	Thread.sleep(2000);
	checkboxTandC.click();
	
	createACbutton.click();
	Thread.sleep(10000);
	  String currenturl=driver.getCurrentUrl();
	  return currenturl;
}

}
