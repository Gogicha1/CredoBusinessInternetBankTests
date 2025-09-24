package tests;

import base.BaseTest;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataProviders;

public class LoginTests extends BaseTest {
    LoginPage loginPage;

    @Test(dataProvider = "languages", dataProviderClass = DataProviders.class)
    public void loginWithEmptyFields(String language) {
        loginPage = new LoginPage(driver);
        loginPage
                .tapDenyNotificationsBtn()
                .chooseLanguage(language)
                .tapFinishBtn(4)
                .tapLoginBtn()
                .assertUserNameError()
                .assertPasswordError();
    }

    @Test(dataProvider = "languages", dataProviderClass = DataProviders.class)
    public void loginWithEmptyUsernameField(String language) {
        loginPage = new LoginPage(driver);
        loginPage
                .tapDenyNotificationsBtn()
                .chooseLanguage(language)
                .tapSkipBtn(language)
                .tapFinishBtn(1)
                .inputPassword("123")
                .tapLoginBtn()
                .assertUserNameError()
                .assertPasswordErrorDoesntExist();
    }

    @Test(dataProvider = "languages", dataProviderClass = DataProviders.class)
    public void loginWithEmptyPasswordField(String language) {
        loginPage = new LoginPage(driver);
        loginPage
                .tapDenyNotificationsBtn()
                .chooseLanguage(language)
                .tapSkipBtn(language)
                .tapFinishBtn(1)
                .inputUserName("Saba")
                .tapLoginBtn()
                .assertPasswordError()
                .assertUsernameErrorDoesntExist();
    }
}