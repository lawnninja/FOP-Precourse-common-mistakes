public class BonusAdder {
    public static void addTenPoints(int score) {
        // BUG 7: Logical Error. 'score' is a primitive, so this is just a local copy.
        // The original variable passed into this method from Main will remain completely unchanged.
        score = score + 10;
        System.out.println("Inside method, score is: " + score);
    }
}