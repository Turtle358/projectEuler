import java.math.BigInteger;

public class Task20 {
    public static int calculateFactorialSum(int number){
        BigInteger result = BigInteger.ONE;
        int sum = 0;
        for (int i = 1; i <= number; i++){
            result = result.multiply(BigInteger.valueOf(i));
        }
        String resultString = result.toString();
        for(int i = 0; i<resultString.length(); i++){
            sum += Integer.parseInt(resultString.charAt(i) + "");
        }
        return sum;
    }
}
