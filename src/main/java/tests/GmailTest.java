package tests;


import objects.Mail;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;
import pages.LoginPage;
import pages.MailPage;
import utils.Utils;

public class GmailTest extends TestBase {

    @Test (priority = 1)
    public void loginIntoGmail() {
        LoginPage loginPage = new LoginPage(driver);
        loginPage.loginIntoGmail(Utils.getProperty("userName"), Utils.getProperty("userPassword"));
    }

    @Test (priority = 2)
    public void sendEmailToOneself() {
        HomePage homePage = new HomePage(driver);
        Mail mail = Utils.convertJsonToMail();
        homePage.initiateEmailCreation()
                .createNewMail(mail)
                .openEmail(Utils.getProperty("userName"))
                .verifyTextExistence(mail.getMessage());
    }

    @Test (priority = 3)
    public void deleteEmail() {
        String userName = Utils.getProperty("userName");
        MailPage mailPage = new MailPage(driver);
        Assert.assertFalse(mailPage.backToHomePage()
                .deleteMail(userName)
                .emailIsExist(userName));
    }
}
