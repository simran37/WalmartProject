package testLayer;

import java.io.IOException;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import baseClassPackage.BaseClass;
import pomLayerPackage.ShoppingCart;
import pomLayerPackage.pomGuest;

public class CartTL extends BaseClass{
ShoppingCart pom;
public CartTL()
{
	super();
	
}
@BeforeMethod
public void setup()
{
	initiation("BagsSearchPage");
	pom= new ShoppingCart();
	
}
@Test
public void addToCartButton() throws InterruptedException
{
	pom.addTocartBut();
}
@Test
public void cartFunctionality() throws InterruptedException
{
	pom.cartFunc();
}
@Test
public void addAnitem()
{
	pom.addMore();
}
@Test
public void refreshCart() throws IOException, InterruptedException
{
	pom.cartMemory();
}
@AfterMethod
public void close()
{
	driver.quit();
}
}
