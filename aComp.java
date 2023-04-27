import java.util.*;
import java.math.*;

class aComp {
    public int[] plusOne(int[] digits) {
        String str = "";
        for (int i = 0; i < digits.length; i++) {
            str += digits[i];
        }
        BigInteger bigIntegerStr=new BigInteger(str);
        BigInteger bigIntegerStr2=new BigInteger("1");
        BigInteger dig;
        dig = bigIntegerStr.add(bigIntegerStr2);
        str = String.valueOf(dig);
        int ret[] = new int[str.length()];
        for (int i = 0; i < ret.length; i++) {
            ret[i] = Integer.valueOf(str.charAt(i) - '0');
        }
        return ret;
    }

    public static void main(String args[]) {
        aComp ob = new aComp();
        List<Integer> list = new ArrayList<Integer>();
        int[] nums3 = { 1, 0, 0, 9 };
        int[][] points = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
        String str = "fviefuro";
        int n[] = ob.plusOne(nums3);
        // System.out.println(n);
        for (int i : n) {
            System.out.println(i);
        }
    }
}
