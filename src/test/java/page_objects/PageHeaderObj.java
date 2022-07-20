package page_objects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

public class PageHeaderObj extends BasePageObj {

    @Getter
    public SelenideElement btnHeaderSignIn = $(".login");
    @Getter
    public SelenideElement btnHeaderSingOut = $(".logout");
    @Getter
    public SelenideElement btnHeaderContactUs = $("#contact-link");
    @Getter
    private SelenideElement imgHeaderLogo = $(".logo");
    @Getter
    private SelenideElement txtHeaderSearchBox =  $("#search_query_top");
    @Getter
    private SelenideElement btnHeaderCart =  $(".shopping_cart");
}
