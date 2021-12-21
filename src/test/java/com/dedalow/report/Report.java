package com.dedalow.report;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;	
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.net.MalformedURLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;
import java.util.logging.FileHandler;
import java.util.logging.Logger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.logging.Level;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.text.StringEscapeUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import com.google.common.io.Files;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.dedalow.SharedDependencies;
import com.dedalow.utils.Utils;
import com.dedalow.RunnerTest;
public class Report {

	private static FileSystem fileSystem = FileSystems.getDefault();
	private static String root = System.getProperty("user.dir") + fileSystem.getSeparator() + "logs";
	private static File rootFile = new File(root);
	private static Properties prop;
	private static Logger logger = Utils.logger();
	private static JsonReport jsonReport = new JsonReport();
	private static SharedDependencies dependencies;
	private static RunnerTest runner = new RunnerTest();
	

	public static void addResults(String featureName, String scenarioName, ArrayList<String> results) {
		TestSuite testSuite = jsonReport.testSuites.get(featureName);
		testSuite =  new TestSuite(featureName);
		
		TestCase testCase = new TestCase(scenarioName, results );
		TestCase testCaseExcel = new TestCase(scenarioName, results);
		testSuite.testCases.put(scenarioName, testCase);
		prop = new Properties();
		try {
			prop.load(new FileInputStream("config.properties"));
			
		} catch (FileNotFoundException e) {
			Report.reportErrors(e.getMessage());
		} catch (IOException e) {
			Report.reportErrors(e.getMessage());
		}

		jsonReport.testSuites.put(featureName, testSuite);
		jsonReport.aLtestSuites.add(testSuite);
		jsonReport.alTestCases.add(testCaseExcel);
		
	}

	public static void reportExcel(File route, ArrayList<String> results, String featureName, String scenarioName) {
		HSSFWorkbook wk = null;
		String result;

		String[] columnsExcel = new String[results.size()+2];
		columnsExcel[0] = "Scenario Name";
		columnsExcel[1] = "Result";

		wk = createExcel(route, featureName, columnsExcel);
		HSSFSheet sheet = wk.getSheet(featureName);

		Row row = sheet.createRow(sheet.getLastRowNum() + 1);
		Cell tc_cell = row.createCell(0);
		tc_cell.setCellValue(scenarioName);

		if (results.size() > 1) {
			if (results.contains("BQ")) {
				result = "BQ";
			}else if (results.contains("KO")) {
				result = "KO";
			} else {
				result = "OK";
			}
			for (int i = 0; i<results.size(); i++) {
				columnsExcel[i+2] = "Iteration: " + (i+1);
				Cell cell = row.createCell(i+2);
				cell.setCellValue(results.get(i));
				cell.setCellStyle(changeColor(results.get(i), wk));
				sheet.autoSizeColumn(i);
			}
		} else {
			result = results.get(0);
		}

		Cell cell = row.createCell(1);
		cell.setCellValue(result);
		cell.setCellStyle(changeColor(result, wk));
		sheet.autoSizeColumn(1);

		if (sheet.getRow(0).getPhysicalNumberOfCells() <= columnsExcel.length) {
			createHeaderExcel(wk, sheet, columnsExcel);
		}

		try {
			FileOutputStream fileOut = new FileOutputStream(
					route + fileSystem.getSeparator() + "ReportResult.xls");
			wk.write(fileOut);
			fileOut.close();
			wk.close();
		} catch (Exception e) {
			Report.reportErrors(e.getMessage());
		}
	}

	public static HSSFWorkbook createExcel(File route, String suiteName, String[] columnsExcel) {
		HSSFWorkbook wk = null;
		try {
			File file = new File(route + fileSystem.getSeparator() + "ReportResult.xls");
			if (file.exists()) {
				FileInputStream fis = new FileInputStream(file);
				 wk = (HSSFWorkbook) WorkbookFactory.create(fis);
				if (fis != null) {
					fis.close();
				}
			} else {
				wk = new HSSFWorkbook();
				HSSFSheet sheet = wk.createSheet(suiteName);
				createHeaderExcel(wk, sheet, columnsExcel);
			}
		} catch (Exception e) {
			Report.reportErrors(e.getMessage());
		}
		return wk;
	}

