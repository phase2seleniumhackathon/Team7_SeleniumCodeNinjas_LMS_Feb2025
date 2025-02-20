package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import driverFactory.DriverFactory;
import utilities.ConfigReader;

//Swasthika's Module
public class LoginPage_POF {
	WebDriver driver = DriverFactory.getDriver();
	String baseurl = ConfigReader.getApplicationUrl("applicationurl");
	public String invalidurl = "https://feb-ui-hackathon-bbfd38d67ea9.herokp.com";
	
	@FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c158-0']")
	WebElement UserTextField;
	
	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(xpath="//div[@class='mat-form-field-infix ng-tns-c158-1']")
	WebElement PasswordTextField;
	
	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(xpath="//div[@class='mat-form-field-infix ng-tns-c158-2']")
	WebElement SelectTheRole;
	
	@FindBy(xpath="//div[@class='mat-select-arrow-wrapper ng-tns-c161-3']")
	WebElement RoleDropDown;
	
	@FindBy(id="login")
	WebElement loginButton;
	
	@FindBy(xpath="form[class='ng-invalid ng-dirty ng-touched'] p")
	WebElement Headerforinvalidlink;
	
	
	
	
	public LoginPage_POF() {
			// Use the PageFactory.initElements method to initialize the elements on the login page
		PageFactory.initElements(driver, this);
	}
	//To get LOg in URL
		public void getbaseurl() {
			driver.get(baseurl);
		}
	
	public String InvalidURL() {
		driver.get("invalidurl");
		return
		Headerforinvalidlink.getText();
	
		
	}
	
	public void CheckUserTextField() {
		
        UserTextField.getText();
	}
	
	public void CheckPasswordTextField() {
		
        UserTextField.getText();
	}
	
	public void enter_user_name(String username) {

		Username.sendKeys(username);	
	}
	
	public void enter_user_password(String password) {

	Password.sendKeys(password);	
	}
	
	public void clickLoginButton() {
		loginButton.click();
	}
	
	public void SelectingTheRole() {
		RoleDropDown.click();
		List<WebElement> RolesList = driver.findElements(By.xpath("//span[@class='mat-option-text']"));
		Iterator<WebElement> it = RolesList.iterator();
		while (it.hasNext()) {
		    WebElement wb  = it.next();
		    System.out.println(wb.getText());
		    if(wb.getText().equals("Admin")) {
		        wb.click();
		        break;
		    }
	}
	}
}
