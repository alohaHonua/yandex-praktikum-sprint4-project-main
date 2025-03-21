package order;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.BaseSteps;
import ru.yandex.praktikum.MainPageYandexScooter;
import ru.yandex.praktikum.OrderPageYandexScooter;

@RunWith(Parameterized.class)

public class OrderForm {

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;
    private final String date;
    private final int time;
    private final int color;

    public OrderForm(String name, String surname, String address, String metro, String phone, String date, int time, int color) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
        this.date = date;
        this.time = time;
        this.color = color;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionsAndAnswers() {
        return new Object[][]{
                {"Фёдор", "Достаевский", "обл Мурманская, г. Полярный, ул Сивко, д. 144", "Достоевская", "89506240001", "28.03.2025",1,1},
                {"Эрнесто", "де ла Крус", "планета Земля", "Арбат", "+79109875411", "12.12.2025",6,1},
                {"Марта", "Шишкина", "Проспект Андропова, 18 к3", "Технопарк", "79119095094", "07.07.2025",3,0},
        };
    }

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

        orderPage.fillName(name);
        orderPage.fillSurname(surname);
        orderPage.fillAddress(address);
        orderPage.fillMetro(metro);
        orderPage.clickListItemByIndex(0);
        orderPage.fillPhoneNumber(phone);
        orderPage.clickNextButton();
        orderPage.waitForLoadHeaderDetails();

        orderPage.chooseOrderDate(date);
        orderPage.chooseOrderTime(time);
        orderPage.chooseScooterColor(color);
        orderPage.clickOrderButton();

        orderPage.waitForConfirmationModal();
        orderPage.clickConfirmOrderButton();

        orderPage.waitForOrderBecomeCompleted("Заказ оформлен");
    }

    @Test
    public void orderFromBody() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Закрыть поп-ап с куками
        BaseSteps baseSteps = new BaseSteps(driver);
        baseSteps.clickAcceptCookiesButton();

        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);

        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonBody();

        OrderPageYandexScooter orderPage = new OrderPageYandexScooter(driver);

        orderPage.waitForLoadHeader();

        orderPage.fillName(name);
        orderPage.fillSurname(surname);
        orderPage.fillAddress(address);
        orderPage.fillMetro(metro);
        orderPage.clickListItemByIndex(0);
        orderPage.fillPhoneNumber(phone);
        orderPage.clickNextButton();
        orderPage.waitForLoadHeaderDetails();

        orderPage.chooseOrderDate(date);
        orderPage.chooseOrderTime(time);
        orderPage.chooseScooterColor(color);
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
