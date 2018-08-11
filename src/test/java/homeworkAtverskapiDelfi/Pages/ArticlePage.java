package homeworkAtverskapiDelfi.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;


public class ArticlePage {
    private final By COLOR_TYPE = By.xpath(".//b[@itemprop = 'color']");
    private final By ARTICLE_JAUNS = By.xpath(".//b[contains(text(), 'Jauns')]");
    private final By ADVERTISMENT = By.xpath(".//a[@class = 'ado-frame-clicktag']");
    private final By ARTICLE_PICTURE = By.xpath(".//*[@class = 'img-responsive-force']");
    private final By DESCRIPTION = By.xpath(".//div[@class = 'col-xs-12 col-md-6 product-description']");

    BaseFunc baseFunc;

    public ArticlePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        Assert.assertTrue("There is no advertisment", baseFunc.isElementPresent(ADVERTISMENT));
        Assert.assertTrue("There are no pictures", baseFunc.isElementPresent(ARTICLE_PICTURE));
        Assert.assertTrue("There is no description", baseFunc.isElementPresent(DESCRIPTION));
    }

    private String articleColor() {
        return baseFunc.getElement(COLOR_TYPE).getText();
    }

    public void compareColors(String color) {
        Assert.assertTrue("Colors are not equal", articleColor().contains(color));
    }

    public void compareCondition(String condition) {
        Assert.assertTrue("Conditions are not equal", articleJauns().contains(condition));
    }

    public String articleJauns() {
        return baseFunc.getElement(ARTICLE_JAUNS).getText();
    }

    public void compareNewAndBlack(){
        compareCondition("Jauns");
        compareColors("Melna");
        baseFunc.back();
    }
}
