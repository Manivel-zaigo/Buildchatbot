package com.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.apache.commons.io.FileUtils;
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
import com.aventstack.extentreports.utils.FileUtil;
import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

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
		FileInputStream fileInputStream = new FileInputStream("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\Reusable records\\config.properties");
		properties.load(fileInputStream);
		value = properties.getProperty("url");
		System.out.println(value);
		fileInputStream.close();
		driver.get(value);
		
		extentReports = new ExtentReports();
		extentHtmlReporter = new ExtentHtmlReporter("Login.html");
		extentReports.attachReporter(extentHtmlReporter);
	}

	@AfterClass
	public void quit() {
		driver.quit();
		extentReports.flush();
	}

	// Registration using invalid credentials
	@Test(priority = 1)
	private void RegisterInvalidEmail() throws InterruptedException, IOException {
		testcase = extentReports.createTest("On Register page, Check whether the invalid email error message is displayed");
		Login_Pageclass credsinvalid = PageFactory.initElements(driver, Login_Pageclass.class);
		String invalidmail = credsinvalid.RegEmailinvalid();
//		Thread.sleep(10000);
		if (invalidmail.equals("Please enter a valid email address.")) {
			testcase.log(Status.PASS, "Invalid email error message is displayed");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Error message is not displayed");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\reginvalidemail.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\reginvalidemail.png");
			assertTrue(false);
		}
//		assertEquals(invalidmail, "Please enter a valid email address.");
	}
	

	// Register validation using Empty fields
	@Test(priority = 2)
	private void RegisterPasswordEmpty() throws InterruptedException, IOException {
		testcase = extentReports.createTest("On Register page, Check whether the invalid password error message is displayed");
		Login_Pageclass pwdempty = PageFactory.initElements(driver, Login_Pageclass.class);
		String emptypwd = pwdempty.RegemptyPwd();
		if (emptypwd.equals ("Please Enter valid Password.")) {
			testcase.log(Status.PASS, "Invalid password error message is displayed");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Error message is not displayed");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\pwdempty.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\pwdempty.png");
			assertTrue(false);
		}
//		assertEquals(emptypwd, "Please Enter valid Password.");
	}
	

	// Registration using valid credentials
	@Test(priority = 3)
	private void RegisterSuccess() throws InterruptedException, IOException {
		testcase = extentReports.createTest("Check whether the user registration success message is displayed");
		Login_Pageclass Successreg = PageFactory.initElements(driver, Login_Pageclass.class);
		String Regsuccess = Successreg.RegisterSuccess();
		if (Regsuccess.equals ( "User Created Successfully. Please Check Email For Verification Link.")) {
			testcase.log(Status.PASS, "Register success message is displayed");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Success message is not shown");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\registersuccess.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\registersuccess.png");
			assertTrue(false);
		}
//		assertEquals(Regsuccess, "User Created Successfully. Please Check Email For Verification Link.");
	}
	

	// Login Validation invalid email
	@Test(priority = 4)
	private void LoginInvalidEmail() throws InterruptedException, IOException {
		testcase = extentReports.createTest("On Login page, Check whether the invalid email error message is displayed");
		Login_Pageclass login2 = PageFactory.initElements(driver, Login_Pageclass.class);
		String EmailInvalid = login2.invalidemail();
		if (EmailInvalid.equals ("Please enter a valid email address.")) {
			testcase.log(Status.PASS, "Invalid email error message is displayed");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Error message is not displayed");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\logininvalidmail.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\logininvalidmail.png");
			assertTrue(false);
		}
//		assertEquals(EmailInvalid, "Please enter a valid email address.");
	}
	

	// Login validation invalid password
	@Test(priority = 5)
	private void LoginInvalidcredentials() throws InterruptedException, IOException {
		testcase = extentReports.createTest("On login page, check whether the invalid credentials error message is displayed");
		Login_Pageclass login3 = PageFactory.initElements(driver, Login_Pageclass.class);
		String Pwdwrong = login3.invalidpwd();
		if (Pwdwrong.equals ( "Invalid Credentials.")) {
			testcase.log(Status.PASS, "Invalid crendtials message is displayed");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Error message is not displayed");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\invalidcreds.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\invalidcreds.png");
			assertTrue(false);
		}
