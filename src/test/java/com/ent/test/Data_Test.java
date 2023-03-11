package com.ent.test;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.HashMap;

public class Data_Test {
    Logger LOGGER=Logger.getLogger( this.getClass().getName() );

    @Test(dataProvider = "one", dataProviderClass = Dataproviderclass.class)
    public void navigateForContactDetailsToLocation(HashMap<String, String> inmap) throws Exception {
        System.setProperty( "webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe" );
        WebDriver driver = new ChromeDriver();
        LOGGER.info( "Driver" );
        driver.get( "https://qa-insyghts.entytle.com/en/login" );
        LOGGER.info( "Initializa" );
        driver.manage().window().maximize();
        driver.findElement( By.xpath( "//div[@class='form-group email']//input" ) ).sendKeys( inmap.get( "Username" ) );
        driver.findElement( By.xpath( "//div[@class='form-group password']//input" ) ).sendKeys( inmap.get("Password" ) );
        driver.findElement( By.xpath( "//div[@class='col-sm-7']//button//span" ) ).click();

    }


}
