package OptimisedCASBCode;

import java.io.IOException;
import java.text.ParseException;
import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

public class ReportsPage extends ConsoleControl {

	public static void generalTab() throws IOException, ParseException {
		
		int sheet=0;
		justWait();
		WebElement generalTab =driver.findElement(By.xpath("//a[text()='General']"));
		HashMap<Integer, String> generalLists = CompleteDatabase.generaldatabase();
		
		PerforminActions.functionSort(generalLists,generalTab, sheet);
		PerforminActions.functionSearch(generalLists,generalTab, sheet);
//		PerforminActions.functionPeriodCollect(generalLists,generalTab);
//		PerforminActions.functionCountCollect(generalLists,generalTab);
//		PerforminActions.functionSpecialsortTestcase(generalLists,generalTab);
//		PerforminActions.exportFormat(generalLists, generalTab);
	}
	
	public static void applicationInsights() throws IOException, ParseException {
		
		int sheet=1;
		WebElement applicationInsightsTab=driver.findElement(By.xpath("//a[text()='Application Insight']"));
		HashMap<Integer, String> applicationInsightsLists = CompleteDatabase.applicationInsightsdatabase();
		
		PerforminActions.functionSort(applicationInsightsLists,applicationInsightsTab,sheet);
		PerforminActions.functionSearch(applicationInsightsLists,applicationInsightsTab,sheet);
		
//		PerforminActions.functionPeriodCollect(applicationInsightsLists,applicationInsightsTab);
//		PerforminActions.functionCountCollect(applicationInsightsLists,applicationInsightsTab);
//		PerforminActions.functionSpecialsortTestcase(applicationInsightsLists, applicationInsightsTab);
//		PerforminActions.exportFormat(applicationInsightsLists, applicationInsightsTab);
	}

	public static void shadowCloudApps() throws IOException, ParseException {
		
		int sheet=2;
		WebElement shadowCloudAppsTab=driver.findElement(By.xpath("//a[text()='Shadow Cloud Apps']"));
		shadowCloudAppsTab.click();
		justWait();
		HashMap<Integer, String> shadowCloudAppsLists = CompleteDatabase.shadowCloudAppsdatabase();
		
		PerforminActions.functionSort(shadowCloudAppsLists,shadowCloudAppsTab, sheet);
		PerforminActions.functionSearch(shadowCloudAppsLists,shadowCloudAppsTab, sheet);
//		PerforminActions.functionPeriodCollect(shadowCloudAppsLists,shadowCloudAppsTab);
//		PerforminActions.functionCountCollect(shadowCloudAppsLists,shadowCloudAppsTab);
//		PerforminActions.functionSpecialsortTestcase(shadowCloudAppsLists, shadowCloudAppsTab);
//		PerforminActions.exportFormat(shadowCloudAppsLists, shadowCloudAppsTab);

	}

	public static void bannedCloudApps() throws IOException, ParseException {
		
		WebElement bannedCloudAppsTab= driver.findElement(By.xpath("//a[text()='Banned Cloud Apps']"));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", bannedCloudAppsTab);
		justWait();
		bannedCloudAppsTab.click();
		justWait();
		HashMap<Integer, String> bannedCloudAppsLists = CompleteDatabase.bannedCloudAppsdatabase();
		
		PerforminActions.functionSort(bannedCloudAppsLists,bannedCloudAppsTab, 0);
		PerforminActions.functionSearch(bannedCloudAppsLists,bannedCloudAppsTab, 0);
//		PerforminActions.functionPeriodCollect(bannedCloudAppsLists,bannedCloudAppsTab);
//		PerforminActions.functionCountCollect(bannedCloudAppsLists,bannedCloudAppsTab);
//		PerforminActions.functionSpecialsortTestcase(bannedCloudAppsLists, bannedCloudAppsTab);
//		PerforminActions.exportFormat(bannedCloudAppsLists,bannedCloudAppsTab);

	}
	

	public static void fileUploads() throws IOException, ParseException {
		
		WebElement fileUploadsTab= driver.findElement(By.xpath("//a[text()='File Uploads']"));
		fileUploadsTab.click();
		justWait();
		HashMap<Integer, String> fileUploadLists = CompleteDatabase.fileUploadListsdatabase();
		
		PerforminActions.functionSort(fileUploadLists,fileUploadsTab, 0);
		PerforminActions.functionSearch(fileUploadLists,fileUploadsTab, 0);
//		PerforminActions.functionPeriodCollect(fileUploadLists,fileUploadsTab);
//		PerforminActions.functionCountCollect(fileUploadLists,fileUploadsTab);
//		PerforminActions.functionSpecialsortTestcase(fileUploadLists, fileUploadsTab);
//		PerforminActions.exportFormat(fileUploadLists, fileUploadsTab);

	}

	public static void zohoFileUploads() throws IOException, ParseException {
		WebElement zohoFileUploadsTab= driver.findElement(By.xpath("//a[text()='Zoho File Uploads']"));
		zohoFileUploadsTab.click();
		justWait();
		HashMap<Integer, String> zohoFileUploadLists = CompleteDatabase.zohoFileUploadListsdatabase();
		
		PerforminActions.functionSort(zohoFileUploadLists,zohoFileUploadsTab, 0);
		PerforminActions.functionSearch(zohoFileUploadLists,zohoFileUploadsTab, 0);
//		PerforminActions.functionPeriodCollect(zohoFileUploadLists, zohoFileUploadsTab);
//		PerforminActions.functionCountCollect(zohoFileUploadLists,zohoFileUploadsTab);
//		PerforminActions.functionSpecialsortTestcase(zohoFileUploadLists, zohoFileUploadsTab);
//		PerforminActions.exportFormat(zohoFileUploadLists, zohoFileUploadsTab);

	}

	

}
