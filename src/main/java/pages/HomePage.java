package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HomePage extends BasePage {

    public HomePage(WebDriver driver) {
        BasePage.driver = driver;
        PageFactory.initElements(driver, this);
    }

    private String emailXpath = "//span[@data-hovercard-id='%s']/ancestor::td";

    @FindBy(xpath = "//div[@role='button' and text()='Написать']")
    WebElement newMail;

    @FindBy(xpath = "//div[@role='button' and @aria-label='Удалить']")
    WebElement deleteButton;

    public MailPage openEmail(String emailFrom) {
        click(getEmailRow(emailFrom));
        waitVisibility(By.xpath("//span[@role='link' and text()='Переслать']"), 5);
        return new MailPage(driver);
    }

    public WebElement getEmailRow(String emailFrom) {
        return waitVisibility(By.xpath(String.format(emailXpath, emailFrom)), 60);
    }

    public boolean emailIsExist(String emailFrom) {
        return driver.findElements(By.xpath(String.format(emailXpath, emailFrom))).size() > 0;
    }

    public NewEmailPage initiateEmailCreation() {
        click(newMail);
        return new NewEmailPage(driver);
    }

    public HomePage deleteMail(String emailFrom) {
        rightClick(By.xpath(String.format(emailXpath, emailFrom)));
        click(deleteButton);
        waitVisibility(By.xpath("//span[text()='Цепочка помещена в корзину.']"));
        return this;
    }

}
