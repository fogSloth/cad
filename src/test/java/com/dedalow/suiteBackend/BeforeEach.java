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

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.google.common.base.Throwables;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;

import com.dedalow.RunnerTest;
import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import com.dedalow.SharedDependencies;
import com.aventstack.extentreports.Status;

import com.dedalow.actions.G_GivenBackendsAction;

public class BeforeEach {
    private ArrayList<String> results = new ArrayList<String>();
    private String finalResult = "OK";
    private SharedDependencies dependencies;
    
	private G_GivenBackendsAction g_GivenBackendsAction;

    public BeforeEach(SharedDependencies sharedDependencies) {
        this.dependencies = sharedDependencies;
        initActions();
    }

    public void initActions() {
        try {
            
			g_GivenBackendsAction = new G_GivenBackendsAction(dependencies);
        } catch (Exception e) {
            Report.reportErrors(e.getMessage());
        }
    }

    @Given("^Given Backends$")
    public void GivenBackends() throws Exception {
        try {
            dependencies.parentTest = dependencies.test.createNode("<b>GIVEN</b> Given Backends");
            Report.reportLog(dependencies, "Given Backends testAction is going to start", "INFO", 0, Status.PASS, false, "", "", null);
            g_GivenBackendsAction.doG_GivenBackendsAction();
            Report.reportLog(dependencies, "Given Backends action completed", "INFO", 0, Status.PASS, false, "", "", null);
        } catch (Exception | AssertionError e) {
            dependencies.finalResult = "BQ";
            Report.reportLog(dependencies, e.getMessage(), dependencies.level, 0, Status.FAIL, true, "isCatch", "", Throwables.getStackTraceAsString(e));
            Report.reportErrors(e.getMessage());
            throw new Exception(e.getMessage());
        }
    }

	

}