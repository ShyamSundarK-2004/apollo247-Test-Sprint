package com.apollo247.testing.utilities;

import org.openqa.selenium.WebDriver;

import org.openqa.selenium.support.PageFactory;

import com.apollo247.testing.pages.DashboardPage;

import com.apollo247.testing.pages.LabTestPage;

import com.apollo247.testing.pages.HealthInsurancePage;

import com.apollo247.testing.pages.LabTestPage;

import com.apollo247.testing.pages.SearchDoctorPage;



public class Pages {

	public static DashboardPage dashboardPage;

	public static LabTestPage labTestPage;

	public static HealthInsurancePage healthInsurancePage;
	


	public static SearchDoctorPage Searchdocter;


	// all the pages are initialized with the driver object
	public static void loadAllPages(WebDriver driver) {
		dashboardPage = new DashboardPage(driver);
		Searchdocter=new SearchDoctorPage(driver);
		PageFactory.initElements(driver, dashboardPage);

		labTestPage = PageFactory.initElements(driver, LabTestPage.class);

		healthInsurancePage=new HealthInsurancePage(driver);
		PageFactory.initElements(driver, healthInsurancePage);

		labTestPage = PageFactory.initElements(driver, LabTestPage.class);


		PageFactory.initElements(driver, Searchdocter);
		

	}
}
