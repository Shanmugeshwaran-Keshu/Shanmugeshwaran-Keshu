package OptimisedCASBCode;

import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.temporal.TemporalAdjusters.nextOrSame;
import static java.time.temporal.TemporalAdjusters.previousOrSame;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class ActionChecking extends GettingAction {

	public static void verifySort(ArrayList<String> columnValues, String columnName, int sheet) throws IOException, ParseException {
		
		int num=0;
		List<String> oldValues = new ArrayList<String>();
		List<String> newValues = new ArrayList<String>();
		String temp = new String();
		String[] oldepoch = new String[columnValues.size()];
		String[] newepoch = new String[columnValues.size()];
		String[] epochString = new String[columnValues.size()];
		List<Long> epoch = new ArrayList<Long>();
		if(columnName.contains("TIME GENERATED")) {
			System.out.println("Shanmu Time");
			for(int i=0;i<columnValues.size();i++) {
				SimpleDateFormat df = new SimpleDateFormat("MMM dd,yyyy hh:mm:ss aa");
				Date date = df.parse(columnValues.get(i));
				long epoch_01 = date.getTime();
				epoch.add(epoch_01);
				epochString[i] = epoch.get(i).toString();
			}		
				oldepoch=epochString;
				Arrays.sort(epochString);
				newepoch=epochString;
					if(oldepoch.equals(newepoch)) {
						temp="TRUE";
					}else {
						temp="FALSE"+" "+oldepoch+" "+newepoch;
					}
					System.out.println(temp);
					ExcelReportGenerate.printReport(temp,columnName, num, sheet);
		}else {
			oldValues = columnValues;
			Collections.sort(columnValues);
			newValues = columnValues;
				if(oldValues.equals(newValues)) {
					temp="TRUE";
				}else {
					temp="FALSE"+" "+oldValues+" "+newValues;
		}
		System.out.println(temp);
		ExcelReportGenerate.printReport(temp,columnName,num,sheet);
		}
	}

	public static void verifySearch(ArrayList<String> columnValues, String searValue, String columnName, int sheet) throws IOException {
		
		int num=2;
		int count = 0;
		String temp;
		for(int i=0;i<dataCount;i++) {
			String data=columnValues.get(i);
			if(data.contains(searValue));
			count++;
		}if(count==dataCount) {
			temp="TRUE";
		}else {
			temp="FALSE"+" "+count+" "+dataCount;
		}
		System.out.println(temp+""+columnName);
		
		ExcelReportGenerate.printReport(temp,columnName, num, sheet);
		
		
	}

	public static void verifyPeriodCheck(String periodValue, ArrayList<String> periodData, String cN) throws IOException, ParseException {
		
		int num=4;
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMM dd,yyyy HH:mm:ss",Locale.ENGLISH);
		String[] listArr = new String[periodData.size()];
		Date[] dt = new Date[periodData.size()];
		for(int i=0;i<periodData.size();i++) {
	          listArr[i] = periodData.get(i);
	          dt[i]=(Date) new SimpleDateFormat("MMM dd,yyyy hh:mm:ss aa").parse(listArr[i]);
	          
		}
		
		
		LocalDateTime dbFirstDate = convertToLocalDateTime(dt[0]);
		LocalDateTime dbLastDate = convertToLocalDateTime(dt[periodData.size()-1]);
		String ans="FALSE"+" "+dbFirstDate+" "+dbLastDate+" "+periodValue;
		System.out.println("Shanmu++++");
		if(periodValue.contains("Today")) {
			
			LocalDate dateTime01 = LocalDate.now();
			LocalDate dateTime02 = LocalDate.now().plusDays(1);
			String todayStart =dateTime01.atStartOfDay().format(formatter).toString();
		    String todayEnd =dateTime02.atStartOfDay().format(formatter).toString();
		    System.out.println(todayStart);
		    System.out.println(todayEnd);
		    LocalDateTime startdate = LocalDateTime.parse(todayStart,formatter);
		    LocalDateTime enddate = LocalDateTime.parse(todayEnd,formatter);
		    if(dbFirstDate.isAfter(startdate)&&dbLastDate.isBefore(enddate)) {
		    	   ans ="TRUE";
		    	  
		    	   }
		    System.out.println(ans);
		    ExcelReportGenerate.printReport(ans, cN, num, num);
		}
		if(periodValue.contains("Last 24 Hours")) {
			
			LocalDateTime dateTime01 = LocalDateTime.now().minusHours(24);
			LocalDateTime dateTime02 = LocalDateTime.now();
			String todayStart =dateTime01.format(formatter).toString();
		    String todayEnd =dateTime02.format(formatter).toString();
		    System.out.println(todayStart);
		    System.out.println(todayEnd);
		    LocalDateTime startdate = LocalDateTime.parse(todayStart,formatter);
		    LocalDateTime enddate = LocalDateTime.parse(todayEnd,formatter);
		    if(dbFirstDate.isAfter(startdate)&&dbLastDate.isBefore(enddate)) {
		    	   ans ="TRUE";
		    	  
		    	   }
		    System.out.println(ans);
		    ExcelReportGenerate.printReport(ans, cN, num, num);
		}
		
		if(periodValue.contains("Previous Day")) {
			
			LocalDate dateTime01 = LocalDate.now().minusDays(1);
			LocalDate dateTime02 = LocalDate.now();
			String todayStart =dateTime01.atStartOfDay().format(formatter).toString();
		    String todayEnd =dateTime02.atStartOfDay().format(formatter).toString();
		    LocalDateTime startdate = LocalDateTime.parse(todayStart,formatter);
		    LocalDateTime enddate = LocalDateTime.parse(todayEnd,formatter);
		    System.out.println(todayStart);
		    System.out.println(todayEnd);
		    if(dbFirstDate.isAfter(startdate)&&dbLastDate.isBefore(enddate)) {
		    	ans="TRUE";
		    
		    }
		    System.out.println(ans);
		    ExcelReportGenerate.printReport(ans, cN, num, num);
		}

		if(periodValue.contains("Last 7 Days")) {
			
			LocalDateTime dateTime01 = LocalDateTime.now().minusHours(7*24);
			LocalDateTime dateTime02 = LocalDateTime.now();
			String todayStart =dateTime01.format(formatter).toString();
		    String todayEnd =dateTime02.format(formatter).toString();
		    LocalDateTime startdate = LocalDateTime.parse(todayStart,formatter);
		    LocalDateTime enddate = LocalDateTime.parse(todayEnd,formatter);
		    System.out.println(todayStart);
		    System.out.println(todayEnd);
		    if(dbFirstDate.isAfter(startdate)&&dbLastDate.isBefore(enddate)) {
		    	ans="TRUE";
		    	
		    }
		    System.out.println(ans);
		    ExcelReportGenerate.printReport(ans, cN, num, num);
		}
		
		if(periodValue.contains("Last 15 Days")) {
			
			LocalDateTime dateTime01 = LocalDateTime.now().minusHours(15*24);
			LocalDateTime dateTime02 = LocalDateTime.now();
			String todayStart =dateTime01.format(formatter).toString();
		    String todayEnd =dateTime02.format(formatter).toString();
		    LocalDateTime startdate = LocalDateTime.parse(todayStart,formatter);
		    LocalDateTime enddate = LocalDateTime.parse(todayEnd,formatter);
		    System.out.println(todayStart);
		    System.out.println(todayEnd);
		    if(dbFirstDate.isAfter(startdate)&&dbLastDate.isBefore(enddate)) {
		    	ans="TRUE";
		    	
		    }
		    System.out.println(ans);
		    ExcelReportGenerate.printReport(ans, cN, num, num);
		}
		
		if(periodValue.contains("Last 30 Days")) {
			
			LocalDateTime dateTime01 = LocalDateTime.now().minusHours(30*24);
			LocalDateTime dateTime02 = LocalDateTime.now();
			String todayStart =dateTime01.format(formatter).toString();
		    String todayEnd =dateTime02.format(formatter).toString();
		    LocalDateTime startdate = LocalDateTime.parse(todayStart,formatter);
		    LocalDateTime enddate = LocalDateTime.parse(todayEnd,formatter);
		    System.out.println(todayStart);
		    System.out.println(todayEnd);
		    if(dbFirstDate.isAfter(startdate)&&dbLastDate.isBefore(enddate)) {
		    	ans ="TRUE";
		    	
		    }
		    System.out.println(ans);
		    ExcelReportGenerate.printReport(ans, cN, num, num);
		}
		
		if(periodValue.contains("This Week")) {
			
			LocalDate today = LocalDate.now();
		    LocalDate monday = today.with(previousOrSame(MONDAY));
		    LocalDate sunday = today.with(nextOrSame(SUNDAY));
			String todayStart =monday.atStartOfDay().format(formatter).toString();
		    String todayEnd =sunday.atStartOfDay().format(formatter).toString();
		    LocalDateTime startdate = LocalDateTime.parse(todayStart,formatter);
		    LocalDateTime enddate = LocalDateTime.parse(todayEnd,formatter);
		    System.out.println(todayStart);
		    System.out.println(todayEnd);
		    if(dbFirstDate.isAfter(startdate)&&dbLastDate.isBefore(enddate)) {
		    	ans="TRUE";
		    	
		    }
		    System.out.println(ans);
		    ExcelReportGenerate.printReport(ans, cN, num, num);
		}
		if(periodValue.contains("Previous Week")) {
			
			LocalDate today = LocalDate.now();
		    LocalDate monday = today.with(previousOrSame(SUNDAY));
		    LocalDate sunday = monday.with(previousOrSame(MONDAY));
			String todayStart =monday.atStartOfDay().format(formatter).toString();
		    String todayEnd =sunday.atStartOfDay().format(formatter).toString();
		    LocalDateTime startdate = LocalDateTime.parse(todayStart,formatter);
		    LocalDateTime enddate = LocalDateTime.parse(todayEnd,formatter);
		    System.out.println(todayStart);
		    System.out.println(todayEnd);
		    if(dbFirstDate.isAfter(startdate)&&dbLastDate.isBefore(enddate)) {
		    	ans="TRUE";
		    
		    }
		    System.out.println(ans);
		    ExcelReportGenerate.printReport(ans, cN, num, num);
		}
		
		if(periodValue.contains("This Month")) {
			
			LocalDate today = LocalDate.now();
			LocalDate dateTime01 = LocalDate.now().withDayOfMonth(1);
			LocalDate dateTime02 = LocalDate.now().withDayOfMonth(today.lengthOfMonth());
			String todayStart =dateTime01.atStartOfDay().format(formatter).toString();
		    String todayEnd =dateTime02.atStartOfDay().format(formatter).toString();
		    LocalDateTime startdate = LocalDateTime.parse(todayStart,formatter);
		    LocalDateTime enddate = LocalDateTime.parse(todayEnd,formatter);
		    System.out.println(todayStart);
		    System.out.println(todayEnd);
		    if(dbFirstDate.isAfter(startdate)&&dbLastDate.isBefore(enddate)) {
		    	ans="TRUE";
		    	
		    }
		    System.out.println(ans);
		    ExcelReportGenerate.printReport(ans, cN, num, num);
		}
	

		if(periodValue.contains("Previous Month")) {
			
			LocalDate today = LocalDate.now().minusMonths(1);
			LocalDate dateTime01 = today.withDayOfMonth(1);
			LocalDate dateTime02 = today.withDayOfMonth(today.lengthOfMonth());
			String todayStart =dateTime01.atStartOfDay().format(formatter).toString();
		    String todayEnd =dateTime02.atStartOfDay().format(formatter).toString();
		    LocalDateTime startdate = LocalDateTime.parse(todayStart,formatter);
		    LocalDateTime enddate = LocalDateTime.parse(todayEnd,formatter);
		    System.out.println(todayStart);
		    System.out.println(todayEnd);
		    if(dbFirstDate.isAfter(startdate)&&dbLastDate.isBefore(enddate)) {
		    	ans="TRUE";
		    	
		    }
		    System.out.println(ans);
		    ExcelReportGenerate.printReport(ans, cN, num, num);
		}
		if(periodValue.contains("Last 60 Minutes")) {
			
			LocalDateTime dateTime01 = LocalDateTime.now().minusMinutes(60);
			LocalDateTime dateTime02 = LocalDateTime.now();
			String todayStart =dateTime01.format(formatter).toString();
		    String todayEnd =dateTime02.format(formatter).toString();
		    LocalDateTime startdate = LocalDateTime.parse(todayStart,formatter);
		    LocalDateTime enddate = LocalDateTime.parse(todayEnd,formatter);
		    System.out.println(todayStart);
		    System.out.println(todayEnd);
		    if(dbFirstDate.isAfter(startdate)&&dbLastDate.isBefore(enddate)) {
		    	ans ="TRUE";
		    	
		    }
		    System.out.println(ans);
		    ExcelReportGenerate.printReport(ans, cN, num, num);
		}
		if(periodValue.contains("Previous Hour")) {
			
			int minutes= LocalDateTime.now().getMinute();
			LocalDateTime dateTime02 = LocalDateTime.now().minusMinutes(minutes);
			LocalDateTime dateTime01 = LocalDateTime.now().minusMinutes(minutes).minusHours(1);
			String todayStart =dateTime01.format(formatter).toString();
		    String todayEnd =dateTime02.format(formatter).toString();
		    LocalDateTime startdate = LocalDateTime.parse(todayStart,formatter);
		    LocalDateTime enddate = LocalDateTime.parse(todayEnd,formatter);
		    System.out.println(todayStart);
		    System.out.println(todayEnd);
		    if(dbFirstDate.isAfter(startdate)&&dbLastDate.isBefore(enddate)) {
		    	ans ="TRUE";
		    	
		    }
		    System.out.println(ans);
		    ExcelReportGenerate.printReport(ans, cN, minutes, minutes);
		}
		if(periodValue.contains("Custom Range")) {
			LocalDateTime dateTime01 = LocalDate.now().atStartOfDay();
			LocalDateTime dateTime02 = LocalDate.now().plusDays(1).atStartOfDay();
			String todayStart =dateTime01.format(formatter).toString();
		    String todayEnd =dateTime02.format(formatter).toString();
		    LocalDateTime startdate = LocalDateTime.parse(todayStart,formatter);
		    LocalDateTime enddate = LocalDateTime.parse(todayEnd,formatter);
		    System.out.println(todayStart);
		    System.out.println(todayEnd);
		    if(dbFirstDate.isAfter(startdate)&&dbLastDate.isBefore(enddate)) {
		    	ans ="TRUE";
		    	
		    }
		    System.out.println(ans);
		    ExcelReportGenerate.printReport(ans, cN, num, num);
		}
	}
	
	

	public static LocalDateTime convertToLocalDateTime(Date dateToConvert) {
	    return LocalDateTime.ofInstant(
	      dateToConvert.toInstant(), ZoneId.systemDefault());
	}

	public static void verifyddSelectionCheck(String ddCount, String request) throws IOException {
		
		int num=6;
		System.out.println(ddCount);
		ExcelReportGenerate.printReport(ddCount, request, num, num);
	}

	

	public static void exportedValueCheck(String dropdownString, String exportedStringValue) {

		String result = new String();
		if(exportedStringValue.contains(dropdownString)) {
			result="TRUE";
			System.out.println(result);
		}else {
			result="FALSE"+" "+exportedStringValue+" "+dropdownString;
			System.out.println(result);
		}
		
	}

	public static void verifySpecialSort(String result, String request) {
		
		
	}

	}

