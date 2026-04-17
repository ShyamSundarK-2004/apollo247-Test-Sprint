package com.apollo247.testing.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.apollo247.testing.pages.DashboardPage;
import com.apollo247.testing.pages.SearchDoctorPage;
import com.apollo247.testing.pages.ManageFamilyPage;
import com.apollo247.testing.pages.LabTestPage;
import com.apollo247.testing.pages.HealthInsurancePage;

public class Pages {

	public static DashboardPage dashboardPage;
	public static SearchDoctorPage Searchdocter;
	public static ManageFamilyPage manageFamilyPage; 
	public static LabTestPage labTestPage;
	public static HealthInsurancePage healthInsurancePage;

	// all the pages are initialized with the driver object
	public static void loadAllPages(WebDriver driver) {
		dashboardPage = new DashboardPage(driver);
		Searchdocter=new SearchDoctorPage(driver);
//		PageFactory.initElements(driver, dashboardPage);
//		PageFactory.initElements(driver, Searchdocter);
		
		PageFactory.initElements(driver, dashboardPage);
    	manageFamilyPage = new ManageFamilyPage(driver);
		PageFactory.initElements(driver, manageFamilyPage);
		labTestPage = PageFactory.initElements(driver, LabTestPage.class);

		healthInsurancePage=new HealthInsurancePage(driver);
		PageFactory.initElements(driver, healthInsurancePage);

		

	}
}
