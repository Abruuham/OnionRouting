import javax.swing.*;
import java.util.*;

public class Main {

    public static void main(String[] args) {
    // write your code here
        /**
         *  Use the terminal as the command line and listen for commands
         */
        System.out.println("Welcome to Onions-R-Us!\n");
        System.out.println("Enter a command to begin!\n");

        Scanner scanner = new Scanner(System.in);

        System.out.print("user:: ");
        String command = "";

        while(!command.equals("power")){
            System.out.print("user:: ");
            command = scanner.nextLine();
            if(command.equals("browse")) {
                System.out.println("Welcome to the Internet or Something"); //browse();
                WebBrowser browser = new WebBrowser();
                browser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                browser.setSize(800,  600);
                browser.setVisible(true);
            }
            else if(command.equals("configure")) System.out.println("Configure your thing");//configure();
            else if(command.equals("download")) System.out.println("Downloading your garbage");//download();
            else if(command.equals("power")) System.out.println("Goodbye for now!");
            else System.out.println("No command \"" + command + " \"");
        }
    }


//    public browse(){
//        WebBrowser browser = new WebBrowser();
//        browser.run(); // Do we need to run it with a config file?
//    }
//    public configure(){
//        WebBrowserConfigure.configure(); // will it write to a file or simply change it in real time?
//    }
//    public download(){
//        VirtualMemory.download(); // Download all or can we specify files?
//    }
}
