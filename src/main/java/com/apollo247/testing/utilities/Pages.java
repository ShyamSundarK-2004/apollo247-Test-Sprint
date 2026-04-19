package com.apollo247.testing.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.apollo247.testing.pages.DashboardPage;
import com.apollo247.testing.pages.LabTestPage;

import com.apollo247.testing.pages.HealthInsurancePage;


import com.apollo247.testing.pages.ManageFamilyPage;
import com.apollo247.testing.pages.SearchDoctorPage;
import com.apollo247.testing.pages.MembershipsPage;
import com.apollo247.testing.pages.LogoutPage;
import com.apollo247.testing.pages.MyAppointmentsPage;
import com.apollo247.testing.pages.NeedHelpPage;
import com.apollo247.testing.pages.NotificationsPage;
import com.apollo247.testing.pages.MyAppointmentsPage;

public class Pages {

	public static DashboardPage dashboardPage;
	public static LabTestPage labTestPage;

	public static HealthInsurancePage healthInsurancePage;
	

	public static ManageFamilyPage manageFamilyPage; 
	public static SearchDoctorPage Searchdocter;
	public static MyAppointmentsPage myappointmentsPage; 
	public static MembershipsPage membershipsPage;
	public static NotificationsPage notificationsPage;
	public static NeedHelpPage needHelpPage;
	public static LogoutPage logoutPage;

	// all the pages are initialized with the driver object
	public static void loadAllPages(WebDriver driver) {
		dashboardPage = new DashboardPage(driver);
		Searchdocter = new SearchDoctorPage(driver);
		manageFamilyPage = new ManageFamilyPage(driver);
		myappointmentsPage = new MyAppointmentsPage(driver);
		healthInsurancePage = new HealthInsurancePage(driver);
		membershipsPage = new MembershipsPage(driver);
		notificationsPage = new NotificationsPage(driver);
		needHelpPage = new NeedHelpPage(driver);
		logoutPage = new LogoutPage(driver);

		PageFactory.initElements(driver, dashboardPage);
		PageFactory.initElements(driver, manageFamilyPage);
		PageFactory.initElements(driver, myappointmentsPage);
		PageFactory.initElements(driver, healthInsurancePage);
		PageFactory.initElements(driver, membershipsPage);
		PageFactory.initElements(driver, notificationsPage);
		PageFactory.initElements(driver, needHelpPage);
		PageFactory.initElements(driver, logoutPage);

		labTestPage = PageFactory.initElements(driver, LabTestPage.class);
		PageFactory.initElements(driver, manageFamilyPage);
		
		
		PageFactory.initElements(driver, dashboardPage);
		PageFactory.initElements(driver, manageFamilyPage);
		PageFactory.initElements(driver, myappointmentsPage);


	}
}