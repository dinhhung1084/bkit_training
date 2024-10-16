package Stream;

import java.sql.SQLOutput;
import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

class Product {
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }
    public String getName() {
        return name;
    }
    public float getPrice() {
        return price;
    }
}

public class JavaStreamExample {

    public static void main(String[] args) {
        List<Product> productsList = new ArrayList<Product>();

        productsList.add(new Product(1, "HP Laptop", 25000f));
        productsList.add(new Product(2, "Dell Laptop", 30000f));
        productsList.add(new Product(3, "Lenevo Laptop", 28000f));
        productsList.add(new Product(4, "Sony Laptop", 28000f));
        productsList.add(new Product(5, "Apple Laptop", 90000f));

        List<Float> productPriceList2 = productsList.stream()
                .filter(product -> product.price < 30000)
                .map(product -> product.price)
                .collect(Collectors.toList());
        System.out.println(productPriceList2);

        productsList.stream()
                .filter(product -> product.price == 30000)
                .forEach(product -> System.out.println(product.name));

        Float totalPrice = productsList.stream()
                .map(product -> product.price)
                .reduce(0.0f, (sum, price) -> sum + price);
        System.out.println(totalPrice);

        float totalPrice1 = productsList.stream()
                .map(product -> product.price)
                .reduce(0.0f, Float::sum);
        System.out.println(totalPrice1);


        double totalPrice2 = productsList.stream()
                .collect(Collectors.summingDouble(p -> p.price));
        System.out.println(totalPrice2);

        Product product = productsList.stream().max((p1,p2) -> p1.price > p2.price ? 1 : -1).get();
        System.out.println(product.name);

        Product product1 = productsList.stream().min((p1,p2) -> p1.price > p2.price ? 1 : -1).get();
        System.out.println(product1.name);

        Product product2 = productsList.stream().max(Comparator.comparingDouble(value -> value.price)).orElse(null);
        System.out.println(product2.name);

        long count = productsList.stream().filter(p -> p.price < 30000).count();
        System.out.println(count);


        Set<Float> productPriceList = productsList.stream()
                .filter(p -> p.price < 30000)
                .map(p -> p.price)
                .collect(Collectors.toSet());
        System.out.println(productPriceList);

        Map<Integer, String> productPriceMap = productsList.stream()
                .collect(Collectors.toMap(p -> p.id, p-> p.name ));
        System.out.println(productPriceMap);

        List<Float> productPriceList1 = productsList.stream()
                .filter(p -> p.price < 30000)
                .map(Product::getPrice)
                .collect(Collectors.toList());
        System.out.println(productPriceList1);

    }
}
