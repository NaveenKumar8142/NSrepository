package org.example.design;

import io.appium.java_client.AppiumBy;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class TestCase3 extends BaseClass1 {
    @Test
    public void checkingPrice() throws InterruptedException {
        driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();
        driver.findElement(AppiumBy.androidUIAutomator("new UiScrollable(new UiSelector()).scrollIntoView(text(\"Australia\"));"));
        driver.findElement(By.xpath("//android.widget.TextView[@text='Australia']")).click();
     //  driver.findElement(By.id("com.androidsample.generalstore:id/nameField")).sendKeys("Shashirekha");
        driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();
        driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
        String toast=driver.findElement(By.xpath("//android.widget.Toast[1]")).getAttribute("name");
        Assert.assertEquals(toast,"Please enter name");
        System.out.println(toast);


    }
}
