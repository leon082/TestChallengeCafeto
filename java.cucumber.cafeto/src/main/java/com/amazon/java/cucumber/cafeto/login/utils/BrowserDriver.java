package com.amazon.java.cucumber.cafeto.login.utils;

import java.util.logging.Level;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
/**
 *
 * @author luis.leon
 */
public class BrowserDriver {
    
	private static final Logger LOGGER = Logger.getLogger(BrowserDriver.class.getName());
	private static WebDriver mDriver;
	
	public synchronized static WebDriver getCurrentDriver() {
		if (mDriver==null) {
                    System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
			 mDriver=new ChromeDriver();
                         
                         mDriver.manage().window().maximize();
		}
        return mDriver;
    }


        public static void show(){
            try {
                Thread.sleep(3000);
            } catch (InterruptedException ex) {
                Logger.getLogger(BrowserDriver.class.getName()).log(Level.SEVERE, null, ex);
            }
}
	
}

