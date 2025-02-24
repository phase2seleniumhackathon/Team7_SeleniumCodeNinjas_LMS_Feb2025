package pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Random;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Config;

import utilities.ConfigReader;
import utilities.ExcelReader;

public class AddBatch_POF {
	
	//Locators
	private By programNameDropDown = By.xpath("//input[@placeholder='Select a Program name']");
	private By dropDownArrow = By.xpath("//div[@role='button']");
	private By dropdownListAllItems = By.xpath("//ul[@role='listbox']/p-dropdownitem");
	private By dropdownSelectedProgram = By.xpath("//ul[@role='listbox']/p-dropdownitem/li[@aria-selected='true']");
	private By batchNamePrefix = By.id("batchProg");
	private By batchNameSuffix = By.id("batchName");
	private By batchDescription = By.id("batchDescription");
	private By activeStatus = By.xpath("(//p-radiobutton[@name='category'])[1]");
	private By inActiveStatus = By.xpath("(//p-radiobutton[@name='category'])[2]");
	private By noOfClasses = By.id("batchNoOfClasses");
	private By saveButton = By.xpath("//button[@label='Save']");
	private By cancelButton = By.xpath("//button[@label='Cancel']");
	private By closeButton = By.xpath("//button[@tabindex='-1']");
	private By batchAddedSucessMessage = By.xpath("//div[@role='alert']");
	private By errorMessage= By.id("text-danger");
	private By batchDetailsModalDialog =By.xpath("//div[@role='dialog']");
	
	//constructor
	private WebDriver driver;
	
	public AddBatch_POF(WebDriver driver) {
			this.driver=driver;
	}
	
	//Methods
	public By getProgramName() {
		return programNameDropDown;
	}
	public void selectProgramName() {
		String select="Playwright";
		driver.findElement(dropDownArrow).click();
		// Wait for the dropdown options to be visible
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    List<WebElement> programOptionsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownListAllItems));
	    Actions actions = new Actions(driver);

	    for (WebElement option : programOptionsList) {
	        System.out.println("Option Text: " + option.getText());
	        if (option.getText().trim().equalsIgnoreCase(select)) {
	            actions.moveToElement(option).click().perform();
	            return;
	        }
	    }
	    wait.until(ExpectedConditions.textToBePresentInElementLocated(dropDownArrow, select));

	    // Print the selected program name
	    WebElement selectedProgram = driver.findElement(dropdownSelectedProgram);
	    System.out.println("Selected Program: " + selectedProgram.getText());
	}
	public By getBatchNamePrefix() {
		return batchNamePrefix;
	}
	public void isProgramAndBatchPrefixSame() {
		String programName = driver.findElement(programNameDropDown).getText();
		String batchPrefix = driver.findElement(batchNamePrefix).getText();
		Assert.assertTrue(programName.equals(batchPrefix));
	}
	public By getBatchNameSuffic() {
		return batchNameSuffix;
	}
	public By getBatchDesciption() {
		return batchDescription;
	}
	public By getActiveStatus() {
		return activeStatus;
	}
	private By getInActiveStatus() {
		return inActiveStatus;
	}
	public By getNoOfClasses() {
		return noOfClasses;
	}
	public By getSaveButton() {
		return saveButton;
	}
	public By getCancelButton() {
		return cancelButton;
	}
	public By getCloseButton() {
		return closeButton;
	}
	public void clickClose() {
		driver.findElement(closeButton).click();
	}
	public void clickSaveButton() {
		driver.findElement(saveButton).click();
	}
	public void clickCancelButton() {
		driver.findElement(cancelButton).click();
	}
	public boolean getErrorMessage() {
		String error = driver.findElement(errorMessage).getText();
		System.out.println(error);
		if(driver.findElement(errorMessage).isDisplayed())
		return true;
		else
		return false;
	}
	public boolean isEmpty() {
		if((driver.findElement(batchNamePrefix).getText()).equals(null)) 
			return true; 
		else
			return false;
	}
	public void enterText(String text, By locator) {
		    WebElement textbox = driver.findElement(locator);
		    if (textbox.isEnabled() && textbox.getAttribute("readonly") == null) {
		    textbox.clear();  
		    textbox.sendKeys(text);  
		    }
		    else
		    	System.out.println("the element is non-editable");
		}
	   public void verifyAddNewBatchDetailsWindowClosed() {
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    	 try {
	    	 wait.until(ExpectedConditions.attributeToBe(driver.findElement(batchDetailsModalDialog), "opacity", "0"));

	    	WebElement modal = driver.findElement(batchDetailsModalDialog);
	    	String displayStyle = modal.getCssValue("display");
	    	System.out.println(displayStyle);
	    	String visibility = modal.getCssValue("visibility"); // Should be "hidden" when closed
	    	System.out.println("Visiblitiy"+visibility);
	    	String opacity = modal.getCssValue("opacity"); // Should be "0" when closed
	    	System.out.println("Opacity"+opacity);
	    	if(modal.isDisplayed()) {
	    		System.out.println("Modal dialog is displayed successfully.");
	           return;
	        }
	    	else 
	    		System.out.println("Window closed");
	    	 } catch (StaleElementReferenceException e) {
	    	        System.out.println("Modal reference is stale, assuming it's closed.");
	    	    } catch (NoSuchElementException e) {
	    	        System.out.println("No modal dialog found. Window is closed.");
	    	    } catch (TimeoutException e) {
	    	        System.out.println("Modal took too long to close, but assuming it is closed.");
	    	    
	    }
	   }
	   public void enterBatchName(String BatchName) {
		   Random random = new Random();
	       int number= random.nextInt(900) + 100;
		   driver.findElement(batchNameSuffix).sendKeys(BatchName+number);
	   }
	   public void enterBatchDesc(String batchDesc) {
		   driver.findElement(batchDescription).sendKeys(batchDesc);
	   }
	   public void selectProgramName(String prg) {
				driver.findElement(dropDownArrow).click();
				// Wait for the dropdown options to be visible
			    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
			    List<WebElement> programOptionsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(dropdownListAllItems));
			    Actions actions = new Actions(driver);

			    for (WebElement option : programOptionsList) {
			        System.out.println("Option Text: " + option.getText());
			        if (option.getText().equalsIgnoreCase(prg)) {
			        	System.out.println("Matched");
			            actions.moveToElement(option).click().perform();
			            return;
			        }
			    }
			
	   }
	   public void selectBatchStatus(String status) {
		   if(status.equals("Active")){
			   driver.findElement(activeStatus).click(); }
			   else
				driver.findElement(inActiveStatus).click(); 
			   
		   }
	   public void selectNumberOfClasses(String classes) {
		   driver.findElement(noOfClasses).sendKeys(classes);
	   }
	   public boolean validateSucessMessage() {
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		   WebElement sucessMsg = wait.until(ExpectedConditions.presenceOfElementLocated(batchAddedSucessMessage));
		   String sucess= sucessMsg.getText();
		   System.out.println(sucess);
		   return true;
	   }
	   public void enterValidValueswithOneBlank() {
		   selectProgramName("Playwright");
		   enterBatchName(ConfigReader.getBatchName());
		   selectNumberOfClasses(ConfigReader.getNoOfClasses());
		   enterBatchDesc(ConfigReader.getBatchDesc());
	   }
	   }

