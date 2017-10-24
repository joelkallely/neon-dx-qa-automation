package baseClasses;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

public class ExcelHelper {
Sheet sh = null;
FileInputStream inputFile = null;
HSSFWorkbook workbook = null;
String file = "";	
	
    public void setExcelFile(String filename, String sheet)
    {
    

		try {
			workbook = new HSSFWorkbook(new FileInputStream(new File("ExcelFiles\\"+filename+".xls")));
			file = "ExcelFiles\\"+filename+".xls";
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
    return CellGetContent;
    }
    public int numRows()
    {
    	return sh.getPhysicalNumberOfRows();
    }
    
	
	
    
}

