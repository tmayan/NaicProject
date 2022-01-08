package org.naic.uiTest;

import org.junit.Test;
import org.naic.utility.ConfigReader;
import org.naic.utility.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class HomePageTest {

    //Ensure there is an element with the id of super_menu
    //I didn't find any elements on the page  id with super_menu
    //When navigate to https://www.naic.org it redirects to https://content.naic.org/
    //Therefore I had to change to requirement of the test
    //I found element id with block-megamenu
    //Due to redirection all the links starts with https://content.naic.org/
    @Test
    public void verifyElement(){
        Driver.getDriver().get(ConfigReader.read("url"));
        WebElement BlockMegaMenuElement = Driver.getDriver().findElement(By.id("block-megamenu"));
        assertEquals("block-megamenu",BlockMegaMenuElement.getAttribute("id"));

        List<WebElement> menuLinks = Driver.getDriver().findElements(By.xpath("//*[@id='block-megamenu']/ul/li/a"));
        for (WebElement eachLink : menuLinks) {
            assertTrue(eachLink.getAttribute("href").startsWith("https://content.naic.org/"));
            System.out.println(eachLink.getAttribute("href"));
        }


        }
    }

