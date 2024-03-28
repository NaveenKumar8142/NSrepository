package org.example.design;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.example.Utils.AndroidActions;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class CartPage1 extends AndroidActions {
    AndroidDriver driver;
    public CartPage1(AndroidDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(new AppiumFieldDecorator(driver),this);
    }

    @AndroidFindBy(id="com.androidsample.generalstore:id/productPrice")
    //List<WebElement> productPrices =driver.findElements(By.id("com.androidsample.generalstore:id/productPrice"));
    private List <WebElement> productList;

    @AndroidFindBy(id="com.androidsample.generalstore:id/totalAmountLbl")
    private WebElement totalAmount;

    @AndroidFindBy(id="com.androidsample.generalstore:id/termsButton")
    private WebElement terms;

    @AndroidFindBy(id="android:id/button1")
    private WebElement acceptButton;

    @AndroidFindBy(id="com.androidsample.generalstore:id/btnProceed")
private WebElement proceedButton;

    @AndroidFindBy(className="android.widget.CheckBox")
       public  WebElement checkBox;

    public List<WebElement> getProductList() {
        return productList;
    }

    public double getProductSum(){
        int count= productList.size();
        double totalSum=0;
        for(int i=0;i<count;i++){
            String amount=productList.get(i).getText();
            Double price=getFormattedAmount(amount);
            totalSum=totalSum+price;
        }
        return totalSum;
    }
public Double  getTotalAmountDisplayed(){
      return getFormattedAmount(totalAmount.getText());
}
public void acceptTerms(){
        LongPress(terms);
        acceptButton.click();
}
public  Double getFormattedAmount(String amount){
    Double price=Double.parseDouble(amount.substring(1));
    return price;

}
public void submitOrder(){
    checkBox.click();
    proceedButton.click();

}

}
