
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.stream.Collectors;

public class greaterthan50percentvote{

    private static boolean ASC = true;
    private static boolean DSc = false;
    private static Select constituency;
    private static WebDriver driver;
    static List<WebElement> cs;
    static ArrayList<Double> l1 = new ArrayList<>();
    static ArrayList<Integer> l2 = new ArrayList<>();
    static ArrayList<Integer> l3 = new ArrayList<>();
    static ArrayList<String> name=new ArrayList<>();
    static ArrayList<String> consituency=new ArrayList<>();
    static String constituencyname;
    static  int c=0;
    static int totalcount=0;

    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\sh.gupta5\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://results.eci.gov.in/ResultAcGenMar2022/ConstituencywiseS0510.htm?ac=10");


        WebElement dropdown1 = driver.findElement(By.xpath("//*[@id='ddlState']"));
        Select state = new Select(dropdown1);
        List<WebElement> statechange = state.getOptions();
        System.out.println("Total number of states : " + (statechange.size()-1));

        for (int k = 2; k <= statechange.size(); k++) {

//            l1.clear();
//            l2.clear();
//            l3.clear();
            System.out.println(driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText());
            constituencyname = driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText();
            driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).click();


            WebElement dropdown2 = driver.findElement(By.xpath("//*[@id='ddlAC']"));
            Select constituency = new Select(dropdown2);
            cs = constituency.getOptions();
            System.out.println("Total number of consituency : " + (cs.size() - 1));

            for (int j = 2; j <= cs.size(); j++) {
                searchConstituencyByIndex(j);

            }
        }
    }


    private static void putDataIntoExcel () {

    }
    public static void searchConstituencyByIndex ( int index){

        driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).click();
        String constituencyName = (driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).getText());
        consituency.add(constituencyName);

        List<WebElement> rowData = driver.findElements(By.xpath("//*[@id='div1']/table[1]/tbody/tr"));
        ArrayList<Integer> Votes = new ArrayList<Integer>();
        int totalrow = rowData.size();
        String totalvotes = (driver.findElement(By.xpath("//*[@id='div1']/table[1]/tbody/tr[" + totalrow + "]/td[6]")).getText());
        Double totalintvote = Double.parseDouble(totalvotes);
        double totalvotes1 = totalintvote.doubleValue();
        l1.add(totalvotes1);
        for (int i = 4; i < rowData.size()-1; i++) {

            String votes = (driver.findElement(By.xpath("//*[@id='div1']/table[1]/tbody/tr[" + i + "]/td[6]")).getText());
            Double intvote = Double.parseDouble(votes);
            double votes1 = intvote.doubleValue();
            double tc = votes1/totalvotes1;
            if(tc>0.5) {
                c++;
            }
        }
        totalcount=totalcount+c;

        if(l1.size()== cs.size()-1) {
            System.out.println("Total count of candidate who have got more vote than 50% is :" + c);
            c=0;
            if(l1.size()==70)
            {
                System.out.println("Total number of candidate who got more vote tha 50% are : "+totalcount);
            }
            l1.clear();
        }


    }

}




