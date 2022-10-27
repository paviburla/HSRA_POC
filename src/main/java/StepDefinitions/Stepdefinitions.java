package StepDefinitions;

import PageObjects.DashBoardPage;

import PageObjects.HomePage;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Stepdefinitions {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @Given("^User navigates to site \"(.*)\"$")
    public void userNavigatesToSite(String site){
        driver.get(site);
    }

    @And("^User moves to \"(.*)\" tab and select \"(.*)\" option$")
    public void userNavigatesToSite(String tab,String option){
        //Created method to have customization in future
        HomePage homePage=new HomePage(driver);
        homePage.navigateToDashboardFromData();
    }

    @And("^user navigates to \"(.*)\" dashboard$")
    public void userNavigatesToDashboard(String tab){
        //Created method to have customization in future
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        dashBoardPage.navigateToHealthSites();
    }

    @And("^user verifies page is navigated to \"(.*)\"$")
    public void userVerifiesPageIsNavigatedTo(String tab){
        //Created method to have customization in future
        DashBoardPage dashBoardPage=new DashBoardPage(driver);
        Assert.assertEquals(tab,dashBoardPage.getPageTitle().trim());
    }

    @And("^user verifies page title is \"(.*)\"$")
    public void userVerifiesPageTitleIs(String title){
        //Created method to have customization in future
        Assert.assertEquals(title,driver.getTitle());
    }
    
    @And("^user header, body, logo and footer is present$")
    public void userVerifyHeaderBodyLogoAndFooterIsPresent(){
    	//Created method to have customization in future
    	DashBoardPage dashBoardPage=new DashBoardPage(driver);
    	dashBoardPage.verifyHeaderLogoBodyAndFooterPresent();
    	
    }
    
    @And("^user navigate to about the dashboard and verify url \"(.*)\" is loaded$")
    public void userNavigateToAboutTheDashboard(String url) throws Exception{
    	//Created method to have customization in future
    	DashBoardPage dashBoardPage=new DashBoardPage(driver);
    	Assert.assertEquals(url, dashBoardPage.navigateToAbtThisDashboard());
    	
    }

    @And("^user navigate to dashboard export instructions and verify url \"(.*)\" is loaded$")
    public void userNavigateToDashboardExportInstructions(String url) throws Exception{
    	//Created method to have customization in future
    	DashBoardPage dashBoardPage=new DashBoardPage(driver);
    	Assert.assertEquals(url, dashBoardPage.navigateToDashboardExportInstructions());
    	
    }
    
    @And("^user verify data as of now is showing todays date$")
    public void userVerifyDataAsOfNowIsShowingTodaysDate() throws Exception{
    	//Created method to have customization in future
    	DashBoardPage dashBoardPage=new DashBoardPage(driver);
    	SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
    	String output="Data as of "+sdf.format(new Date());
    	System.out.println("Expected date "+output);
    	System.out.println("Acutal date "+dashBoardPage.getAsOfTodayData());
    	Assert.assertEquals(output, dashBoardPage.getAsOfTodayData());
    	
    }

    @After
    public void tearUp(){
        driver.quit();
    }



}
