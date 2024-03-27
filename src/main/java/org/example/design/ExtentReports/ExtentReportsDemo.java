package org.example.design.ExtentReports;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.AppiumDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeTest;

import java.io.File;
import java.io.IOException;

public class ExtentReportsDemo {

   static  ExtentReports extent;
    WebDriver driver;

    @BeforeTest
    public static ExtentReports getconfiguration() {
        String path = System.getProperty("user.dir") + "\\reports\\index.html";
        //its the path to store the report(in our project in the reporter folder with the name of index.html file will be created)
        ExtentSparkReporter reporter = new ExtentSparkReporter(path);
        //its responsible to create a report in the provided path
        reporter.config().setReportName("WebAutomation Results");
        //by using above object we can give report name
        reporter.config().setDocumentTitle("Test Results");

        extent = new ExtentReports();
        //its a main class. which will be responsible and consolidate the report which is coming from extentsparkreporter
        extent.attachReporter(reporter);
        //attaching helpingclass object to this object.So it will get all the details from extentSparkReporter like path etc
        extent.setSystemInfo("Tester", "NaveenKumar");
        extent.setSystemInfo("Environment","SIT");
        //AVENSTACK DEPENDCY IS REQUIRED FOR THIS REPORTS GENERATION
       return extent;
    }



    public String getScreenshotPath(String testCaseName, AppiumDriver driver) throws IOException {
        TakesScreenshot takesScreenshot=(TakesScreenshot) driver;
        // to take the screenshot, need to create an object
        File source= takesScreenshot.getScreenshotAs(OutputType.FILE);
        //to get the screenshot in File format(raw file) stored in source variable
        String destinationFile =System.getProperty("user.dir") + "//reports"+testCaseName+".png";
        //it will create a file in reports folder in the form of png in our project and stored in a string format
        FileUtils.copyFile(source, new File(destinationFile));
       /* it will copy the screenshot from rawformat(source) to destinationFile and
        we can't pass destinationfile directly.But we can pass in the form of File object*/
        return destinationFile;
        //In this will capture the screenshot and attach to extent report
    }

}