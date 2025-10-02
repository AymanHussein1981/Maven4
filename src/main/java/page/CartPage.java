package page;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class CartPage {
	
	
	@FindBy (how= How.XPATH, using="//span[@class='title']")WebElement validateyourCartPageElement;
	@FindBy (how= How.XPATH, using="//button[@id='remove-sauce-labs-onesie']")WebElement removeItem1fromCartElement;
	@FindBy (how= How.XPATH, using="//button[@id='continue-shopping'] ")WebElement ContinueSoppingElement;
	@FindBy (how= How.XPATH, using="//button[@id='checkout']")WebElement CheckoutButtonElement;
	
	
	
	
	public void validatelandonCartPage(String expectedheaderText) {

		String actualheaderText = validateyourCartPageElement.getText();
		Assert.assertEquals(actualheaderText, expectedheaderText, "Page not Found");

	}
	
	public void removeitemfromcart() {
		
		removeItem1fromCartElement.click();
	}
	
	public void pressContinueShoppingButton() {
		
		ContinueSoppingElement.click();
	}
	
	public void pressCheckoutButton() {
		
		CheckoutButtonElement.click();
	}

}
