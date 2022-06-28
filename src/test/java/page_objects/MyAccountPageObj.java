package page_objects;

import com.codeborne.selenide.SelenideElement;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$;

public class MyAccountPageObj {

    @Getter
    public final SelenideElement headerMyAccount = $(".page-heading");

    public void checkHeaderIsDisplayed(){
        getHeaderMyAccount().isDisplayed();
    }

}
