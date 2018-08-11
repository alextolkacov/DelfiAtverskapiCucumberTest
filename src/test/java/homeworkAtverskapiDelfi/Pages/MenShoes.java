package homeworkAtverskapiDelfi.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class MenShoes {
    private final By BLACK = By.xpath(".//*[@style = 'background-color: #222223']");
    private final By KURPES = By.xpath(".//*[@for = 'tags-205']");
    private final By JAUNS = By.xpath(".//label[contains(text(), 'Jauns')]");
    private final By SUBMIT_BTN = By.xpath(".//*[@type = 'submit']");
    private final By BLACK_MEN_SHOES = By.xpath(".//*[@class = 'card card-shadow card-default']");
    private final By ADVERTISMENT = By.xpath(".//a[@class = 'ado-frame-clicktag']");
    private final By TAB_BAR = By.xpath(".//div[@class = 'navbar-inside clearfix']");
    private final By FILTERS = By.xpath(".//div[@class = 'filters hidden-xs']");
    BaseFunc baseFunc;

    public MenShoes(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        Assert.assertTrue("There is no Advertisment", baseFunc.isElementPresent(ADVERTISMENT));
        Assert.assertTrue("There is no tab bar", baseFunc.isElementPresent(TAB_BAR));
        Assert.assertTrue("There are no filters", baseFunc.isElementPresent(FILTERS));
    }

    public void clickToShoes() {
        baseFunc.getElement(KURPES).click();
    }

    public void clickToBlack() {
        baseFunc.getElement(BLACK).click();
    }

    public void clickToJauns() {
        baseFunc.getElement(JAUNS).click();
    }

    private WebElement getElementByID(Integer id) {
        List<WebElement> articles = baseFunc.getElements(BLACK_MEN_SHOES);
        return articles.get(id);
    }

    public ArticlePage openArticlePage(Integer id) {
        getElementByID(id).click();
        return new ArticlePage(baseFunc);
    }

    public String getTitleById(Integer id) {
        List<WebElement> articles = baseFunc.getElements(JAUNS);
        return getElementByID(id).getText();
    }

    public void clickSubmit(String submit) {
        List<WebElement> submitBTNS = baseFunc.getElements(SUBMIT_BTN);

        for (int i = 0; i < submitBTNS.size(); i++) {
            if (submitBTNS.get(i).getText().equals(submit)) ;
            submitBTNS.get(i).click();
            break;
        }
    }
}
