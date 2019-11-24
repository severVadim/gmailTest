package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class MailPage extends BasePage {
    public MailPage(WebDriver driver) {
        super(driver);
    }

    By inboxPage = By.xpath("//a[@title='Входящие']");

    public HomePage backToHomePage() {
        click(inboxPage);
        return new HomePage(driver);
    }
}
