package example.day07;

import java.util.List;
import java.util.function.Function;

public class Exam4 {
    public static void main(String[] args) {
        Function< String , Integer > function = Integer::parseInt;
        System.out.println(function.apply("10"));

        //2. 
        List<String> names = List.of("유재석","강호동","신동엽","서장훈");
    }
}
