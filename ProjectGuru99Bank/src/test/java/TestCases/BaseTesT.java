package TestCases;

import Pages.HomePage;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.io.FileHandler;
import org.testng.annotations.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

public class BaseTesT {

    public WebDriver driver;
    private String baseUrl;
    public  HomePage homePage;
    Properties pro;
    private int sec= 0;
    protected String myFile = "src/main/java/util/data.properties";


    public WebDriver setDriver() throws IOException {
        pro = new Properties();
        FileInputStream fis = new FileInputStream(myFile);
        pro.load(fis);
        String browserName = pro.getProperty("browser");

        if (browserName.equalsIgnoreCase("chrome"))
        {
           // WebDriverManager.chromedriver().setup();
            driver = new ChromeDriver();
        }else if (browserName.equalsIgnoreCase("firefox")){

           // WebDriverManager.firefoxdriver().setup();
            driver = new FirefoxDriver();
        }else if (browserName.equalsIgnoreCase("IE")) {

            //WebDriverManager.iedriver().setup();
            driver = new InternetExplorerDriver();
        }
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
         return driver;
    }


    @BeforeMethod(alwaysRun = true)
    public HomePage launchingApplication() throws IOException
    {
        driver = setDriver();
        if (driver != null) {
            homePage= new HomePage(driver);
            driver.get(pro.getProperty("baseUrl"));
            return homePage;
        }
        return null;
    }



    @AfterMethod(alwaysRun = true)
    public void tearDown(){

        if (driver!=null) {
            driver.close();
        }
    }



    @AfterMethod
    public void TakeScreenshot() throws IOException {
            sec += 1;
            File srcFile =((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            String png= ("src/Photos/screens"+ sec + ".png");
            FileUtils.copyFile(srcFile, new File(png));

    }


    public String getScreenshot(String testCaseName, WebDriver driver) throws IOException {
        String screenshotPath = null;

        try {

            //take screenshot and save it in a file

            File sourceFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

            //copy the file to the required path

            File destinationFile = new File(System.getProperty("user.dir") + "\\reports\\" + testCaseName + ".png");

            FileHandler.copy(sourceFile, destinationFile);

            String[] relativePath = destinationFile.toString().split("reports");

            screenshotPath = ".\\" + relativePath[1];

        } catch (Exception e) {

            System.out.println("Failure to take screenshot " + e);

        }

        return screenshotPath;

    }


}
