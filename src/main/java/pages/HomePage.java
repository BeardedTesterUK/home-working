package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends BasePage {

    private By formAuthenticationLink = By.linkText("Form Authentication");
    private By wysiwigEditorLink = By.linkText("WYSIWYG Editor");

        public HomePage (WebDriver driver){
            super(driver);
        }

    public LoginPage clickFormAuthentication(){
        click(formAuthenticationLink);
        return new LoginPage(driver);
    }

    public FrameEditorPage clickWysiwygEditor() {
        click(wysiwigEditorLink);
        return new FrameEditorPage(driver);
    }
}
