package com.browsers;

import com.logger.GetLogger;
import org.apache.commons.logging.Log;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.util.concurrent.TimeUnit;

public class BrowserConfig {

   static Logger logger = GetLogger.getLogger(BrowserConfig.class);

    public static WebDriver startAPP(WebDriver driver, String browserName, String url) {
        if (browserName.equalsIgnoreCase("chrome")) {
            System.setProperty("webdriver.chrome.driver", "Drivers/chromedriver");
            driver = new ChromeDriver();
            logger.debug(browserName+" is opened");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", "Drivers/geckdriver");
            driver = new FirefoxDriver();
            logger.debug(browserName+" is opened");
        } else if (browserName.equalsIgnoreCase("opera")) {
            System.setProperty("webdriver.opera.driver", "Drivers/operadriver");
            driver = new OperaDriver();
            logger.debug(browserName+" is opened");
        } else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.safari.driver", "Drievrs/safarfidriver");
            driver = new SafariDriver();
            logger.debug(browserName+" is opened");
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", "Drivers/msedgedriver");
            driver = new EdgeDriver();
            logger.debug(browserName+" is opened");
        } else {
            /*Logger class should be here*/
            logger.debug(browserName+" is not supported by this framework yet!!");
        }

        //
        driver.manage().window().maximize();
        //
        //
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        driver.get(url);
        //
        return driver;
    }

    public void closeAPP(WebDriver driver) {
        driver.quit();
        logger.debug("Test is done");
    }
}