	public static void createHeaderExcel(HSSFWorkbook wk, HSSFSheet sheet, String[] columnsExcel) {
		Font fontHeader = wk.createFont();
		fontHeader.setBold(true);
		fontHeader.setFontHeightInPoints((short) 11);
		CellStyle styleHeader = wk.createCellStyle();
		styleHeader.setFont(fontHeader);
		Row header = sheet.createRow(0);
		for (int i = 0; i < columnsExcel.length; i++) {
			Cell cellHeader = header.createCell(i);
			cellHeader.setCellValue(columnsExcel[i]);
			cellHeader.setCellStyle(styleHeader);
			sheet.autoSizeColumn(i);
		}
	}

	public static CellStyle changeColor(String result, HSSFWorkbook wk) {
		CellStyle styleResult = wk.createCellStyle();
		styleResult.setFillPattern(FillPatternType.SOLID_FOREGROUND);
		switch (result) {
		case "OK":
			styleResult.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
			return styleResult;
		case "KO":
			styleResult.setFillForegroundColor(IndexedColors.CORAL.getIndex());
			return styleResult;
		default:
			styleResult.setFillForegroundColor(IndexedColors.AQUA.getIndex());
			return styleResult;
		}
	}
	
	public static void reportLog(SharedDependencies dependencies, String msg, String log, int wait) {
		try {
			File route = dependencies.folderTestCase;
			String level = dependencies.level;
			String ScenarioName = dependencies.scenarioName;
			rootFile.mkdirs();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String logPath = route + fileSystem.getSeparator() + "Log_" + ScenarioName + ".log";
			File logFile = new File(logPath);
			FileWriter fw = new FileWriter(logFile, true);
			if (msg != "") {
				switch(log) {
					case "INFO":
						fw.write(df.format(new Date()) + " - " + log + " - " + msg + "\r\n");
						break;
					case "DEBUG":
						if (level.equals("DEBUG")) {
							fw.write(df.format(new Date()) + " - " + log + " - " + msg + "\r\n");
						} else {
							fw.write(df.format(new Date()) + " - INFO - More info changing LOG_LEVEL in confing.properties file\r\n");
						}
						break;
					case "ASYNCHRONOUS":
						if (level.equals("DEBUG")) {
							fw.write(df.format(new Date()) + " - DEBUG - " + msg + "\r\n");
						}
						break;
				}
			}
			
			if (wait > 0) {
				fw.write(df.format(new Date()) + " - " + log + " - " + "Thread sleep " + wait + "ms" + "\r\n");
			}
			
			fw.close();
		} catch (IllegalArgumentException | SecurityException | IOException e) {
			Report.reportErrors(e.getMessage());
		}

	}

