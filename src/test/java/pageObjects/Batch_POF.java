package pageObjects;

import java.time.Duration;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import driverFactory.DriverFactory;

// Shami's Module
public class Batch_POF {

    // Locators

    // Batch Page
    private By batchLinkHomePage = By.xpath("//span[normalize-space()='Batch']");
    private By MenuAddNewBatch = By.xpath("//button[normalize-space()='Add New Batch']");
    private By SearchTextBox = By.id("filterGlobal");
    private By checkBoxHeader = By.xpath("//div[@class='p-checkbox-box']");
    private By allSortIcons = By.xpath("//th[@aria-sort='none']//i");
    private By ManageBatchHeading = By.xpath("//div[normalize-space()='Manage Batch']");
    private By deleteMultipleButton = By.xpath("(//button[@class='p-button-danger p-button p-component p-button-icon-only'])[1]");
    private By batchNameHeader = By.xpath("//th[@psortablecolumn='batchName']");
    private By batchDescHeader = By.xpath("//th[@psortablecolumn='batchDescription']");
    private By batchStatusHeader = By.xpath("//th[@psortablecolumn='batchStatus']");
    private By NoOfClassBatchHeader = By.xpath("//th[@psortablecolumn='batchNoOfClasses']");
    private By programNameHeader = By.xpath("//th[@psortablecolumn='programName']");
    private By editOrDeleteHeader = By.xpath("//th[normalize-space(text())='Edit / Delete']");
    private By editButtonBatch = By.xpath("(//span[@aria-hidden='true'])[3]");
    private By deleteButtonBatch = By.xpath("(//span[@aria-hidden='true'])[5]");
    private By paginationPanel = By.xpath("//p-paginator[@class='ng-star-inserted']");
    private By allEditButtons = By.xpath("(//button[contains(@class,'p-button-rounded p-button-success')])");
    private By allDeleteButtons= By.xpath("(//button[@icon='pi pi-trash'])"); 
    private By allcheckboxes = By.xpath("//div[@role='checkbox']");
    private By batchDetailsTitle = By.id("pr_id_4-label");
    private By batchDetailsModalDialog =By.xpath("//div[@role='dialog']");
    private By logout = By.id("logout");
    private By batchNameAllrows = By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[2]");
    private By batchDescAllrows = By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[3]");
    private By prgNameAllrows = By.xpath("//tbody[@class='p-datatable-tbody']/tr/td[6]");
    private By firstPage = By.xpath("(//button[@type='button'])[1]");
    private By previousPage = By.xpath("(//button[@type='button'])[2]");
    private By nextPage = By.xpath("//span[@class='p-paginator-icon pi pi-angle-right']");
    private By lastPage = By.xpath("//span[@class='p-paginator-icon pi pi-angle-double-right']");
    private By showingRecordsPagination = By.xpath("//span[@class='p-paginator-current ng-star-inserted']");
    
    // Constructor
    private WebDriver driver;

    public Batch_POF(WebDriver driver) {
        this.driver = driver;
    }

    // Methods    
    public void clickLast() {
    	JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", driver.findElement(lastPage));
	    System.out.println("clicked last page ");
    }
    public void clickBatchFromHeader() {
    	driver.findElement(batchLinkHomePage).click();
    }
    public void clickLogout() {
    	driver.findElement(logout).click();
    }
    public String getTitle() {
    	return driver.getTitle();
    }
    public String getCurrentUrl() {
		return driver.getCurrentUrl();
		}
    public boolean isButtonEnabled() {
    	return driver.findElement(deleteMultipleButton).isEnabled();
    }
    public By getBatchName() {
    	return batchNameHeader;
    }
    public By getBatchDesc() {
    	return batchDescHeader;
    }
    public By getBatchStatus() {
    	return batchStatusHeader;
    }
    public By getProgramName() {
    	return programNameHeader;
    }
    public By getNoOfClasses() {
    	return NoOfClassBatchHeader;
    }
    public By getEditOrDeleteHeader() {
    	return editOrDeleteHeader;
    }
    public By getCheckBoxHeader() {
    	return checkBoxHeader;
    }
    public By getMenuAddNewBatchButton() {
    	return MenuAddNewBatch;
    }
    public void clickAddNewBatchButton() {
    	clickBatchFromHeader();
    	driver.findElement(MenuAddNewBatch).click();
    }
    public By getlogout() {
    	return logout;
    }
    public By getSearchBox() {
    	return SearchTextBox;
    }
    public By getAllBatchNames() {
    	return batchNameAllrows;
    }
    public void verifyAddNewBatchDetailsWindowOpened(String expectedTitle) {
    	 try {
    	WebElement modal = driver.findElement(batchDetailsModalDialog);
    	if(modal.isDisplayed()) {
    		System.out.println("Modal dialog is displayed successfully.");
            return;
        }
    } catch (NoSuchElementException e) {
        System.out.println("No modal dialog found.");
    }
    }
    	
