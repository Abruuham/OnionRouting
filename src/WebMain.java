import javax.swing.JFrame;

public class WebMain {
    public static void main (String args []) {
        WebBrowser browser = new WebBrowser();
        browser.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        browser.setSize(800,  600);
        browser.setVisible(true);
    }

}