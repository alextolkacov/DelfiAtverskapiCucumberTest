package homeworkAtverskapiDelfi.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;

public class DropdownToggle {
    private final By APAVI = By.xpath(".//*[@href = 'http://atverskapi.delfi.lv/lv/style/sludinajumi/viriesiem/38-apavi']");
    private final By DROPDOWN_MENU = By.xpath(".//ul[@class = 'dropdown-menu']/li/a");

    BaseFunc baseFunc;

    public DropdownToggle(BaseFunc baseFunc){
        this.baseFunc = baseFunc;
        Assert.assertTrue("There is no dropdown window", baseFunc.isElementPresent(DROPDOWN_MENU));
    }

    public MenShoes clickToApavi(){
        baseFunc.getElement(APAVI).click();
        return new MenShoes(baseFunc);
    }
}
