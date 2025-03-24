package additionalCases;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.MainPageYandexScooter;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class RedirectsFromLogo {

    private WebDriver driver;
    private final static String scooterUrl = "https://qa-scooter.praktikum-services.ru/";
    private final static String yandexUrl = "https://dzen.ru/?yredirect=true";

    @Test
    public void ClickScooterLogoRedirectsOnMainPage() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(scooterUrl);

        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);
        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();
        mainPage.scooterLogoClick();
        mainPage.waitForLoadLogo();
        assertTrue(mainPage.isScooterMainPage());
    }

    @Test
    public void ClickYandexLogoRedirectsOnYandexPage() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(scooterUrl);

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
        driver.quit();
    }
}
