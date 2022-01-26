package OptimisedCASBCode;

import java.io.IOException;
import java.text.ParseException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LandingPage extends ConsoleControl {

	public static void reportsTab() throws IOException, ParseException {
		
		WebElement reportsTab = driver.findElement(By.xpath("//a[text()='Reports']"));
		untillWaitClickable(reportsTab);
		reportsTab.click();
		ReportsPage.generalTab();
		ReportsPage.applicationInsights();
		ReportsPage.shadowCloudApps();
		ReportsPage.bannedCloudApps();
		ReportsPage.fileUploads();
		ReportsPage.zohoFileUploads();
	}

}
