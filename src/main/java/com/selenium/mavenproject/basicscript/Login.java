package com.selenium.mavenproject.basicscript;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.Test;

public class Login {
	WebDriver d;
	@Test
	public void testlogin(){
		//System.out.println(System.getProperty(""));

		//System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir")+"\\drivers\\geckodriver.exe");
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.get("http://localhost:8888/index.php?action=Login&module=Users");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.findElement(By.xpath(".//*[@id='form']/div/div[2]/input")).sendKeys("admin");
		d.findElement(By.xpath(".//*[@id='form']/div/div[4]/input")).sendKeys("password");
		d.findElement(By.xpath(".//*[@id='submitButton']")).click();
		//task-1 statement
	}

}
