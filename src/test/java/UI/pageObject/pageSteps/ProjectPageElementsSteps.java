package UI.pageObject.pageSteps;

import com.codeborne.selenide.Condition;
import UI.projectUtils.Waiters;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static UI.pageObject.pageElements.ProjectPageElements.*;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public final class ProjectPageElementsSteps implements Waiters {
    public static String getProjectName() {
        return projectName.getAttribute("title");
    }

    @Step("Проверить, что открытый проект называется {projectName}")
    public static void checkProjectName(String projectName) {
        Assertions.assertEquals(projectName, getProjectName(), "Проект " + projectName + " не найден.");
    }

    @Step("Открыть список задач")
    public static void clickTasks() {
        tasksButton.click();
        filtersButton.shouldBe(Condition.visible);
    }

    @Step("Поменять фильтр отображения задач на {filtersType}")
    public static void changeFiltersTo(String filtersType) {
        filtersButton.click();
        $(byText(filtersType)).click();
    }

    public String waitForElementIsUpdated() {
        return waitFor(numberOfTasks, 1000);
    }

    @Step("Получить количество задач после применения фильтра \"Все задачи\"")
    public static String getNumberOfFilteredTasks() {
        return new ProjectPageElementsSteps().waitForElementIsUpdated().substring("1 из ".length());
    }

    @Step("Получить количество всех созданных задач")
    public static String getNumberOfAllCreatedTasks() {
        new HeaderElementsSteps().openAllCreatedTasks();
        return numberOfTasks.getText().substring("1 из ".length());
    }

    @Step("Сравнить количество созданных задач и количество задач с примененным фильтром \"Все задачи\"")
    public static void checkNumberOfFilteredTasks() {
        Assertions.assertEquals(getNumberOfFilteredTasks(), getNumberOfAllCreatedTasks(),
                "Количество всех созданных задач не равно количеству задач с фильтром \"Все задачи\"");
    }

    @Step("Нажать \"Создать задачу\" внизу экрана и выбрать \"Открыть в диалоговом окне\"")
    public static void newTaskWithDialogue() {
        createTaskButton.click();
        openInDialogueButton.shouldBe(Condition.visible);
        openInDialogueButton.click();
        taskCreationHeader.shouldBe(Condition.visible);
    }

    public static String getTaskTestNumber(String taskName) {
        String taskDescription = $x("//div[@class='issue-content-container' and span[contains(., '" + taskName + "')]]").getText();
        return taskDescription.substring(0, taskDescription.indexOf('\n'));
    }
}
