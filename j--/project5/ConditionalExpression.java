import java.lang.System;
import java.util.Random;

public class ConditionalExpression {
    public static void main(String[] args) {
        Random rng = new Random();
        String result = rng.nextBoolean() ? "Heads" : "Tails";

        if (rng.nextBoolean()) {
            System.out.println("Heads");
        } else {
            System.out.println("Tails");
        }

        System.out.println(result);
    }
}
