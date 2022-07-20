package tests;

import com.codeborne.selenide.Condition;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page_objects.PageContentObj;
import page_objects.PageFooterObj;
import page_objects.PageHeaderObj;
import utils.Urls;

import static com.codeborne.selenide.Selenide.open;

public class Functional_HomePageTests extends BaseTest {

    PageHeaderObj pageHeader = new PageHeaderObj();
    PageContentObj pageContent = new PageContentObj();
    PageFooterObj pageFooter = new PageFooterObj();

    @BeforeMethod
    public void openHomePage(){
        open(Urls.HOME_PAGE);
    }

    @Test
    public void checkHomePageMainElements(){
        pageHeader.getPageHeader().shouldBe(Condition.visible);
        pageHeader.getImgHeaderLogo().shouldBe(Condition.visible);
        pageHeader.getBtnHeaderContactUs().shouldBe(Condition.visible);
        pageHeader.getBtnHeaderSignIn().shouldBe(Condition.visible);
        pageHeader.getTxtHeaderSearchBox().shouldBe(Condition.visible);

        pageContent.getPageContent().shouldBe(Condition.visible);

        for (var element: pageContent.getPopularProductsList()) {
            element.shouldBe(Condition.visible);
        }

        pageFooter.getPageFooter().shouldBe(Condition.visible);
    }
}
