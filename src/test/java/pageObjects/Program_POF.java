package pageObjects;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class Program_POF {

	private WebDriver driver;
	WebDriverWait wait;

	// Constructor
	public Program_POF(WebDriver driver) {
		this.driver = driver;
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		PageFactory.initElements(driver, this); // Initialize elements in the current class
	}

// Locators for the Program page
	@FindBy(xpath = "//span[normalize-space()='Program']")
	private WebElement ProgramLinkHomePage;
	@FindBy(xpath = "//button[normalize-space()='Add New Program']")
	private WebElement MenuAddNewProgram;
	@FindBy(xpath = "//div[@class='box' and normalize-space(text())='Manage Program']")
	private WebElement ProgramPage;
	@FindBy(xpath = "//div[@role='dialog']")
	private WebElement ProgramDetails;
	@FindBy(xpath = "//button[@id='logout' and .//span[text()='Logout']]")
	private WebElement LogoutLinkProgramMenubar;
	@FindBy(xpath = "//span[normalize-space(text())='LMS - Learning Management System']")
	private WebElement LMSHeading;
	@FindBy(xpath = "//div[@class='navigation-links']//span")
	private List<WebElement> pageNames;
	@FindBy(xpath = "//table//tr//td[2]")
	private List<WebElement> programNames;
	@FindBy(xpath = "//*[@id='programName']")
	private WebElement programNameTextBox;
	@FindBy(xpath = "//input[@id='programDescription']")
	private WebElement ProgramDescriptionTextBox;
	@FindBy(xpath = "(//div[@class='p-radiobutton-box'])[1]")
	private WebElement StatusRadioButton;
	@FindBy(xpath = "//table//tr//td[3]")
	private List<WebElement> programDescriptions;
	@FindBy(xpath = "//table//tr//td[4]")
	private List<WebElement> programStatus;
	@FindBy(className = "cdk-overlay-backdrop")
	private WebElement overlay;
	@FindBy(xpath = "//input[@placeholder='Search...']")
	private WebElement searchBar;
	@FindBy(xpath = "//div[@class='p-checkbox-box']")
	private WebElement Checkbox;
	@FindBy(xpath = "(//th[@class='p-sortable-column'])[1]")
	private WebElement sortArrowsHeader;
	@FindBy(xpath = "//th[normalize-space()='Edit / Delete']")
	private WebElement EditDeleteText;
	@FindBy(xpath = "//div[@role='dialog']")
	private WebElement ProgramDetailspopup;
   // @FindBy(xpath = "//span[@class='p-button-label' and contains(text(),'Save')]")
	//private WebElement SaveButton;
    @FindBy(xpath = "//button[@id='saveProgram']")
    private WebElement SaveButton;
	@FindBy(xpath = "//small[text()='Program name is required.']")
	private WebElement requiredText;
	@FindBy(xpath = "//label[@for='programName']//span[contains(text(),'*')]")
	private WebElement Redasterisk;
	@FindBy(xpath = "//span[@class='p-dialog-title ng-tns-c81-9 ng-star-inserted']")
	private WebElement popupTitleElement;
	@FindBy(xpath = "//span[normalize-space()='Cancel']")
	private WebElement CancelButton;
    @FindBy(xpath = "//app-program/p-toast/div/p-toastitem/div/div/div/div[2]")
	private WebElement SuccessMsg;
	@FindBy(xpath = "//input[@id='filterGlobal']")
	 private WebElement searchBox;
	@FindBy(xpath = "//table[@id='programTable']//tr")
    private List<WebElement> programRows;
	@FindBy(xpath ="//span[@class='p-dialog-header-close-icon ng-tns-c81-5 pi pi-times']")
	private WebElement closeButton;
	@FindBy(xpath ="(//button[@id='editProgram'])[1]")
	private WebElement EditButton;
	
	
	public void  EditProgramSteps(String newProgramName) throws InterruptedException {
		WebElement programNameField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@id='programName']")));
		 programNameField.clear();
	        programNameField.sendKeys(newProgramName);
           System.out.println("SAAAAAAAAAAAAAAAA");
	        Thread.sleep(3000);
	        SaveButton.click();
	    }
	
	public void  EditProgramDescriptionSteps(String newProgramDescription) {
		
		 WebElement programDescriptionField = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@id='programDescription'])[1]")));
		 programDescriptionField.clear();
		 programDescriptionField.sendKeys(newProgramDescription);

	        // Locate and click the Save button
	        WebElement saveButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Save']")));
	        saveButton.click();
	}
	
	
	public void updateProgramSteps() {
		

        // Locate the element that displays the updated program name
      
        WebElement updatedProgramNameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[normalize-space()='New Program Name']")));
        // Get the displayed text
        String displayedProgramName = updatedProgramNameElement.getText();

        // Expected program name (assumes it's stored in a variable or fetched from the scenario context)
        String expectedProgramName = "New Program Name"; // Replace with dynamic value if needed

        // Assertion to verify the program name is updated
        Assert.assertEquals("Program name was not updated correctly!", expectedProgramName, displayedProgramName);
    }

	
