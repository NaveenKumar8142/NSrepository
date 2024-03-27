package org.example.design;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.Utils.AndroidActions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

public class FirstPage extends AndroidActions {
    public AndroidDriver driver;

    public FirstPage(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);

    }

    @AndroidFindBy(id ="com.androidsample.generalstore:id/nameField")
    private WebElement nameField;


    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioMale")
    private WebElement maleGender;
    //driver.findElement(By.id("com.androidsample.generalstore:id/radioMale")).click();

    @AndroidFindBy(id = "com.androidsample.generalstore:id/radioFemale")
    private WebElement femaleGender;
    //driver.findElement(By.id("com.androidsample.generalstore:id/radioFemale")).click();

    @AndroidFindBy(id = "com.androidsample.generalstore:id/spinnerCountry")
    private WebElement countrySelection;
    //   driver.findElement(By.id("com.androidsample.generalstore:id/spinnerCountry")).click();

    @AndroidFindBy(id = "com.androidsample.generalstore:id/btnLetsShop")
    private WebElement shopButton;

    //   driver.findElement(By.id("com.androidsample.generalstore:id/btnLetsShop")).click();
    public void setTextbox(String name) throws InterruptedException {
       // Thread.sleep(5000);
        nameField.sendKeys(name);
       // Thread.sleep(3000);
        driver.hideKeyboard();
    }

    public void setGender(String gender) {
        if (gender.contains("female"))
            femaleGender.click();
        else
            maleGender.click();
    }

    public void setCountrySelection(String countryName) {
        countrySelection.click();
        scrollToText(countryName);
        driver.findElement(By.xpath("//android.widget.TextView[@text='" + countryName + "']")).click();

    }

    public void submitForm() {
        shopButton.click();
    }


}