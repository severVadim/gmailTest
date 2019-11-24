package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class MailPage extends BasePage {

    public MailPage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//a[@title='Входящие']")
    WebElement inboxPage;

    public HomePage backToHomePage() {
        click(inboxPage);
        return new HomePage(driver);
    }
}
