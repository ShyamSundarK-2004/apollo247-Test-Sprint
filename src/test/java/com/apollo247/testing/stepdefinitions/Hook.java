package com.apollo247.testing.stepdefinitions;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

import com.apollo247.testing.utilities.BaseClass;
import com.apollo247.testing.utilities.Pages;
import com.apollo247.testing.utilities.ReaderUtilities;
import com.apollo247.testing.utilities.SessionManager;
import com.apollo247.testing.utilities.WebdriverUtility;

import io.cucumber.java.After;
import io.cucumber.java.Before;

<<<<<<< HEAD
public class Hook extends WebdriverUtility {
=======
public class Hook extends AllUtilityFunctions {
	 private BaseClass b;
>>>>>>> 643c1e6 (Test scenarios Updated)

	    private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

<<<<<<< HEAD
	WebDriver Basedriver;

	// dependency Injection
	public Hook(BaseClass b) {
		this.b = b;
	}

	ReaderUtilities readerUtil = new ReaderUtilities();

	@Before
	public void setup() throws Exception {
		// reading from property file
		String browser = readerUtil.getPropertyKeyValue("browser");
		// browser setup and launching

		if (browser.equals("chrome")) {
			Basedriver = new ChromeDriver();
		} else if (browser.equals("edge")) {
			Basedriver = new EdgeDriver();
		}

		// set driver instance for parallel execution
		b.setDriver(Basedriver);

		// initialize driver to utlitlies
		initializeDriver(b.getDriver());
=======
	    public Hook(BaseClass b) {
	        this.b = b;
	    }

	    public static WebDriver getDriver() {
	        return driver.get();
	    }

	    @Before
	    public void setup() throws IOException {

	        String url = getPropertyKeyValue("url");
	        String browser = getPropertyKeyValue("browser");
>>>>>>> 643c1e6 (Test scenarios Updated)

	        WebDriver localDriver;

<<<<<<< HEAD
		// adding a implicit wait for the page to load
		waitForElements(40);

		// First run login manually Or if Logged in already use the same
		// sessions/cookies
		SessionManager.ManageSession(b.getDriver());

		// initialize all the pages with driver using page factory


		Pages.loadAllPages(b.getDriver());
=======
	        if (browser.equalsIgnoreCase("chrome")) {
	            localDriver = new ChromeDriver();
	        } else if (browser.equalsIgnoreCase("edge")) {
	            localDriver = new EdgeDriver();
	        } else {
	            throw new RuntimeException("Invalid browser");
	        }

	        // ✅ Thread-safe driver
	        driver.set(localDriver);

	        // ✅ Inject into BaseClass (for DI)
	        b.driver = getDriver();
>>>>>>> 643c1e6 (Test scenarios Updated)

	        initializeDriver(getDriver());
	        configMaximizeBrowser();
	        waitForElements(50);
	        enterURL(url);

<<<<<<< HEAD
		// logging in with mobile number
		Pages.dashboardPage.login("phoneNo");

		// enter otp and verify otp
		Pages.dashboardPage.enterOtpAndclickVerify();
		Pages.dashboardPage.clickOnModule("Find Doctors");


	}

	

	@After
	public void teadDown() {
//		quitBroswerWindow();
//		b.unload();
	}
=======
	        Pages.loadAllPages(getDriver());

	        Pages.dashboardPage.closeDomPopup();
	        Pages.dashboardPage.login(getPropertyKeyValue("phoneNo"));
	        Pages.dashboardPage.enterOtpAndclickVerify();
	    }

	    @After
	    public void teadDown() {
	        getDriver().quit();
	        driver.remove(); // ✅ important
	    }
>>>>>>> 643c1e6 (Test scenarios Updated)
}