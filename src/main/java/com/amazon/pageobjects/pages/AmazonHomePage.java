package com.amazon.pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import com.amazon.pageobjects.selection.AmazoniPhone6SearchResults;

/**
 * 
 * @author Raaghav A S, Automation Tester Cognizant Technology Solutions
 *         Assoicate ID : 286440
 */
public class AmazonHomePage extends AbstractPage {

	private WebDriver driver;

	public static final String URL = "https://www.amazon.co.uk/";

	// Use annotations to locate elements.
	@FindBy(id = "twotabsearchtextbox")
	private WebElement twotabsearchtextbox;

	@FindBy(css = "input.nav-submit-input")
	private WebElement searchButton;

	/**
	 * Sole Constructor
	 *
	 * @param driver
	 *            the web driver
	 */
	public AmazonHomePage(WebDriver driver) {
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

	/**
	 * Service: Perform search.
	 *
	 * @param text
	 *            the search term.
	 * @return the search result page object.
	 */
	public AmazoniPhone6SearchResults searchFor(String text) {
		twotabsearchtextbox.sendKeys(text);
		twotabsearchtextbox.submit();
		searchButton.click();
		return new AmazoniPhone6SearchResults(driver);
	}

}