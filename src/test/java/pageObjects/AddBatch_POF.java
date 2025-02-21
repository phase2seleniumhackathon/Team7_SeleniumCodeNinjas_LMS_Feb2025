package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddBatch_POF {
	
	//Locators
	private By programNameDropDown = By.xpath("//input[@placeholder='Select a Program name']");
	private By batchNamePrefix = By.id("batchProg");
	private By batchNameSuffix = By.id("batchName");
	private By batchDescription = By.id("batchDescription");
	private By activeStatus = By.xpath("(//p-radiobutton[@name='category'])[1]");
	private By inactiveStatus = By.xpath("(//p-radiobutton[@name='category'])[2]");
	private By noOfClasses = By.id("batchNoOfClasses");
	private By saveButton = By.xpath("//button[@label='Save']");
	private By cancelButton = By.xpath("//button[@label='Cancel']");
	private By closeButton = By.xpath("//button[@tabindex='-1']");
	
	//constructor
	private WebDriver driver;
	
	public AddBatch_POF(WebDriver driver) {
			this.driver=driver;
	}
	
	//Methods
	private By getProgramName() {
		return programNameDropDown;
	}
	private By getBatchNamePrefix() {
		return batchNamePrefix;
	}
	private By getBatchNameSuffic() {
		return batchNameSuffix;
	}
	private By getBatchDesciption() {
		return batchDescription;
	}
	private By getActiveStatus() {
		return activeStatus;
	}
	private By getInActiveStatus() {
		return inactiveStatus;
	}
	private By getNoOfClasses() {
		return noOfClasses;
	}
	private By getSaveButton() {
		return saveButton;
	}
	private By getCancelButton() {
		return cancelButton;
	}
	private By getCloseButton() {
		return closeButton;
	}
	

}
