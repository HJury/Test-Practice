package util;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelUtils {
   private static XSSFWorkbook workbook;

    static {
        try {
            workbook = new XSSFWorkbook(System.getProperty("user.dir") + "\\excel\\newCampaign.xlsx");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }

    private static XSSFSheet sheet1 = workbook.getSheet("Sheet1");

    public static XSSFWorkbook getWorkbook() {
        return workbook;
    }

    public static XSSFSheet getSheet1() {
        return sheet1;
    }

    static public String getValue(String name){
        for(int i=0; i< sheet1.getPhysicalNumberOfRows();i++) {
            if(sheet1.getRow(i).getCell(0).getStringCellValue().equals(name)){
                sheet1.getRow(i).getCell(1).setCellType(CellType.STRING);
                return (sheet1.getRow(i).getCell(1).getStringCellValue());

            }
        }
        return "";
    }
    static public String getLink(String name){
        for(int i=0; i< sheet1.getPhysicalNumberOfRows();i++) {
            if(sheet1.getRow(i).getCell(0).getStringCellValue().equals(name)){
                sheet1.getRow(i).getCell(1).setCellType(CellType.STRING);
                return (sheet1.getRow(i).getCell(1).getStringCellValue());

            }
        }
        return "";
    }
}
