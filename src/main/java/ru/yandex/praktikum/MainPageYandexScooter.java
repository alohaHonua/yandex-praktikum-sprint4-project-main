package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageYandexScooter {

    private WebDriver driver;

    //Лого яндекса в хидере
    private By yandexLogo = By.xpath(".//a/img[@alt='Yandex']");

    //Лого самоката в хидере
    private By scooterLogo = By.xpath(".//a[contains(@class, 'Header_LogoScooter')]");

    //Главная страница самоката
    private By scooterMainPage = By.xpath(".//div[contains(@class, 'HomePage')]");

    //Заголовок "Вопросы о важном"
    private By questionsHeader = By.xpath(".//div[contains(text(), 'Вопросы о важном')]");

    //Список вопросов
    private By questionsList = By.xpath(".//div[@class = 'accordion__heading']");
    //private By question = By.xpath(".//div[text() = '"+ text + "']");

    //Список ответов
    private By answersList = By.xpath(".//div[@class = 'accordion__heading']/../..//div//p");

    //Кнопка "Заказать" в хидере
    private By orderButtonHeader = By.xpath(".//div[contains(@class, 'Header')]//button[text() = 'Заказать']");

    //Кнопка "Статус заказа" в хидере
    private By trackButton = By.xpath(".//div[contains(@class, 'Header')]//button[text() = 'Статус заказа']");

    //Кнопка заказать в тексте страницы
    private By orderButtonBody = By.xpath(".//div[contains(@class, 'ThirdPart')]//button[text() = 'Заказать']");

    // Конструктор класса
    public MainPageYandexScooter(WebDriver driver) {
        this.driver = driver;
    }

    // Метод ожидания загрузки страницы
    public void waitForLoadLogo() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(yandexLogo));
    }

    // Метод, который кликает на вопрос по заданному тексту
    public void clickQuestionByText(String text) {
        driver.findElement(By.xpath(".//div[text() = '" + text + "']")).click();
    }

    // Метод, который проверяет текст ответа
    public String getAnswer(String text) {
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(answersList));
        String answerText = driver.findElement(By.xpath(".//div[@class = 'accordion__heading']/../..//div//p[text()='" + text + "']")).getText();
        return answerText;
    }

    // Метод, который нажимает кнопку "Заказать" в хидере
    public void clickOrderButtonHeader() {
        driver.findElement(orderButtonHeader).click();
    }

    // Метод, который нажимает кнопку "Заказать" в тексте
    public void clickOrderButtonBody() {
        driver.findElement(orderButtonBody).click();
    }

    // Метод, который нажимает кнопку "Статус заказа"
    public void clickTrackButton() {
        driver.findElement(trackButton).click();
    }

    // Метод клика на логотип Яндекса
    public void yandexLogoClick() {
            driver.findElement(yandexLogo).click();
        }

    // Метод клика на логотип Самоката
    public void scooterLogoClick() {
        driver.findElement(scooterLogo).click();
    }

    // Метод проверяет находимся ли мы на главной странице самоката
    public Boolean isScooterMainPage() {
        return driver.findElement(scooterMainPage).isDisplayed();
    }

}
