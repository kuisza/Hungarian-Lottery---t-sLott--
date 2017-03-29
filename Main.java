/**
 * Created by bedaa on 08/03/2017.
 */
public class Main {
    public static void main(String[] args) {
        try {
        Week week = new Week();
        week.weekly(); } catch (IllegalArgumentException | NullPointerException | ArrayIndexOutOfBoundsException e) {
            System.out.println(e.getMessage());
        }
    }
}
