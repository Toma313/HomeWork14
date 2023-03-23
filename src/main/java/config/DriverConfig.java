package config;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.logging.Level;

import static org.openqa.selenium.chrome.ChromeOptions.LOGGING_PREFS;
import static org.openqa.selenium.remote.CapabilityType.*;

public class DriverConfig {
    public static WebDriver driver;
    public static  WebDriver createDriver(Browsers browser) {
        if (driver == null) {
            switch (browser) {
                case CHROME -> createChrome();
                case CHROMEINCOGNITO -> createChromeIncognito();
                case CHROMELOGS -> chromeWithLogsOptions();

            }

        }
        return driver;
    }


    private static void createChromeIncognito() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito") ;
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver = new ChromeDriver(options);
    }

    private static void createChrome() {
        driver= new ChromeDriver();
        driver.manage().window().maximize();
    }

    private  static  void chromeWithLogsOptions(){
        LoggingPreferences prefs = new LoggingPreferences();
        prefs.enable(LogType.BROWSER, Level.ALL);
        DesiredCapabilities capabilities = new DesiredCapabilities();
     //   capabilities.setCapability(CapabilityType.LOGGING_PREFS, prefs);
        ChromeOptions options = new ChromeOptions();
        options.merge(capabilities);
        options.addArguments("--start-maximized");
        options.addArguments("--remote-allow-origins=*");
        driver=new ChromeDriver(options);
    }

}
