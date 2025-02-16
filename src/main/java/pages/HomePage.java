package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.testng.Assert;


public class HomePage {
    private Driver driver;


    By signUpButton = By.xpath("//button[@data-testid=\"signup-button\"]");
    By loginButton = By.xpath("//button[@data-testid=\"login-button\"]");
    By userWidgetLink = By.xpath("//button[@data-testid=\"user-widget-link\"]");
    By logoutButton = By.xpath("//button[@data-testid=\"user-widget-dropdown-logout\"]");
    By searchFiled = By.xpath("//input[@aria-owns=\"recent-searches-dropdown\"]");
    By plusButton = By.xpath("(//button[@data-encore-id=\"buttonTertiary\"])[7]");
    By createPlayList = By.xpath("(//button[@data-encore-id=\"buttonPrimary\"])[2]");


    public HomePage(Driver driver) {
        this.driver = driver;
    }

    /*********************************  Assertions  *****************************************************/

    @Step("Check that Home Page is loaded successfully")
    public HomePage checkThatHomePageIsLoadedSuccessfully() {
        Assert.assertEquals(driver.browser().getCurrentURL(), "https://open.spotify.com/");
        return this;
    }

    @Step("Check that the signup link is displayed")
    public HomePage checkSignupLinkExistOnTheHomePage() {
        Assert.assertTrue(driver.element().isDisplayed(signUpButton));
        return this;
    }


    @Step("Check that login link is displayed")
    public HomePage checkLoginLinkIsExistOnTheHomePage() {
        Assert.assertTrue(driver.element().isDisplayed(loginButton));
        return this;
    }

    /*********************************  Actions  *****************************************************/


    @Step("Check that the user can open user widget dropdown menu")
    public HomePage checkThatTheUserCanOpenUserWidget() {
        driver.element().isClickable(userWidgetLink);
        driver.element().click(userWidgetLink);
        return this;
    }

    @Step("Check that the user can logout after signup")
    public HomePage checkThatTheUserCanLogout() {
        driver.element().click(logoutButton);
        return this;
    }

    @Step("Check that the user is navigated to signup page upon clicking on signup button on the Home page")
    public SignupPage checkThatTheUserCanNavigateToTheSignupPage() {
        driver.element().click(signUpButton);
        return new SignupPage(driver);
    }

    @Step("Check that the use can navigate to Login Page")
    public LoginPage checkThatTheUseCanNavigateToLoginPage() {
        driver.element().click(loginButton);
        return new LoginPage(driver);
    }

    @Step("Click on plus Button")
    public HomePage clickOnPlusButton() {
        driver.element().click(plusButton);
        return this;
    }


    @Step("Search for singer")
    public SearchPage searchForASinger() {
        driver.element().fillField(searchFiled, "Amr Diab");
        return new SearchPage(driver);
    }


    @Step("Click on create playlist")
    public PlayList clickOnCreatePlayList() {
        driver.element().isClickable(createPlayList);
        driver.element().click(createPlayList);
        return new PlayList(driver);

    }

}
