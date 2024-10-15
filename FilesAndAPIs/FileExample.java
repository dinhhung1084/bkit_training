package FilesAndAPIs;

import java.io.File;
import java.io.IOException;

public class FileExample {

    public static void example1(){
        try {
            File file = new File("h:/javaFile123.txt");
            if (file.createNewFile()) {
                System.out.println("New File is created!");
            } else {
                System.out.println("File already exists.");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void example2(){
        String path = "";
        boolean bool = false;
        try {
            File file  = new File("h:/testFile1.txt");
            file.createNewFile();
            System.out.println(file);

            File file2 = file.getCanonicalFile();
            System.out.println(file2);
            bool = file2.exists();

            path = file2.getAbsolutePath();
            System.out.println(bool);
            if (bool) {
                System.out.print(path + " Exists? " + bool);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public static void example3(){
        File f=new File("h:/python");
        String filenames[]=f.list();
        for(String filename:filenames){
            System.out.println(filename);
        }
    }

    public static void example4(){
        File dir=new File("h:/python");
        File files[]=dir.listFiles();
        for(File file:files){
            System.out.println(file.getName()+" Can Write: "+file.canWrite()
                    +" Is Hidden: "+file.isHidden()+" Length: "+file.length()+" bytes ");
        }
    }


    public static void main(String[] args) {
        example1();
        example2();
        example3();
        example4();
    }
}
