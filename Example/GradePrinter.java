public class GradePrinter {
    public static void printGrades(int[] grades) {
        System.out.print("Current Grades: ");
        
        // BUG 5: Runtime Error. <= causes an ArrayIndexOutOfBoundsException 
        // when the loop tries to read the 4th index of a 4-item array.
        for (int i = 0; i <= grades.length; i++) {
            System.out.print(grades[i] + " ");
        }
        System.out.println();
    }
}