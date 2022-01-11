package com.dedalow.release5;

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
import com.dedalow.ContainerManager;

import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class ForderGlobalScen {
    private ArrayList<String> results = new ArrayList<String>();
    private String FeatureName = "Release5";
    private SharedDependencies dependencies;
    

    private G_IralaapliacinsuperteAction g_IralaapliacinsuperteAction;
    private W_EjecutarlaspruebassimpAction w_EjecutarlaspruebassimpAction;
    

    public ForderGlobalScen(SharedDependencies sharedDependencies){
        this.dependencies = sharedDependencies;
        this.dependencies.scenarioName =  "ForderGlobalScen";
    }

    public void initActions() throws Exception {
        g_IralaapliacinsuperteAction = new G_IralaapliacinsuperteAction(dependencies);
            w_EjecutarlaspruebassimpAction = new W_EjecutarlaspruebassimpAction(dependencies);
            
    }

    @Before("@ForderGlobalScen")
    public void before() throws IOException {
        try {
            dependencies.checkDocker();
			dependencies.setUp(FeatureName);
			dependencies.setUpEnvironment("MAIN_CONTEXT");
            initActions();
        } catch (Exception e) {
            Report.reportErrors(e.getMessage());
        }
    }

    @Given("^Ir a la apliación supertestui$")
    public void Given2() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>GIVEN</b> Ir a la apliación supertestui");
            Report.reportLog(dependencies, "Ir a la apliación supertestui testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            g_IralaapliacinsuperteAction.doG_IralaapliacinsuperteAction();
            Report.reportLog(dependencies, "Ir a la apliación supertestui action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	@When("^Ejecutar las pruebas simples$")
    public void When3() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>WHEN</b> Ejecutar las pruebas simples");
            Report.reportLog(dependencies, "Ejecutar las pruebas simples testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            w_EjecutarlaspruebassimpAction.doW_EjecutarlaspruebassimpAction();
            Report.reportLog(dependencies, "Ejecutar las pruebas simples action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	
    @After("@ForderGlobalScen")
    public void after() {
        dependencies.logger.info("Result on ForderGlobalScen" + ":" + dependencies.finalResult);
        
        dependencies.results.add(0, dependencies.finalResult);
        Report.addResults(FeatureName, dependencies.scenarioName, dependencies.results);
        dependencies.initialize.flush();
        dependencies.clearDrivers();
        dependencies.finalReports(FeatureName);
        		ContainerManager.stopContainer(dependencies.finalResult, dependencies.scenarioName);
    }
}
