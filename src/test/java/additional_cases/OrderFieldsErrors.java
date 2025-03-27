package additional_cases;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import ru.yandex.praktikum.BrowserRule;
import ru.yandex.praktikum.MainPageYandexScooter;
import ru.yandex.praktikum.OrderPageYandexScooter;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class OrderFieldsErrors {

    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    private final String name;
    private final String surname;
    private final String address;
    private final String metro;
    private final String phone;

    public OrderFieldsErrors(String name, String surname, String address, String metro, String phone) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.metro = metro;
        this.phone = phone;
    }

    @Parameterized.Parameters
    public static Object[][] getQuestionsAndAnswers() {
        return new Object[][]{
                {"Anna", "Karenina", "Moscow city, Lenina street, house 1", "x1s5x", "1010"},
                {"Пётр 1", "Император всероссийский", "Г.МОСКВА, МУНИЦИПАЛЬНЫЙ ОКРУГ ПРЕСНЕНСКИЙ, УЛ ЛИТВИНА-СЕДОГО, Д. 2/13, К. В, СТР. 1, ПОМЕЩ. 1Ц", "Петра 1", "один два три четыре"},
        };
    }


    @Test
    public void checkErrorMessageForNameField() {
        MainPageYandexScooter mainPage = new MainPageYandexScooter(browserRule.getWebDriver());
        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();

        OrderPageYandexScooter orderPage = new OrderPageYandexScooter(browserRule.getWebDriver());
        orderPage.waitForLoadHeader();
        orderPage.fillName(name);
        orderPage.clickNextButton();
        assertEquals("Введите корректное имя", orderPage.getNameFieldError());
}

    @Test
    public void checkErrorMessageForSurnameField() {
        MainPageYandexScooter mainPage = new MainPageYandexScooter(browserRule.getWebDriver());
        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();

        OrderPageYandexScooter orderPage = new OrderPageYandexScooter(browserRule.getWebDriver());
        orderPage.waitForLoadHeader();
        orderPage.fillSurname(surname);
        orderPage.clickNextButton();
        assertEquals("Введите корректную фамилию", orderPage.getSurnameFieldError());
    }

    @Test
    public void checkErrorMessageForAddressField() {
        MainPageYandexScooter mainPage = new MainPageYandexScooter(browserRule.getWebDriver());
        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();

        OrderPageYandexScooter orderPage = new OrderPageYandexScooter(browserRule.getWebDriver());
        orderPage.waitForLoadHeader();
        orderPage.fillAddress(address);
        orderPage.clickNextButton();
        assertEquals("Введите корректный адрес", orderPage.getAddressFieldError());
    }

    @Test
    public void checkErrorMessageForMetroStationField() {
        MainPageYandexScooter mainPage = new MainPageYandexScooter(browserRule.getWebDriver());
        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();

        OrderPageYandexScooter orderPage = new OrderPageYandexScooter(browserRule.getWebDriver());
        orderPage.waitForLoadHeader();
        orderPage.fillMetro(metro);
        orderPage.clickNextButton();
        assertEquals("Выберите станцию", orderPage.getMetroFieldError());
    }

    @Test
    public void checkErrorMessageForPhoneNumberField() {
        MainPageYandexScooter mainPage = new MainPageYandexScooter(browserRule.getWebDriver());
        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();

        OrderPageYandexScooter orderPage = new OrderPageYandexScooter(browserRule.getWebDriver());
        orderPage.waitForLoadHeader();
        orderPage.fillPhoneNumber(phone);
        orderPage.clickNextButton();
        assertEquals("Введите корректный номер", orderPage.getPhoneFieldError());
    }

}
