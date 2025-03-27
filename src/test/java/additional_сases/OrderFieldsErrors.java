package additional_сases;

import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.BaseSteps;
import ru.yandex.praktikum.MainPageYandexScooter;
import ru.yandex.praktikum.OrderPageYandexScooter;
import static org.testng.AssertJUnit.assertEquals;

@RunWith(Parameterized.class)
public class OrderFieldsErrors extends BaseSteps {

    public OrderFieldsErrors(String name, String surname, String address, String metro, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;

    }

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;

    @Parameterized.Parameters
    public static Object[][] getQuestionsAndAnswers() {
        return new Object[][]{
                {"Anna", "Karenina", "Moscow city, Lenina street, house 1", "x1s5x", "1010"},
                {"Пётр 1", "Император всероссийский", "Г.МОСКВА, МУНИЦИПАЛЬНЫЙ ОКРУГ ПРЕСНЕНСКИЙ, УЛ ЛИТВИНА-СЕДОГО, Д. 2/13, К. В, СТР. 1, ПОМЕЩ. 1Ц", "Петра 1", "один два три четыре"},
        };
    }
    private WebDriver driver;

    @Test
    public void checkErrorMessageForNameField() {
        driver = getDriver();
        clickAcceptCookiesButton(driver);

        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);

        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();

        OrderPageYandexScooter orderPage = new OrderPageYandexScooter(driver);

        orderPage.waitForLoadHeader();
        orderPage.fillName(name);
        orderPage.clickNextButton();
        assertEquals("Введите корректное имя", orderPage.getNameFieldError());
}

    @Test
    public void checkErrorMessageForSurnameField() {
        driver = getDriver();
        clickAcceptCookiesButton(driver);

        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);

        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();

        OrderPageYandexScooter orderPage = new OrderPageYandexScooter(driver);

        orderPage.waitForLoadHeader();
        orderPage.fillSurname(surname);
        orderPage.clickNextButton();
        assertEquals("Введите корректную фамилию", orderPage.getSurnameFieldError());
    }

    @Test
    public void checkErrorMessageForAddressField() {
        driver = getDriver();
        clickAcceptCookiesButton(driver);

        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);

        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();

        OrderPageYandexScooter orderPage = new OrderPageYandexScooter(driver);

        orderPage.waitForLoadHeader();
        orderPage.fillAddress(address);
        orderPage.clickNextButton();
        assertEquals("Введите корректный адрес", orderPage.getAddressFieldError());
    }

    @Test
    public void checkErrorMessageForMetroStationField() {
        driver = getDriver();
        clickAcceptCookiesButton(driver);

        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);

        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();

        OrderPageYandexScooter orderPage = new OrderPageYandexScooter(driver);

        orderPage.waitForLoadHeader();
        orderPage.fillMetro(metro);
        orderPage.clickNextButton();
        assertEquals("Выберите станцию", orderPage.getMetroFieldError());
    }

    @Test
    public void checkErrorMessageForPhoneNumberField() {
        driver = getDriver();
        clickAcceptCookiesButton(driver);

        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);

        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();

        OrderPageYandexScooter orderPage = new OrderPageYandexScooter(driver);

        orderPage.waitForLoadHeader();
        orderPage.fillPhoneNumber(phone);
        orderPage.clickNextButton();
        assertEquals("Введите корректный номер", orderPage.getPhoneFieldError());
    }

    @After
public void tearDown() {
    closeBrowser(driver);
}
}
