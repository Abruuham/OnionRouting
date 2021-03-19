
import java.io.*;
import java.net.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;
import javax.swing.*;
import javax.swing.event.*;

public class WebBrowser extends JFrame{

    private JTextField addressField;
    private JEditorPane window;
    private JButton backButton;
    private LinkedList<String> history = new LinkedList<>();
    private ArrayList<Object> downloads = new ArrayList<>();

    public WebBrowser() {
        super("Secure Web Browser");

        addressField = new JTextField("https://");
        addressField.addActionListener(
                event -> loadSite(event.getActionCommand())
        );

        add(addressField, BorderLayout.NORTH);
        backButton = new JButton("<");
        backButton.addActionListener(
                event -> loadSite(history.pop())
        );
        add(backButton, BorderLayout.WEST);

        window = new JEditorPane();
        window.setEditable(false);
        window.addHyperlinkListener(
                event -> {
                    if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                        loadSite(event.getURL().toString());
                    }
                    System.out.println(history);
                }

        );
        add(new JScrollPane(window), BorderLayout.CENTER);

    }

    private void loadSite(String text) {
        try {
            if(text.endsWith(".zip")){
                VirtualMemory.addToMemory(text);
                JOptionPane.showMessageDialog(null, "Added to Downloads!");
                return;
            }
            window.setPage(text);
            addressField.setText(text);
            history.add(text);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid URL!");
        }
    }
}
