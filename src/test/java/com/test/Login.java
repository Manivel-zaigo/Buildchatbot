package com.test;

import static org.testng.Assert.assertEquals;

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
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Login {

	WebDriver driver;
	String value;
	
//	ExtentReports extentReports;
//	ExtentHtmlReporter extentHtmlReporter;
//	ExtentTest extentTest;
	
	

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
		
//		extentReports = new ExtentReports();
//		extentHtmlReporter = new ExtentHtmlReporter("Login.html");
//		extentReports.attachReporter(extentHtmlReporter);

	}

	@AfterClass
	public void quit() {
		driver.quit();

	}

	// Registration using invalid credentials
	@Test(priority = 1)
	private void RegisterInvalidEmail() throws InterruptedException {
		Login_Pageclass credsinvalid = PageFactory.initElements(driver, Login_Pageclass.class);
		String invalidmail = credsinvalid.RegEmailinvalid();
		Thread.sleep(10000);
		assertEquals(invalidmail, "Please enter a valid email address.");
	}

	// Register validation using Empty fields
	@Test(priority = 2)
	private void RegisterPasswordEmpty() throws InterruptedException {
		Login_Pageclass pwdempty = PageFactory.initElements(driver, Login_Pageclass.class);
		String emptypwd = pwdempty.RegemptyPwd();
		assertEquals(emptypwd, "Please Enter valid Password.");
	}

	// Registration using valid credentials
	@Test(priority = 3)
	private void RegisterSuccess() throws InterruptedException {
		Login_Pageclass Successreg = PageFactory.initElements(driver, Login_Pageclass.class);
		String Regsuccess = Successreg.RegisterSuccess();
		assertEquals(Regsuccess, "User Created Successfully. Please Check Email For Verification Link.");
	}

	// Login Validation invalid email
	@Test(priority = 4)
	private void LoginInvalidEmail() throws InterruptedException {
		Login_Pageclass login2 = PageFactory.initElements(driver, Login_Pageclass.class);
		String EmailInvalid = login2.invalidemail();
		assertEquals(EmailInvalid, "Please enter a valid email address.");
	}

	// Login validation invalid password
	@Test(priority = 5)
	private void LoginInvalidcredentials() throws InterruptedException {
		Login_Pageclass login3 = PageFactory.initElements(driver, Login_Pageclass.class);
		String Pwdwrong = login3.invalidpwd();
		assertEquals(Pwdwrong, "Invalid Credentials.");
	}

	// Login with valid credentials
	@Test(priority = 6)
	private void LoginSuccess() throws InterruptedException {
		Login_Pageclass login = PageFactory.initElements(driver, Login_Pageclass.class);
		String Dashboard = login.setcredentials();
		assertEquals(Dashboard, "Create Your Chatbot");

	}

	// Bot creation empty validation
	@Test(priority = 7)
	private void BotEmptyFieldValidation() throws InterruptedException {
		Login_Pageclass boterror = PageFactory.initElements(driver, Login_Pageclass.class);
		String emptybotfield = boterror.botempty();
		assertEquals(emptybotfield, "Please Enter ChatBot Name.");
	}

	// Bot creation with valid input
	@Test(priority = 8)
	private void BotCreateSucess() throws InterruptedException {
		Login_Pageclass botvalid = PageFactory.initElements(driver, Login_Pageclass.class);
		String createbot = botvalid.botcreate();
		assertEquals(createbot, "Testbots");
	}

}
