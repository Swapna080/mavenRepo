package com.selenium.mavenproject.basicscript;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class Howtoreadtablecolumndata {
	WebDriver d;
	@Test
	public void testhowtoreadtablecolumndata()
	{
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\drivers\\chromedriver.exe");
		d=new ChromeDriver();
		d.get("http://localhost:8888/index.php?action=Login&module=Users");
		d.manage().window().maximize();
		d.manage().timeouts().implicitlyWait(60,TimeUnit.SECONDS);
		d.findElement(By.xpath(".//*[@id='form']/div/div[2]/input")).sendKeys("admin");
		d.findElement(By.xpath(".//*[@id='form']/div/div[4]/input")).sendKeys("password");
		d.findElement(By.xpath(".//*[@id='submitButton']")).click();
		d.findElement(By.linkText("Leads")).click();
		int rowcount=d.findElements(By.xpath(".//*[@id='massdelete']/table/tbody/tr/td/div/table/tbody/tr")).size();
		int columncount	=d.findElements(By.xpath(".//*[@id='massdelete']/table/tbody/tr/td/div/table/tbody/tr[1]/td")).size();
		System.out.println(rowcount+"  "+columncount);
		
		for(int i=3;i<=rowcount;i++){
			for(int j=2;j<columncount;j++){
				String fpath=".//*[@id='massdelete']/table/tbody/tr/td/div/table/tbody/tr[";
						
				String mpart="]/td[";
				String lpart="]";
				String calldata=d.findElement(By.xpath(fpath+i+mpart+j+lpart)).getText();
				System.out.print(calldata+" | ");
			}
			System.out.println();
		}

	}

}
