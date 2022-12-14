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
    private HomePage homePage=new HomePage(Hooks.driver);
    private DashBoardPage dashBoardPage=new DashBoardPage(Hooks.driver);

    @And("^User moves to \"(.*)\" tab and select \"(.*)\" option$")
    public void userNavigatesToSite(String tab,String option) throws InterruptedException {
        //Created method to have customization in future
        homePage.navigateToMainMenu(tab);
        homePage.navigateToSubmenu(option);
    }

    @And("^user navigates to \"(.*)\" dashboard$")
    public void userNavigatesToDashboard(String tab){
        //Created method to have customization in future
        dashBoardPage.navigateToDashboard(tab);
    }


    @And("^user verifies page is navigated to \"(.*)\"$")
    public void userVerifiesPageIsNavigatedTo(String tab){
        //Created method to have customization in future
        Assert.assertEquals(tab,dashBoardPage.getPageTitle().trim());
    }

    @And("^user verifies page title is \"(.*)\"$")
    public void userVerifiesPageTitleIs(String title){
        //Created method to have customization in future
        Assert.assertEquals(title,Hooks.driver.getTitle());
    }
    
    @And("^user verifies header, body, logo and footer is present$")
    public void userVerifyHeaderBodyLogoAndFooterIsPresent(){
    	//Created method to have customization in future
    	dashBoardPage.verifyHeaderLogoBodyAndFooterPresent();
    	
    }
    
    @And("^user navigate to about the dashboard and verify url \"(.*)\" is loaded$")
    public void userNavigateToAboutTheDashboard(String url) throws Exception{
    	//Created method to have customization in future
    	Assert.assertEquals(url, dashBoardPage.navigateToAbtThisDashboard());
    	
    }

    @And("^user navigate to dashboard export instructions and verify url \"(.*)\" is loaded$")
    public void userNavigateToDashboardExportInstructions(String url) throws Exception{
    	//Created method to have customization in future
    	Assert.assertEquals(url, dashBoardPage.navigateToDashboardExportInstructions());
    	
    }
    
    @And("^user verify data as of now is showing todays date$")
    public void userVerifyDataAsOfNowIsShowingTodaysDate() throws Exception{
    	//Created method to have customization in future
    	SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
    	String output="Data as of "+sdf.format(new Date());
    	System.out.println("Expected date "+output);
    	System.out.println("Acutal date "+dashBoardPage.getAsOfTodayData());
    	Assert.assertEquals(output, dashBoardPage.getAsOfTodayData());
    	
    }
    
    @And("^user verifies bread crumb of the page as \"(.*)\"")
    public void userVerifiesBreadCrumb(String breadCrumb){
        //Created method to have customization in future
        Assert.assertEquals(breadCrumb,dashBoardPage.getBreadCrumb());
    }

    @And("^User verifies all the refresh cycle which are \"(.*)\" is Data of Source Data is \"(.*)\"")
    public void userVerifiesAllTheRefreshCycleWhichAreIdDataOfSourceDataIs(String refreshCycle,String date) throws InterruptedException {
        //Created method to have customization in future
        dashBoardPage.verifyDateForRefreshCycle(refreshCycle,date);
    }




}
