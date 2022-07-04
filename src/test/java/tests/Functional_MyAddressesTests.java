package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_objects.HomePageObj;
import page_objects.LoginPageObj;
import page_objects.MyAccountPageObj;
import page_objects.MyAccount_MyAddressesPageObj;
import utils.CookiesHelpers;
import utils.Urls;
import utils.Users;

import static com.codeborne.selenide.Selenide.open;

public class Functional_MyAddressesTests extends TestBase {

    HomePageObj homePage = new HomePageObj();
    LoginPageObj loginPage = new LoginPageObj();
    MyAccountPageObj myAccount = new MyAccountPageObj();
    MyAccount_MyAddressesPageObj myAddresses = new MyAccount_MyAddressesPageObj();

    @BeforeTest
    public void loginIntoApp(){
        open(Urls.HOME_PAGE);
        homePage.getBtnSignIn().click();

        loginPage.getHeaderAuthentication().shouldHave(Condition.text("Authentication"));
        loginPage.loginIntoAppWithUserParameters(Users.userName, Users.userPass);
        homePage.getBtnSingOut().shouldBe(Condition.visible);
        myAccount.checkHeaderIsDisplayed();
        myAccount.checkMyAccountButtons();

        CookiesHelpers.storeCookies(); // Store cookies for further tests

        homePage.btnSingOut.click();
    }

    @Test
    public void tryToLoginWithCookies(){
        CookiesHelpers.loadCookies(); // load session cookies
        open(Urls.HOME_PAGE);
    }

    @Test
    public void editUserAddressInMyAccount(){
        CookiesHelpers.loadCookies(); // load session cookies
        open(Urls.MY_ACCOUNT_PAGE);
        myAccount.getBtnMyAddresses().click();
        myAddresses.checkMyAddressesPageElements();
    }
}
