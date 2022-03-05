package com.vytrack.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {

    /*
    Creating a private constructor so we are closing the access to the object of this class from otside the class
     */
    private Driver(){}
    //We make WebDriver private because we want to close access from outside the class
    //we make it static because we will use it in a static method
    private static WebDriver driver;
    //create a reusable utility method which will return same driver instance when we call it

    public static WebDriver getDriver (){
      if(driver==null){
          /*
          We read our browser type from configuration prop this way we can control which browser is opened from outside our code
           */
String browserType= ConfigurationReader.getProperty("browser");
switch (browserType){
    case "chrome":
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        break;
    case "firefox":
        WebDriverManager.firefoxdriver().setup();
        driver=new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        break;
}


      }
      return driver;
    }


//try to create a method CloseDriver//assigning driver back to null
public static void closeDriver(){
    if(driver!=null){
        driver.quit();
        driver=null;
    }
}

}
