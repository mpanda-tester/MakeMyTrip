package demo;

import java.time.Duration;
import java.util.logging.Level;
import java.time.Duration;


import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeDriverService;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogType;
import org.openqa.selenium.logging.LoggingPreferences;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import io.github.bonigarcia.wdm.WebDriverManager;

import io.github.bonigarcia.wdm.WebDriverManager;

public class TestCases {
    ChromeDriver driver;

    public TestCases() {
        // System.out.println("Constructor: TestCases");

        // WebDriverManager.chromedriver().timeout(30).setup();
        // ChromeOptions options = new ChromeOptions();
        // LoggingPreferences logs = new LoggingPreferences();

        // // Set log level and type
        // logs.enable(LogType.BROWSER, Level.ALL);
        // logs.enable(LogType.DRIVER, Level.ALL);
        // options.setCapability("goog:loggingPrefs", logs);
        // options.addArguments("start-maximized");
        // options.addArguments("--disable-blink-features=AutomationControlled");

        // // options.setCapability("goog:loggingPrefs", logs);

        // DesiredCapabilities capabilities = new DesiredCapabilities();
        // capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        // driver = (ChromeDriver) new RemoteWebDriver(new URL("http://localhost:8082/wd/hub"), capabilities);

        // // Set browser to maximize and wait
        // driver.manage().window().maximize();
        // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
    }

    public void endTest() {
        System.out.println("End Test: TestCases");
        if (driver != null) {
            driver.quit();
        }
    }

    public void testCase01() {
        System.out.println("Start Test case: testCase01");
        driver.get("https://www.makemytrip.com/");
        String url=driver.getCurrentUrl();
        if(url.contains("makemytrip.")){
            System.out.println("Test case01 : PASS");
        }else{
            System.out.println("Test case01 : FAIL");
        }
        System.out.println("End Test case: testCase01");
    }
    public void testCase02() throws InterruptedException{
        System.out.println("Start Test case: testcase02");
        driver.get("https://www.makemytrip.com/");
        WebElement frombtn = driver.findElement(By.id("fromCity"));
        frombtn.click();
        WebElement searchbarForm =driver.findElement(By.xpath("//input[@placeholder='From']"));
        searchbarForm.click();
        searchbarForm.sendKeys("blr");

        WebElement selectFromCity = driver.findElement(By.xpath("//span[text()='Bengaluru']"));
        selectFromCity.click();

        WebElement tobtn = driver.findElement(By.id("toCity"));
        tobtn.click();
        WebElement searchbarTo =driver.findElement(By.xpath("//input[@placeholder='To']"));
        searchbarTo.click();
        searchbarTo.sendKeys("del");

        WebElement selectToCity = driver.findElement(By.xpath("//span[text()='New Delhi']"));
        selectToCity.click();
        

        WebElement dateToChoose = driver.findElement(By.xpath("(//p[text()='29'])[2]"));
        String date=dateToChoose.getText();
        if(date.equals("29")){
            System.out.println("Date is "+date);
        }
        dateToChoose.click();

        WebElement searchBtn = driver.findElement(By.xpath("//a[contains(text(),'Search')]"));
        searchBtn.click();
        System.out.println("Search button is clicked");
        Thread.sleep(8000);
        
        WebElement ppopUp= driver.findElement(By.xpath("//button[contains(text(),'OKAY, GOT IT!')]"));
        ppopUp.click();
        Thread.sleep(3000);
        // WebDriverWait wait = new WebDriverWait(driver,20);
        // wait.until(ExpectedConditions.urlContains("/flight/search"));


        // List<WebElement> price = driver.findElements(By.xpath("//*[@id=\"listing-id\"]/div/div[2]/div/div[8]/div[1]/div[2]/div[2]/div/div/div"));

        // for(WebElement pp:price){
        //     System.out.println("adult "+pp.getText());
        // }
           
        List<WebElement> priceElements = driver
        .findElements(
                By.xpath("//*[@id=\"listing-id\"]/div/div[2]/div/div[8]/div[1]/div[2]/div[2]/div/div/div"));
if (priceElements.size() > 0) {
    String price = priceElements.get(0).getText();
    System.out.println("Price per adult: " + price);
} else {
    System.out.println("No flight details found.");
}

        System.out.println("End Test case: testCase02");

    }
    public void testCase03() throws InterruptedException{
        System.out.println("Start Test case: testcase03");
        driver.get("https://www.makemytrip.com/");
        WebElement optTrain = driver.findElement(By.xpath("(//span[text()='Trains'])[1]"));
        optTrain.click();

        WebElement frombtn = driver.findElement(By.id("fromCity"));
        frombtn.click();
        WebElement searchbarForm =driver.findElement(By.xpath("//input[@placeholder='From']"));
        searchbarForm.click();
        searchbarForm.sendKeys("ypr");

        WebElement selectFromCity = driver.findElement(By.xpath("//span[text()='Bangalore']"));
        selectFromCity.click();

        WebElement tobtn = driver.findElement(By.xpath("//span[text()='To']"));
        tobtn.click();
        WebElement searchbarTo =driver.findElement(By.xpath("//input[@placeholder='To']"));
        searchbarTo.click();
        searchbarTo.sendKeys("ndls");

        WebElement selectToCity = driver.findElement(By.xpath("//span[text()='Delhi']"));
        selectToCity.click();

        WebElement dateToSelect = driver.findElement(By.xpath("(//span[@class='font32 latoBlack'])[1]"));
        dateToSelect.click();
        

        WebElement dateToChoose = driver.findElement(By.xpath("(//div[text()='29'])[2]"));
        String date=dateToChoose.getText();
        if(date.equals("29")){
            System.out.println("Date is "+date);
        }
        dateToChoose.click();
        

        WebElement searchBtn = driver.findElement(By.xpath("//a[contains(text(),'Search')]"));
        searchBtn.click();
        System.out.println("Search button is clicked");

        Thread.sleep(3000);

        // WebDriverWait wait = new WebDriverWait(driver,20);
        // wait.until(ExpectedConditions.urlContains("railways/listing"));

        List<WebElement> price = driver.findElements(By.xpath("//div[@class='ticket-price justify-flex-end']"));
        for(WebElement pp: price){
            System.out.println("Train Price:"+pp.getText());
        }



        System.out.println("End Test case: testCase03");
    }

