import java.util.*;
import java.io.*;
import java.net.*;

public class VirtualMemory {
    WebBrowser browser;
    public static ArrayList<String> memory = new ArrayList<String>();  // The list of links the user has "Downloaded"

    // Use this to see current files
    public static void printMemory() {
        for(int i = 0; i < memory.size(); i++) {
            System.out.println(memory.get(i));
        }
    }

    // Call this with the link to the download
    public static void addToMemory(String extension) {
        memory.add(extension);
    }

    // Download specified files in the array
    public static void execute(String file) {
        Scanner sc = new Scanner(System.in);
        String fileName;
        if (file.equals("all")) {
            for (int i = 0; i < memory.size(); i++) {
                System.out.println("What would you like the first file called?\n");
                fileName = sc.nextLine();
                download(memory.remove(i), fileName);
            }
        } else {
            System.out.println("What would you like the first file called?\n");
            fileName = sc.nextLine();
            download(memory.remove(Integer.parseInt(file)), fileName);
        }
    }

    public static void download(String FILE_URL, String FILE_NAME) {
        try (BufferedInputStream in = new BufferedInputStream(new URL(FILE_URL).openStream());
             FileOutputStream fileOutputStream = new FileOutputStream(FILE_NAME + ".zip")) {
            byte dataBuffer[] = new byte[1024];
            int bytesRead;
            while ((bytesRead = in.read(dataBuffer, 0, 1024)) != -1) {
                fileOutputStream.write(dataBuffer, 0, bytesRead);
            }
        } catch (IOException e) {
            // handle exception
            System.out.println("Sorry something terrible has gone wrong and Onions-R-Us claims no responsibility...");
        }
    }
}


