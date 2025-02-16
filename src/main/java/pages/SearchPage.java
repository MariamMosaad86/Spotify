package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SearchPage {
    private Driver driver;

    By addNewPlayList = By.xpath("(//button[@)[role=\"menuitem\"]2]");
    By selectThreeDots = By.xpath("(//button[@data-testid=\"more-button\"])[3]");
    By playASong = By.xpath("(//div/li[@role=\"listitem\"])[2]");
    By addToLikeButton = By.xpath("(//button[@data-encore-id=\"buttonTertiary\"])[26]");
    By addToPlayList = By.xpath("(//li[@role=\"presentation\"])[1]");
    By addToMyPlayList = By.xpath("(//button[@role=\"menuitem\"])[3]");
    By selectASong = By.xpath("//a[@href=\"/track/6TYFcqqQVQPb3YsgfRhvqs\"]");
    By searchButton = By.xpath("//div[@class=\"IconContainer-sc-1oa4n9m-0 dXCfis\"]");
    By userWidgetLink = By.xpath("//button[@data-testid=\"user-widget-link\"]");
    By logoutButton = By.xpath("//button[@data-testid=\"user-widget-dropdown-logout\"]");

    public SearchPage(Driver driver) {
        this.driver = driver;
    }

    @Step("Add song to newPlayList")
    public SearchPage addSongToNewPlaylist() {
        driver.element().isClickable(addToPlayList);
        driver.element().click(addToPlayList);
        driver.element().isClickable(addNewPlayList);
        driver.element().click(addNewPlayList);
        return this;
    }


    @Step("Play a PlayList")
    public SearchPage playPlayListSong() {
        driver.element().click(playASong);
        return this;
    }

    @Step("Add song to likeList")
    public SearchPage addSongToLikeList() {
        driver.browser().scrollToBottom();
        driver.element().click(addToLikeButton);
        return this;
    }

    @Step("Click on Three dots")
    public SearchPage clickOnThreeDots() {
        driver.element().click(selectThreeDots);
        return this;
    }

    @Step("Click on addToPlayList")
    public SearchPage clickOnAddToPlayList() {
        driver.element().click(addToPlayList);
        return this;
    }

    @Step("Click on Add To MyPlaylist")
    public SearchPage clickOnAddToMyPlayList() {
        driver.element().click(addToMyPlayList);
        return this;
    }

    @Step("Click on Search Button")
    public SearchPage clickOnSearchButton() {
        driver.element().click(searchButton);
        return this;
    }

    @Step("Click on user widget")
    public SearchPage clickOnUserWidget() {
        driver.element().click(userWidgetLink);
        return this;
    }

    @Step("Click on logout button")
    public HomePage clickOnLogoutButton() {
        driver.element().click(logoutButton);
        return new HomePage(driver);
    }



}
