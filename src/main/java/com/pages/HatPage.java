package com.pages;

import com.pageData.HatPageData;
import com.util.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HatPage {
    private WebDriver driver;

    public HatPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "allHatText")
    List<WebElement> hatText;

    public void verifyAllProduct() {
        ArrayList<Object> actualText = Helper.getActualText(hatText);
        ArrayList<String> expectedText = Helper.expectedText(HatPageData.hatPageText);
        Helper.compareText(actualText, expectedText);

    }
}
