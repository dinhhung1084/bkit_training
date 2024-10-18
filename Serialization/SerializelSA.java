package Serialization;

class Person implements java.io.Serializable {
    int id;
    String name;

    public Person(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

class Student1 extends Person{
    String course;
    int fee;

    public Student1(int id, String name, String course, int fee) {
        super(id, name);
        this.course = course;
        this.fee = fee;
    }
}

public class SerializelSA {
    public static void main(String[] args) {
        try {
            Student1 s1 = new Student1(211, "ravi", "java", 5000);

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
        try {
            // Creating stream to read the object
            java.io.FileInputStream fin = new java.io.FileInputStream("H:\\javaFile123.txt");
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fin);
            Student1 s = (Student1) in.readObject();
            // printing the data of the serialized object
            System.out.println(s.id + " " + s.name + " " + s.course + " " + s.fee);
            // closing the stream
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
