	       
	  import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
	  import org.openqa.selenium.WebDriver;
	  import org.openqa.selenium.WebElement;
	  import org.openqa.selenium.chrome.ChromeDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

import java.io.IOException;
	  import java.net.HttpURLConnection;
	  import java.net.URL;
	  import java.util.List;
import java.util.concurrent.TimeUnit;

	  public class BrokenLinkChecker {
			public static Logger log;
	      public static void main(String[] args) throws IOException {
	    	  log = Logger.getLogger(BrokenLinkChecker.class);
	  		PropertyConfigurator.configure("log4j.properties");
	        WebDriverManager.chromedriver().setup();
	          WebDriver driver = new ChromeDriver();
	          driver.manage().window().maximize();

	         
	              driver.get("https://www.magicplanetmena.com/sitemap"); // Replace with your URL
	              driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

	              List<WebElement> links = driver.findElements(By.tagName("a"));
	              for (WebElement link : links) {
	                  String url = link.getAttribute("href");
	                  if (isValidUrl(url)) {
	                      URL newurl = new URL(url);
	                      HttpURLConnection httpConnect = (HttpURLConnection) newurl.openConnection();
	                      httpConnect.connect();

	                      int rescode = httpConnect.getResponseCode();

	                      if (rescode >= 400) {
	                          log.info(url);
	                      }
	                  }
	              }

	              driver.quit();
	          }

	          private static boolean isValidUrl(String url) {
	              return url != null && !url.isEmpty() && !url.startsWith("javascript:") && !url.startsWith("mailto:") && !url.startsWith("tel:");
	          }
	      }





