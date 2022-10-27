package selenium.pom.testClasses;

import org.testng.annotations.Test;
import selenium.pom.base.BaseTest;
import selenium.pom.pages.HomePage;

public class runAllTestsScenario extends BaseTest {

    @Test
    public void testScenario_1_Register_User() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.loadPage()
                .isOnHomePage()
                .clickSignupLoginButton()
                .verifyUserSignUp()
                .enterNameAndEmailAddress()
                .clickSignUpButton()
                .verifyAccountInformation()
                .fillDetailsForm()
                .verifyCreatedAccount()
                .clickContinueButton()
                .setDeleteAccount()
                .verifyAccountDeleted();
    }

    @Test
    public void testScenario_2_Login_User_With_Correct_Email_And_Password() {
        HomePage homePage = new HomePage(driver);
        homePage.loadPage()
                .isOnHomePage()
                .clickSignupLoginButton()
                .setVerifyLoginYourAccount()
                .enterCorrectEmailAndPassword()
                .clickLoginButton();
        //homePage.setDeleteAccount();
        //homePage.verifyAccountDeleted();
    }

    @Test
    public void testScenario_3_Login_User_With_Incorrect_Email_And_Password() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        homePage.loadPage()
                .isOnHomePage()
                .clickSignupLoginButton()
                .setVerifyLoginYourAccount()
                .enterFakeNameAndEmailAddress()
                .clickLoginButton()
                .incorrectEmailAndPassword();
    }

    @Test
    public void testScenarioCase_4_Logout_User() {
        HomePage homePage = new HomePage(driver);
        homePage.loadPage()
                .isOnHomePage()
                .clickSignupLoginButton()
                .setVerifyLoginYourAccount()
                .enterCorrectEmailAndPassword()
                .clickLoginButton()
                .clickLogout()
                .setVerifyLoginYourAccount();
    }
}
