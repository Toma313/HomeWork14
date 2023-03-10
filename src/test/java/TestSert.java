import config.BaseClass;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.ResourceBundle;

public class TestSert extends BaseClass {
    SertificatePage sertificatePage;
    @Test(dataProvider= "gerSert", dataProviderClass = SertData.class)
    public void testSertPage(String type) throws InterruptedException {
        ResourceBundle bundle =ResourceBundle.getBundle(type);
        driver.get("https://certificate.ithillel.ua/");
        sertificatePage = PageFactory.initElements(driver, SertificatePage.class);
        sertificatePage.sendSertificateForm(bundle.getString("textInput"));
        Assert.assertEquals(bundle.getString("error"),String.valueOf(sertificatePage.messageCheckEn()));
        System.out.println("Check type: "+type);

    }
}
