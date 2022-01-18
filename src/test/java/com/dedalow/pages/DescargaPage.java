package com.dedalow.pages;

import java.util.logging.Logger;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.By;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Properties;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.aventstack.extentreports.Status;
import com.dedalow.report.Report;
import com.dedalow.utils.Utils;
import com.dedalow.utils.Constant;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class DescargaPage {

    private WebDriver driver;
    private Class reflectiveClass;
    private JavascriptExecutor js;
    private static Logger logger = Utils.logger();
	private Properties prop;
    private File folderDownloads;
    
	private By RealizaDescarga = By.xpath("//body/section[1]/div[1]/div[1]/div[2]/div[1]/div[1]/div[1]/div[3]/div[2]/a[1]");
    
    
    public DescargaPage(Class reflectiveClass) throws Exception {
        this.reflectiveClass = reflectiveClass;
        this.driver = (WebDriver) reflectiveClass.getField("driver").get(reflectiveClass);
        PageFactory.initElements(driver, this);
        js = (JavascriptExecutor)driver;
		prop = (Properties) reflectiveClass.getField("prop").get(reflectiveClass);
        folderDownloads = (File) reflectiveClass.getField("folderDownloads").get(reflectiveClass);
        
    }
        
	public DescargaPage RealizaDescarga() throws Exception {
        
            
            
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
}