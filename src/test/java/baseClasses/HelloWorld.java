package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
public class HelloWorld {

	
	 
	static Sheet sh = null;
	
	public static void main(String args[]) throws Exception
	{
	
		System.out.println("hello");
		//setExcelFile("D:\\auto\\auto_selenium\\check\\Excel Files\\productPage.xls","Sheet1");
		//getCell(1,1);

	}
	
    public static void setExcelFile(String path, String sheet)
    {     
    	FileInputStream inputFile = null;
		HSSFWorkbook workbook = null;
		String filePath = "D:\\auto\\auto_selenium\\check\\Excel Files\\productPage.xls";

		try {
			inputFile = new FileInputStream(new File(path));
			workbook = new HSSFWorkbook(inputFile);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sh = workbook.getSheet(sheet);
		
		
    }
    public static void getCell(int col,int row){
    String CellGetContent = sh.getRow(1).getCell(1).toString();
	//getCell(0,0).getContents();
    System.out.println(CellGetContent);
    }
	
	
	

    }

