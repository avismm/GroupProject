package utils;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;

public class CommonMethods extends PageInitializer {//inheriting the properties of one pageInitializer class into another class
    public static WebDriver driver;

    public static void openBrowserAndLaunchApplication(){
        ConfigReader.readProperties(Constants.CONFIGURATION_FILEPATH);
        switch (ConfigReader.getPropertyValue("browser")){
            case "chrome":
                driver=new ChromeDriver();
                break;
            case "firefox":
                driver=new FirefoxDriver();
                break;
            default:
                throw new RuntimeException(("Invalid browser name"));
        }

        driver.manage().window().maximize();
        driver.get(ConfigReader.getPropertyValue("url"));
        initializePageObjects();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(Constants.IMPLICIT_WAIT));
    }

    public  static void sendText(WebElement element, String textToSend){
        element.clear();
        element.sendKeys(textToSend);
    }

    public static WebDriverWait getWait() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(Constants.EXPLICIT_WAIT));
        return wait;
    }

    public  static void waitForClickability(WebElement element){
        getWait().until(ExpectedConditions.elementToBeClickable(element));
    }
    public void click(WebElement element){
        waitForClickability(element);
        element.click();
    }
    public static JavascriptExecutor getJSExecutor(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        return js;
    }
    public static void jsClick(WebElement element){
        getJSExecutor().executeScript("arguments[0].click();", element);
    }

    public void closeBrowser(){
        driver.quit();
    }
    public static byte[] takeScreenshot(String fileName){
        //generating and storing screenshots
        TakesScreenshot ts=(TakesScreenshot) driver;
        byte[] picByte =ts.getScreenshotAs(OutputType.BYTES);
        File sourceFile =ts.getScreenshotAs((OutputType.FILE));
        try {
            FileUtils.copyFile(sourceFile, new File(Constants.SCREENSHOT_FILEPATH+fileName+" "+getTimeStamp("yyyy-MM-dd-HH-mm-ss")+" .png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return picByte;
    }
    public static String getTimeStamp (String pattern){
        Date date = new Date();
        SimpleDateFormat sdf =new SimpleDateFormat(pattern);
        return sdf.format(date);

    }

}
