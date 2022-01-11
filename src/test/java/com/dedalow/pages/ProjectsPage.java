package com.dedalow.pages;

import com.aventstack.extentreports.Status;
import com.dedalow.SharedDependencies;
import com.dedalow.utils.Utils;
import com.dedalow.report.Report;
import static org.junit.jupiter.api.Assertions.assertTrue;
import java.io.File;
import java.util.Properties;
import java.util.HashMap;
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
import org.openqa.selenium.remote.LocalFileDetector;
import org.openqa.selenium.remote.RemoteWebElement;

public class ProjectsPage {
    
	private By CreateNewProject = By.xpath("//button[contains(text(),'+ Create new project')]");
	private By NameProject1 = By.xpath("/html/body/div[12]/div/div/div[3]/div[2]/div[1]/input");
	private By CreateNew = By.xpath("//button[contains(text(),'Create new...')]");
	private By CreateSeed = By.xpath("/html/body/div[12]/div/div/div[4]/button[1]");
	private By NewProject = By.xpath("/html/body/div[10]/div/div[1]/div/a");
    
    private JavascriptExecutor js;
    private SharedDependencies dependencies;
    private WebDriver driver;
    private Properties prop;
    private File folderDownloads;

    public ProjectsPage(SharedDependencies sharedDependencies) {
        this.dependencies = sharedDependencies;
        this.prop = dependencies.prop;
        this.folderDownloads = dependencies.folderDownloads;
        PageFactory.initElements(dependencies.driver, this);
        js = (JavascriptExecutor)dependencies.driver;
    }

    

	public ProjectsPage CreateNewProject() throws Exception {
        	dependencies.driver.findElement(NameProject1).clear();
            dependencies.driver.findElement(NameProject1).sendKeys("createglobal");
            Report.reportLog(dependencies, "Typed " + "createglobal in NameProject1", "INFO", 0, Status.PASS, true, "", "", null);
		
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(CreateNewProject));
            Report.reportLog(dependencies, "Condition CreateNewProject isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(CreateNewProject).click();
            Report.reportLog(dependencies, "Clicked CreateNewProject", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
    }

	public ProjectsPage CreateNew() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(CreateNew));
            Report.reportLog(dependencies, "Condition CreateNew isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(CreateNew).click();
            Report.reportLog(dependencies, "Clicked CreateNew", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
    }

	public ProjectsPage CreateSeed() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(CreateSeed));
            Report.reportLog(dependencies, "Condition CreateSeed isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(CreateSeed).click();
            Report.reportLog(dependencies, "Clicked CreateSeed", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public ProjectsPage NewProject() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(NewProject));
            Report.reportLog(dependencies, "Condition NewProject isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(NewProject).click();
            Report.reportLog(dependencies, "Clicked NewProject", "INFO", 1000, Status.PASS, true, "", "", null);
            return this;
    }
    
}