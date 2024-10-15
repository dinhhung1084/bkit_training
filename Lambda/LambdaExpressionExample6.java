package Lambda;

import java.util.ArrayList;
import java.util.List;

public class LambdaExpressionExample6 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("jeee");
        list.add("he");
        list.add("asdfasd");
        list.add("asdf");

        list.forEach(
            (ls) -> System.out.println(ls)
        );
    }
}
