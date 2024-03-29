import java.util.Arrays;
import java.util.List;

public class Print {

    void print(String s) {
        if (s == null) {
            throw new NullPointerException("Exception: s is null1!");
        }
        System.out.println("Inside method print: " + s);
    }

    public static void main(String[] args) {
        Print print = new Print();
        List list= Arrays.asList("first step", null, "second step");

        for (Object s:list) {
            try {
                print.print((String) s);
            }
            catch (NullPointerException e) {
                System.out.println(e.getMessage());
                System.out.println("Exception was processed. Program continues");
            }
            finally {
                System.out.println("Inside bloсk finally");
            }
            System.out.println("Go program....");
            System.out.println("-----------------");
        }

    }
}