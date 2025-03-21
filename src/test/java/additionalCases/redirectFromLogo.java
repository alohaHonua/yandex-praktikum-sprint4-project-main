package additionalCases;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.MainPageYandexScooter;
import static org.junit.Assert.assertTrue;

public class redirectFromLogo {

    private WebDriver driver;

    @Test
    public void ClickLogoRedirectOnMainPage() {
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get("https://qa-scooter.praktikum-services.ru/");

        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);
        mainPage.waitForLoadLogo();
        mainPage.clickOrderButtonHeader();
        driver.findElement(By.xpath(".//a[contains(@class, 'Header_LogoScooter')]")).click();
        mainPage.waitForLoadLogo();
        assertTrue( driver.findElement(By.xpath(".//div[contains(@class, 'HomePage')]")).isDisplayed());
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
