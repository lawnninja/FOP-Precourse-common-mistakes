public class CertificateGenerator {
    public static void printStars() {
        System.out.print("Certificate Stars: ");
        
        // BUG 9: Logical Error. The semicolon instantly terminates the loop.
        // The loop runs 5 times doing nothing, then prints exactly ONE star.
        for (int i = 0; i < 5; i++); 
        {
            System.out.print("* ");
        }
        System.out.println();
    }
}