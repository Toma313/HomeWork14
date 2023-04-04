package config;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.WorkWithFile;
import utils.WorkWithLogs;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

public class BaseClass {
    public static WebDriver driver;
    public static Map<String,String> map = new HashMap<>();
    @BeforeClass
    public static void createDriver() {
        System.out.println("BEFORE BASECLASS");
        driver = DriverConfig.createDriver(Browsers.BROWERSMOBPROXY);
    }
    @AfterClass
    public void after() throws IOException {
        try{
            Thread.sleep(1000);
        } catch (InterruptedException e){
            throw new RuntimeException(e);
        }
        WorkWithLogs.printLogs(driver);
        WorkWithFile.createFile("HillelLogs", WorkWithLogs.getLogEntries(driver));
        WorkWithFile.createFile("MAP", map);
        driver.quit();
    }




}

