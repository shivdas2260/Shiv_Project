package com.spicejet;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Driverscript_SpiceJet {
	public WebDriver driver;
	public String str;
  @Test
  public void test() throws Exception {
	  FileInputStream fi=new FileInputStream(".\\Testdata\\Spicejet.xls");
	  Workbook w=Workbook.getWorkbook(fi);
	  Sheet s=w.getSheet("test1");
	  for(int c=3; c<s.getColumns(); c++) {
		  for (int i = 1; i < s.getRows(); i++) {
		  	try{
		  if(s.getCell(2, i).getContents().equalsIgnoreCase("dropdown"))
		  {
		  new Select(driver.findElement(By.name(s.getCell(0, i).getContents()))).selectByVisibleText(s.getCell(c, i).getContents());		
		  }
		  else if(s.getCell(2, i).getContents().equalsIgnoreCase("textbox"))
		  {
		  driver.findElement(By.name(s.getCell(0, i).getContents())).sendKeys(s.getCell(c, i).getContents());	 
		  }
		  else if(s.getCell(2, i).getContents().equalsIgnoreCase("button")
		  		||s.getCell(2, i).getContents().equalsIgnoreCase("radiobutton")
		  		||s.getCell(2, i).getContents().equalsIgnoreCase("checkbox"))
		  {
		  driver.findElement(By.xpath(s.getCell(0, i).getContents())).click();
		  Thread.sleep(1000);
		  }
		  else if(s.getCell(2, i).getContents().equalsIgnoreCase("alert"))
		  {
		  if(s.getCell(c, i).getContents().equalsIgnoreCase("ok"))
		  {
		  driver.switchTo().alert().accept();
		  }else{
		  driver.switchTo().alert().dismiss();
		  }
		  }
		  else if(s.getCell(2, i).getContents().equalsIgnoreCase("link"))
		  {
		  driver.findElement(By.linkText(s.getCell(0, i).getContents())).click();
		  }
		  else if(s.getCell(2, i).getContents().equalsIgnoreCase("url"))
		  {
		  driver.get(s.getCell(0, i).getContents());
		  }
		  str="Pass";
		  }catch(Exception e){str="Fail";}
		  }
		  }
		    }

  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver.exe");
	  driver=new ChromeDriver();
	  driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
  }

}
