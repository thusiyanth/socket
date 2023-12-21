// InputUtils.java
import java.util.Scanner;

public class InputUtils {
    public static double getDoubleInput(String message) {
        Scanner scanner = new Scanner(System.in);
        System.out.println(message);
        return scanner.nextDouble();
    }
}
