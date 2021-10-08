package com.pages;

import com.logger.GetLogger;
import com.util.Helper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import java.io.IOException;
import java.util.Properties;

public class HomePage {
    private WebDriver driver;
    Logger logger = GetLogger.getLogger(HomePage.class);
    Properties properties;

    public HomePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try {
            properties = Helper.readProperties("Page-Data/homePageData.properties");
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("Please check the HomePage Constructor");
        }
    }

    @FindBy(xpath = "winter clothes")
    WebElement winterClothes;

    public void verifyHomePageByTitle() {
        Helper.verifyTitle(driver, properties.getProperty("title"));
    }

    public WinterPage clickOnWinterClothes() {
        Helper.elementReady(driver, winterClothes, 10);
        logger.debug("Clicked on Winter Clothes");
        return new WinterPage(driver);
    }


}
