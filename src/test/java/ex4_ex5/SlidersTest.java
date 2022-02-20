package ex4_ex5;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import ex4_ex5.bases.SelenideBase;
import ex4_ex5.listeners.AllureAttachListener;
import ex4_ex5.page_objects.LoginPage;
import ex4_ex5.page_objects.SlidersPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static ex4_ex5.enums.LoginPageEnum.LOGIN;
import static ex4_ex5.enums.LoginPageEnum.PASSWORD;

@Listeners(AllureAttachListener.class)
@Features({"SelenideTestSuite"})
@Stories({"\"Sliders\" tests"})

public class SlidersTest extends SelenideBase {
    private LoginPage loginPageSliders;
    private SlidersPage slidersPage;

    @BeforeMethod
    public void setUp() {
        loginPageSliders = Selenide.page(LoginPage.class);
        slidersPage = Selenide.page(SlidersPage.class);
    }

    @AfterMethod(alwaysRun = true)
    //Delay 3sec in last test case.
    public void shutDown() {
        WebDriverRunner.getWebDriver().close();
    }

    @Test
    public void SlidersTests() {

        //1 Open test site by URL
        loginPageSliders.openPage();

        //2 Perform login
        loginPageSliders.login(LOGIN.expectedText, PASSWORD.expectedText);

        //3 Assert User name in the left-top side of screen that user is loggined
        loginPageSliders.checkUserName();

        //4 Open Service page and open Dates page
        loginPageSliders.openServiceDatesPage();

        //5 Using drag-and-drop set Range sliders.
        //  left sliders - the most left position, right slider - the most right position
        slidersPage.setSlidersRange(0, 100);

        //6 Using drag-and-drop set Range sliders.
        //  left sliders - the most left position, right slider - the most left position.

        slidersPage.setSlidersRange(0, 0);

        //7 Using drag-and-drop set Range sliders.
        //  left sliders - the most right position, right slider - the most right position.
        slidersPage.setSlidersRange(100, 100);

        //8 Using drag-and-drop set Range sliders. left - 30, right - 70.
        slidersPage.setSlidersRange(30, 70);
    }
}
