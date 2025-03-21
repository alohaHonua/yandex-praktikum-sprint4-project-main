package order;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.BaseSteps;
import ru.yandex.praktikum.MainPageYandexScooter;
import ru.yandex.praktikum.OrderPageYandexScooter;

public class orderForm {

    private WebDriver driver;

    @Test
    public void orderFromHeader() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Закрыть поп-ап с куками
        BaseSteps baseSteps = new BaseSteps(driver);
        baseSteps.clickAcceptCookiesButton();

        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);

        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();

        OrderPageYandexScooter orderPage = new OrderPageYandexScooter(driver);

        orderPage.waitForLoadHeader();

        orderPage.fillName("Марта");
        orderPage.fillSurname("Шишкина");
        orderPage.fillAddress("Проспект Андропова, 18 к3");
        orderPage.fillMetro("Технопарк");
        orderPage.clickListItemByIndex(0);
        orderPage.fillPhoneNumber("79119095094");
        orderPage.clickNextButton();
        orderPage.waitForLoadHeaderDetails();

        orderPage.chooseOrderDate("01.04.2025");
        orderPage.chooseOrderTime(4);
        orderPage.chooseScooterColor(1);
        orderPage.clickOrderButton();

        orderPage.waitForConfirmationModal();
        orderPage.clickConfirmOrderButton();

        orderPage.waitForOrderBecomeCompleted("Заказ оформлен");

    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
