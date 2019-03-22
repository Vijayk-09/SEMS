package generics;

import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class Excel {

	public static String getCellValue(String xlPath, String sheet, int row, int cell) {

		String v = "";
		try {
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			v = wb.getSheet(sheet).getRow(row).getCell(cell).toString();
		} catch (Exception e) {

		}
		
		return v;
	}

	public static int getRowCount(String xlPath, String sheet) {
		int rc = 0;
		try {
			FileInputStream fis = new FileInputStream(xlPath);
			Workbook wb = WorkbookFactory.create(fis);
			rc = wb.getSheet(sheet).getLastRowNum();
		} catch (Exception e) {

		}
		return rc;
	}
}