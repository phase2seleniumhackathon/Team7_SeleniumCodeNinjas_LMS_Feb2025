package driverFactory;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import io.github.bonigarcia.wdm.WebDriverManager;
import utilities.ConfigReader;
import utilities.LoggerLoad;

public class DriverFactory {
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static  ConfigReader configFileReader = new ConfigReader();

	public void  webdriverinitialize(String browser) {
		
		if (browser.equalsIgnoreCase("firefox")) {
			LoggerLoad.info("Testing on firefox");
			
			driver.set(new FirefoxDriver());
			

		} else if (browser.equalsIgnoreCase("chrome")) {
			LoggerLoad.info("Testing on chrome");
			
			driver.set(new ChromeDriver());
			
		} else if (browser.equalsIgnoreCase("safari")) {
			LoggerLoad.info("Testing on safari");
			
			driver.set(new SafariDriver());

		} else if (browser.equalsIgnoreCase("edge")) {
			LoggerLoad.info("Testing on Edge");
			
			driver.set(new EdgeDriver());
		}
		
		getDriver().manage().deleteAllCookies();
		getDriver().manage().window().maximize();
		getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		
	}
	public static WebDriver getDriver() {
		
		return driver.get();
		
	}
	public static ConfigReader configReader() {
		return configFileReader;
	}
	
	// Close the WebDriver
    public  void quitDriver() {
        if (driver.get() != null) {
            driver.get().quit();
            driver.remove(); // Removes driver from ThreadLocal to clean up resources
        }
    }

}
