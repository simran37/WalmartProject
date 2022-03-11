package pomLayerPackage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClassPackage.BaseClass;

public class PomMyAccount extends BaseClass{

	@FindBy(id="username") WebElement username;
	@FindBy(id="password")WebElement password;
	@FindBy(xpath="//*[@id=\"login-form\"]/div/div[7]/button")WebElement SignInButton;
	@FindBy(xpath="//*[@id=\"accounts-home-page\"]/div[3]/div[1]/div[4]/a[1]")WebElement ProfileSettings;
	public PomMyAccount()
	{
		PageFactory.initElements(driver, this);
	}
	
	public void signIn(String email, String pwd) 
	{
		username.sendKeys(email);
		password.sendKeys(pwd);
		SignInButton.click();
		WebDriverWait wait=new WebDriverWait(driver, 30);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("accounts-home-page")));
	}
	public String proSettings()
	{ String flag="0";
		if(ProfileSettings.isDisplayed())
		{
			return "1";
		}
		return flag;
	}
}
