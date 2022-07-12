package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.*;

public class MyAccount_MyAddressesPageObj {

    @Getter
    private ElementsCollection listOfAddresses = $$("#center_column > div.addresses > div > div");

    @Getter
    public SelenideElement headerMyAddresses = $(".page-heading");

    @Getter
    public SelenideElement sectionDefaultAddressSection = $("#center_column > div.addresses > div > div");
    public SelenideElement btnUpdate = sectionDefaultAddressSection.find(By.cssSelector("li.address_update > a:nth-child(1)[title=\"Update\"]"));
    public SelenideElement btnDelete = sectionDefaultAddressSection.find(By.cssSelector("li.address_update > a:nth-child(2)[title=\"Delete\"]"));

    public SelenideElement btnAddNewAddress = $("#center_column > div.clearfix.main-page-indent > a > span");
    public SelenideElement btnBackToYourAccount = $("#center_column > ul > li:nth-child(1) > a > span");
    public SelenideElement btnHome = $("#center_column > ul > li:nth-child(2) > a > span");

    public void checkMyAddressesPageElements() {
        headerMyAddresses.shouldBe(Condition.visible);
        sectionDefaultAddressSection.shouldBe(Condition.visible);
        btnUpdate.shouldBe(Condition.visible);
        btnDelete.shouldBe(Condition.visible);
        btnAddNewAddress.shouldBe(Condition.visible);
        btnBackToYourAccount.shouldBe(Condition.visible);
        btnHome.shouldBe(Condition.visible);
    }

    public void acceptDeletionAddressAlert(){
        //Alert alert = switchTo().alert();
        switchTo().alert().accept();
    }


}
