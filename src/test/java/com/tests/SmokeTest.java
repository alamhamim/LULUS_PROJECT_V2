package com.tests;

import com.pages.*;
import org.testng.annotations.Test;

public class SmokeTest extends BaseTest{

    /*All the test case is here*/
    HomePage homePage;
    WinterPage winterPage;
    JacketPage jacketPage;
    SweaterPage sweaterPage;
    HoodiePage hoodiePage;
    BlazerPage blazerPage;
    GlovePage glovePage;
    HatPage hatPage;

    @Test(priority = 1)
    public void homePageTitleTest() {
        homePage = new HomePage(driver);
        homePage.verifyHomePageByTitle();
    }


    @Test(priority = 2, dependsOnMethods = {"homePageTitleTest"})
    public void clickOnWinterTest() {
        homePage = new HomePage(driver);
        winterPage = homePage.clickOnWinterClothes();
    }

    @Test(priority = 3)
    public void verifyWinterTestSubMenu() {
        winterPage = new WinterPage(driver);
        winterPage.verifyTheSubMenus();
    }

    @Test(priority = 4)
    public void verifyJacketPageProduct() {
        winterPage = new WinterPage(driver);
        jacketPage = winterPage.winterClick();
        jacketPage.verifyAllProduct();
    }

    @Test(priority = 5)
    public void verifySweaterPageProduct() {
        winterPage = new WinterPage(driver);
        sweaterPage = winterPage.sweaterClick();
        sweaterPage.verifyAllTheProduct();
    }

    @Test(priority = 6)
    public void verifyHoodiePageProduct() {
        winterPage = new WinterPage(driver);
        hoodiePage = winterPage.hoodieClick();
        hoodiePage.verifyAllProduct();
    }

    @Test(priority = 7)
    public void verifyBlazerPageProduct() {
        winterPage = new WinterPage(driver);
        blazerPage = winterPage.blazersClick();
        blazerPage.verifyBalzerText();
    }

    @Test(priority = 8)
    public void verifyGlovePageProduct() {
        winterPage = new WinterPage(driver);
        glovePage = winterPage.glovePageClick();
        glovePage.verifyAllProduct();
    }

    @Test(priority = 9)
    public void verifyHatPageProduct() {
        winterPage = new WinterPage(driver);
        hatPage = winterPage.hatPageClick();
        hatPage.verifyAllProduct();
    }

}
