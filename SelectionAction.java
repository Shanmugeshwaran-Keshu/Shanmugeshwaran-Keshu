package OptimisedCASBCode;

import java.util.HashMap;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import io.netty.util.internal.ThreadLocalRandom;

public class SelectionAction extends ConsoleControl {

	
	public static int dropdownSelection(int ddvaluev) {
		
		WebElement dropdownListSelection = driver.findElement(By.xpath("//ul[@class='dropdown-menu']/li["+ThreadLocalRandom.current().nextInt(1,6)+"]"));
		System.out.println(dropdownListSelection.getText());
		String text = dropdownListSelection.getText();
		int ddvalue = Integer.parseInt(text);
		dropdownListSelection.click();
		justWait();
		WebElement dropdownpopup = driver.findElement(By.xpath("//button[@class='btn dropdown-toggle']"));
		justWait();
		dropdownpopup.click();
		return ddvalue;
	}

	

	public static void periodSelection(String period) {
		WebElement periodSelection = null;
		try {
			periodSelection=driver.findElement(By.xpath("//li[contains(text(),'"+period+"')]"));
			untillWaitClickable(periodSelection);
			periodSelection.click();
		}catch (Exception e) {
			System.out.println("shanmu");
			((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",periodSelection);
			untillWaitClickable(periodSelection);
			periodSelection.click();
		}
		if(period.contains("Custom Range")) {
			WebElement apply = driver.findElement(By.xpath("//button[@class='applyBtn btn btn-sm btn-success']"));
			apply.click();
			justWait();
		}
		//((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);",driver.findElement(By.xpath("(//a[@class='dropdown-toggle'])[3]")));
		System.out.println(periodSelection.getText());
		justWait();
		
	}



	public static String selectexportDropdown(int dropdownValue) {
		
		HashMap<Integer, String> exportDD = CompleteDatabase.exportDropdownList(); 
		WebElement exportddSelection = driver.findElement(By.xpath("//i[@class='dsp-icon icn-file-"+exportDD.get(dropdownValue)+"']"));
		System.out.println(dropdownValue);
		String exportddString= exportDD.get(dropdownValue);
		exportddSelection.click();
		justWait();
		System.out.println(exportddString+"Shanmu");
		return exportddString;
	}
}
