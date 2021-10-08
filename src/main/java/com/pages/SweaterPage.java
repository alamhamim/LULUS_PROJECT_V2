package com.pages;

import com.pageData.SweaterPageData;
import com.util.Helper;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class SweaterPage {
    private WebDriver driver;

    public SweaterPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);

    }

    @FindBy(xpath = "allProductText")
    List<WebElement> allProduct;

    public void verifyAllTheProduct() {
        ArrayList<Object> actualText = Helper.getActualText(allProduct);
        ArrayList<String> expectedText = Helper.expectedText(SweaterPageData.sweaterPageText);
        Helper.compareText(actualText, expectedText);

    }

}
