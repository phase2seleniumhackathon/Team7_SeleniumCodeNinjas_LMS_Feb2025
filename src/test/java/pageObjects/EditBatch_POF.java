package pageObjects;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import utilities.ConfigReader;

public class EditBatch_POF {
	
	private WebDriver driver;
	
	public EditBatch_POF(WebDriver driver) {
		this.driver=driver;
	}
	
	//Locators
	private By manageBatchHeading=By.xpath("//div[normalize-space()='Manage Batch']");
	private By batchLinkHomePage = By.xpath("//span[normalize-space()='Batch']");
	private By editIcon = By.xpath("//tbody/tr[1]/td[7]/div/span/button[@icon='pi pi-pencil']");
	private By programNameDropDwon = By.id("programName");
	private By batchName = By.id("batchName");
	private By description = By.id("batchDescription");
	private By activeStatus = By.xpath("(//div[@class='p-radiobutton-box'])[1]");
	private By inactiveStatus = By.xpath("(//div[@class='p-radiobutton-box'])[2]");
	private By noOfClasses = By.id("batchNoOfClasses");
	private By saveButton = By.xpath("//button[@label='Save']");
	private By cancelButton = By.xpath("//button[@label='Cancel']");
	private By errorMsg = By.xpath("//small[@id='text-danger']");
	private By successMsg = By.xpath("//div[@role='alert']");
	private By editDialog = By.xpath("//div[@class='p-dialog-header ng-tns-c118-150 ng-star-inserted']");
	private By batchHeader = By.xpath("//span[@id='pr_id_98-label']");
	
	public By getBatchLink() {
		return batchLinkHomePage;
	}
	public void clicksBatchLinkHomePAge() {
		driver.findElement(batchLinkHomePage).click();
	}
	public void clickEditIcon() {
		WebElement edit =driver.findElement(editIcon);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", edit);
	}
	public boolean verifyEditBatchWindowOpened() {
   	 try {
   	String header = driver.findElement(batchHeader).getText();
   	if(header.equals("Batch Details")) {
   		System.out.println("pop up dialog is displayed successfully.");
           return true;
       }
   } catch (NoSuchElementException e) {
       System.out.println("No pop up dialog found.");
   }
	return false;
   }
	public boolean isPrgNameEnabled() {
		WebElement prg= driver.findElement(programNameDropDwon);
		if(prg.isEnabled())
			return false;
		else
			return true;
	}
	public boolean isBatchNameEnabled() {
		WebElement batch = driver.findElement(batchName);
		if(!batch.isEnabled())
			return true;
		else
			return false;
	}
	public void enterInvalidvalues() {
		driver.findElement(description).clear();
		driver.findElement(noOfClasses).clear();
		driver.findElement(description).sendKeys(ConfigReader.getEditBatchDesc());
		driver.findElement(noOfClasses).sendKeys(ConfigReader.getEditBatchClasses());
	}
	//the save button gives element interception error(button clicking is blocked) so the user first 
	//fixes the inputs and then the save button can be clicked. 
	public void clickSaveButton() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		WebElement save = driver.findElement(saveButton);
		js.executeScript("arguments[0].click()", save);
		
	}
	public boolean getErrorMessage() {
		String error = driver.findElement(errorMsg).getText();
		System.out.println(error);
		if(driver.findElement(errorMsg).isDisplayed())
		return true;
		else
		return false;
	}
	public void clickCancelButton() {
		try {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", driver.findElement(cancelButton));
	    System.out.println("Cancel button clicked ");
		driver.findElement(cancelButton).click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    wait.until(ExpectedConditions.invisibilityOfElementLocated(editDialog));
	    
	    System.out.println("Modal closed successfully.");

	} catch (StaleElementReferenceException e) {
	    System.out.println("Caught StaleElementReferenceException. Modal already closed.");
	}
	}
	public void enterAllValidValues(String desc,String classes) {
		driver.findElement(description).clear();
		driver.findElement(noOfClasses).clear();
		driver.findElement(description).sendKeys(desc);
		driver.findElement(noOfClasses).sendKeys(classes);
	}
	public void selectStatus(String status) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", driver.findElement(activeStatus));
	    System.out.println("Active Radio button clicked.");
	}
	public By getmanageBatchHeading() {
		return manageBatchHeading;
	}
	public boolean isElementDisplayed(WebDriver driver, By locator) {
    	WebElement element = driver.findElement(locator);
    	try {
            
           // return element.isDisplayed();
            if(element.isDisplayed()) {
            	System.out.println(element.getText()+" is displayed"); 
            	return true;
            	}
        	} catch (Exception e) {
            // Element is not found or another error occurred
        		System.out.println(element.getText()+" not found");
         //   return false;
        }
		return false;
    }
	  public boolean validateSucessMessage() {
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		   WebElement sucessMsg = wait.until(ExpectedConditions.presenceOfElementLocated(successMsg));
		   String sucess= sucessMsg.getText();
		   System.out.println(sucess);
		   return true;
	   }
}
