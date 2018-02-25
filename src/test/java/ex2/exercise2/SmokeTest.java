package ex2.exercise2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

import java.util.List;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class SmokeTest {
    private WebDriver driver;

    @BeforeSuite(alwaysRun = true)
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");
        driver.manage().window().maximize();
    }

    @AfterSuite(alwaysRun = true)
    public void shutDown() {
        driver.close();
    }

    @Test(groups = {"smokeTests"})
    public void loginTest5() {
        //1 Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //3 Assert User name in the left-top side of screen that user is loggined
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li")).click();
        driver.findElement(By.xpath("//*[@id='Login']")).sendKeys("epam");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("1234");
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/div/form/button")).click();
        WebElement element = driver.findElement(By.xpath("//*[@class='profile-photo']//span"));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), "PITER CHAILOVSKII");
        assertEquals(driver.getTitle(), "Index Page");

        //4 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        assertEquals(images.size(), 4);
        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }

        //5 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
        String[] allTexts = {"To include good practices\nand ideas from successful\nEPAM projec",
                "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        for (int i = 0; i < allTexts.length; i++) {
            assertEquals(texts.get(i).getText(), allTexts[i]);
        }

        //6 Assert that there are the main header and the text below it on the Home Page
        assertTrue(driver.findElement(By.xpath("/html/body/div/div/main/div[2]/h3")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("/html/body/div/div/main/div[2]/p")).isDisplayed());
    }

    @Test(groups = {"smokeTests"})
    public void loginTest6() {
        //1 Open test site by URL
        driver.navigate().to("https://jdi-framework.github.io/tests/index.htm");

        //2 Assert Browser title
        assertEquals(driver.getTitle(), "Index Page");

        //3 Assert User name in the left-top side of screen that user is loggined
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li")).click();
        driver.findElement(By.xpath("//*[@id='Login']")).sendKeys("epam");
        driver.findElement(By.xpath("//*[@id='Password']")).sendKeys("1234");
        driver.findElement(By.xpath("/html/body/div/header/div/nav/ul[2]/li/div/form/button")).click();
        WebElement element = driver.findElement(By.xpath("//*[@class='profile-photo']//span"));
        assertTrue(element.isDisplayed());
        assertEquals(element.getText(), "PITER CHAILOVSKII");
        assertEquals(driver.getTitle(), "Index Page");

        //4 Assert that there are 4 images on the Home Page and they are displayed
        List<WebElement> images = driver.findElements(By.className("benefit-icon"));
        assertEquals(images.size(), 4);
        for (WebElement image : images) {
            assertTrue(image.isDisplayed());
        }

        //5 Assert that there are 4 texts on the Home Page and check them by getting texts
        List<WebElement> texts = driver.findElements(By.className("benefit-txt"));
        assertEquals(texts.size(), 4);
        for (WebElement text : texts) {
            assertTrue(text.isDisplayed());
        }
        String[] allTexts = {"To include good practices\nand ideas from successful\nEPAM projec",
                "To be flexible and\ncustomizable", "To be multiplatform",
                "Already have good base\n(about 20 internal and\nsome external projects),\nwish to get more…"};
        for (int i = 0; i < allTexts.length; i++) {
            assertEquals(texts.get(i).getText(), allTexts[i]);
        }

        //6 Assert that there are the main header and the text below it on the Home Page
        assertTrue(driver.findElement(By.xpath("/html/body/div/div/main/div[2]/h3")).isDisplayed());
        assertTrue(driver.findElement(By.xpath("/html/body/div/div/main/div[2]/p")).isDisplayed());
    }
}