package additional_cases;

import org.junit.Rule;
import org.junit.Test;
import ru.yandex.praktikum.BrowserRule;
import ru.yandex.praktikum.MainPageYandexScooter;
import ru.yandex.praktikum.TrackingPageYandexScooter;

public class TrackNotFoundCase  {

    @Rule
    public final BrowserRule browserRule = new BrowserRule();

    @Test
    public void checkIfTrackNumberNotExists(){

        MainPageYandexScooter mainPage = new MainPageYandexScooter(browserRule.getWebDriver());
        mainPage.waitForLoadLogo();
        mainPage.clickTrackButton();

        TrackingPageYandexScooter trackingPage = new TrackingPageYandexScooter(browserRule.getWebDriver());
        trackingPage.waitForLoadTrackInputField();
        trackingPage.inputTrackNumber("7353521");
        trackingPage.clickSearchTrackingInfoButton();
        trackingPage.waitForImageTrackNotFound();
    }

}
