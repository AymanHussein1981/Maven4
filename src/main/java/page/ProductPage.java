package page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

public class ProductPage extends BasePage {

	WebDriver driver;

	public ProductPage(WebDriver driver) {
		this.driver = driver;
	}

	@FindBy(how = How.XPATH, using = "//span[@class='title'and contains(text(),'Products')]")
	WebElement validateProductPageElement;
	@FindBy(how = How.XPATH, using = "//select[@class='product_sort_container']")
	WebElement itemsSortDropDownElement;
	@FindBy(how = How.XPATH, using = "//button[@id='add-to-cart-sauce-labs-onesie']")
	WebElement AddtoCartitem1Element;
	@FindBy(how = How.XPATH, using = "//button[@id='add-to-cart-test.allthethings()-t-shirt-(red)']")
	WebElement AddtoCartitem2Element;
	@FindBy(how = How.XPATH, using = "//button[@id='add-to-cart-sauce-labs-backpack']")
	WebElement AddtoCartitem3Element;
	@FindBy(how = How.XPATH, using = "//button[@id='add-to-cart-sauce-labs-fleece-jacket']")
	WebElement AddtoCartitem4Element;
	@FindBy(how = How.XPATH, using = "//a[@class='shopping_cart_link']")
	WebElement GotoShopingCartElement;
	@FindBy(how = How.XPATH, using = "//span[@class='title']")
	WebElement validateyourCartPageElement;
	@FindBy(how = How.XPATH, using = "//button[@id='react-burger-menu-btn']")
	WebElement menueElement;
	@FindBy(how = How.XPATH, using = "//a[@id='logout_sidebar_link']")
	WebElement LogOutElement;

	public void validatelandonProductPage(String expectedheaderText) {

		String actualheaderText = validateProductPageElement.getText();
		Assert.assertEquals(actualheaderText, expectedheaderText, "Page not Found");

	}

	public void sortPriceDropDown(String visibleText) {

		selectFromDropDown(itemsSortDropDownElement, visibleText);
	}

	public void AddItem1toCart() {

		AddtoCartitem1Element.click();
	}

	public void AddItem2toCart() {

		AddtoCartitem2Element.click();
	}

	public void AddItem3toCart() {

		AddtoCartitem3Element.click();
	}
	
	public void AddItem4toCart() {

		AddtoCartitem4Element.click();
	}

	public void PressCartButton() {

		GotoShopingCartElement.click();
	}

	public void gotomenue() {

		menueElement.click();

	}

	public void Logout() {

		LogOutElement.click();

	}

}