	public static void reportLog (SharedDependencies dependencies, String msg, String log, int wait, Status status,
		Boolean screenShot, String request, String response, String debugMsg) {
		try {
						
			File route = dependencies.folderTestCase;
			String ScenarioName = dependencies.scenarioName;
			ExtentTest parentTest = dependencies.parentTest;
			String level = dependencies.level;

			rootFile.mkdirs();
			DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
			String logPath = route + fileSystem.getSeparator() + "Log_" + ScenarioName + ".log";
			File logFile = new File(logPath);
			FileWriter fw = new FileWriter(logFile, true);
			if (!request.equals("") && !response.equals("") && !response.equals("backendAssertion")) {
				parentTest.log(status, request);
				parentTest.log(status, response);
				reportLog(dependencies, msg, log, wait);
			} else if (!request.equals("") && response.equals("backendAssertion")) {
				parentTest.log(status, request);
				reportLog(dependencies, msg, log, wait);
			} else if (request.equals("isCatch")) {
				failedStepReport(msg, level, wait, dependencies, status, debugMsg);
			} else {
				parentTest.log(status, msg);
				if (screenShot == true) {
					capScreenFrequency(dependencies);
				}
				reportLog(dependencies, msg, log, wait);
			}
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
	}

	/**
	 * We check the screenshot field of the config.properties that the user has defined and based on his choice, the screenshots are made or not.
	 * @param dependencies
	 */
	public static void capScreenFrequency(SharedDependencies dependencies) {
		switch(dependencies.screenshot) {
		case "always":
			capScreen(dependencies);
			break;
		case "only":
			List<String> listResult = Arrays.asList("BQ", "KO");
			String result = dependencies.isAfter ? dependencies.captureLog : dependencies.finalResult;
			if (listResult.contains(result)) {
				capScreen(dependencies);
			}
		}
	}

	public static void capScreen(SharedDependencies dependencies) {
		String ScenarioName = dependencies.scenarioName;
		String timeStamp = new SimpleDateFormat("HH.mm.ss.SSS").format(Calendar.getInstance().getTime());
		String name = "";

		if (dependencies.isAfter) {
			name = dependencies.captureLog + "_" + dependencies.scenarioName;
		} else {
			name = dependencies.finalResult + "_" + dependencies.scenarioName;
		}
		TakesScreenshot ts = (TakesScreenshot) dependencies.driver;
		File sourcePath = ts.getScreenshotAs(OutputType.FILE);
		File folderScreen = new File(dependencies.folderTestCase + fileSystem.getSeparator() + "screenshots");
		folderScreen.mkdir();
		String path = folderScreen + fileSystem.getSeparator() + name + "_" + timeStamp + ".png";
		

		File destination = new File(path);

		if (name.contains("BQ") || name.contains("KO")) {
			try {
				String relativePath = path.split(runner.dat)[1].substring(1);
				dependencies.parentTest.addScreenCaptureFromPath(relativePath);
			} catch (IOException e) {
				logger.log(Level.SEVERE, e.getMessage(), e);
			}
		
		}
		try {
			Files.copy(sourcePath, destination);
		} catch (Exception e) {
			logger.severe(e.getMessage());
		}
	}

	

	private static void failedStepReport(String msg, String log, int wait,
		SharedDependencies dependencies, Status status, String debugMsg) throws Exception {
		File route = dependencies.folderTestCase;
		String ScenarioName = dependencies.scenarioName;
		String level = dependencies.level;
		ExtentTest parentTest = dependencies.parentTest;
			
		rootFile.mkdirs();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String logPath = route + fileSystem.getSeparator() + "Log_" + ScenarioName + ".log";
		File logFile = new File(logPath);
		FileWriter fw = new FileWriter(logFile, true);
		
		if (level.equals("INFO")) {
			fw.write(df.format(new Date()) + " - " + "ERROR" + " - " + msg + "\r\n");
			fw.write(df.format(new Date()) + " - " + "INFO" +
			" - " + "More info changing LOG_LEVEL in confing.properties file\r\n");
		} else {
			fw.write(df.format(new Date()) + " - " + "ERROR" + " - " + msg + "\r\n");
			fw.write(df.format(new Date()) + " - " + log + " - " + debugMsg + "\r\n");
		}
		if (wait > 0) {
			fw.write(df.format(new Date()) + " - " + log + " - " + "Thread sleep " + wait + "ms" + "\r\n");
		}
		
		fw.close();

		if (level.equals("INFO")) { 
			msg = StringEscapeUtils.escapeHtml4(msg);
			parentTest.log(status, msg);
		} else {
			debugMsg = StringEscapeUtils.escapeHtml4(debugMsg);
			parentTest.log(status, debugMsg);
		}
		if (!dependencies.isBackend) {
			capScreenFrequency(dependencies);
		}
	}

	public static void reportErrors(String msg) {
		File errorsFolder = new File(System.getProperty("user.dir") + fileSystem.getSeparator() + "Errors");
		errorsFolder.mkdir();
		DateFormat df = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		String logPath = System.getProperty("user.dir") + fileSystem.getSeparator() + "Errors"
		+ fileSystem.getSeparator() + "Errors " + runner.dat + ".log";
		File logFile = new File(logPath);
		try {
			FileWriter fw = new FileWriter(logFile, true);
			fw.write(df.format(new Date()) + " - " + "ERROR" + " - " + "\n" + msg + "\r\n");
			fw.close();
			logger.severe("\n" + msg);
		} catch (Exception e) {
			logger.severe("Error creating errors file");
		}
	}
}
