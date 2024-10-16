package Stream;

import java.util.stream.Stream;

public class JavaStreamExample1 {
    public static void main(String[] args) {
        Stream.iterate(0, e -> e + 2 )
                .filter(integer -> integer % 5 == 0)
                .limit(5)
                .forEach(System.out::println);
    }
}
