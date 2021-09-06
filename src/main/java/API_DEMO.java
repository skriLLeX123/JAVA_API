import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class API_DEMO {

    private static HttpURLConnection connection;

    public static void main(String[]args) throws IOException {
         StringBuffer stringBuffer = new StringBuffer();
         String line;
        BufferedReader bufferedReader;
        URL url = new URL("https://jsonplaceholder.typicode.com/albums");
        connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");
        connection.setConnectTimeout(5000);
        connection.setReadTimeout(5000);
        int status = connection.getResponseCode();

        if(status>299){
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getErrorStream()));
            while((line = bufferedReader.readLine())!=null){
                stringBuffer.append(line);
            }
            bufferedReader.close();
        }
        else{
            bufferedReader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            while((line = bufferedReader.readLine())!=null){
                stringBuffer.append(line);
            }
            bufferedReader.close();
        }
        System.out.println(stringBuffer);
    }
}
