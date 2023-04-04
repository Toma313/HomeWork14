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
        Thread.sleep(10000);
        driver.findElement(By.xpath("//*[@id=\"L2AGLb\"]/div")).click();
        driver.findElement(By.xpath("//button[contains(@class,'icon-button') and contains(@class,'topbar-menu-button-avatar-button')]")).click();
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys("Ukraine");
        driver.findElement(By.xpath("//input[@name='search']")).sendKeys(Keys.ENTER);
        //  Thread.sleep(3000);
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


