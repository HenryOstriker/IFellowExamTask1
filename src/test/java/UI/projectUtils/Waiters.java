package UI.projectUtils;

import com.codeborne.selenide.SelenideElement;

public interface Waiters {
    default String waitFor(SelenideElement selenideElement, int timeOutMillis) {
        String temp = selenideElement.getText();
        for (int i = timeOutMillis; i > 0; i -= 250) {
            try {
                Thread.sleep(250);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            if (!selenideElement.getText().equals(temp)) {
                return selenideElement.getText();
            }
        }

        return temp;
    }
}
