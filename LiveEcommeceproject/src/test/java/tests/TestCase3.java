//import org.openqa.selenium.By;
//import org.testng.Assert;
//import org.testng.annotations.Test;
//
//public class TestCase3 extends tests.BaseTest {
//
//
//    private  StringBuffer verification = new StringBuffer();
//
//
//    @Test
//    public void test3(){
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
//
//        getDriver().findElement(By.xpath("(//button[@class='button btn-cart'])[1]")).click();
//
//        getDriver().findElement(By.cssSelector("input[title='Qty']")).sendKeys("1000");
//
//        getDriver().findElement(By.cssSelector("button[title='Update']")).click();
//
//        String ErrorValidation =  getDriver().findElement(By.xpath("//p[@class='item-msg error']")).getText();
//
//        System.out.println(ErrorValidation);
//
//
//        getDriver().findElement(By.cssSelector("#empty_cart_button")).click();
//
//       String emptymessage =  getDriver().findElement(By.tagName("h1")).getText();
//       String expectedmessage = "SHOPPING CART IS EMPTY";
//        System.out.println(emptymessage);
//        System.out.println(expectedmessage);
//
//
//        Assert.assertEquals(emptymessage,expectedmessage);
//
//                   }
//
//
//
//
//}
