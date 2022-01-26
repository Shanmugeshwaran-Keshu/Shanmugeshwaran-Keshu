package OptimisedCASBCode;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

public class SettingEnvirounment extends ConsoleControl  {

	public static void openProduct() {
		
		driver.get("http://localhost:8800");
		driver.manage().window().maximize();
		justWait();
		
	}

	public static void loginToProduct() {
		
		WebElement userName=driver.findElement(By.xpath("//input[@id='j_username']"));
		userName.sendKeys("admin");
		WebElement passKey = driver.findElement(By.xpath("//input[@id='j_password']"));
		passKey.sendKeys("admin");
		WebElement domainList = driver.findElement(By.xpath("//select[@id='domainList']"));
		Select domainListDropdown = new Select(domainList);
		domainListDropdown.selectByVisibleText("DataSecurityPlus Authentication");
		WebElement loginButton = driver.findElement(By.xpath("//input[@id='login']"));
		loginButton.click();
		
	}

	public static void cloudProtectionModule() {
		
		WebElement cloudProtection = driver.findElement(By.xpath("(//div[@class='dsp-apps-legend'])[position()=5]"));
		untillWaitClickable(cloudProtection);
		cloudProtection.click();
		justWait();
		
	}
	
	

}
