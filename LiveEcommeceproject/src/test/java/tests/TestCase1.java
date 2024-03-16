package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.HomePage;

public class TestCase1 extends BaseTest {

    private  StringBuffer verification = new StringBuffer();
    private WebDriver driver;
    HomePage homePage ;


    @Test
    public void test1(){
         driver = getDriver();
         homePage  = new HomePage(driver);
         driver.get(baseUrl);
         String demosite = homePage.getPageTitle();
         String  ExpectedTitle = "THIS IS DEMO SITE FOR   ";
         Assert.assertEquals(demosite,ExpectedTitle);
         homePage.ClickonMobile();
         homePage.Selectmenu("Name");
    }

}