package pageObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import driverFactory.DriverFactory;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import utilities.ConfigReader;


//Swasthika's Module
public class LoginPage_POF {
	//WebDriver driver = new ChromeDriver();
	WebDriver driver = DriverFactory.getDriver();
	String baseurl = ConfigReader.getApplicationUrl("applicationurl");
	public String invalidurl =ConfigReader.getApplicationUrl("invalidapplicationurl");;

	@FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c158-0']")
	WebElement UserTextField;

	@FindBy(id="username")
	WebElement Username;
	
	@FindBy(id="mat-error-0")
	WebElement pleaseEnterUsename;

	@FindBy(xpath="//div[@class='mat-form-field-infix ng-tns-c158-1']")
	WebElement PasswordTextField;

	@FindBy(id="password")
	WebElement Password;
	
	@FindBy(id="mat-error-1")
	WebElement pleaseEnterPassword;

	@FindBy(xpath="//div[@class='mat-form-field-infix ng-tns-c158-2']")
	WebElement SelectTheRole;
	
	@FindBy(xpath="//span[@class='mat-select-placeholder mat-select-min-line ng-tns-c161-3 ng-star-inserted']")
	WebElement SelectTheRoleFiled;

	@FindBy(xpath="//div[@class='mat-select-arrow-wrapper ng-tns-c161-3']")
	WebElement RoleDropDown;
	
	@FindBy(xpath="//p[normalize-space()='Please login to LMS application']")
	WebElement plssignIn;
	
	@FindBy(xpath="//img[@src='assets/img/LMS-logo.jpg']")
	WebElement CompanyLogo;

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
		driver.get(invalidurl);
		return
				Headerforinvalidlink.getText();


	}
	
	public String pleaseSignIn() {
		String plsSignIn = plssignIn.getText();
		return plsSignIn;
	}

	public void CheckUserTextFieldDisplay() {

		UserTextField.getText();
	}

	public void CheckPasswordTextFieldDisplay() {

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
	
	public String pleaseEnterUserNameError() {
	 String  EnterUserNameError =pleaseEnterUsename.getText();
	     return EnterUserNameError;
	}
	
	public String pleaseEnterPasswordError() {
		 String  EnterPasswordError =pleaseEnterPassword.getText();
		     return EnterPasswordError;
		}
	
	public boolean verifyUserTextField() {
		
		boolean display = UserTextField.isDisplayed();
		return display;
	}
	public boolean verifyPasswordTextField() {
		
		boolean display = PasswordTextField.isDisplayed();
		return display;
	}
	
	public boolean verifyRoleDropDownField() {
		
		boolean display = RoleDropDown.isDisplayed();
		return display;
	}
	
	
	public String HomePageValidation()
	 {	 
	   	    String title2 = DriverFactory.getDriver().getCurrentUrl(); 
		    return title2;
		 
	 }
	
	public boolean checkforAstric() {
		boolean Astric= false;
		String text = UserTextField.getText();
      System.out.println("USER Field"+text);
		String[] trimmedText = text.split(" ");
		for (String str : trimmedText) {
		    System.out.println(str);
		
		}
	   
		if(trimmedText[1].contains("*")) {
			 Astric= true;
		}
		
			return Astric;
	}
	
	public boolean checkforPasswordAstric() {
		boolean Astric= false;
		String text = PasswordTextField.getText();
    	String[] trimmedText = text.split(" ");
		for (String str : trimmedText) {
		    System.out.println(str);
		
		}
	   
		if(trimmedText[1].contains("*")) {
			 Astric= true;
		}
		
			return Astric;
	}
	
	public String checkforUserTextField() {
		String Astric=null;
		String text = UserTextField.getText();
    	String[] trimmedText = text.split(" ");
		for (String str : trimmedText) {
		    System.out.println(str);
		
		}
	   
		if(trimmedText[0].contains("User")) {
			 Astric= trimmedText[0];
		}
		
			return Astric;
	}
	
	public String checkforPasswordTextField() {
		String Astric=null;
		String text = PasswordTextField.getText();
    	String[] trimmedText = text.split(" ");
		for (String str : trimmedText) {
		    System.out.println(str);
		
		}
	   
		if(trimmedText[0].contains("Password")) {
			 Astric= trimmedText[0];
		}
		
			return Astric;
	}

	public String checkforSelectRoleTextField() {
		
			String SelectTheRoleFiled1 = SelectTheRoleFiled.getText();
			return SelectTheRoleFiled1;
	}
	
	public void appNameOnLogo() throws IOException, TesseractException {
		
		String imageURL = CompanyLogo.getAttribute("src");
		System.out.println("IMAGEURL"+imageURL);
		URL url = new URL(imageURL);
	     BufferedImage	 image1 = ImageIO.read(url);

		 Tesseract tesseract = new Tesseract();
		 tesseract.setDatapath("C:\\Users\\swast\\git\\Team7_SeleniumCodeNinjas_LMS_Feb2025\\image.png");
		 tesseract.setLanguage("eng");
		  String extractedText = tesseract.doOCR(image1);
	
          System.out.println("Extracted Text: " + extractedText);
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
	
	public  void keyboardEnter() throws InterruptedException {
		Actions actions = new Actions(driver);
		actions.click(loginButton).sendKeys(Keys.ENTER).perform();
		 Thread.sleep(2000);
		
		 try {
	            Thread.sleep(2000); // Wait for 2 seconds
	        } catch (InterruptedException e) {
	            e.printStackTrace();
	        }
	}
	
	public void mouseActionClick() throws InterruptedException {
		Actions actions = new Actions(driver);
	    actions.moveToElement(loginButton).click().perform();
		 Thread.sleep(2000);
		 try {
	           Thread.sleep(2000); // Wait for 2 seconds
	       } catch (InterruptedException e) {
	           e.printStackTrace();
	       }
	}
	
	public int BrokenLinkValidation() throws MalformedURLException, IOException
	{
		int i=0;
		int Rescode=-1;
		List<WebElement> links = DriverFactory.getDriver().findElements(By.tagName("link"));		
		
		for(WebElement link : links)
		{			
			String url=link.getAttribute("href");
			
				if(url==null || url.isEmpty())
				{
					continue;
				}
			
			HttpURLConnection huc = (HttpURLConnection) (new URL(url).openConnection());
			huc.connect();
			
			 Rescode=huc.getResponseCode();
			
			if(Rescode>=400)
			{
				i++;				
				System.out.println("Broken Links " + i);
			}
			else{}		
			
		}
		return i;
	}
		
}
