package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

public class HomePage extends PageBase {


    public HomePage(WebDriver driver) {
        super(driver);

    }


    By demositeheader = By.cssSelector("h2");

    By ClickonMobile=  By.xpath("//a[contains(text(),'Mobile')]");

    By Selectmenu = By.tagName("select");




    public void ClickonMobile(){

        driver.findElement(ClickonMobile).click();
    }


    public  String getPageTitle(){

        return driver.findElement(demositeheader).getText();
    }


      public void Selectmenu(String value){

       new Select(driver.findElement(Selectmenu)).selectByVisibleText(value);

   }



}

