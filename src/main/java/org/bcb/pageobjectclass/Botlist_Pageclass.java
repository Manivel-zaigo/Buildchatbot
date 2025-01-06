package org.bcb.pageobjectclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Botlist_Pageclass {

	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000);

	WebDriver driver;
	WebDriverWait wait;

	public Botlist_Pageclass(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// Login path
	By Email = By.xpath("//*[@id='email']");
	By Password = By.xpath("//*[@id='password']");
	By Login = By.xpath("//*[@id='loginsubmit']");
	By Dashboard = By.xpath("//*[contains(text(),'Create Your Chatbot')]");

	// Bot creation
	By closetips = By.xpath("/html/body/div[2]/button");
	By botfield = By.xpath("//*[@id='chatName']");
	By createbotbtn = By.id("createbot");
	By emptyfield = By.xpath("//*[text()='Please Enter ChatBot Name.']");
	By bothome = By.xpath("//*[@id='textInputP']");
	
	//List page
	By listpage = By.xpath("//*[@id='navbarSupportedContent']/ul/li[7]/a");
	By botlist = By.xpath("//*[@id='page']/section/div[2]/div/div[3]/div/div/div/div/h4");
	
	//Upload txt file
	By closetipuploads = By.xpath("/html/body/div[4]/button");
	By txttab = By.xpath("//*[@id='txt']");
	By uploadfield = By.xpath("//div[@id='upload-file-sec_txt']");
	By selectcheckbox = By.xpath("//*[@id='files-list-container_txt']/div/div[1]/span[2]");
	By updatesyncbtn = By.id("submitButton_txt");
	By syncfilepopup = By.xpath("//*[@id='toast-container']");
	
	//Upload txt-content
	By txtcontenttab = By.xpath("//*[@id='text_content']");
	By txtcontentfield = By.id("txtcontent");
	By submitsynctext = By.xpath("//*[@id='submitButton-txtcontent']");
	
	//View synced files status
	By gosyncstatus = By.xpath("//*[@id='tab6']/div/div[1]/p/a");
	By txtfilestatus = By.xpath("//*[@id='accordionExample']/div[5]/h2/button/div/div/p");
	By txtcontentstatus = By.xpath("//*[@id='accordionExample']/div[10]/h2/button/div/div/p");
	
	//Chatbot preview
	By chatbotpreviewtab = By.xpath("//*[@id='page']/section/div[2]/div/div/div/div/div[1]/ul/li[2]/a");
	By questionfield = By.xpath("//*[@id='messageinput']");
	By questionsendbtn = By.xpath("//*[@id='chatboxbuttoninput']/span/i");
	By botreply = By.xpath("//*[@id='bc-messageid']/p[3]");
	
	

	// Inputs removed from the fields
	private void clearField(By element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).clear();
	}

	// Click the elements
	private void click(By element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
	}

	private void click(WebElement element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOf(element));

		Actions actions = new Actions(driver);
		// Perform the click action using the actions object
		actions.click(element).build().perform();
	}
	

	private void EnterText(By element, String value) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(value);

	}
	
	
	public static void attachmentFile(String location) throws AWTException {
		StringSelection selection = new StringSelection(location);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(selection, null);
		Robot robot = new Robot();
		robot.keyPress(KeyEvent.VK_CONTROL);
		robot.keyPress(KeyEvent.VK_V);
		robot.keyRelease(KeyEvent.VK_CONTROL);
		robot.keyRelease(KeyEvent.VK_V);
		robot.keyPress(KeyEvent.VK_ENTER);
		robot.keyRelease(KeyEvent.VK_ENTER);

	}
	
	public Boolean conditionChecking1() {
		Boolean text = false;
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			text = wait.until(ExpectedConditions.visibilityOfElementLocated(bothome)).isEnabled();
		} catch (Exception e) {
			return text;
		}
		return text;
	}

	// Login success with valid inputs
	public String setcredentials() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get(driver.getCurrentUrl());
		this.EnterText(Email, "berlin@zaigoinfotech.com");
		this.EnterText(Password, "Password@123");
		this.click(Login);
		Thread.sleep(3000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Dashboard));
		String dashboard = driver.findElement(Dashboard).getText();
		return dashboard;
	}

	// Bot creation success
	public String botcreate() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
//		this.EnterText(botfield, "Test" + randomInt);
		Thread.sleep(2000);
		this.click(closetips);
		Thread.sleep(2000);
		
		this.EnterText(botfield, "Testbot");
		Thread.sleep(2000);
		boolean condition = false;
		if (!this.conditionChecking1()) {
			do {
				this.click(createbotbtn);
				if (this.conditionChecking1()) {
					condition = false;
				}
			} while (condition);
		}

		String bothomepage = driver.findElement(bothome).getText();
		return bothomepage;

	}
	
	public String botlist() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		this.click(listpage);
		wait.until(ExpectedConditions.visibilityOfElementLocated(botlist));
		String Botlist = driver.findElement(botlist).getText();
		return Botlist;
		
	}
	
	public String txtfile() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(3000);
		this.click(closetipuploads);		
		Thread.sleep(5000);
//		this.click(botlist);
		this.click(txttab);
		Thread.sleep(2000);
		
        // Set the file path to be uploaded
		this.click(uploadfield);
		Thread.sleep(2000);
        String TXTPath = "C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\upload_pdf\\Community user validations.doc.txt";
        Botlist_Pageclass.attachmentFile(TXTPath);
        Thread.sleep(5000);
        
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,600)");
        Thread.sleep(5000);
        
//        WebElement chk_box = wait.until(ExpectedConditions.visibilityOfElementLocated(selectcheckbox));
//        Actions actions = new Actions(driver);
//		actions.doubleClick(chk_box).build().perform();
		this.click(selectcheckbox);
        Thread.sleep(3000);
        WebElement syncbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(updatesyncbtn));
        Actions actions1 = new Actions(driver);
		actions1.doubleClick(syncbtn).build().perform();
   		wait.until(ExpectedConditions.visibilityOfElementLocated(syncfilepopup));
		String syncpopup = driver.findElement(syncfilepopup).getText();
		return syncpopup;
		
	}
	
	public String txtcontentfile() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(5000);		
		WebElement textconttab = wait.until(ExpectedConditions.visibilityOfElementLocated(txtcontenttab));
        Actions actions1 = new Actions(driver);
		actions1.doubleClick(textconttab).build().perform();
		Thread.sleep(5000);
		this.EnterText(txtcontentfield, "Manivel,2000,BECSE");
		
		JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,500)");
        Thread.sleep(3000);

		this.click(submitsynctext);
		wait.until(ExpectedConditions.visibilityOfElementLocated(syncfilepopup));
		String syncpopup = driver.findElement(syncfilepopup).getText();
		
		JavascriptExecutor js1 = (JavascriptExecutor) driver;
        js1.executeScript("window.scrollBy(0,-500)");
        Thread.sleep(3000);
        
		return syncpopup;
		
	}
	
	public String chatbotpreview() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(2000);
		this.click(chatbotpreviewtab);
		this.EnterText(questionfield, "What is community");
		Thread.sleep(3000);
		this.click(questionsendbtn);
		wait.until(ExpectedConditions.visibilityOfElementLocated(botreply));
		String botrply = driver.findElement(botreply).getText();
		return botrply;
		
	}
	
}
