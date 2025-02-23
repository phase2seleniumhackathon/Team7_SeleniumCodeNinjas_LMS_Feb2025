package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import driverFactory.*;
import utilities.ConfigReader;


public class Logout_POF {
	WebDriver driver;
	
	private By logout = By.id("logout");
//	@FindBy(xpath="//*[contains(text(),'Logout')]")
//	WebElement LogoutBtn;
//	
//	@FindBy(xpath="//span[normalize-space()='Logout']")
//	WebElement LogoutBtn;
	
	@FindBy(id="logout")
	WebElement LogoutBtn;
//     
	LoginPage_POF loginpagefactory= new LoginPage_POF();
	
//	public void clickLogout()
//	{
//		System.out.println("AAAAAAAAAAAAAA");
//		System.out.println(LogoutBtn);
//		LogoutBtn.click();
//	}
	public Logout_POF(WebDriver driver) {
        this.driver = driver;
    }
	public boolean logoutvalidation()
	{
		
		String curntURL=DriverFactory.getDriver().getCurrentUrl();
		if(curntURL.equalsIgnoreCase(ConfigReader.HomePageURL()))
		return true;
		else
			return false;
	}
	
	public void clickLogout() {
    	driver.findElement(logout).click();
    }
	
	public void isElementDisplayed(WebDriver driver, By locator) {
    	WebElement element = driver.findElement(locator);
    	try {
            
           // return element.isDisplayed();
            if(element.isDisplayed()) {
            	System.out.println(element.getText()+" is displayed"); 
            	}
        	} catch (Exception e) {
            // Element is not found or another error occurred
        		System.out.println(element.getText()+" not found");
         //   return false;
        	}
    	}
	public By getlogout() {
    	return logout;
    }
}

