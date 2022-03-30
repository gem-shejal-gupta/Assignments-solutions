package sample;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;

public class uniquerowsintable {

    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sh.gupta5\\Downloads\\chromedriver_win32\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("file:///C:/Users/sh.gupta5/Downloads/Creating%20Tables%20in%20HTML.html");

        ArrayList<String>l1=new ArrayList<String>();
        ArrayList<String>l2=new ArrayList<String>();
        ArrayList<String>l3=new ArrayList<String>();
        ArrayList<String>l4=new ArrayList<String>();
        WebElement table = driver.findElement(By.xpath("//body/table"));
        List<WebElement> rows = table.findElements(By.tagName("tr"));
        int rows_count = rows.size();
          for(int i = 0; i < rows_count; i++)
          {
            List<WebElement> cols = rows.get(i).findElements(By.tagName("td"));
            int cols_count = cols.size();
            for(int j = 0; j < cols_count; j++)
            {
                String c = cols.get(j).getText();
                if(j==0)
                l1.add(c);
                if(j==1)
                    l2.add(c);
                if(j==2)
                    l3.add(c);
            }
        }

            for(int i=0;i<l1.size();i++)
            {
               if((!(l4.contains(l1.get(i))))||(!(l4.contains(l2.get(i))))||(!(l4.contains(l3.get(i))))) {
                   l4.add(l1.get(i));
                   l4.add(l2.get(i));
                   l4.add(l3.get(i));
               }

                }
            System.out.println("No."+"  "+"Name"+"   "+"Age");
            for(int i=0;i<l4.size()-2;i=i+3)
            System.out.println(l4.get(i)+" "+l4.get(i+1)+" "+l4.get(i+2));
    }
}
