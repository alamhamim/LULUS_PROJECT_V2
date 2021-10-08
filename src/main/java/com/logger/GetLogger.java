package com.logger;

import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class GetLogger {

    public static Logger getLogger(Class name) {
        DOMConfigurator.configure("Test-Data/logger.xml");
        Logger logger = Logger.getLogger(name);
        return logger;
    }
}
