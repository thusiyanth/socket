// RoundTripDelayCalculator.java
public class RoundTripDelayCalculator {

    public void run() {
        try {
            double transmissionDelay1 = InputUtils.getDoubleInput("Enter transmission delay for node 1 (in milliseconds): ");
            double propagationDelay1 = InputUtils.getDoubleInput("Enter propagation delay for node 1 (in milliseconds): ");
            double processingDelay1 = InputUtils.getDoubleInput("Enter processing delay for node 1 (in milliseconds): ");

            double transmissionDelay2 = InputUtils.getDoubleInput("Enter transmission delay for node 2 (in milliseconds): ");
            double propagationDelay2 = InputUtils.getDoubleInput("Enter propagation delay for node 2 (in milliseconds): ");
            double processingDelay2 = InputUtils.getDoubleInput("Enter processing delay for node 2 (in milliseconds): ");

            double transmissionDelay3 = InputUtils.getDoubleInput("Enter transmission delay for node 3 (in milliseconds): ");
            double propagationDelay3 = InputUtils.getDoubleInput("Enter propagation delay for node 3 (in milliseconds): ");
            double processingDelay3 = InputUtils.getDoubleInput("Enter processing delay for node 3 (in milliseconds): ");

            // Calculate and display average round-trip delay
            double averageRoundTripDelay = calculateAverageRoundTripDelay(
                    transmissionDelay1, propagationDelay1, processingDelay1,
                    transmissionDelay2, propagationDelay2, processingDelay2,
                    transmissionDelay3, propagationDelay3, processingDelay3
            );

            System.out.println("Average Round-Trip Delay: " + averageRoundTripDelay + " milliseconds");
        } catch (Exception e) {
            System.err.println("An error occurred: " + e.getMessage());
        }
    }

    private double calculateAverageRoundTripDelay(
            double transmissionDelay1, double propagationDelay1, double processingDelay1,
            double transmissionDelay2, double propagationDelay2, double processingDelay2,
            double transmissionDelay3, double propagationDelay3, double processingDelay3) {

        // Calculate one-way delays for each leg of the journey
        double leg1Delay = transmissionDelay1 + propagationDelay1 + processingDelay1;
        double leg2Delay = transmissionDelay2 + propagationDelay2 + processingDelay2;
        double leg3Delay = transmissionDelay3 + propagationDelay3 + processingDelay3;

        // Calculate round-trip delay
        double roundTripDelay = 2 * (leg1Delay + leg2Delay + leg3Delay);

        // Calculate average round-trip delay
        return roundTripDelay / 3;
    }
}
