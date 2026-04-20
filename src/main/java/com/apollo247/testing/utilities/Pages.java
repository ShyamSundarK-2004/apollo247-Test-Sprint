package com.apollo247.testing.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.apollo247.testing.pages.DashboardPage;
import com.apollo247.testing.pages.LabTestPage;
<<<<<<< HEAD

import com.apollo247.testing.pages.HealthInsurancePage;
=======
import com.apollo247.testing.pages.SearchDoctorPage;
import com.apollo247.testing.pages.RadiologyPage;
import com.apollo247.testing.pages.UploadPrescriptionPage;
import com.apollo247.testing.pages.filterDocterPage;
//import com.apollo247.testing.pages.ManageFamilyPage;
import com.apollo247.testing.pages.MyAppointmentPage;
import com.apollo247.testing.pages.LocationPage;
//import com.apollo247.testing.pages.HealthInsurancePage;
import com.apollo247.testing.pages.HealthtoolPage;

>>>>>>> e0e53877cf1731a16176a9c23f5898a1a35ce501


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
<<<<<<< HEAD

	public static HealthInsurancePage healthInsurancePage;
	

	public static ManageFamilyPage manageFamilyPage; 
	public static SearchDoctorPage Searchdocter;
	public static MyAppointmentsPage myappointmentsPage; 
	public static MembershipsPage membershipsPage;
	public static NotificationsPage notificationsPage;
	public static NeedHelpPage needHelpPage;
	public static LogoutPage logoutPage;
=======
//	public static HealthInsurancePage healthInsurancePage;
	public static SearchDoctorPage Searchdocter;
//	public static ManageFamilyPage manageFamilyPage; 
	public static UploadPrescriptionPage bookByPrescriptionPage;
	public static RadiologyPage radiologyPage;
	public static filterDocterPage FilterDocter;
	public static MyAppointmentPage AppointmentDocter;
	public static LocationPage LocationDocter;
	public static HealthtoolPage HeartToolPage;
>>>>>>> e0e53877cf1731a16176a9c23f5898a1a35ce501

	// all the pages are initialized with the driver object
	public static void loadAllPages(WebDriver driver) {

		// dashboard page driver initialization
		dashboardPage = new DashboardPage(driver);
<<<<<<< HEAD
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

=======
		Searchdocter=new SearchDoctorPage(driver);
//	    manageFamilyPage = new ManageFamilyPage(driver);
		labTestPage = PageFactory.initElements(driver, LabTestPage.class);
//		healthInsurancePage=new HealthInsurancePage(driver);
		PageFactory.initElements(driver, dashboardPage);
//		PageFactory.initElements(driver, manageFamilyPage);
//		PageFactory.initElements(driver, healthInsurancePage);
		PageFactory.initElements(driver, Searchdocter);

		// labtest page driver initialization
		// upload_prescription page driver initialization
		bookByPrescriptionPage = new UploadPrescriptionPage(driver);
		PageFactory.initElements(driver, bookByPrescriptionPage);
      	
		labTestPage = PageFactory.initElements(driver, LabTestPage.class);
        FilterDocter=PageFactory.initElements(driver, filterDocterPage.class);
        AppointmentDocter=PageFactory.initElements(driver, MyAppointmentPage.class);
        LocationDocter=PageFactory.initElements(driver, LocationPage.class);
        HeartToolPage=PageFactory.initElements(driver, HealthtoolPage.class);
		// radiology page driver initialization
		radiologyPage = new RadiologyPage(driver);
		PageFactory.initElements(driver, radiologyPage);
>>>>>>> e0e53877cf1731a16176a9c23f5898a1a35ce501

	}
}