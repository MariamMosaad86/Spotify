package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;

public class SearchPage {
    private Driver driver;

//    By addToPlayList = By.xpath("(//div[@class=\"lQEXaOyKiOHRJAkTf1EF\"])[1]");
    By addNewPlayList = By.xpath("(//button[@)[role=\"menuitem\"]2]");
    By selectThreeDots = By.xpath("(//button[@aria-haspopup=\"menu\"])[2]");
    By playASong= By.xpath("(//div/li[@role=\"listitem\"])[2]");
    By addToLikeButton = By.xpath("(//button[@data-encore-id=\"buttonTertiary\"])[26]");
    By addToPlayList = By.xpath("(//ul/li[@role=\"presentation\"])[1]");
    By addToMyPlayList =By.xpath("(//button/span[@data-encore-id=\"type\"])[2]");
    By selectASong= By.xpath("//a[@href=\"/track/6TYFcqqQVQPb3YsgfRhvqs\"]");


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
    public SearchPage playPlayListSong(){
        driver.element().click(playASong);
        return this;
    }

    @Step("Add song to likeList")
    public SearchPage addSongToLikeList(){
        driver.browser().scrollToBottom();
        driver.element().click(addToLikeButton);
        return this;
    }

    @Step("Click on Three dots")
    public SearchPage clickOnThreeDots(){
        driver.element().click(selectThreeDots);
        driver.element().hoverOnItem(addToPlayList);
        driver.element().click(addToMyPlayList);
        return this;
    }
}
