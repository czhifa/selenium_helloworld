package com.asurion.optimalpath.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.util.logging.Logger;

public class SelectBrowser {

	Logger log = Logger.getLogger("BrowserSelection");

	public WebDriver selectBrowser() throws Exception {

		ReadPropertiesFile prop = new ReadPropertiesFile();
		WebDriver driver = null;

		String browser = prop.ReadPropertiesFileByKey("browser");

		while (browser == null) {
			log.info("Browser is not specified in Configuration file. Terminating process !!!");
			System.exit(0);
		}
		if (browser.equalsIgnoreCase("firefox")) {
			driver = new FirefoxDriver();
			log.info("Browser selected for testing is :  Mozilla Firefox");
		} else if (browser.equalsIgnoreCase("chrome")) {
			System.setProperty("webdriver.chrome.driver", "C:\\Automation\\workspace\\OpTest\\src\\chromedriver.exe");
			driver = new ChromeDriver();
			log.info("Browser selected for testing is :  Google Chrome");

		} else if (browser.equalsIgnoreCase("ie")) {
			System.setProperty("webdriver.ie.driver", "C:\\Automation\\workspace\\OpTest\\src\\IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			log.info("Browser selected for testing is :  Internet Explorer");

		} else {
			log.info("Selected browser value should be either firefox or chrome or ie --> Update in Configuration file is required");
			System.exit(0);
		}
		return driver;
	}
}