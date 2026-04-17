package com.apollo247.testing.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.apollo247.testing.pages.DashboardPage;
import com.apollo247.testing.pages.SearchDoctorPage;
import com.apollo247.testing.pages.ManageFamilyPage;
import com.apollo247.testing.pages.LabTestPage;
import com.apollo247.testing.pages.HealthInsurancePage;
import com.apollo247.testing.pages.MyAppointmentsPage;

public class Pages {

	public static DashboardPage dashboardPage;
	public static SearchDoctorPage Searchdocter;
	public static ManageFamilyPage manageFamilyPage; 
	public static LabTestPage labTestPage;
	public static HealthInsurancePage healthInsurancePage;
	public static MyAppointmentsPage myappointmentsPage; 

	// all the pages are initialized with the driver object
	public static void loadAllPages(WebDriver driver) {
		dashboardPage = new DashboardPage(driver);
		Searchdocter = new SearchDoctorPage(driver);
		manageFamilyPage = new ManageFamilyPage(driver);
		myappointmentsPage = new MyAppointmentsPage(driver);
		healthInsurancePage = new HealthInsurancePage(driver);

		PageFactory.initElements(driver, dashboardPage);
		PageFactory.initElements(driver, manageFamilyPage);
		PageFactory.initElements(driver, myappointmentsPage);
		PageFactory.initElements(driver, healthInsurancePage);

		labTestPage = PageFactory.initElements(driver, LabTestPage.class);
	}
}