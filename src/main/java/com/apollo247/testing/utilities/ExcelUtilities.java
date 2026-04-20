package com.apollo247.testing.utilities;

import java.io.FileInputStream;
<<<<<<< HEAD
import java.text.SimpleDateFormat;
import java.util.*;

import org.apache.poi.ss.usermodel.*;

public class ExcelUtilities {

    private static final String ACCOUNT_FILE_PATH =
        "./src/test/resources/testdata/AccountTestData.xlsx";

    public List<Map<String, String>> getExcelDataAsMap(
            String filePath, String sheetName) throws Exception {

        List<Map<String, String>> list = new ArrayList<>();

        FileInputStream fis = new FileInputStream(filePath);
        Workbook wb = WorkbookFactory.create(fis);
        Sheet sheet = wb.getSheet(sheetName);

        if (sheet == null) {
            throw new RuntimeException(
                "❌ Sheet '" + sheetName + "' not found in: " + filePath
            );
        }

        Row header = sheet.getRow(0);

        // ✅ Date formatter
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {
            Row row = sheet.getRow(i);
            if (row == null) continue;

            Map<String, String> map = new HashMap<>();

            for (int j = 0; j < header.getLastCellNum(); j++) {
                String key = header.getCell(j).toString().trim();
                Cell cell = row.getCell(j);

                String value = "";

                if (cell != null) {
                    switch (cell.getCellType()) {

                        case STRING:
                            value = cell.getStringCellValue().trim();
                            break;

                        case NUMERIC:
                            // ✅ Handle DATE properly
                            if (DateUtil.isCellDateFormatted(cell)) {
                                value = sdf.format(cell.getDateCellValue());
                            } else {
                                value = String.valueOf((long) cell.getNumericCellValue());
                            }
                            break;

                        case BOOLEAN:
                            value = String.valueOf(cell.getBooleanCellValue());
                            break;

                        case FORMULA:
                            value = cell.toString();
                            break;

                        default:
                            value = "";
                            break;
                    }
                }

                map.put(key, value);
            }
            list.add(map);
        }

        wb.close();
        fis.close();
        return list;
    }

    public List<Map<String, String>> getAccountModuleData(
            String sheetName) throws Exception {
        return getExcelDataAsMap(ACCOUNT_FILE_PATH, sheetName);
    }
}
=======
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.WebDriver;

public class ExcelUtilities {

	public List<Map<String, String>> getExcelDataAsMap(String sheetName) throws Exception {

		List<Map<String, String>> list = new ArrayList<>();

		String FILE_PATH = "";

		FileInputStream fis = new FileInputStream(FILE_PATH);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheet = wb.getSheet(sheetName);

		Row header = sheet.getRow(0);

		for (int i = 1; i <= sheet.getLastRowNum(); i++) {

			Row row = sheet.getRow(i);
			Map<String, String> map = new HashMap<>();

			for (int j = 0; j < row.getLastCellNum(); j++) {
				map.put(header.getCell(j).toString(), row.getCell(j).toString());
			}

			list.add(map);
		}

		return list;
	}

}
>>>>>>> e0e53877cf1731a16176a9c23f5898a1a35ce501
