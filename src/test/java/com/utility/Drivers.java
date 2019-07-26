package com.utility;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class Drivers {
	public static WebDriver getDriver(String browser) {
		// TODO Auto-generated method stub
		if(browser.equals("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Users\\training_b6b.00.10\\Desktop\\Browsers and Drivers\\chromedriver.exe");
		    return new ChromeDriver();
		}
		    else if(browser.equals("firefox")) {
				System.setProperty("webdriver.firefox.driver","C:\\Users\\training_b6b.00.10\\Desktop\\Browsers and Drivers\\geckodriver.exe");
			    return new FirefoxDriver();
		    }
			    else if(browser.equals("ie")) {
					System.setProperty("webdriver.ie.driver","C:\\Users\\training_b6b.00.10\\Desktop\\Browsers and Drivers\\IEDriverServer.exe");
			   return new InternetExplorerDriver();	 
			    
			    }
			    else
			    {
			    	return null;
			    }
	}
}
