
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.stream.Collectors;

public class maxvotedifference {

    private static boolean ASC = true;
    private static boolean DSc = false;
    private static Select constituency;
    private static WebDriver driver;
    static List<WebElement> cs;
    static ArrayList<Integer> l1 = new ArrayList<>();
    static ArrayList<Integer> l2 = new ArrayList<>();
    static ArrayList<Integer> l3 = new ArrayList<>();
    static ArrayList<String> name=new ArrayList<>();
    static ArrayList<String> consituency=new ArrayList<>();
    static String constituencyname;

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

            l1.clear();
            l2.clear();
            l3.clear();
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
            for (int i = 4; i < rowData.size(); i++) {

                String votes = (driver.findElement(By.xpath("//*[@id='div1']/table[1]/tbody/tr[" + i + "]/td[6]")).getText());
                Integer intvote = Integer.parseInt(votes);
                int votes1 = intvote.intValue();
                Votes.add(votes1);
            }

            int obj = Collections.max(Votes);
            int row = Votes.indexOf(obj) + 4;
            Collections.sort(Votes);
            int obj2 = Votes.get(Votes.size() - 2);
            l3.add(obj - obj2);
            String names = (driver.findElement(By.xpath("//*[@id='div1']/table[1]/tbody/tr["  + row +  "]/td[2]")).getText());
            name.add(names);


//name of candidate


           if (l3.size() == cs.size() - 1) {
//               System.out.println(l3);
//               System.out.println(name);
               int maxindex = l3.indexOf(Collections.max(l3));
               System.out.println("The candidate who won with maximum vote difference is :  " + name.get(maxindex) + "  with vote difference of : " + Collections.max(l3) + "  in constituency :" + consituency.get(maxindex));
                l3.clear();
                Votes.clear();
                name.clear();
                consituency.clear();
            }

        }

    }



