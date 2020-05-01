package com.debu.uber;

import java.util.HashMap;
import java.util.Map;

public class FractionToRecurringDecimal {

    public static String fractionToDecimal(int numerator, int denominator) {

            //-2147483648 = OVERFLOW
            // you should convert any int to Long else it will overflow

            //also should check if either of num or den is -ve
            StringBuilder fraction = new StringBuilder();

            if (numerator == 0) {
                return "0";
            }

            if(denominator == 0)
                return fraction.toString();

            if(numerator < 0 ^ denominator < 0)
                fraction.append("-");

            long dividend = Math.abs( Long.valueOf(numerator) );
            long divisor = Math.abs( Long.valueOf(denominator) );

            fraction.append(String.valueOf(dividend / divisor));

            Long remainder = Math.abs(dividend) % Math.abs(divisor);
            if(remainder <= 0)
                return fraction.toString();

            fraction.append(".");

            Map<Long, Integer> map = new HashMap<>();
            // check whethr to put a paranthesis in the remainder part
            while(remainder != 0 )
            {
                if(map.containsKey(remainder))
                {
                    fraction.insert( map.get(remainder), "(" );
                    fraction.append(")");
                    break;

                }
                map.put(remainder, fraction.length());

                remainder *= 10;
                fraction.append( String.valueOf( remainder / divisor ) );
                remainder %= divisor;

            }


            return fraction.toString();



    }

    public static void main(String[] args) {

        int num = 7;
        int den = -12;

        System.out.println(FractionToRecurringDecimal.fractionToDecimal(num,den));
    }
}
