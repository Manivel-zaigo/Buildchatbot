package org.bcb.pageobjectclass;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.File;
import java.time.Duration;
import java.util.Arrays;
import java.util.Comparator;
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

	// List page
	By listpage = By.xpath("//*[@id='navbarSupportedContent']/ul/li[7]/a");
	By botlist = By.xpath("//*[@id='page']/section/div[2]/div/div[3]/div/div/div/div/h4");

	// Upload txt file
	By closetipuploads = By.xpath("/html/body/div[4]/button");
	By txttab = By.xpath("//*[@id='txt']");
	By uploadfield = By.xpath("//div[@id='upload-file-sec_txt']");
	By selectcheckbox = By.xpath("//*[@id='files-list-container_txt']/div/div[1]/span[2]");
	By updatesyncbtn = By.id("submitButton_txt");
	By syncfilepopup = By.xpath("//*[@id='toast-container']");
	By invalidfile = By.xpath("//*[@id='toast-container']/div/div");

	// Upload txt-content
	By txtcontenttab = By.xpath("//*[@id='text_content']");
	By txtcontentfield = By.id("txtcontent");
	By submitsynctext = By.xpath("//*[@id='submitButton-txtcontent']");

	// Upload PDF file
	By pdftab = By.xpath("//*[@id='pdf']");
	By pdfupload = By.xpath("//div[@id='upload-file-sec']");
	By pdfcheckbox = By.xpath("//*[@id='files-list-container']/div/div[1]/span[2]");
	By pdfsyncbtn = By.id("submitButton-pdf");
//	By syncpdfpopup = By.xpath("//*[@id='toast-container']");

	// Upload Doc file
	By doctab = By.xpath("//*[@id='docx']");
	By docupload = By.xpath("//div[@id='upload-file-sec_doc']");
	By doccheckbox = By.xpath("//*[@id='files-list-container_doc']/div/div[1]/span[2]");
	By docsyncbtn = By.xpath("//*[@id='submitButton_doc']");
