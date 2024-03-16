package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class HomePage extends PageBase{



    private WebDriver driver;

    public HomePage(WebDriver driver){
        super(driver);
        // super(driver);
        this.driver=driver;
    }


    //locators

    private By userIDText= By.cssSelector("input[name='uid'");
    private By passwordText =By.name("password");
    private By loginbutton = By.xpath("//input[@type='submit']");
    private By resetbutton = By.xpath("//input[@type='reset']");






     public void EnterLogincredentials(String id,String pass){
         SendElementBy(userIDText,id);
         SendElementBy(passwordText,pass);
     }



     public void ClickLogin(){
         ClickElementBy(loginbutton);
     }




    public void Clickreset(){
        ClickElementBy(resetbutton);
    }




}
