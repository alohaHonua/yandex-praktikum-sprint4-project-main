package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class BaseSteps {

    private WebDriver driver;

    private By acceptCookiesButton = By.id("rcc-confirm-button");

    public BaseSteps(WebDriver driver){
        this.driver = driver;
    }

    public void clickAcceptCookiesButton(){
        driver.findElement(acceptCookiesButton).click();
    }
}
