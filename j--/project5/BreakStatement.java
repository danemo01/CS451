import java.lang.Integer;
import java.lang.System;

public class BreakStatement {
    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        int count = 0;
        for (int i = 2; ; ) {
            if (i > n) {
                System.out.println(" in first  if i =" + i + "count=" + count);
                break;
            }
            int j = 2;
            while (j <= i / j) {
                if (i % j == 0) {
                    System.out.println("in second if i =" + i + "count=" +  count);
                    break;
                }
                j++;
            }
            // should get 2
            count += j > i / j ? 1 : 0;
            i++;
        }
        System.out.println(count);
    }
}
