package pages;

import driverFactory.Driver;
import io.qameta.allure.Step;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PlayList {

    private Driver driver;
   FluentWait wait;





    By firstMoreOptions = By.xpath("(//button[@data-testid=\"more-button\"])[2]");
    By addToPlayListButton = By.xpath("(//button[@class=\"mWj8N7D_OlsbDgtQx5GW\"])[1]");
    By newPlayList = By.xpath("(//li[@class=\"rQ6LXqVlEOGZdGIG0LgP\"])[2]");
    By searchForASongField = By.xpath("//input[@data-encore-id=\"text\"]");
    By addTamallyMaakButton = By.xpath("(//button[@data-testid=\"add-to-playlist-button\"])[1]");
    By addWayahButton = By.xpath("(//button[@data-testid=\"add-to-playlist-button\"])[3]");
    By playMyPlaylist = By.xpath("(//button[@data-testid=\"play-button\"])[1]");
    By closeButton =  By.xpath("(//button[@aria-label=\"Close\"])[2]");


    public PlayList(Driver driver) {
        this.driver = driver;
        wait = new WebDriverWait(this.driver.get(), Duration.ofSeconds(30));
    }

    @Step("Click on more options")
    public PlayList clickOnMoreOptions() {
        driver.element().hoverOnItem(firstMoreOptions);
        driver.element().click(firstMoreOptions);
        return this;
    }

    @Step("Click on Add To PlayList")
    public PlayList clickOnAddToPlayList() {
        driver.element().hoverOnItem(addToPlayListButton);
        driver.element().click(addToPlayListButton);
        return this;
    }

    @Step("Click on New playlist button")
    public PlayList clickOnNewPlaylistButton() {
        driver.element().hoverOnItem(newPlayList);
        driver.element().click(newPlayList);
        return this;
    }

    @Step("Check that user can fill Search filed")
    public PlayList fillFieldSearchForASong() {
        driver.browser().scrollToBottom();
        driver.element().fillField(searchForASongField, "Tamally Maak");
        return this;
    }

    @Step("Click on Add Tamally Maak song button")
    public PlayList clickOnTamallyMaakAddButton() {
        driver.element().isDisplayed(addTamallyMaakButton);
        driver.element().click(addTamallyMaakButton);
        return this;
    }

    @Step("Click on Add Wayah song button")
    public PlayList clickOnWayahAddButton() {
        driver.element().isDisplayed(addWayahButton);
        driver.element().click(addWayahButton);
        return this;
    }

    @Step("Click on play MyPlaylist")
    public PlayList clickOnPlayMyPlaylist() {
        driver.element().hoverOnItem(playMyPlaylist);
//        driver.element().isDisplayed(playMyPlaylist);
//        driver.element().click(playMyPlaylist);
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(60));
        return this;
    }

    public PlayList clickOnCloseButton(){
        driver.element().click(closeButton);
        return this;
    }
}
