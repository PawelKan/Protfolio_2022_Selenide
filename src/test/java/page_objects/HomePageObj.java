package page_objects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class HomePageObj {

    String btnSignIn = ".login";

    public SelenideElement btnSignIn(){ return $(btnSignIn);    }

}
