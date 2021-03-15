package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class NavigationPage extends BasePage {
    public NavigationPage(WebDriver driver){
        super(driver);
    }

    public NavigationPage checkForNavigationPage() {
        WebElement navList = new WebDriverWait(driver, 10)
               .until(ExpectedConditions.visibilityOfElementLocated(By.id("content")));
        System.out.println(" navList Webelement contains " + navList);

        return new NavigationPage(driver);
    }
}
