package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class waitsandwebtables {

    @Test
    public void verify (){
        System.setProperty("webdriver.chrome.driver","C:\\Users\\sh.gupta5\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.techlistic.com/p/demo-selenium-practice.html");
        driver.manage().window().maximize();

        //printing table data row wise
       WebElement table = driver.findElement(By.xpath("//tbody"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int rows_count = rows.size();

          for(int i = 0; i < rows_count; i++)
          {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
             int cols_count = cols.size();
            for (int j = 0; j < cols_count; j++) {
                String c = cols.get(j).getText();
                System.out.print(c +"  ");
            }
            System.out.println();
        }

           //printing table data column wise
          for(int i=1;i<=3;i++) {
              List<WebElement> record = driver.findElements(By.xpath("//table[contains(@id,'customers')]//tr//td[" + i + "]"));
              for (WebElement ele : record) {
                  String s = ele.getText();
                  System.out.print(s+"  ");
              }
              System.out.println();
          }

          //verifying roland mendel works in microsoft and lives in austria
         WebElement ele = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[4]/td[1]"));
          String s1 = ele.getText();
        WebElement ele1 = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[4]/td[3]"));
        String s2 = ele1.getText();
          if((s1.equals("Microsoft"))&&(s2.equals("Austria"))) {
              WebElement ele2 = driver.findElement(By.xpath("//*[@id='customers']/tbody/tr[4]/td[2]"));
              String s3 = ele2.getText();
             // Assert.assertEquals(s3, "Roland Mendel");
              Assert.assertTrue(true, String.valueOf(s3.equals("Roland Mendel")));
          }
          else {
              Assert.fail();
          }


    }
}
