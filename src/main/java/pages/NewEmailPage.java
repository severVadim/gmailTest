package pages;


import objects.Mail;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class NewEmailPage extends BasePage {

    public NewEmailPage(WebDriver driver) {
        super(driver);
    }

    By toWhom = By.xpath("//textarea[@aria-label='Кому']");

    By subject = By.xpath("//input[@aria-label='Тема']");

    By message = By.xpath("//div[@role='textbox' and @aria-label='Тело письма']");

    By sendButton = By.xpath("//div[@role='button' and starts-with(@aria-label, 'Отправить')]");

    public HomePage createNewMail(Mail mail) {
        writeText(toWhom, mail.getToWhom());
        writeText(subject, mail.getSubject());
        writeText(message, mail.getMessage());
        click(sendButton);
        return new HomePage(driver);
    }
}
