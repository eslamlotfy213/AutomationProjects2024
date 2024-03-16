package DataDriven;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;

public class GetDataFromExcel {


    DataFormatter formatter = new DataFormatter();

    public Object[][] getData(String sheetName, String pathFile) throws IOException {

        FileInputStream fis = new FileInputStream(pathFile);
        XSSFWorkbook workbook=new XSSFWorkbook(fis);
        XSSFSheet sheet=workbook.getSheet(sheetName);
        int rowCount = sheet.getPhysicalNumberOfRows();
        XSSFRow row = sheet.getRow(0);
        int colcount = row.getLastCellNum();
        Object data[][] = new Object[rowCount-1][colcount];
        for (int i = 0; i < rowCount-1; i++) {
            row= sheet.getRow(i+1);
            for (int j = 0; j < colcount; j++) {
                XSSFCell cell = row.getCell(j);
                data[i][j]= formatter.formatCellValue(cell);
            }
        }
        return data;
    }




}
