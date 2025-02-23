package pageObjects;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.imageio.ImageIO;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


import driverFactory.DriverFactory;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import utilities.ConfigReader;


public class LoginPage_POF {
	WebDriver driver = DriverFactory.getDriver();
	String baseurl = ConfigReader.getApplicationUrl("applicationurl");
	public String invalidurl =ConfigReader.getApplicationUrl("invalidapplicationurl");;

	@FindBy(xpath = "//div[@class='mat-form-field-infix ng-tns-c158-0']")
	WebElement UserTextField;

	@FindBy(id="username")
	WebElement Username;

	@FindBy(xpath="//mat-error[text()=' Please enter your user name ']")
	WebElement pleaseEnterUsename;

	@FindBy(xpath="//div[@class='mat-form-field-infix ng-tns-c158-1']")
	WebElement PasswordTextField;

	@FindBy(id="password")
	WebElement Password;

	@FindBy(xpath="//mat-error[text()=' Please enter your password ']")
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
	
	 @FindBy(xpath="//img")
	 WebElement DashboardImage;

	public LoginPage_POF() {
		// Use the PageFactory.initElements method to initialize the elements on the login page
		PageFactory.initElements(driver, this);
	}
	
	//To get LOg in URL
	public void getbaseurl() {
		driver.get(baseurl);
	}

	//InvaliURL
	public boolean InvalidURL() {
		boolean invalidlink = false;
		driver.get(invalidurl);
		if(Headerforinvalidlink.getText()!="Invalid Site") {
			invalidlink = true;
		}
		return invalidlink;
	}

	//Please sign in error
	public String pleaseSignIn() {
		String plsSignIn = plssignIn.getText();
		return plsSignIn;
	}

	//To check if User field is displayed
	public void CheckUserTextFieldDisplay() {
        UserTextField.getText();
	}

	//To check if Password field is displayed
	public void CheckPasswordTextFieldDisplay() {
    	PasswordTextField.getText();
	}

	
	//Enter User name
	public void enter_user_name(String username) {
         Username.sendKeys(username);	
	}

	//Enter Password
	public void enter_user_password(String password) {
        Password.sendKeys(password);	
	}

	//Click Login Button
	public void clickLoginButton() {
		loginButton.click();
	}

	
	public String pleaseEnterUserNameError() throws InterruptedException {
		String  EnterUserNameError =pleaseEnterUsename.getText();
		return EnterUserNameError;
	}

	public String pleaseEnterPasswordError() throws InterruptedException {
		Thread.sleep(3000);
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

	public boolean appNameOnLogo(String ExpText,boolean order) throws IOException, TesseractException, InterruptedException {

//       util.waitForElement(signInmesg);       
        Thread.sleep(3000);
        // Take a screenshot of the image
        File imageFile = DashboardImage.getScreenshotAs(OutputType.FILE);
        File tempFile = new File("temp_image.png");
        FileHandler.copy(imageFile, tempFile);         

        // Initialize Tesseract
        
        Tesseract tesseract = new Tesseract();
        tesseract.setDatapath("C://Program Files//Tesseract-OCR//tessdata"); 
        tesseract.setLanguage("eng"); 

        // Extract text from the image
        String extractedText = tesseract.doOCR(tempFile);      
    	        if(order) {        	
        	int LMSIndex = extractedText.indexOf("LMS");
        	int NumpytIndex = extractedText.indexOf("Learning management System");
        
        	if(ExpText.contains("LMS") && LMSIndex <NumpytIndex) {
            	
            	return true;
        	}else if(ExpText.contains("Numpy") && NumpytIndex > LMSIndex) {
        		System.out.println("Numpy is after LMS"); 
            	return true;
        	}
        	
        }else {
        	if(extractedText.contains(ExpText)) 
            	return true;
            else
            	return false;               
        }
        return false;
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

	public boolean VerifyingTheRoleList(String ExpectedRoleList) {
		List<String> lst = new ArrayList<String>();
		List<String> lst2 = new ArrayList<String>();
		boolean isListisSame = false;
		for (String field : ExpectedRoleList.split(",")) {
			lst.add(field);
		}		
		//	RoleDropDown.click();
		List<WebElement> RolesList = driver.findElements(By.xpath("//span[@class='mat-option-text']"));
		Iterator<WebElement> it = RolesList.iterator();
		while (it.hasNext()) {
			WebElement wb  = it.next();
			System.out.println(wb.getText());
			lst2.add(wb.getText());
		}

		if(lst.containsAll(lst2)) {
			System.out.println("YOU ARe Good TO Go");
			isListisSame= true;
		}
		else {
			System.out.println("NOT GOOD");
			isListisSame= false;
		}
		return isListisSame;
	}

	public boolean isLoginButtonDisplaying() {
		boolean isloginbuttondisplayed = loginButton.isDisplayed();
		return isloginbuttondisplayed;
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

	public boolean adminUserTextColorValidation()
	{	
		boolean UsertextColor = false;
		String expectedColor = "rgba(0, 0, 0, 0.87)";
		String textColor = UserTextField.getCssValue("color");   
		if (textColor.equalsIgnoreCase(expectedColor)) {
			UsertextColor= true;   
		}

		return UsertextColor;
	}	

	public boolean adminPasswordTextColorValidation()
	{	
		boolean UsertextColor = false;
		String expectedColor = "rgba(0, 0, 0, 0.87)";
		String textColor = PasswordTextField.getCssValue("color");   

		if (textColor.equalsIgnoreCase(expectedColor)) {
			UsertextColor= true;   
		}

		return UsertextColor;
	}	
	
	public boolean ChackFieldsonLoginPage() {
		
		Boolean Userspellingcheck = false;
		Boolean Passwdspellingcheck = false;
		Boolean Rolepellingcheck = false;
		Boolean allfields=false;
		if(UserTextField.getText().equals("User *")) {
			System.out.println("User field spelling is right");
			Userspellingcheck = true;
		}
		if(PasswordTextField.getText().contains("Password")) {
			System.out.println("Password field spelling is right");
			Passwdspellingcheck=true;
		}
		if(SelectTheRole.getText().contains("Select the role")) {
			System.out.println("Select the role field spelling is right");
			Rolepellingcheck = true;
		}
	
		if(Userspellingcheck == true && Passwdspellingcheck==true &&  Rolepellingcheck == true) {
			allfields =true;
		}
			return allfields; 
	}
	 
	
	
	
}
