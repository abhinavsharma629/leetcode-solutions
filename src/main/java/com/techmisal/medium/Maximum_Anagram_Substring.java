/**
 *                                        Maximum Occurence Of the Anangram Substring- Maxigram
 *
 *
 *
 * Maxigram is an ordered pair (i.e. string of length two) of capital Latin letters. For example, "AZ", "ZA" — are Maxigram.

 You are given a string s consisting of n capital Latin letters. Your task is to find any Maxigram contained in the given string as a substring (i.e. two consecutive characters of the string) maximal number of times. For example, for string s
     = "BBAABBBA" the answer is Maxigram "BB", which contained in s three times. In other words, find any most frequent Maxigram.

 Note:- that occurrences of the Maxigram can overlap with each other.

 Input
 The first line of the input contains integer number n(2 ≤ n ≤ 100) — the length of string s. The second line of the input contains the string consisting of n capital Latin letters.

 Output
 Print the only line containing exactly two capital Latin letters — any two-gram contained in the given string s
 as a substring (i.e. two consecutive characters of the string) maximal number of times.**/




import java.util.*;
import java.lang.*;
import java.io.*;

class Maximum_Anagram_Substring
{
    public static void main (String[] args) throws java.lang.Exception
    {
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the length of the String");      //Entering the length of the String
        int n=sc.nextInt();
        System.out.println("Enter the String");                    //Entering the String
        String s=sc.next();
        int i;
        HashMap<String,Integer> hmap=new HashMap<String,Integer> ();            ////Creating a HashMap of String,Integer to store the frequency
        for(i=0;i<n-2;i++)
        {
            String s1=s.substring(i,i+2);                          //two length substring

            StringBuilder s2=new StringBuilder();

            s2.append(s1);
            s2.reverse();                                          //reversing the substring using StringBuilder
            String s3=(s2.toString());

            if(hmap.containsKey(s1))                                //Checking if the substring is there in the map
                hmap.put(s1,(hmap.get(s1))+1);

            else if(hmap.containsKey(s3))
                hmap.put(s3,(hmap.get(s3))+1);
            else
                hmap.put(s1,1);
        }
        String s4=(s.substring(n-2,n));                                //For the last two left alphabets of the string

        if(hmap.containsKey(s4))
            hmap.put(s4,(hmap.get(s4))+1);
        else
        {
            StringBuilder s2=new StringBuilder();


            s2.append(s4);
            s2.reverse();
            String s3=s2.toString();
            if(hmap.containsKey(s3))
                hmap.put(s3,(hmap.get(s3))+1);
        }
        if(hmap.size()==0)
            System.out.println(s.substring(0,2));
        else
        {
            int max=0;
            String stri="";
            for(Map.Entry<String,Integer> entry: hmap.entrySet())              //Loop For finding out the maximum Occurence Anagram Substring
            {
                if(entry.getValue()>max)
                {
                    max=entry.getValue();
                    stri=entry.getKey();

                }
            }
            System.out.println("Anagram substring with the maximum occurence in the String:- "+stri);                                         //Printing the Substring
        }
    }
}