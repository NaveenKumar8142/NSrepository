package org.example.design;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.io.FileUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class Ecommerce1 extends BaseClass1 {

    @Test(dataProvider = "getData")
    public void fillForm(HashMap<String, String> input) throws MalformedURLException, InterruptedException {
        FirstPage1 fo = new FirstPage1(driver);
        fo.setTextbox(input.get("name"));
        fo.setGender(input.get("gender"));
        fo.setCountrySelection(input.get("country"));
        fo.submitForm();
        ProductCatalogue productCatalogue = new ProductCatalogue(driver);
        productCatalogue.addItemToCartByIndex(0);
        productCatalogue.GoToCart();
        CartPage1 cartPage = new CartPage1(driver);
        double totalsum = cartPage.getProductSum();
        System.out.println(totalsum);
        double displayFormattedSum = cartPage.getTotalAmountDisplayed();
        System.out.println(displayFormattedSum);
        cartPage.acceptTerms();
        cartPage.submitOrder();
        Thread.sleep(6000);
        Set<String> context=driver.getContextHandles();
        Thread.sleep(6000);
        for(String contextNames:context){
            System.out.println(contextNames);
        }
//driver.context("WEBVIEW_com.androidsample.generalstore");
      //  driver.findElement(By.id("input")).sendKeys("Amazon");
// gyuio


    }

    public List<HashMap<String, String>> getJsonData(String JsonFilePath) throws IOException {
        String JsonContent = FileUtils.readFileToString(new File(JsonFilePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }

    @DataProvider
    public Object[][] getData() throws IOException {
        List<HashMap<String, String>> data = getJsonData(System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\testData\\eCommerce.json");
        // return new Object[][]{{"Naveenkumar","male","Algeria"}};
        return new Object[][]{{data.get(0)}};
    }
}





