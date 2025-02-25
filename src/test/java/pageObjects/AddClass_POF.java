package pageObjects;

import java.io.IOException;
import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import driverFactory.DriverFactory;
import jdk.internal.org.jline.utils.Log;
import utilities.ConfigReader;
import utilities.ExcelReaderMadhu;


public class AddClass_POF {
	
	
	
	//=============Locators====================
	
	
	private By classinMenubar = By.xpath("//span[text()='Class']");
	private By addNewClass = By.xpath("//button[contains(text(),'Add New Class')]");
	private By popupWindow = By.xpath("//div[@class='ng-trigger ng-trigger-animation ng-tns-c81-10 p-fluid p-dialog p-component p-dialog-draggable p-dialog-resizable ng-star-inserted']");
	private By classclick = By.xpath("//span[text()='Class']");
	private By addnewclass = By.xpath("//button[contains(text(),'Add New Class')]");
	private By save	= By.xpath("//span[contains(text(),'Save')]");
	private By cancel	= By.xpath("//span[text()='Cancel']");
	private By xbutton = By.xpath("//span[contains(@class, 'p-dialog-header-close-icon') and contains(@class, 'pi-times')]");
	private By batchName = By.xpath("//label[text()='Batch Name']");
	private By batchNameCheckbox = By.xpath(" //input[@placeholder='Select a Batch Name']");
	private By classTopic = By.xpath("//label[contains(text(),'Class Topic ')]");
	private By classTopicCheckbox = By.xpath("//input[@id='classTopic']");
	private By classDescription = By.xpath("//label[contains(text(),'Class Description')]");
	private By classDescriptionCheckbox = By.xpath("//input[@id='classDescription']");
	private By selectClassDates = By.xpath("//label[contains(text(),' Select Class Dates ')]");
	private By selectClassDatesCheckbox = By.xpath("//input[@id='icon']");
	private By noOfClasses = By.xpath("//label[@for='classNo']");
	private By noOfClassesCheckbox = By.xpath("//input[@id='classNo']");
	private By staffName = By.xpath("//label[@for='staffId']");
	private By staffNameCheckBox = By.xpath("//input[@placeholder='Select a Staff Name']");
	private By status = By.xpath("//lable[contains(text(),'Status')]");
	private By comments = By.xpath("//label[@for='classComments']");
	private By commentsCheckbox = By.xpath("//input[@id='classComments']");
	private By notes = By.xpath("//label[@for='classNotes']");
	private By notesCheckbox = By.xpath("//input[@id='classNotes']");
	private By recordings = By.xpath("//label[@for='classRecording']");
	private By recordingsCheckbox = By.xpath("//input[@id='classRecordingPath']");
	private By statusActive = By.xpath("//div[@class='radio ng-star-inserted']/div[2]");
	private By statusInactive = By.xpath("//div[@class='radio ng-star-inserted']/div[3]");

	//=====================Add new class popup locators======================================
	
	private By dropdownarrow = By.cssSelector("span[class*='p-dropdown-trigger-icon'][class*='pi-chevron-down']");
	private By alertmsg = By.xpath("//div[contains(@class, 'p-toast-detail')]");
	private By dropdownList = By.cssSelector("li[role='option']");
	private By batchNameError = By.xpath("//*[contains(text(),'Batch Name is required.')]");
	private By classTopicError = By.xpath("//*[contains(text(),'Class Topic is required.')]");
	private By classDateError = By.xpath("//*[contains(text(),'Class Date is required.')]");
	private By noOfClassesError = By.xpath("//*[contains(text(),'No. of Classes is required.')]");
	private By staffNameError = By.xpath("//*[contains(text(),'Staff Name is required.')]");
	private By statusError = By.xpath("//*[contains(text(),'Status is required.')]");
	private By classdetailsWindow = By.xpath("//span[text()='Class Details']");
	private By header = By.xpath("//div[@class='p-dialog-header ng-tns-c81-10 ng-star-inserted']");
	private By activeStatusRadioBtn = By.xpath("//input[@id='Active']/ancestor::div[contains(@class,'p-radiobutton')]");
	
