package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class LoginPage {
	
	
	WebDriver driver;
	WebDriverWait wait;
	
	public LoginPage(WebDriver driver) {
		this.driver=driver;
		this.wait = new WebDriverWait(driver, 10);
	}
	
	@FindBy (how= How.XPATH, using="//input[@id=\"user-name\"]")WebElement userNameElement;
	@FindBy (how= How.XPATH, using="//input[@id=\"password\"]")WebElement PasswordElement;
	@FindBy (how= How.XPATH, using="//input[@id=\"login-button\"]")WebElement loginBottonElement;
	@FindBy (how= How.XPATH, using="//h3[@data-test=\"error\"and contains(text(),'Epic sadface: Username is required')]")WebElement usernameemptymsgElement;
	@FindBy (how= How.XPATH, using="//h3[@data-test=\"error\"and contains(text(),'Epic sadface: Password is required')]")WebElement passwordemptymsgElement;
	@FindBy (how= How.XPATH, using="//h3[@data-test=\"error\" and contains(text(),'Epic sadface: Username and password do not match any user in this service')]")WebElement usernameorpasswordwrongElement;
	@FindBy (how= How.XPATH, using="//button[@class=\"error-button\"]")WebElement closeerrormsgElement;
	
	
	
	public void insertUserName(String username) {
		
		 wait.until(ExpectedConditions.visibilityOf(userNameElement));
		userNameElement.sendKeys(username);
	}
	
	
	
	public void insertPassword(String password) {
		
		wait.until(ExpectedConditions.visibilityOf(PasswordElement));
		PasswordElement.sendKeys(password);	
	}
	
	
	public void pressLoginBotton() {
		
		wait.until(ExpectedConditions.visibilityOf(loginBottonElement));
		loginBottonElement.click();
	}
	
	
	public void validateUsernameErrorMSG(String ExpectedMsg) {
		
		wait.until(ExpectedConditions.visibilityOf(usernameemptymsgElement));
		String ActualMSG=usernameemptymsgElement.getText();
		Assert.assertEquals(ActualMSG, ExpectedMsg, "username empty");
		closeerrormsgElement.click();
			
	}
	
	
	public void validatePasswordeErrorMSG(String ExpectedMsg) {
		
		wait.until(ExpectedConditions.visibilityOf(passwordemptymsgElement));
		String ActualMSG=passwordemptymsgElement.getText();
		Assert.assertEquals(ActualMSG, ExpectedMsg, "password empty");
		closeerrormsgElement.click();
			
	}
	
	
	public void validateusernmeorPasswordwrongMSG(String ExpectedMsg) {
		
		wait.until(ExpectedConditions.visibilityOf(usernameorpasswordwrongElement));
		String ActualMSG=usernameorpasswordwrongElement.getText();
		Assert.assertEquals(ActualMSG, ExpectedMsg, "username empty");
		closeerrormsgElement.click();
			
	}
	
	
	

}
