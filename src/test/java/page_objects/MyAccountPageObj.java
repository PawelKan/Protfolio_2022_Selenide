package page_objects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

public class MyAccountPageObj {

    @Getter
    public final SelenideElement headerMyAccount = $(".page-heading");
    @Getter
    public final SelenideElement btnOrderHistoryAndDetails = $("#center_column > div > div:nth-child(1) > ul > li:nth-child(1) > a");
    @Getter
    public final SelenideElement btnMyCreditSlips = $("#center_column > div > div:nth-child(1) > ul > li:nth-child(2) > a");
    @Getter
    public final SelenideElement btnMyAddresses = $("#center_column > div > div:nth-child(1) > ul > li:nth-child(3) > a");
    @Getter
    public final SelenideElement btnMyPersonalInformation = $("#center_column > div > div:nth-child(1) > ul > li:nth-child(4) > a");
    @Getter
    public final SelenideElement btnMyWishlists = $("#center_column > div > div:nth-child(2) > ul > li > a");

    public void checkHeaderIsDisplayed() {
        getHeaderMyAccount().isDisplayed();
    }

    public void checkMyAccountButtons() {
        btnOrderHistoryAndDetails.shouldBe(Condition.visible).shouldHave(Condition.text("Order history and details"));
        btnMyCreditSlips.shouldBe(Condition.visible).shouldHave(Condition.text("My credit slips"));
        btnMyAddresses.shouldBe(Condition.visible).shouldHave(Condition.text("My addresses"));
        btnMyPersonalInformation.shouldBe(Condition.visible).shouldHave(Condition.text("My personal information"));
        btnMyWishlists.shouldBe(Condition.visible).shouldHave(Condition.text("My wishlists"));
    }
}
