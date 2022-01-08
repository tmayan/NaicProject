package org.naic.utility;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Driver {
    private static WebDriver obj ;

    private Driver(){ }

    /**
     * Return obj with only one WebDriver instance
     * @return same WebDriver if exists , new one if null
     */
    public static WebDriver getDriver(){
        // read the browser type you want to launch from properties file
        String browserName = ConfigReader.read("browser") ;

        if(obj == null){

            switch (browserName ){
                case "chrome" :
                    WebDriverManager.chromedriver().setup();
                    obj = new ChromeDriver();
                    break;
                case "firefox" :
                    WebDriverManager.edgedriver().setup();
                    obj = new EdgeDriver();
                    break;

                default:
                    obj = null ;
                    System.out.println("UNKNOWN BROWSER TYPE!!! " + browserName);
            }
            return obj ;



        }else{
//
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
