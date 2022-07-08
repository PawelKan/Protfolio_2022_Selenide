package tests;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import models.ClientData;
import models.Users;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_objects.*;
import utils.CookiesHelpers;
import utils.Urls;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.open;

public class Functional_MyAddressesTests extends TestBase {

    HomePageObj homePage = new HomePageObj();
    LoginPageObj loginPage = new LoginPageObj();
    MyAccountPageObj myAccount = new MyAccountPageObj();
    MyAccount_MyAddressesPageObj myAddresses = new MyAccount_MyAddressesPageObj();
    MyAccount_MyAddressesUpdatePageObj myAddressesUpdate = new MyAccount_MyAddressesUpdatePageObj();
    Faker fakeData = new Faker();

    @BeforeTest
    public void loginIntoApp() {
        open(Urls.HOME_PAGE);
        homePage.getBtnSignIn().click();

        loginPage.getHeaderAuthentication().shouldHave(text("Authentication"));
        loginPage.loginIntoAppWithUserParameters(Users.userName, Users.userPass);
        homePage.getBtnSingOut().shouldBe(Condition.visible);
        myAccount.checkHeaderIsDisplayed();
        myAccount.checkMyAccountButtons();

        CookiesHelpers.storeCookies(); // Store cookies for further tests
    }

//    @BeforeClass
//    public void loadCookiesForLogin(){
//        CookiesHelpers.loadCookies();
//    }

    @Test
    public void e2e_editUserAddressInMyAccount() {
        ClientData clientData = new ClientData();
        String firstNameForTest = fakeData.name().firstName() + fakeData.name().firstName();
        clientData.setFirstNameUpdate(firstNameForTest);


        CookiesHelpers.loadCookies();
        open(Urls.MY_ACCOUNT_PAGE);
        myAccount.getBtnMyAddresses().click();
        myAddresses.checkMyAddressesPageElements();
        myAddresses.btnUpdate.click();

        myAddressesUpdate.checkMyAddressesUpdatePageElements();
        myAddressesUpdate.getBtnBackToYourAddress().click();

        myAddresses.btnUpdate.click();

        myAddressesUpdate.updateAddressForUser(clientData);

        myAddressesUpdate.getBtnSave().click();

        myAddresses.getSectionDefaultAddressSection().shouldHave(text(firstNameForTest));
    }
}
