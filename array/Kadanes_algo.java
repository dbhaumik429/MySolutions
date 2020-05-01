package com.debu.array;

/**
 * Created by Aspire V3 on 27-05-2017.
 */
public class Kadanes_algo {

    public static void main(String[] args)
    {
        int arr[]= {-2, -3, 4, -1, -2, 1, 5, -3 };

        int sum=0,maxSum=0;
        int startIndex=0,endIndex=0;
        int flag=0;

        for(int i=0;i<arr.length; ++i)
        {
            sum += arr[i];
            if(sum > maxSum)
            {
                maxSum=sum;
                endIndex = i;

                if(flag == 0 )
                {
                    startIndex=i;
                    flag=1;
                }
            }else
            {
                sum=0;
            }
        }

        System.out.println("nmax sum is " + maxSum + "and startIndex " + startIndex +"and endIndex " + endIndex);
    }
}
