package DDT;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class FetchSingleDataFromExcelFile {

	public static void main(String[] args) throws Throwable {
		FileInputStream fis =new FileInputStream("./src/test/resources/Test_Data.xlsx");
		
		Workbook book= WorkbookFactory.create(fis);
		Sheet sheet = book.getSheet("Sheet1");
		Row row = sheet.getRow(2);
		Cell cell = row.getCell(2);
		String data = cell.getStringCellValue();
		System.out.println(data);
		double excelData = cell.getNumericCellValue();
		
		//DataFormatter
		DataFormatter format = new DataFormatter();
		String excelData1 = format.formatCellValue(cell);
		System.out.println(excelData1);
	}

}
