import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class API_DEMO {

    private static HttpURLConnection connection;
    public static void main(String[]args) throws IOException {
        URL url = new URL("https://jsonplaceholder.typicode.com/albums");
        System.out.println(url.openConnection());

    }
}
