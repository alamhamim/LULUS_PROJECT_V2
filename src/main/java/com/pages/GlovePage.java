package com.pages;

import com.pageData.GlovePageData;
import com.util.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class GlovePage {
    private WebDriver driver;


    public GlovePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "allGloveText")
    List<WebElement> gloveText;

    public void verifyAllProduct() {
        ArrayList<Object> actualText = Helper.getActualText(gloveText);
        ArrayList<String> expectedText = Helper.expectedText(GlovePageData.glovePageText);
        Helper.compareText(actualText, expectedText);

    }
}
