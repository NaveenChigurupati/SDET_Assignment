package seleniumWithJava;

import io.github.bonigarcia.wdm.WebDriverManager;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;

import java.time.Duration;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

public class SeleniumTask {
    WebDriver driver;
    ChromeOptions chromeoptions=new ChromeOptions();
    FirefoxOptions firefoxoptions=new FirefoxOptions();
    DesiredCapabilities capabilities=new DesiredCapabilities();

    
    @BeforeMethod
    public void  initialiseBrowser(ITestResult result){
        String methodName= result.getMethod().getMethodName();
        
        
        //System.out.println("Executing method" + methodName);
        if("averifyMakemyTripLogo".equals(methodName)) {
            WebDriverManager.firefoxdriver().setup();
//            FirefoxProfile profile =new FirefoxProfile();
//            profile.setPreference("dom.webnotifications.enabled", false);
            driver=new FirefoxDriver();
            driver.manage().window().maximize();
            //System.out.println("From 1st method");
        }
        else {
                WebDriverManager.chromedriver().setup();
                //chromeoptions.setBinary();
               //chromeoptions.addArguments("--disable-notifications");
                driver = new ChromeDriver();
                driver.manage().window().maximize();
                //System.out.println("From 2nd method");
        }

    }

    @Test
    public void averifyMakemyTripLogo(){
       driver.get("https://www.makemytrip.com/");
       WebElement closebtn= driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]"));
       closebtn.isDisplayed();
       closebtn.click();
       WebElement Makemytriplogo=driver.findElement(By.xpath("//img[@src=\"//imgak.mmtcdn.com/pwa_v3/pwa_hotel_assets/header/mmtLogoWhite.png\"]"));
       Makemytriplogo.isDisplayed();
       

    }
    @Test
    public void bverifyMakemyTrip() throws InterruptedException{
    	 WebDriverWait wait= new WebDriverWait(driver,Duration.ofSeconds(30));
        driver.get("https://www.makemytrip.com/");
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class=\"commonModal__close\"]"))).click();;
        
//        WebElement closebtn= driver.findElement(By.xpath("//span[@class=\"commonModal__close\"]"));
//        closebtn.isDisplayed();
//        closebtn.click();
//      
        WebElement flights= driver.findElement(By.xpath("//a[@href=\"https://www.makemytrip.com/flights/\"]"));
        flights.isDisplayed();
        flights.click();
        
       
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[text()='One Way']"))).click();;
        
        //onewaytrip.isDisplayed();
        //onewaytrip.click();
        WebElement fromcity= driver.findElement(By.xpath("//input[@data-cy=\"fromCity\"]"));
        fromcity.isDisplayed();
        WebElement tocity= driver.findElement(By.xpath("//input[@data-cy=\"toCity\"]"));
        tocity.isDisplayed();
    }
    @AfterMethod
    public void close(){
        driver.quit();
    }


    
}
