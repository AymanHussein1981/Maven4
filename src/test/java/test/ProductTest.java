package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.CartPage;
import page.LoginPage;
import page.ProductPage;
import util.BaseClass;

public class ProductTest {
	
	
	static WebDriver driver;
	LoginPage loginpage;
	ProductPage productpage;
	CartPage cartpage;
	
	
	String UserName="standard_user";
	String Password="secret_sauce";
	String ProductPageHeader="Products";
	String CartPageHeader="Your Cart";
	String FilterDropDown="Price (low to high)";
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void BeforeRun() {
		driver=BaseClass.init();
		
		loginpage=PageFactory.initElements(driver, LoginPage.class);
		productpage=PageFactory.initElements(driver, ProductPage.class);
		cartpage=PageFactory.initElements(driver, CartPage.class);
	}
	
	
	
	@Test(priority=1)
	public void CustomerShouldAddItemstoCart() throws InterruptedException {
		
		loginpage.insertUserName(UserName);
		loginpage.insertPassword(Password);
		loginpage.pressLoginBotton();
		productpage.validatelandonProductPage(ProductPageHeader);
		productpage.sortPriceDropDown(FilterDropDown);
		productpage.AddItem1toCart();
		productpage.AddItem2toCart();
		productpage.AddItem3toCart();
		productpage.PressCartButton();
		cartpage.validatelandonCartPage(CartPageHeader);
		
	}
	
	
	@Test(priority=2)
	public void CustomerShouldLoginThenLogOut()  {
		
		loginpage.insertUserName(UserName);
		loginpage.insertPassword(Password);
		loginpage.pressLoginBotton();
		productpage.validatelandonProductPage(ProductPageHeader);
		productpage.gotomenue();
		productpage.Logout();
		
		
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void AfterRun() {
		
		BaseClass.TearDown();
	}

}
