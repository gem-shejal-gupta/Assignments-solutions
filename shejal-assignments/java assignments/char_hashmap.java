import java.util.*;
class char_hashmap
{
public static void main(String args[])
{
Scanner sc=new Scanner(System.in);
String s=sc.nextLine();
char a[]=s.toCharArray();
 HashMap<Character, Integer> count = new HashMap<Character, Integer>();
      for (char c : a)
{
         if (count.containsKey(c))
{
            count.put(c, count.get(c) + 1);
         }
else{
            count.put(c, 1);
         }
      }

   for (Map.Entry entry : count.entrySet())
{
         System.out.println(entry.getKey() + " " + entry.getValue());
}
}
}
