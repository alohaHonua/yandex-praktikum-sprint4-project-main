package additionalCases;

import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import ru.yandex.praktikum.BaseSteps;
import ru.yandex.praktikum.MainPageYandexScooter;
import ru.yandex.praktikum.TrackingPageYandexScooter;

public class TrackNotFoundCase {

    private WebDriver driver;
    private final static String scooterUrl = "https://qa-scooter.praktikum-services.ru/";

    @Test
    public void checkIfTrackNumberNotExists(){
        ChromeOptions options = new ChromeOptions();
        driver = new ChromeDriver(options);
        driver.get(scooterUrl);

        //Закрыть поп-ап с куками
        BaseSteps baseSteps = new BaseSteps(driver);
        baseSteps.clickAcceptCookiesButton();

        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);

        mainPage.waitForLoadLogo();
        mainPage.clickTrackButton();

        TrackingPageYandexScooter trackingPage = new TrackingPageYandexScooter(driver);

        trackingPage.waitForLoadTrackInputField();
        trackingPage.inputTrackNumber("7353521");
        trackingPage.clickSearchTrackingInfoButton();

        trackingPage.waitForImageTrackNotFound();


    }
}
