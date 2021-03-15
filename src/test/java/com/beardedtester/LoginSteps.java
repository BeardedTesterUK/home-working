package com.beardedtester;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.WebDriver;
import pages.FrameEditorPage;
import pages.HomePage;
import pages.LoginPage;
import pages.NavigationPage;
import utils.TestFunctions;

import static org.junit.Assert.assertEquals;
import static utils.DriverFactory.getFireFoxDriver;
import static utils.TestFunctions.*;



public class LoginSteps {
    WebDriver driver;
    LoginPage login;
    NavigationPage nav;
    HomePage home;
    FrameEditorPage frame;

    @Given("^the home page$")
    public void the_Symbiote_home_page(){
        home = new HomePage(driver);
        home.navigateTo("https://the-internet.herokuapp.com/");
    }

    @When("^logging in as an admin$")
    public void logging_in_as_an_admin(){
        home.clickFormAuthentication();
        login = new LoginPage(driver);
        login.loginAsAdmin();
    }

    @When("^Input into frame$")
    public void input_into_frame(){
        home.clickWysiwygEditor();
        frame = new FrameEditorPage(driver);
        frame.clearTextArea();
        String testString = TestFunctions.buildRandomFunction();
        frame.setTextArea(testString);
        frame.decreaseIndention();
        frame.setTextArea("world");
    }

    @Then("^Text input is correct$")
    public void text_input_is_correct(){
        String editorText = frame.getTextFromEditor();
        assertEquals( "Text from editor is incorrect","hello"+"world",editorText);
    }

    @Then("^the home page navigation is available$")
    public void the_home_page_navigation_is_available(){
        nav = new NavigationPage(driver);
        nav.checkForNavigationPage();
    }

    @Before("@First")
    public void startUp(){
        driver = getFireFoxDriver();
    }

    @After("@First")
    public void tearDown(){
        driver.quit();
    }
}
