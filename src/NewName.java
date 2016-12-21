import java.util.Scanner;

/**
 * Created by Ленок on 19.12.2016.
 */
public class NewName {
    private String c;

    public static String readThisName(){
        Scanner in = new Scanner(System.in);
        System.out.print("Give new name:");
        String c;
        c = in.nextLine();
        return c;
    }
}
