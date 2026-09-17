import java.util.Scanner;

public class InputHandler {
    public static String readStudentData() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Enter Student ID Number: ");
        int id = scanner.nextInt();
        
        System.out.print("Enter Student Name: ");
        // BUG 2: Reads the leftover \n from nextInt(). 
        // The user never gets to type their name, and it returns an empty string.
        String name = scanner.nextLine(); 
        
        return name;
    }
}