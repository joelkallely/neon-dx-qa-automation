package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelHelper {
Sheet sh = null;
	
	
    public void setExcelFile(String sheet)
    {
    	FileInputStream inputFile = null;
		HSSFWorkbook workbook = null;

		try {
			inputFile = new FileInputStream(new File("D:\\auto\\auto_selenium\\check\\Excel Files\\inputData.xls"));
			workbook = new HSSFWorkbook(inputFile);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sh = workbook.getSheet(sheet);
		
		
    }
	public CharSequence getCell(int row,int col){
		CharSequence CellGetContent = "";
	if(sh.getRow(row).getCell(col).getCellType()==Cell.CELL_TYPE_STRING)
	{
    
		CellGetContent = sh.getRow(row).getCell(col).toString();
    
	}
	else if(sh.getRow(row).getCell(col).getCellType()==Cell.CELL_TYPE_NUMERIC)
	{
		double num = sh.getRow(row).getCell(col).getNumericCellValue();
		int n = (int)num;
		CellGetContent = String.valueOf(n);
	}
    System.out.println(CellGetContent);
	//getCell(0,0).getContents();
    return CellGetContent;
    }
    public int numRows()
    {
    	return sh.getPhysicalNumberOfRows();
    }
	
	
    
}

