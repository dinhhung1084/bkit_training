package Lambda;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

class Product{
    int id;
    String name;
    float price;

    public Product(int id, String name, float price) {
        super();
        this.id = id;
        this.name = name;
        this.price = price;
    }
}

public class LambdaExpressionExample9 {
    public static void main(String[] args) {
        List<Product> list = new ArrayList<Product>();

        list.add(new Product(1,"HP Laptop",25000f));
        list.add(new Product(3,"Ceyboard",300f));
        list.add(new Product(2,"Dell Mouse",150f));
        list.add(new Product(4,"A Mouse",150f));
        list.add(new Product(5,"B Mouse",150f));
        list.add(new Product(6,"Sony Xperia",25000f));
        list.add(new Product(7,"Nokia Lumia",15000f));
        list.add(new Product(8,"Redmi4 ",26000f));
        list.add(new Product(9,"Lenevo Vibe",19000f));

        System.out.println("Sorting on basic...");

        Collections.sort(list,(p1,p2) -> {
            return p1.name.compareTo(p2.name);
        });
        for (Product p : list){
            System.out.println(p.id+" "+p.name+" "+p.price);
        }
        System.out.println("====================");
        Collections.sort(list, (p1,p2)-> {
            return Integer.compare(p1.id,p2.id);
        });
        for (Product p : list){
            System.out.println(p.id+" "+p.name+" "+p.price);
        }

        Stream<Product> filtered_data = list.stream().filter(p -> p.price > 20000);
        System.out.println("=================");
        filtered_data.forEach(p -> {
            System.out.println(p.name + ": " + p.price);
        });

    }

}
