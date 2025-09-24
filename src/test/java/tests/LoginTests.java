package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.LoginPage;
import utils.DataProviders;
import utils.DriverManager;

import java.net.MalformedURLException;

public class LoginTests extends DriverManager {
    private LoginPage loginPage;

    @BeforeMethod
    public void setUp() throws MalformedURLException {
        DriverManager.initializeDriver();
        loginPage = new LoginPage();
    }

    @AfterMethod
    public void tearDown() {
        DriverManager.quitDriver();
    }

    @Test(dataProvider = "languages", dataProviderClass = DataProviders.class)
    public void login_with_empty_fields(String language) {
        loginPage
                .Denying_Notifications()
                .Choosing_language_and_closing_bottom_sheet(language)
                .Tap_finish_button_times(4)
                .Tap_login_button()
                .Assert_that_Username_error_exists()
                .Assert_that_password_error_exists();
    }

    @Test(dataProvider = "languages", dataProviderClass = DataProviders.class)
    public void loginWithEmptyUsernameField(String language) {
        loginPage
                .Denying_Notifications()
                .Choosing_language_and_closing_bottom_sheet(language)
                .Tap_skip_carousel_button(language)
                .Tap_finish_button_times(1)
                .Input_password("123")
                .Tap_login_button()
                .Assert_that_Username_error_exists()
                .Assert_that_password_error_does_not_exist();
    }

    @Test(dataProvider = "languages", dataProviderClass = DataProviders.class)
    public void loginWithEmptyPasswordField(String language) {
        loginPage
                .Denying_Notifications()
                .Choosing_language_and_closing_bottom_sheet(language)
                .Tap_skip_carousel_button(language)
                .Tap_finish_button_times(1)
                .Input_username("Saba")
                .Tap_login_button()
                .Assert_that_password_error_exists()
                .Assert_that_username_error_does_not_exist();
    }
}
