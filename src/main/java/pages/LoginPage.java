package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    By emailOrPhone = By.xpath("//input[@aria-label='Телефон или адрес эл. почты']");

    By password = By.xpath("//input[@aria-label='Введите пароль']");

    By nextButton = By.xpath("//span[text()='Далее']/ancestor::div[@role='button']");

    public HomePage loginIntoGmail(String userName, String userPassword) {
        writeText(emailOrPhone, userName);
        click(nextButton);
        writeText(password, userPassword);
        click(nextButton);
        waitVisibility(By.xpath(String.format("//a[@aria-label='Аккаунт Google: %s']", userName)), 60);
        return new HomePage(driver);
    }
}
