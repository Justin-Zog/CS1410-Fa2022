// Justin Herzog *Testing Logical Operators*
import java.util.*;

public class XOR {

    public static void main(String[] args) {

        // Initial Values
        int a = 5;
        int b = 8;
        int c = (a ^ b);
        // Bitwise XOR statement
        // Given that 5 is 0101 and 8 is 1000, XOR should return "1101" or 13
        System.out.println("a ^ b = " + (a ^ b));

        // To undo a XOR operator we just do it again. If we take a ^ c then it should equal b (1000 or 8)
        System.out.println("a ^ c = " + (a ^ c));

    }

}
