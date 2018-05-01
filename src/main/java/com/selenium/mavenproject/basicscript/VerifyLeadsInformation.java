package com.selenium.mavenproject.basicscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

public class VerifyLeadsInformation {
	WebDriver d;
	@Test
	public void testverifyleadsinformation(){
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.get("http://localhost:8888/index.php?action=Login&module=Users");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.findElement(By.xpath(".//*[@id='form']/div/div[2]/input")).sendKeys("admin");
		d.findElement(By.xpath(".//*[@id='form']/div/div[4]/input")).sendKeys("password");
		d.findElement(By.xpath(".//*[@id='submitButton']")).click();
		d.findElement(By.linkText("Leads")).click();
		d.findElement(By.xpath(".//*[@id='row_125']/td[4]/a")).click();
		String fname = d.findElement(By.id("mouseArea_First Name")).getText();
		Assert.assertEquals(fname, "Ms.   swapna");
		
		String cname = d.findElement(By.id("mouseArea_Company")).getText();
		Assert.assertEquals(cname, "  learnbyswapna");
		
		String cmount = d.findElement(By.id("mouseArea_Annual Revenue")).getText();
		Assert.assertEquals(cmount, "  23,452,345");
	}

}