public void updateProgramDescriptionSteps() {
		

        // Locate the element that displays the updated program name
        WebElement updatedProgramDescriptionElement = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@id='updatedProgramDescription']"))); 

        // Get the displayed text
        String displayedProgramDescription = updatedProgramDescriptionElement.getText();

        // Expected program name (assumes it's stored in a variable or fetched from the scenario context)
        String expectedProgramDescription = "New Program Description"; // Replace with dynamic value if needed

        // Assertion to verify the program name is updated
        Assert.assertEquals("Program Description was not updated correctly!", expectedProgramDescription, displayedProgramDescription);
    }
	
	
	
	
	
	
	
	
	
	
	
	
	  

//	
//	public void clickEditProgram() {
//		System.out.println("SCIENCE");
//		 EditButton.click();
//	}

public void ClickEditButton() {
	 try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));

	        // Wait for the Edit button to be present in the DOM
	        WebElement editButton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("(//button[@id='editProgram'])[1]")));

	        // Wait for it to be clickable
	        editButton = wait.until(ExpectedConditions.elementToBeClickable(editButton));

	        if (editButton.isDisplayed() && editButton.isEnabled()) {
	            // Scroll into view to ensure visibility
	            JavascriptExecutor js = (JavascriptExecutor) driver;
	          //  js.executeScript("arguments[0].scrollIntoView(true);", editButton);
	            
	           
	            Thread.sleep(500); // Small delay before clicking

	            // Click using JavaScript
	            js.executeScript("arguments[0].click();", editButton);
	            System.out.println("Edit button clicked successfully.");
	        } else {
	            System.out.println("Edit button is not visible or enabled.");
	        }
	    } catch (TimeoutException e) {
	        System.out.println("Timeout Exception: Edit button was not clickable within 15 seconds.");
	    } catch (NoSuchElementException e) {
	        System.out.println("NoSuchElementException: Edit button not found in the DOM.");
	    } catch (ElementClickInterceptedException e) {
	        System.out.println("ElementClickInterceptedException: Another element is blocking the Edit button.");
	    } catch (Exception e) {
	        System.out.println("Exception occurred while clicking Edit button: " + e.getMessage());
	    }
	}
	
//*********************************************************************	
	
	
  public void clickCloseButton() {
	        closeButton.click();
	    }
	  
	  public boolean isProgramDetailsFormClosed() {
	        try {
	            return !isProgramDetailPopupDisplayed(); // If not displayed, return true
	        } catch (NoSuchElementException e) {
	            return true;  // If form is not found, it's closed
	        }
	    }
	
	//******************************************************************************
	
