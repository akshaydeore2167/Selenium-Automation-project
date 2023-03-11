package com.ent.test;


import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

import java.net.URL;
import java.util.HashMap;

public class Selenium_Grid_Docker_Test {


    @Test(dataProvider = "one", dataProviderClass = Dataproviderclass.class)
    public void navigateForContactDetailsToLocation(HashMap<String, String> inmap) throws Exception {
        DesiredCapabilities dc= DesiredCapabilities.chrome();
        URL url=new URL("http://localhost:4444/wd/hub");
        RemoteWebDriver driver=new RemoteWebDriver( url,dc );


        driver.get( "https://qa-insyghts.entytle.com/en/login" );

        driver.manage().window().maximize();
        driver.findElement( By.xpath( "//div[@class='form-group email']//input" ) ).sendKeys( inmap.get( "Username" ) );
        driver.findElement( By.xpath( "//div[@class='form-group password']//input" ) ).sendKeys( inmap.get("Password" ) );
        driver.findElement( By.xpath( "//div[@class='col-sm-7']//button//span" ) ).click();

    }


}
