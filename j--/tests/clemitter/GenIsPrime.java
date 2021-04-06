import java.util.ArrayList;

import jminusminus.CLEmitter;

import static jminusminus.CLConstants.*;

/**
 * This class programmatically generates the class file for the following Java application:
 * 
 * <pre>
 * public class IsPrime {
 *     // Entry point.
 *     public static void main(String[] args) {
 *         int n = Integer.parseInt(args[0]);
 *         boolean result = isPrime(n);
 *         if (result) {
 *             System.out.println(n + " is a prime number");
 *         } else {
 *             System.out.println(n + " is not a prime number");
 *         }
 *     }
 *
 *     // Returns true if n is prime, and false otherwise.
 *     private static boolean isPrime(int n) {
 *         if (n < 2) {
 *             return false;
 *         }
 *         for (int i = 2; i <= n / i; i++) {
 *             if (n % i == 0) {
 *                 return false;
 *             }
 *         }
 *         return true;
 *     }
 * }
 * </pre>
 */
public class GenIsPrime {
    public static void main(String[] args) {
        CLEmitter e = new CLEmitter(true);

        //
        ArrayList<String> modifiers = new ArrayList<String>();

        // public class IsPrime {
        modifiers.add("public");
        e.addClass(modifiers, "IsPrime", "java/lang/Object", null, true);

        // public static void main(String[] args) {
        modifiers.clear();
        modifiers.add("public");
        modifiers.add("static");
        e.addMethod(modifiers, "main", "([Ljava/lang/String;)V", null, true);

        // int n = Integer.parseInt(args[0]);
        e.addNoArgInstruction(ALOAD_0); // loads args
        e.addNoArgInstruction(ICONST_0); // gets 0
        e.addNoArgInstruction(AALOAD); // loads args[0]?
        e.addMemberAccessInstruction(INVOKESTATIC, "java/lang/Integer", "parseInt",
                "(Ljava/lang/String;)I");
        e.addNoArgInstruction(ISTORE_1); // store in int n

        // boolean result = isPrime(n);
        e.addNoArgInstruction(ILOAD_1); // so get n
        e.addMemberAccessInstruction(INVOKESTATIC, "IsPrime", "isPrime", "(I)I"); // run isPrime(n)
        e.addNoArgInstruction(ISTORE_2); // store return int from isPrime to boolean

        // if (result) {
        e.addNoArgInstruction(ILOAD_2); // load result
        e.addNoArgInstruction(ICONST_1); // load ICONST_1
        e.addBranchInstruction(IF_ICMPNE, "Else"); //

        // Base case: System.out.println(n + " is a prime number");

        // Get System.out on stack
        e.addMemberAccessInstruction(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");

        // Create an instance of sb on stack to concat string
        // sb = new StringBuffer();
        e.addReferenceInstruction(NEW, "java/lang/StringBuffer"); // FUCK THIS CLASS MAN
        e.addNoArgInstruction(DUP);
        e.addMemberAccessInstruction(INVOKESPECIAL, "java/lang/StringBuffer", "<init>", "()V");

        // sb.append(n);
        e.addNoArgInstruction(ILOAD_1);
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/lang/StringBuffer", "append",
                "(I)Ljava/lang/StringBuffer;");

        // sb.append("is a prime number");
        e.addLDCInstruction(" is a prime number");
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/lang/StringBuffer", "append",
                "(Ljava/lang/String;)Ljava/lang/StringBuffer;");

        // System.out.println(sb.toString());
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/lang/StringBuffer",
                "toString", "()Ljava/lang/String;");
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/io/PrintStream", "println",
                "(Ljava/lang/String;)V");

        // return;

        e.addBranchInstruction(GOTO, "EndMain");

        // Else case: System.out.println(n + " is not a prime number");
        e.addLabel("Else");

        // Get System.out on stack
        e.addMemberAccessInstruction(GETSTATIC, "java/lang/System", "out", "Ljava/io/PrintStream;");

        // Create an instance of sb on stack to concat string
        // sb = new StringBuffer();
        e.addReferenceInstruction(NEW, "java/lang/StringBuffer"); // FUCK THIS CLASS MAN
        e.addNoArgInstruction(DUP);
        e.addMemberAccessInstruction(INVOKESPECIAL, "java/lang/StringBuffer", "<init>", "()V");

        // sb.append(n);
        e.addNoArgInstruction(ILOAD_1);
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/lang/StringBuffer", "append",
                "(I)Ljava/lang/StringBuffer;");

        // sb.append("is a prime number");
        e.addLDCInstruction(" is not a prime number");
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/lang/StringBuffer", "append",
                "(Ljava/lang/String;)Ljava/lang/StringBuffer;");

        // System.out.println(sb.toString());
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/lang/StringBuffer",
                "toString", "()Ljava/lang/String;");
        e.addMemberAccessInstruction(INVOKEVIRTUAL, "java/io/PrintStream", "println",
                "(Ljava/lang/String;)V");

        // return e.addNoArgInstruction(RETURN);
        e.addLabel("EndMain");
        e.addNoArgInstruction(RETURN);

        // private static boolean isPrime(int n) {
        modifiers.clear(); // clears modifier
        modifiers.add("private");
        modifiers.add("static");
        e.addMethod(modifiers, "isPrime", "(I)I", null, true);

        //     if (n >= 2) { branch to "A"
        e.addNoArgInstruction(ILOAD_0); // push n
        e.addNoArgInstruction(ICONST_2); // push 2
        e.addBranchInstruction(IF_ICMPGE, "A"); // n >= 2

        //          return false;
        e.addNoArgInstruction(ICONST_0); // push 0 (false)
        e.addNoArgInstruction(IRETURN);
        //     }

        //     for (int i = 2; i <= n / i; i++) {
        //      A: i = 2
        e.addLabel("A");
        e.addNoArgInstruction(ICONST_2); // push 2
        e.addNoArgInstruction(ISTORE_1); // i = 2

        //      D: if i > n / i goto B:
        e.addLabel("D");
        e.addNoArgInstruction(ILOAD_1); // push i
        e.addNoArgInstruction(ILOAD_0); // push n
        e.addNoArgInstruction(ILOAD_1); // push i
        e.addNoArgInstruction(IDIV); // n / i
        e.addBranchInstruction(IF_ICMPGT, "B"); // i > n / i

        e.addNoArgInstruction(ILOAD_0); // push n
        e.addNoArgInstruction(ILOAD_1); // push i
        e.addNoArgInstruction(IREM); // n % i
        e.addNoArgInstruction(ICONST_0); // push 0
        e.addBranchInstruction(IF_ICMPNE, "C"); // i > n / i
        e.addNoArgInstruction(ICONST_0); // push 0 (false)
        e.addNoArgInstruction(IRETURN);

        //      C: increment i by 1; branch to "D"
        e.addLabel("C");
        e.addIINCInstruction(1, 1); // i++
        e.addBranchInstruction(GOTO, "D");

        //      B:   return  True
        e.addLabel("B");
        e.addNoArgInstruction(ICONST_1); // push 1 (true)
        e.addNoArgInstruction(IRETURN);
        e.write();

    }
}
