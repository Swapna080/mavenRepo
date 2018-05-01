package com.selenium.mavenproject.basicscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class Createleads {
	WebDriver d;
	@Test
	public void testcreateleads(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.get("http://localhost:8888/index.php?action=Login&module=Users");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.findElement(By.xpath(".//*[@id='form']/div/div[2]/input")).sendKeys("admin");
		d.findElement(By.xpath(".//*[@id='form']/div/div[4]/input")).sendKeys("password");
		d.findElement(By.xpath(".//*[@id='submitButton']")).click();
		d.findElement(By.linkText("Leads")).click();
		d.findElement(By.xpath("//img[@title='Create Lead...']")).click();
		Select s=new Select(d.findElement(By.xpath("//Select[@name='salutationtype']")));
		s.selectByIndex(2);
		d.findElement(By.xpath("//input[@name='firstname']")).sendKeys("swapna");
		d.findElement(By.xpath("//input[@name='lastname']")).sendKeys("panda");
		d.findElement(By.xpath("//input[@name='company']")).sendKeys("learnbyswapna");
		
		d.findElement(By.id("designation")).sendKeys("youtube");
		s=new Select(d.findElement(By.xpath("//select[@name='leadsource']")));
		s.selectByVisibleText("Employee");
		s=new Select(d.findElement(By.xpath("//select[@name='industry']")));
		s.selectByVisibleText("Chemicals");
		d.findElement(By.name("annualrevenue")).sendKeys("23452345");
		d.findElement(By.xpath(".//*[@id='noofemployees']")).sendKeys("100");
		d.findElement(By.xpath(".//*[@id='secondaryemail']")).sendKeys("abc@gmail.com");
		d.findElement(By.xpath("//textarea[@name='lane']")).sendKeys("odisha");
		d.findElement(By.xpath(".//*[@id='code']")).sendKeys("23456");
		d.findElement(By.xpath(".//*[@id='country']")).sendKeys("india");
		d.findElement(By.xpath("//textarea[@name='description']")).sendKeys("this is automation");
		d.findElement(By.xpath(".//*[@id='phone']")).sendKeys("9876654321");
		d.findElement(By.xpath(".//*[@id='mobile']")).sendKeys("1234567890");
		d.findElement(By.xpath(".//*[@id='fax']")).sendKeys("23456");
		d.findElement(By.xpath(".//*[@id='email']")).sendKeys("sdfghj@gmail.com");
		s=new Select(d.findElement(By.name("leadstatus")));
		s.selectByVisibleText("Contact in Future");
		d.findElement(By.xpath("//input[@name='assigntype' and @value='T']")).click();
		d.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
	}

}
