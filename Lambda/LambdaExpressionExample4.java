package Lambda;

interface Sayable{
    public String say(String name);
}

public class LambdaExpressionExample4 {
    public static void main(String[] args) {
        Sayable s1 = (name) -> {
            return "Hello World!" + name;
        };
        System.out.println(s1.say("www"));

        Sayable s2 = name -> {
            return "Hello, " + name;
        };
        System.out.println(s2.say("hehehe"));
    }
}
