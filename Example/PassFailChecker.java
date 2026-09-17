public class PassFailChecker {
    public static String determineStatus(int finalScore) {
        if (finalScore >= 50) {
            return "Passed";
        }
        if (finalScore < 50) {
            return "Failed";
        }
        // BUG 8: Compiler Error. The compiler requires a guaranteed return statement. 
        // It does not calculate the math to realize >= 50 and < 50 cover all scenarios.
    }
}