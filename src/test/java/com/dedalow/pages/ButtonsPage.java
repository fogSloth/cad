package com.dedalow.pages;

import com.aventstack.extentreports.Status;
import com.dedalow.SharedDependencies;
import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import java.io.File;
import java.util.Properties;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.interactions.Actions;

public class ButtonsPage {
    
	private By clickToOk = By.id("clickToOk");
	private By disableButtons = By.id("disableButtons");
	private By disableButtons1 = By.id("disableButtons");
	private By clickToOkByXpath = By.xpath("//*[@id=\"clickToOk\"]");
	private By doubleClickToOkByXpath = By.xpath("//*[@id=\"doubleClickToOk\"]");
	private By disableButtons2 = By.id("disableButtons");
	private By disableButtons3 = By.id("disableButtons");
	private By clickToOk1 = By.id("clickToOk");
	private By disableButtons4 = By.id("disableButtons");
	private By clickToOkByXpath1 = By.xpath("//*[@id=\"clickToOk\"]");
	private By doubleClickToOkByXpath1 = By.xpath("//*[@id=\"doubleClickToOk\"]");
	private By disableButtons5 = By.id("disableButtons");
    
    private JavascriptExecutor js;
    private SharedDependencies dependencies;
    private WebDriver driver;
    private Properties prop;
    private File folderDownloads;
    
    public ButtonsPage(SharedDependencies sharedDependencies) {
        this.dependencies = sharedDependencies;
        this.prop = dependencies.prop;
        this.folderDownloads = dependencies.folderDownloads;
        PageFactory.initElements(dependencies.driver, this);
        js = (JavascriptExecutor)dependencies.driver;
    }

    

	public ButtonsPage clickToOk() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(clickToOk));
            Report.reportLog(dependencies, "Condition clickToOk isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(clickToOk).click();
            Report.reportLog(dependencies, "Clicked clickToOk", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public ButtonsPage disableButtons() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(disableButtons));
            Report.reportLog(dependencies, "Condition disableButtons isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(disableButtons).click();
            Report.reportLog(dependencies, "Clicked disableButtons", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public ButtonsPage disableButtons1() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(disableButtons1));
            Report.reportLog(dependencies, "Condition disableButtons1 isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(disableButtons1).click();
            Report.reportLog(dependencies, "Clicked disableButtons1", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public ButtonsPage clickToOkByXpath() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(clickToOkByXpath));
            Report.reportLog(dependencies, "Condition clickToOkByXpath isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(clickToOkByXpath).click();
            Report.reportLog(dependencies, "Clicked clickToOkByXpath", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public ButtonsPage doubleClickToOkByXpath() throws Exception {
        
            
            Actions action = new Actions(dependencies.driver);
            action.doubleClick(dependencies.driver.findElement(doubleClickToOkByXpath)).perform();
            Report.reportLog(dependencies, "Double clicked doubleClickToOkByXpath", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public ButtonsPage disableButtons2() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(disableButtons2));
            Report.reportLog(dependencies, "Condition disableButtons2 isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(disableButtons2).click();
            Report.reportLog(dependencies, "Clicked disableButtons2", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public ButtonsPage disableButtons3() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(disableButtons3));
            Report.reportLog(dependencies, "Condition disableButtons3 isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(disableButtons3).click();
            Report.reportLog(dependencies, "Clicked disableButtons3", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public ButtonsPage clickToOk1() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(clickToOk1));
            Report.reportLog(dependencies, "Condition clickToOk1 isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(clickToOk1).click();
            Report.reportLog(dependencies, "Clicked clickToOk1", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public ButtonsPage disableButtons4() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(disableButtons4));
            Report.reportLog(dependencies, "Condition disableButtons4 isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(disableButtons4).click();
            Report.reportLog(dependencies, "Clicked disableButtons4", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public ButtonsPage clickToOkByXpath1() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(clickToOkByXpath1));
            Report.reportLog(dependencies, "Condition clickToOkByXpath1 isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(clickToOkByXpath1).click();
            Report.reportLog(dependencies, "Clicked clickToOkByXpath1", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public ButtonsPage doubleClickToOkByXpath1() throws Exception {
        
            
            Actions action = new Actions(dependencies.driver);
            action.doubleClick(dependencies.driver.findElement(doubleClickToOkByXpath1)).perform();
            Report.reportLog(dependencies, "Double clicked doubleClickToOkByXpath1", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public ButtonsPage disableButtons5() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(disableButtons5));
            Report.reportLog(dependencies, "Condition disableButtons5 isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(disableButtons5).click();
            Report.reportLog(dependencies, "Clicked disableButtons5", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }
    
}