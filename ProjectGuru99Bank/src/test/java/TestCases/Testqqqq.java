package TestCases;

import org.openqa.selenium.By;

public class Testqqqq {


    public static void main(String[] args) {


        String pageText = "Manger Id : mngr538906";
        System.out.println("pageText"+pageText);
        // Extract the dynamic text mngrXXXX on page

        String[] parts = pageText.split(":");
        System.out.println("parts"+parts[1]);

        String dynamicText = parts[1].trim();
        System.out.println("dynamicText :"+dynamicText);
        System.out.println("dynamicText_length :"+dynamicText.length());


        String dynamicText2= dynamicText.substring(0,4);
        System.out.println("dynamicText2 :"+dynamicText2);

    }
}
