package OptimisedCASBCode;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import io.netty.util.internal.ThreadLocalRandom;

public class GettingAction extends ConsoleControl {
	public static int dataCount;

	public static int dropdownValueGetting() {
		
		justWait();
		WebElement dropdownpopup = driver.findElement(By.xpath("//button[@class='btn dropdown-toggle']"));
		dropdownpopup.click();
		justWait();
		int ddCountValue = ThreadLocalRandom.current().nextInt(1,6);
		
		return ddCountValue;
	}

	public static String periodGetting() {
	
		justWait();
		WebElement element_1=driver.findElement(By.xpath("(//input[@class='form-control pull-left date-range cursor-normal disabled'])"));
		element_1.click();
		justWait();
		List<String> periodList = CompleteDatabase.periodDatabase();
		String period = periodList.get(ThreadLocalRandom.current().nextInt(1));
		return period;
	}
	
	public static int getDataCount(HashMap<String, String> columnsList, List<WebElement> listth, int i) {
		
		dataCount = driver.findElements(By.xpath("//td[@name='dsp.webgateway.reports.table_column_name."+columnsList.get(listth.get(i).getText())+"']")).size();
		return dataCount;
	}
	
	public static ArrayList<String> dataGetter(int i) {
		
		HashMap<String, String> columnsList = CompleteDatabase.columnListDatabase();
		justWait();
		List<WebElement> listth = driver.findElements(By.xpath("//th[@class='active']"));
		System.out.println("\""+listth.get(i).getText() + "\"");
		int dataCount=GettingAction.getDataCount(columnsList,listth,i);
		System.out.println(dataCount);
		ArrayList<String> columnValues = new ArrayList<String>();
		for(int i1=0;i1<dataCount;i1++) {
			justWait();
			WebElement element_01  =driver.findElement(By.xpath("(//td[@name='dsp.webgateway.reports.table_column_name."+columnsList.get(listth.get(i).getText())+"'])[position()="+(i1+1)+"]"));
			String value=element_01.getText();
			
			
			columnValues.add(value);
		}
		return columnValues;
		
	}
public static ArrayList<String> dataGetterSearch(int i) {
		
		HashMap<String, String> columnsList = CompleteDatabase.searchListDatabase();
		justWait();
		List<WebElement> listth = driver.findElements(By.xpath("//input[@class='ember-view ember-text-field']"));
		System.out.println("\""+listth.get(i).getAttribute("name") + "\"");
		int dataCount=GettingAction.getDataCountSearch(columnsList,listth,i);
		System.out.println(dataCount);
		ArrayList<String> columnValues = new ArrayList<String>();
		for(int i1=0;i1<dataCount;i1++) {
			justWait();
			WebElement element_01  =driver.findElement(By.xpath("(//td[@name='dsp.webgateway.reports.table_column_name."+columnsList.get(listth.get(i).getAttribute("name"))+"'])[position()="+(i1+1)+"]"));
			String value=element_01.getText();
			columnValues.add(value);
		}
		return columnValues;
		
	}

	private static int getDataCountSearch(HashMap<String, String> columnsList, List<WebElement> listth, int i) {

		dataCount = driver.findElements(By.xpath("//td[@name='dsp.webgateway.reports.table_column_name."+columnsList.get(listth.get(i).getAttribute("name"))+"']")).size();
		return dataCount;

}

	public static ArrayList<String> dataGetterPeriod(String columnValue) {
		System.out.println(columnValue);
		ArrayList<String> columnValues = new ArrayList<String>();
		int dataCountTime = driver.findElements(By.xpath("(//td[@name='dsp.webgateway.reports.table_column_name.time_generated'])")).size();
		for(int i1=0;i1<dataCountTime;i1++) {
			justWait();
			WebElement element_01  =driver.findElement(By.xpath("//td[@name='dsp.webgateway.reports.table_column_name.time_generated']"));
			String value=element_01.getText();
			columnValues.add(value);
		}
		return columnValues;
	}
	
	public static int[] get_pageCount(int ddvaluev) {
		  justWait();
		  
		  String count = driver.findElement(By.xpath("//div[@class='table-nav']//span")).getText();
	      String count_arr[] = count.split(" ");
	      int row_count = Integer.parseInt(count_arr[count_arr.length-1]);
	      int page_count = 1;
	      if(row_count%ddvaluev == 0) {
	    	  page_count = row_count/ddvaluev;
	      }
	      else if(row_count<ddvaluev) {
	    	
	    	  page_count = 1;
	      }
	      else {
	    	 
	    	  page_count = (row_count/ddvaluev)+1;
	    	 
		}
	      
	      return new int[] {page_count, row_count};
	  }

	public static void countCorrection(HashMap<Integer, String> hmList, WebElement element) throws IOException {
		for(Map.Entry<Integer, String> e : hmList.entrySet()) { 
			try {
				WebElement listOfhm = untillWaitPresence(e.getValue());
				listOfhm.click();
			}catch (Exception e1) {
				System.out.println("shanmu");
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				WebElement listOfhm = untillWaitPresence(e.getValue());
				listOfhm.click();
			}
		String request = untillWaitPresence(e.getValue()).getText();
		String period =GettingAction.periodGetting();
		SelectionAction.periodSelection(period);
		int ddvaluev = GettingAction.dropdownValueGetting();
		int ddvalueCrt=SelectionAction.dropdownSelection(ddvaluev);
		int[] pageCount= GettingAction.get_pageCount(ddvalueCrt);
		for(int i=0;i<pageCount[0];i++) {
		GettingAction.dataGetter(0);
		if(dataCount==ddvalueCrt) {
			PerforminActions.pageSelection();
		}else if(dataCount > ddvalueCrt) {
			String result ="False";
			ActionChecking.verifyddSelectionCheck(result,request);
			break;
		}else {
			String result ="True";
			ActionChecking.verifyddSelectionCheck(result,request);
			break;
		}
		
		
		
		}
		
			}
		
	}

	public static int getexportFormat() {
		
		WebElement exportAs = driver.findElement(By.xpath("//a[@class='dropdown-toggle']/i[@class='dsp-inline-icon icn-saveas']"));
		exportAs.click();
		int ddValue = ThreadLocalRandom.current().nextInt(1,4);
		return ddValue;
	}

	public static String getdownLoadValue() {
		
		      // Store the current window handle
		      String mainWindow = driver.getWindowHandle();
		      
		      // open a new tab
		      JavascriptExecutor js = (JavascriptExecutor)driver;
		      js.executeScript("window.open()");
		     // switch to new tab
		    // Switch to new window opened
		      for(String winHandle : driver.getWindowHandles()){
		          driver.switchTo().window(winHandle);
		      }
		     // navigate to chrome downloads
		      driver.get("chrome://downloads");
		      
		      JavascriptExecutor js1 = (JavascriptExecutor)driver;
		      justWait();
		     // get the latest downloaded file name
		      String fileName = (String) js1.executeScript("return document.querySelector('downloads-manager').shadowRoot.querySelector('#downloadsList downloads-item').shadowRoot.querySelector('div#content #file-link').text");
		      System.out.println("File Name :-" + fileName);
		     // close the downloads tab2
		      driver.close();
		     // switch back to main window
		      driver.switchTo().window(mainWindow);
		      return fileName;
		  
		
		
	}
	

}
