package UI.pageObject.pageElements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$x;

public final class ProfilePageElements {
    public static final SelenideElement displayedUserName = $x("//dd[@id='up-d-username']");
}
