package com.dedalow.regresionCustomAction;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.concurrent.TimeUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.api.Test;
import com.dedalow.ContainerManager;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Throwables;
import com.dedalow.utils.Utils;
import com.dedalow.utils.DriverInit;
import com.dedalow.utils.Constant;
import com.dedalow.report.ExtentHtml;
import com.dedalow.report.Report;
import com.dedalow.Launcher;

import com.aventstack.extentreports.Status;


import com.dedalow.actions.ActionOracleAction;
import com.dedalow.customActions.OracleBefore;
import com.dedalow.customActions.OracleExecute;
import com.dedalow.customActions.OracleAfter;

public class Test_PSFUEND02E0116 {
   
    private static Class reflectiveClass;
    private static Launcher launcher = new Launcher();
    public static DriverInit driverInit = new DriverInit();
    public static Constant constant = launcher.constant;
    public static String suiteName = "RegresionCustomAction";
    public static String caseName = Test_PSFUEND02E0116.class.getSimpleName();
    public static String modelDocumentation = "OracleAndReportHTML";
    public static WebDriver driver;

    public static Properties prop;
    public static String level;
    public static String handler;
    public static String finalResult = "OK";
    public static File folderTestCase;
    public static File folderDownloads;
    public static HashMap<String, String> excelSheet;

    
    private static RegresionCustomActionBeforeEach2 regresionCustomActionBeforeEach2;
	private static ActionOracleAction actionOracleAction;
	private static OracleBefore oracleBefore;
	private static OracleExecute oracleExecute;
	private static OracleAfter oracleAfter;
    
    
	@BeforeAll
    public static void checkDocker() {
        try {
            Runtime.getRuntime().exec("docker --version");
        } catch (IOException e) {
            constant.logger.severe("Cannot run program \"docker\": CreateProcess error=2, System can not find docker installed.");
        }
    }

    @BeforeEach
    public void beforeEach() throws Exception {
        try {
            if (constant.excelSheets == null) {
                Report.reportErrors(suiteName + " - " + caseName + ": Error reading from Excel");
            } else {
                excelSheet = constant.excelSheets.get(constant.iterationExcel);
                constant.initialize = new ExtentHtml(suiteName, caseName+ " (" 
                + ++constant.iterationExcel  + " of " + constant.excelSheets.size() + ")", modelDocumentation);
                constant.test = constant.initialize.getTest();
            }
            driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", constant.contextsDriver);
                Report.reportLog(reflectiveClass, "Dataset row " + constant.iterationExcel + " start execution: " + excelSheet, "INFO", 0, Status.PASS, false, "", "", null);
        	regresionCustomActionBeforeEach2.doBeforeEach2();
        } catch (AssertionError | Exception e) {
            Report.reportErrors(e.getMessage());
			finalResult = "BQ";
            Report.reportLog(reflectiveClass, e.getMessage(), level, 0, Status.FAIL, true, "isCatch", "", Throwables.getStackTraceAsString(e));
            throw new Exception(e);
		}
    }

    public void before() throws Exception {
        try {
            
            
            Report.reportLog(reflectiveClass, "Before of execution", "INFO", 0, Status.PASS, false, "", "", null);
            
			
	oracleBefore.doOracleBefore(reflectiveClass);
            constant.test.log(Status.PASS, "OracleBefore completed");
            Report.capScreen(reflectiveClass);
            

        } catch (AssertionError | Exception e) {
            finalResult = "BQ";
            throw new Exception(e);
        }
    }

    @ParameterizedTest
	@MethodSource("setUpExcel")
	@DisplayName("Test_PSFUEND02E0116")
	public void test() throws Exception {
        try {
            before();
            
            
            Report.reportLog(reflectiveClass, "Start of execution", "INFO", 0, Status.PASS, false, "", "", null);
            
			
	oracleExecute.doOracleExecute(reflectiveClass);
            constant.test.log(Status.PASS, "OracleExecute completed");
            Report.capScreen(reflectiveClass);
            

			actionOracleAction.doActionOracleAction();
            Report.reportLog(reflectiveClass, "Action ActionOracleAction finished","INFO", 0, Status.PASS, false, "", "", null);
            
            
        } catch (AssertionError | Exception e) {
            Report.reportErrors(e.getMessage());
            if (finalResult != "BQ") {
				finalResult = "KO";
			}
            Report.reportLog(reflectiveClass, e.getMessage(), level, 0, Status.FAIL, true, "isCatch", "", Throwables.getStackTraceAsString(e));
            throw new Exception(e);
        }
    }

