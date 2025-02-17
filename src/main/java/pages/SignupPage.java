package pages;


import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;


public class SignupPage {

    private Driver driver;



    By sigUpButton = By.xpath("//footer/a[@data-encore-id=\"buttonPrimary\"]");
    By emailField = By.id("username");
    By nextEmailButton = By.cssSelector("button[data-testid='submit']");
    By passwordField = By.xpath("//*[@id=\"new-password\"]");
    By nextPasswordButton = By.cssSelector("button[data-testid='submit']");
    By nameField = By.xpath("(//input[@data-encore-id=\"formInput\"])[3]");
    By day = By.xpath("(//input[@data-encore-id=\"formInput\"])[4]");
    By month = By.xpath("//select[@data-testid=\"birthDateMonth\"]");
    By year = By.xpath("(//input[@data-encore-id=\"formInput\"])[5]");
    By womanRadioButton = By.xpath("(//span[@class=\"Indicator-sc-hjfusp-0 jRuGOG\"])[2]");
    By userDataNextButton = By.xpath("//button[@data-testid=\"submit\"]");
    By finalSignUpButton = By.xpath("//button[@data-encore-id=\"buttonPrimary\"]");
    By firstCheckBox=By.xpath("(//span[@class=\"Indicator-sc-1airx73-0 lhZnAn\"])[1]");
    By secondCheckBox = By.xpath("(//span[@class=\"Indicator-sc-1airx73-0 lhZnAn\"])[2]");



    public SignupPage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/

    @Step("Check that Signup Page is loaded successfully")
    public SignupPage checkThatSignupPageIsLoadedSuccessfully() {
        Assert.assertTrue(driver.browser().getCurrentURL().contains("/signup?"));
        return this;
    }

    @Step("Check that signup button is displayed on the signup page")
    public SignupPage checkThatSignUpButtonIsDisplayed() {
        Assert.assertTrue(driver.element().isDisplayed(sigUpButton));
        return this;
    }

    /*********************************  Actions  *****************************************************/

    @Step("Check that the user can Click on Signup button")
    public SignupPage checkThatUserCanClickOnSignUpButtonSuccessfully() {
        driver.element().click(sigUpButton);
        return this;
    }

    @Step("Check that the user should enter new email not exist in the database to signup")
    public SignupPage enterNewEmailInEmailField() {

        driver.element().fillField(emailField, TestData.FAKE_EMAIL);
        clickOnEmailNextButton();
        return this;
    }

    @Step("Click on Next button")
    public SignupPage clickOnEmailNextButton() {
        driver.element().isClickable(nextEmailButton);
        driver.element().click(nextEmailButton);
        return this;
    }

    @Step("Check that user should enter password with one letter, 1 number or special character and 10 characters and in password filed")
    public SignupPage enterPasswordInPasswordField() {
        driver.element().fillField(passwordField, "test@spotify");
        driver.element().isClickable(nextPasswordButton);
        clickOnPasswordNextButton();
        return this;
    }


    @Step("Click on Next button")
    public SignupPage clickOnPasswordNextButton() {
        driver.element().isClickable(nextPasswordButton);
        driver.element().click(nextPasswordButton);
        return this;
    }

    @Step("Fill user data")
    public SignupPage fillUserForm() {
        driver.element().fillField(nameField, "Mariam");
        driver.element().fillField(day, "4");
        driver.element().selectByIndex(month, 2);
        driver.element().fillField(year, "1980");
        driver.browser().scrollToBottom();
        driver.element().click(womanRadioButton);
        return this;
    }

    @Step("Click on Next button")
    public SignupPage clickOnUserDataNextButton() {
        driver.browser().scrollToBottom();
        driver.element().click(userDataNextButton);
        return this;
    }

    @Step("Select first checkbox")
    public SignupPage clickOnFirstCheckBox(){
        driver.element().click(firstCheckBox);
        return this;
    }

    @Step("Select second checkbox")
    public SignupPage clickOnSecondCheckBox(){
        driver.element().click(secondCheckBox);
        return this;
    }
    @Step("Click on Signup Button")
    public HomePage clickOnSignupButton() {
        driver.element().click(finalSignUpButton);
        return new HomePage(driver);
    }



}
