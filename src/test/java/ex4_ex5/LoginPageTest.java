package ex4_ex5;

import com.codeborne.selenide.Selenide;
import ex4_ex5.bases.SelenideBase;
import ex4_ex5.enums.ServiceElementsEnum;
import ex4_ex5.enums.TextsBelowImagesEnum;
import ex4_ex5.listeners.AllureAttachListener;
import ex4_ex5.page_objects.DifferentElementsPage;
import ex4_ex5.page_objects.LoginPage;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import ru.yandex.qatools.allure.annotations.Features;
import ru.yandex.qatools.allure.annotations.Stories;

import static com.codeborne.selenide.Selenide.close;
import static ex4_ex5.enums.CheckboxEnum.WATER;
import static ex4_ex5.enums.CheckboxEnum.WIND;
import static ex4_ex5.enums.ColoursEnum.COLORS;
import static ex4_ex5.enums.ColoursEnum.YELLOW;
import static ex4_ex5.enums.LoginPageEnum.LOGIN;
import static ex4_ex5.enums.LoginPageEnum.PASSWORD;
import static ex4_ex5.enums.MetalsEnum.METALS;
import static ex4_ex5.enums.MetalsEnum.SELEN;

@Listeners(AllureAttachListener.class)
@Features({"SelenideTestSuite"})
@Stories({"\"Login Page and Different Elements Page\" tests"})

public class LoginPageTest extends SelenideBase {

    private LoginPage loginPage;
    private DifferentElementsPage differentElements;

    @BeforeMethod
    public void setUp() {
        loginPage = Selenide.page(LoginPage.class);
        differentElements = Selenide.page(DifferentElementsPage.class);
    }

    @AfterMethod(alwaysRun = true)
    public void shutDown() {
        close();
    }

    @Test
    public void pageLoginTests() {
        //1 Open test site by URL
        loginPage.openPage();

        //2 Perform login
        loginPage.login(LOGIN.expectedText, PASSWORD.expectedText);

        //3 Assert User name in the left-top side of screen that user is loggined
        loginPage.checkUserName();

        //4 Check interface on Home page, it contains 4 pictures.
        loginPage.checkImagesExistance();

        //5 Check that there are 4 texts on the Home Page and check them by getting texts
        loginPage.checkTextBelowIcons(TextsBelowImagesEnum.values());

        //6 Check that there are the main header and the text below it on the Home Page
        loginPage.checkMainTitleTextCenter();
        loginPage.checkBelowMainTitleTextCenter();

        //7 Click on Service subcategory in the header section and check that drop down contains options
        loginPage.checkServiceHeaderDropdownElements(ServiceElementsEnum.values());

        //8 Click on Service subcategory in the left section and check that drop down contains options
        loginPage.checkServiceLeftSectionDropdownElements(ServiceElementsEnum.values());

        //9 Open through the header menu Service -> Different Elements Page
        differentElements.openDifferentElementsPage();

        //10 Check interface on Service page, it contains all needed elements:
        //   4 checkboxes, 4 radios, dropdown, 2 - buttons, left section, right section.
        differentElements.checkInterfaceElementsOnServicePage();

        //11 Select and assert checkbox Water, Wind elements are checked
        differentElements.checkSelectedCheckboxElementsForCheck(WATER, WIND);

        //12 Select radio Selen	element and check it
        differentElements.checkSelectRadioElement();

        //13 Selected in dropdown Yellow element
        differentElements.checkDropdownColour();

        //14 Check in logs section selected values and status (true|false)
        differentElements.checkLogsSectionSelectedCheckboxes(WATER.expectedText, 3, true);
        differentElements.checkLogsSectionSelectedCheckboxes(WIND.expectedText, 2, true);
        differentElements.checkLogsSectionSelectedDropdownsAndRadios(METALS.expectedText, SELEN.expectedText, 1);
        differentElements.checkLogsSectionSelectedDropdownsAndRadios(COLORS.expectedText, YELLOW.expectedText, 0);

        //15 Unselect and assert checkboxes
        differentElements.unselectAndAssertCheckboxes(WATER, WIND);

        //16 Check in logs section unselected values and status (true|false)
        differentElements.checkLogsSectionUnselectedCheckboxes(WIND.expectedText, 0, false);
        differentElements.checkLogsSectionUnselectedCheckboxes(WATER.expectedText, 1, false);
    }
}