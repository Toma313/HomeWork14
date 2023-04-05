import config.BaseProxy;
import net.lightbody.bmp.core.har.Har;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class TestYoutube extends BaseProxy{
    @Test
    public void test1() throws InterruptedException {
        driver.get("https://www.youtube.com/");
        driver.findElement(By.xpath("//button[contains(@class,'icon-button') and contains(@class,'topbar-menu-button-avatar-button')]")).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("no war");
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(Keys.ENTER);
        Thread.sleep(4000);
        utils.BrowserUtils.takeScreen("screen");
    }

    @Test
    public void test2() throws InterruptedException, IOException {
        serverBase.newHar("wiki");

        driver.get("https://www.google.com/");
        Har hr=serverBase.getHar();
        hr.writeTo(new File("wiki.har"));
        Thread.sleep(10000);
    }

    }


