package tests;

import com.codeborne.selenide.Configuration;
import lombok.SneakyThrows;
import org.testng.annotations.BeforeSuite;

import java.io.FileInputStream;
import java.util.Properties;

public class TestBase {

    @BeforeSuite
    @SneakyThrows
    public static void ConfigBrowser(){
        Properties prop = new Properties();
        prop.load(new FileInputStream("src/main/resources/properties.properties"));

        Configuration.browser= prop.get("browser").toString();
        Configuration.browserSize = prop.get("browserSize").toString();
        Configuration.baseUrl = prop.get("baseUrl").toString();
        Configuration.timeout = Long.parseLong(prop.get("timeout").toString());
        Configuration.holdBrowserOpen = Boolean.parseBoolean(prop.get("holdBrowserOpen").toString());
    }
}
