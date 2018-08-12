package cucumberStepDefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import homeworkAtverskapiDelfi.Pages.*;
import org.junit.Assert;
import org.openqa.selenium.By;

public class AtverskapiDelfiStepDefs {
    BaseFunc baseFunc = new BaseFunc();
    MenShoes menShoes = new MenShoes(baseFunc);
    ArticlePage articlePage = new ArticlePage(baseFunc);
    DropdownToggle dropdownToggle = new DropdownToggle(baseFunc);
    HomePage homePage = new HomePage(baseFunc);


    private final String HOME_PAGE = "http://atverskapi.delfi.lv/lv/style";
    private final By ADVERTISMENT = By.xpath(".//a[@class = 'ado-frame-clicktag']");
    private final By TAB_BAR = By.xpath(".//div[@class = 'navbar-inside clearfix']");
    private final By FILTERS = By.xpath(".//div[@class = 'filters hidden-xs']");

    @Given("Atverskapi Delfi home page")
    public void open_home_page() {
        baseFunc.openPage(HOME_PAGE);
    }

    @When("we are clicking on dropdown toggle and Viriesiem")
    public void clicking_on_viriesiem() {
        homePage.clickDropdownToggle();
    }

    @Then("clicking on Apavi")
    public void clicking_on_apavi() {
        dropdownToggle.clickToApavi();
    }

    @Then("men shoes page appears")
    public void men_shoes_page() {
        Assert.assertTrue("There is no Advertisment", baseFunc.isElementPresent(ADVERTISMENT));
        Assert.assertTrue("There is no tab bar", baseFunc.isElementPresent(TAB_BAR));
        Assert.assertTrue("There are no filters", baseFunc.isElementPresent(FILTERS));
    }

    @When("we are clicking on filter Shoes")
    public void click_on_shoes() {
        menShoes.clickToShoes();
    }

    @Then("we are clicking on filter Black")
    public void clicking_on_black() {
        menShoes.clickToBlack();
    }

    @Then("we are clicking on filter New")
    public void clicking_on_jauns() {
        menShoes.clickToJauns();
    }

    @Then("we are clicking on BTN (.*)")
    public void filtret() {
        menShoes.clickSubmit("Filtrēt");
    }

    @Then("check search results")
    public void check() {
        articlePage.compareNewAndBlack();
    }
}
