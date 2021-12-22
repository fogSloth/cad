package com.dedalow.testSuiteModel;

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
import org.junit.jupiter.api.Test;
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


import com.dedalow.customActions.CustomAleatoria;
import com.dedalow.customActions.CustomCambiosRecientes;

public class Test_TestCaseModel {
   
    private static Class reflectiveClass;
    private static Launcher launcher = new Launcher();
    public static DriverInit driverInit = new DriverInit();
    public static Constant constant = launcher.constant;
    public static String suiteName = "TestSuiteModel";
    public static String caseName = Test_TestCaseModel.class.getSimpleName();
    public static String modelDocumentation = "";
    public static WebDriver driver;

    public static Properties prop;
    public static String level;
    public static String handler;
    public static String finalResult = "OK";
    public static File folderTestCase;
    public static File folderDownloads;
    public static HashMap<String, String> excelSheet;

    
	private static CustomAleatoria customAleatoria;
	private static CustomCambiosRecientes customCambiosRecientes;
    
    
    @BeforeEach
    public void beforeEach() throws Exception {
        try {
			setUp();
            constant.initialize = new ExtentHtml(suiteName, caseName, modelDocumentation);
            constant.test = constant.initialize.getTest();
            driver = setUpEnvironment(folderDownloads, prop, "MAIN_CONTEXT", constant.contextsDriver);
                
        } catch (AssertionError | Exception e) {
            Report.reportErrors(e.getMessage());
			finalResult = "BQ";
            Report.reportLog(reflectiveClass, e.getMessage(), level, 0, Status.FAIL, true, "isCatch", "", Throwables.getStackTraceAsString(e));
            throw new Exception(e);
		}
    }

    

    @Test
	@DisplayName("Test_TestCaseModel")
	public void test() throws Exception {
        try {
            
            
            
            Report.reportLog(reflectiveClass, "Start of execution", "INFO", 0, Status.PASS, false, "", "", null);
            
			driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
            Report.reportLog(reflectiveClass, "Navigated to " + "https://es.wikipedia.org/wiki/Wikipedia:Portada", "INFO", 0, Status.PASS, true, "", "", null);
			
	customCambiosRecientes.doCustomCambiosRecientes(reflectiveClass);
            constant.test.log(Status.PASS, "CustomCambiosRecientes completed");
			Thread.sleep(3000);
            Report.capScreen(reflectiveClass);
            

			assertTrue(driver.getCurrentUrl().equals("https://es.wikipedia.org/wiki/Especial:CambiosRecientes?hidebots=1&hidecategorization=1&hideWikibase=1&limit=50&days=7&urlversion=2"), "Field FrontEndVerdictStepsAction1 not found in assertion");
        	Report.reportLog(reflectiveClass, "The field https://es.wikipedia.org/wiki/Especial:CambiosRecientes?hidebots=1&hidecategorization=1&hideWikibase=1&limit=50&days=7&urlversion=2 has been found on assertion", "INFO", 0, Status.PASS, true, "", "", null);
            
            
            Report.reportLog(reflectiveClass, "The field FrontEndVerdictStepsAction has been found on assertions", "INFO", 0, Status.PASS, false, "", "", null);
            
	customAleatoria.doCustomAleatoria(reflectiveClass);
            constant.test.log(Status.PASS, "CustomAleatoria completed");
            Report.capScreen(reflectiveClass);
            

        } catch (AssertionError | Exception e) {
            Report.reportErrors(e.getMessage());
            if (finalResult != "BQ") {
				finalResult = "KO";
			}
            Report.reportLog(reflectiveClass, e.getMessage(), level, 0, Status.FAIL, true, "isCatch", "", Throwables.getStackTraceAsString(e));
            throw new Exception(e);
        }
    }

    

    @AfterEach
    public void afterEach()  {
        boolean screenShot = true;
        
        
        if (finalResult == "OK") {
            Report.reportLog(reflectiveClass, "Result on Test_TestCaseModel: " + finalResult, "INFO", 0, Status.PASS, false, "", "", null);
        } else {
            Report.reportLog(reflectiveClass, "Result on Test_TestCaseModel: " + finalResult, "INFO", 0, Status.FAIL, false, "", "", null);
        }
        constant.logger.info("Result on Test_TestCaseModel: " + finalResult);
        Utils.tearDown(reflectiveClass);
		Utils.finalReports(reflectiveClass, screenShot);
		constant.initialize.flush();
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
        } catch (Exception e) {
            e.printStackTrace();
            Report.reportErrors(e.getMessage());
            throw new Exception(e);
        }
    }

    public static WebDriver setUpEnvironment(File folderDownloads, Properties prop,
        String nameDriver, Map<String, WebDriver> contextsDriver) throws Exception {
        driver = driverInit.driverSelector(folderDownloads, prop, nameDriver, contextsDriver);
            handler = driver.getWindowHandle();
        reflectiveClass = Utils.getReflective(Test_TestCaseModel.class.getCanonicalName());
		customAleatoria = new CustomAleatoria(driver);
		customCambiosRecientes = new CustomCambiosRecientes(driver);
        return driver;
    }
}