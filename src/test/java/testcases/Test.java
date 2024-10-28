package testcases;

import utilities.ExcelReader;

public class Test {

	public static void main(String[] args) {

		ExcelReader excel = new ExcelReader(
				System.getProperty("user.dir")+"/src/test/resources/TestData/TestData.xlsx");

		String sheetName = "TestData";
		// ExcelReader datatable = null;

		// datatable = new ExcelReader(
		// "C:\\CM3.0\\app\\test\\Framework\\AutomationBvt\\src\\config\\xlfiles\\Controller.xlsx");

		/*
		 * for (int col = 0; col < reader.getColumnCount("TC5"); col++) {
		 * System.out.println(reader.getCellData("TC5", col, 1)); }
		 */
		
		//System.out.println(excel.getCellData(sheetName, 2, 2));

		int rows = excel.getRowCount(sheetName);
		int columns = excel.getColumnCount(sheetName);

		for (int i = 2; i < rows; i++) {
			for (int j = 0; j < columns; j++) {
				System.out.println(excel.getCellData(sheetName, j, i));
			}
		}

		// System.out.println(excel.getRowCount("TestData"));

		/// System.out.println(excel.getCellData("TestData, 0, 1"));

	}

}
