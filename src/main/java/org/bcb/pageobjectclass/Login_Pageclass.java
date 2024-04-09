package org.bcb.pageobjectclass;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;
import java.util.Random;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.github.dockerjava.api.model.Driver;

public class Login_Pageclass {

	Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000);

	WebDriver driver;
	WebDriverWait wait;

	public Login_Pageclass(WebDriver driver) {
		this.driver = driver;
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
	}

	// User Registeration
	By Loginpage = By.xpath("//*[@id='masthead']/div/div/div/div[3]/div/span[2]/a/button");
	By Registerlink = By.xpath("//*[@id='page']/section/div[1]/div/div/div/div/form/div[6]/p/a");
	By Registerpage = By.xpath("//*[@id='page']/section/div[1]/div/div/div/div/h2");
	By RegEmail = By.xpath("//*[@id='email']");
	By RegPassword = By.xpath("//*[@id='password']");
	By Registerbtn = By.xpath("//*[@id='registersubmit']");
	By Registersuccess = By.xpath("//*[@id='verification_success_msg']");
	By Regsuccessokbtn = By.xpath("//*[@id='verificationsuccessok']");
	By Loginlink = By.xpath("//*[@id='page']/section/div[1]/div/div/div/div/form/div[5]/p/a");

	// Invalids
	By RegInvalidemail = By.xpath("//*[text()='Please enter a valid email address.']");
	By Pwdempty = By.xpath("//*[text()='Please Enter valid Password.']");

	// Login path
	By Email = By.xpath("//*[@id='email']");
	By Password = By.xpath("//*[@id='password']");
	By Login = By.xpath("//*[@id='loginsubmit']");
	By Dashboard = By.xpath("//*[contains(text(),'Create Your Chatbot')]");

	// Invalid
	By Invalidemail = By.xpath("//*[text()='Please enter a valid email address.']");
	By Wrongpwd = By.xpath("//*[text()='Invalid Credentials.']");

	// Bot creation
	By botfield = By.xpath("//*[@id='chatName']");
	By createbotbtn = By.xpath("//*[@id='createbot']");
	By emptyfield = By.xpath("//*[text()='Please Enter ChatBot Name.']");
	By bothome = By.xpath("//*[@id='textInputP']");

	// Inputs removed from the fields
	private void clearField(By element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).clear();
	}

	// Click the elements
	private void click(By element) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).click();
	}

	private void EnterText(By element, String value) {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).clear();
		wait.until(ExpectedConditions.visibilityOfElementLocated(element)).sendKeys(value);

	}

	// Invalid email in Registeration
	public String RegEmailinvalid() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		this.click(Registerlink);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Registerpage));
		this.EnterText(RegEmail, "jonqa@@gmail.com");
		this.EnterText(RegPassword, "Password@123");
		this.click(Registerbtn);
		wait.until(ExpectedConditions.visibilityOfElementLocated(RegInvalidemail));
		String error1 = driver.findElement(RegInvalidemail).getText();
		this.clearField(RegEmail);
		this.clearField(RegPassword);
		return error1;

	}

	// Password is empty in Registration
	public String RegemptyPwd() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get(driver.getCurrentUrl());
		this.EnterText(RegEmail, "");
		this.EnterText(RegPassword, "");
		this.click(Registerbtn);
		wait.until(ExpectedConditions.presenceOfElementLocated(Pwdempty));
		String error1 = driver.findElement(Pwdempty).getText();
		return error1;
	}

	public Boolean conditionChecking1() {
		Boolean text = false;
		try {
			wait = new WebDriverWait(driver, Duration.ofSeconds(20));
			text = wait.until(ExpectedConditions.visibilityOfElementLocated(Registersuccess)).isEnabled();
		} catch (Exception e) {
			return text;
		}
		return text;
	}

	// Register success with valid inputs
	public String RegisterSuccess() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		this.EnterText(RegEmail, "John" + randomInt + "@gmail.com");
		this.EnterText(RegPassword, "Password@123");
		this.click(Registerbtn);
		boolean condition = false;
		if (!this.conditionChecking1()) {
			do {
				this.click(Registerbtn);
				if (this.conditionChecking1()) {
					condition = false;
				}
			} while (condition);
		}
		String dashboard = driver.findElement(Registersuccess).getText();
		return dashboard;
	}

	// Login success with valid inputs
	public String setcredentials() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get(driver.getCurrentUrl());
		this.EnterText(Email, "joseph@mailinator.com");
		this.EnterText(Password, "Password@123");
		this.click(Login);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Dashboard));
		String dashboard = driver.findElement(Dashboard).getText();
		return dashboard;
	}

	// Invalid email in Login page
	public String invalidemail() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		driver.get("https://beta.buildchatbot.ai/login/");
		this.EnterText(Email, "joseph@@mailinator.com");
		this.EnterText(Password, "Password@123");
		this.click(Login);
		wait.until(ExpectedConditions.visibilityOfElementLocated(Invalidemail));
		String errmsg1 = driver.findElement(Invalidemail).getText();
		this.clearField(Email);
		this.clearField(Password);
		return errmsg1;
	}

	// Invalid password in login page
	public String invalidpwd() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(50));
		this.EnterText(Email, "joseph@mailinator.com");
		this.EnterText(Password, "Pass");
		this.click(Login);

		boolean condition = false;
		if (!this.conditionChecking1()) {
			do {
				this.click(Login);
				if (this.conditionChecking1()) {
					condition = false;
				}

			} while (condition);
		}

		String errmsg2 = driver.findElement(Wrongpwd).getText();
		this.clearField(Email);
		this.clearField(Password);
		return errmsg2;
	}

	// Bot field empty validation
	public String botempty() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.EnterText(botfield, "");
		this.click(createbotbtn);
		wait.until(ExpectedConditions.visibilityOfElementLocated(emptyfield));
		String botempty = driver.findElement(emptyfield).getText();
		return botempty;
	}

	// Bot creation success
	public String botcreate() throws InterruptedException {
		wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		this.EnterText(botfield, "Testbot");
		this.click(createbotbtn);

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

}
