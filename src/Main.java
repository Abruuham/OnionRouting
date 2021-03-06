import javax.swing.*;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;

public class Main {

    private static WebBrowser browser = new WebBrowser();
    private static List<String> exclusionList = Arrays.asList(".git", ".idea", "OnionRouting.iml", "out", "README.md", "src");

    public static void main(String[] args) throws IOException {
        // write your code here
        /**
         *  Use the terminal as the command line and listen for commands
         */
        Extras.ascii();
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
            else if (command.equals("power")) { System.out.println("Goodbye for now!"); browser.dispose(); System.exit(0); }
            else if (command.equals("ls")) listFiles();
            else if (command.equals("notepad")) openNotepad();
            else if (command.equals("help")) Extras.commands();
            else System.out.println("No command \"" + command + " \"");
        }
    }


    /**
     * Opens the browser
     */
    public static void browse() {
        System.out.println("Welcome to the Internet or Something"); //browse();
        browser.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        browser.setSize(800, 600);
        browser.setVisible(true);
    }

    public static void configure() throws IOException {
        System.out.println("Configure your thang!");
        int choice = 1;
        int repeat = 2;
        Scanner yesNo = new Scanner(System.in);

        while (repeat == 2) {
            configHelp(choice);
            System.out.println("Are you satisfied with the settings?\n1. Yes\t\t2. No");
            repeat = yesNo.nextInt();
        }
    }

    private static void configHelp(int chose) throws IOException{
        ClassLoader classLoader = WebBrowserConfigure.class.getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("Control.txt");
        System.out.println("Would you like \n1. to see your current settings?\n " +
                "OR\n2. Configure your settings?");
        Scanner mainObj = new Scanner(System.in);
        chose = mainObj.nextInt();
        if (chose == 1) {
//            look at settings
            System.out.println("Your settings are");
            String line = "";
            try (BufferedReader br = new BufferedReader(new InputStreamReader(inputStream))) {
                while ((line = br.readLine()) != null) {
                    System.out.println(line + ": " + br.readLine());
                }
            }
        } else {
//            configure all settings
            String data = WebBrowserConfigure.readFromInputStream(inputStream);

            Path fileName = Path.of("src/Control.txt");
            Files.writeString(fileName, data);
        }
    }

    /**
     * Downloads the specified files that the user previously saved, to the root directory
     * @param sc - passes a scanner
     */
    public static void download(Scanner sc) {
        VirtualMemory.printMemory();
        if (VirtualMemory.memory.size() == 0) System.out.println("No files to download...");

        else {
            System.out.println("To download all files use \'all\', otherwise use the index of the file");
            String select = sc.nextLine();
            VirtualMemory.execute(select); // Download all or can we specify files?
        }
    }


    /**
     * lists all downloaded files in the root directory
     */
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

    public static void openNotepad(){
        EncryptedNotepad e = new EncryptedNotepad();
    }
}


