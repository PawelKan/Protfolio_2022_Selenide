package page_objects;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageObj {

    String headerAuthentication = ".page-heading";
    String txtEmailAddressLogin = "#email";
    String txtPasswordLogin = "#passwd";
    String btnLoginSubmit = "#SubmitLogin";

    public SelenideElement headerAuthentication(){ return $(headerAuthentication);    }
    public SelenideElement txtEmailAddressLogin(){ return $(txtEmailAddressLogin);    }
    public SelenideElement txtPasswordLogin(){ return $(txtPasswordLogin);    }

    public SelenideElement btnLoginSubmit() { return $(btnLoginSubmit);    }
}
