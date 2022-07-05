package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

public class MyAccount_MyAddressesUpdatePageObj {

    @Getter
    public SelenideElement headerYourAddress = $(".page-subheading");
    private String translationHeaderYourAddress = "Your addresses";

    public SelenideElement txtFirstName = $("#firstname");
    public SelenideElement txtLastName = $("#lastname");
    public SelenideElement txtCompany = $("#company");
    public SelenideElement txtAddress = $("#address1");
    public SelenideElement txtAddressLine2 = $("#address2");
    public SelenideElement txtCity = $("#city");
    public SelenideElement listState = $("#id_state");
    public SelenideElement txtZipPostalCode = $("#postcode");
    public SelenideElement listCountry = $("#id_country");
    public SelenideElement txtHomePhone = $("#phone");
    public SelenideElement txtMobilePhone = $("#phone_mobile");
    public SelenideElement txtAdditionalInformation = $("#other");
    public SelenideElement AddressTitleAlias = $("#alias");

    public SelenideElement btnSave = $("#submitAddress");
    private String translationSave = "Save";

    public SelenideElement btnBackToYourAddress = $(".footer_links.clearfix .btn");
    private String translationBackToYourAddress = " Back to your addresses";



    public void checkMyAddressesUpdatePageElements(){
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
        AddressTitleAlias.shouldBe(Condition.visible);
        btnSave.shouldBe(Condition.visible).shouldHave(Condition.text(translationSave));
        btnBackToYourAddress.shouldBe(Condition.visible).shouldHave(Condition.text(translationBackToYourAddress));
    }

}
