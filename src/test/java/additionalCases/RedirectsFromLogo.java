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
        driver.findElement(By.xpath(".//a[contains(@class, 'Header_LogoScooter')]")).click();
        mainPage.waitForLoadLogo();
        assertTrue(driver.findElement(By.xpath(".//div[contains(@class, 'HomePage')]")).isDisplayed());
    }

    @Test
    public void ClickYandexLogoRedirectsOnYandexPage() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(scooterUrl);

        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);
        mainPage.waitForLoadLogo();
        driver.findElement(By.xpath(".//a/img[@alt='Yandex']")).click();
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
