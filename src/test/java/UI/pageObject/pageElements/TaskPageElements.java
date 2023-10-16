package UI.pageObject.pageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.*;

public final class TaskPageElements {
    public static final SelenideElement taskStatus = $x("//span[@id='status-val']");
    public static final SelenideElement taskFixInVersion = $x("//span[@id='fixVersions-field']");
    public static final SelenideElement taskInProgressButton = $(byText("В работе"));
    public static final SelenideElement taskBusinessProcessButton = $(byText("Бизнес-процесс"));
    public static final SelenideElement taskResolvedButton = $(byText("Исполнено"));
    public static final SelenideElement taskAcceptButton = $x("//input[@id='issue-workflow-transition-submit']");
    public static final SelenideElement taskDoneButton = $(byText("Подтверждено"));
}
