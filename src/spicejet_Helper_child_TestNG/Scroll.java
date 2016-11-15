package spicejet_Helper_child_TestNG;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Scroll {
	

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver;
		System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver.exe");
		driver=new ChromeDriver();
		 driver.get("http://selenium4testing.com");
		 driver.manage().window().maximize();
		 JavascriptExecutor jsx=( JavascriptExecutor)driver;
		 
		 jsx.executeScript("window.scrollBy(0,4500)","");
		 Thread.sleep(3000);
		 jsx.executeScript("window.scrollBy(6000,0)", "");

	}

}
