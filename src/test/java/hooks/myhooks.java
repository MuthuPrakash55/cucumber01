package hooks;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import factory.driverfactory;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

public class myhooks {

	WebDriver driver;
	
	@Before
	public void getapp() {
		driverfactory.intializebrowser("chrome");
		driver=driverfactory.getdriver();
		driver.get("https://letcode.in/");
		driver.manage().window().maximize();
	}
	@After
	public void sreenshot(Scenario scenario) {
		byte[] src=((TakesScreenshot)driver).getScreenshotAs(OutputType.BYTES);
		scenario.attach(src, "image/png", scenario.getName());
	}
	
	public static String getxpath(String fieldname) throws Exception {
		File file =new File("./src/test/resources/datasheet.xlsx");
		FileInputStream stream=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(stream);
		XSSFSheet sh=wb.getSheet("sheet1");
		DataFormatter df=new DataFormatter();
		
		for(int i=1;i<=sh.getLastRowNum();i++) {
			if(fieldname.equals(df.formatCellValue(sh.getRow(i).getCell(0)))) {
				return df.formatCellValue(sh.getRow(i).getCell(1));
			}
			
		}
		return null;
	}
	public static String getdata(String fieldname) throws Exception {
		File file =new File("./src/test/resources/datasheet.xlsx");
		FileInputStream stream=new FileInputStream(file);
		XSSFWorkbook wb=new XSSFWorkbook(stream);
		XSSFSheet sh=wb.getSheet("sheet1");
		DataFormatter df=new DataFormatter();
		
		for(int i=1;i<=sh.getLastRowNum();i++) {
			if(fieldname.equals(df.formatCellValue(sh.getRow(i).getCell(0)))) {
				return df.formatCellValue(sh.getRow(i).getCell(2));
			}
			
		}
		return null;
	}
}
