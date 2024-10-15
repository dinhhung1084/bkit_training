package FilesAndAPIs;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

public class NasaApiExample {
    public static void main(String[] args) {
        try {
            // Tạo một đối tượng URL chứa API endpoint
            URL url = new URL("https://api.nasa.gov/planetary/apod?api_key=DEMO_KEY");

            // Mở kết nối HTTP đến URL và ép kiểu về HttpURLConnection
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();

            // Thiết lập thuộc tính yêu cầu, ở đây là chấp nhận phản hồi JSON
            connection.setRequestProperty("accept", "application/json");

            // Thực hiện yêu cầu, và nhận phản hồi qua InputStream
            InputStream responseStream = connection.getInputStream();

            // Sử dụng Jackson ObjectMapper để chuyển đổi phản hồi JSON thành đối tượng APOD
            ObjectMapper mapper = new ObjectMapper();
            APOD apod = mapper.readValue(responseStream, APOD.class);

            // In ra tiêu đề của APOD (Hình ảnh thiên văn của ngày hôm đó)
            System.out.println("Title: " + apod.getTitle());
            System.out.println("Explanation: " + apod.getExplanation());

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

// Định nghĩa lớp APOD, với các thuộc tính khớp với các trường trong JSON phản hồi
class APOD {
    private String title;
    private String explanation;
    private String url;

    // Getters và setters cho các trường
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getExplanation() {
        return explanation;
    }

    public void setExplanation(String explanation) {
        this.explanation = explanation;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
