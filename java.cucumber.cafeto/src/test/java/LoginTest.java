

import io.cucumber.junit.Cucumber;
import org.junit.runner.RunWith;
import io.cucumber.junit.CucumberOptions;




/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author luis.leon
 */
@RunWith(Cucumber.class)
@CucumberOptions(plugin = "pretty", features = "src/main/resources/")
public class LoginTest {
    
}
