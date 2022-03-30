import java.util.*;
public class count_char
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int i,n=0;
        String str="";
        String s=sc.nextLine();
        ArrayList<Character>l1=new ArrayList<Character>();
         ArrayList<Character>l2=new ArrayList<Character>();
        for(i=0;i<s.length();i++)
        {
            if(s.charAt(i)!=32)
           l1.add(s.charAt(i));
        }
        for(i=0;i<l1.size()-n;i++)
        {
            if(!(l2.contains(l1.get(i))))
            {
            System.out.print(l1.get(i) +"="+Collections.frequency(l1,l1.get(i)));
            l2.add(l1.get(i));
            }
            System.out.println();
        }
    }
}