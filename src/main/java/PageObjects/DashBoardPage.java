package PageObjects;

import java.time.Duration;


import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {

    @FindBy(xpath = "//h4[text()='Health Sites']/..")
    public WebElement healthSites;

    @FindBy(xpath = "//li[@class='active']")
    public WebElement activePageSite;
    
    @FindBy(xpath = "//div[contains(@class,'page-entry-icon')]")
    public WebElement pageIcon;
    
    @FindBy(xpath = "//h1[text()='Health Sites']")
    public WebElement healthSiteHeader;
    
    @FindBy(xpath = "//p[@class='lead']")
    public WebElement leadBody;
    
    @FindBy(xpath = "//div[contains(text(),'Data as of ')]")
    public WebElement dataAsOf;
    
    @FindBy(xpath = "//a[contains(text(),'About this Dashboard ')]")
    public WebElement aboutThisDashboard;
    
    @FindBy(xpath = "//a[contains(text(),'Dashboard Export Instructions')]")
    public WebElement dashboardExportInstructions;
    
    @FindBy(id = "colophon")
    public WebElement footer;
    
    @FindBy(id="vizContainer")
    public WebElement dashboardRegion;

    public WebDriver driver;
    public DashBoardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }

    public void navigateToHealthSites(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(healthSites));
        healthSites.click();
    }

    public String getPageTitle(){
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.visibilityOf(activePageSite));
        return activePageSite.getText();
    }
    
    public void verifyHeaderLogoBodyAndFooterPresent() {
    	Assert.assertTrue(pageIcon.isDisplayed());
    	Assert.assertTrue(healthSiteHeader.isDisplayed());
    	Assert.assertTrue(footer.isDisplayed());
    	Assert.assertTrue(dashboardRegion.isDisplayed());
    }
    
    public String navigateToAbtThisDashboard() throws Exception{
    	aboutThisDashboard.click();
    	Thread.sleep(3000);
    	String url=driver.getCurrentUrl();
    	driver.navigate().back();
    	return url;
    	
    }
    
    public String navigateToDashboardExportInstructions() throws Exception{
    	dashboardExportInstructions.click();
    	Thread.sleep(3000);
    	String url=driver.getCurrentUrl();
    	driver.navigate().back();
    	return url;
    	
    }
    
    public String getAsOfTodayData() throws Exception{
    	
    	return dataAsOf.getText();
    	
    }

}
