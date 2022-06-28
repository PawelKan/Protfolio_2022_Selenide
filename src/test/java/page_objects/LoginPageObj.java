package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

public class LoginPageObj {
    @Getter
    public SelenideElement headerAuthentication = $(".page-heading");

    @Getter
    public SelenideElement txtEmailAddressLogin = $("#email");

    @Getter
    public SelenideElement txtPasswordLogin = $("#passwd");

    @Getter
    public SelenideElement btnLoginSubmit = $("#SubmitLogin");

    @Getter
    public SelenideElement errorMessage = $("#center_column > div.alert.alert-danger");

    public void checkAlertMessageThereIsOneError(){
        getErrorMessage().should(Condition.text("There is 1 error"));
    }

    public void loginIntoAppWithUserParameters(String userName, String userPassword){
        getTxtEmailAddressLogin().clear();
        getTxtEmailAddressLogin().sendKeys(userName);

        getTxtPasswordLogin().clear();
        getTxtPasswordLogin().sendKeys(userPassword);
    }
}
