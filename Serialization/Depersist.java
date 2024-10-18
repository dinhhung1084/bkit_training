package Serialization;

public class Depersist {
    public static void main(String[] args) {
        try {
            // Creating stream to read the object
            java.io.FileInputStream fin = new java.io.FileInputStream("H:\\javaFile123.txt");
            java.io.ObjectInputStream in = new java.io.ObjectInputStream(fin);
            Student2 s = (Student2) in.readObject();
            // printing the data of the serialized object
            System.out.println(s.id + " " + s.name);
            // closing the stream
            in.close();
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
