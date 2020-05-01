package com.debu.string;

/**
 * Created by Aspire V3 on 01-07-2017.
 */
public class removeDuplicatesAdjacent {

    static class Result
    {
        public boolean modified;
        public StringBuilder result;

        Result()
        {
            modified=false;
            result = new StringBuilder("");
        }
    }

    private static Result removeDuplicatesUtil(String str)
    {
        int i=0;
        int index=0;
        Result res = new Result();

        while(i<str.length())
        {
            if(i+1 < str.length())
            {
                while(str.charAt(i) == str.charAt(i+1)) {
                    i++;
                    res.modified = true;
                }
                    res.result.append(str.charAt(i));
                    i=i+1;
            }else
            {
                res.result.append(str.charAt(i));
                break;
            }
        }

        return res;
    }

    public static String removeDuplicates(Result res)
    {
        while(true)
        {
            res = removeDuplicatesUtil(res.result.toString());
            if(res.modified != true)
                break;
        }

        return res.result.toString();
    }

    public static void main (String[] args) {

        String str="acaaabbbacdddd";
        Result res = new Result();
        res.result.append(str);

        System.out.println(removeDuplicates(res));

    }
}
