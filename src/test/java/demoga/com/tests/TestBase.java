package demoga.com.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import configs.CredentialsConfig;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;

import org.aeonbits.owner.ConfigFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import static com.codeborne.selenide.Selenide.*;

public class TestBase {


    @BeforeAll
    static void setUp() {
        CredentialsConfig config = ConfigFactory.create(CredentialsConfig.class);
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());

        String selenoidLogin = config.selenoidLogin();
        String selenoidPass = config.selenoidPass();
        String selenoidUrl = config.selenoidUrl();

        Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com");
        System.setProperty("browser", "chrome");
        Configuration.browser = System.getProperty("browser", "firefox");
        Configuration.browserSize = System.getProperty("browserSize", "1920x1080");
        System.setProperty("version", "99");
        Configuration.browserVersion = System.getProperty("version", "98");


        Configuration.remote = "https://" + selenoidLogin + ":" + selenoidPass + "@" + selenoidUrl;


        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("enableVNC", true);
        capabilities.setCapability("enableVideo", true);
        Configuration.browserCapabilities = capabilities;
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
        Attach.addVideo();
        closeWebDriver();
    }
}
