package ex2.exercise1;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;

public class DataProviderTextTest {
    private WebDriver driver;

    @BeforeTest
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        driver.manage().window().maximize();
    }

    @AfterTest
    public void turnOff() {
        driver.close();
    }

    @DataProvider(parallel = true)
    public Object[][] expectedTexts() {
        return new Object[][]{
                {0, "To include good practices\nand ideas from successful\nEPAM projec"},
                {1, "To be flexible and\ncustomizable"}, {2, "To be multiplatform"},
                {3, "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"}
        };
    }

    @Test(dataProvider = "expectedTexts")
    public void indexTextAssertionTest(int stringIndex, String str) {
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        assertEquals(texts.get(stringIndex).getText(), str);
    }
}