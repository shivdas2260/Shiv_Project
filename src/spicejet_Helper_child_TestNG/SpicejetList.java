package spicejet_Helper_child_TestNG;


import java.net.HttpURLConnection;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;



public class SpicejetList {
 public static void main(String[] args)  {
	 WebDriver driver;
	 driver=new FirefoxDriver();
	 //System.setProperty("webdriver.chrome.driver", "D:\\library\\chromedriver.exe");
	//  driver=new ChromeDriver();
	  driver.get("http://spicejet.com");
	  driver.manage().window().maximize();
	  driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	  List<WebElement> link=driver.findElements(By.tagName("a"));
	  System.out.println("totallinks are: "+ link.size());
	  for (int i = 0; i < link.size(); i++) {
		  WebElement element=link.get(i);
		  String url=element.getAttribute("href");
		  T02(url);
		
	  }		
	}
	 
 
 
  public static void T02(String LinksUrl) {
	  try{  

	  URL url=new URL(LinksUrl);
	  
	  HttpURLConnection httpurlconnection=(HttpURLConnection)url.openConnection();
	  httpurlconnection.setConnectTimeout(3000);
	  httpurlconnection.connect();
      if(httpurlconnection.getResponseCode()==200)
      {
          System.out.println(LinksUrl+" - "+httpurlconnection.getResponseMessage());
       }

	  if(httpurlconnection.getResponseCode()==httpurlconnection.HTTP_NOT_FOUND){
		  System.out.println(LinksUrl+"--" + httpurlconnection.getResponseMessage() +"--"+httpurlconnection.HTTP_NOT_FOUND);
	  }
	  
  }
	
  catch (Exception e){
	
	  
  }
  }
  
 
}
