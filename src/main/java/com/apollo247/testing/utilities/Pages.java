package com.apollo247.testing.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.apollo247.testing.pages.DashboardPage;
<<<<<<< HEAD
import com.apollo247.testing.pages.LabTestPage;

import com.apollo247.testing.pages.HealthInsurancePage;

import com.apollo247.testing.pages.LabTestPage;
=======
import com.apollo247.testing.pages.SearchDoctorPage;
>>>>>>> feature/finddoctor


public class Pages {

	public static DashboardPage dashboardPage;
<<<<<<< HEAD
	public static LabTestPage labTestPage;

	public static HealthInsurancePage healthInsurancePage;
	

=======
	public static SearchDoctorPage Searchdocter;
>>>>>>> feature/finddoctor

	// all the pages are initialized with the driver object
	public static void loadAllPages(WebDriver driver) {
		dashboardPage = new DashboardPage(driver);
		Searchdocter=new SearchDoctorPage(driver);
		PageFactory.initElements(driver, dashboardPage);
<<<<<<< HEAD
		labTestPage = PageFactory.initElements(driver, LabTestPage.class);

		healthInsurancePage=new HealthInsurancePage(driver);
		PageFactory.initElements(driver, healthInsurancePage);

		labTestPage = PageFactory.initElements(driver, LabTestPage.class);

=======
		PageFactory.initElements(driver, Searchdocter);
		
>>>>>>> feature/finddoctor
	}
}
