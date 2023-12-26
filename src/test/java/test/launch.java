package test;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class launch {

	public static void main(String[] args) {
		WebDriverManager.chromedriver().setup();
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://ethara-frontend-staging.eu-staging.kacdn.net/");
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

		Actions action = new Actions(driver);

		WebElement aboutus = driver.findElement(By.xpath("//a[contains(text(),\"About us\")]"));
		WebElement book_now_GP_button = driver.findElement(By.xpath("//a[contains(text(),'Book now')]"));

		action.moveToElement(aboutus).click().perform();
		aboutus.click();

		// printing page title 
		System.out.println(driver.getTitle());

		String aboutus_expected = "Ethara | About Us";
		String aboutus_actual = driver.getTitle();
		driver.navigate().back();
		book_now_GP_button.click();

	}

}
