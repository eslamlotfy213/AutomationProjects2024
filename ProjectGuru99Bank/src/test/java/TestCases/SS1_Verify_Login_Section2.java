package TestCases;

import DataDriven.GetDataFromExcel;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;


public class SS1_Verify_Login_Section2  extends BaseTesT{

    DataFormatter formatter = new DataFormatter();
    @Test(dataProvider = "getData")
    public void EnterValidUseridAndPassword(String username, String password) throws IOException, InterruptedException {
        homePage.EnterLogincredentials(username, password);
        homePage.ClickLogin();

        try {
        // Switching to Alert
        Alert alert = driver.switchTo().alert();
        // Capturing alert message.
        String alertMessage= driver.switchTo().alert().getText();
        // Displaying alert message
        System.out.println(alertMessage);
        // Accepting alert
        alert.accept();
        }catch (NoAlertPresentException Ex){
            System.out.println(Ex.getMessage());
        }


        String Title = driver.getTitle();
        System.out.println(Title);
        Assert.assertEquals(Title,Util.EXPECT_TITLE);

    }


    @DataProvider
    public Object[][] getData() {
        GetDataFromExcel getDataFromExcel = new GetDataFromExcel();
        try {
            return getDataFromExcel.getData("TestData2", "src/main/java/DataDriven/demodata.xlsx");
        } catch (IOException e) {
            // Handle the exception (log, throw a custom exception, etc.)
            e.printStackTrace();
            return null; // or throw a custom exception
        }
    }





}