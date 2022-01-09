package org.naic.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Driver {
    private static WebDriver obj ;

    private Driver(){ }


    public static WebDriver getDriver(){

        String browserName = ConfigReader.read("browser") ;

        if(obj == null){

            switch (browserName ){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;
                case "edge" :
                    WebDriverManager.edgedriver().setup();
                    obj = new EdgeDriver();
                    break;

                default:
                    obj = null ;
                    System.out.println("UNKNOWN BROWSER TYPE!!! " + browserName);
            }
            return obj ;



        }else{

            return obj ;

        }

    }


    public static void closeBrowser(){

        if(obj != null ){
            obj.quit();

            obj = null ;
        }

    }

}
