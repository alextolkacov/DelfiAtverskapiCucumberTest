package cucumberStepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homeworkAtverskapiDelfi.Pages.ArticlePage;
import homeworkAtverskapiDelfi.Pages.BaseFunc;
import homeworkAtverskapiDelfi.Pages.MenShoes;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AtverskapiDelfiStepDefs {
    BaseFunc baseFunc = new BaseFunc();
    MenShoes menShoes;
    ArticlePage articlePage;

    private final String HOME_PAGE = "http://atverskapi.delfi.lv/lv/style";
    private final By VIRIESIEM = By.xpath(".//a[contains(text(), 'Vīriešiem')]");
    private final By APAVI = By.xpath(".//*[@href = 'http://atverskapi.delfi.lv/lv/style/sludinajumi/viriesiem/38-apavi']");
    private final By KURPES = By.xpath(".//*[@for = 'tags-205']");
    private final By BLACK = By.xpath(".//*[@style = 'background-color: #222223']");
    private final By JAUNS = By.xpath(".//label[contains(text(), 'Jauns')]");
    private final By SUBMIT_BTN = By.xpath(".//*[@type = 'submit']");
    private final By ADVERTISMENT = By.xpath(".//a[@class = 'ado-frame-clicktag']");
    private final By TAB_BAR = By.xpath(".//div[@class = 'navbar-inside clearfix']");
    private final By FILTERS = By.xpath(".//div[@class = 'filters hidden-xs']");

    @Given("Atverskapi Delfi home page")
    public void open_home_page() {
        baseFunc.openPage(HOME_PAGE);
    }

    @When("we are clicking on Viriesiem")
    public void clicking_on_viriesiem() {
        baseFunc.getElement(VIRIESIEM).click();
    }

    @And("clicking on Apavi")
    public void clicking_on_apavi() {
        baseFunc.getElement(APAVI).click();
    }

    @Then("men shoes page appears")
    public void men_shoes_page() {
        Assert.assertTrue("There is no Advertisment", baseFunc.isElementPresent(ADVERTISMENT));
        Assert.assertTrue("There is no tab bar", baseFunc.isElementPresent(TAB_BAR));
        Assert.assertTrue("There are no filters", baseFunc.isElementPresent(FILTERS));
    }

    @When("we are clicking on filter Shoes")
    public void click_on_shoes() {
        baseFunc.getElement(KURPES).click();
    }

    @And("we are clicking on filter Black")
    public void clicking_on_black() {
        baseFunc.getElement(BLACK).click();
    }

    @And("we are clicking on filter New")
    public void clicking_on_jauns() {
        baseFunc.getElement(JAUNS).click();
    }

    @And("we are clicking on BTN (.*)")
    public void filtret(String submitBTN) {
        menShoes.clickSubmit("Filtrēt");
    }

    @Then("check search results")
    public void check() {
        articlePage.compareNewAndBlack();
    }
}
