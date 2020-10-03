package com.facebook.baseclass;

import com.facebook.util.TestUtil;
import org.openqa.selenium.WebDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseClass {
    public static Properties properties;
    public static WebDriver driver;
    public  BaseClass() throws IOException {
        properties = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\HP\\Documents\\Facebook_Automation_Project\\src\\main\\java\\com\\facebook\\config\\Config.properties");
            properties.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
    public static void initialize(){
        String browserName = properties.getProperty("browser");
        if(browserName.equals("chrome")){
            System.setProperty("webdriver.gecko.driver","C:\\Users\\HP\\Documents\\Facebook_Automation_Project\\Driver\\geckodriver.exe");
        }
        driver.manage().window().maximize();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(TestUtil.IMPLICITE_WAIT_TIMEOUT, TimeUnit.SECONDS);
    }
}
