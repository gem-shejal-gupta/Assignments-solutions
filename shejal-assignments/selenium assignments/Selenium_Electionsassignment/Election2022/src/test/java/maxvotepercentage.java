
import io.opentelemetry.exporter.logging.SystemOutLogExporter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.stream.Collectors;

public class maxvotepercentage{

    private static boolean ASC = true;
    private static boolean DSc = false;
    private static Select constituency;
    private static WebDriver driver;
    static  List<WebElement> cs;
    static ArrayList<Double>l1=new ArrayList<>();
    static ArrayList<String>l2=new ArrayList<>();
    static ArrayList<String>l3=new ArrayList<>();
    static String constituencyname;
    public static void main(String[] args) {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);

        System.setProperty("webdriver.chrome.driver","C:\\Users\\sh.gupta5\\Downloads\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://results.eci.gov.in/ResultAcGenMar2022/ConstituencywiseS0510.htm?ac=10");


        WebElement dropdown1 = driver.findElement(By.xpath("//*[@id='ddlState']"));
        Select state =new Select(dropdown1);
        List<WebElement> statechange = state.getOptions();
        System.out.println( "Total number of states : "+ (statechange.size()-1));

        for( int k=2;k<= statechange.size();k++) {

            l1.clear();
            l2.clear();
            l3.clear();
            System.out.println(driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText());
            constituencyname=driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText();
            driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).click();


            WebElement dropdown2 = driver.findElement(By.xpath("//*[@id='ddlAC']"));
            Select constituency = new Select(dropdown2);
            cs = constituency.getOptions();
            System.out.println("Total number of consituency in  "+constituencyname+" : " + (cs.size()-1));

            for (int j = 2; j <= cs.size(); j++) {
                searchConstituencyByIndex(j);

            }
        }

    }
    private static Map<Double, Double> sortByValue(Map<Double, Double> unsortMap, final boolean order)
    {
        List<Map.Entry<Double, Double>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }

    private static void printMap(Map<Double, Double> map)
    {
        map.forEach((key, value) -> System.out.println("Key : " + key + " Value : " + value));
    }

    private static void putDataIntoExcel(){

    }
    public static void searchConstituencyByIndex(int index){
        driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).click();




        String constituencyName = (driver.findElement(By.xpath("//*[@id='ddlAC']/option[" + index + "]")).getText());
        // System.out.println(constituencyName);
        l3.add(constituencyName);

        List<WebElement> rows = driver.findElements(By.xpath("//*[@id='div1']/table[1]/tbody/tr"));

        HashMap<Double, Double> list = new HashMap<>();

        for (double i = 4; i < rows.size(); i++) {

            String votes = (driver.findElement(By.xpath("//*[@id='div1']/table[1]/tbody/tr[" + i + "]/td[7]")).getText());
            Double intvote = Double.parseDouble(votes);
            double votes1 = intvote.doubleValue();
            list.put(i, votes1);
        }



        //     System.out.println("After sorting ascending order......");
        Map<Double, Double> sortedMapAsc = sortByValue(list, DSc);
        //  printMap(sortedMapAsc);

        Map.Entry<Double, Double> entry = sortedMapAsc.entrySet().iterator().next();
        double key = entry.getKey();
        double value = entry.getValue();
        // System.out.println(key);
        // System.out.println("who have got higest vote in constituency");
        // System.out.println(value);
        l1.add(value);


//name of candidate
        String xpathforName = "//*[@id='div1']/table[1]/tbody/tr[" + key + "]/td[2]";
        String nameOfCandidate = driver.findElement(By.xpath(xpathforName)).getText();
        l2.add(nameOfCandidate);

        //System.out.println("---" + nameOfCandidate);
        if(l1.size()==cs.size()-1) {
            int indexmax= l1.indexOf(Collections.max(l1));
            System.out.println("The candidate who won with Highest percentage of vote  in "+constituencyname+ " is "+ l2.get(indexmax)+" in constituency "+l3.get(indexmax)+" with vote percentage " + Collections.max(l1));
        }

    }
}

