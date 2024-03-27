package org.example.design.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import io.appium.java_client.AppiumDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import java.io.IOException;

public class Listeners extends ExtentReportsDemo implements ITestListener {

    ExtentReports extent = ExtentReportsDemo.getconfiguration();
    //calling getconfiguration method dirctly by classname
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    /*    it will create the test by testcaseName to get the testcase name we are using
        result.getMethod.getMethodName() & it will create test entry*/
        System.out.println("Execution started");
    }

    public void onTestSuccess(ITestResult result) {
        test.log(Status.PASS, "Test Passed");
       /* In the test object all the entrys are stored.Based on test log will get the
        status. we are filtering with pass keyword*/
        System.out.println("Execution completed and test passed");
    }

    public void onTestFailure(ITestResult result) {
        // test.log(Status.FAIL,"TestFailed"); it will just give us as fail
        test.fail(result.getThrowable()); //it will give us the reason in logs
        try {
            driver = (AppiumDriver) result.getTestClass().getRealClass().getField(("driver")).get(result.getInstance());
        }
     /*   results holds the information about the test.from that we are getting testname.
         from that we are getting class name  as per testNG.Xml file and from that class it will get the driver*/

        catch (Exception e) {
            e.printStackTrace();
        }
        try {
            test.addScreenCaptureFromPath(getScreenshotPath(result.getMethod().getMethodName(), (AppiumDriver) driver), result.getMethod().getMethodName());
           /* in this we are attaching screenshot to extent report by addScreenCaptureFromPath method and passing
            parameters i.e,  getScreenshotpath parameters and testcassename
            getScreenshotpath parameters are testcaseName and driver
             testcasename==get by result.getMethod().getMethodName()*/
        } catch (Exception e1) {
            e1.printStackTrace();
        }
    }

    public void onFinish(ITestContext context) {
        extent.flush();
        //Then only report generation will be finished.Other wise it will looks for data to generate(it will not generate report)
    }
}
