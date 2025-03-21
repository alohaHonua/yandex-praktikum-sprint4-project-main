package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class OrderPageYandexScooter {
    private WebDriver driver;

    //Заголовок на 1 странице оформления заказа
    private By orderHeader = By.xpath(".//div[contains(@class, 'Order_Header')]");
    //Поле ввода имени
    private By inputName = By.xpath(".//input[contains(@placeholder, 'Имя')]");
    //Поле ввода фамилии
    private By inputSurname = By.xpath(".//input[contains(@placeholder, 'Фамилия')]");
    //Поле ввода адреса
    private By inputAddress = By.xpath(".//input[contains(@placeholder, 'Адрес')]");

    //Поле ввода станции метро
    private By inputMetro = By.xpath(".//input[contains(@placeholder, 'Станция метро')]");

    //Список станций
    private By stationsList = By.xpath(".//li/button");

    //Поле ввода телефона
    private By inputPhoneNumber = By.xpath(".//input[contains(@placeholder, 'Телефон')]");

    //Кнопка "далее"
    private By buttonNext = By.xpath(".//button[text() = 'Далее']");

    //Заголовок на 2 странице оформления заказа
    private By orderHeaderDetails = By.xpath(".//div[text()='Про аренду']");

    //Поле ввода даты заказа
    private By inputOrderDate = By.xpath(".//input[contains(@placeholder, 'Когда')]");

    //Поле ввода срока заказа
    private By inputOrderTime = By.xpath(".//div[contains(text(), 'Срок')]");

    //Цвет самоката
    private By scooterColor = By.xpath("//input[@type = 'checkbox']");

    //Выбранная в календаре дата
    private By datePickerSelectedDate = By.xpath(".//div[contains(@class, 'datepicker__day--selected')]");

    //Выпадающий список в поле срок аренды
    private By orderTimeList = By.xpath(".//div[@class = 'Dropdown-option']");

    //Кнопка Заказать под формой заказа
    private By orderButtonContent = By.xpath(".//div[contains(@class, 'Content')]//button[text() = 'Заказать']");

    //Подтверждение заказа - Кнопка Да
    private By confirmOrderButton = By.xpath(".//div[contains(@class, 'Order_Modal')]//button[text() = 'Да']");

    //Заголовок "заказ оформлен"
    private By orderCompleted = By.xpath(".//div[contains(@class, 'Order_Modal')]/div[text()='Заказ оформлен']");

    // Конструктор класса
    public OrderPageYandexScooter(WebDriver driver) {
        this.driver = driver;
    }

    // Метод ожидания загрузки страницы
    public void waitForLoadHeader() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderHeader));
    }

    public void waitForLoadHeaderDetails() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(orderHeaderDetails));
    }

    public void waitForConfirmationModal() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(confirmOrderButton));
    }

    public void waitForOrderBecomeCompleted(String text){
        new WebDriverWait(driver,3)
                .until(ExpectedConditions.textToBePresentInElementLocated(orderCompleted, text));
    }



    // Методы заполнения текстовых полей
    public void fillName(String text) {
        driver.findElement(inputName).sendKeys(text);
    }

    public void fillSurname(String text) {
        driver.findElement(inputSurname).sendKeys(text);
    }

    public void fillAddress(String text) {
        driver.findElement(inputAddress).sendKeys(text);
    }

    public void fillMetro(String text) {
        driver.findElement(inputMetro).sendKeys(text);
    }

    public void fillPhoneNumber(String text) {
        driver.findElement(inputPhoneNumber).sendKeys(text);
    }

    // Метод выбора из выпадающего списка по индексу
    public void clickListItemByIndex(int num) {
        List<WebElement> elements = driver.findElements(stationsList);
        elements.get(num).click();
    }

    // Метод нажатия на кнопку Далее
    public void clickNextButton() {
        driver.findElement(buttonNext).click();
    }

    // Метод нажатия на кнопку Заказать
    public void clickOrderButton() {
        driver.findElement(orderButtonContent).click();
    }

    // Метод нажатия на кнопку подтвердить
    public void clickConfirmOrderButton() {
        driver.findElement(confirmOrderButton).click();
    }

    //Метод заполнения даты заказа с выбором из календаря
    public void chooseOrderDate(String text) {
        driver.findElement(inputOrderDate).sendKeys(text);
        driver.findElement(datePickerSelectedDate).click();
    }

    //Метод выбора срока заказа из выпадающего списка по индексу
    public void chooseOrderTime(int num) {
        driver.findElement(inputOrderTime).click();
        List<WebElement> elements = driver.findElements(orderTimeList);
        elements.get(num).click();
    }

    //Метод выбора цвета самоката по индексу
    public void chooseScooterColor(int num) {
        List<WebElement> elements = driver.findElements(scooterColor);
        elements.get(num).click();
    }

}
