package UI.pageObject.pageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public final class ProjectPageElements {
    public static final SelenideElement taskCreationHeader = $x("//h2[@id='jira-dialog2__heading']");
    public static final SelenideElement projectName = $x("//div[@class='aui-item project-title']/child::a");
    public static final SelenideElement tasksButton = $x("//li[@class='aui-nav-selected' and contains(., 'Задачи')]/child::a");
    public static final SelenideElement filtersButton = $x("//button[@id='subnav-trigger']");
    public static final SelenideElement numberOfTasks = $x("//div[@class='showing']");
    public static final SelenideElement createTaskButton = $x("//div[@class='iic-trigger']");
    public static final SelenideElement openInDialogueButton = $(byText("Открыть в диалоговом окне"));
}
