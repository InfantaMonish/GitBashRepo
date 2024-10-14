package DDT;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class InsertDataToExcelFile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/Test_Data.xlsx");

		Workbook book = WorkbookFactory.create(fis);
			
		Sheet sheet = book.getSheet("Sheet1");
			
		Row row = sheet.createRow(6);

		Cell cell = row.createCell(6);
			
		cell.setCellValue("QSPIDERS");

		FileOutputStream fos = new FileOutputStream("./src/test/resources/Test_Data.xlsx");
		book.write(fos);
		book.close();

			
			}



}
