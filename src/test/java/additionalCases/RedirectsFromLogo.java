package additionalCases;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.BaseSteps;
import ru.yandex.praktikum.MainPageYandexScooter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RedirectsFromLogo extends BaseSteps {

    public RedirectsFromLogo() {
        super();
    }

    private WebDriver driver;
    private final static String yandexUrl = "https://dzen.ru/?yredirect=true";

    @Test
    public void ClickScooterLogoRedirectsOnMainPage() {
        driver = getDriver();
        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);
        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();
        mainPage.scooterLogoClick();
        mainPage.waitForLoadLogo();
        assertTrue(mainPage.isScooterMainPage());
    }

    @Test
    public void ClickYandexLogoRedirectsOnYandexPage() {
        driver = getDriver();
        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);
        mainPage.waitForLoadLogo();
        mainPage.yandexLogoClick();
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        String newPageUrl = driver.getCurrentUrl();
        assertEquals(yandexUrl,newPageUrl);
    }

    @After
    public void tearDown() {
        closeBrowser(driver);
    }
}
