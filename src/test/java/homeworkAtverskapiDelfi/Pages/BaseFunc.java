package homeworkAtverskapiDelfi.Pages;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;

public class BaseFunc {

    WebDriver driver;

    public BaseFunc(){
        System.setProperty("webdriver.gecko.driver", "C://QA2/geckodriver.exe");
        driver = new FirefoxDriver();
        driver.manage().window().maximize();
    }

    public void openPage(String url){
        driver.get(url);
    }

    public List<WebElement> getElements(By locator){
        Assert.assertFalse("No elements found" , driver.findElements(locator).isEmpty());
        return driver.findElements(locator);
    }

    public WebElement getElement(By locator){
        Assert.assertFalse("Element is not found", getElements(locator).isEmpty());
        return driver.findElement(locator);
    }

    public void back(){
        driver.navigate().back();
    }

    public void waitLoad(){
        WebDriverWait wait = new WebDriverWait(driver, 50);
        wait.until(ExpectedConditions.visibilityOfAllElements());
    }

    public boolean isElementPresent(By locator){
        return getElements(locator).isEmpty();
    }
    private void waitForElement(By locator){
        new WebDriverWait(driver, 10).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }
}
