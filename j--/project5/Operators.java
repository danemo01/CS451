import java.lang.Integer;
import java.lang.System;

public class Operators {
    public static void main(String[] args) {
        int a = Integer.parseInt(args[0]);
        int b = Integer.parseInt(args[1]);
        System.out.println(a != b); // TRUE - works
        System.out.println(a /= b); // 7 - works
        System.out.println(a -= b); // 4 - works
        System.out.println(a *= b); // 12 - works
        System.out.println(a %= b); // 0 - works
        System.out.println(a >>= b); // 0 - works
        System.out.println(a >>>= b); // 0 - works
        System.out.println(a >= b); // false - works
        System.out.println(a <<= b); // 0 - works
        System.out.println(a < b); // true - works
        System.out.println(a ^= b); // 3 - works
        System.out.println(a |= b); // 3 - works
        System.out.println(a == b || b == a); // true - works
        System.out.println(a &= b); // 3 - works
        System.out.println(a++); // 3 - works
        System.out.println(--b); // 2 - ?
        System.out.println(a / b); // 2
        System.out.println(a % b); // 0
        System.out.println(a << b); // 16
        System.out.println(a >> b); // 1
        System.out.println(a >>> b); // 1
        System.out.println(~a); // -5
        System.out.println(a | b); // 6
        System.out.println(a ^ b); // 6
        System.out.println(a & b);// 0
        System.out.println(+a);// 4
    }
}
