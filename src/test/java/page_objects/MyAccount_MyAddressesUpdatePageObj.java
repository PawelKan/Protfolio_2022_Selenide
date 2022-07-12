package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import models.ClientData;
import utils.CommonActions;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class MyAccount_MyAddressesUpdatePageObj {

    @Getter
    private ElementsCollection listOfAddresses = $$("#center_column > div.addresses > div > div");

    @Getter
    public SelenideElement headerYourAddress = $(".page-subheading");
    private String translationHeaderYourAddress = "Your addresses";

    private SelenideElement txtFirstName = $("#firstname");
    private SelenideElement txtLastName = $("#lastname");
    private SelenideElement txtCompany = $("#company");
    private SelenideElement txtAddress = $("#address1");
    private SelenideElement txtAddressLine2 = $("#address2");
    private SelenideElement txtCity = $("#city");
    private SelenideElement listState = $("#id_state");
    private SelenideElement txtZipPostalCode = $("#postcode");
    private SelenideElement listCountry = $("#id_country");
    private SelenideElement txtHomePhone = $("#phone");
    private SelenideElement txtMobilePhone = $("#phone_mobile");
    private SelenideElement txtAdditionalInformation = $("#other");
    private SelenideElement txtAddressTitleAlias = $("#alias");

    @Getter
    private SelenideElement btnSave = $("#submitAddress");
    private String translationSave = "Save";

    @Getter
    private SelenideElement btnBackToYourAddress = $(".footer_links.clearfix .btn");
    private String translationBackToYourAddress = " Back to your addresses";

//    public SelenideElement getLastAddedAddressSection(){
//        SelenideElement lastAddress;
//        return new SelenideElement lastAddress = listOfAddresses.last();
//    }
    public void checkMyAddressesUpdatePageElements() {
        headerYourAddress.shouldBe(Condition.visible).shouldHave(Condition.text(translationHeaderYourAddress));
        txtFirstName.shouldBe(Condition.visible);
        txtLastName.shouldBe(Condition.visible);
        txtCompany.shouldBe(Condition.visible);
        txtAddress.shouldBe(Condition.visible);
        txtAddressLine2.shouldBe(Condition.visible);
        txtCity.shouldBe(Condition.visible);
        listState.shouldBe(Condition.exist);
        txtZipPostalCode.shouldBe(Condition.visible);
        listCountry.shouldBe(Condition.exist);
        txtHomePhone.shouldBe(Condition.visible);
        txtMobilePhone.shouldBe(Condition.visible);
        txtAdditionalInformation.shouldBe(Condition.visible);
        txtAddressTitleAlias.shouldBe(Condition.visible);
        btnSave.shouldBe(Condition.visible).shouldHave(Condition.text(translationSave));
        btnBackToYourAddress.shouldBe(Condition.visible).shouldHave(Condition.text(translationBackToYourAddress));
    }

    public void updateAddressForUser(ClientData clientData){
        CommonActions.clearAndType(txtFirstName, clientData.getFirstNameUpdate());
        CommonActions.clearAndType(txtLastName, clientData.getLastNameUpdate());
        CommonActions.clearAndType(txtCompany, clientData.getCompanyUpdate());
        CommonActions.clearAndType(txtAddress, clientData.getAddressUpdate());
        CommonActions.clearAndType(txtAddressLine2, clientData.getAddressLine2Update());
        CommonActions.clearAndType(txtCity, clientData.getCityUpdate());
        CommonActions.selectElementFromList(listState, clientData.getStateUpdate());
        CommonActions.clearAndType(txtZipPostalCode, clientData.getZipPostalCodeUpdate());
        CommonActions.selectElementFromList(listCountry, clientData.getCountryUpdate());
        CommonActions.clearAndType(txtHomePhone, clientData.getHomePhoneUpdate());
        CommonActions.clearAndType(txtMobilePhone, clientData.getMobilePhoneUpdate());
        CommonActions.clearAndType(txtAdditionalInformation, clientData.getAdditionalInformationUpdate());
        CommonActions.clearAndType(txtAddressTitleAlias, clientData.getAddressTitleAliasUpdate());
    }
}
