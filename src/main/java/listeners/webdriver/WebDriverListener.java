package listeners.webdriver;

import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

public class WebDriverListener implements org.openqa.selenium.support.events.WebDriverListener {

    private WebDriver driver;


    public WebDriverListener(WebDriver driver){
        this.driver=driver;
    }



    /************************************* Browser Actions Listeners ******************************************/

    @Override
    public void afterGet(WebDriver driver, String url) {
        System.out.println("Getting to \"" + url + "\".");
    }
//    @Override
//    public void afterGetCurrentUrl(String result, WebDriver driver) {
//        System.out.println("Current url is: \"" + result + "\".");
//    }

    @Override
    public void afterGetTitle(WebDriver driver, String result) {
        System.out.println("Current Page Title is: \"" + result + "\".");
    }

    @Override
    public void afterTo(WebDriver.Navigation navigation, String url) {
        System.out.println("Navigating to url \"" + url + "\".");
    }

    @Override
    public void afterBack(WebDriver.Navigation navigation) {
        System.out.println("Navigating back.");
    }

    @Override
    public void afterForward(WebDriver.Navigation navigation) {
        System.out.println("Navigating forward.");
    }

    @Override
    public void afterRefresh(WebDriver.Navigation navigation) {
        System.out.println("Refreshing current page......");
    }

    @Override
    public void afterGetPageSource(WebDriver driver, String result) {
        System.out.println("Getting Page source: " + result);
    }

    @Override
    public void beforeDeleteCookie(WebDriver.Options options, Cookie cookie) {
        System.out.println("Deleting Cookie: " + cookie + " ......");
    }

    @Override
    public void beforeDeleteAllCookies(WebDriver.Options options) {
        System.out.println("Deleting All Cookies.....");
    }


    /************************************* Element Actions Listeners ******************************************/

//Global wait
    @Override
    public void beforeFindElement(WebDriver driver, By locator) {
        try {
            new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(30))
                    .pollingEvery(Duration.ofMillis(500))
                    .ignoring(NoSuchElementException.class)
                    .ignoring(StaleElementReferenceException.class)
                    .until(ExpectedConditions.visibilityOfElementLocated(locator));
        } catch (TimeoutException timeoutException) {
            // In case the element was not found / not visible and the timeout expired
            System.out.println(timeoutException.getMessage() + " || "
                    + timeoutException.getCause()
                    .getMessage().substring(0, timeoutException.getCause().getMessage().indexOf("\n")));
            throw timeoutException;
        }

    }

    @Override
    public void afterClose(WebDriver driver) {
        System.out.println("Successfully Closed Driver.");
    }

    @Override
    public void afterQuit(WebDriver driver) {
        System.out.println("Successfully Quit Driver.");
    }

    // WebElement

    @Override
    public void beforeClick(WebElement element) {
        System.out.println("Wait for " + getElementName(element) + " to be clickable");

        try {
            new WebDriverWait(this.driver,
                    Duration.ofSeconds(30))
                    .until(ExpectedConditions.elementToBeClickable(element));
        } catch (TimeoutException timeoutException) {
            System.out.println(timeoutException);
            throw timeoutException;
        }

        try {
            System.out.println("Click on " + getElementName(element) + ".");
        } catch (Exception throwable) {
            System.out.println("Click.");
        }
    }

    @Override
    public void beforeSubmit(WebElement element) {
        try {
            System.out.println("Submit " + getElementName(element) + ".");
        } catch (Exception throwable) {
            System.out.println("Submit.");
        }
    }

    @Override
    public void beforeSendKeys(WebElement element, CharSequence... keysToSend) {
//        StringBuilder stringBuilder = new StringBuilder();
//        Arrays.stream(keysToSend).toList().forEach(stringBuilder::append);
        try {
            System.out.println("Type \"" + keysToSend + "\" into " + getElementName(element) + ".");
        } catch (Exception throwable) {
            System.out.println("Type \"" + keysToSend + "\".");
        }
    }

    @Override
    public void beforeClear(WebElement element) {
        System.out.println("Clear " + getElementName(element) + ".");
    }

    @Override
    public void afterGetAttribute(WebElement element, String name, String result) {
        try {
            System.out.println("Get Attribute \"" + name + "\" from " + getElementName(element) + ", value is \"" + result + "\".");
        } catch (Exception throwable) {
            System.out.println("Get Attribute \"" + name + "\", value is \"" + result + "\".");
        }
    }

    @Override
    public void afterGetText(WebElement element, String result) {
        try {
            System.out.println("Get Text from " + getElementName(element) + ", text is \"" + result + "\".");
        } catch (Exception throwable) {
            System.out.println("Get Text, text is :\"" + result + "\".");
        }
    }


    // Alert

    @Override
    public void beforeSendKeys(Alert alert, String text) {
        System.out.println("Type \"" + text + "\" into Alert.");
    }


    private String getElementName(WebElement element) {
        String accessibleName = element.getAccessibleName();
        if ("".equals(accessibleName)) {
            return "element";
        } else {
            return "\"" + accessibleName + "\"";
        }
    }





















}
