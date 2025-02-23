package pageObjects;

import java.util.Iterator;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import driverFactory.DriverFactory;


public class HomePage_POF {
	WebDriver driver = DriverFactory.getDriver();
//	@FindBy(id="username")
//	WebElement Username;
//	
//	@FindBy(id="mat-error-0")
//	WebElement pleaseEnterUsename;
//
//	@FindBy(xpath="//div[@class='mat-form-field-infix ng-tns-c158-1']")
//	WebElement PasswordTextField;
//
//	@FindBy(id="password")
//	WebElement Password;
//	
//	@FindBy(id="mat-error-1")
//	WebElement pleaseEnterPassword;
	By user = By.xpath("//*[@id='username']");
	By password=By.xpath("//*[@id='password']");
//	By role=By.xpath("//*[@class='mat-option-text']");
//	@FindBy(xpath="c")
	By role = By.xpath("//*[@class='mat-card mat-focus-indicator']/mat-card-content/form/mat-form-field[3]");
	WebElement RoleDropDown;
	By login=By.xpath("//*[@id='login']");
	By LMSspelling =By.xpath("/html/body/app-root/app-header/mat-toolbar/span[1]");
	//By homespelling =By.xpath("/html/body/app-root/app-header/mat-toolbar/div/button[1]");
	By homespelling =By.xpath("//*[@id='dashboard']");
	By programspelling = By.xpath("/html/body/app-root/app-header/mat-toolbar/div/button[2]");
	By batchspelling = By.xpath("/html/body/app-root/app-header/mat-toolbar/div/button[3]");
	By classspelling = By.xpath("/html/body/app-root/app-header/mat-toolbar/div/button[4]");
	By logoutspelling = By.xpath("//*[@id='logout']");
	By validatenavigationbar = By.xpath("html/body/app-root/app-header/mat-toolbar");
	By piechart = By.xpath("//*[@class='chartjs-size-monitor']");
	By uservalue= By.xpath("//*[@class='widget-container']/div/div[2]");
	By staffvalue= By.xpath("//*[@class='widget-container']/div[2]/div[2]");
	By batchvalue= By.xpath("//*[@class='widget-container']/div[3]/div[2]");
	By programvalue= By.xpath("//*[@class='widget-container']/div[4]/div[2]");
	By staffdatapage = By.xpath("//*[@class='mat-grid-list container']/div/mat-grid-tile[1]/figure");
	By previouspage = By.xpath("//*[@class='mat-paginator-outer-container']/div/div/button[2]");
	By firstpage = By.xpath("//*[@class='mat-paginator-outer-container']/div/div/button");
	By staffdata = By.xpath("//*[@class='mat-grid-list container']/div/mat-grid-tile[1]/figure/div/app-staffdata/mat-table");
	//By staffdata = By.xpath("By.tagName(\"mat-row\")");
	By welcomeuser = By.xpath("//*[@class='mat-grid-tile']/figure/div/app-admindata/div/div[2]");
	By welcomerole =By.xpath("//*[@class='mat-grid-tile']/figure/div/app-admindata/div/div[3]");
	By barchart = By.xpath("//*[@class='mat-grid-tile']/figure/div/div/canvas");
	
	public void launchpage(){
		WebDriver driver = DriverFactory.getDriver();
	}
	
	public void enteruser() {
		
		driver.findElement(user).sendKeys("sdetnumpyninja@gmail.com");
	}
	
