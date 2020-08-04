package com.qa.hargreavessitetest;

import java.util.logging.Logger;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


//Using the FTSE 100 market overview, 
//find the largest “riser and faller” for the latest stock price index.

public class HargreavesSiteTest {
	
	private WebDriver driver;

	@Before
	public void init() {
		System.setProperty("webdriver.chrome.driver",
				"C://Users//shiva//Documents//AA_PROJECTS//DG_seleniumProjects//seleniumTest1//src//test//resources//chromedriver.exe");
		driver = new ChromeDriver();
		// driver.manage().window().fullscreen();

	}

	WebElement target;
	private final static Logger LOGGER = Logger.getLogger(HargreavesSiteTest.class.getName());
	String logMessage;
	@Test
	public void test1() throws InterruptedException {
		driver.get("https://www.hl.co.uk/shares/stock-market-summary/ftse-100");
		target = (new WebDriverWait(driver, 10))
				.until(ExpectedConditions.presenceOfElementLocated(By.id("acceptCookie")));
		target = driver.findElement(By.id("acceptCookie"));
		target.click();
		LOGGER.info("Clicked cookie");
		Thread.sleep(9000); 
		
		target = driver.findElement(By.xpath("/html/body/main/div/div/div[3]/div/div[4]/div[1]/ul/li[2]"));
		target.click();
		Thread.sleep(12000); 
		logMessage  = driver.findElement(By.xpath("/html/body/main/div/div/div[3]/div[4]/div[1]/div[2]/table/tbody/tr[1]/td[2]/a")).getText();
		LOGGER.info("Found the highest riser: " + logMessage);
		Thread.sleep(2000);
		target = driver.findElement(By.xpath("/html/body/main/div/div/div[3]/div[4]/div[1]/div[1]/ul/li[3]/a"));
		target.click();
		Thread.sleep(2000);
		logMessage = driver.findElement(By.xpath("/html/body/main/div/div/div[3]/div[4]/div[1]/div[2]/table/tbody/tr[1]/td[2]/a")).getText();
		LOGGER.info("Found the biggest loser: " + logMessage);
	}
	

	
	@After
	public void tearDown() {
		driver.close();
	}


}
