package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.TimeoutException;

public class DeleteBatch_POF {

	private WebDriver driver;
	
	public DeleteBatch_POF(WebDriver driver) {
        this.driver = driver;
    }
	
	//locators
	private By deleteIcon=By.xpath("(//button[@icon='pi pi-trash'])[2]");
	private By yesButton =By.xpath("//span[text()='Yes']");
	private By noButton = By.xpath("//span[text()='No']");
	private By confirmDialog=By.xpath("//div[@class='p-dialog-header ng-tns-c118-150 ng-star-inserted']");
	private By closeButton = By.xpath("//span[@class='pi pi-times ng-tns-c118-150']");
	private By successMsg = By.xpath("//div[@role='alert']");
	private By deletecheckboxfirstrow = By.xpath("(//div[@role='checkbox'])[2]");
	private By deleteCheckboxSecondrow = By.xpath("(//div[@role='checkbox'])[3]");
	private By multipleDeleteBatch = By.xpath("//button[@icon='pi pi-trash']"); 
	private By confirmHeading = By.xpath("//span[contains(text(),'Confirm')]");
	
	public By getdeleteIcon() {
		return deleteIcon;
	}
	public By getYesButton() {
		return yesButton;
	}
	public By getNoButton() {
		return noButton;
	}
	public By getClose() {
		return closeButton;
	}
	public String getConfrimHeading() {
		return driver.findElement(confirmHeading).getText();
	}
	public boolean verifyDeletBatchConfirmDialog() {
	   	 try {
	   	WebElement modal = driver.findElement(confirmDialog);
	   	if(modal.isDisplayed()) {
	   		System.out.println("Modal dialog is displayed successfully.");
	           return true;
	       }
	   } catch (NoSuchElementException e) {
	       System.out.println("No modal dialog found.");
	   }
		return false;
	   }
	public boolean verifyYesNoButtonPresent() {
		WebElement yes = driver.findElement(yesButton);
		WebElement no = driver.findElement(noButton);
		if(yes.isDisplayed() && no.isDisplayed())
			return true;
		else
			return false;
	}
	public void clicktheOption(WebDriver driver ,By locator) {
		try {
		WebElement element =driver.findElement(locator);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", element);
		}
		catch(NoSuchElementException e) 
		{
			System.out.println("error");
		}
	}
	public String validateSucessMessage() {
		   WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
		   WebElement sucessMsg = wait.until(ExpectedConditions.presenceOfElementLocated(successMsg));
		   String sucess= sucessMsg.getText();
		   System.out.println(sucess);
		   return sucess;
	   }
	public void multipleDeleteBatch() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", driver.findElement(deletecheckboxfirstrow));
		js.executeScript("arguments[0].click();", driver.findElement(deleteCheckboxSecondrow));
		js.executeScript("arguments[0].click();", driver.findElement(multipleDeleteBatch));
		js.executeScript("arguments[0].click();", driver.findElement(yesButton));
	}
	public void singleRowSelect() {
		WebElement first =driver.findElement(deletecheckboxfirstrow);
		JavascriptExecutor js = (JavascriptExecutor) driver;
	    js.executeScript("arguments[0].click();", first);
	}
	public void verifyBatchDeleteWindowClosed() {
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	    
	    try {
	        boolean isClosed = wait.until(ExpectedConditions.invisibilityOfElementLocated(confirmDialog));
	        if (isClosed) {
	            System.out.println("Window closed successfully.");
	        } else {
	            System.out.println("Modal is still visible.");
	        }
	    } catch (TimeoutException e) {
	        System.out.println("Modal did not close within the timeout.");
	    } catch (StaleElementReferenceException e) {
	        System.out.println("Modal reference is stale, assuming it is closed.");
	    } catch (NoSuchElementException e) {
	        System.out.println("No modal dialog found. Assuming it is closed.");
	    }
	}
}
