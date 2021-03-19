import javax.swing.*;
import java.util.*;

public class Main {

    private static WebBrowser browser = new WebBrowser();

    public static void main(String[] args) {
    // write your code here
        /**
         *  Use the terminal as the command line and listen for commands
         */
        System.out.println("Welcome to Onions-R-Us!\n");
        System.out.println("Enter a command to begin!\n");

        Scanner scanner = new Scanner(System.in);

//        System.out.print("user:: ");
        String command = "";

        WebBrowser browser = new WebBrowser();
        while(!command.equals("power")){
            System.out.print("user:: ");
            command = scanner.nextLine();
<<<<<<< Updated upstream
            if(command.equals("browse")) browse();
            else if(command.equals("configure")) System.out.println("Configure your thing");//configure();
            else if(command.equals("download")) download(scanner);
            else if(command.equals("power")){ System.out.println("Goodbye for now!");  browser.dispose();}
=======
            if(command.equals("browse")) {
                System.out.println("Welcome to the Internet or Something"); //browse();
                ;
                browser.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
                browser.setSize(800,  600);
                browser.setVisible(true);
            }
            else if(command.equals("configure")) System.out.println("Configure your thing");//configure();
            else if(command.equals("download")) System.out.println("Downloading your garbage");//download();
            else if(command.equals("power")){
                System.out.println("Goodbye for now!");
                browser.dispose();
            }
            else System.out.println("No command \"" + command + " \"");
        }
    }


    public static void browse(){
        System.out.println("Welcome to the Internet or Something"); //browse();
        browser.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE);
        browser.setSize(800,  600);
        browser.setVisible(true);
    }
//    public configure(){
//        WebBrowserConfigure.configure(); // will it write to a file or simply change it in real time?
//    }
    public static void download(Scanner sc){
        VirtualMemory.printMemory();
        System.out.println("To download all files use \'all\', otherwise use the index of the file");
        String select = sc.nextLine();
        VirtualMemory.execute(select); // Download all or can we specify files?
    }
}
