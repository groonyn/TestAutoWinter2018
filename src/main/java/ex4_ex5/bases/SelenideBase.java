package ex4_ex5.bases;

import com.codeborne.selenide.Configuration;
import org.testng.annotations.BeforeSuite;

public abstract class SelenideBase {
    @BeforeSuite
    public void setUpSuite() {
        Configuration.browser = "chrome";
//        Configuration.startMaximized = true;
        Configuration.pollingInterval = 200;
//        Configuration.collectionsPollingInterval = 300;
    }
}