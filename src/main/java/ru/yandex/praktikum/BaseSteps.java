package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BaseSteps {

    public BaseSteps(){
    }

    private final static String scooterUrl = "https://qa-scooter.praktikum-services.ru/";

    protected WebDriver getDriver() {
        WebDriver driver;
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(scooterUrl);
        return driver;
    }

    private final By acceptCookiesButton = By.id("rcc-confirm-button");

    public void clickAcceptCookiesButton(WebDriver driver){
        driver.findElement(acceptCookiesButton).click();
    }

    public void closeBrowser(WebDriver driver){
        driver.quit();
    }
}
