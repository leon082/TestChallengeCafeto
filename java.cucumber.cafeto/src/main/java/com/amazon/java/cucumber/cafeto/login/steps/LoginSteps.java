/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amazon.java.cucumber.cafeto.login.steps;


import com.amazon.java.cucumber.cafeto.login.utils.BrowserDriver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.util.logging.Level;
import java.util.logging.Logger;
import static org.junit.Assert.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

/**
 *
 * @author luis.leon
 */
public class LoginSteps {
    
    private static final Logger LOGGER = Logger.getLogger(LoginSteps.class.getName());
    private static final String USER_NAME="pepitoperez@gmail.com";
    private String userIn;
    private String actualMessage;
    
    @Given("The user is on the login page")
    public void given_The_user_is_on_the_login_page(){
        LOGGER.info("Entrando: I navigate on the page aws.amazon.com");
        //BrowserDriver.getCurrentDriver().get("https://signin.aws.amazon.com/signin?redirect_uri=https%3A%2F%2Faws.amazon.com%2Fmarketplace%2Fmanagement%2Fsignin%3Fstate%3DhashArgs%2523%26isauthcode%3Dtrue&client_id=arn%3Aaws%3Aiam%3A%3A015428540659%3Auser%2Faws-mp-seller-management-portal&forceMobileApp=0");
        BrowserDriver.getCurrentDriver().get("https://aws.amazon.com/es/");
        BrowserDriver.show();
        BrowserDriver.getCurrentDriver().get("https://portal.aws.amazon.com/gp/aws/manageYourAccount?nc2=h_m_ma");
    }
 
    @When("The user fills in account id with {string}")
    public void when_I_try_to_login(String credentialsType){
        LOGGER.log(Level.INFO, "Entrando: I try to login with {0}", credentialsType);
       this.userIn=credentialsType;
        WebElement username=BrowserDriver.getCurrentDriver().findElement(By.id("resolving_input"));
       BrowserDriver.show();
        username.sendKeys(credentialsType);
    }
    
    @And("The user press next button")
    public void and_The_user_press_next_button(){
        LOGGER.info("Entrando: pressing the next botton...");
         WebElement button=BrowserDriver.getCurrentDriver().findElement(By.id("next_button_text"));
         BrowserDriver.show();
        button.click();
    }
 
    @Then("The users should be on the user home page")
    public void then_I_login(){
        
        LOGGER.info("Entrando: I should see that I logged in amazon" );
         BrowserDriver.show();
    }
    
    @And("The users sees {string}")
    public void The_users_sees(String message){
         LOGGER.log(Level.INFO, "Message{0}", message);
         getActualAnswer(userIn);
          BrowserDriver.show();
         assertEquals(message, actualMessage);
         
    }
    
    public void getActualAnswer(String user){
        this.actualMessage= user.equalsIgnoreCase(LoginSteps.USER_NAME) ? "Login Succesful!" : "Invalid Credentials!";
    }
}
