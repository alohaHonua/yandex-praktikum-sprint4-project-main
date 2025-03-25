package additionalCases;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.testng.AssertJUnit;
import ru.yandex.praktikum.BaseSteps;
import ru.yandex.praktikum.MainPageYandexScooter;
import ru.yandex.praktikum.OrderPageYandexScooter;

public class DebugTest extends BaseSteps {

    public DebugTest() {
        super();
    }

    private WebDriver driver;

    @Test
    public void ClickScooterLogoRedirectsOnMainPage() {
       driver = getDriver();
       clickAcceptCookiesButton(driver);

       MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);
       mainPage.clickOrderButtonHeader();
       OrderPageYandexScooter orderPage = new OrderPageYandexScooter(driver);

        orderPage.waitForLoadHeader();
        orderPage.fillName("Кассандра12");
        orderPage.clickNextButton();
        AssertJUnit.assertEquals("Введите корректное имя", orderPage.getNameFieldError());
    }

    @After
    public void tearDown() {
        closeBrowser(driver);
    }
}
