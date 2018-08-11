package homeworkAtverskapiDelfi.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class HomePage {
    private final By VIRIESIEM = By.xpath(".//a[contains(text(), 'Vīriešiem')]");
    private final By ADVERTISMENT = By.xpath(".//a[@class = 'ado-frame-clicktag']");
    private final By TAB_BAR = By.xpath(".//div[@class = 'navbar-inside clearfix']");
    private final By ROW = By.xpath("row");

    BaseFunc baseFunc;

    public HomePage(BaseFunc baseFunc) {
        this.baseFunc = baseFunc;
        Assert.assertTrue("There is no advertisment", baseFunc.isElementPresent(ADVERTISMENT));
        Assert.assertTrue("There is no tab bar", baseFunc.isElementPresent(TAB_BAR));
        Assert.assertTrue("There is no row", baseFunc.isElementPresent(ROW));
    }

    public DropdownToggle clickDropdownToggle() {
        baseFunc.getElement(VIRIESIEM).click();
        return new DropdownToggle(baseFunc);
    }

    private WebElement getDropdownWindowByGender(Integer gender) {
        List<WebElement> genders = baseFunc.getElements(VIRIESIEM);
        return genders.get(gender);
    }

}
