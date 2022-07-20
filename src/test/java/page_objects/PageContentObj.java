package page_objects;

import com.codeborne.selenide.ElementsCollection;
import lombok.Getter;

import static com.codeborne.selenide.Selenide.$$;

public class PageContentObj extends BasePageObj {

    @Getter
    private ElementsCollection popularProductsList = $$("#homefeatured .product-container");
    @Getter
    private ElementsCollection bestsellerProductsList = $$("#blockbestsellers .product-container");

}