//	By syncdocpopup = By.xpath("//*[@id='toast-container']");

	// View synced files status
	By gosyncstatus = By.xpath("//*[@id='tab6']/div/div[1]/p/a");
	By txtfilestatus = By.xpath("//*[@id='accordionExample']/div[5]/h2/button/div/div/p");
	By txtcontentstatus = By.xpath("//*[@id='accordionExample']/div[10]/h2/button/div/div/p");

	// Chatbot preview
	By chatbotpreviewtab = By.xpath("//*[@id='page']/section/div[2]/div/div/div/div/div[1]/ul/li[2]/a");
	By questionfield = By.xpath("//*[@id='messageinput']");
	By questionsendbtn = By.xpath("//*[@id='chatboxbuttoninput']/span/i");
	By botreply = By.xpath("//*[@id='bc-messageid']/p[3]/span[2]");

	// Settings - User form settings - Collect User Data
	By settingstab = By.xpath("//*[@id='page']/section/div[2]/div/div/div/div/div[1]/ul/li[3]/a");
	By toggle = By.xpath("//*[@id='tab-1']/div[1]/div[1]/div/div[2]/label/div");
	By businessnamecheckbox = By.xpath("//*[@id='customize-inputs-checkbox']/li[2]/label");
	By phonenumbercheckbox = By.xpath("//*[@id='customize-inputs-checkbox']/li[5]/label");
	By formsavebutton = By.xpath("//*[@id='tab-1']/div[2]/p/span/button");
	By savepopup = By.xpath("//*[@id='toast-container']/div/div");

	// Widget download
	By launchchatbottab = By.xpath("//*[@id='page']/section/div[2]/div/div/div/div/div[1]/ul/li[7]/a");
	By downloadfile = By.xpath("//*[@id='downloadBtn2']");

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
		Thread.sleep(2000);
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

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(3000);

		return syncpopup;

	}

	public String fileinvalid() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(3000);
		this.click(closetipuploads);
		Thread.sleep(5000);

		this.click(txttab);
		Thread.sleep(2000);

		// Set the file path to be uploaded
		this.click(uploadfield);
		Thread.sleep(2000);
		String InvalidPath = "C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\upload_pdf\\Beginner-Guide-To-Software-Testing.pdf";
		Botlist_Pageclass.attachmentFile(InvalidPath);
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(invalidfile));
		String syncpopup = driver.findElement(invalidfile).getText();

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

	public String pdffile() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(5000);
		this.click(pdftab);
		Thread.sleep(2000);

		// Set the file path to be uploaded
		this.click(pdfupload);
		Thread.sleep(2000);
		String PDFPath = "C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\upload_pdf\\Beginner-Guide-To-Software-Testing.pdf";
		Botlist_Pageclass.attachmentFile(PDFPath);
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);

		this.click(pdfcheckbox);
		Thread.sleep(3000);
		WebElement syncbtn = wait.until(ExpectedConditions.visibilityOfElementLocated(pdfsyncbtn));
		Actions actions1 = new Actions(driver);
		actions1.doubleClick(syncbtn).build().perform();
		wait.until(ExpectedConditions.visibilityOfElementLocated(syncfilepopup));
		String syncpopup = driver.findElement(syncfilepopup).getText();

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-500)");
		Thread.sleep(3000);

		return syncpopup;

	}

	public String docfile() throws InterruptedException, AWTException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		Thread.sleep(5000);
		this.click(doctab);
		Thread.sleep(2000);

		// Set the file path to be uploaded
		this.click(docupload);
		Thread.sleep(2000);
		String DOCPath = "C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\upload_pdf\\Testing Activities.docx";
		Botlist_Pageclass.attachmentFile(DOCPath);
		Thread.sleep(5000);

		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");
		Thread.sleep(5000);

		this.click(doccheckbox);
		Thread.sleep(3000);
		this.click(docsyncbtn);
		wait.until(ExpectedConditions.visibilityOfElementLocated(syncfilepopup));
		String syncpopup = driver.findElement(syncfilepopup).getText();

		JavascriptExecutor js1 = (JavascriptExecutor) driver;
		js1.executeScript("window.scrollBy(0,-700)");
		Thread.sleep(3000);

		return syncpopup;

	}

	public String chatbotpreview() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(3000);
		this.click(chatbotpreviewtab);
		Thread.sleep(5000);

		this.EnterText(questionfield, "What is the testing?");
		Thread.sleep(3000);
		this.click(questionsendbtn);
		
		wait.until(ExpectedConditions.visibilityOfElementLocated(botreply));
		String botrply = driver.findElement(botreply).getText();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,-400)");
		Thread.sleep(5000);
		
		return botrply;

	}

	public String settingssave() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(3000);
		this.click(settingstab);
		Thread.sleep(5000);

		this.click(toggle);
		Thread.sleep(3000);
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,400)");
		Thread.sleep(5000);

		this.click(businessnamecheckbox);
		this.click(phonenumbercheckbox);
		Thread.sleep(3000);

		this.click(formsavebutton);
		js.executeScript("window.scrollBy(0,-400)");
		Thread.sleep(5000);
		wait.until(ExpectedConditions.visibilityOfElementLocated(savepopup));
		String popup = driver.findElement(savepopup).getText();
		return popup;

	}

	public String widgetdownload() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		Thread.sleep(3000);
		this.click(launchchatbottab);
		Thread.sleep(5000);

		this.click(downloadfile);
		Thread.sleep(5000);

		File dir = new File("C:\\Users\\Admin\\Downloads");
		File latestFile = null;
		int waitTime = 0;

		while (waitTime < 20000) {
			File[] files = dir.listFiles((d, name) -> name.toLowerCase().endsWith(".html"));
			if (files != null && files.length > 0) {
				latestFile = Arrays.stream(files).max(Comparator.comparingLong(File::lastModified)).orElse(null);
				if (latestFile != null && latestFile.exists()) {
					break;
				}
			}
			Thread.sleep(1000); // wait 1s
			waitTime += 1000;
		}

		if (latestFile == null) {
			System.out.println("❌ No HTML file downloaded.");
			return null;
		}

		// ✅ Open in a new tab
		String fileUrl = "file:///" + latestFile.getAbsolutePath().replace("\\", "/");
		// Open new tab manually and switch
		((JavascriptExecutor) driver).executeScript("window.open('about:blank','_blank');");
		for (String tab : driver.getWindowHandles()) {
			driver.switchTo().window(tab);
		}
		// Now navigate to the file
		driver.get(fileUrl);

		System.out.println("✅ Opened file: " + fileUrl);

		return latestFile.getName();

	}

}
