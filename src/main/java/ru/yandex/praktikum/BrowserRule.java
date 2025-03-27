package ru.yandex.praktikum;
import org.junit.rules.ExternalResource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserRule extends ExternalResource {

    private WebDriver driver;

    private final By acceptCookiesButton = By.id("rcc-confirm-button");
    private final static String SCOOTER_URL = "https://qa-scooter.praktikum-services.ru/";


    protected void before() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(SCOOTER_URL);
        driver.findElement(acceptCookiesButton).click();
    }

    protected void after() {
        driver.quit();
    }

    public WebDriver getWebDriver() {
        return driver;
    }
}
