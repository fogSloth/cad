package com.dedalow.suiteBackend;

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

public class BackendsScen {
    private ArrayList<String> results = new ArrayList<String>();
    private String FeatureName = "SuiteBackend";
    private SharedDependencies dependencies;
    

    private G_RealizaBackendsAction g_RealizaBackendsAction;
    private W_BackendAction1Action w_BackendAction1Action;
    private A_BackendAction2Action a_BackendAction2Action;
    

    public BackendsScen(SharedDependencies sharedDependencies){
        this.dependencies = sharedDependencies;
        this.dependencies.scenarioName =  "BackendsScen";
    }

    public void initActions() throws Exception {
        g_RealizaBackendsAction = new G_RealizaBackendsAction(dependencies);
            w_BackendAction1Action = new W_BackendAction1Action(dependencies);
            a_BackendAction2Action = new A_BackendAction2Action(dependencies);
            
    }

    @Before("@BackendsScen")
    public void before()  {
        try {
            dependencies.setUp(FeatureName);
            initActions();
        } catch (Exception e) {
            Report.reportErrors(e.getMessage());
        }
    }

    @Given("^Realiza Backends$")
    public void Given3() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>GIVEN</b> Realiza Backends");
            Report.reportLog(dependencies, "Realiza Backends testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            g_RealizaBackendsAction.doG_RealizaBackendsAction();
            Report.reportLog(dependencies, "Realiza Backends action completed", "INFO", 0, Status.PASS, false, "", "", null);
        } catch (TimeoutException te) {
            dependencies.finalResult = "BQ";
            Report.reportLog(dependencies, te.getMessage(), dependencies.level, 0, Status.FAIL, true, "isCatch", "", Throwables.getStackTraceAsString(te));
            throw new Exception(te.getMessage());
        } catch (Exception | AssertionError e) {
            dependencies.finalResult = "BQ";
            Report.reportLog(dependencies, e.getMessage(), dependencies.level, 0, Status.FAIL, true, "isCatch", "", Throwables.getStackTraceAsString(e));
            Report.reportErrors(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

	@When("^BackendAction1$")
    public void When4() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>WHEN</b> BackendAction1");
            Report.reportLog(dependencies, "BackendAction1 testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            w_BackendAction1Action.doW_BackendAction1Action();
            Report.reportLog(dependencies, "BackendAction1 action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	@And("^BackendAction2$")
    public void And5() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>AND</b> BackendAction2");
            Report.reportLog(dependencies, "BackendAction2 testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            a_BackendAction2Action.doA_BackendAction2Action();
            Report.reportLog(dependencies, "BackendAction2 action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	
    @After("@BackendsScen")
    public void after() {
        dependencies.isAfter = true;
        dependencies.isBackend = false;
        String afterResult = "succesfully";
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>AFTER</b> BackendsScen");
            
			w_BackendAction1Action.doW_BackendAction1Action();

        } catch (AssertionError e) {
            Report.reportErrors(e.getMessage());
            dependencies.captureLog ="KO";
            afterResult = "not succesfully";
            Report.reportLog(dependencies, e.getMessage(), dependencies.level, 0, Status.WARNING, true, "isCatch", "", Throwables.getStackTraceAsString(e));
        } catch (Exception e) {
            Report.reportErrors(e.getMessage());
            dependencies.captureLog ="KO";
            afterResult = "not succesfully";
            Report.reportLog(dependencies, e.getMessage(), dependencies.level, 0, Status.WARNING, true, "isCatch", "", Throwables.getStackTraceAsString(e));
        }
        
        dependencies.isAfter = false;
        dependencies.logger.info("Result on BackendsScen" + ":" + dependencies.finalResult);
        dependencies.logger.info("After execution finished" + ":" + afterResult);
        dependencies.results.add(0, dependencies.finalResult);
        Report.addResults(FeatureName, dependencies.scenarioName, dependencies.results);
        dependencies.initialize.flush();
        dependencies.clearDrivers();
        dependencies.finalReports(FeatureName);
        
    }
}
