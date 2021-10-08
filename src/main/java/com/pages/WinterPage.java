package com.pages;

import com.logger.GetLogger;
import com.pageData.HatPageData;
import com.pageData.HoodiePageData;
import com.pageData.WinterPageData;
import com.util.Helper;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class WinterPage {
    private WebDriver driver;
    Properties properties;
    static Logger logger = GetLogger.getLogger(WinterPage.class);

    public WinterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        try {
            properties = Helper.readProperties("Page-Data/homePageData.properties");
        } catch (IOException e) {
            e.printStackTrace();
            logger.debug("Please check the WinterPage Constructor");
        }
    }

    /*Jackets, Sweaters, Hoodies, Blazers, Hats
    * Gloves*/

    @FindBy(xpath = "submenus")
    List<WebElement> subMenus;

    @FindBy(xpath = "Jackets")
    WebElement jackets;

    @FindBy(xpath = "Sweaters")
    WebElement sweaters;

    @FindBy(xpath = "hoodie")
    WebElement hoodies;

    @FindBy(xpath = "Blazer")
    WebElement blazers;

    @FindBy(xpath = "hats")
    WebElement hats;

    @FindBy(xpath = "gloves")
    WebElement gloves;

    public void verifyTheSubMenus() {

        ArrayList<Object> actual_sub_menu_text = Helper.getActualText(subMenus);
        ArrayList<String> expected_sub_menu_text = Helper.expectedText(WinterPageData.subMenus);
        Helper.compareText(actual_sub_menu_text, expected_sub_menu_text);
    }

    public JacketPage winterClick() {
        Helper.elementReady(driver, jackets, 10);
        return new JacketPage(driver);
    }

    public SweaterPage sweaterClick() {
        Helper.elementReady(driver, sweaters, 10);
        return new SweaterPage(driver);
    }

    public HoodiePage hoodieClick() {
        Helper.elementReady(driver, hoodies, 10);
        return new HoodiePage(driver);
    }

    public BlazerPage blazersClick() {
        Helper.elementReady(driver, blazers, 10);
        return new BlazerPage(driver);
    }

    public HatPage hatPageClick() {
        Helper.elementReady(driver, hats, 10);
        return new HatPage(driver);
    }

    public GlovePage glovePageClick() {
        Helper.elementReady(driver, gloves, 10);
        return new GlovePage(driver);
    }
}
