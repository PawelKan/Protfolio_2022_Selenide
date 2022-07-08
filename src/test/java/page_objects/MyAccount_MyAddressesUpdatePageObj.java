package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import utils.CommonActions;

import static com.codeborne.selenide.Selenide.$;

public class MyAccount_MyAddressesUpdatePageObj {

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

    public void updateAddressForUser(String sFirstNameUpdate, String sLastName, String sCompany,
                                     String sAddress, String sAddressLine2, String sCity, String sState, String sZipPostalCode,
                                     String sCountry, String sHomePhone, String sMobilePhone, String sAdditionalInformation, String sAddressTitleAlias) {

        CommonActions.clearAndType(txtFirstName, sFirstNameUpdate);
        CommonActions.clearAndType(txtLastName, sLastName);
        CommonActions.clearAndType(txtCompany, sCompany);
        CommonActions.clearAndType(txtAddress, sAddress);
        CommonActions.clearAndType(txtAddressLine2, sAddressLine2);
        CommonActions.clearAndType(txtCity, sCity);
        CommonActions.selectElementFromList(listState, sState);
        CommonActions.clearAndType(txtZipPostalCode, sZipPostalCode);
        CommonActions.selectElementFromList(listCountry, sCountry);
        CommonActions.clearAndType(txtHomePhone, sHomePhone);
        CommonActions.clearAndType(txtMobilePhone, sMobilePhone);
        CommonActions.clearAndType(txtAdditionalInformation, sAdditionalInformation);
        CommonActions.clearAndType(txtAddressTitleAlias, sAddressTitleAlias);
    }
}
