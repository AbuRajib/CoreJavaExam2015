package BaseApi;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * Created by HP on 4/12/2015.
 */

public class Base {
    //Running useSaucelab when it is true.

    public WebDriver driver=null;
    @Parameters ({"useSauceLabs","username","Key","os","browsername","browserVersion","url"})
    @BeforeMethod
    public void setUp(Boolean useSauceLabs,String userName,String Key,String os,String browsername,
                      String browserVersion,String url) throws IOException{
        if(useSauceLabs==true){
            setupCloudEnvironment(userName,Key,os,browsername,browserVersion,url);
        }
        else{
            getLocalDriver(browsername,browserVersion,url);
        }

    }

        //Running local when useSaucelab  is false

    public void setupCloudEnvironment(String userName,String Key,String os,String browsername,
                                    String browserVersion,String url) throws IOException{

        DesiredCapabilities cap=new DesiredCapabilities();
        cap.setBrowserName(browsername);
        cap.setCapability("version",browserVersion);
        cap.setCapability("platform",os);
        this.driver=new RemoteWebDriver(new URL("http://"+userName+":"+Key +"@ondemand.saucelabs.com:80/wd/hub"),cap);
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();

    }

    public void getLocalDriver(String browsername,String browserVersion,String url){
        if(browsername.equalsIgnoreCase("firefox")){
            driver=new FirefoxDriver();

        }
        else if(browsername.equalsIgnoreCase("chrome")){
            System.setProperty("webdriver.chrome.driver", "../common/Selenium-Driver/chromedriver.exe");
            driver=new ChromeDriver();

        }
        else if(browsername.equalsIgnoreCase("IE")){
            System.setProperty("webdriver.ie.driver", "../common/Selenium-Driver/IEDriverServer.exe");
            driver=new InternetExplorerDriver();

        }
        driver.navigate().to(url);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
       driver.manage().window().maximize();
    }




    @AfterMethod
    public void cleanUp(){

        driver.quit();
    }
    //utility Methods
    public void clickBycss(String locator){
        driver.findElement(By.cssSelector(locator)).click();
    }
    public void clickByxpath(String locator){
        driver.findElement(By.xpath(locator)).click();
    }

    public void typeBycss(String locator,String value){
        driver.findElement(By.cssSelector(locator)).sendKeys(value);
    }

    public void typeByxpath(String locator,String value){
        driver.findElement(By.xpath(locator)).sendKeys(value);
    }
    public void typeAndEnterByxpath(String locator,String value){
        driver.findElement(By.xpath(locator)).sendKeys(value,Keys.ENTER);
    }
    public void typeAndEnterBycss(String locator,String value){
        driver.findElement(By.cssSelector(locator)).clear();
        driver.findElement(By.cssSelector(locator)).sendKeys(value,Keys.ENTER);
    }


    // search WebElements(list) from the website
    public List<String> getListofTextBycss(String locator){
        List<WebElement> element=driver.findElements(By.cssSelector(locator));
        List<String> text=new ArrayList<String>();

        for(WebElement st:element){
            text.add(st.getText());
        }
        return text;
    }

    //Display Webelements to testng framework
    public void displayText(List<String> text){
        for(String st:text){
            System.out.println(st);
        }

    }



    //search webelemts list from browser
    public List<WebElement> getWebElements(String locator){
        List<WebElement> elements=driver.findElements(By.cssSelector("#nav-subnav .nav-a"));
        return elements;
    }

    // click webelements one by one
    public void clickBytext(String locator){
        driver.findElement(By.linkText(locator)).click();
    }

    // sleep method
    public void sleepFor(int sec)throws InterruptedException{
        Thread.sleep(sec*1000);
    }

    // random-App call to customrs or city from w3Schools.com
    public String getTextBycss(String locator){
        String text=driver.findElement(By.cssSelector(locator)).getText();
        return text;
    }

    public void selectElementByVisibleText(String locator,String value){
        WebElement element=driver.findElement(By.cssSelector(locator));
        Select select=new Select(element);
        select.selectByVisibleText(value);
    }


}
