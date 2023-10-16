package UI.pageObject.pageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.*;

public final class LogInElements {
    public static final SelenideElement logInButton = $x("//a[contains(@class, 'login-link')]");
    public static final SelenideElement usernameField = $x("//input[@id='login-form-username']");
    public static final SelenideElement passwordField = $x("//input[@id='login-form-password']");
    public static final SelenideElement submitButton = $x("//input[@id='login-form-submit']");
}
