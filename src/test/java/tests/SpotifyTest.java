package tests;

import driverFactory.Driver;

import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import pages.HomePage;

public class SpotifyTest {
    public Driver driver;


    @BeforeClass
    public void setUp() {
        driver = new Driver();
    }


    @Test(priority = 1)
    public void signup() {
        new HomePage(driver)
                .checkThatHomePageIsLoadedSuccessfully()
                .checkSignupLinkExistOnTheHomePage()
                .checkThatTheUserCanNavigateToTheSignupPage()
                .enterNewEmailInEmailField()
                .clickOnEmailNextButton()
                .enterPasswordInPasswordField()
                .fillUserForm()
                .clickOnUserDataNextButton()
                .clickOnFirstCheckBox()
                .clickOnSecondCheckBox()
                .clickOnSignupButton()
                .searchForASinger()
                .clickOnSearchButton()
                .clickOnUserWidget()
                .clickOnLogoutButton();

    }

    @Test(priority = 2, dependsOnMethods = "signup")
    public void login() {
        driver.browser().navigateToURL("https://open.spotify.com/");
        new HomePage(driver)
                .checkLoginLinkIsExistOnTheHomePage()
                .checkThatTheUseCanNavigateToLoginPage()
                .fillEmailUserNameFiled()
                .fillPasswordField()
                .checkThatUserCanLoginAfterLogout();
    }

    @Test(priority = 3, dependsOnMethods = "login")
    public void addSongsToPlayListAndPlayPlaylist() {
        new HomePage(driver)
                .clickOnCreatePlayList()
                .fillFieldSearchForASong()
                .clickOnTamallyMaakAddButton()
                .clickOnWayahAddButton()
                .clickOnPlayMyPlaylist();
    }

    @AfterClass
    public void tearDown() {
        driver.browser().deleteAllCookies();
        driver.quit();
    }

}
