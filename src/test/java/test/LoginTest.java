package test;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import page.LoginPage;
import page.ProductPage;
import util.BaseClass;

public class LoginTest {
	
	static WebDriver driver;
	LoginPage loginpage;
	ProductPage productpage;
	
	String UserName="standard_user";
	String UserName1="locked_out_user";
	String UserName2="problem_user";
	String UserName3="performance_glitch_user";
	String UserName4="error_user";
	String UserName5="visual_user";
	String Password="secret_sauce";
	String WrongUserName="standard_user123";
	String WrongPassword="secret_sauce123";
	String usernameerrormsg="Epic sadface: Username is required";
	String passworderrormsg="Epic sadface: Password is required";
	String usernamorpasswordwrongmsg="Epic sadface: Username and password do not match any user in this service";
	String ProductPageHeader="Products";
	
	
	@BeforeMethod(alwaysRun = true)
	public void BeforeRun() {
		driver=BaseClass.init();
		
		loginpage=PageFactory.initElements(driver, LoginPage.class);
		productpage=PageFactory.initElements(driver, ProductPage.class);
	}
	
	
	
	@Test(priority=1, groups={"smoke"})
	public void validatUserNameEmptyMSG() {
		
		loginpage.pressLoginBotton();
		loginpage.validateUsernameErrorMSG(usernameerrormsg);
	}
	
	
	@Test(priority=2, groups={"smoke"})
	public void validatPasswordEmptyMSG() {
		
		loginpage.insertUserName(UserName);
		loginpage.pressLoginBotton();
		loginpage.validatePasswordeErrorMSG(passworderrormsg);
	}
	
	
	@Test(priority=3)
	public void validatWrongusernametoLogin() {
		
		loginpage.insertUserName(WrongUserName);
		loginpage.insertPassword(Password);
		loginpage.pressLoginBotton();
		loginpage.validateusernmeorPasswordwrongMSG(usernamorpasswordwrongmsg);
	
	}
	
	
	@Test(priority=4)
	public void validatWrongpasswordtoLogin() {
		
		loginpage.insertUserName(UserName);
		loginpage.insertPassword(WrongPassword);
		loginpage.pressLoginBotton();
		loginpage.validateusernmeorPasswordwrongMSG(usernamorpasswordwrongmsg);
	}
	
	
	@Test(priority=5, groups={"regression1"})
	public void validatusershouldtoLogin() {
		
		loginpage.insertUserName(UserName);
		loginpage.insertPassword(Password);
		loginpage.pressLoginBotton();
		productpage.validatelandonProductPage(ProductPageHeader);
	
	}
	
	
	
	@DataProvider(name="loginDataDifRole")
	public String [][] loginData() {
		String [][] data= new String[][]{
			{UserName,Password},
			{UserName1,Password},
			{UserName2,Password},
			{UserName3,Password},
			{UserName4,Password},
			{UserName5,Password}
		};
		return data;
		
	}
	
	
	@Test(dataProvider="loginDataDifRole",priority=6,groups={"smoke"})
	public void LoginUsingDifRole(String username, String Password) {
		
		loginpage.insertUserName(username);
		loginpage.insertPassword(Password);
	}
	
	@AfterMethod(alwaysRun = true)
	public void AfterRun() {
		
		BaseClass.TearDown();
	}

}
