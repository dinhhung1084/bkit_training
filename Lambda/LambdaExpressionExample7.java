package Lambda;
interface Sayable2{
    String say(String message);
}
public class LambdaExpressionExample7 {
    public static void main(String[] args) {
        Sayable2 person = message -> {
            String str1 = "DAY LA RAP VIET ";
            String str2 = str1 + message;
            return str2;
        };
        System.out.println(person.say("VIEON"));
    }

}