//		assertEquals(Pwdwrong, "Invalid Credentials.");
	}
	

	// Login with valid credentials
	@Test(priority = 6)
	private void LoginSuccess() throws InterruptedException, IOException {
		testcase = extentReports.createTest("Check whether the user loggedin success message is displayed");
		Login_Pageclass login = PageFactory.initElements(driver, Login_Pageclass.class);
		String Dashboard = login.setcredentials();
		if (Dashboard.equals ( "Create Your Chatbot")) {
			testcase.log(Status.PASS, "Login success message is shown");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Login success message is not shown");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\loginsuccess.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\loginsuccess.png");
			assertTrue(false);
		}
//		assertEquals(Dashboard, "Create Your Chatbot");
	}
	

	// Bot creation empty validation
	@Test(priority = 7)
	private void BotEmptyFieldValidation() throws InterruptedException, IOException {
		testcase = extentReports.createTest("On bot creation page, Check whether the field empty validation message is displayed");
		Login_Pageclass boterror = PageFactory.initElements(driver, Login_Pageclass.class);
		String emptybotfield = boterror.botempty();
		if (emptybotfield.equals ("Please Enter ChatBot Name.")) {
			testcase.log(Status.PASS, "Field empty message is shown");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Field empty message is not shown");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\emptyfield.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\emptyfield.png");
			assertTrue(false);
		}
//		assertEquals(emptybotfield, "Please Enter ChatBot Name.");
	}
	

	// Bot creation with valid input
	@Test(priority = 8)
	private void BotCreateSuccess() throws InterruptedException, IOException {
		testcase = extentReports.createTest("Check whether the chatbot was created successfully");
		Login_Pageclass botvalid = PageFactory.initElements(driver, Login_Pageclass.class);
		String createbot = botvalid.botcreate();
		if (createbot.equals ("Testbot")) {
			testcase.log(Status.PASS, "Chatbot created successfully");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Chat bot not created");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\createbotsuccess.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\createbotsuccess.png");
			assertTrue(false);
		}
//		assertEquals(createbot, "Testbot");
	} 
	
	// Bot update empty validation
	@Test(priority = 9)
	private void BotUpdateEmptyValidation() throws InterruptedException, IOException {
		testcase = extentReports.createTest("On bot edit page, Check whether the field empty message is displayed");
		Login_Pageclass boterror = PageFactory.initElements(driver, Login_Pageclass.class);
		String emptybotfield = boterror.boteditempty();
		if (emptybotfield.equals ("This field may not be blank.")) {
			testcase.log(Status.PASS, "Field empty error is shown");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Field empty error is not shown");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\botemptyfield.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\botemptyfield.png");
			assertTrue(false);
		}
	}
	
	//Bot update with valid input
	@Test(priority = 10)
	private void BotUpdateSuccess() throws InterruptedException, IOException {
		testcase = extentReports.createTest("Check whether the chatbot was updated successfully");
		Login_Pageclass botvalid = PageFactory.initElements(driver, Login_Pageclass.class);
		String updatebot = botvalid.botupdate();
		if (updatebot.equals ("Samplebot")) {
			testcase.log(Status.PASS, "Chatbot updated successfully");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Chat bot not updated");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\updatedbotsuccess.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\updatedbotsuccess.png");
			assertTrue(false);
		}
	}
	
	//Bot delete
	@Test(priority = 11)
	private void BotDelete() throws InterruptedException, IOException {
		testcase = extentReports.createTest("Check whether the chatbot was Deleted successfully");
		Login_Pageclass deletebot = PageFactory.initElements(driver, Login_Pageclass.class);
		String Deletebot = deletebot.botdelete();
		if (Deletebot.equals ("Create Your Chatbot")) {
			testcase.log(Status.PASS, "Chatbot deleted successfully");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Chatbot not deleted");
			TakesScreenshot screenshot = (TakesScreenshot) driver;
			File screenshotAs = screenshot.getScreenshotAs(OutputType.FILE);
			File file = new File("C:\\Users\\Admin\\eclipse-workspace\\Build_Chatbot\\botemptyfield.png");
			FileUtils.copyFile(screenshotAs, file);
			testcase.addScreenCaptureFromPath("C:\\\\Users\\\\Admin\\\\eclipse-workspace\\\\Build_Chatbot\\\\botemptyfield.png");
			assertTrue(false);
		}
	}

}
