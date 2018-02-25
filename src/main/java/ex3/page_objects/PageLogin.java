package ex3.page_objects;

import ex3.enums.DivClassRowClerafixBenefitsEnum;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

import static java.util.stream.IntStream.range;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class PageLogin {
    @FindBy(css = ".dropdown.uui-profile-menu")
    private WebElement dropdownForm;

    @FindBy(css = "#Login")
    private WebElement loginForm;

    @FindBy(css = "#Password")
    private WebElement passwordForm;

    @FindBy(css = ".fa.fa-sign-in")
    private WebElement enterButton;

    @FindBy(css = ".uui-profile-menu span")
    private WebElement userName;

    @FindBy(css = ".benefit-icon")
    private List<WebElement> icons;

    @FindBy(css = ".benefit-txt")
    private List<WebElement> textsBelowIcons;

    @FindBy(css = ".main-title.text-center")
    private WebElement mainTitleTextCenter;

    @FindBy(css = ".main-txt.text-center")
    private WebElement belowMainTitleTextCenter;

    public void openPage(WebDriver driver) {
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
    }

    public void login(String name, String password) {
        dropdownForm.click();
        loginForm.sendKeys(name);
        passwordForm.sendKeys(password);
        enterButton.click();
    }

    public void checkPageTitle(WebDriver driver) {
        assertEquals(driver.getTitle(), "Index Page");
    }

    public void checkUserName() {
        assertEquals(userName.getText(), "PITER CHAILOVSKII");
    }


    public void checkImagesExistance() {
        assertEquals(icons.size(), 4);
        for (WebElement icon : icons) {
            assertTrue(icon.isDisplayed());
        }
    }

    public void checkTextBelowIcons(DivClassRowClerafixBenefitsEnum[] benefits) {
        textsBelowIcons.forEach(texts -> assertTrue(texts.isDisplayed()));
        assertEquals(textsBelowIcons.size(), 4);
        range(0, textsBelowIcons.size()).forEach(i -> {
            assertTrue(textsBelowIcons.get(i).isDisplayed());
            assertEquals(textsBelowIcons.get(i).getText().replaceAll("\n", " "), benefits[i].text);
        });
    }

    public void checkMainTitleTextCenter() {
        assertTrue(mainTitleTextCenter.isDisplayed());
    }

    public void checkBelowMainTitleTextCenter() {
        assertTrue(belowMainTitleTextCenter.isDisplayed());
    }
}
