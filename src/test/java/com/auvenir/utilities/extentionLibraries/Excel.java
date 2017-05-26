package com.auvenir.utilities.extentionLibraries;

import com.auvenir.utilities.GenericService;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import java.io.FileInputStream;

/**
 * Created by huy.huynh on 24/05/2017.
 */
public class Excel {

    /**
     * get all data on given sheet into 2-dimension array
     *
     * @param sheetName sheet which we want to get data
     */
    public static String[][] readExcelSheetData(String sheetName) {
        String data[][] = null;
        try {
            FileInputStream fis = new FileInputStream(GenericService.sTestDataFile);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sheet = wb.getSheet(sheetName);

            //System.out.println("sheetName = " + sheetName);
            int rowCount = sheet.getLastRowNum();
            data = new String[rowCount][sheet.getRow(0).getLastCellNum()];
            for (int i = 1; i <= rowCount; i++) {
                Row row = sheet.getRow(i);
                for (int j = 0; j < row.getLastCellNum(); j++) {
                    data[i - 1][j] = row.getCell(j).getStringCellValue();
                    //System.out.print(row.getCell(j).getStringCellValue() + "/");
                }
                //System.out.println("");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return data;
    }

    /* ===================================================================
     * @author: LAKSHMI BS Description: To read tests data from excel sheet
     * Edited by Doai.Tran
     =================================================================== */
    public static String[] toReadExcelData(String sTestCaseID, String SheetName) {
        String sData[] = null;
        try {
            FileInputStream fis = new FileInputStream(GenericService.sTestDataFile);
            Workbook wb = WorkbookFactory.create(fis);
            Sheet sht = wb.getSheet(SheetName);

            System.out.println(SheetName);
            int iRowNum = sht.getLastRowNum();
            int k = 0;
            for (int i = 1; i <= iRowNum; i++) {
                if (sht.getRow(i).getCell(0).toString().equals(sTestCaseID)) {
                    int iCellNum = sht.getRow(i).getLastCellNum();
                    sData = new String[iCellNum];
                    System.out.println("Dong: " + i);
                    System.out.println("So Cot:" + iCellNum);
                    for (int j = 1; j <= iCellNum; j++) {
                        sData[j] = sht.getRow(i).getCell(j).getStringCellValue();
                        System.out.println(sData[j]);
                    }
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sData;
    }
}
