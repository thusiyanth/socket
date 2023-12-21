// Main.java
public class Main {
    public static void main(String[] args) {
        try {
            RoundTripDelayCalculator calculator = new RoundTripDelayCalculator();
            calculator.run();
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }
}
