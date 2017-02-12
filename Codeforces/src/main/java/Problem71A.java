import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class Problem71A {

    public static void main(String[] args) {
        Scanner in = new Scanner(new BufferedReader(new InputStreamReader(System.in)));
        PrintWriter out = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
        for (int n = in.nextInt(); n > 0; n--) {
            String s = in.next();
            if (s.length() > 10) {
                out.print(s.charAt(0));
                out.print(s.length() - 2);
                out.println(s.charAt(s.length() - 1));
            } else {
                out.println(s);
            }
        }
        out.flush();
    }

}
