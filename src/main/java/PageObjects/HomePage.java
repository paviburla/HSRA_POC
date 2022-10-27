package PageObjects;

import java.time.Duration;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
    @FindBy(xpath = "//span[text()='Data']/..")
    public WebElement dataElement;

    @FindBy(xpath = "//a[text()='Dashboards']")
    public WebElement dashBoards;
    public WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }
    public void navigateToDashboardFromData(){
        Actions act=new Actions(driver);
        act.moveToElement(dataElement).build().perform();
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        wait.until(ExpectedConditions.elementToBeClickable(dashBoards));
        dashBoards.click();
    }

}
