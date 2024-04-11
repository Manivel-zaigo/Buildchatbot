package com.test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.bcb.pageobjectclass.Login_Pageclass;
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
	private void RegisterInvalidEmail() throws InterruptedException {
		testcase = extentReports.createTest("On Register page, Check whether the invalid email error message is displayed");
		Login_Pageclass credsinvalid = PageFactory.initElements(driver, Login_Pageclass.class);
		String invalidmail = credsinvalid.RegEmailinvalid();
//		Thread.sleep(10000);
		if (invalidmail.equals("Please enter a valid email address.")) {
			testcase.log(Status.PASS, "Invalid email error message is displayed");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Error message is not displayed");
			assertTrue(false);
		}
//		assertEquals(invalidmail, "Please enter a valid email address.");
	}
	

	// Register validation using Empty fields
	@Test(priority = 2)
	private void RegisterPasswordEmpty() throws InterruptedException {
		testcase = extentReports.createTest("On Register page, Check whether the invalid password error message is displayed");
		Login_Pageclass pwdempty = PageFactory.initElements(driver, Login_Pageclass.class);
		String emptypwd = pwdempty.RegemptyPwd();
		if (emptypwd.equals ("Please Enter valid Password.")) {
			testcase.log(Status.PASS, "Invalid password error message is displayed");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Error message is not displayed");
			assertTrue(false);
		}
//		assertEquals(emptypwd, "Please Enter valid Password.");
	}
	

	// Registration using valid credentials
	@Test(priority = 3)
	private void RegisterSuccess() throws InterruptedException {
		testcase = extentReports.createTest("Check whether the user registration success message is displayed");
		Login_Pageclass Successreg = PageFactory.initElements(driver, Login_Pageclass.class);
		String Regsuccess = Successreg.RegisterSuccess();
		if (Regsuccess.equals ( "User Created Successfully. Please Check Email For Verification Link.")) {
			testcase.log(Status.PASS, "Register success message is displayed");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Success message is not shown");
			assertTrue(false);
		}
//		assertEquals(Regsuccess, "User Created Successfully. Please Check Email For Verification Link.");
	}
	

	// Login Validation invalid email
	@Test(priority = 4)
	private void LoginInvalidEmail() throws InterruptedException {
		testcase = extentReports.createTest("On Login page, Check whether the invalid email error message is displayed");
		Login_Pageclass login2 = PageFactory.initElements(driver, Login_Pageclass.class);
		String EmailInvalid = login2.invalidemail();
		if (EmailInvalid.equals ("Please enter a valid email address.")) {
			testcase.log(Status.PASS, "Invalid email error message is displayed");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Error message is not displayed");
			assertTrue(false);
		}
//		assertEquals(EmailInvalid, "Please enter a valid email address.");
	}
	

	// Login validation invalid password
	@Test(priority = 5)
	private void LoginInvalidcredentials() throws InterruptedException {
		testcase = extentReports.createTest("On login page, check whether the invalid credentials error message is displayed");
		Login_Pageclass login3 = PageFactory.initElements(driver, Login_Pageclass.class);
		String Pwdwrong = login3.invalidpwd();
		if (Pwdwrong.equals ( "Invalid Credentials.")) {
			testcase.log(Status.PASS, "Invalid crendtials message is displayed");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Error message is not displayed");
			assertTrue(false);
		}
//		assertEquals(Pwdwrong, "Invalid Credentials.");
	}
	

	// Login with valid credentials
	@Test(priority = 6)
	private void LoginSuccess() throws InterruptedException {
		testcase = extentReports.createTest("Check whether the user loggedin success message is displayed");
		Login_Pageclass login = PageFactory.initElements(driver, Login_Pageclass.class);
		String Dashboard = login.setcredentials();
		if (Dashboard.equals ( "Create Your Chatbot")) {
			testcase.log(Status.PASS, "Login success message is shown");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Login success message is not shown");
			assertTrue(false);
		}
//		assertEquals(Dashboard, "Create Your Chatbot");
	}
	

	// Bot creation empty validation
	@Test(priority = 7)
	private void BotEmptyFieldValidation() throws InterruptedException {
		testcase = extentReports.createTest("On bot creation page, Check whether the field empty validation message is displayed");
		Login_Pageclass boterror = PageFactory.initElements(driver, Login_Pageclass.class);
		String emptybotfield = boterror.botempty();
		if (emptybotfield.equals ("Please Enter ChatBot Name.")) {
			testcase.log(Status.PASS, "Field empty message is shown");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Field empty message is not shown");
			assertTrue(false);
		}
//		assertEquals(emptybotfield, "Please Enter ChatBot Name.");
	}
	

	// Bot creation with valid input
	@Test(priority = 8)
	private void BotCreateSuccess() throws InterruptedException {
		testcase = extentReports.createTest("Check whether the chatbot was created successfully");
		Login_Pageclass botvalid = PageFactory.initElements(driver, Login_Pageclass.class);
		String createbot = botvalid.botcreate();
		if (createbot.equals ("Testbot")) {
			testcase.log(Status.PASS, "Chatbot created successfully");
			assertTrue(true);
		}else {
			testcase.log(Status.FAIL, "Created bot is not shown in the list");
			assertTrue(false);
		}
//		assertEquals(createbot, "Testbots");
	}

}
