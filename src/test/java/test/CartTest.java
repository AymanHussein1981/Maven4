package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import page.CartPage;
import page.CheckoutPage;
import page.LoginPage;
import page.ProductPage;
import util.BaseClass;

public class CartTest {
	
	
	static WebDriver driver;
	LoginPage loginpage;
	ProductPage productpage;
	CartPage cartpage;
	CheckoutPage checkoutpage;
	
	
	String UserName="standard_user";
	String Password="secret_sauce";
	String ProductPageHeader="Products";
	String CartPageHeader="Your Cart";
	String CheckoutPageHeader="Checkout: Your Information";
	String FilterDropDown="Price (low to high)";
	
	
	
	@BeforeMethod(alwaysRun = true)
	public void BeforeRun() {
		driver=BaseClass.init();
		
		loginpage=PageFactory.initElements(driver, LoginPage.class);
		productpage=PageFactory.initElements(driver, ProductPage.class);
		cartpage=PageFactory.initElements(driver, CartPage.class);
		checkoutpage=PageFactory.initElements(driver, CheckoutPage.class);
	}
	
	
	@Test
	public void CustomerShouldgotoCartPage() throws InterruptedException {
		
		loginpage.insertUserName(UserName);
		loginpage.insertPassword(Password);
		loginpage.pressLoginBotton();
		Thread.sleep(3000);
		productpage.validatelandonProductPage(ProductPageHeader);
		productpage.sortPriceDropDown(FilterDropDown);
		productpage.AddItem1toCart();
		productpage.AddItem2toCart();
		productpage.AddItem3toCart();
		productpage.PressCartButton();
		Thread.sleep(3000);
		cartpage.validatelandonCartPage(CartPageHeader);
		cartpage.removeitemfromcart();
		cartpage.pressContinueShoppingButton();
		Thread.sleep(3000);
		productpage.AddItem4toCart();
		productpage.PressCartButton();
		Thread.sleep(3000);
		cartpage.pressCheckoutButton();
		checkoutpage.validateLandonCheckoutPage(CheckoutPageHeader);
		Thread.sleep(3000);
	}
	
	
	@AfterMethod(alwaysRun = true)
	public void AfterRun() {
		
		BaseClass.TearDown();
	}

}
