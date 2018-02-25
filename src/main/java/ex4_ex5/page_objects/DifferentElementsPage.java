package ex4_ex5.page_objects;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import com.codeborne.selenide.WebDriverRunner;
import ex4_ex5.enums.CheckboxEnum;
import ex4_ex5.enums.ColoursEnum;
import ex4_ex5.enums.DifferentElementsEnum;
import ex4_ex5.enums.MetalsEnum;
import org.openqa.selenium.support.FindBy;
import org.testng.AssertJUnit;
import ru.yandex.qatools.allure.annotations.Step;

import java.util.List;

import static com.codeborne.selenide.Condition.*;
import static org.testng.AssertJUnit.assertEquals;
import static org.testng.AssertJUnit.assertTrue;


public class DifferentElementsPage {

    @FindBy(css = ".sub-menu [href = 'page8.htm']")
    private SelenideElement differentElementsButton;

    @FindBy(css = ".label-checkbox")
    private ElementsCollection checkboxes;

    @FindBy(css = ".label-radio")
    private ElementsCollection radios;

    @FindBy(css = "select.uui-form-element")
    private SelenideElement dropdown;

    @FindBy(css = ".main-content .uui-button")
    private ElementsCollection buttons;

    @FindBy(css = "._mCS_1")
    private SelenideElement leftSection;

    @FindBy(css = ".panel-body-list.logs li")
    private List<SelenideElement> logs;

    @FindBy(css = "._mCS_2")
    private SelenideElement rightSection;

    private SelenideElement checkboxName;
    private SelenideElement radioElementSelen;

    @Step
    public void openDifferentElementsPage() {
        differentElementsButton.click();
        AssertJUnit.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), DifferentElementsEnum.URL_DIFFERENT_ELEMENTS.expectedText);
    }

    @Step
    public void checkInterfaceElementsOnServicePage() {
        checkboxes.forEach(checkbox -> checkbox.shouldBe(visible));
        assertEquals(checkboxes.size(), 4);
        radios.forEach(radio -> radio.shouldBe(visible));
        assertEquals(radios.size(), 4);
        dropdown.shouldBe(visible);
        buttons.forEach(button -> button.shouldBe(visible));
        assertEquals(buttons.size(), 2);
        leftSection.shouldBe(visible);
        rightSection.shouldBe(visible);
    }

    @Step
    public SelenideElement takeCheckboxElementsForCheck(CheckboxEnum element) {
        checkboxes.forEach((SelenideElement checkbox) -> {
            if (checkbox.text().equalsIgnoreCase(element.expectedText)) {
                checkboxName = checkbox;
            }
        });
        return checkboxName;
    }

    @Step
    public void checkSelectedCheckboxElementsForCheck(CheckboxEnum... elementsToCheck) {
        for (CheckboxEnum elementEnum : elementsToCheck) {
            takeCheckboxElementsForCheck(elementEnum).click();
            takeCheckboxElementsForCheck(elementEnum).find(DifferentElementsEnum.INPUT.expectedText).shouldBe(checked);
        }
    }

    @Step
    public void checkSelectRadioElement() {
        radioElementSelen = radios.get(3).shouldHave(text(MetalsEnum.SELEN.expectedText));
        radioElementSelen.find(DifferentElementsEnum.INPUT.expectedText).click();
        radioElementSelen.find(DifferentElementsEnum.INPUT.expectedText).shouldBe(checked);
    }

    @Step
    public void checkDropdownColour() {
        dropdown.click();
        dropdown.selectOption(ColoursEnum.YELLOW.expectedText);
        dropdown.shouldHave(text(ColoursEnum.YELLOW.expectedText));
    }

    @Step
    public void checkLogsSectionSelectedCheckboxes(String value, int index, boolean status) {
        assertTrue(logs.get(index).getText().contains(value));
        assertTrue(logs.get(index).getText().contains(String.valueOf(status)));
    }

    @Step
    public void checkLogsSectionSelectedDropdownsAndRadios(String type, String typeValue, int index) {
        assertTrue(logs.get(index).getText().contains(type));
        assertTrue(logs.get(index).getText().contains(typeValue));
    }

    @Step
    public void unselectAndAssertCheckboxes(CheckboxEnum... elementsToCheck) {
        for (CheckboxEnum checkboxEnum : elementsToCheck) {
            takeCheckboxElementsForCheck(checkboxEnum).click();
            takeCheckboxElementsForCheck(checkboxEnum).find(DifferentElementsEnum.INPUT.expectedText).shouldNotBe(checked);
        }
    }

    @Step
    public void checkLogsSectionUnselectedCheckboxes(String value, int index, boolean status) {
        assertTrue(logs.get(index).getText().contains(value));
        assertTrue(logs.get(index).getText().contains(String.valueOf(status)));
    }
}