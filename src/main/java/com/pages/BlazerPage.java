package com.pages;

import com.pageData.BlazerPageData;
import com.util.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class BlazerPage {
    private WebDriver driver;

    public BlazerPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "allBlazerText")
    List<WebElement> blazerText;

    public void verifyBalzerText() {
        ArrayList<Object> actualText = Helper.getActualText(blazerText);
        ArrayList<String> expectedText = Helper.expectedText(BlazerPageData.blazerPageText);
        Helper.compareText(actualText, expectedText);

    }
}
