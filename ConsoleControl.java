package OptimisedCASBCode;

import java.io.IOException;
import java.text.ParseException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ConsoleControl {
	
	public static WebDriver driver;
	public static WebDriverWait wait;

	public static void main(String[] args) throws IOException, ParseException {
		
		driverSettings();
		SettingEnvirounment.openProduct();
		SettingEnvirounment.loginToProduct();
		SettingEnvirounment.cloudProtectionModule();
		LandingPage.reportsTab();

	}
    
	//DriverWait Function
	public static void justWait() {
		
		synchronized (driver) {
			try {
				driver.wait(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
	}
	//DriverSettingFunction 
	public static void driverSettings() {
		
		System.setProperty("webdriver.chrome.driver", "./drivers/chromedriver.exe");
		driver = new ChromeDriver();
		wait = new WebDriverWait(driver, Duration.ofSeconds(10));
	}
	
	//UntillWait Function
	public static void untillWaitClickable(WebElement element) {
		
		wait.until(ExpectedConditions.elementToBeClickable(element));
		
	}
	
	public static WebElement untillWaitPresence(String string) {
		
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(string)));

		
	}

}
