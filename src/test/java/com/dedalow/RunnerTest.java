package com.dedalow;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;

import java.net.InetAddress;
import java.net.MalformedURLException;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.Date;
import java.util.Properties;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.dedalow.report.Report;
import com.dedalow.utils.Utils;
import cucumber.api.cli.Main;
import org.junit.runner.RunWith;
import cucumber.api.junit.Cucumber;
import cucumber.api.CucumberOptions;

@RunWith(Cucumber.class)
@CucumberOptions(features = "features", glue = {
			"com.dedalow.testSuiteModel",
			 })
public class RunnerTest {

	public static FileSystem fileSystem = FileSystems.getDefault();
	public static DateFormat dfNameF = new SimpleDateFormat("dd_MM_yyyy_HH_mm");
	public static String dat = dfNameF.format(new Date());
	public static String root = System.getProperty("user.dir") + fileSystem.getSeparator() + "logs";
	public static File folderLogs = new File(root + fileSystem.getSeparator() + dat);
	public static byte executionStatus;
	private static Logger logger = Utils.logger();
	
	public static void main(String[] args) {
		if (args.length == 0) {
			args = new String[]{ "-s", "-m",
				"-p", "pretty",
				"-p", "html:" + folderLogs + "/Cucumber/ReportHTML",
				"-p", "json:" + folderLogs + "/Cucumber/ReportJSON.json",
				"-p", "junit:" + folderLogs + "/Cucumber/ReportXML.xml",
				"features",
				"-g", "com.dedalow.testSuiteModel",
				"-t", Utils.selectExecution()
			};
		} else {
			args = Utils.getArgumentsOptions(args);
		}

		/**
		 * Create the report folder and ping to 
		 * check the connection to the HomePage
		 */
		executionPropertiesSetUp();
		
		try {			
			executionStatus = Main.run(args, Thread.currentThread().getContextClassLoader());
		} catch (IOException e) {
			Report.reportErrors("Error runnig test: " + e.getMessage());
		}

		/**
		 * Make a complete report of the project execution.
		 * TestLink, Excel
		 */
		executionReport();
		System.exit(executionStatus);
	}

	public static void executionPropertiesSetUp() {
		folderLogs.mkdirs();
		Pattern regex = Pattern.compile(":?(http(?:s)*://)*([^:|/]*):?([0-9]*)([^$]*)");
		Properties prop = new Properties();

		try {
			prop.load(new FileInputStream("config.properties"));
			Matcher homePage = regex.matcher(prop.getProperty("WEB_URL"));
			homePage.find();
			InetAddress ping = InetAddress.getByName(homePage.group(2));
		} catch (Exception e) {
			logger.warning("No connection established with " + prop.getProperty("WEB_URL"));
		}
	}

	public static void executionReport() {
		logger.info("Logs can be consulted at the following dir: " + root);
		logger.info("******************************** FEATURES execution finished ********************************");

	}
}