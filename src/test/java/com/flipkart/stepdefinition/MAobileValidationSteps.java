 package com.flipkart.stepdefinition;

import java.util.Set;
import java.util.concurrent.TimeUnit;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import io.github.bonigarcia.wdm.WebDriverManager;

public class MAobileValidationSteps {
	static WebDriver driver;
	static long  startTime  ;
	static String name1;
	@BeforeClass
	public  static void BeforeClass() {
		
	WebDriverManager.firefoxdriver().setup();
	 driver  = new FirefoxDriver();
	driver.get("http://www.flipkart.com/");
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
	}
	@AfterClass
public static void afterClass() {
driver.quit();

	}
	@BeforeMethod
	public void beforeScript() {
	long startTime=	System.currentTimeMillis();
	}
	@AfterMethod
	public void afterscript() {
		long endTime=	System.currentTimeMillis();
		System.out.println("time taken is :"+(endTime -startTime));
	}
	
	@Test
	public void method1() {
		try {
			WebElement s =driver.findElement(By.xpath("//button[text()='✕']"));
			s.click();
		}catch (Throwable e) {
	
		}
		
	}

	@Test
	public void method2() {
		
		WebElement search=driver.findElement(By.name("q"));
		search.sendKeys("realme",Keys.ENTER);
	}
	
	
	
	@Test
	public void method3() {
		
		WebElement mobliename =driver.findElement(By.xpath("(//div[contains(text(),'realme')])[1]"));
name1=	mobliename.getText();
System.out.println(name1);
mobliename.click();
	}
	@Test
	public void method4() {
		
		String parent  =driver.getWindowHandle();
	Set <String>	children =driver.getWindowHandles();
	for (String x : children) {
		if(!parent.equals(x)) {
			driver.switchTo().window(x);
		}
		
		
	}
		
	}
	@Test
	public void method5() {
	WebElement 	mobilename2=driver.findElement(By.xpath("//span[contains(text(),'realme')]"));
	
	String name2 =mobilename2.getText();
	System.out.println(name2);
	
	Assert.assertEquals(name1, name2);
	
	}
	
	}
	
	
	

