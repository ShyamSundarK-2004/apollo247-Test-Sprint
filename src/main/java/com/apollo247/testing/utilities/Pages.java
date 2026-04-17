package com.apollo247.testing.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.apollo247.testing.pages.DashboardPage;
import com.apollo247.testing.pages.ManageFamilyPage;

public class Pages {

	public static DashboardPage dashboardPage;
	public static ManageFamilyPage manageFamilyPage; 

	// all the pages are initialized with the driver object
	public static void loadAllPages(WebDriver driver) {
		dashboardPage = new DashboardPage(driver);
		manageFamilyPage = new ManageFamilyPage(driver);
		PageFactory.initElements(driver, dashboardPage);
		PageFactory.initElements(driver, manageFamilyPage);

	}
}
