package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import page_objects.*;
import utils.CookiesHelpers;
import utils.Urls;
import utils.testData.Users;
import utils.testData.UsersData;

import static com.codeborne.selenide.Selenide.open;

public class Functional_MyAddressesTests extends TestBase {

    HomePageObj homePage = new HomePageObj();
    LoginPageObj loginPage = new LoginPageObj();
    MyAccountPageObj myAccount = new MyAccountPageObj();
    MyAccount_MyAddressesPageObj myAddresses = new MyAccount_MyAddressesPageObj();
    MyAccount_MyAddressesUpdatePageObj myAddressesUpdate = new MyAccount_MyAddressesUpdatePageObj();

    @BeforeTest
    public void loginIntoApp() {
        open(Urls.HOME_PAGE);
        homePage.getBtnSignIn().click();

        loginPage.getHeaderAuthentication().shouldHave(Condition.text("Authentication"));
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
        CookiesHelpers.loadCookies();
        open(Urls.MY_ACCOUNT_PAGE);
        myAccount.getBtnMyAddresses().click();
        myAddresses.checkMyAddressesPageElements();
        myAddresses.btnUpdate.click();

        myAddressesUpdate.checkMyAddressesUpdatePageElements();
        myAddressesUpdate.getBtnBackToYourAddress().click();

        myAddresses.btnUpdate.click();
        myAddressesUpdate.updateAddressForUser(
                UsersData.sFirstNameUpdate,
                UsersData.sLastNameUpdate,
                UsersData.sCompanyUpdate,
                UsersData.sAddressUpdate,
                UsersData.sAddressLine2Update,
                UsersData.sCityUpdate,
                UsersData.sStateUpdate,
                UsersData.sZipPostalCodeUpdate,
                UsersData.sCountryUpdate,
                UsersData.sHomePhoneUpdate,
                UsersData.sMobilePhoneUpdate,
                UsersData.sAdditionalInformationUpdate,
                UsersData.sAddressTitleAliasUpdate);

        myAddressesUpdate.getBtnSave().click();
    }
}
