package UI.hooks;

import UI.pageObject.pageSteps.HeaderElementsSteps;
import UI.pageObject.pageSteps.LogInElementsSteps;
import UI.projectUtils.CustomAllureSelenide;
import UI.projectUtils.ScreenshotOnFailure;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;

import static utils.Configuration.getConfigurationValue;

@ExtendWith(ScreenshotOnFailure.class)
public abstract class WebHooks {
    @BeforeAll
    static void setUp() {
            Selenide.open(getConfigurationValue("jiraUrl"));
            WebDriverRunner.getWebDriver().manage().window().maximize();
            new LogInElementsSteps().authorization(getConfigurationValue("username"),
                    getConfigurationValue("password"));
        SelenideLogger.addListener("AllureSelenide", new CustomAllureSelenide());
    }

    @BeforeEach
    public void logIn() {
        new HeaderElementsSteps().clickMainLogo();
    }

    @AfterAll
    static void closeWebBrowser() {
        new HeaderElementsSteps().logout();
        Selenide.closeWebDriver();
    }
}
