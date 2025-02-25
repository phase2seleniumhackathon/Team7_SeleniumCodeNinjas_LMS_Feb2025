package pageObjects;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;

//Madhuri's Module
public class Class_POF {

	WebDriver driver;
	WebDriverWait wait;
	
	public Class_POF() {
        this.driver = DriverFactory.getDriver();
		
	}

	private By classManagePage  = By.xpath("//div[@class='signin-content']");
	private By lmsHeading = By.xpath("//span[text()=' LMS - Learning Management System ']");
	private By header = By.xpath("//app-header");
	private By manageClassHeader = By.xpath("//div[text()=' Manage Class']");
	private By searchBox = By.id("filterGlobal");
	private By dataTableHeadings = By.xpath("//tr/th");
	private By text = By.xpath("//span[text()='Showing 1 to 8 of 8 entries']");
	private By paginator = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
	private By prevSetofPagesMove = By.xpath(
			"//button[@class='p-paginator-first p-paginator-element p-link p-disabled p-ripple ng-star-inserted']");
	private By nextSetofPagesMove = By
			.xpath("//button[@class='p-paginator-last p-paginator-element p-link p-ripple ng-star-inserted']");
	private By nextPageMove = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
	private By prevPageMove = By.xpath("//span[@class='p-paginator-icon pi pi-angle-left']");
	private By sortIcons = By.xpath("//i[@class='p-sortable-column-icon pi pi-fw pi-sort-alt']");
	private By deleteButton = By.xpath("//button[@class='p-button-danger p-button p-component p-button-icon-only']");
	private By totalNumberofClasses = By.xpath("//div[@class='p-d-flex p-ai-center p-jc-between ng-star-inserted']");
	private By classButton = By.xpath("//span[text()='Class']");
	private By number = By.xpath("//span[@class='p-paginator-pages ng-star-inserted']");

//----------- Class Button Click------------------
	
	public void clickClass() {
		
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement classHeader = wait.until(ExpectedConditions.elementToBeClickable(classButton));
	 
		try {
	        classHeader.click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", classHeader);
	    }
	
		
	}
//-------------Validate Class Page------------------
		
		public boolean isClassPageDisplayed() {
			
			WebElement header = driver.findElement(classManagePage);
			return header.isDisplayed() ;
			
		}
	
//-----------Validate LMS Heading--------------------
		
		public String getLMSHeading() {
			
			return driver.findElement(lmsHeading).getText().trim();
			
		}
	
//--------------Validate Class Header------------
		
		public String validateManageClassHeader() {
			return driver.findElement(manageClassHeader).getText().trim();
			
		}
	
//-------------Validate Search Bar-----------------
		
		public String getSearchBar() {
			WebElement searchText = driver.findElement(searchBox);
			return searchText.isDisplayed() ? searchText.getAttribute("placeholder"):null;
			
			
		}
	
//-------------Validate data table header--------------
		
		public List<String> getAllColumnHeaders() {
		    List<WebElement> tableHeaders = driver.findElements(dataTableHeadings);
		    List<String> actualColHeaders = new ArrayList<>();

		    // Start from index 1 to skip the first column
		    for (int i = 1; i < tableHeaders.size(); i++) {
		        actualColHeaders.add(tableHeaders.get(i).getText().trim());
		    }

		    return actualColHeaders; 
		}
		
		
//---------------Validate text and pagination icons------------------
		
		public String getInfoText() {
			return driver.findElement(paginator).getText();
			
		}
		
		public boolean isPreviousButtonDisplayed() {
			return driver.findElement(prevPageMove).isDisplayed();
			
		}
		public boolean isSetofPreviousButtonDisplayed() {
			return driver.findElement(prevSetofPagesMove).isDisplayed();
			
		}
		
		public boolean isNextButtonDisplayed() {
			return driver.findElement(nextPageMove).isDisplayed();
			
		}
		public boolean isSetNextButtonDisplayed() {
			return driver.findElement(nextSetofPagesMove).isDisplayed();
			
		}
		
		public String getCurrentPageNumber() {
			return driver.findElement(number).getText();
			
		}
		
		public boolean verifyPagination() {
			return isPreviousButtonDisplayed() &&
					isSetofPreviousButtonDisplayed() &&
					isNextButtonDisplayed() &&
					isSetNextButtonDisplayed();
		}
		
		public boolean verifyText() {
			String text = getInfoText();
			return text.matches("Showing \\d+ to \\d+ of \\d+ entries");
		}
		
		public boolean isPaginationControlEnabled(WebElement control) {
			
			return control.isEnabled() && !control.getAttribute("class").contains("disabled");
		}
		
		
//-------------Validate Sort icons---------------------
		
	public boolean validateSortIcons() {
		
		List<WebElement> allSortIcons = driver.findElements(sortIcons);
		
			for(int i=0; i < allSortIcons.size(); i++) {
				if(allSortIcons.get(i).isDisplayed())
					return true;
			}
			
				return false;
	}
					
//----------------Validate Delete Button------------------------
	
	public boolean validateDeleteBtn() {
		return driver.findElement(deleteButton).isDisplayed();
		
	}
	
//----------------Validate total number of classes---------------
	public boolean validateTotalClasses() {
		 return driver.findElement(totalNumberofClasses).isDisplayed();
		//System.out.println("Total Number Of Classes are :" +count);
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
		
}
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	



