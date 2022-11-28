package PageObjects;

import java.io.File;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DashBoardPage {

    
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
    
    @FindBy(xpath = "//ul[@class='breadcrumb']/li")
    public List<WebElement> breadCrumb;

    public WebDriver driver;
    public DashBoardPage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
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
    
    public String navigateToAbtThisDashboard() {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(aboutThisDashboard));
    	return aboutThisDashboard.getAttribute("href");
    	
    }
    
    public String navigateToDashboardExportInstructions(){
    	dashboardExportInstructions.click();
    	return dashboardExportInstructions.getAttribute("href");
    	
    }
    public void navigateToDashboard(String dashBoardName){
        WebElement dashboard=driver.findElement(By.xpath("//h4[text()='"+dashBoardName+"']/.."));
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(dashboard));
        dashboard.click();
    }

    public String getBreadCrumb(){
        StringBuilder breadCr= new StringBuilder();
        for(int i=0; i<breadCrumb.size()-1;i++){
            breadCr.append(breadCrumb.get(i).getText()).append(">");
        }
        breadCr.append(breadCrumb.get(breadCrumb.size() - 1).getText());
        return breadCr.toString();
    }
    
    public String getAsOfTodayData() throws Exception{
    	
    	return dataAsOf.getText();
    	
    }

    public void verifyDateForRefreshCycle(String refreshCycle,String date) throws InterruptedException {
        SimpleDateFormat sdf=new SimpleDateFormat("MM/dd/yyyy");
        String output=sdf.format(new Date());
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        Thread.sleep(3000);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//td[text()='"+refreshCycle+"']/../td[3]")));
        List<WebElement> listOfDates=driver.findElements(By.xpath("//td[text()='"+refreshCycle+"']/../td[3]"));
        List<WebElement> listOfDataSource=driver.findElements(By.xpath("//td[text()='"+refreshCycle+"']/../td[1]"));
        System.out.println(listOfDates.size());
        if(date.equalsIgnoreCase("today")) {
            for (int i = 0; i < listOfDates.size(); i++) {
                Assert.assertEquals("Date mismatch for " + listOfDataSource.get(i).getText() + " is " + listOfDates.get(i).getText(), output, listOfDates.get(i).getText());
            }
        }else{
            for (int i = 0; i < listOfDates.size(); i++) {
                Assert.assertEquals("Date mismatch for " + listOfDataSource.get(i).getText() + " is " + listOfDates.get(i).getText(), date, listOfDates.get(i).getText());
            }
        }

    }

}
