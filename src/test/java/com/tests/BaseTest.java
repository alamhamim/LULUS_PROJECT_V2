package com.tests;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.browsers.BrowserConfig;
import com.logger.GetLogger;
import com.util.Helper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;

public class BaseTest {

    WebDriver driver;
    ExtentReports reports;
    ExtentTest test;
    Logger logger = GetLogger.getLogger(BaseTest.class);

    @BeforeClass
    public void testSetup() {
        reports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("Test-Report/report_" + Helper.getDateAndTime() + ".html");
        test = reports.createTest("LULUS TEST");
    }

    @Parameters({"browserName","url"})
    @BeforeMethod
    public void browserSetup(String browserName, String url) {
        driver = BrowserConfig.startAPP(driver, browserName, url);
    }

    @AfterMethod
    public void tearDown(ITestResult result) throws IOException {
        if (result.getStatus() == ITestResult.FAILURE) {
            Helper.takeScreenShot(driver);
            test.fail(result.getMethod().getMethodName()+" is failed");
            logger.fatal("Test is failed");
        } else {
            test.pass(result.getMethod().getMethodName() + " is passed");
            logger.debug("Test is passed");
        }
        reports.flush();
    }



}
