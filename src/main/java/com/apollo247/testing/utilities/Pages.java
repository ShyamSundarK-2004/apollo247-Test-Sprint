package com.apollo247.testing.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.apollo247.testing.pages.DashboardPage;
<<<<<<< HEAD
import com.apollo247.testing.pages.LabTestPage;
import com.apollo247.testing.pages.SearchDoctorPage;
import com.apollo247.testing.pages.RadiologyPage;
import com.apollo247.testing.pages.UploadPrescriptionPage;
import com.apollo247.testing.pages.filterDocterPage;
//import com.apollo247.testing.pages.ManageFamilyPage;
import com.apollo247.testing.pages.MyAppointmentPage;
import com.apollo247.testing.pages.LocationPage;
//import com.apollo247.testing.pages.HealthInsurancePage;
import com.apollo247.testing.pages.HealthtoolPage;


public class Pages {

	public static DashboardPage dashboardPage;
	public static LabTestPage labTestPage;
//	public static HealthInsurancePage healthInsurancePage;
	public static SearchDoctorPage Searchdocter;
//	public static ManageFamilyPage manageFamilyPage; 
	public static UploadPrescriptionPage bookByPrescriptionPage;
	public static RadiologyPage radiologyPage;
	public static filterDocterPage FilterDocter;
	public static MyAppointmentPage AppointmentDocter;
	public static LocationPage LocationDocter;
	public static HealthtoolPage HeartToolPage;
=======

import com.apollo247.testing.pages.HealthInsurancePage;
import com.apollo247.testing.pages.HealthInsuranceProductListings;

public class Pages {

	public static DashboardPage dashboardPage;;
	public static HealthInsurancePage healthInsurancePage;
<<<<<<< HEAD
>>>>>>> 903d57d (Insurance Updated)
=======
	public static HealthInsuranceProductListings healthInsuranceProductListings;
>>>>>>> 643c1e6 (Test scenarios Updated)

	// all the pages are initialized with the driver object
	public static void loadAllPages(WebDriver driver) {

		// dashboard page driver initialization
		dashboardPage = new DashboardPage(driver);
<<<<<<< HEAD
		Searchdocter=new SearchDoctorPage(driver);
//	    manageFamilyPage = new ManageFamilyPage(driver);
		labTestPage = PageFactory.initElements(driver, LabTestPage.class);
//		healthInsurancePage=new HealthInsurancePage(driver);
		PageFactory.initElements(driver, dashboardPage);
//		PageFactory.initElements(driver, manageFamilyPage);
//		PageFactory.initElements(driver, healthInsurancePage);
		PageFactory.initElements(driver, Searchdocter);
=======
		PageFactory.initElements(driver, dashboardPage);

>>>>>>> 903d57d (Insurance Updated)

<<<<<<< HEAD
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
=======
		healthInsurancePage=new HealthInsurancePage(driver);
		PageFactory.initElements(driver, healthInsurancePage);
		
		
		healthInsuranceProductListings=new HealthInsuranceProductListings(driver);
		PageFactory.initElements(driver, healthInsuranceProductListings);
		
		

		
>>>>>>> 643c1e6 (Test scenarios Updated)

	}
}
