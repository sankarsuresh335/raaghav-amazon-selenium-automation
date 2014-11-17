package com.amazon.pageobjects.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

/**
 * Defines an abstract Page.
 * 
 * @author Raaghav A S, Automation Tester Cognizant Technology Solutions
 *         Assoicate ID : 286440
 */
public abstract class AbstractPage {

	/**
	 * Constructor for a Page object that represents an entire page. We rely on
	 * the PageFactory to instantiate the instance of the PageObject.
	 * https://code.google.com/p/selenium/wiki/PageFactory
	 *
	 * @param driver
	 *            the web driver instance.
	 */
	public AbstractPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	/**
	 * Returns the page URL.
	 *
	 * @return String representation of the URL.
	 */
	public abstract String getPageURL();

}