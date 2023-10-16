package UI.pageObject.pageSteps;

import com.codeborne.selenide.Condition;
import io.qameta.allure.Step;

import static UI.pageObject.pageElements.NewTaskWindowElements.*;
import static com.codeborne.selenide.Selenide.*;

public final class NewTaskWindowElementsSteps {
    @Step("Заполнить поле \"Тип задачи\" значением {taskType}")
    public static void setTaskType(String taskType) {
        taskTypeSelector.shouldBe(Condition.visible).click();
        taskTypeSelector.sendKeys(taskType + "\n");
    }

    @Step("Заполнить поле \"Тема\" значением {taskName}")
    public static void setTaskName(String taskName) {
        taskThemeField.shouldBe(Condition.visible).setValue(taskName);
    }

    @Step("Заполнить поле \"Описание\" значением {description}")
    public static void setTaskDescription(String description) {
        taskDescriptionField.shouldBe(Condition.visible).click();
        actions().sendKeys(description).perform();
    }

    @Step("Заполнить поле \"Окружение\" значением {environment}")
    public static void setTaskEnvironment(String environment) {
        taskEnvironmentField.shouldBe(Condition.visible).click();
        actions().sendKeys(environment).perform();
    }

    @Step("Заполнить поле \"Связанные задачи\" значением {task}")
    public static void setConnectedTask(String task) {
        taskConnected.sendKeys(task);
    }

    @Step("Сохранить и создать задачу")
    public static void acceptAndCreateTask() {
        submitButton.click();
    }

    @Step("Заполнить поля задачи: \"Тип задачи\", \"Тема\", \"Описание\", \"Исправить в версиях\", " +
            "\"Окружение\", \"Затронуты версии\", \"Связанные задачи\"")
    public static void setTaskFields(String taskType, String taskName, String taskDescription, String taskFixInVersion,
                                     String taskEnvironment, String taskAffectedVersion, String connectedTask) {
        setTaskType(taskType);
        setTaskName(taskName);
        setTaskDescription(taskDescription);
        setTaskFixInVersion(taskFixInVersion);
        setTaskEnvironment(taskEnvironment);
        setTaskAffectedVersion(taskAffectedVersion);
        setConnectedTask(connectedTask);
    }
}
