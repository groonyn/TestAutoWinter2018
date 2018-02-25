package ex3.exercise2;

import ex3.enums.DivClassRowClerafixBenefitsEnum;
import ex3.page_objects.PageLogin;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class PageLoginPageObject {
    private WebDriver driver;
    private PageLogin pageLogin;

    //Preparing WebDriver environment
    @BeforeClass
    public void setUp() {
        System.setProperty("webdriver.chrome.driver", "src\\main\\resources\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        pageLogin = PageFactory.initElements(driver, PageLogin.class);
    }

    //shutDown WebDriver environment
    @AfterMethod(alwaysRun = true)
    public void shutDown() {
        driver.close();
    }

    @Test
    public void pageLoginTests() {
        //1 Open test site by URL
        pageLogin.openPage(driver);

        //2 Assert Browser title
        pageLogin.checkPageTitle(driver);

        //3 Perform login
        pageLogin.login("epam", "1234");

        //4 Assert User name in the left-top side of screen that user is loggined
        pageLogin.checkUserName();

        //5 Assert Browser title
        pageLogin.checkPageTitle(driver);

        //6 Assert that there are 4 images on the Home Page and they are displayed
        pageLogin.checkImagesExistance();

        //7 Assert that there are 4 texts on the Home Page and check them by getting texts
        pageLogin.checkTextBelowIcons(DivClassRowClerafixBenefitsEnum.values());

        //8 Assert that there are the main header and the text below it on the Home Page
        pageLogin.checkMainTitleTextCenter();
        pageLogin.checkBelowMainTitleTextCenter();
    }
}
