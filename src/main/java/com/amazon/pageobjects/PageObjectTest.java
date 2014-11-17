package com.amazon.pageobjects;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

import org.apache.log4j.Logger;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import com.amazon.pageobjects.pages.AmazonHomePage;
import com.amazon.pageobjects.pages.EditBasketAndProceedCheckOut;
import com.amazon.pageobjects.pages.RegisterUser;
import com.amazon.pageobjects.selection.AmazoniPhone6SearchResults;

/**
 * Defines an abstract Page.
 * 
 * @author Raaghav A S, Automation Tester Cognizant Technology Solutions
 *         Assoicate ID : 286440
 */
public class PageObjectTest extends TestCase {

	private final static Logger log = Logger.getLogger(PageObjectTest.class);

	private WebDriver driver = null;
	private StringBuffer verificationErrors = new StringBuffer();

	/**
	 * Constructs a test case with the given name.
	 *
	 * @param testName
	 *            name of the test case.
	 */
	public PageObjectTest(String testName) {
		super(testName);
		log.debug("Generating Test Case: " + testName);
	}

	/**
	 * Construct a test suite for this class.
	 *
	 * @return the suite of tests.
	 */
	public static Test suite() {
		return new TestSuite(PageObjectTest.class);
	}

	/*
	 * setUp: Create a new instance of the FireFox driver.
	 */
	@Override
	public void setUp() {
		driver = new FirefoxDriver();
	}

	/*
	 * tearDown: Shutdown the driver.
	 */
	@Override
	public void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}

	/**
	 * Verify title of Amazon home page.
	 */
	public void testA_Amazon_PageTitle_HomePage() {
		AmazonHomePage homePage = new AmazonHomePage(driver);
		driver.get(homePage.getPageURL());

		// Now set the cookie. This one's valid for the entire domain
		Cookie cookie = new Cookie("key", "value");
		driver.manage().addCookie(cookie);

		assertEquals(
				"Amazon.co.uk: Low Prices in Electronics, Books, Sports Equipment & more",
				driver.getTitle());
	}

	/**
	 * Verify search functionality. Demonstrates use of AmazonSearch and
	 * AmazonSearchResults page objects.
	 */
	public void testB_AmazoniPhone6_Search_Results() {
		AmazonHomePage homePage = new AmazonHomePage(driver);
		driver.get(homePage.getPageURL());

		// Now set the cookie. This one's valid for the entire domain
		Cookie cookie = new Cookie("key", "value");
		driver.manage().addCookie(cookie);

		AmazoniPhone6SearchResults searchResults = homePage
				.searchFor("iPhone6");
		assertTrue(searchResults.getSearchResultText().contains("iPhone 6"));

		assertEquals("Amazon.co.uk: iPhone6", driver.getTitle());

		searchResults.selectSearchItem();

		// assertEquals("Apple iPhone 6 4.7\" UNLOCKED Silver / Gold / Space Grey 16 / 64 / 128GB SIM FREE (16GB, Gold): 3 network: Amazon.co.uk: Electronics",
		// driver.getTitle());

	}

	 /***
	  * tests to Edit the Item count to 3 and Proceed checkout
	  */
	public void testC_AmazoniPhone6_editBasket() {
		EditBasketAndProceedCheckOut editbasketButton = new EditBasketAndProceedCheckOut(
				driver);
		driver.get(editbasketButton.getPageURL());

		// Now set the cookie. This one's valid for the entire domain
		Cookie cookie = new Cookie("key", "value");
		driver.manage().addCookie(cookie);

		editbasketButton.addtoBasket();
		assertEquals("Amazon.co.uk Shopping Basket", driver.getTitle());

		try {
			// assertEquals("1 item was added to your basket",
			// driver.findElement(By.id("confirm-text")).getText());
		} catch (Error e) {
			verificationErrors.append(e.toString());
		}

	
		editbasketButton.editBasket();
		
		// assertTitle
		assertEquals("Amazon.co.uk Shopping Basket", driver.getTitle());

		// CheckOut the items ordered
		editbasketButton.proceedCheckOut();
	}
	
	/**
	 * Tests for the User Registration
	 */
	public void testD_UserRegistration() {
		RegisterUser registeruser = new RegisterUser(driver);
		driver.get(registeruser.getPageURL());

		// User Signing validation
		registeruser.signIn();

		/***
		 * Registration
		 */
		// Assert title
		assertEquals("Amazon.co.uk Registration", driver.getTitle());

		registeruser.Registration();

		// Address info
		/**
		 * Commented since it might not be application during checkout
		 */
		// registeruser.addressInfo();

	}
}
