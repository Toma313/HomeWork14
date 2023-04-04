import config.BaseClass;
import config.BaseProxy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.sql.SQLOutput;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class TestSert extends BaseProxy {

    SertificatePage sertificatePage;
    @Test(dataProvider= "gerSert", dataProviderClass = SertData.class)
    public void testSertPage(String type) throws InterruptedException {
        ResourceBundle bundle =ResourceBundle.getBundle(type);
        driver.get("https://certificate.ithillel.ua/");
        sertificatePage = PageFactory.initElements(driver, SertificatePage.class);
        sertificatePage.sendSertificateForm(bundle.getString("textInput"));

        map.put(bundle.getBaseBundleName(),String.valueOf(SertificatePage.messageDisplay()));
        Assert.assertEquals(bundle.getString("error"),String.valueOf(sertificatePage.messageCheckEn()));
        System.out.println("Check type: "+type);
    }
}
