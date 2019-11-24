package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPage extends BasePage {

    public LoginPage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//input[@aria-label='Телефон или адрес эл. почты']")
    WebElement emailOrPhone;

    @FindBy(xpath = "//input[@aria-label='Введите пароль']")
    WebElement password;

    @FindBy(xpath = "//span[text()='Далее']/ancestor::div[@role='button']")
    WebElement nextButton;

    public HomePage loginIntoGmail(String userName, String userPassword) {
        writeText(emailOrPhone, userName);
        click(nextButton);
        writeText(password, userPassword);
        click(nextButton);
        waitVisibility(By.xpath(String.format("//a[@aria-label='Аккаунт Google: %s']", userName)), 60);
        return new HomePage(driver);
    }
}
