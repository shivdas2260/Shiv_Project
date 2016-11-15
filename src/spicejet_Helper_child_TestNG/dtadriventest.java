package spicejet_Helper_child_TestNG;

import java.io.FileInputStream;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import org.testng.annotations.Test;

public class dtadriventest {
	public WebDriver driver;
	
  @Test
  public void test() throws Exception {
	  FileInputStream fi=new FileInputStream(".\\Testdata\\Spicejet.xls");
	  Workbook w=Workbook.getWorkbook(fi);
	  Sheet s=w.getSheet("test1");
	 for (int i = 0; i <= s.getRows(); i++) {
		 Cell c=s.getCell(i,1);
		 String data=c.getContents();
		 System.out.println(data);	
	}

    System.out.println(s.getCell(1, 1).getContents());
	Cell c=s.getCell(1, 1);
	String data=c.getContents();
	System.out.println(data);
	
	  
		    }
}