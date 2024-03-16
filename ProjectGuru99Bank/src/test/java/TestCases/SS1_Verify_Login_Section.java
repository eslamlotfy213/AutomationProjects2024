package TestCases;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import util.Util;

import java.io.IOException;


public class SS1_Verify_Login_Section extends BaseTesT{


    @Test(dataProvider = "getData")
    public void EnterValidUseridAndPassword(String email, String password) throws IOException
    {
//       DataDriven d=new DataDriven();
//       ArrayList data=d.getData("Login", "TestCases","testdata", "src/main/java/DataDriven/demodata.xlsx");

       homePage.EnterLogincredentials(email,password);
       homePage.ClickLogin();
       String Title=driver.getTitle();
       System.out.println(Title);
       Assert.assertTrue(Title.contains(Util.EXPECT_TITLE));

        String pageText = driver.findElement(By.xpath("//tr[@class='heading3']")).getText();
        System.out.println("pageText"+pageText);
        // Extract the dynamic text mngrXXXX on page

        String[] parts = pageText.split(":");
        System.out.println("parts"+parts[1]);

        String dynamicText = parts[1].trim();
        System.out.println("dynamicText "+dynamicText);

        String subText2= dynamicText.substring(0,4);
        System.out.println("dynamicText2 :"+subText2);

        Assert.assertEquals(subText2,"mngr");

   }


   @DataProvider
   public Object[][] getData()
   {
      return new Object[][]
              {
                      {"mngr538906", "nUrUbEj"}
              };
   }



}