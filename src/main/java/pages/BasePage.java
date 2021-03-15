package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static org.junit.Assert.assertEquals;

public class BasePage {
    protected WebDriver driver;

    public BasePage(WebDriver driver){
        this.driver = driver;
    }

    protected WebElement find (By locator){
        return driver.findElement(locator);
    }

    protected void type (String text, By locator){
        find(locator).clear();
        find(locator).sendKeys(text);
    }

    protected void click (By locator){
        find(locator).click();
    }

    protected Boolean isDisplayed (By locator){
        try{
            return find(locator).isDisplayed();
        }
        catch (NoSuchElementException exc){
            return false;
        }
    }

    public HomePage navigateTo(String url){
        driver.navigate().to(url);
        assertEquals("The Internet", driver.getTitle());
        return new HomePage(driver);
    }
}