public void searchProgram(String programName) {
        wait.until(ExpectedConditions.visibilityOf(searchBox));
        searchBox.clear();
        searchBox.sendKeys(programName);
        searchBox.sendKeys(Keys.ENTER);
        try
        {
        wait.until(ExpectedConditions.visibilityOfAllElements(programRows));
        System.out.println("Search results loaded successfully.");
    }catch (TimeoutException e){
        System.out.println("Timeout: Program rows did not appear after search.");
    }
}
	
	public boolean isProgramDisplayed(String programName) {
		boolean result= false;
	    try {
	        wait.until(ExpectedConditions.visibilityOfAllElements(programRows));

	  
	        for (WebElement row : programRows) {
	            String rowText = row.getText().trim();
	            System.out.println("DEBUG: Row text: " + rowText);  // Log the text of each row
	            if (rowText.contains(programName)) {
	                 result=true;
	            }
	        }
	    } catch (TimeoutException e) {
	        System.out.println("Timeout: Program search results did not load.");
	    }
	    return result;
	}
	

	// *************************************************************************************
	public void clickSaveButton() {
	JavascriptExecutor js = (JavascriptExecutor) driver;
   js.executeScript("arguments[0].click();", SaveButton);
	    
	System.out.println("SAVEDDDDDDDDD");
		//SaveButton.click();
}
	
public String successMsgSave() {
		return SuccessMsg.getText();
	}
//**************************************************************************************

	public void createForm() {
		programNameTextBox.sendKeys("Achievers");
		
		ProgramDescriptionTextBox.sendKeys("celebrate");
	}
	//**************************************************************************************

	
	public void editform() {
		
		programNameTextBox.sendKeys("Kanthara");
		
		ProgramDescriptionTextBox.sendKeys("movie");
	}

	// *************************************************************************************

	public void clickStatus()  {
		System.out.println("PPPP");
	    try {
	        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	        WebElement statusRadioButton = wait.until(ExpectedConditions.elementToBeClickable(this.StatusRadioButton));

	        // Scroll into view to make sure it's visible
	        JavascriptExecutor js = (JavascriptExecutor) driver;
	        js.executeScript("arguments[0].scrollIntoView(true);", statusRadioButton);
	        //Thread.sleep(500); // Small delay before clicking
	        
	        // Attempt to click using JavaScript
	        js.executeScript("arguments[0].click();", statusRadioButton);
	        System.out.println("Active Radio button clicked.");
	        
	    } catch (TimeoutException e) {
	        System.out.println("TimeoutException occurred while clicking the radio button: " + e.getMessage());
	    }
	}
	

	public boolean isStatusSelected() {
		SoftAssert softAssert = new SoftAssert();
		boolean isSelected = StatusRadioButton.isSelected();
		softAssert.assertFalse(isSelected, "The radio button for active status should be selected.");
		softAssert.assertAll(); // Collect assertion failures but continue execution
		return isSelected;
	}

