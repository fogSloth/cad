package com.dedalow.compruebaEuros;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.logging.Logger;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import com.google.common.base.Throwables;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import com.dedalow.SharedDependencies;
import com.dedalow.report.Report;
import com.dedalow.actions.*;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class EurosScen {
    private ArrayList<String> results = new ArrayList<String>();
    private String FeatureName = "CompruebaEuros";
    private SharedDependencies dependencies;
    

    private G_CompruebaAction g_CompruebaAction;
    

    public EurosScen(SharedDependencies sharedDependencies){
        this.dependencies = sharedDependencies;
        this.dependencies.scenarioName =  "EurosScen";
    }

    public void initActions() throws Exception {
        g_CompruebaAction = new G_CompruebaAction(dependencies);
            
    }

    @Before("@EurosScen")
    public void before()  {
        try {
            dependencies.setUp(FeatureName);
			dependencies.setUpEnvironment("MAIN_CONTEXT");
            initActions();
        } catch (Exception e) {
            Report.reportErrors(e.getMessage());
        }
    }

    @Given("^Comprueba€$")
    public void Given1() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>GIVEN</b> Comprueba€");
            Report.reportLog(dependencies, "Comprueba€ testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            g_CompruebaAction.doG_CompruebaAction();
            Report.reportLog(dependencies, "Comprueba€ action completed", "INFO", 0, Status.PASS, false, "", "", null);
        } catch (TimeoutException te) {
            dependencies.finalResult = "KO";
            Report.reportLog(dependencies, te.getMessage(), dependencies.level, 0, Status.FAIL, true, "isCatch", "", Throwables.getStackTraceAsString(te));
            throw new Exception(te.getMessage());
        } catch (Exception | AssertionError e) {
            dependencies.finalResult = "KO";
            Report.reportLog(dependencies, e.getMessage(), dependencies.level, 0, Status.FAIL, true, "isCatch", "", Throwables.getStackTraceAsString(e));
            Report.reportErrors(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

	
    @After("@EurosScen")
    public void after() {
        dependencies.logger.info("Result on EurosScen" + ":" + dependencies.finalResult);
        
        dependencies.results.add(0, dependencies.finalResult);
        Report.addResults(FeatureName, dependencies.scenarioName, dependencies.results);
        dependencies.initialize.flush();
        dependencies.clearDrivers();
        dependencies.finalReports(FeatureName);
        
    }
}
