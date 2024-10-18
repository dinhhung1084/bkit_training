package Serialization;

class Student implements java.io.Serializable {
    int id;
    String name;

    public Student(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

public class Persist {
    public static void main(String[] args) {
        try {
            Student2 s1 = new Student2(211, "ravi");

            // Creating stream and writing the object
            java.io.FileOutputStream fout = new java.io.FileOutputStream("H:\\javaFile123.txt");
            java.io.ObjectOutputStream out = new java.io.ObjectOutputStream(fout);
            out.writeObject(s1);
            out.flush();
            // closing the stream
            out.close();
            System.out.println("success");
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
