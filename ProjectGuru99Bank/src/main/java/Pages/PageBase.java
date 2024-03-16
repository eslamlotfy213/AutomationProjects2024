package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class PageBase {


    private WebDriver driver;

    public PageBase(WebDriver driver){

        this.driver =driver;
    }



    public void ClickElementBy(By by){
        driver.findElement(by).click();
    }


    public void SendElementBy(By by,String text){
        driver.findElement(by).sendKeys(text);
    }

    public void ClickWebElement(WebElement webElement){

        webElement.click();
    }

    public void SendWebElement(WebElement webElement,String text){

        webElement.sendKeys(text);
    }

    public void waitForElementToDisappear(By findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(driver.findElement(findBy)));
    }

    public void waitForWebElementToDisappear(WebElement findBy)
    {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        wait.until(ExpectedConditions.invisibilityOf(findBy));
    }


}
