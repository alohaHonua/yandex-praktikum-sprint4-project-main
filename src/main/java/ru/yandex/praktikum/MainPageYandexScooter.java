package ru.yandex.praktikum;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class MainPageYandexScooter {

    private WebDriver driver;

//Лого в хидере
    private By yandexLogo = By.xpath(".//a/img[@alt='Yandex']");

//Заголовок "Вопросы о важном"
    private By questionsHeader = By.xpath(".//div[contains(text(), 'Вопросы о важном')]");

//Список вопросов
    private By questionsList = By.xpath(".//div[@class = 'accordion__heading']");
    //private By question = By.xpath(".//div[text() = '"+ text + "']");

//Список ответов
    private By answersList = By.xpath(".//div[@class = 'accordion__heading']/../..//div//p");


    // Конструктор класса
    public MainPageYandexScooter(WebDriver driver){
        this.driver = driver;
    }

    // Метод ожидания загрузки страницы
    public void waitForLoadLogo(){
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(yandexLogo));
    }

    // Метод, который кликает на вопрос по заданному тексту
    public void clickQuestionByText(String text){
        driver.findElement(By.xpath(".//div[text() = '"+ text + "']")).click();
    }

    // Метод, который проверяет текст ответа
    public String getAnswer(String text){
        new WebDriverWait(driver, 5)
                .until(ExpectedConditions.presenceOfAllElementsLocatedBy(answersList));
        String answerText = driver.findElement(By.xpath(".//div[@class = 'accordion__heading']/../..//div//p[text()='"+ text +"']")).getText();
        return answerText;
    }

}
