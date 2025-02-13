package com.test;

import static org.testng.Assert.assertTrue;

import java.awt.AWTException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
import org.bcb.pageobjectclass.Botlist_Pageclass;
import org.bcb.pageobjectclass.Login_Pageclass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Botlist {

	WebDriver driver;
	String value;

	ExtentReports extentReports;
	ExtentHtmlReporter extentHtmlReporter;
	ExtentTest testcase;

	@BeforeClass
	public void browser_launch() throws IOException {

		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		Properties properties = new Properties();
		FileInputStream fileInputStream = new FileInputStream(
				"C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\Reusable records\\config.properties");
		properties.load(fileInputStream);
		value = properties.getProperty("url");
		System.out.println(value);
		fileInputStream.close();
		driver.get(value);

		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Botlist.html");
		extentReports.attachReporter(extentHtmlReporter);
	}

	@AfterClass
	public void quit() {
		driver.quit();
		extentReports.flush();
	}

	@Test(priority = 1)
	private void LoginSuccess() throws InterruptedException, IOException {
		testcase = extentReports.createTest("Check whether the user loggedin success message is displayed");
		Botlist_Pageclass login = PageFactory.initElements(driver, Botlist_Pageclass.class);
		String Dashboard = login.setcredentials();
		if (Dashboard.equals("Create Your Chatbot")) {
			testcase.log(Status.PASS, "Login success message is shown");
			assertTrue(true);
		} else {
			testcase.log(Status.FAIL, "Login success message is not shown");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\loginsuccess.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath(
					"C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\loginsuccess.png");
			assertTrue(false);
		}
//		    assertEquals(Dashboard, "Create Your Chatbot");
	}

	// Bot creation with valid input
	@Test(priority = 2)
	private void BotCreateSuccess() throws InterruptedException, IOException {
		testcase = extentReports.createTest("Check whether the chatbot was created successfully");
		Botlist_Pageclass botcreate = PageFactory.initElements(driver, Botlist_Pageclass.class);
		String createbot = botcreate.botcreate();
		if (createbot.equals("Testbot")) {
			testcase.log(Status.PASS, "Chatbot created successfully");
			assertTrue(true);
		} else {
			testcase.log(Status.FAIL, "Chat bot not created");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\createbotsuccess.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath(
					"C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\createbotsuccess.png");
			assertTrue(false);
		}
//			assertEquals(createbot, "Testbot");
	}

	// Bot list on the list page
//	@Test(priority = 4)
//	private void BotList() throws InterruptedException, IOException {
//		testcase = extentReports.createTest("Check whether the user create chatbot was listed");
//		Botlist_Pageclass botlistpage = PageFactory.initElements(driver, Botlist_Pageclass.class);
//		String listbot = botlistpage.botlist();
//		if (listbot.equals("Testbot")) {
//			testcase.log(Status.PASS, "Chatbot listed successfully");
//			assertTrue(true);
//		} else {
//			testcase.log(Status.FAIL, "Chat bot is not listed");
//			TakesScreenshot screenshot = (TakesScreenshot) driver;
//			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
//			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\botlist.png");
//			FileUtils.copyFile(screenshotAs, file);
//			testcase.addScreenCaptureFromPath(
//					"C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\botlist.png");
//			assertTrue(false);
//		}
////		    assertEquals(listbot, "Testbot");
//	}

	// Txt file synced status
	@Test(priority = 3)
	private void txtfilesync() throws InterruptedException, IOException, AWTException {
		testcase = extentReports.createTest("Check whether the user uploaded TXT file is syncing");
		Botlist_Pageclass textfile = PageFactory.initElements(driver, Botlist_Pageclass.class);
		String textfilesync = textfile.txtfile();
		if (textfilesync.equals("Syncing the files to the bot memory in background. You will receive an email once completed.")) {
			testcase.log(Status.PASS, "Txt file is syncing toast displayed");
			assertTrue(true);
		} else {
			testcase.log(Status.FAIL, "Txt file is syncing toast not displayed");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\Txtfilesync.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\Txtfilesync.png");
			assertTrue(false);
		}
//			assertEquals(txtfile, "Testbot");
	}

	// Txt Content file synced status
	@Test(priority = 4)
	private void txtcontentfilesync() throws InterruptedException, IOException, AWTException {
		testcase = extentReports.createTest("Check whether the user uploaded TXT Content file is syncing");
		Botlist_Pageclass textcontfile = PageFactory.initElements(driver, Botlist_Pageclass.class);
		String textcontentfilesync = textcontfile.txtcontentfile();
		if (textcontentfilesync.equals("Syncing the Text Content to the bot memory in background. You will receive an email once completed.")){
			testcase.log(Status.PASS, "Txt content file is syncing toast displayed");
			assertTrue(true);
		} else {
			testcase.log(Status.FAIL, "Txt content file is syncing toast not displayed");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\Txtcontfilesync.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\Txtcontfilesync.png");
			assertTrue(false);
		}
//			assertEquals(txtcontentfile, "Testbot");
	}
	
	
	// PDF file synced status
		@Test(priority = 5)
		private void pdffilesync() throws InterruptedException, IOException, AWTException {
			testcase = extentReports.createTest("Check whether the user uploaded PDF file is syncing");
			Botlist_Pageclass pdffiles = PageFactory.initElements(driver, Botlist_Pageclass.class);
			String pdffilesync = pdffiles.pdffile();
			if (pdffilesync.equals("Syncing the files to the bot memory in background. You will receive an email once completed.")) {
				testcase.log(Status.PASS, "PDF file is syncing toast displayed");
				assertTrue(true);
			} else {
				testcase.log(Status.FAIL, "PDF file is syncing toast not displayed");
				TakesScreenshot screenshot = (TakesScreenshot) driver;
				File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
				File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\Pdffilesync.png");
				FileUtils.copyFile(screenshotAs, file);
				testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\Pdffilesync.png");
				assertTrue(false);
			}
//				assertEquals(pdffile, "Testbot");
		}
	
	
		// Doc file synced status
				@Test(priority = 6)
				private void docfilesync() throws InterruptedException, IOException, AWTException {
					testcase = extentReports.createTest("Check whether the user uploaded DOC file is syncing");
					Botlist_Pageclass docfiles = PageFactory.initElements(driver, Botlist_Pageclass.class);
					String docfilesync = docfiles.docfile();
					if (docfilesync.equals("Syncing the files to the bot memory in background. You will receive an email once completed.")) {
						testcase.log(Status.PASS, "DOC file is syncing toast displayed");
						assertTrue(true);
					} else {
						testcase.log(Status.FAIL, "DOC file is syncing toast not displayed");
						TakesScreenshot screenshot = (TakesScreenshot) driver;
						File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
						File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\Docfilesync.png");
						FileUtils.copyFile(screenshotAs, file);
						testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\Docfilesync.png");
						assertTrue(false);
					}
//						assertEquals(docfile, "Testbot");
				}
	
				

	// Txt Content file synced status
	@Test(priority = 7)
	private void chatbotspreview() throws InterruptedException, IOException, AWTException {
		testcase = extentReports.createTest("Check whether the user can view the bot replied successfully");
		Botlist_Pageclass chatpreview = PageFactory.initElements(driver, Botlist_Pageclass.class);
		String textchatpreview = chatpreview.chatbotpreview();
		if (textchatpreview.equals("Sorry! I'm not sure what you're saying.")) 
		{
			testcase.log(Status.PASS, "Bot replied successfully");
			assertTrue(true);
		} else {
			testcase.log(Status.FAIL, "Bot doesnot replied");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\botreply.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\botreply.png");
			assertTrue(false);
		}
//				assertEquals(botreply, "Testbot");
	}

}
