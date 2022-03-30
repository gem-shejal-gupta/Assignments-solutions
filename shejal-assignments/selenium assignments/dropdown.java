package sample;

import javafx.beans.property.SetProperty;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.nio.channels.SelectableChannel;
import java.util.List;

public class dropdown {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sh.gupta5\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.get("https://codepen.io/abdulmlik/pen/dJOJov");
       driver.switchTo().frame("result");
        WebElement dropdown= driver.findElement(By.xpath("//*[@id='year']"));
        Select year =new Select(dropdown);
        List<WebElement> x = year.getOptions();
        System.out.println(x.size());
        //Looping through the options and printing dropdown options
        System.out.println("The dropdown options are:");
        for(int i=0;i<x.size();i++) {
            System.out.println(x.get(i).getText());
        }

                Select selectmonth=new Select(driver.findElement(By.xpath("//*[@id='month']")));
                selectmonth.selectByVisibleText("5");
        System.out.print(selectmonth.getFirstSelectedOption().getText()+"-");

                        Select selectday=new Select(driver.findElement(By.xpath("//*[@id='day']")));
                        selectday.selectByVisibleText("5");
                        System.out.print(selectday.getFirstSelectedOption().getText()+"-");

        year.selectByVisibleText("2005");
        System.out.print(year.getFirstSelectedOption().getText());




    }
}
