package com.pages;

import com.pageData.HoodiePageData;
import com.util.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class HoodiePage {
    private WebDriver driver;


    public HoodiePage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "allHoodiElement")
    List<WebElement> allProducts;

    public void verifyAllProduct() {
        ArrayList<Object> actualText = Helper.getActualText(allProducts);
        ArrayList<String> expectedText = Helper.expectedText(HoodiePageData.hoodiePageText);
        Helper.compareText(actualText, expectedText);

    }

}
