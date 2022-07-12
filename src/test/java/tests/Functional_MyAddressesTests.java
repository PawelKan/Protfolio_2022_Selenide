package tests;

import com.codeborne.selenide.Condition;
import com.github.javafaker.Faker;
import models.ClientData;
import models.Users;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
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
    ClientData clientData = new ClientData();

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

    @BeforeMethod
    public void loadCookiesForLogin(){
        CookiesHelpers.loadCookies();
    }

    @Test
    public void e2e_addNewUserAddressInMyAccount() {
        String firstNameForTest = fakeData.name().firstName() + fakeData.name().firstName();
        clientData.setFirstNameUpdate(firstNameForTest);

        String aliasAddressNameForTest = fakeData.address().streetName();
        clientData.setAddressTitleAliasUpdate(aliasAddressNameForTest);

        //CookiesHelpers.loadCookies();
        open(Urls.MY_ACCOUNT_PAGE);
        myAccount.getBtnMyAddresses().click();
        myAddresses.checkMyAddressesPageElements();
        myAddresses.btnAddNewAddress.click();

        myAddressesUpdate.checkMyAddressesUpdatePageElements();
        myAddressesUpdate.getBtnBackToYourAddress().click();

        myAddresses.btnAddNewAddress.click();

        myAddressesUpdate.updateAddressForUser(clientData);

        myAddressesUpdate.getBtnSave().click();

        myAddresses.getListOfAddresses().last().shouldHave(text(firstNameForTest)); // check address was added correctly
    }

    @Test
    public void e2e_editUserAddressInMyAccount() {
        String firstNameForTest = fakeData.name().firstName() + fakeData.name().firstName();
        clientData.setFirstNameUpdate(firstNameForTest);

        //CookiesHelpers.loadCookies();
        open(Urls.MY_ACCOUNT_PAGE);
        myAccount.getBtnMyAddresses().click();
        myAddresses.checkMyAddressesPageElements();
        myAddresses.btnUpdate.click();

        myAddressesUpdate.updateAddressForUser(clientData);
        myAddressesUpdate.getBtnSave().click();
        myAddresses.getSectionDefaultAddressSection().shouldHave(text(firstNameForTest));
    }

    @Test
    public void e2e_deleteUserAddressInMyAccount() {
        //CookiesHelpers.loadCookies();
        open(Urls.MY_ACCOUNT_PAGE);
        myAccount.getBtnMyAddresses().click();

        if (myAddresses.getListOfAddresses().size() > 1) {
            String addressText = myAddresses.getListOfAddresses().last().getText();

            myAddresses.getListOfAddresses().last().find("li.address_update > a:nth-child(2)[title=\"Delete\"]").click();
            myAddresses.acceptDeletionAddressAlert();
            myAddresses.getListOfAddresses().last().shouldNotHave(Condition.text(addressText));

        } else {
            Assert.fail("Address panel shouldn't be empty and have more than 1 addresses");
        }
    }
}
