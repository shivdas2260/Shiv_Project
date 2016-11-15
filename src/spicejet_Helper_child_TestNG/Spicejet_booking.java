package spicejet_Helper_child_TestNG;

import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

public class Spicejet_booking {
	public WebDriver driver;
	
  @Test()
  public void Booking() throws Exception {
	  driver.findElement(By.linkText("Flight")).click();
	  Thread.sleep(3000);
	  driver.findElement(By.id("ctl00_mainContent_rbtnl_Trip_1")).click();
	  
	  driver.findElement(By.name("ctl00_mainContent_ddl_originStation1_CTXT")).click();
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Hyderabad (HYD)")).click();
	 // driver.manage().timeouts().implicitlyWait(50, TimeUnit.SECONDS);
	  Thread.sleep(1000);
	  driver.findElement(By.linkText("Mumbai (BOM)")).click();
	  driver.findElement(By.id("ctl00_mainContent_txt_Fromdate")).click();
	  driver.findElement(By.linkText("31")).click();
  }
  
  @Test
  public void Booking1() throws Exception{
	new Select(driver.findElement(By.name("ctl00$mainContent$ddl_Adult"))).selectByValue("2");
	Thread.sleep(1000);
	new Select(driver.findElement(By.name("ctl00$mainContent$ddl_Child"))).selectByValue("0");
	Thread.sleep(1000);
	new Select(driver.findElement(By.name("ctl00$mainContent$ddl_Infant"))).selectByIndex(0);
	Thread.sleep(1000);
	driver.findElement(By.name("ctl00$mainContent$btn_FindFlights")).click();
	Thread.sleep(3000); 
  }
	@Test(description="currency convertor")
	public void booking2() throws Exception {
	driver.findElement(By.xpath(".//*[@id='popUpConverter']")).click();
	Set<String> window=driver.getWindowHandles();
	System.out.println(window);
	Object w[]=window.toArray();
	driver.switchTo().window(w[1].toString());
	Thread.sleep(3000);
	new Select(driver.findElement(By.xpath(".//*[@id='CurrencyConverterCurrencyConverterView_DropDownListBaseCurrency']"))).selectByIndex(2);
	Thread.sleep(1000);
	new Select(driver.findElement(By.xpath(".//*[@id='CurrencyConverterCurrencyConverterView_DropDownListConversionCurrency']"))).selectByIndex(2);
	Thread.sleep(1000);
	driver.findElement(By.xpath(".//*[@id='CurrencyConverterCurrencyConverterView_TextBoxAmount']")).sendKeys("200");
	driver.findElement(By.id("CurrencyConverterCurrencyConverterView")).click();
	driver.findElement(By.id("ButtonCloseWindow")).click();
	driver.switchTo().window(w[0].toString());
  }
  
  
  @BeforeTest
  public void beforeTest() {
	  System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver.exe");
		driver=new ChromeDriver();
	driver.get("http://spicejet.com");
	 driver.manage().window().maximize();
  }

  @AfterTest
  public void afterTest() {
	//  driver.quit();
  }

}
