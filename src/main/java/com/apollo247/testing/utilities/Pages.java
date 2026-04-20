package com.apollo247.testing.utilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import com.apollo247.testing.pages.DashboardPage;
import com.apollo247.testing.pages.LabTestPage;
<<<<<<< HEAD
import com.apollo247.testing.pages.SearchDoctorPage;
=======
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
import com.apollo247.testing.pages.RadiologyPage;
import com.apollo247.testing.pages.UploadPrescriptionPage;
import com.apollo247.testing.pages.filterDocterPage;
//import com.apollo247.testing.pages.ManageFamilyPage;
import com.apollo247.testing.pages.MyAppointmentPage;
import com.apollo247.testing.pages.LocationPage;
//import com.apollo247.testing.pages.HealthInsurancePage;
import com.apollo247.testing.pages.HealthtoolPage;


public class Pages {

<<<<<<< HEAD
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
	public DashboardPage dashboardPage;
	public LabTestPage labTestPage;
	public UploadPrescriptionPage bookByPrescriptionPage;
	public RadiologyPage radiologyPage;
>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9

	// all the pages are initialized with the driver object
	public Pages(WebDriver driver) {

		// dashboard page driver initialization
		dashboardPage = new DashboardPage(driver);
		Searchdocter=new SearchDoctorPage(driver);
//	    manageFamilyPage = new ManageFamilyPage(driver);
		labTestPage = PageFactory.initElements(driver, LabTestPage.class);
//		healthInsurancePage=new HealthInsurancePage(driver);
		PageFactory.initElements(driver, dashboardPage);
//		PageFactory.initElements(driver, manageFamilyPage);
//		PageFactory.initElements(driver, healthInsurancePage);
		PageFactory.initElements(driver, Searchdocter);

		// labtest page driver initialization
<<<<<<< HEAD
=======
		labTestPage = PageFactory.initElements(driver, LabTestPage.class);

>>>>>>> f43f88b3ea8ad539e74e567c768991d95ce1f3e9
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

		// radiology page driver initialization
		radiologyPage = new RadiologyPage(driver);
		PageFactory.initElements(driver, radiologyPage);
	}
}
