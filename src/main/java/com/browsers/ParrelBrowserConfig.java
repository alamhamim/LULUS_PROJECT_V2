package com.browsers;

import com.logger.GetLogger;
import org.apache.log4j.Logger;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class ParrelBrowserConfig {
    static Logger logger = GetLogger.getLogger(ParrelBrowserConfig.class);

    public static WebDriver startAPP(WebDriver driver, String browserName, String url) throws MalformedURLException {
        DesiredCapabilities cap = null;
        //
        if (browserName.equalsIgnoreCase("chrome")) {
            cap = DesiredCapabilities.chrome();
            cap.setPlatform(Platform.ANY);
            logger.debug(browserName + " is opened");
        } else if (browserName.equalsIgnoreCase("firefox")) {
            cap = DesiredCapabilities.firefox();
            cap.setPlatform(Platform.ANY);
            logger.debug(browserName + " is opened");
        } else if (browserName.equalsIgnoreCase("safari")) {
            cap = DesiredCapabilities.safari();
            cap.setPlatform(Platform.ANY);
            logger.debug(browserName + " is opened");
        } else if (browserName.equalsIgnoreCase("edge")) {
            cap = DesiredCapabilities.edge();
            cap.setPlatform(Platform.ANY);
            logger.debug(browserName + " is opened");
        } else if (browserName.equalsIgnoreCase("opera")) {
            cap = DesiredCapabilities.operaBlink();
            cap.setPlatform(Platform.ANY);
            logger.debug(browserName + " is opened");
        } else {
            logger.debug(browserName + " is not supported by this framework yet!!");
        }

        //
        driver = new RemoteWebDriver(new URL(url), cap);
        //
        return driver;
    }

}
