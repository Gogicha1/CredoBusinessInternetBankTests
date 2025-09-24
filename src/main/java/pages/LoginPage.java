package pages;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import utils.CommonSteps;

import static org.testng.Assert.assertTrue;
import static org.testng.AssertJUnit.assertEquals;
import static utils.Constants.errorTexts;
import static utils.Constants.skipBtnTexts;

public class LoginPage extends CommonSteps {
    public LoginPage(AppiumDriver driver) {
        super(driver);
    }

    private String currentLanguage;

    private final By denyBtnLocator = AppiumBy.id("com.android.permissioncontroller:id/permission_deny_button");
    private final By finishButton = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"finishButton\")");
    private final By nameInputLocator = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"usernameInput\")");
    private final By passwordInputLocator = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"passwordInput\")");
    private final By loginBtnLocator = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"loginButton\")");
    private final By usernameErrorTextLocator = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"usernameErrorText\")");
    private final By passwordErrorTextLocator = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"passwordErrorText\")");
    private final By languageBtnLocator = AppiumBy.androidUIAutomator("new UiSelector().text(\"KA\")");
    private final By closeBtnLocator = AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"closeButton\")");
    private By languageSelectorLocator(String language) {
        return AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"" + language + "LanguageButton\")");
    }
    private By skipBtnLocatorByLanguage(String language) {
        return  AppiumBy.androidUIAutomator("new UiSelector().text(\"" + language + "\")");
    }

    @Given("Denying Notifications")
    public LoginPage tapDenyNotificationsBtn() {
        WebElement denyBtn = waitForVisibilityOfElement(denyBtnLocator);
        denyBtn.click();
        return this;
    }

    @When("Tap {string} skip carousel button")
    public LoginPage tapSkipBtn(String language) {
        this.currentLanguage = language;
        WebElement skipBtn = waitForVisibilityOfElement(skipBtnLocatorByLanguage(skipBtnTexts.get(language)));
        skipBtn.click();
        return this;
    }

    @When("Tap finish button {int} times")
    public LoginPage tapFinishBtn(int times) {
        for(int i = 0; i < times; i++) {
            WebElement finishBtn = waitForClickableElement(finishButton);
            finishBtn.click();
        }
        return this;
    }

    @When("Input username {string}")
    public LoginPage inputUserName(String userName) {
        WebElement userNameInput = waitForVisibilityOfElement(nameInputLocator);
        userNameInput.sendKeys(userName);
        return this;
    }

    @When("Input password {string}")
    public LoginPage inputPassword(String password) {
        WebElement passwordInput = waitForVisibilityOfElement(passwordInputLocator);
        passwordInput.sendKeys(password);
        return this;
    }

    @When("Tap login button")
    public LoginPage tapLoginBtn() {
        WebElement loginBtn = waitForVisibilityOfElement(loginBtnLocator);
        loginBtn.click();
        return this;
    }

    @Then("Assert that Username error exists")
    public LoginPage assertUserNameError() {
        WebElement userNameErrorText = waitForVisibilityOfElement(usernameErrorTextLocator);
        Assert.assertEquals(userNameErrorText.getText(), errorTexts.get(currentLanguage));
        return this;
    }

    @Then("Assert that password error exists")
    public LoginPage assertPasswordError() {
        WebElement passwordErrorText = waitForVisibilityOfElement(passwordErrorTextLocator);
        assertEquals(passwordErrorText.getText(), errorTexts.get(currentLanguage));
        return this;
    }

    @Then("Assert that password error does not exist")
    public LoginPage assertPasswordErrorDoesntExist() {
        assertTrue(waitForElementNotExists(passwordErrorTextLocator));
        return this;
    }

    @Then("Assert that username error does not exist")
    public LoginPage assertUsernameErrorDoesntExist() {
        assertTrue(waitForElementNotExists(usernameErrorTextLocator));
        return this;
    }

    @When("Choosing {string} language and closing bottom sheet")
    public LoginPage chooseLanguage(String language) {
        this.currentLanguage = language;
        WebElement languageChangeBtn = waitForVisibilityOfElement(languageBtnLocator);
        languageChangeBtn.click();
        WebElement languageSelector = waitForVisibilityOfElement(languageSelectorLocator(language));
        languageSelector.click();
        driver.findElement(closeBtnLocator).click();
        return this;
    }
}
