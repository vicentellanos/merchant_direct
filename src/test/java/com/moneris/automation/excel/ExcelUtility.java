package com.moneris.automation.excel;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;



public class ExcelUtility {
	private static final String FILE_NAME = "C:\\Users\\vicente.llanos\\eclipse-workspace\\merchant_direct\\testdata_credentials.xlsx";
	
	private static final String CREATE_USER_FILENAME = System.getProperty("user.dir")+"\\Create Users - Test - Copy.xlsx";
	
	public static UserCredentials excel_getCredentials(int row) {
		UserCredentials userCredentials = null;
		
		try {
			
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			
			Row excelRow = datatypeSheet.getRow(row);
			
			String username = excelRow.getCell(0).getStringCellValue();
			String password = excelRow.getCell(1).getStringCellValue();
			
			userCredentials = new UserCredentials(username, password);
			
			workbook.close();
			excelFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userCredentials;
	}
	
	public static UserCredentials excel_getCredentials(String fileName, int excel_row, int usernameCol, int passwordCol) {
		UserCredentials userCredentials = null;
		
		try {
			final String FILE_NAME = System.getProperty("user.dir")+"\\"+fileName;
			
			FileInputStream excelFile = new FileInputStream(new File(FILE_NAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			
			Row excelRow = datatypeSheet.getRow(excel_row);
			
			String username = excelRow.getCell(usernameCol) != null? excelRow.getCell(usernameCol).getStringCellValue() : null;
			String password = excelRow.getCell(passwordCol) != null?  excelRow.getCell(passwordCol).getStringCellValue() : null;
			
			userCredentials = new UserCredentials(username, password);
			
			workbook.close();
			excelFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userCredentials;
	}
	
	public static String excel_getUserId(int row) {
		String userId = null;
		
		try {
			FileInputStream excelFile = new FileInputStream(new File(CREATE_USER_FILENAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			
			Row excelRow = datatypeSheet.getRow(row);
			
			userId = excelRow.getCell(0).getStringCellValue();
			
			workbook.close();
			excelFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return userId;
	}
	
	public static String excel_getPasswordEmailAddress(int row) {
		String passwordEmailAddress = null;
		
		try {
			FileInputStream excelFile = new FileInputStream(new File(CREATE_USER_FILENAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			
			Row excelRow = datatypeSheet.getRow(row);
			
			passwordEmailAddress = excelRow.getCell(1).getStringCellValue();
			
			workbook.close();
			excelFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return passwordEmailAddress;
	}
	
	public static HashMap<Integer, UserInformation> convertExcelCreateUsersToHashMap() {
		HashMap<Integer, UserInformation> createUserInfo = new HashMap<Integer, UserInformation>();
		
		try {
			FileInputStream excelFile = new FileInputStream(new File(CREATE_USER_FILENAME));
			Workbook workbook = new XSSFWorkbook(excelFile);
			Sheet datatypeSheet = workbook.getSheetAt(0);
			
			for (int i=1; i < datatypeSheet.getPhysicalNumberOfRows(); i ++) {
				Row excelRow = datatypeSheet.getRow(i);
				
				UserInformation userInfo = new UserInformation();
				userInfo.setUserID(excelRow.getCell(0).getStringCellValue());
				userInfo.setPasswordEmailAddress(excelRow.getCell(1) != null? excelRow.getCell(1).getStringCellValue():null);
				userInfo.setNotificationEmailAddress(excelRow.getCell(2) != null? excelRow.getCell(2).getStringCellValue():null);
				userInfo.setUserName(excelRow.getCell(3) != null? excelRow.getCell(3).getStringCellValue() : null);
				userInfo.setUserType(excelRow.getCell(4) != null ? excelRow.getCell(4).getStringCellValue() : null);
				
				if (excelRow.getCell(5) != null) 
					excelRow.getCell(5).setCellType(CellType.STRING);
				
				String customerID = excelRow.getCell(5) != null ? excelRow.getCell(5).getStringCellValue():null;
				userInfo.setCustomerID(customerID);
				
				userInfo.setSalesRepCode(excelRow.getCell(6) != null? excelRow.getCell(6).getStringCellValue() : null);
				userInfo.setCustomerType(excelRow.getCell(7) != null? excelRow.getCell(7).getStringCellValue():null);
				userInfo.setMessageCentreAccess(excelRow.getCell(8) != null? excelRow.getCell(8).getStringCellValue(): null);
				userInfo.setOutgoingMessagesAccess(excelRow.getCell(9) != null? excelRow.getCell(9).getStringCellValue(): null);
				userInfo.setCardholderDataAccess(excelRow.getCell(10)!=null ? excelRow.getCell(10).getStringCellValue(): null);
				userInfo.setReportsAccess(excelRow.getCell(11) != null? excelRow.getCell(11).getStringCellValue() : null);
				userInfo.setRewardsManagement(excelRow.getCell(12) != null? excelRow.getCell(12).getStringCellValue() : null);
				
				if (excelRow.getCell(13) != null) 
					excelRow.getCell(13).setCellType(CellType.STRING);
				
				String additionalCustNums = excelRow.getCell(13) != null ? excelRow.getCell(13).getStringCellValue():null;
				userInfo.setAdditionalCustomerNumbers(additionalCustNums);
				
				userInfo.setTemporaryPassword(excelRow.getCell(14) != null ? excelRow.getCell(14).getStringCellValue():null);
				
				userInfo.setNewPassword(excelRow.getCell(15) != null ? excelRow.getCell(15).getStringCellValue():null);
				
				createUserInfo.put(i, userInfo);
			}
			workbook.close();
			excelFile.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return createUserInfo;
	}
	
	public static void writeTempPasswordToExcel(String tempPassword, int row_index) {
		
		try {
			FileInputStream excelFileInputStream = new FileInputStream(new File(CREATE_USER_FILENAME));
			Workbook workbook = new XSSFWorkbook(excelFileInputStream);
			Sheet sheet = workbook.getSheetAt(0);
			
			Row firstExcelRow = sheet.getRow(0);
			Cell columnHeaderCell = firstExcelRow.getCell(14);
						
			if(columnHeaderCell == null) {
				firstExcelRow.createCell(14);
			}
			firstExcelRow.getCell(14).setCellValue("Temporary Password");
	
			Row excelRow = sheet.getRow(row_index);
			
			Cell temporaryPwCell = excelRow.getCell(14);
			
			if(temporaryPwCell == null) {
				excelRow.createCell(14);
			}
			excelRow.getCell(14).setCellValue(tempPassword);
			
			excelFileInputStream.close();
			FileOutputStream excelFileOutputStream = new FileOutputStream(new File(CREATE_USER_FILENAME));
			workbook.write(excelFileOutputStream);
			workbook.close();
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
}
