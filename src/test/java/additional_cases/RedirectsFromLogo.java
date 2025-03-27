package additional_cases;

import org.junit.Rule;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.BrowserRule;
import ru.yandex.praktikum.MainPageYandexScooter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RedirectsFromLogo {

    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    private final static String YANDEX_URL = "https://dzen.ru/?yredirect=true";
    private WebDriver driver;

    @Test
    public void clickScooterLogoRedirectsOnMainPage() {
        MainPageYandexScooter mainPage = new MainPageYandexScooter(browserRule.getWebDriver());
        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();
        mainPage.scooterLogoClick();
        mainPage.waitForLoadLogo();
        assertTrue(mainPage.isScooterMainPage());
    }

    @Test
    public void clickYandexLogoRedirectsOnYandexPage() {
        driver = browserRule.getWebDriver();
        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);
        mainPage.waitForLoadLogo();
        mainPage.yandexLogoClick();
        Object[] windowHandles = driver.getWindowHandles().toArray();
        driver.switchTo().window((String) windowHandles[1]);
        String newPageUrl = driver.getCurrentUrl();
        assertEquals(YANDEX_URL,newPageUrl);
    }

}
