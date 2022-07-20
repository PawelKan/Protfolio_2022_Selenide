package page_objects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

public class BasePageObj {

    @Getter
    private SelenideElement pageHeader = $("#header");

    @Getter
    private SelenideElement pageContent = $("#columns.container");

    @Getter
    private SelenideElement pageFooter = $("#footer");

}
