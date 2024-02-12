package test;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.LogManager;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

public class loggerFile {

		org.apache.log4j.Logger log = LogManager.getLogger(loggerFile.class);
		
		@Test
		public void Launch() throws InterruptedException 
		{
			PropertyConfigurator.configure("log4j.properties");
			WebDriver driver = new ChromeDriver();
			
			driver.manage().window().maximize();
			log.info("Browser set up completed");
			driver.get("https://ethara.com/");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			
			log.info("Ethara Home page");
			
			Thread.sleep(2000);
			driver.close();
			log.info("Closing Browser");
			
		
			
		}
}
