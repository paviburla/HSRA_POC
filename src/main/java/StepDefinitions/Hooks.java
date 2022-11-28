package StepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

public class Hooks {
    public static WebDriver driver;
    @Before
    public void setUp(){
        boolean headless=System.getProperty("headless","true").equalsIgnoreCase("true");
        ChromeOptions options=new ChromeOptions();
        WebDriverManager.chromedriver().setup();
        options.setHeadless(headless);
        driver=new ChromeDriver(options);
        if(headless){
            driver.manage().window().setSize(new Dimension(1920,1080));
        }else{
            driver.manage().window().maximize();
        }
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
        driver.get("https://data.hrsa.gov/");
    }

    @After
    public void tearUp(Scenario scenario) throws IOException {
        if(scenario.isFailed()){
            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            File DestFile=new File("./Screenshot/"+scenario.getName()+".jpg");
            FileUtils.copyFile(srcFile, DestFile);
        }
        driver.quit();
    }
}
