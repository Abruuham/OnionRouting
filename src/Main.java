import javax.swing.*;
import java.io.File;
import java.util.*;

public class Main {

    private static WebBrowser browser = new WebBrowser();
    private static List<String> exclusionList = Arrays.asList(".git", ".idea", "OnionRouting.iml", "out", "README.md", "src");

    public static void main(String[] args) {
        // write your code here
        /**
         *  Use the terminal as the command line and listen for commands
         */
        System.out.println("Welcome to Onions-R-Us!\n");
        System.out.println("Enter a command to begin!\n");

        Scanner scanner = new Scanner(System.in);

        String command = "";

        while (!command.equals("power")) {
            System.out.print("user:: ");
            command = scanner.nextLine();
            if (command.equals("browse")) browse();
            else if (command.equals("configure")) configure();
            else if (command.equals("download")) download(scanner);
            else if (command.equals("power")) { System.out.println("Goodbye for now!");browser.dispose(); }
            else if (command.equals("ls")) listFiles();
            else System.out.println("No command \"" + command + " \"");
        }
    }


    public static void browse() {
        System.out.println("Welcome to the Internet or Something"); //browse();
        browser.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        browser.setSize(800, 600);
        browser.setVisible(true);
    }

    public static void configure() throws IOException {
        System.out.println("Configure your thang!");

        ClassLoader classLoader = WebBrowserConfigure.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("Control.txt");
        String data = WebBrowserConfigure.readFromInputStream(inputStream);

        Path fileName = Path.of("Control.txt");
        Files.writeString(fileName, data);
    }
    
    public static void download(Scanner sc) {
        VirtualMemory.printMemory();
        if (VirtualMemory.memory.size() == 0) System.out.println("No files to download...");

        else {
            System.out.println("To download all files use \'all\', otherwise use the index of the file");
            String select = sc.nextLine();
            VirtualMemory.execute(select); // Download all or can we specify files?
        }
    }


    public static void listFiles() {
        File directoryPath = new File(".\\");
        //List of all files and directories
        String contents[] = directoryPath.list();
        if(contents == null) {
            System.out.println("Nothing to see...");

        } else {
            System.out.println();
            for (int i = 0; i < contents.length; i++) {
                if (!exclusionList.contains(contents[i])) {
                    System.out.println("|-- " + contents[i]);
                }
            }
            System.out.println();
        }
    }
}


