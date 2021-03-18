
import java.io.*;
import java.net.*;

import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import javax.swing.*;
import javax.swing.event.*;

public class WebBrowser extends JFrame{

    private JTextField addressField;
    private JEditorPane window;
    private ArrayList<String> history = new ArrayList<String>();
    private ArrayList<Object> downloads = new ArrayList<>();

    public WebBrowser() {
        super("Secure Web Browser");

        addressField = new JTextField("https://");
        addressField.addActionListener(
                event -> loadSite(event.getActionCommand())
        );
        add(addressField, BorderLayout.NORTH);

        window = new JEditorPane();
        window.setEditable(false);
        window.addHyperlinkListener(
                event -> {
                    if (event.getEventType() == HyperlinkEvent.EventType.ACTIVATED) {
                        loadSite(event.getURL().toString());
                    }
                }

        );
        add(new JScrollPane(window), BorderLayout.CENTER);


    }

    private void loadSite(String text) {
        try {
            window.setPage(text);
            addressField.setText(text);
            history.add(text);
        }
        catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Invalid URL!");
        }
    }
}
