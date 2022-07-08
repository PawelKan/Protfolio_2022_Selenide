package utils;

import com.codeborne.selenide.SelenideElement;

public class CommonActions {

    public static void clearAndType(SelenideElement selenideElement, String text) {
        selenideElement.clear();
        selenideElement.sendKeys(text);
    }

    public static void selectElementFromList(SelenideElement selenideElement, String text) {
        selenideElement.selectOption(text);
    }
}