    public void enterSearchText() {
    	driver.findElement(SearchTextBox).sendKeys("Playwright");
    }
    public boolean searchResultsValidate() {
    	List<WebElement> allBatchNames=driver.findElements(batchNameAllrows);
    	List <WebElement> allBatchDesc = driver.findElements(batchDescAllrows);
    	List<WebElement> allProgName = driver.findElements(prgNameAllrows);
    	String searchKeyword = driver.findElement(SearchTextBox).getText();
    	 boolean allResultsContainKeyword = true;
    	    for (WebElement result : allBatchNames) {
    	        String resultText = result.getText();
    	        if (!resultText.toLowerCase().contains(searchKeyword.toLowerCase())) {
    	            System.out.println("Keyword not found in: " + resultText);
    	            allResultsContainKeyword = false;
    	        }
    	    }
    	    for (WebElement result : allBatchDesc) {
    	        String resultText = result.getText();
    	        if (!resultText.toLowerCase().contains(searchKeyword.toLowerCase())) {
    	            System.out.println("Keyword not found in: " + resultText);
    	            allResultsContainKeyword = false;
    	        }
    	    }
    	    for (WebElement result : allProgName) {
    	        String resultText = result.getText();
    	        if (!resultText.toLowerCase().contains(searchKeyword.toLowerCase())) {
    	            System.out.println("Keyword not found in: " + resultText);
    	            allResultsContainKeyword = false;
    	        }
    	    }
    	    return allResultsContainKeyword;
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
    public boolean isDisabled() {
    	return (!driver.findElement(lastPage).isEnabled());
    }
    public boolean isFirstDiabled() {
    	return (!driver.findElement(firstPage).isEnabled());
    }

    public boolean isElementEnabled(WebDriver driver,By locator) {
    	WebElement element = driver.findElement(locator);
    	try {
           // return element.isDisplayed();
            if(element.isEnabled()) {
            	System.out.println(element.getText()+" is enabled");
            	return true;
            	}
            else {
            	System.out.println(element.getText()+" is disabled");
            	return false;
            }          	
        	} catch (Exception e) {
            // Element is not found or another error occurred
        		System.out.println(element.getText()+" not found");
            return false;
        }
    }
    public void scrollUntilVisibleWithWait(WebDriver driver, By locator) {
    	if (driver == null) {
            throw new IllegalStateException("WebDriver is not initialized.");
        }
    	WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", element);     
    }
    
    public WebElement BatchHeading() {
    	return driver.findElement(ManageBatchHeading);
    }
    public By getPaginationPanel() {
		return paginationPanel;
    	
    }
    public By editButton() {
    	return editButtonBatch;
    }
    public By deleteButton() {
    	return deleteButtonBatch;
    }
    public By allEditButtons() {
    	return allEditButtons;
    }
    public By allDeleteButtons() {
    	return allDeleteButtons;
    }
    public By allCheckBoxes() {
    	return allcheckboxes;
    }
    public By getAllSortIcons() {
    	return allSortIcons;
    }
    
    //this same method is used to validate all edit buttons,all delete buttons,all sort icons and all checkboxes on each row 
    public boolean areAllEditOrDeleteOrCheckBoxOrSortIconDisplayed(WebDriver driver, By locator) {
        try {
        	//wait and scroll till all elements are visible
        	scrollUntilVisibleWithWait(DriverFactory.getDriver(), locator);
            // Locate all Edit buttons on the page
            List<WebElement> editButtons = driver.findElements(locator);
            // Verify if all Edit buttons are displayed
            for (WebElement button : editButtons) {
                if (!button.isDisplayed()) {
                    System.out.println("Elements are not displayed.");
                    return false;
                }
            }

            System.out.println("Elements are displayed.");
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public void clicktheOption(WebDriver driver ,By locator) {
		WebElement element =driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
	}
    public By getNextLink() {
    	return nextPage;
    }
    public By getlastPage() {
    	return lastPage;
    }
    public By getpreviousLink() {
    	return previousPage;
    }
    public By getFirstPage() {
    	return firstPage;
    }

    
}
