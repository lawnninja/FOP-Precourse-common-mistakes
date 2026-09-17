public class Main {
    public static void main(String[] args) {
        System.out.println("--- Starting Grading Pipeline ---");
        
        // BUG 1: Compiler error. Attempting to call a non-static method directly 
        // from the static main method without creating a Main object first.
        runPipeline(); 
    }

    public void runPipeline() {
        String studentName = InputHandler.readStudentData();
        boolean isAdmin = Authenticator.checkAdmin(studentName);
        
        int[] originalGrades = {45, 80, 20, 95};
        int[] backup = DataBackup.createBackup(originalGrades);
        
        GradePrinter.printGrades(backup);
        // ... pipeline continues ...
    }
}