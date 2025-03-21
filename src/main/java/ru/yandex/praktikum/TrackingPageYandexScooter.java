package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class TrackingPageYandexScooter {
    private WebDriver driver;

    //Поле ввода номера заказа
    private By trackNumberInputField = By.xpath(".//input[@placeholder = 'Введите номер заказа']");

    //Кнопка начать поиск
    private By buttonSearchTrackingInfo = By.xpath(".//button[text() = 'Go!']");

    //
    private By imageTrackingInfoNotFound = By.xpath(".//img[@alt = 'Not found']");

    // Конструктор класса
    public TrackingPageYandexScooter(WebDriver driver) {
        this.driver = driver;
    }

    //Метод для ожидания пока появится поле для ввода номера заказа
    public void waitForLoadTrackInputField() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(trackNumberInputField));
    }

    //Метод для ввода номера заказа

    public void inputTrackNumber(String number){
        driver.findElement(trackNumberInputField).sendKeys(number);
    }

    //Метод нажатия на кнопку Go
    public void clickSearchTrackingInfoButton(){
        driver.findElement(buttonSearchTrackingInfo).click();
    }

    //Метод ожидания появления картинки
    public void waitForImageTrackNotFound(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(imageTrackingInfoNotFound));
    }
}
