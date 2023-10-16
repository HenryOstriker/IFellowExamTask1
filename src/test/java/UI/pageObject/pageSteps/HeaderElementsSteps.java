package UI.pageObject.pageSteps;

import io.qameta.allure.Step;

import static UI.pageObject.pageElements.HeaderElements.*;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public final class HeaderElementsSteps {
    public void logout() {
        userHeaderMenuButton.click();
        logOutButton.click();
    }

    public void openAllCreatedTasks() {
        tasksButton.click();
        searchTasks.click();
    }

    @Step("Открыть страницу пользователя")
    public static void goToUserPage() {
        userHeaderMenuButton.click();
        profileButton.click();
    }

    @Step("Открыть проект {projectName}")
    public static void openProject(String projectName) {
        projectsButton.click();
        $(byText(projectName)).click();
    }

    @Step("Найти задачу под номером {projectName}")
    public static void searchTask(String projectName) {
        searchField.setValue(projectName + "\n");
    }

    @Step("Найти и открыть созданную задачу {projectName}")
    public static void searchCreatedTask(String projectName) {
        searchTask(ProjectPageElementsSteps.getTaskTestNumber(projectName));
    }

    @Step("Переход на главную страницу")
    public void clickMainLogo() {
        headerLogo.click();
    }
}