	//===========constructor===============
	private WebDriver driver;
	ExcelReaderMadhu excelReader;
	WebDriverWait wait;
	ConfigReader configReader;
	
	public AddClass_POF() {
		this.driver = DriverFactory.getDriver();
		this.excelReader = new ExcelReaderMadhu("src\\test\\resources\\TestData\\Team7-TestData.xlsx");
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}

	 public String getTitle() {
	    	return driver.getTitle();
	    }
	    public String getCurrentUrl() {
			return driver.getCurrentUrl();
			}
	
	    
//===============Manage Class================================
	
	public void manageClass() {
		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(5));
		WebElement classHeader = wait.until(ExpectedConditions.elementToBeClickable(classclick));
	
		try {
	        classHeader.click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", classHeader);
	    }

		
	
}
	
//==================Add New Class==========================
	public void addNewClass() {

		WebDriverWait  wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		WebElement AddnewclassClick = wait.until(ExpectedConditions.elementToBeClickable(addnewclass));
	 
		try {
			Thread.sleep(5000);
			AddnewclassClick.click();
	    } catch (Exception e) {
	        ((JavascriptExecutor) driver).executeScript("arguments[0].click();", AddnewclassClick);
	    }
	
	}
 //==================Save Button============================
	public boolean isSaveButtonDisplayed() {
		System.out.println(driver.findElement(save).getText());
		return driver.findElement(save).isDisplayed();
		
	}

//==================Cancel Button=============================
	public boolean isCancelButtonDisplayed() {
		System.out.println(driver.findElement(cancel).getText());
		return driver.findElement(cancel).isDisplayed();
		
	}

//=====================X Button============================
	public boolean isXButtonDisplayed() throws InterruptedException {
		
//		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//		WebElement closeButton = wait.until(ExpectedConditions.elementToBeClickable(
//		   By.xpath("//span[@class='p-dialog-header-close-icon ng-tns-c81-18 pi pi-times']")));
		return driver.findElement(xbutton).isDisplayed();
	}
		
//===================All Input Fields==========================
		
	
	//-------------Batch Name----------------
	
			public boolean batchName()  {
				System.out.println(driver.findElement(batchName).getText());
				return driver.findElement(batchName).isDisplayed();
			}

			public boolean batchNameTextBox()  {
				System.out.println(driver.findElement(batchNameCheckbox).getText());
				return driver.findElement(batchNameCheckbox).isDisplayed();
			}
	//----------------Class Topic----------------		
			public boolean classTopic()  {
				return driver.findElement(classTopic).isDisplayed();
			}
			
			public boolean classTopicTextBox()  {
				return driver.findElement(classTopicCheckbox).isDisplayed();
			}
			
			
			
	//--------------Class Description-------------------
			
			public boolean classDescription()  {
				return driver.findElement(classDescription).isDisplayed();
			}
			
			public boolean classDescriptionTextBox()  {
				return driver.findElement(classDescriptionCheckbox).isDisplayed();
			}
			
	//--------------Select Class Dates-------------------		
			
			
			public boolean classDates()  {
				return driver.findElement(selectClassDates).isDisplayed();
			}
			
			public boolean classDatesTextBox()  {
				return driver.findElement(selectClassDatesCheckbox).isDisplayed();
			}
			
	//----------------No of Classes-----------------
			
			public boolean numberOfClass()  {
				return driver.findElement(noOfClasses).isDisplayed();
			}
			
			public boolean numberOfClassTextBox()  {
				return driver.findElement(noOfClassesCheckbox).isDisplayed();
			}
	
	//--------------Staff Name-------------------
			
			
			public boolean staffName()  {
				return driver.findElement(staffName).isDisplayed();
			}
			
			public boolean staffNameTextBox()  {
				return driver.findElement(staffNameCheckBox).isDisplayed();
			}	
			
			
	//----------------------Status-----------------
			

			public boolean status()  {
				return driver.findElement(status).isDisplayed();
			}
			
			
	//----------------Validate Select Status---------------
			
			public void validateStatusSelection() {
				WebDriverWait wait 	= new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement activeStatus = wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(statusActive)));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", activeStatus);
				Assert.assertEquals(activeStatus.getText(),"Active");
				
				WebDriverWait waitI 	= new WebDriverWait(driver, Duration.ofSeconds(10));
				WebElement inactiveStatus = waitI.until(ExpectedConditions.elementToBeClickable(driver.findElement(statusInactive)));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();", inactiveStatus);
				Assert.assertEquals(inactiveStatus.getText(),"Inactive");
				
			}
			
	//------------Comments------------------
			
			

			public boolean comments()  {
				return driver.findElement(comments).isDisplayed();
			}
			
			public boolean commentsTextBox()  {
				return driver.findElement(commentsCheckbox).isDisplayed();
			}	
			
			
	//---------------Notes--------------------
			
			public boolean notes()  {
				return driver.findElement(notes).isDisplayed();
			}
			
			public boolean notesTextBox()  {
				return driver.findElement(notesCheckbox).isDisplayed();
			}	
			
			
	//--------------Recordings-----------------
			
			public boolean recordings()  {
				return driver.findElement(recordings).isDisplayed();
			}
			
			public boolean recordingsTextBox()  {
				return driver.findElement(recordingsCheckbox).isDisplayed();
			}	
			
	//=====================Add New Class Popup=====================
			
				
