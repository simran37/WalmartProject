package pomLayerPackage;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClassPackage.BaseClass;

public class ShoppingCart extends BaseClass{
	JavascriptExecutor js= (JavascriptExecutor)driver;
	@FindBy(xpath="//div[@class='css-1kkxwdu elsmchb9']")WebElement AddSuccess;
	@FindBy(xpath="//div[@class='css-nk32ej e1nkqonp3']//a[@class='ekai0sg0 css-7nhke1 elkyjhv0']")WebElement cart;
	@FindBy(xpath="//button[@class='e5qqw234 css-1gezpl6 edzik9p0']")WebElement Qty;
	@FindBy(xpath="//button[@class='css-vfxkzw edzik9p0']")WebElement checkOut;
	public ShoppingCart()
	{
		PageFactory.initElements(driver, this);
	}
	//---------------------------------------------------------------------------
	public void addTocartBut() throws InterruptedException
	{
		
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//div[@data-product-id='6000195505547']/descendant::div[@class='css-18ejvus e175iya612']")).click();
	Thread.sleep(3000);
		driver.switchTo().alert();
	if(AddSuccess.isDisplayed())
	{
		System.out.println("Product added");
	}
	
	}
	//==============================================================================
	public void cartFunc() throws InterruptedException
	{   
	js.executeScript("window.scrollBy(0,500)");
	driver.findElement(By.xpath("//div[@data-product-id='6000195505547']/descendant::div[@class='css-18ejvus e175iya612']")).click();
WebDriverWait wait= new WebDriverWait(driver, 30);
wait.until(ExpectedConditions.visibilityOf(AddSuccess));
		 String str= driver.findElement(By.xpath("//div[@class='css-22gbgz elsmchb13']")).getText();
		if(str.split(" ")[1]!=null)
		{
			System.out.println("Price of one item is: "+str.split(" ")[1]);
		}
	}
	//=================================================================================
	public void addMore()
	{
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//div[@data-product-id='6000195505547']/descendant::div[@class='css-18ejvus e175iya612']")).click();
	WebDriverWait wait= new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(AddSuccess));
	Qty.click();
			 String str= driver.findElement(By.xpath("//div[@class='css-22gbgz elsmchb13']")).getText();
			if(str.split(" ")[1]!=null)
			{
				System.out.println("Price of two items is: "+str.split(" ")[1]);
			}
	}
	//===================================================================================
	public void cartMemory() throws IOException, InterruptedException
	{
		js.executeScript("window.scrollBy(0,500)");
		driver.findElement(By.xpath("//div[@data-product-id='6000195505547']/descendant::div[@class='css-18ejvus e175iya612']")).click();
	WebDriverWait wait= new WebDriverWait(driver, 30);
	wait.until(ExpectedConditions.visibilityOf(AddSuccess));
	Qty.click();
	checkOut.click();
	Thread.sleep(3000);
	File file=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
	FileUtils.copyFile(file,new File("/Users/jaura/Downloads/screenshot.jpg"));
	}
}
