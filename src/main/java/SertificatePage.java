import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SertificatePage {
    @FindBy(name = "certificate")
    WebElement textInput;
    @FindBy(xpath = "//*[@id=\"certificateCheckForm\"]/div/button")
    WebElement confirmButton;
    @FindBy(className = "certificate-check_message")
    WebElement messageCheck;

    @FindBy(xpath = "//*[@id=\"certificatePng\"]")
    static
    WebElement downloadcertificate;

    public void sendSertificateForm(String textInput) throws InterruptedException {
        this.textInput.sendKeys(textInput);
        confirmButton.click();
        Thread.sleep(3000);
    }

    public boolean messageCheckEn(){
        return messageCheck.isDisplayed();
    }

    public static boolean messageDisplay() {
        return downloadcertificate.getAttribute("href") != null;
    }
}
