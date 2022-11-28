package PageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage {
	public WebDriver driver;
    public HomePage(WebDriver driver){
        this.driver=driver;
        PageFactory.initElements(this.driver,this);
    }
    public void navigateToMainMenu(String mainMenu){
        Actions act=new Actions(driver);
        act.moveToElement(driver.findElement(By.xpath("//span[text()='"+mainMenu+"']/.."))).build().perform();
    }

    public void navigateToSubmenu(String subMenu) throws InterruptedException {
        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(30));
        WebElement subMenuXpath=driver.findElement(By.xpath("//a[text()='"+subMenu+"']"));
        wait.until(ExpectedConditions.elementToBeClickable(subMenuXpath));
        Thread.sleep(2000);
        subMenuXpath.click();
    }
}
