package com.debu.backtracking;

/**
 * Created by Aspire V3 on 31-05-2017.
 */
public class anagramGen {

    static void generateAnagram(String text, int start, int end)
    {
            if(start<end)
            {
                //swap(text,start+i,end);
                //generateAnagram(text,start+i,end);
                //swap(text,start+i,end);
            }
            else
                System.out.println("%s" + text);
    }

    public static void main(String[] args)
    {
        String text = "abc";
        for(int i=0; i<text.length(); ++i)
        {
            generateAnagram(text,i,text.length());
        }


    }


}
