package com.util;

import com.google.common.io.Files;
import com.logger.GetLogger;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;

public class Helper {

    public static String getDateAndTime() {
        SimpleDateFormat date = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date currentDate = new Date();
        return date.format(currentDate);

    }

    public static void takeScreenShot(WebDriver driver) throws IOException {
        TakesScreenshot scrShot = ((TakesScreenshot) driver);
        File SrcFile = scrShot.getScreenshotAs(OutputType.FILE);
        Files.copy(SrcFile, new File("ScreenShots/pic_" + getDateAndTime() + ".png"));
    }

    public static Properties readProperties(String path) throws IOException {
        FileInputStream file = new FileInputStream(new File(path));
        Properties properties = new Properties();
        properties.load(file);
        return properties;
    }

    public static void verifyTitle(WebDriver driver, String title) {
        if (driver.getTitle().equals(title)) {
            System.out.println("Title is verified");
        } else {
            System.out.println("Can not verify the title");
            Assert.fail();
        }
    }

    public static WebElement elementReady(WebDriver driver, WebElement element, int sec) {
        WebDriverWait wait = new WebDriverWait(driver, sec);
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }

    public static ArrayList<Object> getActualText(List<WebElement> elements) {
        ArrayList<Object> datas = new ArrayList<Object>();
        for (WebElement element : elements) {
            datas.add(element.getText());
        }
        return datas;
    }

    public static ArrayList<String> expectedText(String[] args) {
        ArrayList<String> datas = new ArrayList<String>();
        for (String arg : args) {
            datas.add(arg);
        }
        return datas;
    }

    public static void compareText(ArrayList actualText, ArrayList expectedText) {
        Iterator iterator = actualText.iterator();
        Iterator iterator1 = expectedText.iterator();

        //
        while (iterator.hasNext() && iterator1.hasNext()) {
            if (iterator.next().equals(iterator1.next())) {
                System.out.println(iterator.next()+" "+iterator1.next()+" is verified");
            } else {
                System.out.println("Can not verify "+iterator.next()+" "+iterator1.next());
            }
        }
    }

    /*public static void click(List<WebElement> elementsOne, List<WebElement> elementsTwo, String[] args, WebDriver driver) {
        for (WebElement element1 : elementsOne) {
            element1.click();

            //
            for (WebElement element2 : elementsTwo) {
                ArrayList<Object> textOne = getActualText(elementsTwo);
                ArrayList<String> textTwo = expectedText(args);
                compareText(textTwo, textOne);
                driver.navigate().back();
            }
        }
    }*/


}
