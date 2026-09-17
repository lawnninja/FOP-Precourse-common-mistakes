public class DataBackup {
    public static int[] createBackup(int[] original) {
        // BUG 4: Logical Error. This does not copy the array. It just creates 
        // a second remote control pointing to the exact same array in memory.
        int[] backup = original;
        
        // Modifying the backup accidentally destroys the original data.
        backup[0] = 999; 
        return backup;
    }
}