    public void after() {
        constant.isAfter = true;
        constant.isBackend = false;
        try {
            
            
            Report.reportLog(reflectiveClass, "After of execution", "INFO", 0, Status.PASS, false, "", "", null);
            
			
	oracleAfter.doOracleAfter(reflectiveClass);
            constant.test.log(Status.PASS, "OracleAfter completed");
            Report.capScreen(reflectiveClass);
            

        } catch (AssertionError | Exception e) {
            Report.reportErrors(e.getMessage());
			constant.captureLog = "KO";
			constant.afterResult = "not succesfully";
            Report.reportLog(reflectiveClass, e.getMessage(), level, 0, Status.WARNING, true, "isCatch", "", Throwables.getStackTraceAsString(e));
        }
    }

    @AfterEach
    public void afterEach()  {
        boolean screenShot = true;
        after();
        if (finalResult == "OK") {
            Report.reportLog(reflectiveClass, "Result on Test_PSFUEND02E0116 row" + constant.iterationExcel + ": " + finalResult, "INFO", 0, Status.PASS, false, "", "", null);
        } else {
            Report.reportLog(reflectiveClass, "Result on Test_PSFUEND02E0116 row" + constant.iterationExcel + ": " + finalResult, "INFO", 0, Status.FAIL, false, "", "", null);
        }
        constant.logger.info("Result on Test_PSFUEND02E0116 row" + constant.iterationExcel + ": " + finalResult);
		constant.logger.info("After execution finished: " + constant.afterResult);
        Utils.tearDown(reflectiveClass);
		finalResult = "OK";
		constant.afterResult = "succesfully";
		constant.captureLog = "OK";
		constant.isAfter = false;
        if (constant.iterationExcel == constant.excelSheets.size()) {
            Utils.finalReports(reflectiveClass, screenShot);
            constant.initialize.flush();
        } else {
            constant.initialize.flush();
        }
        
		ContainerManager.stopContainer(finalResult, caseName);
    }
    
    private static ArrayList<HashMap<String, String>> setUpExcel() throws Exception {
        setUp();
        constant.excelSheets = constant.sheets.get("Login");
        return constant.excelSheets;
    }
    
	public static void setUp() throws Exception{
        try{
            constant.defaultValues();
            constant.folderTestSuite = new File(constant.folderLogs + constant.fileSystem.getSeparator() + suiteName);
            constant.folderTestSuite.mkdirs();
            folderTestCase = new File(constant.folderTestSuite + constant.fileSystem.getSeparator() + caseName);
            folderTestCase.mkdirs();
            folderDownloads = new File(folderTestCase + constant.fileSystem.getSeparator() + "files");
            folderDownloads.mkdirs();
            prop = Utils.getConfigProperties();
            level = prop.getProperty("LOG_LEVEL");
            Utils.setEncoding();
		constant.sheets = Utils.readExcel(prop.getProperty("DATASET"));
        } catch (Exception e) {
            e.printStackTrace();
            Report.reportErrors(e.getMessage());
            throw new Exception(e);
        }
    }

    public static WebDriver setUpEnvironment(File folderDownloads, Properties prop,
        String nameDriver, Map<String, WebDriver> contextsDriver) throws Exception {
        driver = driverInit.initDockerDriver(folderDownloads, prop, nameDriver, contextsDriver, folderTestCase);
            handler = driver.getWindowHandle();
        reflectiveClass = Utils.getReflective(Test_PSFUEND02E0116.class.getCanonicalName());
			regresionCustomActionBeforeEach2 = new RegresionCustomActionBeforeEach2(reflectiveClass);
		actionOracleAction = new ActionOracleAction(reflectiveClass);
		oracleBefore = new OracleBefore(driver);
		oracleExecute = new OracleExecute(driver);
		oracleAfter = new OracleAfter(driver);
        return driver;
    }
}