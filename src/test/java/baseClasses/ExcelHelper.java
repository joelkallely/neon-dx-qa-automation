package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class ExcelHelper {
Sheet sh = null;
FileInputStream inputFile = null;
HSSFWorkbook workbook = null;
String file = "";	
	
    public void setExcelFile(String path, String sheet)
    {
    	
		System.out.println(path);
		file="D:\\GIT Project\\selenium.automation\\ExcelFiles\\"+path;

		try {
			inputFile = new FileInputStream(new File(new File(".").getCanonicalPath()+"\\ExcelFiles\\"+path));
			//inputFile = new FileInputStream();
			workbook = new HSSFWorkbook(inputFile);

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		sh = workbook.getSheet(sheet);
		
    }
    public void setCell(int r,int c,String val) throws IOException{
    	Row row = sh.getRow(r);
        Cell cell = row.getCell(c);
        cell.setCellType(Cell.CELL_TYPE_STRING);
        cell.setCellValue(val);
        FileOutputStream outFile =new FileOutputStream(new File(file));  //Creating new file
        workbook.write(outFile);   //printing the data in the new file
        outFile.close();           //closing the new file
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

