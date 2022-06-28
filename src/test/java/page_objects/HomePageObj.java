package page_objects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

public class HomePageObj {

    @Getter
    public SelenideElement btnSignIn = $(".login");
}
