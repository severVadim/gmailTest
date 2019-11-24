package tests;

import driverManager.DriverManager;
import driverManager.DriverManagerFactory;
import driverManager.DriverType;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import utils.Utils;


public class TestBase {

    public DriverManager driverManager;
    public WebDriver driver;

    @BeforeClass
    public void beforeTest() throws InterruptedException {
        driverManager = DriverManagerFactory.getManager(DriverType.valueOf(Utils.getProperty("browser")));
        driver = driverManager.getDriver();
        driver.manage().window().maximize();
        driver.get(Utils.getProperty("url"));
    }

    @AfterClass
    public void afterMethod() {
        driverManager.quitDriver();
    }
}