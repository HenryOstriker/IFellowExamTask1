package UI.pageObject.pageSteps;

import static UI.pageObject.pageElements.LogInElements.*;

public final class LogInElementsSteps {
    public void authorization(String login, String password) {
        logInButton.click();
        usernameField.setValue(login);
        passwordField.setValue(password);
        submitButton.click();
    }
}
