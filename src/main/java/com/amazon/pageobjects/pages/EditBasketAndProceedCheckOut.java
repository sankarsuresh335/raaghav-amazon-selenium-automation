package com.amazon.pageobjects.pages;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Defines a Page Object that represents the Amazon Home page
 * 
 * @author Raaghav A S, Automation Tester Cognizant Technology Solutions
 *         Assoicate ID : 286440
 */
public class EditBasketAndProceedCheckOut extends AbstractPage {

	private WebDriver driver;
	@SuppressWarnings("unused")
	private boolean acceptNextAlert = true;
	public static final String URL = "http://www.amazon.co.uk/Apple-iPhone-UNLOCKED-Silver-Space/dp/B00NK332EK/ref=sr_1_3?ie=UTF8&qid=1416170857&sr=8-3&keywords=iPhone6";

	// Use annotations to locate elements.

	// Use annotations to locate elements.
	@FindBy(id = "bb_atc_button")
	private WebElement addBasketbutton;

	/**
	 * View the Cart page
	 */
	@FindBy(id = "nav-cart")
	private WebElement viewCart;

	/**
	 * Find edit basket to edit the added item
	 */
	@FindBy(id = "a-autoid-2-announce")
	private WebElement editBasket;

	// Increase quantity value to 3
	@FindBy(id = "dropdown1_2")
	private WebElement quantity;

	@FindBy(name = "proceedToCheckout")
	private WebElement proceedToCheckout;

	/**
	 * Sole Constructor
	 * @param driver
	 * the web driver
	 **/

	public void addtoBasket() {

		addBasketbutton.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public EditBasketAndProceedCheckOut(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	/**
	 * Returns the page URL.
	 *
	 * @return String representation of the URL.
	 */
	@Override
	public String getPageURL() {
		return URL;
	}

	public void editBasket() {
		viewCart.click();
		editBasket.click();
		quantity.click();
		// quantity.click();
	}

	/**
	 * Increase the quantity value to 3
	 */
	public void editQuantityValue() {
		quantity.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}

	/**
	 * Proceed to checkout the item added to the basket
	 */
	public void proceedCheckOut() {
		proceedToCheckout.click();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	}
}