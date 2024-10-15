package Lambda;
interface Addable{
    int add(int a, int b);
}

public class LambdaExpressionExample5 {
    public static void main(String[] args) {
        Addable s1 = (a, b) -> (a + b);
        System.out.println(s1.add(10,20));

        Addable s2 = (int a,int b) -> (a + b);
        System.out.println(s2.add(100,20));

        Addable s3 = (a, b) -> {
                return a + b;
        };
        System.out.println(s3.add(90,10));
    }


}
