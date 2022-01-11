package com.dedalow.utils;
import java.io.File;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import com.dedalow.ContainerManager;

public class DriverInit {

    public Logger logger = Utils.logger();
    public String driverType;
    public WebDriver driver = null;
    public String driverPath;
    public String[] driverOptions;
    public String pathFolderDownloads;
    public int timeOut;
    public List<String> listNamesChrome = Arrays.asList("testcontainerchrome", "testcontainergooglechrome");
    public List<String> listNamesFirefox = Arrays.asList("testcontainerfirefox", "testcontainermozilla", "testcontainermozillafirefox", "testcontainergecko");
    
	public WebDriver initDockerDriver(File folderDownloads, Properties prop, String nameDriver,
            Map<String, WebDriver> contextsDriver, File folderTestCase) {
        WebDriver driver;
        if (contextsDriver.get(nameDriver) != null) {
            driver = contextsDriver.get(nameDriver);
        }
        else {
            ContainerManager.startContainer(folderDownloads, prop, folderTestCase);
            driver = ContainerManager.container.getWebDriver();
            driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
            contextsDriver.put(nameDriver, driver);
        }
        return driver;
    } 
        
	public ChromeOptions dockerChromeOptions(File folderDownloads, Properties prop) {
        driverOptions = prop.getProperty("WebDriver.DRIVER_OPTIONS").split(", ");
        HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
        chromePrefs.put("profile.default_content_settings.popups", 0);
        chromePrefs.put("download.default_directory", folderDownloads.getAbsolutePath());
        ChromeOptions options = new ChromeOptions();
        options.addArguments(driverOptions);
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--allow-file-access-from-files");
        options.setExperimentalOption("prefs", chromePrefs);
        return options;
    }
    
	public FirefoxOptions dockerFirefoxOptions(File folderDownloads, Properties prop) {
        driverOptions = prop.getProperty("WebDriver.DRIVER_OPTIONS").split(", ");
        FirefoxProfile profile = new FirefoxProfile();
        profile.setPreference("browser.download.manager.useWindow", false);
        profile.setPreference("browser.download.dir", folderDownloads.getAbsolutePath());
        profile.setPreference("browser.download.manager.showAlertOnComplete", true);
        profile.setPreference("browser.helperApps.neverAsk.saveToDisk",
            "text/plain, application/vnd.openxmlformats-officedocument.spreadsheetml.sheet, application/octet-stream,"
            + "application/binary, text/csv, application/csv, application/excel,"
            + "text/comma-separated-values, text/xml, application/xml");
        profile.setPreference("browser.download.folderList",2);
        FirefoxOptions optionsFirefox = new FirefoxOptions();
        optionsFirefox.setProfile(profile);
        return optionsFirefox;
    }
    
    public Capabilities driverSelector(File folderDownloads, Properties prop) {
        driverType = prop.getProperty("WebDriver.BROWSER").toLowerCase().replace(" ", "");
        if (listNamesChrome.contains(driverType)) {
            return dockerChromeOptions(folderDownloads, prop);
        } else if (listNamesFirefox.contains(driverType)) {
            return dockerFirefoxOptions(folderDownloads, prop);
        } else {
            logger.info("The indicated options does not match the available TestContainer [Chrome, Firefox], it is launched by default on TestContainer Chrome");
            return dockerChromeOptions(folderDownloads, prop);
        }
    }

}