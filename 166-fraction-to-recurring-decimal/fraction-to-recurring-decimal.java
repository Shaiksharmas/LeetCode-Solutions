import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
     
        if (numerator == 0) return "0";

        StringBuilder result = new StringBuilder();

        if ((numerator < 0) ^ (denominator < 0)) {
            result.append("-");
        }

        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        result.append(num / den);
        long remainder = num % den;

        if (remainder == 0) {
            return result.toString();
        }

        result.append(".");

        List<Long> remainders = new ArrayList<>();
        List<Long> digits = new ArrayList<>();

        while (remainder != 0) {
            if (remainders.contains(remainder)) {
                int idx = remainders.indexOf(remainder);
                for (int i = 0; i < digits.size(); i++) {
                    if (i == idx) result.append("(");
                    result.append(digits.get(i));
                }
                result.append(")");
                return result.toString();
            }

            remainders.add(remainder);

            remainder *= 10;
            digits.add(remainder / den);
            remainder = remainder % den;
        }

        for (long d : digits) {
            result.append(d);
        }

        return result.toString();
    }
}