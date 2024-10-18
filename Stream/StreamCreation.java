package Stream;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;
import java.util.regex.Pattern;
import java.util.stream.*;

class Product1 {
    int id;
    String name;

    public Product1(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }
}


public class StreamCreation {
    //Empty Stream
    public static Stream<String> streamOf(List<String> list) {
        return list.isEmpty() || list == null ? Stream.empty() : list.stream();
    }

    private static long counter;

    private static void wasCalled() {
        counter++;
    }


    public static void main(String[] args) throws IOException {
        List<String> list = new ArrayList<String>();
        streamOf(list);

        Collection<String> collection = Arrays.asList("a", "ds", "dsasd");
        Stream<String> streamOfCollection = collection.stream();

        String[] arr = new String[]{"a", "b", "c"};
        Stream<String> streamOfArrayFull = Arrays.stream(arr);
        Stream<String> streamOfArrayPart = Arrays.stream(arr, 1, 3);

        Stream<String> buider = Stream.<String>builder().add("a").add("b").build();
        Stream<String> streamGenerated = Stream.generate(() -> "element").limit(10);

        Stream<Integer> streamIterated = Stream.iterate(40, n -> n + 2).limit(20);

        // Stream of Primitives
        IntStream intStream = IntStream.range(1, 3);
        LongStream longStream = LongStream.rangeClosed(1, 3);

        Random random = new Random();
        DoubleStream doubleStream = random.doubles(3);

        // Stream of String
        IntStream streamOfChars = "abc".chars();
        Stream<String> streamOfString =
                Pattern.compile(", ").splitAsStream("a, b, c");

        // Stream of File
        Path path = Paths.get("H:\\testFile1.txt");
        Stream<String> s1 = Files.lines(path);
        Stream<String> s2 = Files.lines(path, Charset.forName("UTF-8"));

        // Referencing a Stream
        List<String> elements =
                Stream.of("a", "b", "c").filter(element -> element.contains("b"))
                        .collect(Collectors.toList());
        Optional<String> anyElement = elements.stream().findAny();
        Optional<String> firstElement = elements.stream().findFirst();

        // Stream Pipeline
        Stream<String> s3 = Stream.of("a", "das", "dafs").skip(1);

        List<String> list1 = Arrays.asList("abc1", "abc2", "abc3");
        long size = list1.stream().skip(1)
                .map(element -> element.substring(0, 3)).sorted().count();

        // Lazy Invocation
//        counter = 0;
//        Stream<String> stream = list1.stream().filter(element -> {
//            wasCalled();
//            return element.contains("2");
//        });

        // Order of Execution
        long size1 = list1.stream().skip(2).map(element -> {
            wasCalled();
            return element.substring(0, 3);
        }).count();


        //Stream Reduction
        OptionalInt reduced =
                IntStream.range(1, 4).reduce((a, b) -> a + b); // 1 + 2 + 3
        int reducedTwoParams =
                IntStream.range(1, 4).reduce(10, (a, b) -> a + b);
        int reducedParams = Stream.of(1, 2, 3)
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    return a + b;
                });
        int reducedParallel = Arrays.asList(1, 2, 3).parallelStream()
                .reduce(10, (a, b) -> a + b, (a, b) -> {
                    return a + b;
                });

        List<Product1> productList = Arrays.asList(new Product1(23, "potatoes"),
                new Product1(14, "orange"), new Product1(13, "lemon"),
                new Product1(23, "bread"), new Product1(13, "sugar"));

        List<String> collectorCollection =
                productList.stream().map(Product1::getName).collect(Collectors.toList());

        String listToString = productList.stream().map(Product1::getName)
                .collect(Collectors.joining(", ", "[", "]"));


    }
}
