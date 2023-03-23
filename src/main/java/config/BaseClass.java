package config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WorkWithFile;
import utils.WorkWithLogs;

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
            Thread.sleep(1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        System.out.println("AFTER BASECLASS");

        WorkWithLogs.printLogs(driver);
        WorkWithFile.createFile("HillelLogs", WorkWithLogs.getLogEntries(driver));
        driver.quit();
    }




}

