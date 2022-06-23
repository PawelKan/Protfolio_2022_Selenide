package tests;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.Test;
import page_objects.*;
import utils.*;



import static com.codeborne.selenide.Selenide.open;

public class HomePageTests {

    @Test
    public void goToLoginPage(){
        Configuration.browserSize = "2560x1440";
        open("http://automationpractice.com/index.php");

        HomePageObj homePage = new HomePageObj();
        LoginPageObj loginPage = new LoginPageObj();

        open("http://automationpractice.com/index.php");
        homePage.btnSignIn().click();

        loginPage.headerAuthentication().shouldHave(Condition.text("Authentication"));

        loginPage.txtEmailAddressLogin().sendKeys(Users.userName);
        loginPage.txtPasswordLogin().sendKeys(Users.userPass);
        loginPage.btnLoginSubmit().click();

        //Thread.sleep(50000000);
        //fbn33265@bcaoo.com/Test1234

    }

}
