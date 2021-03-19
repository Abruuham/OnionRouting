import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class WebBrowserConfigure {
//     public static void main(String[] args) throws IOException {
//         ClassLoader classLoader = WebBrowserConfigure.class.getClassLoader();
//         InputStream inputStream = classLoader.getResourceAsStream("Control.txt");
//         String data = readFromInputStream(inputStream);

//         Path fileName = Path.of("Control.txt");
//         Files.writeString(fileName, data);
// //        System.out.println(data);
//         //write to control file with seperated lines for choice and answer
//     }

    public static String readFromInputStream(InputStream inputStream) throws IOException {
        StringBuilder resultStringBuilder = new StringBuilder();
        String option = "";
        String fileTxt = "";
        try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
            String line;
            String lane;
            while ((line = br.readLine()) != null) {
                lane = br.readLine();
                resultStringBuilder.append(line).append("\n");
                lane = changeMe(line, lane);
                // return the answer and update to lane
                option += line + " is " + lane + "\n";
                fileTxt += line + "\n" + lane + "\n";
            }
        }
//        return resultStringBuilder.toString();
        System.out.println(option);
        return fileTxt;
    }

    private static String changeMe(String setting, String choice) {
        System.out.println(setting + " is ...\n1. off\t2. on" );
        Scanner myObj = new Scanner(System.in);
        int ans = myObj.nextInt();
        if(ans == 1) {
            System.out.println("off\n\n");
            return "off";
        } else {
            System.out.println("on\n\n");
            return "on";
        }
//        return choice;
    }
}