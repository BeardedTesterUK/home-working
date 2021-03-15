package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LoginPage extends BasePage{

    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("#login button");

    public LoginPage(WebDriver driver){
        super(driver);
    }

    //public void setUsername(String username){
       // driver.findElement(usernameField).sendKeys(username);
   // }

    //public void setPassword(String password){
        //driver.findElement(passwordField).sendKeys(password);
    //}

   // public SecureAreaPage clickLoginButton(){
     //   driver.findElement(loginButton).click();
     //   return new SecureAreaPage(driver);
    //}


    public LoginPage loginAsAdmin() {
        //find(usernameField).sendKeys("tomsmith");
        type("tomsmith", usernameField);
        find(passwordField).sendKeys("SuperSecretPassword!");
        click(loginButton);
        //WebElement open = driver.findElement(By.id("open"));
        //open.click();

        //WebElement username = driver.findElement(By.id("username"));
        //username.sendKeys("admin");

       // WebElement password = driver.findElement(By.id("password"));
        //password.sendKeys("admin");

        //WebElement login = driver.findElement(By.id("login-button"));
        //login.submit();

        return new LoginPage(driver);
    }
}
