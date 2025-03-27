package additional_сases;

import org.junit.After;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import ru.yandex.praktikum.BaseSteps;
import ru.yandex.praktikum.MainPageYandexScooter;
import ru.yandex.praktikum.TrackingPageYandexScooter;

public class TrackNotFoundCase extends BaseSteps {

    public TrackNotFoundCase() {
        super();
    }

    private WebDriver driver;

    @Test
    public void checkIfTrackNumberNotExists(){
        driver = getDriver();
        clickAcceptCookiesButton(driver);

        MainPageYandexScooter mainPage = new MainPageYandexScooter(driver);
        mainPage.waitForLoadLogo();
        mainPage.clickTrackButton();

        TrackingPageYandexScooter trackingPage = new TrackingPageYandexScooter(driver);
        trackingPage.waitForLoadTrackInputField();
        trackingPage.inputTrackNumber("7353521");
        trackingPage.clickSearchTrackingInfoButton();
        trackingPage.waitForImageTrackNotFound();
    }

    @After
    public void tearDown() {
        closeBrowser(driver);
    }
}
