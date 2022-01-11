package com.dedalow;

import com.dedalow.utils.Utils;
import com.dedalow.utils.DriverInit;
import com.dedalow.utils.Constant;

import java.io.File;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.util.Optional;
import java.util.Properties;
import java.util.logging.Logger;

import org.testcontainers.containers.BrowserWebDriverContainer;
import org.testcontainers.containers.VncRecordingContainer.VncRecordingFormat;
import org.testcontainers.lifecycle.TestDescription;

public class ContainerManager {

    public static BrowserWebDriverContainer<?> container;
    private static Logger logger = Logger.getLogger("Log 1");
	public static FileSystem fileSystem = FileSystems.getDefault();
    public static String resources =  System.getProperty("user.dir") + fileSystem.getSeparator() + "resources";
    public static DriverInit driverInit = new DriverInit();
    public static Launcher launcher = new Launcher();
    public static Constant constant = launcher.constant;
 
    public static void startContainer(File folderDownloads, Properties prop, File folderTestCase) {
        File folderScreen = new File(folderTestCase + fileSystem.getSeparator() + "screenshots");
		container = new BrowserWebDriverContainer<>().withRecordingMode(
				BrowserWebDriverContainer.VncRecordingMode.RECORD_FAILING, folderScreen, VncRecordingFormat.MP4);
        container.withFileSystemBind(folderDownloads.getAbsolutePath(), "/home/seluser/Downloads");
        container.withCapabilities(driverInit.driverSelector(folderDownloads, prop));
        logger.info("Starting docker container..");
        container.start();
    }
 
    public static void stopContainer(String finalResult, String caseName) {
		if (null != container && container.isRunning()) {

			Optional<Throwable> optional = "OK".equalsIgnoreCase(finalResult)
                ? Optional.empty() : Optional.of(new AssertionError());

			container.afterTest(new TestDescription() {

				@Override
				public String getTestId() {
					return getFilesystemFriendlyName();
				}

				@Override
				public String getFilesystemFriendlyName() {
					return caseName;
				}

			}, optional);

			logger.info("Stop docker container..");
			container.stop();
		}
	}
}