package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class LoginPage {
    private Driver driver;

    By emailField = By.xpath("//input[@autocomplete=\"username\"]");
    By passwordField = By.xpath("(//input[@data-encore-id=\"formInput\"])[2]");
    By loginButton = By.xpath("//button[@id=\"login-button\"]");

    public LoginPage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Actions  *****************************************************/

    @Step("Check that the user can login after logout")
    public HomePage checkThatUserCanLoginAfterLogout() {
        driver.element().click(loginButton);
        return new HomePage(driver);
    }

    @Step("Fill Email/Username filed")
    public LoginPage fillEmailUserNameFiled(){
        driver.element().fillField(emailField,TestData.FAKE_EMAIL);
        return this;
    }
    @Step("Fill password filed")
    public LoginPage fillPasswordField() {
        driver.element().fillField(passwordField, "test@spotify");
        return this;
    }

}