    public void testCase04() throws InterruptedException{
        System.out.println("Start Test case: testcase04");
        driver.get("https://www.makemytrip.com/");
        WebElement optTrain = driver.findElement(By.xpath("(//span[text()='Buses'])[1]"));
        optTrain.click();
        WebElement frombtn = driver.findElement(By.id("fromCity"));
        frombtn.click();
        WebElement searchbarForm =driver.findElement(By.xpath("//input[@placeholder='From']"));
        searchbarForm.click();
        searchbarForm.sendKeys("bangl");

        WebElement selectFromCity = driver.findElement(By.xpath("//span[text()='Bangalore, Karnataka']"));
        selectFromCity.click();
        Thread.sleep(2000);


   
        WebElement toInput = driver.findElement(By.id("toCity"));
        // toInput.click();
        WebElement toCity = driver.findElement(By.xpath("//input[@placeholder='To']"));
        toCity.sendKeys("kathma");
        Thread.sleep(3000); // Wait for the dropdown to appear
        WebElement toOption = driver
                .findElement(By.xpath("//span[text()='Kathmandu, Nepal']"));
        toOption.click();

        // Select the correct date (20th of next Month) for the bus.
        Thread.sleep(3000);

        

        WebElement dateToChoose = driver.findElement(By.xpath("(//div[text()='29'])[2]"));
        String date=dateToChoose.getText();
        if(date.equals("29")){
            System.out.println("Date is "+date);
        }
        dateToChoose.click();

        WebElement searchBtn = driver.findElement(By.xpath("//button[contains(text(),'Search')]"));
        searchBtn.click();
        System.out.println("Search button is clicked");
        Thread.sleep(3000);

        // WebDriverWait wait = new WebDriverWait(driver,20);
        // wait.until(ExpectedConditions.urlContains("/bus/search"));

        WebElement errorResult= driver.findElement(By.xpath("//span[@class='error-title']"));
        String result = errorResult.getText();
        if(result.equals("No buses found for 29 Jul")){
            System.out.println("No buses found");
        }


        System.out.println("End Test case: testCase04");
    }
}
