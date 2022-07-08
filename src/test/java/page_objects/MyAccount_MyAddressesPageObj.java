package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

public class MyAccount_MyAddressesPageObj {

    @Getter
    public SelenideElement headerMyAddresses = $(".page-heading");

    public SelenideElement btnDefaultAddressSection = $("#center_column > div.addresses > div > div");
    public SelenideElement btnUpdate = btnDefaultAddressSection.find(By.cssSelector("li.address_update > a:nth-child(1)[title=\"Update\"]"));
    public SelenideElement btnDelete = btnDefaultAddressSection.find(By.cssSelector("li.address_update > a:nth-child(2)[title=\"Delete\"]"));

    public SelenideElement btnAddNewAddress = $("#center_column > div.clearfix.main-page-indent > a > span");
    public SelenideElement btnBackToYourAccount = $("#center_column > ul > li:nth-child(1) > a > span");
    public SelenideElement btnHome = $("#center_column > ul > li:nth-child(2) > a > span");

    public void checkMyAddressesPageElements() {
        headerMyAddresses.shouldBe(Condition.visible);
        btnDefaultAddressSection.shouldBe(Condition.visible);
        btnUpdate.shouldBe(Condition.visible);
        btnDelete.shouldBe(Condition.visible);
        btnAddNewAddress.shouldBe(Condition.visible);
        btnBackToYourAccount.shouldBe(Condition.visible);
        btnHome.shouldBe(Condition.visible);
    }


}
