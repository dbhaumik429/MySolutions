package com.debu.array;

/**
 * Created by Aspire V3 on 23-05-2018.
 */
public class MinSubArrWithSum {

    public static void main(String[] args)
    {
        int arr[] = {1, 10, 5, 2, 7};
        int k = 9;

        int start=0;
        int end=0;

        int sum=0;
        int minArrLenght=Integer.MAX_VALUE;
        int i=start;
        for(; i< arr.length; ++i)
        {
            sum += arr[i];

            if(sum < k)
            {
                end++;
                continue;
            }

            while( start < end )
            {
                sum -= arr[start];

                if(sum > k)
                {
                    start++;
                    continue;
                }
                break;
            }

            if(minArrLenght > (end - start + 1) )
            {
                minArrLenght = end - start + 1;
                i=start;
                start++;
                sum=0;
            }
        }

        System.out.println(minArrLenght);
    }

}
