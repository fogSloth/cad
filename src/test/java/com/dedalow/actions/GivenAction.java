package com.dedalow.actions;

import com.dedalow.utils.Utils;
import com.dedalow.utils.Constant;
import com.dedalow.report.Report;
import io.restassured.response.Response;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import static org.junit.jupiter.api.Assertions.assertTrue;
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
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;

public class GivenAction{

    private Class reflectiveClass;
    private Constant constant;
    private WebDriver driver;
    private String handler;
    private JavascriptExecutor js;
    private Properties prop;
    private String level;
    private String caseName;
    private File folderTestCase;
    private File folderDownloads;
    private String finalResult;
    private HashMap<String, String> excelSheet;
    
      
	private By RealizaDescarga = By.xpath("//body/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/a[1]");
    
    public GivenAction(Class reflectiveClass) throws Exception {
        this.reflectiveClass = reflectiveClass;
        getPrepareAction();
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor)driver;
    }

    public void getPrepareAction() throws Exception {
        this.driver = (WebDriver) reflectiveClass.getField("driver").get(reflectiveClass);
        this.constant = (Constant) reflectiveClass.getField("constant").get(reflectiveClass);
        this.prop = (Properties) reflectiveClass.getField("prop").get(reflectiveClass);
        this.level = (String) reflectiveClass.getField("level").get(reflectiveClass);
        this.folderDownloads = (File) reflectiveClass.getField("folderDownloads").get(reflectiveClass);
        this.finalResult = (String) reflectiveClass.getField("finalResult").get(reflectiveClass);
        this.folderTestCase = (File) reflectiveClass.getField("folderTestCase").get(reflectiveClass);
        this.caseName = (String) reflectiveClass.getField("caseName").get(reflectiveClass);
        this.handler = (String) reflectiveClass.getField("handler").get(reflectiveClass);
        this.excelSheet = (HashMap) reflectiveClass.getField("excelSheet").get(reflectiveClass);
    }

    public GivenAction FrontEndNavigate () {
        driver.get("https://320ytmp3.com/es6/download?type=ytmp3&url=https%3A%2F%2Fwww.youtube.com%2Fwatch%3Fv%3Dl4pQbkI7y98");
        Report.reportLog(reflectiveClass, "FrontEndNavigate action completed", "INFO", 0, Status.PASS, true, "", "", null);
        return this;
    }

	
      
	public GivenAction RealizaDescarga() throws Exception {
        
            
            
        String explorerDownloads = prop.getProperty("FOLDER_DOWNLOAD").equals("default")
        ? folderDownloads.getAbsolutePath() : prop.getProperty("FOLDER_DOWNLOAD");
        File directoryPath = new File(explorerDownloads);
        int directoryLength = directoryPath.listFiles().length;

        if (driver.toString().contains("internet explorer")) {
        String linkLocation = driver.findElement(RealizaDescarga).getAttribute("href");

        Process process = Runtime.getRuntime().exec("cmd /c start cmd.exe /K \"cd " + explorerDownloads + " && "
        + System.getProperty("user.dir") +"/resources/tool/wget.exe " + linkLocation  + "&& exit" );
        } else {
            driver.findElement(RealizaDescarga).click();
        }
        assertTrue(Utils.checkDownload(reflectiveClass, explorerDownloads, directoryLength,
            directoryPath), "File not found in " + explorerDownloads);
            Report.reportLog(reflectiveClass, "RealizaDescarga downloaded", "INFO", 0, Status.PASS, true, "", "", null);
            return this;
      }
      
    public void doGivenAction() throws Exception {
    
    
		FrontEndNavigate();
    
		RealizaDescarga();
    
		
    }
}