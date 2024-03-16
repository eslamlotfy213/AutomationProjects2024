package tests;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    private WebDriver driver;
    public String baseUrl;
    public int sec= 0;
    protected String myFile = "src/test/data.properties";

    @BeforeSuite
    public void setDriver() throws IOException {
        Properties pro = new Properties();
        FileInputStream fis = new FileInputStream(myFile);
        pro.load(fis);
        String browserName = pro.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome"))
        {
            WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();

        }else if (browserName.equalsIgnoreCase("firefox")){

            WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("IE")) {

            WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }

        baseUrl="http://live.techpanda.org/";
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        driver.manage().window().maximize();
    }



    @AfterSuite
    public void tearDown(){

        if (null != driver) {
            driver.close();
            driver.quit();
        }
    }


    public WebDriver getDriver()
    {
        return driver;
    }



    @AfterMethod
    public void TakeScreenshot() throws IOException {
        sec = sec + 1;
        File srcFile =((TakesScreenshot)getDriver()).getScreenshotAs(OutputType.FILE);
        String png= ("D:\\Project\\LiveEcommeceproject\\src\\test\\Screens"+ sec + ".png");
        FileUtils.copyFile(srcFile, new File(png));

    }


}
