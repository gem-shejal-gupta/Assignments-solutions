package sample;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class keyboardmouseevent {
    public static void main(String[] args) throws InterruptedException {

        //Launch https://chercher.tech/practice/practice-pop-ups-selenium-webdriver
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sh.gupta5\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://chercher.tech/practice/practice-pop-ups-selenium-webdriver");
        driver.manage().window().maximize();


        //Click on Alert and accept it
        driver.findElement(By.xpath("//*[@name='alert']")).click();
        Thread.sleep(1000);
        Alert simplealert= driver.switchTo().alert();
        simplealert.accept();


        //Click on confirmation box and get the text and cancel it
        driver.findElement(By.xpath("//*[@name='confirmation']")).click();
        Thread.sleep(1000);
        Alert confirmbox= driver.switchTo().alert();
        String confirmboxText = confirmbox.getText();
        confirmbox.dismiss();
        System.out.println(confirmboxText);

        //Click on prompt and enter text and accept it
        driver.findElement(By.xpath("//*[@name='prompt']")).click();
        Thread.sleep(1000);
        Alert promptbox= driver.switchTo().alert();
        String alertText = promptbox.getText();
        System.out.println("PromptAlert text is " + alertText);
        promptbox.sendKeys("I Am Prompt");
        promptbox.accept();

        //Upload any sample file
       WebElement upload = driver.findElement(By.xpath("//*[@name='upload']"));
       upload.sendKeys("C:\\Users\\sh.gupta5\\Documents");
     //  driver.findElement(By.id("open")).click();


        //Double click on Double click me and get the text from alert
        Actions builder = new Actions(driver);
        WebElement link = driver.findElement(By.xpath("//input[@id='double-click']"));
        builder.doubleClick(link).perform();
        Thread.sleep(1000);
        Alert doublealert = driver.switchTo().alert();
        System.out.println(doublealert.getText());
        doublealert.accept();

        //move mouse to Sub menu and click on it
        WebElement link2 = driver.findElement(By.xpath("//button[@id='sub-menu']"));
        Actions actions = new Actions(driver);
        actions.moveToElement(link2).click().perform();

        //Press tab key and select google and click on it
        WebElement link3 = driver.findElement(By.xpath("//*[@id='link2']"));
        actions.click(link3).perform();


    }
}
