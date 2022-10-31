package selenium.pom.testClasses;

import org.testng.annotations.Test;
import selenium.pom.base.BaseTest;
import selenium.pom.pages.MainPage;

public class runAllTestsScenarios extends BaseTest {

    @Test
    public void testScenario_1_Register_User() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.loadPage()
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
        MainPage mainPage = new MainPage(driver);
        mainPage.loadPage()
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
        MainPage mainPage = new MainPage(driver);
        mainPage.loadPage()
                .isOnHomePage()
                .clickSignupLoginButton()
                .setVerifyLoginYourAccount()
                .enterFakeNameAndEmailAddress()
                .clickLoginButton()
                .incorrectEmailAndPassword();
    }

    @Test
    public void testScenarioCase_4_Logout_User() {
        MainPage mainPage = new MainPage(driver);
        mainPage.loadPage()
                .isOnHomePage()
                .clickSignupLoginButton()
                .setVerifyLoginYourAccount()
                .enterCorrectEmailAndPassword()
                .clickLoginButton()
                .clickLogout()
                .setVerifyLoginYourAccount();
    }

    @Test
    public void testScenarioCase_5_Register_User_With_Existing_Email() {
        MainPage mainPage = new MainPage(driver);
        mainPage.loadPage()
                .isOnHomePage()
                .clickSignupLoginButton()
                .enterAlreadyExist()
                .clickSignUpButton()
                .verifyAlreadyExist();
    }

    @Test
    public void testScenarioCase_6_Contact_Us_Form() throws InterruptedException {
        MainPage mainPage = new MainPage(driver);
        mainPage.loadPage()
                .isOnHomePage()
                .clickContactUsIcon()
                .enterFillForm()
                .clickOKButton()
                .verifySuccessMessage()
                .backToHomePageButton();
    }

    @Test
    public void testScenarioCase_7_Verify_Test_Cases_Page() {
        MainPage mainPage = new MainPage(driver);
        mainPage.loadPage()
                .isOnHomePage()
                .clickTestCaseIcon()
                .isOnTestCasePage();
    }

}