	public void enterpassword() {
		driver.findElement(password).sendKeys("Feb@2025");
		}
	/*public void SelectingTheRole() {
		System.out.println("ABCcccccccccccccccc");
		driver.findElement(role).click();
		List<WebElement> RolesList = driver.findElements(role);
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
	public void enter_user_name(String username) {

		user.sendKeys(username);	
	}

	public void enter_user_password(String password) {

		password.sendKeys(password);	
	}

	public void clickLoginButton() {
		login.click();
	}*/
	public void SelectingTheRole() {
		driver.findElement(role).click();
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
	public void clicklogin() {
		driver.findElement(login).click();
	}
	public void validateLMS() {
		driver.findElement(LMSspelling).isDisplayed();
	}
	public void validatelocationLMS() {
		driver.findElement(LMSspelling);
		WebElement lms = driver.findElement(LMSspelling);
		Point p = lms.getLocation();
		System.out.println("x-cord-"+p.x+" " +p.getX());
		System.out.println("y-cord-"+p.y+" " +p.getY());
		Dimension d = lms.getSize();
		System.out.println("width-" +d.width+" " +d.getWidth());
		System.out.println("height-" +d.height+" " +d.getHeight());
		// Validate that it's in the left corner
       /* if (x-cord < 100 && y-cord < 100) {
            System.out.println("LMS is in the left corner!");
        } else {
            System.out.println("LMS is NOT in the left corner.");
        
	      }*/
	}
	public void validatehomepagespelling() {
		WebElement LMSSpelling = driver.findElement(LMSspelling); 
        WebElement homeSpelling = driver.findElement(homespelling);  
        WebElement programSpelling = driver.findElement(programspelling);  
        WebElement batchSpelling = driver.findElement(batchspelling);  
        WebElement classSpelling = driver.findElement(classspelling);  
        WebElement logoutSpelling = driver.findElement(logoutspelling);  

		Assert.assertEquals(LMSSpelling.getText().trim(), "LMS - Learning Management System");
        Assert.assertEquals(homeSpelling.getText().trim(), "Home");
        Assert.assertEquals(programSpelling.getText().trim(), "Program");
        Assert.assertEquals(batchSpelling.getText().trim(), "Batch");
        Assert.assertEquals(classSpelling.getText().trim(), "Class");
        Assert.assertEquals(logoutSpelling.getText().trim(), "Logout");
    }
	
		
	public void LMSspelling() {
		        
        String actualText = driver.findElement(LMSspelling).getText();
       String expectedText = "LMS - Learning Management System";  
        
       if (actualText.equals(expectedText)) {
        System.out.println("Spelling is correct: " + actualText);
        } else {
            System.out.println("Spelling is incorrect. Found: " + actualText);
        }

	}
	public void validatenavigationbar() {
		
	WebElement navigation =driver.findElement(validatenavigationbar);
    Point p = navigation.getLocation();
    System.out.println("x-cord-"+p.x+" " +p.getX());
    System.out.println("y-cord-"+p.y+" " +p.getY());
    Dimension d = navigation.getSize();
    System.out.println("width-" +d.width+" " +d.getWidth());
    System.out.println("height-" +d.height+" " +d.getHeight());
}
	/*public void homefirst() {
	
    WebElement HomeFirst = driver.findElement(homespelling);
    String firstTitle = HomeFirst.get(0).getText().trim();
    Assert.assertEquals(firstTitle, "Home", "Admin does not see Home as the first title!");
    System.out.println("Admin sees 'Home' as the first title in the navigation bar.");

}*/
	public void homefirst() {
		driver.findElement(homespelling).isDisplayed();
//	    // Find all the navigation items (or buttons)
//	    List<WebElement> navigationItems = driver.findElements(homespelling);
//
//	    // Check if there are at least 1 item
//	    Assert.assertEquals("There are no navigation items!", navigationItems.size() > 0);
//
//	    // Get the first item in the list (index starts from 0)
//	    WebElement homeFirst = navigationItems.get(0);  // First item is at index 0
//
//	    // Get the text of the first item and validate it matches 'Home'
//	    String firstTitle = homeFirst.getText().trim();
//	    Assert.assertEquals("Admin does not see Home as the first title!", "Home", firstTitle);
//
//	    System.out.println("Admin sees 'Home' as the first item in the navigation bar.");
	}
	
	public void programsecond() {
		driver.findElement(programspelling).isDisplayed();
//	    WebElement programSecond = driver.findElement(programspelling);
//	    String secondTitle = programSecond.get(1).getText().trim();
//	    Assert.assertEquals(secondTitle, "Home", "Admin does not see Home as the first title!");
//	    System.out.println("Admin sees 'Home' as the first title in the navigation bar.");

	}
public void batchthird() {
	driver.findElement(batchspelling).isDisplayed();
//	    WebElement batchThird = driver.findElement(batchspelling);
//	    String thirdTitle = batchThird.get(2).getText().trim();
//	    Assert.assertEquals(thirdTitle, "Home", "Admin does not see Home as the first title!");
//	    System.out.println("Admin sees 'Home' as the first title in the navigation bar.");

	}
//public void classfourth() {
//	driver.findElement(classspelling).isDisplayed();
//    WebElement classFourth = driver.findElement(classspelling);
//    String fouthTitle = classFourth.get(3).getText().trim();
//    Assert.assertEquals(fouthTitle, "Home", "Admin does not see Home as the first title!");
//    System.out.println("Admin sees 'Home' as the first title in the navigation bar.");

//}
public void classfourth() {
	driver.findElement(classspelling).isDisplayed();
//    // Find all the elements you want (e.g., navigation items)
//    List<WebElement> navigationItems = driver.findElements(classspelling);
//    
//    // Ensure the list is large enough to access the fourth element (index 3)
//    if (navigationItems.size() > 0) {
//        // Get the text of the fourth element (index 3)
//        String fourthTitle = navigationItems.get(3).getText().trim();
//        
//        // Assert that the text of the fourth element is "Home"
//        Assert.assertEquals(fourthTitle, "Home", "Admin does not see Home as the fourth title!");
//        
//        System.out.println("Admin sees 'Home' as the fourth title in the navigation bar.");
//    } else {
//        System.out.println("The navigation bar does not have enough items.");
//    }
}
public void logoutfifth() {
	driver.findElement(logoutspelling).isDisplayed();
//    WebElement logoutfifth = driver.findElement(logoutspelling);
//    String fifthTitle = logoutfifth.get(4).getText().trim();
//    Assert.assertEquals(fifthTitle, "Home", "Admin does not see Home as the first title!");
//    System.out.println("Admin sees 'Home' as the first title in the navigation bar.");

}
public boolean StaffDataRowsCheck()
{
	List <WebElement> row=driver.findElements(By.tagName("mat-row"));
	if(row.size()==5) 
		return true;
	return false;
}
public void validatepiechart() {
	driver.findElement(piechart).isDisplayed();
}
public void validatewelcomemsg() {
	driver.findElement(welcomeuser).isDisplayed();
	driver.findElement(welcomerole).isDisplayed();
}
public void validatebarchart() {
	driver.findElement(barchart);
}
public void validateuservalue() {
	driver.findElement(uservalue).isDisplayed();
}
public void validatestaffvalue() {
	driver.findElement(staffvalue).isDisplayed();
}
public void validatebatchvalue() {
	driver.findElement(batchvalue).isDisplayed();
}
public void validateprogramvalue() {
	driver.findElement(programvalue).isDisplayed();
}
public void validatestaffdataandpagination() {
	driver.findElement(staffdatapage).isDisplayed();
}
public void validateprviouspage() {
	WebElement previousPageButton = driver.findElement(previouspage);
	boolean isDisabled = previousPageButton.getAttribute("disabled") != null;
	Assert.assertTrue(isDisabled);
}
public void validatefirstpage() {
	WebElement previousPageButton = driver.findElement(firstpage);
	boolean isDisabled = previousPageButton.getAttribute("disabled") != null;
	Assert.assertTrue(isDisabled);
}
//public void validatestaffdata() {
//	driver.findElement(staffdata).isDisplayed();
//	}
//public void verifyFiveStaffData() {
//    // Find all staff data elements (replace with actual locator)
//    List<WebElement> staffDataElements = driver.findElements(By.cssSelector("your-staff-data-element-selector"));
//
//    // Assert that exactly 5 staff data elements are displayed on the page
//    Assert.assertEquals("Admin should see 5 staff data entries on the page.", 5, staffDataElements.size());
//
//    // Optionally, print out the staff data count for confirmation
//    System.out.println("Admin sees " + staffDataElements.size() + " staff data entries on the page.");
//}
public boolean validatestaffdata()
{
	List <WebElement> row=driver.findElements(staffdata);
	if(row.size()==5) 
		return true;
	return false;
}
}

