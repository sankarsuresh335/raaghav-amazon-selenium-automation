package com.amazon.pageobjects;

import org.openqa.selenium.WebDriver;

/*
 *  Page object pattern
 * 
 * @author Raaghav A S, Automation Tester
 * Cognizant Technology Solutions 
 * Assoicate ID : 286440
 */
public abstract class Page {

	protected WebDriver webDriver;

	/*
	 * Constructor injecting the WebDriver interface
	 * 
	 * @param webDriver
	 */
	public Page(WebDriver webDriver) {
		this.webDriver = webDriver;
	}

	public WebDriver getWebDriver() {
		return webDriver;
	}

	public String getTitle() {
		return webDriver.getTitle();
	}

}
