package OptimisedCASBCode;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class PerforminActions extends ConsoleControl  {

	public static void functionSort(HashMap<Integer, String> hmList, WebElement element, int sheet) throws IOException, ParseException {
		
		for(Map.Entry<Integer, String> e : hmList.entrySet()) { 
			
			
			try {
				WebElement listOfhm = untillWaitPresence(e.getValue());
				listOfhm.click();
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);

			}
			catch (Exception e1) {
					System.out.println("shanmu");
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					justWait();
					WebElement listOfhm = untillWaitPresence(e.getValue());
					listOfhm.click();			
					}
			
			justWait();
			int count = driver.findElements(By.xpath("//th[@class='active']")).size();
			for(int i=0;i<count;i++) {
				String request =driver.findElement(By.xpath(e.getValue())).getText();
				System.out.println(request);
				justWait();
				String period =GettingAction.periodGetting();
				SelectionAction.periodSelection(period);
				justWait();
				String columnName = new String();
				WebElement column= driver.findElement(By.xpath("//th[@class='active']["+(i+1)+"]"));
				((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
				columnName = element.getText()+'\n'+request+'\n'+column.getText()+'\n'+"(SORT)";
				untillWaitClickable(column);
				column.click();
				justWait();
				int ddvaluev = GettingAction.dropdownValueGetting();
				int ddvalueCrt=SelectionAction.dropdownSelection(ddvaluev);
				int[] pageCount= GettingAction.get_pageCount(ddvalueCrt);
				
				ArrayList<String> columnValues = new ArrayList<String>();
				ArrayList<String> columnValues1 = new ArrayList<String>();
				 justWait();
				 columnValues1 =  GettingAction.dataGetter(i);
				 columnValues.addAll(columnValues1);
				for(int a=0;a<pageCount[0]-1;a++) {
					
					
					 WebElement pageSelection = driver.findElement(By.xpath("//i[@class='dsp-inline-icon icn-next']"));
					 pageSelection.click();
					 justWait();
					 columnValues1 =  GettingAction.dataGetter(i);
					 columnValues.addAll(columnValues1);
					 
				
				}
				
				ActionChecking.verifySort(columnValues,columnName,sheet);
				
			}
		}

	}

	

	public static void exportFormat(HashMap<Integer, String> hmList, WebElement element) {
		
for(Map.Entry<Integer, String> e : hmList.entrySet()) { 
			
			
			try {
				WebElement listOfhm = untillWaitPresence(e.getValue());
				listOfhm.click();
			}
			catch (Exception e1) {
					System.out.println("shanmu");
					((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
					WebElement listOfhm = untillWaitPresence(e.getValue());
					listOfhm.click();			
					}
			
			justWait();
			System.out.println(driver.findElement(By.xpath(e.getValue())).getText());
		
		int dropdownValue=GettingAction.getexportFormat();
		String dropdownString = SelectionAction.selectexportDropdown(dropdownValue);
		System.out.println(dropdownString);
		justWait();
		String exportedString= GettingAction.getdownLoadValue();
		System.out.println(exportedString);
		String[] countArr = exportedString.split("\\.");
		String exportedStringValue = countArr[countArr.length-1];
		ActionChecking.exportedValueCheck(dropdownString,exportedStringValue);
	}
	}



	public static void functionSearch(HashMap<Integer, String> hmList, WebElement element, int sheet) throws IOException {
		
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
			justWait();
			String period =GettingAction.periodGetting();
			SelectionAction.periodSelection(period);
			justWait();
			WebElement element_1 = driver.findElement(By.xpath("//i[@class='dsp-icon icn-table-search']"));
    		element_1.click();
    		String columnName = new String();
    		int count=driver.findElements(By.xpath("//input[@class='ember-view ember-text-field']")).size();
    		for(int i=0;i<count;i++) {
    			justWait();
    			String request = driver.findElement(By.xpath(e.getValue())).getText();
    			WebElement element_2 = driver.findElement(By.xpath("(//input[@class='ember-view ember-text-field'])[position()="+(i+1)+"]"));
    			columnName = element.getText()+'\n'+request+'\n'+element_2.getAttribute("name")+'\n'+"(SEARCH)";
    			System.out.println(columnName);
    			ArrayList<String>columnValues1=GettingAction.dataGetterSearch(i);
    			wait.until(ExpectedConditions.elementToBeClickable(element_2));
    			String value = new String();
    			if(columnValues1.size()>0) {
    			value =columnValues1.get(0);
    			}else if(columnValues1.size()==0) {
    				value = "no data";
    			}
    			System.out.println(value);
    			String searValue = new String();
    			if(value.length()>6) {
    			searValue=value.substring(3, 6);
    			}else if(value.length()<3) {
    				searValue = value.substring(0);
    			}
    			System.out.println(searValue);
				element_2.sendKeys(searValue);
				element_2.sendKeys(Keys.ENTER);
				justWait();
				int ddvaluev = GettingAction.dropdownValueGetting();
				int ddvalueCrt=SelectionAction.dropdownSelection(ddvaluev);
				int[] pageCount= GettingAction.get_pageCount(ddvalueCrt);
				ArrayList<String> columnValues = new ArrayList<String>();
				 justWait();
				 columnValues.addAll(columnValues1);
				for(int a=0;a<pageCount[0]-1;a++) {
					
					
					 WebElement pageSelection = driver.findElement(By.xpath("//i[@class='dsp-inline-icon icn-next']"));
					 pageSelection.click();
					 justWait();
					 columnValues1 =  GettingAction.dataGetter(i);
					 columnValues.addAll(columnValues1);
					 
				
				}
				int values = columnValues.size();
				
				System.out.println(values);
				ActionChecking.verifySearch(columnValues,searValue,columnName,sheet);
				if(pageCount[0]>1) {
				driver.findElement(By.xpath("//i[@class='dsp-inline-icon icn-prev-all']")).click();
				}
				justWait();
				WebElement element_3 =wait.until(ExpectedConditions.elementToBeClickable(By.xpath("(//input[@class='ember-view ember-text-field'])[position()="+(i+1)+"]")));
				element_3.click();
				element_3.clear();	   			
    			
    			}
    		}
		}



	public static void functionPeriodCollect(HashMap<Integer, String> hmList, WebElement element) throws IOException, ParseException {
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
		
		String periodValue = GettingAction.periodGetting();
		System.out.println(periodValue);
		SelectionAction.periodSelection(periodValue);
		int activeColumn = driver.findElements(By.xpath("//th[@class='active']")).size();
		for(int i=1;i<=activeColumn;i++) {
			String cN = driver.findElement(By.xpath("//th[@class='active']["+i+"]")).getText();
			if(cN.equals("TIME GENERATED")) {
				ArrayList<String> periodData =GettingAction.dataGetterPeriod(cN);
				if(periodData.size()>0) {
				ActionChecking.verifyPeriodCheck(periodValue,periodData,cN);
				}
				}
			}
		
		}
	}



	public static void functionCountCollect(HashMap<Integer, String> hmList, WebElement element) throws IOException {
		
		GettingAction.countCorrection(hmList,element);
		}



	public static void functionSpecialsortTestcase(HashMap<Integer, String> hmList, WebElement element) {
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
			int count = driver.findElements(By.xpath("//th[@class='active']")).size();
			for(int i=0;i<count;i++) {
				System.out.println(driver.findElement(By.xpath(e.getValue())).getText());
				justWait();
				
			String request = untillWaitPresence(e.getValue()).getText();
			String period =GettingAction.periodGetting();
			SelectionAction.periodSelection(period);
			int ddvaluev = GettingAction.dropdownValueGetting();
			int ddvalueCrt=SelectionAction.dropdownSelection(ddvaluev);
			int[] pageCount= GettingAction.get_pageCount(ddvalueCrt);
			System.out.println(pageCount[0]);
			if(pageCount[0]==0) {
				String result = "Insufficient Data";
				ActionChecking.verifySpecialSort(result,request);
			}else if(pageCount[0]>5) {
				for(int i1=0;i1<3;i1++) {
					WebElement pageSelection = driver.findElement(By.xpath("//i[@class='dsp-inline-icon icn-next']"));
					pageSelection.click();
					justWait();
					
				}
					}else {
						for(int i1=0;i1<pageCount[0];i1++) {
							WebElement pageSelection = driver.findElement(By.xpath("//i[@class='dsp-inline-icon icn-next']"));
							pageSelection.click();
							justWait();
							
						}
					}
				
				WebElement column= driver.findElement(By.xpath("//th[@class='active']["+(i+1)+"]"));
				untillWaitClickable(column);
				column.click();
				justWait();
				 String count1 = driver.findElement(By.xpath("//div[@class='table-nav']//span")).getText();
			      String count_arr[] = count1.split(" ");
			      String count_arr1[] = count_arr[0].split("-");
			      int row_count= Integer.parseInt(count_arr1[0]);
			      System.out.println(row_count);
				if(row_count==1) {
					String result="True";
					System.out.println(result);
					ActionChecking.verifySpecialSort(result,request);
				}else {
					String result="False";
					System.out.println(result);
					ActionChecking.verifySpecialSort(result,request);
				}
				}
			}
		
	}



	public static void pageSelection() {
		
		WebElement pageSelection = driver.findElement(By.xpath("//i[@class='dsp-inline-icon icn-next']"));
		pageSelection.click();
		justWait();
	}
	
}

