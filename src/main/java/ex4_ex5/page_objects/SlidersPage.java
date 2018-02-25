package ex4_ex5.page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.allure.annotations.Step;

import static com.codeborne.selenide.Selenide.actions;

public class SlidersPage {

    @FindBy(css = "div:nth-child(2) > div > a:nth-child(1)")
    private SelenideElement sliderLeft;

    @FindBy(css = "div:nth-child(2) > div > a:nth-child(3)")
    private SelenideElement sliderRight;

    @Step
    public void setSlidersRange(int left, int right) {
        actions().dragAndDropBy(sliderLeft, -276, 0).build().perform();
        actions().dragAndDropBy(sliderRight, -276, 0).build().perform();
        actions().dragAndDropBy(sliderRight, (int) ((right * 2.72) - 1), 0).build().perform();
        sliderRight.shouldHave(Condition.matchText(Integer.toString(right)));
        actions().dragAndDropBy(sliderLeft, (int) ((left * 2.72) - 1), 0).build().perform();
        sliderLeft.shouldHave(Condition.matchText(Integer.toString(left)));
    }
}
