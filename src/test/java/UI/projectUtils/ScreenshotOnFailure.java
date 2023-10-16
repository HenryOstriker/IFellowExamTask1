package UI.projectUtils;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;

public final class ScreenshotOnFailure implements AfterEachCallback {
    @Override
    public void afterEach(ExtensionContext extensionContext) {
        boolean testFailed = extensionContext.getExecutionException().isPresent();
        if (testFailed) {
            getScreenshotBytes();
        }
    }

    @Attachment(value = "screenshot", type = "image/png", fileExtension = ".png")
    public byte[] getScreenshotBytes() {
        try {
            return WebDriverRunner.hasWebDriverStarted()
                    ? ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES)
                    : new byte[0];
        } catch (WebDriverException e) {
            e.printStackTrace();
            return new byte[0];
        }
    }
}
