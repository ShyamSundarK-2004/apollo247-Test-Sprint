package com.apollo247.testing.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;

import com.apollo247.testing.pages.DashboardPage;
import com.apollo247.testing.pages.LabTestPage;
import com.apollo247.testing.pages.RadiologyPage;
import com.apollo247.testing.pages.UploadPrescriptionPage;
import com.apollo247.testing.pages.ManageFamilyPage;
import com.apollo247.testing.pages.MyAppointmentsPage;
import com.apollo247.testing.pages.MembershipsPage;
import com.apollo247.testing.pages.NotificationsPage;
import com.apollo247.testing.pages.NeedHelpPage;
import com.apollo247.testing.pages.LogoutPage;

public class Pages {

    public static DashboardPage dashboardPage;
    public static LabTestPage labTestPage;
    public static UploadPrescriptionPage bookByPrescriptionPage;
    public static RadiologyPage radiologyPage;

    public static ManageFamilyPage manageFamilyPage;
    public static MyAppointmentsPage myappointmentsPage;
    public static MembershipsPage membershipsPage;
    public static NotificationsPage notificationsPage;
    public static NeedHelpPage needHelpPage;
    public static LogoutPage logoutPage;

    public Pages(WebDriver driver) {

        dashboardPage = new DashboardPage(driver);
        PageFactory.initElements(driver, dashboardPage);

        labTestPage = PageFactory.initElements(driver, LabTestPage.class);

        bookByPrescriptionPage = new UploadPrescriptionPage(driver);
        PageFactory.initElements(driver, bookByPrescriptionPage);

        radiologyPage = new RadiologyPage(driver);
        PageFactory.initElements(driver, radiologyPage);

        manageFamilyPage = new ManageFamilyPage(driver);
        myappointmentsPage = new MyAppointmentsPage(driver);
        membershipsPage = new MembershipsPage(driver);
        notificationsPage = new NotificationsPage(driver);
        needHelpPage = new NeedHelpPage(driver);
        logoutPage = new LogoutPage(driver);

        PageFactory.initElements(driver, manageFamilyPage);
        PageFactory.initElements(driver, myappointmentsPage);
        PageFactory.initElements(driver, membershipsPage);
        PageFactory.initElements(driver, notificationsPage);
        PageFactory.initElements(driver, needHelpPage);
        PageFactory.initElements(driver, logoutPage);
    }
}