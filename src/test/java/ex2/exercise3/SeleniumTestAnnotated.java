package ex2.exercise3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

public class SeleniumTestAnnotated {
    private WebDriver driver;

    @BeforeSuite
    public void setUpSuite() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
    }

    @BeforeTest
    public void setUpTest() {
        driver = new ChromeDriver();
    }

    @BeforeMethod
    public void setUpMethod() {
        System.out.println(driver.getTitle());
    }

    @AfterMethod
    public void shutDownMethod() {
        if (driver.toString().contains("null")) {
            driver.quit();
        }
    }

    @AfterTest
    public void shutDownTest() {
        System.out.println(System.currentTimeMillis());
    }

    @AfterSuite
    public void shutDownSuite() {
        driver.close();
    }

    @Test
    public void test() {
        driver.manage().window().maximize();
        driver.navigate().to("https://epam.com");
        Assert.assertEquals(driver.getTitle(), "EPAM | Software Product Development Services");
        WebElement element = driver.findElement(By.cssSelector(".header-search__button"));
        element.click();
    }
}