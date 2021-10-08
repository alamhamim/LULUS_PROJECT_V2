package com.pages;

import com.pageData.JackectPageData;
import com.util.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class JacketPage {
    private WebDriver driver;

    public JacketPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "allProduct")
    List<WebElement> allProduct;

    public void verifyAllProduct() {
        ArrayList<Object> actualText = Helper.getActualText(allProduct);
        ArrayList<String> expectedText = Helper.expectedText(JackectPageData.jackPageText);
        Helper.compareText(actualText, expectedText);
    }
}
