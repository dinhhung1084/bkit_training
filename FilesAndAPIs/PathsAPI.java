package FilesAndAPIs;

import java.io.*;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.nio.file.*;
import java.nio.file.attribute.FileTime;
import java.nio.file.attribute.UserPrincipal;
import java.util.Comparator;
import java.util.stream.Stream;

public class PathsAPI {
    /**
     * The entry point of application.
     *
     * @param args the input arguments
     * @throws URISyntaxException the uri syntax exception
     * @throws IOException        the io exception
     */
    public static void main(String[] args) throws URISyntaxException, IOException {
//        Path path = Path.of("H:\\readme.txt");
//        boolean exists = Files.exists(path);
//        System.out.println("exists = " + exists);

//        FileTime lastModifiedTime = Files.getLastModifiedTime(path);
//        System.out.println("lastModifiedTime = " + lastModifiedTime);

//        long mismatchIndex = Files.mismatch(path, Paths.get("H:\\heh.txt"));
//        System.out.println("mismatch = " + mismatchIndex);

//        UserPrincipal owner = Files.getOwner(path);
//        System.out.println("owner = " + owner);

//        Path tempFile1 = Files.createTempFile("somePrefixOrNull", ".jpg");
//        System.out.println("tempFile1 = " + tempFile1);

//        Path tempFile2 = Files.createTempFile(path.getParent(), "somePrefixOrNull", ".jpg");
//        System.out.println("tempFile2 = " + tempFile2);

//        Path tmpDirectory = Files.createTempDirectory("prefix");
//        System.out.println("tmpDirectory = " + tmpDirectory);

//        Path newDirectory = Files.createDirectories(path.getParent().resolve("some/new/dir"));
//        System.out.println("newDirectory = " + newDirectory);

//        Path newFile = Files.createFile(newDirectory.resolve("emptyFile.txt"));
//        System.out.println("newFile = " + newFile);

//        Files.writeString(path, "this is my string hê lô các bạn đã đến với chanel của mình");
//        System.out.println("path = " + Files.readString(path));

//        Path utfFile = Files.createTempFile("some", ".txt");
//        Files.writeString(utfFile, "this is my string ää öö üü"); // UTF 8
//        System.out.println("utfFile = " + utfFile);

//        Path iso88591File = Files.createTempFile("some", ".txt");
//        Files.writeString(iso88591File, "this is my string ää öö üü", StandardCharsets.ISO_8859_1); // otherwise == utf8
//        System.out.println("iso88591File = " + iso88591File);


//        Path anotherIso88591File = Files.createTempFile("some", ".txt");
//        Files.write(anotherIso88591File, "this is my string ää öö üü".getBytes(StandardCharsets.ISO_8859_1));
//        System.out.println("anotherIso88591File = " + anotherIso88591File);


//        Path anotherUtf8File = Files.createTempFile("some", ".txt");
//        Files.writeString(anotherUtf8File, "this is my string ää öö üü", StandardCharsets.UTF_8,
//                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
//        System.out.println("anotherUtf8File = " + anotherUtf8File);

//        Path oneMoreUtf8File = Files.createTempFile("some", ".txt");
//        Files.write(oneMoreUtf8File, "this is my string ää öö üü".getBytes(StandardCharsets.UTF_8),
//                StandardOpenOption.CREATE, StandardOpenOption.TRUNCATE_EXISTING, StandardOpenOption.WRITE);
//        System.out.println("oneMoreUtf8File = " + oneMoreUtf8File);


//        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(path)) {
//            bufferedWriter.write("Hello, this is UTF-8 text!");
//            bufferedWriter.newLine();
//            bufferedWriter.write("More text here!");
//        }

//        byte[] data = "Hello, this is binary data!".getBytes(StandardCharsets.UTF_8);
//        try (OutputStream os = Files.newOutputStream(path)) {
//            os.write(data);
//        }

//        String s = Files.readString(path);// UTF 8
//        System.out.println("s = " + s);

//        s = Files.readString(path, StandardCharsets.ISO_8859_1); // otherwise == utf8
//        System.out.println("s = " + s);

//        s = new String(Files.readAllBytes(path), StandardCharsets.UTF_8);
//        System.out.println("s = " + s);


//        try (BufferedReader bufferedReader = Files.newBufferedReader(path)) {
//            String line;
//            while ((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
//            }
//        }

//        try (InputStream is = Files.newInputStream(path)) {
//            byte[] buffer = new byte[1024];
//            int bytesRead;
//            while ((bytesRead = is.read(buffer)) != -1) {
//                System.out.write(buffer, 0, bytesRead);
//            }
//        }


//        Path utfFile = Files.createTempFile("some", ".txt");

//        try {
////            Files.move(utfFile, Path.of("h:\\dev"));  // this is wrong!
//            Files.move(utfFile, Path.of("h:\\dev").resolve(utfFile.getFileName().toString()));
//        } catch (FileAlreadyExistsException e) {
//            System.out.println(e);
//        }

//        Path utfFile2 = Files.createTempFile("some", ".txt");
//        Files.move(utfFile2, Path.of("h:\\dev").resolve(utfFile.getFileName().toString()), StandardCopyOption.REPLACE_EXISTING);
//
//        Path utfFile3 = Files.createTempFile("some", ".txt");
//        Files.move(utfFile3, Path.of("h:\\dev").resolve(utfFile.getFileName().toString()), StandardCopyOption.ATOMIC_MOVE);

//        Path tmpDir = Paths.get("h:\\some.jpg");
//        try {
//            Files.delete(tmpDir);
//        } catch (DirectoryNotEmptyException e) {
//            e.printStackTrace();
//        }

//        Path dir = Paths.get("H:\\some");
//
//        try (Stream<Path> walk = Files.walk(dir)) {
//            walk.sorted(Comparator.reverseOrder()).forEach(paths -> {
//                try {
//                    Files.delete(paths);
//                } catch (IOException e) {
//                    System.err.println("Không thể xóa: " + paths + " - " + e.getMessage());
//                }
//            });
//        } catch (IOException e) {
//            e.printStackTrace();
//        }


//        Path tmpDirectory = Paths.get("H:\\python");
//        try (var files = Files.list(tmpDirectory)) {
//            files.forEach(System.out::println);
//        }

//        try (var files = Files.newDirectoryStream(tmpDirectory, "*.py")) {
//            files.forEach(System.out::println);
//        }

//        try (var files = Files.walk(tmpDirectory)) {
//            files.forEach(System.out::println);
//        }

//        Path p = Paths.get("./src/main/java/../resources/some.properties");
//        System.out.println("p.isAbsolute() = " + p.isAbsolute());

//        Path p2 = p.toAbsolutePath();
//        System.out.println("p2 = " + p2);
//        System.out.println("p2.isAbsolute() = " + p2.isAbsolute());

//        Path p3 = p.normalize().toAbsolutePath();
//        System.out.println("p3 = " + p3);
//        System.out.println("p3.isAbsolute() = " + p3.isAbsolute());

//        Path relativizedPath = Paths.get("h:\\python").relativize(p3);
//        System.out.println("relativizedPath = " + relativizedPath);



    }
}
