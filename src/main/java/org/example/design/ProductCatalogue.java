package org.example.design;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.Utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ProductCatalogue extends AndroidActions {
    public AndroidDriver driver;
    public   ProductCatalogue (AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(xpath = "//android.widget.TextView[@text='ADD TO CART']")
    private List<WebElement>  addToCart;

    @AndroidFindBy(id="com.androidsample.generalstore:id/appbar_btn_cart")
private WebElement GoToCartButton;

public void addItemToCartByIndex(int index) throws InterruptedException {
        addToCart.get(index).click();
        Thread.sleep(5000);


}
public void GoToCart(){
        GoToCartButton.click();
}




}
