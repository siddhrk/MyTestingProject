package utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.Reporter;

public class Utility1 {

	static Sheet MySheet;

	public static String readDataFromExcel(int rowIndex, int columnIndex)
			throws EncryptedDocumentException, IOException {
		
		FileInputStream MyFile = new FileInputStream("D:\\ExcelSheet_apachepoi\\sidZerodha.xlsx");
		MySheet = WorkbookFactory.create(MyFile).getSheet("Sheet1");
		String value = MySheet.getRow(rowIndex).getCell(columnIndex).getStringCellValue();
		return value;

	}

	public static void takesScreenshot(WebDriver driver, int TCID) throws IOException {

		File source = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		File dest = new File("D:\\Selenium Screenshots\\TC" + TCID + "Screenshot.png");
		FileHandler.copy(source, dest);
		Reporter.log("screenshot taken for TC " +TCID, true);

	}
}
