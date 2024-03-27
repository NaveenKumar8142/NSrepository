/*
package org.example;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.Activity;
import org.example.APIDemoApplication.BaseClass;
import org.example.design.BaseClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.net.MalformedURLException;

public class Drag extends BaseClass {
    @Test
    public void DragNDrop() throws MalformedURLException, InterruptedException {
        Configuration();
driver.findElement(AppiumBy.accessibilityId("Views")).click();
driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
WebElement source=driver.findElement(By.id("io.appium.android.apis:id/drag_dot_1"));
dragn(source,844,736);
Thread.sleep(2000);
String result=driver.findElement(By.id("io.appium.android.apis:id/drag_result_text")).getText();
        Assert.assertEquals(result,"Dropped!");
        Activity act=new Activity("io.appium.android.apis","io.appium.android.apis.preference.PreferenceDependencies");
        driver.startActivity(act);

    }
}
*/
