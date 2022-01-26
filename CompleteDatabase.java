package OptimisedCASBCode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CompleteDatabase extends ConsoleControl {

	public static HashMap<Integer, String> generaldatabase() {
		
		HashMap<Integer, String> generalLists = new HashMap<Integer, String>();
		generalLists.put(1,"//a[text()='Recent Requests']");
		generalLists.put(2, "//a[text()='Recent Plain HTTP Requests']");
		generalLists.put(3,"//a[text()='Recent Connect Requests']");
		generalLists.put(4, "//a[text()='Recent Failed Requests']");
		generalLists.put(5,"//a[text()='Top Cloud Apps']");
		generalLists.put(6, "//a[text()='Top Actors']");
		generalLists.put(7,"//a[text()='Browser Usage']");
		generalLists.put(8, "//a[text()='Top Actors x Cloud Apps']");
		return generalLists;
	}

	public static HashMap<Integer, String> applicationInsightsdatabase() {
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1,"//a[text()='Cloud Apps Accessed']");
		hm.put(2, "//a[text()='HTTP Cloud Apps Accessed']");
		hm.put(3, "//a[text()='Cloud Apps Categories']");
		hm.put(4, "//a[text()='Low Reputed Apps Request']");
		hm.put(5, "//a[text()='Low Reputed Apps']");
		return hm;
	}

	public static HashMap<Integer, String> shadowCloudAppsdatabase() {
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "//a[text()='Recent Sanctioned Apps Request']");
		hm.put(2, "//a[text()='Recent Shadow Apps Request']");
		hm.put(3, "//a[text()='Shadow App Discovery']");
		hm.put(4, "//a[text()='Top Actors Accessing Shadow Apps']");
		return hm;
	}

	public static HashMap<Integer, String> bannedCloudAppsdatabase() {
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "//a[text()='Recent Banned Apps Requests']");
		hm.put(2, "//a[text()='Banned Cloud App Accesses']");
		hm.put(3, "//a[text()='Top Actors Accessing Banned Apps']");
		return hm;
	}

	public static HashMap<Integer, String> fileUploadListsdatabase() {
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "//a[text()='All Upload Requests']");
		hm.put(2, "//a[text()='Sharepoint/OneDrive Upload Requests']");
		hm.put(3, "//a[text()='Office 365 Upload Requests']");
		hm.put(4, "//a[text()='Zoho Apps Upload Requests']");
		hm.put(5, "//a[text()='Google Apps Upload Requests']");
		hm.put(6, "//a[text()='Dropbox Upload Requests']");
		hm.put(7, "//a[text()='Box Upload Requests']");
		hm.put(8, "//a[text()='Yahoo Upload Requests']");
		hm.put(9, "//a[text()='Multipart Requests']");
		return hm;
	}

	public static HashMap<Integer, String> zohoFileUploadListsdatabase() {
		
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1, "//a[text()='Zoho Apps Upload Requests']");
		hm.put(2, "//a[text()='WorkDrive Upload Requests']");
		hm.put(3, "//a[text()='Writer Upload Requests']");
		hm.put(4, "//a[text()='Sheet Upload Requests']");
		hm.put(5, "//a[text()='Show Upload Requests']");
		hm.put(6, "//a[text()='Projects Upload Requests']");
		hm.put(7, "//a[text()='Mail Upload Requests']");
		hm.put(8, "//a[text()='Cliq Upload Requests']");
		hm.put(9, "//a[text()='Common Upload Requests']");
		return hm;
	}

	public static List<String> periodDatabase() {
		
		List<String> list = new ArrayList<String>();
		 list.add("Today");
		 list.add("Last 7 Days");
		 list.add("Last 15 Days");
		 list.add("Last 30 Days");
		 list.add("Last 24 Hours");
		 list.add("Previous Day");
		 list.add("This Week");
		 list.add("Previous Week");
		 list.add("Previous Month");
		 list.add("This Month");
		 list.add("Last 60 Minutes");
		 list.add("Previous Hour");
		 list.add("Custom Range");
		 
		return list;
	}
	
	public static HashMap<Integer,String> dropdownCountDatabase(){
		
		HashMap<Integer,String> hm = new HashMap<Integer,String>();
		hm.put(1, "25");
		hm.put(2, "50");
		hm.put(3, "100");
		hm.put(4, "200");
		hm.put(5, "400");
		hm.put(6, "800");

		return hm;	
	}

	public static HashMap<String, String> columnListDatabase() {
		
		HashMap<String, String> list = new HashMap<String, String>();
		list.put("CLOUD APP","cloud_app");
		list.put("ACTOR","actor");
		list.put("TIME GENERATED","time_generated");
		list.put("APP CATEGORY","app_category");
		list.put("APP REPUTATION","app_reputation");
		list.put("URI","uri");
		list.put("METHOD","method");
		list.put("UPLOAD SIZE","upload_size");
		list.put("DOWNLOAD SIZE", "download_size");
		list.put("BROWSER", "user_agent");
		list.put("USER AGENT","user_agent_original");
		list.put("FAILURE REASON", "failure_reason");
		list.put("RESPONSE CODE", "response_code");
		list.put("RESPONSE TEXT", "response_text");
		list.put("COUNT", "count");
		list.put("TOTAL SIZE","total_size");
		list.put("CONTENT TYPE","content_type");
		list.put("CONTENT RANGE","content_range");
		list.put("FILE NAME", "file_name");
		list.put("UPLOAD REQUEST SIZE","upload_request_size");
		return list;
	}

	public static HashMap<Integer, String> exportDropdownList() {
		HashMap<Integer, String> hm = new HashMap<Integer, String>();
		hm.put(1,"csv");
		hm.put(2, "pdf");
		hm.put(3,"xls");
		hm.put(4, "html");
		return hm;
	}

	public static HashMap<String, String> searchListDatabase() {
		HashMap<String, String> list = new HashMap<String, String>();
		list.put("WS_HOST","cloud_app");
		list.put("CLIENT_HOST_NAME","actor");
		list.put("REQUEST_URI","uri");
		list.put("REQUEST_METHOD","method");
		list.put("EXTRA_NCHAR_1", "user_agent");
		list.put("CLIENT_FAILURE_REASON", "failure_reason");
		list.put("RESPONSE_STATUS_CODE_AS_TEXT", "response_text");	
		list.put("REQUEST_HEADERS_CONTENT_TYPE","content_type");
		list.put("REQUEST_HEADERS_CONTENT_RANGE","content_range");
		list.put("EXTRA_NCHAR_3", "file_name");
		return list;
	}
	
	

}
