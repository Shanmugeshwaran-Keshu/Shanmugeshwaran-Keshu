package OptimisedCASBCode;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.ss.usermodel.HorizontalAlignment;
import org.apache.poi.ss.usermodel.VerticalAlignment;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelReportGenerate {
	
	static int index=1;
	public static void printReport(String temp, String columnName, int i, int sheet2) throws IOException {
		
//		HashMap<Integer, String> hm = new HashMap<Integer, String>();
//		hm.put(0, "(SORT)");
//		hm.put(2, "(SERACH)");
		File file = new File("C:\\Users\\shanmug-12474\\Desktop\\Cloud Protection Report.xlsx");
		FileInputStream fpis = new FileInputStream(file);
		
		XSSFWorkbook wbook = new XSSFWorkbook(fpis);
        XSSFSheet sheet = wbook.getSheetAt(0);
        sheet.setColumnWidth(i+0, 5000);
        sheet.setColumnWidth(i+1, 5000);
        
		XSSFCellStyle cellStyle = wbook.createCellStyle();
		cellStyle.setWrapText(true);
		cellStyle.setAlignment(HorizontalAlignment.CENTER);
		cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
		
		XSSFRow row_0 = sheet.createRow(0);
		XSSFRow row = sheet.createRow(index++);
		
		XSSFCell cell_1 = row_0.createCell(0);
		XSSFCell cell_2 = row_0.createCell(1);
		
		XSSFCell cell1 = row.createCell(0);
		XSSFCell cell2 = row.createCell(1);
		
		row_0.setHeight((short) 1500);
		cell_1.setCellStyle(cellStyle);
		cell_1.setCellValue("COLUMN NAME"+" ");
		cell_2.setCellStyle(cellStyle);
		cell_2.setCellValue("RESULT"+" ");
		
		row.setHeight((short) 1500);
		cell1.setCellStyle(cellStyle);
		cell1.setCellValue(columnName);
		cell2.setCellStyle(cellStyle);
		cell2.setCellValue(temp);
		
		FileOutputStream outputStream = new FileOutputStream(file);
		wbook.write(outputStream);
		wbook.close();
	}

}
