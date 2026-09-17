import java.util.ArrayList;

public class FailingGradeFilter {
    public static void removeFailing(ArrayList<Integer> grades) {
        // BUG 6: Runtime/Logical Error. Removing an item shifts all subsequent items left.
        // The loop index 'i' moves forward, skipping the element immediately after the removed one.
        for (int i = 0; i < grades.size(); i++) {
            if (grades.get(i) < 50) {
                grades.remove(i);
            }
        }
        System.out.println("Grades after filter: " + grades);
    }
}