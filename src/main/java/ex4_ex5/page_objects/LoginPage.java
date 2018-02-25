package ex4_ex5.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import ex4_ex5.enums.DatesPageAndSlidersEnum;
import ex4_ex5.enums.LoginPageEnum;
import ex4_ex5.enums.ServiceElementsEnum;
import ex4_ex5.enums.TextsBelowImagesEnum;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static org.testng.Assert.assertEquals;

public class LoginPage {
    @FindBy(css = ".dropdown.uui-profile-menu")
    private SelenideElement dropdownForm;

    @FindBy(css = "#Login")
    private SelenideElement loginForm;

    @FindBy(css = "#Password")
    private SelenideElement passwordForm;

    @FindBy(css = ".fa.fa-sign-in")
    private SelenideElement enterButton;

    @FindBy(css = ".uui-profile-menu span")
    private SelenideElement userName;

    @FindBy(css = ".benefit-icon")
    private ElementsCollection icons;

    @FindBy(css = ".benefit-txt")
    private ElementsCollection textsBelowIcons;

    @FindBy(css = ".main-title.text-center")
    private SelenideElement mainTitleTextCenter;

    @FindBy(css = ".main-txt.text-center")
    private SelenideElement belowMainTitleTextCenter;

    @FindBy(css = "a.dropdown-toggle")
    private SelenideElement serviceHeaderButton;

    @FindBy(css = ".dropdown-menu>li")
    private ElementsCollection serviceHeaderDropdownElements;

    @FindBy(css = ".sidebar-menu .sub-menu")
    private SelenideElement serviceLeftButton;

    @FindBy(css = ".sub>li")
    private ElementsCollection serviceLeftDropdownElements;

    @FindBy(css = "[href='page4.htm']")
    private SelenideElement serviceDropdownDatesButton;

    @Step
    public void openPage() {
        Selenide.open(LoginPageEnum.URL.expectedText);
    }

    @Step
    public void login(String name, String password) {
        dropdownForm.click();
        loginForm.sendKeys(name);
        passwordForm.sendKeys(password);
        enterButton.click();
    }

    @Step
    public void checkUserName() {
        userName.shouldHave(text(LoginPageEnum.USERNAME.expectedText));
    }

    @Step
    public void checkImagesExistance() {
        icons.shouldHaveSize(4).forEach(icon -> icon.shouldBe(visible));
    }

    @Step
    public void checkTextBelowIcons(TextsBelowImagesEnum[] benefits) {
        textsBelowIcons.shouldHaveSize(4).forEach(text -> text.shouldBe(visible));
        for (int i = 0; i < textsBelowIcons.size(); i++) {
            assertEquals(textsBelowIcons.get(i).getText().replaceAll("\n", " "), benefits[i].expectedText);
        }
    }

    @Step
    public void checkMainTitleTextCenter() {
        mainTitleTextCenter.shouldBe(visible).shouldHave(text(LoginPageEnum.TEXT_MAIN_TITLE_CENTER.expectedText));
    }

    @Step
    public void checkBelowMainTitleTextCenter() {
        belowMainTitleTextCenter.shouldBe(visible).shouldHave(text(LoginPageEnum.TEXT_BELOW_MAIN_TITLE_CENTER.expectedText));
    }

    @Step
    public void checkServiceHeaderDropdownElements(ServiceElementsEnum[] serviceElements) {
        serviceHeaderButton.shouldBe(visible);
        serviceHeaderButton.click();
        serviceHeaderDropdownElements.forEach(serviceHeaderDropdownElement -> serviceHeaderDropdownElement.shouldBe(visible));
        assertEquals(serviceHeaderDropdownElements.size(), serviceElements.length);
        int i = 0;
        while (i < serviceElements.length) {
            serviceHeaderDropdownElements.get(i).shouldHave(text(serviceElements[i].expectedText.toUpperCase()));
            i++;
        }
    }

    @Step
    public void checkServiceLeftSectionDropdownElements(ServiceElementsEnum[] serviceElements) {
        serviceLeftButton.shouldBe(visible);
        serviceLeftButton.click();
        serviceLeftDropdownElements.forEach(serviceLeftDropdownElement -> serviceLeftDropdownElement.shouldBe(visible));
        assertEquals(serviceLeftDropdownElements.size(), serviceElements.length);
        int i = 0;
        while (i < serviceElements.length) {
            serviceLeftDropdownElements.get(i).shouldHave(text(serviceElements[i].expectedText));
            i++;
        }
    }

    @Step
    public void openServiceDatesPage() {
        serviceHeaderButton.shouldBe(visible);
        serviceHeaderButton.click();
        serviceDropdownDatesButton.shouldBe(visible);
        serviceDropdownDatesButton.click();
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), DatesPageAndSlidersEnum.URL_DATES.expectedText);
    }
}