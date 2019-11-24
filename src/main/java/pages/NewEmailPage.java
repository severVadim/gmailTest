package pages;


import objects.Mail;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class NewEmailPage extends BasePage {

    public NewEmailPage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//textarea[@aria-label='Кому']")
    WebElement toWhom;

    @FindBy(xpath = "//input[@aria-label='Тема']")
    WebElement subject;

    @FindBy(xpath = "//div[@role='textbox' and @aria-label='Тело письма']")
    WebElement message;

    @FindBy(xpath = "//div[@role='button' and starts-with(@aria-label, 'Отправить')]")
    WebElement sendButton;

    public HomePage createNewMail(Mail mail) {
        writeText(toWhom, mail.getToWhom());
        writeText(subject, mail.getSubject());
        writeText(message, mail.getMessage());
        click(sendButton);
        return new HomePage(driver);
    }
}
