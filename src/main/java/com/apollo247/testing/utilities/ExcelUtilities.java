package com.apollo247.testing.utilities;

import java.io.FileInputStream;
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
            throw new RuntimeException("Sheet '" + sheetName + "' not found");
        }

        Row header = sheet.getRow(0);
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
                            value = cell.getStringCellValue();
                            break;

                        case NUMERIC:
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

    public List<Map<String, String>> getAccountModuleData(String sheetName) throws Exception {
        return getExcelDataAsMap(ACCOUNT_FILE_PATH, sheetName);
    }
}