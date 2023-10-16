package UI.pageObject.pageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;
import org.junit.jupiter.api.Assertions;

import static UI.pageObject.pageElements.TaskPageElements.*;

public final class TaskPageElementsSteps {
    public static String getTaskStatus() {
        return taskStatus.getText();
    }


    @Step("Проверить, что у задачи есть статус")
    public static void checkTaskStatusIsSet() {
        Assertions.assertTrue(getTaskStatus().length() > 0, "Статус задачи не задан.");
    }

    public static String getChangedTaskStatus() {
        String status = taskStatus.getText();
        return taskStatus.shouldNotHave(Condition.exactText(status)).getText();
    }

    @Step("Проверить, что новый статус задачи равен {taskStatus}")
    public static void checkChangedTaskStatus(String taskStatus) {
        Assertions.assertEquals(taskStatus, getChangedTaskStatus(), "Статус не равен '" + taskStatus + "'.");
    }

    public static String getFixInVersion() {
        return taskFixInVersion.getText();
    }

    @Step("Проверить, что задача должна быть исправлена в {version}")
    public static void checkFixInVersion(String version) {
        Assertions.assertEquals(version, getFixInVersion(), "Версия для исправления не соответствует " + version);
    }

    @Step("Поменять статус задачи на \"В работе\"")
    public static void setStatusInProgress() {
        taskInProgressButton.click();
    }

    @Step("Поменять статус задачи на \"Решенные\"")
    public static void setStatusResolved() {
        taskBusinessProcessButton.click();
        taskResolvedButton.click();
        taskAcceptButton.click();
    }

    @Step("Поменять статус задачи на \"Готово\"")
    public static void setStatusDone() {
        taskBusinessProcessButton.click();
        taskDoneButton.click();
        taskAcceptButton.click();
    }
}
