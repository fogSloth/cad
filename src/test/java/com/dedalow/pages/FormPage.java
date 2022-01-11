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

public class FormPage {
    
	private By uploadFile = By.id("uploadFile");
	private By downloadFile = By.xpath("//button[contains(text(), 'Download uploadFilefileName')]");
	private By dummyClickToForceWait = By.id("name");
	private By fillInputs = By.id("name");
	private By nameById = By.id("name");
	private By lastNameByXpathAndDoubleQuote = By.xpath("//input[@id=\"lastName\"]");
	private By emailByXpathAndSingleQuote = By.xpath("//input[@id='email']");
	private By phoneByName = By.name("phone");
    
    private JavascriptExecutor js;
    private SharedDependencies dependencies;
    private WebDriver driver;
    private Properties prop;
    private File folderDownloads;

    public FormPage(SharedDependencies sharedDependencies) {
        this.dependencies = sharedDependencies;
        this.prop = dependencies.prop;
        this.folderDownloads = dependencies.folderDownloads;
        PageFactory.initElements(dependencies.driver, this);
        js = (JavascriptExecutor)dependencies.driver;
    }

    

	public FormPage uploadFile() throws Exception {
        
            
            LocalFileDetector detector = new LocalFileDetector();
        File localFile = detector.getLocalFile("C:/Users/jperepei/generated/Swagger.json");
        WebElement element = dependencies.driver.findElement(uploadFile);
        ((RemoteWebElement)element).setFileDetector(detector);
        element.sendKeys(localFile.getAbsolutePath());
            Report.reportLog(dependencies, "uploadFile: C:/Users/jperepei/generated/Swagger.json uploaded", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public FormPage downloadFile() throws Exception {
        
            
            
        String explorerDownloads = prop.getProperty("FOLDER_DOWNLOAD").equals("default")
        ? folderDownloads.getAbsolutePath() : prop.getProperty("FOLDER_DOWNLOAD");
        File directoryPath = new File(explorerDownloads);
        int directoryLength = directoryPath.listFiles().length;

        if (dependencies.driver.toString().contains("internet explorer")) {
        String linkLocation = dependencies.driver.findElement(downloadFile).getAttribute("href");

        Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd " + explorerDownloads + " && "
        + System.getProperty("user.dir") +"/resources/tool/wget.exe " + linkLocation  + "&& exit" );
        } else {
            dependencies.driver.findElement(downloadFile).click();
        }
        assertTrue(Utils.checkDownload(dependencies, explorerDownloads, directoryLength,
            directoryPath), "File not found in " + explorerDownloads);
            Report.reportLog(dependencies, "downloadFile downloaded", "INFO", 2000, Status.PASS, true, "", "", null);
            return this;
    }

	public FormPage dummyClickToForceWait() throws Exception {
        
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(dummyClickToForceWait));
            Report.reportLog(dependencies, "Condition dummyClickToForceWait isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(dummyClickToForceWait).click();
            Report.reportLog(dependencies, "Clicked dummyClickToForceWait", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }

	public FormPage fillInputs() throws Exception {
        	dependencies.driver.findElement(nameById).clear();
            dependencies.driver.findElement(nameById).sendKeys("a name");
            Report.reportLog(dependencies, "Typed " + "a name in nameById", "INFO", 0, Status.PASS, true, "", "", null);
			dependencies.driver.findElement(lastNameByXpathAndDoubleQuote).clear();
            dependencies.driver.findElement(lastNameByXpathAndDoubleQuote).sendKeys("a last name");
            Report.reportLog(dependencies, "Typed " + "a last name in lastNameByXpathAndDoubleQuote", "INFO", 0, Status.PASS, true, "", "", null);
			dependencies.driver.findElement(emailByXpathAndSingleQuote).clear();
            dependencies.driver.findElement(emailByXpathAndSingleQuote).sendKeys("an email");
            Report.reportLog(dependencies, "Typed " + "an email in emailByXpathAndSingleQuote", "INFO", 0, Status.PASS, true, "", "", null);
			dependencies.driver.findElement(phoneByName).clear();
            dependencies.driver.findElement(phoneByName).sendKeys("123456");
            Report.reportLog(dependencies, "Typed " + "123456 in phoneByName", "INFO", 0, Status.PASS, true, "", "", null);
		
            new WebDriverWait(dependencies.driver, 20).until(ExpectedConditions.elementToBeClickable(fillInputs));
            Report.reportLog(dependencies, "Condition fillInputs isClickable finished", "ASYNCHRONOUS", 0);
            dependencies.driver.findElement(fillInputs).click();
            Report.reportLog(dependencies, "Clicked fillInputs", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
    }
    
}