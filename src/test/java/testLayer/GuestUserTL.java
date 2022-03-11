package testLayer;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import baseClassPackage.BaseClass;
import pomLayerPackage.pomGuest;

public class GuestUserTL extends BaseClass{

pomGuest pom;
public GuestUserTL()
{
	super();

}

@BeforeMethod
public void setup()
{
	initiation("BagsSearchPage");
	pom= new pomGuest();
	
}
@DataProvider
public Object[][] list()
{
	String [][] option= {{"Patio"},{"BBQs"},{"Electronics"},{"Clothing"}};
	return option;
}
@Test(dataProvider="list")
public void guestAccess(String options) throws InterruptedException
{
	pom.verifyGuestaccess(options);
	
}
@DataProvider
public Object[][] slist()
{
	String [][] option= {{"Fur"},{"Oranges"},{"car cleaning products"},{"30457838"},{"30457"},{"Furniture"}};
	return option;
}
@Test(dataProvider="slist")
public void searchOptions(String args) throws InterruptedException
{
	String res=pom.verifySearchFunc(args);
	Assert.assertEquals(res, "1");
}
@Test
public void Pagination() throws InterruptedException
{
	pom.verifyPagination();
}
@Test
public void filteration() throws InterruptedException
{  //1 for Sold and Shipped by
	//2 for Category
	//3 for Brand
	pom.filter(2);
}
@Test
public void sort() throws InterruptedException
{
	pom.sorting();
}
@Test
public void filterWithSort() throws InterruptedException
{
	pom.FilnSort();
}
@Test
public void filSortPag() throws InterruptedException
{
	pom.fsp();
}
@AfterMethod
public void closebrowser()
{
	driver.quit();
}
}