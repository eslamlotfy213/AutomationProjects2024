//import org.openqa.selenium.By;
//import org.openqa.selenium.support.ui.Select;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class TestCase2 extends tests.BaseTest {
//
//
//    private  StringBuffer verification = new StringBuffer();
//
//
//    @Test
//    public void test1(){
//        getDriver().get(baseUrl);
//        String demosite = getDriver().findElement(By.cssSelector("h2")).getText();
//        System.out.println("ActualTitle "+demosite);
//        String  ExpectedTitle = "THIS IS DEMO SITE FOR   ";
//        try {
//            Assert.assertEquals(demosite,ExpectedTitle);
//            verification.append(demosite.toString());
//        }catch (Error e ){
//            System.out.println(verification.append(e.toString()));
//        }
//
//        getDriver().findElement(By.xpath("//a[contains(text(),'Mobile')]")).click();
//        new Select(getDriver().findElement(By.tagName("select"))).selectByVisibleText("Name");
//
//       String priceonHomepage= getDriver().findElement(By.cssSelector("#product-price-1 > span.price")).getText();
//       System.out.println(priceonHomepage);
//
//       getDriver().findElement(By.xpath("//a[@title='Sony Xperia']")).click();
//
//
//
//        String priceondetails = getDriver().findElement(By.cssSelector("span.price")).getText();
//        System.out.println(priceondetails);
//
//        Assert.assertEquals(priceonHomepage,priceondetails);
//
//    }
//
//
//
//
//}
