
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.*;
import java.util.stream.Collectors;

public class minvote {

    private static boolean ASC = true;
    private static boolean DSc = false;
    private static Select constituency;
    private static WebDriver driver;
    static  List<WebElement> cs;
    static ArrayList<Integer>l1=new ArrayList<>();
    static ArrayList<String>l2=new ArrayList<>();
    static ArrayList<String>l3=new ArrayList<>();
    static ArrayList<Integer>l4=new ArrayList<>();
    static ArrayList<String>l5=new ArrayList<>();
    static ArrayList<String>l6=new ArrayList<>();
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
           // System.out.println(driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText());
            constituencyname=driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).getText();
            driver.findElement(By.xpath("//*[@id='ddlState']/option[" + k + "]")).click();


            WebElement dropdown2 = driver.findElement(By.xpath("//*[@id='ddlAC']"));
            Select constituency = new Select(dropdown2);
            cs = constituency.getOptions();
            //System.out.println("Total number of consituency : " + (cs.size()-1));

            for (int j = 2; j <= cs.size(); j++) {
                searchConstituencyByIndex(j);

            }
        }

    }
    private static Map<Integer, Integer> sortByValue(Map<Integer, Integer> unsortMap, final boolean order)
    {
        List<Map.Entry<Integer, Integer>> list = new LinkedList<>(unsortMap.entrySet());

        // Sorting the list based on values
        list.sort((o1, o2) -> order ? o1.getValue().compareTo(o2.getValue()) == 0
                ? o1.getKey().compareTo(o2.getKey())
                : o1.getValue().compareTo(o2.getValue()) : o2.getValue().compareTo(o1.getValue()) == 0
                ? o2.getKey().compareTo(o1.getKey())
                : o2.getValue().compareTo(o1.getValue()));
        return list.stream().collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> b, LinkedHashMap::new));

    }

    private static void printMap(Map<Integer, Integer> map)
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
        HashMap<Integer, Integer> list = new HashMap<>();

        for (int i = 4; i < rows.size(); i++) {

            String votes = (driver.findElement(By.xpath("//*[@id='div1']/table[1]/tbody/tr[" + i + "]/td[6]")).getText());
            Integer intvote = Integer.parseInt(votes);
            int votes1 = intvote.intValue();
            list.put(i, votes1);
        }



        //     System.out.println("After sorting ascending order......");
        Map<Integer, Integer> sortedMapAsc = sortByValue(list, ASC);
        // printMap(sortedMapAsc);

        Map.Entry<Integer, Integer> entry = sortedMapAsc.entrySet().iterator().next();
        int key = entry.getKey();
        int value = entry.getValue();
        // System.out.println(key);
        // System.out.println("who have got higest vote in constituency");
        //System.out.println(value);
        l1.add(value);


//name of candidate
        String xpathforName = "//*[@id='div1']/table[1]/tbody/tr[" + key + "]/td[2]";
        String nameOfCandidate = driver.findElement(By.xpath(xpathforName)).getText();
        l2.add(nameOfCandidate);

        // System.out.println("---" + nameOfCandidate);
        if(l1.size()==cs.size()-1) {
            int indexmin = l1.indexOf(Collections.min(l1));
            l4.add(Collections.min(l1));
            l5.add(l2.get(indexmin));
            l6.add(l3.get(indexmin));
        }
           if(l4.size()==5) {
               int indexminn = l4.indexOf(Collections.min(l4));
               System.out.println("The candidate who won with minimum vote is " + l5.get(indexminn) + " in constituency " + l6.get(indexminn) + " and vote is = " + Collections.min(l4));
           }

    }
}

