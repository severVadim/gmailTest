package pages;


import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.util.List;


public class BasePage {

    protected WebDriver driver;
    private final int WAIT_TIME = 10;

    public BasePage(WebDriver driver) {
        this.driver = driver;
    }


    public WebElement waitVisibility(By locator, int time) {
        WebDriverWait wait = new WebDriverWait(driver, time);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public WebElement waitVisibility(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        return wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public WebElement waitToBeClickable(By locator) {
        WebDriverWait wait = new WebDriverWait(driver, WAIT_TIME);
        return wait.until(ExpectedConditions.elementToBeClickable(locator));
    }

    public void click(WebElement element) {
        waitToBeClickable(element);
        element.click();
    }

    public void click(By locator){
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        waitToBeClickable(locator).click();
    }

    public void rightClick(By locator) {
        waitToBeClickable(locator);
        Actions actions = new Actions(driver);
        actions.contextClick(driver.findElement(locator)).perform();
    }

    public void writeText(By locator, String text) {
        WebElement element = waitVisibility(locator);
        element.clear();
        element.sendKeys(text);
    }

    public void verifyTextExistence(String text) {
        List<WebElement> list = driver.findElements(By.xpath(String.format("//*[contains(text(),'%s')]", text)));
        Assert.assertTrue(list.size() > 0);
    }
}