//			public boolean selectBatchNameDropdown(String optionToSelect) {
//				
//				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
//				WebElement dropdownElement = driver.findElement(dropdown);
//				((JavascriptExecutor) driver).executeScript("arguments[0].click();",wait.until(ExpectedConditions.elementToBeClickable(dropdownElement)));
//			
//			try {
//				List<WebElement> roleStatusOptions =  wait.until(
//			            ExpectedConditions.presenceOfAllElementsLocatedBy(By.cssSelector("li[role='option']")));
//			            //driver.findElements((By.cssSelector("li[role='option']")));
//				for(WebElement roleStatus : roleStatusOptions)
//				{
//					
//					String optionText = roleStatus.getText().trim();
//		            System.out.println("Dropdown option found: " + optionText);
//
//		            if (optionText.equalsIgnoreCase(optionToSelect)) {
//					
//					((JavascriptExecutor) driver).executeScript("arguments[0].click();",wait.until(ExpectedConditions.elementToBeClickable(roleStatus)));
//					
//					
//					System.out.println("Selected Role status: " + optionText);
//					
//					WebElement selectedOption = wait.until(
//		                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='ng-star-inserted']")));
//					
//					  String selectedText = selectedOption.getText().trim();
//					//System.out.println("Batch name" + roleStatus.getText());
//					//return roleStatus;
//					Assert.assertEquals(selectedText, optionToSelect, "Dropdown Selection Mismatched");
//					return true;
////					
////				}
//				}
//				
//				System.out.println("Options not found" +optionToSelect );
//			
//				
//			    } catch (StaleElementReferenceException e) {
//				
//				System.out.println("Some Exception" + e.getMessage());
//			}
//			return false;
//		}	
//			
	
			public void selectBatchName(String batch) {
				driver.findElement(dropdownarrow).click();
				
				 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
				 
				 List<WebElement> batchNameOptionsList = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.cssSelector("li[role='option']")));
				Actions actions = new Actions(driver);
				
				
			for(WebElement option : batchNameOptionsList ) {
				
				System.out.println("Option Text: " + option.getText());
				if (option.getText().equalsIgnoreCase(batch)) {
					
					System.out.println("Matched");
					 actions.moveToElement(option).click().perform();
			            return;
				
				}
				
				
			}
			}
			
			public void enterClassTopic() {
				driver.findElement(classTopicCheckbox).sendKeys("Selenium");
			
			}
			
			public void selectClassDates() throws InterruptedException {


				//wait = new WebDriverWait(driver, Duration.ofSeconds(5));
				Thread.sleep(3000);
				WebElement datePicker = driver.findElement(By.xpath("//span[@class='p-button-icon pi pi-calendar']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",
						wait.until(ExpectedConditions.elementToBeClickable(datePicker)));
				
				
				//wait = new WebDriverWait(driver, Duration.ofSeconds(50));
				
				Thread.sleep(3000);
				WebElement dateToSelect = driver.findElement(By.xpath("//table//span[normalize-space()='25']"));
				((JavascriptExecutor) driver).executeScript("arguments[0].click();",
						wait.until(ExpectedConditions.elementToBeClickable(dateToSelect)));
			((JavascriptExecutor) driver).executeScript("arguments[0].click();",
						wait.until(ExpectedConditions.elementToBeClickable(datePicker)));
				
//			Actions actions = new Actions(driver);
//			actions.moveByOffset(10, 10).click().perform(); 

			}

			public boolean selectStaffName() {
				WebElement select_staffName_drpdown = driver
						.findElement(By.xpath("(//span[contains(@class,'p-dropdown-trigger-icon') and contains(@class,'pi-chevron-down')])[2]"));
				select_staffName_drpdown.click();
				try {
					List<WebElement> roleStatusOptions = driver.findElements((By.cssSelector("li[role='option']")));
					for (WebElement roleStatus : roleStatusOptions) {
						roleStatus.click();
						System.out.println("Role status: " + roleStatus.getText());
						//Assert.assertEquals(roleStatus.getText(), select_staffName_drpdown.getText());
						return true;
					}
				} catch (StaleElementReferenceException e) {
					System.out.println("Some expection" + e.getMessage());
				}
				return false;
			}
			
			
			public void successAlert() {
				Alert alert = driver.switchTo().alert();
				String alertText = alert.getText();
				System.out.println("Alert text: " + alertText);
			}
			
			public void enterMandatoryFields(String sheetName, String scenarioName) throws IOException, InterruptedException{
				
				sheetName = "Class";
				List<String> data = excelReader.getRowData(sheetName, 0, scenarioName);
				if(scenarioName.equals("addClassWithOnlyMandatoryFields")) {
					 String batchName = data.get(1);
					String classTopicText = data.get(2);
					
					selectBatchName(batchName);
					
					wait = new WebDriverWait(driver, Duration.ofSeconds(30));
					driver.findElement(classTopicCheckbox).sendKeys(classTopicText);

					
					selectClassDates();
					wait = new WebDriverWait(driver, Duration.ofSeconds(30));
					
//					Actions actions = new Actions(driver);
//					actions.moveByOffset(500, 500).click().perform(); 

					JavascriptExecutor js = (JavascriptExecutor) driver;
					js.executeScript("document.body.click();");
					Thread.sleep(2000);
					
					selectStaffName();
					Thread.sleep(2000);
					
					WebElement activeBtn = driver.findElement(activeStatusRadioBtn);
					
					activeBtn.click();
					
					
					WebElement clickSaveBtn = driver.findElement(save);
					clickSaveBtn.click();
					
				
					
				}
			
			}
			
//------------------------- Class with Optional fields------------------------
			
			public void classWithOptionalFields() {
			
				String batchName = "Micro service -03";
					selectBatchName(batchName);
					
					wait = new WebDriverWait(driver, Duration.ofSeconds(30));
					driver.findElement(classDescriptionCheckbox).sendKeys("automation");
					
					wait = new WebDriverWait(driver, Duration.ofSeconds(30));
					driver.findElement(commentsCheckbox).sendKeys("newclass");
					
					driver.findElement(notesCheckbox).sendKeys("automationtesting");
					
					driver.findElement(recordingsCheckbox).sendKeys("https://docs.google.com/spreadsheets");
					
					WebElement clickSaveBtn = driver.findElement(save);
					clickSaveBtn.click();
					
					JavascriptExecutor js = (JavascriptExecutor) driver;
				    js.executeScript("window.scrollTo(0, 0);");
			}
			
		
				public void validateSuccessClassCreated(String sheetName, String scenarioName) throws IOException {
					try {
						List<String> data =excelReader.getRowData(sheetName, 0, scenarioName);
						String messageText = data.get(8);
						wait = new WebDriverWait(driver, Duration.ofSeconds(30)); 
						WebElement alert = wait.until(ExpectedConditions.visibilityOfElementLocated(alertmsg));
						String actualMsg = alert.getText();
						Assert.assertTrue(
								actualMsg.replaceAll("\\s+", " ").trim().contains(messageText.replaceAll("\\s+", " ").trim()));
					} catch (Exception e) {
						Assert.fail("Error in getting alerts" + e.getMessage());
					}
				}
			
			
				
	//----------------------------Date Picker--------------------------
				
				
				public void selectdatePicker() {
					WebElement datePicker =  driver.findElement(By.xpath("//span[@class='p-button-icon pi pi-calendar']"));
					datePicker.click();
					
				}

	//----------------------------Weekend dates------------------------------------

			public void verifyWeekendDisabled() {
			
				List<WebElement> weekendDates = driver.findElements(By.xpath("//td[.//span[contains(@class, 'p-disabled')] and (.//span[text()='1' or text()='2' or text()='8' or text()='9' or text()='15' or text()='16' or text()='22' or text()='23'])]"));
						
						//driver.findElements(By.xpath("//td[(contains(@class, 'ng-star-inserted')) and (.//span[contains(@class, 'p-disabled')]) and (position() mod 7 = 0 or position() mod 7 = 6)]"));
				 Assert.assertFalse(weekendDates.isEmpty(), "No disabled weekends found.");
				
				for (WebElement date : weekendDates) {
					 Assert.assertFalse(date.isEnabled(), "Weekend date should be disabled but is enabled: " + date.getText());
					System.out.println("Weekend date is correctly disabled: " + date.getText());
					
				}
				
			}
			
			
	//--------------------Click Save Button-------------------------
			
			public void clickSaveButton() {
				WebElement saveButtonClick =  driver.findElement(save);
				saveButtonClick.click();
			}
			
			
	//---------------------Error Message---------------------------
		
			public boolean isBatchNameErrorDisplayed() {
		        return driver.findElement(batchNameError).isDisplayed();
		    }

		    public boolean isClassTopicErrorDisplayed() {
		        return driver.findElement(classTopicError).isDisplayed();
		    }

		    public boolean isClassDateErrorDisplayed() {
		        return driver.findElement(classDateError).isDisplayed();
		    }

		    public boolean isNoOfClassesErrorDisplayed() {
		        return driver.findElement(noOfClassesError).isDisplayed();
		    }

		    public boolean isStaffNameErrorDisplayed() {
		        return driver.findElement(staffNameError).isDisplayed();
		    }

		    public boolean isStatusErrorDisplayed() {
		        return driver.findElement(statusError).isDisplayed();
		    }
		
		
//-------------------------Click X button-------------------------
		    
		    public void clickXButton() {
		    	WebElement xButtonClick = driver.findElement(xbutton);
		    	xButtonClick.click();
		    }

//------------------Close Popup window---------------------
		    
		    public boolean isPopupClosed() {
		    	try {
		            
		    		return !driver.findElement(classdetailsWindow).isDisplayed();
		            
		        } catch (NoSuchElementException e) {
		            return true; 
		        }
		    	
		    }
		   
		    
		    
//-----------------Status Active-----------------
		    

			public void statusActive() {

				driver.findElement(statusActive).click();
			}
		  
//------------------validate no of classes------------
			
			public void validateNoOfClasses() throws InterruptedException {
				
				String batchName = "SMPO-0001";
				selectBatchName(batchName);
				
				enterClassTopic();
				
				selectClassDates();
				
				Actions actions = new Actions(driver);
				actions.moveByOffset(200, 200).click().perform(); 
				
				Thread.sleep(2000);

				
			}
		    

//------------------------get no of classes-------------------
			
			public String getNumberOfClasses() {
			    WebElement noOfClassesField = driver.findElement(noOfClassesCheckbox);
			    return noOfClassesField.getAttribute("value"); // Fetches the input field's value
			}




}







































