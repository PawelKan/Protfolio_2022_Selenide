package tests;

import com.codeborne.selenide.Condition;
import lombok.SneakyThrows;
import org.testng.annotations.Test;
import page_objects.PageHeaderObj;
import page_objects.LoginPageObj;
import page_objects.MyAccountPageObj;
import utils.Urls;
import models.Users;

import static com.codeborne.selenide.Selenide.open;

public class Functional_LoginIntoAppTests extends BaseTest {

    PageHeaderObj pageHeader = new PageHeaderObj();
    LoginPageObj loginPage = new LoginPageObj();
    MyAccountPageObj myAccountPage = new MyAccountPageObj();

    @Test
    public void loginIntoPageWithEmptyUserCredentials() {
        open(Urls.LOGIN_PAGE);
        pageHeader.getBtnHeaderSignIn().click();

        loginPage.getHeaderAuthentication().shouldHave(Condition.text("Authentication"));
        loginPage.getBtnLoginSubmit().click();
        loginPage.checkAlertMessageThereIsOneError();
    }

    @Test
    public void loginIntoPageWithInvalidUserName() {
        open(Urls.LOGIN_PAGE);
        pageHeader.getBtnHeaderSignIn().click();

        loginPage.getHeaderAuthentication().shouldHave(Condition.text("Authentication"));
        loginPage.loginIntoAppWithUserParameters("InvalidUser1234", Users.userPass);

        loginPage.getBtnLoginSubmit().click();

        loginPage.checkAlertMessageThereIsOneError();
    }

    @Test
    public void loginIntoPageWithInvalidUserPassword() {
        open(Urls.LOGIN_PAGE);
        pageHeader.getBtnHeaderSignIn().click();

        loginPage.getHeaderAuthentication().shouldHave(Condition.text("Authentication"));
        loginPage.loginIntoAppWithUserParameters(Users.userName, "InvalidPassword1111");

        loginPage.getBtnLoginSubmit().click();

        loginPage.checkAlertMessageThereIsOneError();
    }

    @Test
    @SneakyThrows
    public void loginIntoPageWithValidUser() {
        open(Urls.HOME_PAGE);
        pageHeader.getBtnHeaderSignIn().click();

        loginPage.getHeaderAuthentication().shouldHave(Condition.text("Authentication"));
        loginPage.loginIntoAppWithUserParameters(Users.userName, Users.userPass);

        myAccountPage.checkHeaderIsDisplayed();
        myAccountPage.checkMyAccountButtons();

        pageHeader.btnHeaderSingOut.click();
    }
}
