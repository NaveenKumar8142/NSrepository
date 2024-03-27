package org.example.design;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.collect.ImmutableMap;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import org.apache.commons.io.FileUtils;
import org.example.Utils.AndroidActions;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.time.Duration;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;

public class BaseClass {
    public static AndroidDriver driver;
    public static AppiumDriverLocalService service;


    @BeforeClass
    public void Configuration() throws IOException, InterruptedException {
        Properties pro = new Properties();

        //This will create instance/object for Properties class
        FileInputStream fis = new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\java\\org\\example\\design\\resources\\Data.properties");
        //FIS class is used to read the data from properties file
        pro.load(fis);
        //It will load the path into pro object
        String ipAddress = pro.getProperty("ipAddress");
        String portNum = pro.getProperty("port");
        service = startAppiumServer(ipAddress, Integer.parseInt(portNum));
        UiAutomator2Options options = new UiAutomator2Options();
        // this will create instance & that will be used to configure appium session with that framework on android
        options.setDeviceName(pro.getProperty("androidDeviceName"));
        //providing the device name from property file
        options.setApp("D:\\Trainings\\Java Selenium\\nani\\untitled1\\untitled1\\src\\main\\java\\org\\example\\design\\resources\\GeneralStore.apk");
        driver = new AndroidDriver(service.getUrl(), options);
        Thread.sleep(5000);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public List<HashMap<String, String>> getJsonData(String JsonFilePath) throws IOException {
        String JsonContent = FileUtils.readFileToString(new File(JsonFilePath), StandardCharsets.UTF_8);
        ObjectMapper mapper = new ObjectMapper();
        List<HashMap<String, String>> data = mapper.readValue(JsonContent, new TypeReference<List<HashMap<String, String>>>() {
        });
        return data;
    }
    public AppiumDriverLocalService startAppiumServer(String ipAddress, int portNum) {
        AppiumDriverLocalService service;
        service = new AppiumServiceBuilder().withAppiumJS(new File("C:\\Users\\AIN166\\AppData\\Roaming\\npm\\node_modules\\appium\\build\\lib\\main.js"))
                .withIPAddress(ipAddress).usingPort(portNum).build();
        service.start();
        return service;
    }
    @AfterClass
    public void closing() {
        driver.quit();
        service.close();

    }
}

