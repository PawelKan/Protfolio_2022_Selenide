package utils;

import com.codeborne.selenide.WebDriverRunner;
import org.openqa.selenium.Cookie;

import java.util.Set;

public class CookiesHelpers {

    public static Set<Cookie> myCookieSet;

    public static Set<Cookie> storeCookies() {
        return myCookieSet = WebDriverRunner.getWebDriver().manage().getCookies();
    }

    public static void loadCookies() {
        for (Cookie cookie : myCookieSet) {
            WebDriverRunner.getWebDriver().manage().addCookie(cookie);
        }
    }
}
