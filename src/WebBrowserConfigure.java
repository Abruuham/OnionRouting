import java.io.*;
import java.util.*;

public class WebBrowserConfigure {
    public static void main(String[] args) throws IOException {
        ClassLoader classLoader = WebBrowserConfigure.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("Control.txt");
        String data = readFromInputStream(inputStream);
        System.out.println(data);
    }

    public static String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            while ((line = br.readLine()) != null) {
                resultStringBuilder.append(line).append("\n");
            }
        }
        return resultStringBuilder.toString();
    }


}