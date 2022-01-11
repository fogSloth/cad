package com.dedalow;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.List;

import java.util.Date;
import org.openqa.selenium.WebDriver;
import com.aventstack.extentreports.ExtentTest;
import com.dedalow.report.Report;
import com.dedalow.report.ExtentHtml;
import com.dedalow.report.Report;
import com.dedalow.utils.Utils;
import com.dedalow.utils.DriverInit;

public class SharedDependencies {

	public WebDriver driver;
	public Utils utils;
	public File folderTestSuite;
	public File folderTestCase;
	public File folderDownloads;
	public Logger logger = Utils.logger();
	public FileSystem fileSystem = FileSystems.getDefault();
	public Properties prop;
	public RunnerTest runner = new RunnerTest();
	public Map<String, WebDriver> contextsDriver = new HashMap<String, WebDriver>();
	public String handler;
	public String level;
	public String finalResult;
	public boolean isAfter = false;
	public String captureLog = "OK";
	public String scenarioName;
	public ArrayList<String> results = new ArrayList<String>();
	public ExtentHtml initialize;
	public ExtentTest test;
	public ExtentTest parentTest;
	public static DriverInit driverInit = new DriverInit();
	public DateFormat dfNameF = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
	public String dat = dfNameF.format(new Date());
	public Boolean isBackend = false;
	public String screenshot;

	/**
	 * Constructor
	 */
	public SharedDependencies() {
		utils = new Utils();
	}
	
	public void setUp(String suiteName) throws Exception {
		finalResult = "OK";
		folderTestSuite = new File(runner.folderLogs + fileSystem.getSeparator() + suiteName);
		folderTestSuite.mkdirs();
		folderTestCase = new File(folderTestSuite + fileSystem.getSeparator() + scenarioName);
		folderTestCase.mkdirs();
		folderDownloads = new File(folderTestCase + fileSystem.getSeparator() + "files");
		folderDownloads.mkdirs();
		initialize = new ExtentHtml(suiteName, scenarioName, "");
        test = initialize.getTest();
		prop = Utils.getConfigProperties();
		level = prop.getProperty("LOG_LEVEL");
		screenshot = utils.configScreenshot(prop);
		Utils.setEncoding();
	}

	
	
		public void checkDocker() {
			try {
				Runtime.getRuntime().exec("docker --version");
			} catch (IOException e) {
				logger.severe("Cannot run program \"docker\": CreateProcess error=2, System can not find docker installed.");
			}
		}

	
	public void setUpEnvironment(String nameDriver) throws Exception {
		driver = driverInit.initDockerDriver(folderDownloads, prop, nameDriver, contextsDriver, folderTestCase);
		handler = driver.getWindowHandle();
	}

	
	public void clearDrivers() {
		String driverType = prop.getProperty("WebDriver.BROWSER").toLowerCase().replace(" ", "");
        List<String> listNamesFirefox = Arrays.asList("testcontainerfirefox", "testcontainermozilla", "testcontainermozillafirefox", "testcontainergecko");

		for (Map.Entry<String, WebDriver> context : contextsDriver.entrySet()) {
            if (!listNamesFirefox.contains(driverType)) {
                context.getValue().close();
            }
            context.getValue().quit();
        }
		contextsDriver.clear();
	}

	public void finalReports(String featureName) {
        Report.reportExcel(folderTestSuite, results, featureName, scenarioName);
		
	}
}