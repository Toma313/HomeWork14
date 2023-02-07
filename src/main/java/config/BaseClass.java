package config;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.json.JsonOutput;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.sql.SQLOutput;

public class BaseClass {
    static public WebDriver driver;
    @BeforeClass
    public static void createDriver() {
        System.out.println("BEFORE BASECLASS");
        driver = DriverConfig.createDriver(Browsers.CHROMEINCOGNITO);
    }
    @AfterClass
    public static void after() {
        try{
            Thread.sleep(5000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("AFTER BASECLASS");
        // System.out.println(driver.getCurrentUrl());
        driver.quit();
    }

}

