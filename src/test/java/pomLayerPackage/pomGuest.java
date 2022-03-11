package pomLayerPackage;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import baseClassPackage.BaseClass;

public class pomGuest extends BaseClass{

	String i="0";
	@FindBy(id="search-form-input")WebElement search;
	@FindBy(xpath="//*[@type='submit'][@class='css-1v9c0kj e1xoeh2i2']")WebElement searchButton;
	@FindBy(id="product-results") WebElement results;
	@FindBy(xpath="//a[@class='css-d3kgcc ed60zyg9']")WebElement pageNo;
	@FindBy(xpath="//a[contains(text(),'Next')]")WebElement Next;
	@FindBy(xpath="//div[contains(text(),'Online Savings')]")WebElement filterButton;
	@FindBy(xpath="//*[@class='css-148r75k e8eb2yh12']")WebElement shipFilter;
	@FindBy(xpath="/html/body/div[1]/div[1]/div[3]/div/div/div/div/div[7]/div[2]/div[1]/div/div/div[2]/div/div/div/div[1]/button/div")WebElement Category;
	@FindBy(xpath="//*[contains(text(),'Brand')][@class='css-1c6ntpr e14ixz031']")WebElement Brand;
	@FindBy(xpath="//span[@data-automation='category-item-name-10003']")WebElement Electronics;
	@FindBy(xpath="//span[contains(text(),'IYEFENG')]")WebElement Wean;
	@FindBy(xpath="//div[contains(text(),'Best Match')]")WebElement Sort;
	public pomGuest()
	{
		PageFactory.initElements(driver, this);
	}
	//--------------------------------------------------------------------------------------------
	public void verifyGuestaccess(String args) throws InterruptedException
	{   
		driver.findElement(By.xpath("//*[contains(text(),'"+args+"')]")).click();
		
	}
	//-----------------------------------------------------------------------------------------
	public String verifySearchFunc(String args) throws InterruptedException
	{String flag="1";
		search.sendKeys(args);
		Thread.sleep(2000);
		screenshot(args);
		searchButton.click();
		Thread.sleep(3000);
		screenshot(i+1);
		System.out.println(results.getText());
		if(results.getText().equals(null))
		{
			return flag="0";
		}
		return flag;
	}
	//------------------------------------------------------------------------------------------
	public void verifyPagination() throws InterruptedException
	{  Integer i=1;
	JavascriptExecutor js= (JavascriptExecutor)driver;
	
			List<WebElement> items= new ArrayList<WebElement>();
			//Long initialHeight= (Long)(js.executeScript("return document.body.scrollHeight"));
		//while(true)
	//	{
			js.executeScript("window.scrollTo(0,document.body.height)");
		//	Thread.sleep(2000);
			//Long currentHeight= (Long)(js.executeScript("return document.body.scrollHeight"));
			items=driver.findElements(By.xpath("//*[@class='css-1q7g4lp epettpn2']"));
			//if(initialHeight==currentHeight)
			//{
			//	break;
		//	}
		//	initialHeight=currentHeight;
		//}
		
		//System.out.println("Number of pages: "+i);
		Set <String> names=new HashSet<String>();
		
	
	for(WebElement a: items)
	{  if(names.add(a.getText())==false)
	{
		System.out.println("Found duplicate item: "+a.getText());
	}
	else
		{names.add(a.getText());}
		
	}
	if(names.size()==0)
	{
		System.out.println("No duplicate items");
	
	}
	}
	
//----------------------------------------------------------------------------	
	public void filter(Integer args) throws InterruptedException
	{
		JavascriptExecutor js= (JavascriptExecutor)driver;
		filterButton.click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[text()='Clearance']")).click();
		//driver.navigate().to("https://www.walmart.ca/search?q=bags");
		//Thread.sleep(2000);
		switch(args)
		{
			case 1:shipFilter.click();
			break;
			case 2: 
			Electronics.click();
			break;
			case 3: js.executeScript("arguments[0].scrollIntoView();", Brand);
				Brand.click();
			Wean.click();
			break;
		}
		
		
	}
	
	//---------------------------------------------------------------------------------
	public void sorting() throws InterruptedException
	{
		
		Sort.click();
		Thread.sleep(2000);
		//driver.findElement(By.xpath("//*[@id=\"browse-search-page\"]/div/div/div/div/div[7]/div[1]/div/div[2]/div[2]/button/div[2]/div/div[2]/div[3]")).click();
	driver.findElement(By.xpath("//div[@data-automation='sort-option-Newest:DESC']")).click();
	
	}
	
	//-----------------------------------------------------------------------------
	public void FilnSort() throws InterruptedException
	{
		
		Sort.click();
		//driver.findElement(By.xpath("//*[@id=\"browse-search-page\"]/div/div/div/div/div[7]/div[1]/div/div[2]/div[2]/button/div[2]/div/div[2]/div[3]")).click();
		
		Electronics.click();
	
	
	}
	//--------------------------------------------------------------------------------------
	public void fsp() throws InterruptedException
	{
		
		Sort.click();
		driver.findElement(By.xpath("//*[@id=\"browse-search-page\"]/div/div/div/div/div[7]/div[1]/div/div[2]/div[2]/button/div[2]/div/div[2]/div[3]")).click();
		
		Electronics.click();
		Integer i=1;
		JavascriptExecutor js= (JavascriptExecutor)driver;
		List<WebElement> items= new ArrayList<WebElement>();
		
			while(true)
			{ js.executeScript("arguments[0].scrollIntoView();", driver.findElement(By.xpath("//*[@class='css-1o0a1vl ed60zyg0']")));
			 items=driver.findElements(By.xpath("//*[@class='css-1q7g4lp epettpn2']"));
			if(Next.isEnabled())
				{Next.click();
				i=i+1;}
				else
					break;
			}
			System.out.println("Number of pages: "+i);
			Set <String> names=new HashSet<String>();
			
		
		for(WebElement a: items)
		{  if(names.add(a.getText())==false)
		{
			System.out.println("Found duplicate item: "+a.getText());
		}
		else
			{names.add(a.getText());}
			
		}
		if(names.size()==0)
		{
			System.out.println("No duplicate items");
		
		}
	}
}