//**************************************************** 
	public void clickCancelButton() {
		try {
			if (CancelButton.isDisplayed() && CancelButton.isEnabled()) {
				CancelButton.click();
				System.out.println("Cancel button clicked successfully.");
			} else {
				System.out.println("Cancel button is not clickable.");
			}
		} catch (NoSuchElementException e) {
			System.out.println("Error: Cancel button not found - " + e.getMessage());
		} catch (ElementClickInterceptedException e) {
			System.out.println("Error: Cancel button click intercepted - " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Unexpected error while clicking Cancel button - " + e.getMessage());
		}
	}

	public String getCancelButtonText() {
		return CancelButton.getText(); // Gets the text of the Cancel button
	}

//**************************************************** 
	public void enterProgramName(String programName) {
		programNameTextBox.clear();
		programNameTextBox.sendKeys(programName);
	}

	public String getEnteredProgramName() {
		return programNameTextBox.getAttribute("value");
	}

	// ****************************************************
	public void enterProgramDescription(String TestName) {
		ProgramDescriptionTextBox.clear();
		ProgramDescriptionTextBox.sendKeys(TestName);
	}

	public String getEnteredProgramDescription() {
		return ProgramDescriptionTextBox.getAttribute("value");
	}

// ************************************************************************************
	public void saveClick() {
		SaveButton.click();
	}

//*******************************************************************************************
	public String testRequiredFieldMessage() {
		String fieldText = requiredText.getText();
		return fieldText;
	}

	// ****************************************************************************************
	public String getPopupTitle() {
		return popupTitleElement.getText();
	}

	// ****************************************************************************************
	public boolean isProgramDetailPopupDisplayed() {
		try {
			System.out.println("Attempting to check if Program Details pop-up is displayed.");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOf(ProgramDetailspopup)); // Wait until the pop-up is visible
			if (ProgramDetailspopup.isDisplayed()) {
				System.out.println("Program Details pop-up is displayed.");
				return true;
			} else {
				System.out.println("Program Details pop-up is NOT displayed.");
				return false;
			}
		} catch (Exception e) {

			System.out.println("Error occurred: " + e.getMessage());
			return false;
		}
	}
	// ****************************************************************************************

	public boolean isRedasteriskDisplayed() {
		try {
			return Redasterisk.isDisplayed(); // Check if it's visible
		} catch (Exception e) {
			return false; // If not found or visible, return false
		}
	}

////****************************************************************************************   


	public void clickProgramLink() {
		try {
			// Wait for the element to be visible
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			WebElement programLink = wait.until(ExpectedConditions.visibilityOf(ProgramLinkHomePage));

			// Wait until the element is clickable
			wait.until(ExpectedConditions.elementToBeClickable(programLink));

			// Scroll into view before clicking
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", programLink);

			// Click the element
			programLink.click();
			System.out.println("Clicked on Program link successfully.");
		} catch (TimeoutException e) {
			System.out.println("Element not found or not clickable within time: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Click failed, attempting JavaScript click: " + e.getMessage());

			// JavaScript Click as fallback
			((JavascriptExecutor) driver).executeScript("arguments[0].click();", ProgramLinkHomePage);
			System.out.println("JavaScript click executed.");
		}
	}

//*******************************************************************************************
	public boolean isEditDeleteTextDisplayed() {
		return EditDeleteText.isDisplayed();
	}

	// **********************************************************************************
	public boolean isSortArrowHeaderDisplayed() {
		return sortArrowsHeader.isDisplayed();

	}
	// *************************************************************************************

	public boolean ischeckboxselected() {
		return Checkbox.isDisplayed();

	}

//*************************************************************************************************
	public boolean isSearchBarDisplayed() {
		return searchBar.isDisplayed();
	}

	// ****************************************************************************************

	public boolean isProgramPageDisplayed() {
		return ProgramPage.isDisplayed();
	}

//******************************************************
	public void clickAddNewProgram() {
		System.out.println("PROGRAM");
		MenuAddNewProgram.click();
	}

//****************************************************************	
	public boolean isMenuAddNewProgramisDisplayed() {
		return MenuAddNewProgram.isDisplayed();
	}

//***************************************************************
	public boolean isProgramDetailsDisplayed() {
		return ProgramDetails.isDisplayed();
	}

//********************************************************************
	public boolean isProgramLogoutisDisplayed() {
		return LogoutLinkProgramMenubar.isDisplayed();
	}

//*************************************************************************	

	
	public boolean isLMSHeadingCorrect(String expectedHeading) {
		return LMSHeading.getText().trim().equals(expectedHeading);
	}

//****************************************************************
	public List<WebElement> getPageNames() {
		return pageNames;
	}

	// ***********************************************************
	public List<WebElement> getProgramNames() {
		return programNames;
	}

	// ***************************************************************
	public List<WebElement> getProgramDescription() {
		return programDescriptions;
	}
	// *********************************************************************

	public List<WebElement> getProgramStatus() {
		return programStatus;
	}
	// **************************************************************
}
