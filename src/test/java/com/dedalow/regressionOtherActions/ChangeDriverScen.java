package com.dedalow.regressionOtherActions;

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

public class ChangeDriverScen {
    private ArrayList<String> results = new ArrayList<String>();
    private String FeatureName = "RegressionOtherActions";
    private SharedDependencies dependencies;
    

    private G_AbrirunnuevonavegadorAction g_AbrirunnuevonavegadorAction;
    private A_ComprobarqueestamosenAction a_ComprobarqueestamosenAction;
    private W_AbrirunnuevonavegadorAction w_AbrirunnuevonavegadorAction;
    private A_AbrirlapestaaparareaAction a_AbrirlapestaaparareaAction;
    private A_ComprobarquepodemosreaAction a_ComprobarquepodemosreaAction;
    private W_VolveralapestaadeGmAction w_VolveralapestaadeGmAction;
    private A_ComprobarqueestamosenAction1 a_ComprobarqueestamosenAction1;
    private T_VolveralapaginaCADAction t_VolveralapaginaCADAction;
    private A_ComprobarqueestamosenAction2 a_ComprobarqueestamosenAction2;
    

    public ChangeDriverScen(SharedDependencies sharedDependencies){
        this.dependencies = sharedDependencies;
        this.dependencies.scenarioName =  "ChangeDriverScen";
    }

    public void initActions() throws Exception {
        g_AbrirunnuevonavegadorAction = new G_AbrirunnuevonavegadorAction(dependencies);
            a_ComprobarqueestamosenAction = new A_ComprobarqueestamosenAction(dependencies);
            w_AbrirunnuevonavegadorAction = new W_AbrirunnuevonavegadorAction(dependencies);
            a_AbrirlapestaaparareaAction = new A_AbrirlapestaaparareaAction(dependencies);
            a_ComprobarquepodemosreaAction = new A_ComprobarquepodemosreaAction(dependencies);
            w_VolveralapestaadeGmAction = new W_VolveralapestaadeGmAction(dependencies);
            a_ComprobarqueestamosenAction1 = new A_ComprobarqueestamosenAction1(dependencies);
            t_VolveralapaginaCADAction = new T_VolveralapaginaCADAction(dependencies);
            a_ComprobarqueestamosenAction2 = new A_ComprobarqueestamosenAction2(dependencies);
            
    }

    @Before("@ChangeDriverScen")
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

    @Given("^Abrir un nuevo navegador a la pagina JIRAITO$")
    public void Given1() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>GIVEN</b> Abrir un nuevo navegador a la pagina JIRAITO");
            Report.reportLog(dependencies, "Abrir un nuevo navegador a la pagina JIRAITO testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            g_AbrirunnuevonavegadorAction.doG_AbrirunnuevonavegadorAction();
			Thread.sleep(5000);
            Report.reportLog(dependencies, "Abrir un nuevo navegador a la pagina JIRAITO action completed", "INFO", 5000, Status.PASS, false, "", "", null);
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

	@And("^Comprobar que estamos en la pagina WIKIPEDIA$")
    public void And() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>AND</b> Comprobar que estamos en la pagina WIKIPEDIA");
            Report.reportLog(dependencies, "Comprobar que estamos en la pagina WIKIPEDIA testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            a_ComprobarqueestamosenAction.doA_ComprobarqueestamosenAction();
            Report.reportLog(dependencies, "Comprobar que estamos en la pagina WIKIPEDIA action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	@When("^Abrir un nuevo navegador a la pagina Gmail$")
    public void When1() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>WHEN</b> Abrir un nuevo navegador a la pagina Gmail");
            Report.reportLog(dependencies, "Abrir un nuevo navegador a la pagina Gmail testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            w_AbrirunnuevonavegadorAction.doW_AbrirunnuevonavegadorAction();
			Thread.sleep(5000);
            Report.reportLog(dependencies, "Abrir un nuevo navegador a la pagina Gmail action completed", "INFO", 5000, Status.PASS, false, "", "", null);
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

	@And("^Abrir la pestaña para realizar el inicio de sesion$")
    public void And4() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>AND</b> Abrir la pestaña para realizar el inicio de sesion");
            Report.reportLog(dependencies, "Abrir la pestaña para realizar el inicio de sesion testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            a_AbrirlapestaaparareaAction.doA_AbrirlapestaaparareaAction();
			Thread.sleep(5000);
            Report.reportLog(dependencies, "Abrir la pestaña para realizar el inicio de sesion action completed", "INFO", 5000, Status.PASS, false, "", "", null);
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

	@And("^Comprobar que podemos realizar el inicio de sesion$")
    public void And3() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>AND</b> Comprobar que podemos realizar el inicio de sesion");
            Report.reportLog(dependencies, "Comprobar que podemos realizar el inicio de sesion testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            a_ComprobarquepodemosreaAction.doA_ComprobarquepodemosreaAction();
			Thread.sleep(5000);
            Report.reportLog(dependencies, "Comprobar que podemos realizar el inicio de sesion action completed", "INFO", 5000, Status.PASS, false, "", "", null);
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

	@When("^Volver a la pestaña de Gmail$")
    public void When2() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>WHEN</b> Volver a la pestaña de Gmail");
            Report.reportLog(dependencies, "Volver a la pestaña de Gmail testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            w_VolveralapestaadeGmAction.doW_VolveralapestaadeGmAction();
			Thread.sleep(5000);
            Report.reportLog(dependencies, "Volver a la pestaña de Gmail action completed", "INFO", 5000, Status.PASS, false, "", "", null);
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

	@And("^Comprobar que estamos en la pagina Gmail$")
    public void And1() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>AND</b> Comprobar que estamos en la pagina Gmail");
            Report.reportLog(dependencies, "Comprobar que estamos en la pagina Gmail testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            a_ComprobarqueestamosenAction1.doA_ComprobarqueestamosenAction1();
			Thread.sleep(5000);
            Report.reportLog(dependencies, "Comprobar que estamos en la pagina Gmail action completed", "INFO", 5000, Status.PASS, false, "", "", null);
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

	@Then("^Volver a la pagina CAD$")
    public void Then1() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>THEN</b> Volver a la pagina CAD");
            Report.reportLog(dependencies, "Volver a la pagina CAD testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            t_VolveralapaginaCADAction.doT_VolveralapaginaCADAction();
			Thread.sleep(5000);
            Report.reportLog(dependencies, "Volver a la pagina CAD action completed", "INFO", 5000, Status.PASS, false, "", "", null);
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

	@And("^Comprobar que estamos en la pagina CAD$")
    public void And2() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>AND</b> Comprobar que estamos en la pagina CAD");
            Report.reportLog(dependencies, "Comprobar que estamos en la pagina CAD testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            a_ComprobarqueestamosenAction2.doA_ComprobarqueestamosenAction2();
            Report.reportLog(dependencies, "Comprobar que estamos en la pagina CAD action completed", "INFO", 0, Status.PASS, false, "", "", null);
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

	
    @After("@ChangeDriverScen")
    public void after() {
        dependencies.logger.info("Result on ChangeDriverScen" + ":" + dependencies.finalResult);
        
        dependencies.results.add(0, dependencies.finalResult);
        Report.addResults(FeatureName, dependencies.scenarioName, dependencies.results);
        dependencies.initialize.flush();
        dependencies.clearDrivers();
        dependencies.finalReports(FeatureName);
        		ContainerManager.stopContainer(dependencies.finalResult, dependencies.scenarioName);
    }
}
