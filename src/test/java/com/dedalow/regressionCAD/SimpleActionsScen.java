package com.dedalow.regressionCAD;

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

public class SimpleActionsScen {
    private ArrayList<String> results = new ArrayList<String>();
    private String FeatureName = "RegressionCAD";
    private SharedDependencies dependencies;
    

    private G_IralapginadelformulAction g_IralapginadelformulAction;
    private A_ComprobarqueestamosenAction3 a_ComprobarqueestamosenAction3;
    private W_EscribirenelformularioAction w_EscribirenelformularioAction;
    private T_ComprobartodoslostiposAction t_ComprobartodoslostiposAction;
    private W_IralapginadebotonesAction w_IralapginadebotonesAction;
    private A_ComprobarelclickizquieAction a_ComprobarelclickizquieAction;
    private A_ComprobarelclickizquieAction1 a_ComprobarelclickizquieAction1;
    private A_ComprobareldobleclickAction a_ComprobareldobleclickAction;
    private A_IralapginadedraganAction a_IralapginadedraganAction;
    private A_ArrastrarunaimagenAction a_ArrastrarunaimagenAction;
    private T_ComprobarquesehahechoAction t_ComprobarquesehahechoAction;
    

    public SimpleActionsScen(SharedDependencies sharedDependencies){
        this.dependencies = sharedDependencies;
        this.dependencies.scenarioName =  "SimpleActionsScen";
    }

    public void initActions() throws Exception {
        g_IralapginadelformulAction = new G_IralapginadelformulAction(dependencies);
            a_ComprobarqueestamosenAction3 = new A_ComprobarqueestamosenAction3(dependencies);
            w_EscribirenelformularioAction = new W_EscribirenelformularioAction(dependencies);
            t_ComprobartodoslostiposAction = new T_ComprobartodoslostiposAction(dependencies);
            w_IralapginadebotonesAction = new W_IralapginadebotonesAction(dependencies);
            a_ComprobarelclickizquieAction = new A_ComprobarelclickizquieAction(dependencies);
            a_ComprobarelclickizquieAction1 = new A_ComprobarelclickizquieAction1(dependencies);
            a_ComprobareldobleclickAction = new A_ComprobareldobleclickAction(dependencies);
            a_IralapginadedraganAction = new A_IralapginadedraganAction(dependencies);
            a_ArrastrarunaimagenAction = new A_ArrastrarunaimagenAction(dependencies);
            t_ComprobarquesehahechoAction = new T_ComprobarquesehahechoAction(dependencies);
            
    }

    @Before("@SimpleActionsScen")
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

    @Given("^Ir a la página del formulario$")
    public void Given3() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>GIVEN</b> Ir a la página del formulario");
            Report.reportLog(dependencies, "Ir a la página del formulario testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            g_IralapginadelformulAction.doG_IralapginadelformulAction();
            Report.reportLog(dependencies, "Ir a la página del formulario action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	@And("^Comprobar que estamos en la página$")
    public void And5() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>AND</b> Comprobar que estamos en la página");
            Report.reportLog(dependencies, "Comprobar que estamos en la página testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            a_ComprobarqueestamosenAction3.doA_ComprobarqueestamosenAction3();
            Report.reportLog(dependencies, "Comprobar que estamos en la página action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	@When("^Escribir en el formulario$")
    public void When4() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>WHEN</b> Escribir en el formulario");
            Report.reportLog(dependencies, "Escribir en el formulario testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            w_EscribirenelformularioAction.doW_EscribirenelformularioAction();
            Report.reportLog(dependencies, "Escribir en el formulario action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	@Then("^Comprobar todos los tipos de assert$")
    public void Then2() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>THEN</b> Comprobar todos los tipos de assert");
            Report.reportLog(dependencies, "Comprobar todos los tipos de assert testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            t_ComprobartodoslostiposAction.doT_ComprobartodoslostiposAction();
            Report.reportLog(dependencies, "Comprobar todos los tipos de assert action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	@When("^Ir a la página de botones$")
    public void When5() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>WHEN</b> Ir a la página de botones");
            Report.reportLog(dependencies, "Ir a la página de botones testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            w_IralapginadebotonesAction.doW_IralapginadebotonesAction();
            Report.reportLog(dependencies, "Ir a la página de botones action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	@And("^Comprobar el click izquierdo por ID$")
    public void And7() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>AND</b> Comprobar el click izquierdo por ID");
            Report.reportLog(dependencies, "Comprobar el click izquierdo por ID testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            a_ComprobarelclickizquieAction.doA_ComprobarelclickizquieAction();
            Report.reportLog(dependencies, "Comprobar el click izquierdo por ID action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	@And("^Comprobar el click izquierdo por Xpath$")
    public void And8() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>AND</b> Comprobar el click izquierdo por Xpath");
            Report.reportLog(dependencies, "Comprobar el click izquierdo por Xpath testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            a_ComprobarelclickizquieAction1.doA_ComprobarelclickizquieAction1();
            Report.reportLog(dependencies, "Comprobar el click izquierdo por Xpath action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	@And("^Comprobar el doble click$")
    public void And9() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>AND</b> Comprobar el doble click");
            Report.reportLog(dependencies, "Comprobar el doble click testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            a_ComprobareldobleclickAction.doA_ComprobareldobleclickAction();
            Report.reportLog(dependencies, "Comprobar el doble click action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	@And("^Ir a la página de drag and drop$")
    public void And6() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>AND</b> Ir a la página de drag and drop");
            Report.reportLog(dependencies, "Ir a la página de drag and drop testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            a_IralapginadedraganAction.doA_IralapginadedraganAction();
            Report.reportLog(dependencies, "Ir a la página de drag and drop action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	@And("^Arrastrar una imagen$")
    public void And10() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>AND</b> Arrastrar una imagen");
            Report.reportLog(dependencies, "Arrastrar una imagen testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            a_ArrastrarunaimagenAction.doA_ArrastrarunaimagenAction();
            Report.reportLog(dependencies, "Arrastrar una imagen action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	@Then("^Comprobar que se ha hecho correctamente$")
    public void Then3() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>THEN</b> Comprobar que se ha hecho correctamente");
            Report.reportLog(dependencies, "Comprobar que se ha hecho correctamente testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            t_ComprobarquesehahechoAction.doT_ComprobarquesehahechoAction();
            Report.reportLog(dependencies, "Comprobar que se ha hecho correctamente action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	
    @After("@SimpleActionsScen")
    public void after() {
        dependencies.logger.info("Result on SimpleActionsScen" + ":" + dependencies.finalResult);
        
        dependencies.results.add(0, dependencies.finalResult);
        Report.addResults(FeatureName, dependencies.scenarioName, dependencies.results);
        dependencies.initialize.flush();
        dependencies.clearDrivers();
        dependencies.finalReports(FeatureName);
        		ContainerManager.stopContainer(dependencies.finalResult, dependencies.scenarioName);
    }
}
