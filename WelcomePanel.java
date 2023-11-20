import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePanel extends JPanel {

    public WelcomePanel() {
        // Set the background color to light green
        setBackground(new Color(144, 238, 144));

        JLabel welcomeLabel = new JLabel("Finance Tracker Management");
        welcomeLabel.setHorizontalAlignment(SwingConstants.CENTER);
        welcomeLabel.setFont(new Font("SansSerif", Font.PLAIN, 24));
        welcomeLabel.setForeground(Color.WHITE); // Set the font color to dark green

        // Instantiate and add different GUIs
        JPanel panel1 = new FirstPanel().getPanel();
        JPanel panel2 = new SecondPanel().getPanel();

        JTabbedPane tabbedPane = new JTabbedPane();
        tabbedPane.addTab("Expenses", panel1);
        tabbedPane.addTab("Income", panel2);
        
        // Customize the tabbedPane
        tabbedPane.setFont(new Font("SansSerif", Font.PLAIN, 18));
        tabbedPane.setForeground(Color.WHITE);
        tabbedPane.setBackground(new Color(0, 100, 0)); // Set the background color of tabs

        tabbedPane.setTabPlacement(JTabbedPane.TOP); // Set the tab placement to the top

        setLayout(new BorderLayout());
        add(welcomeLabel, BorderLayout.NORTH);
        add(tabbedPane, BorderLayout.CENTER);
        setVisible(true);
    }
}

// First GUI class
class FirstPanel {
    private JPanel panel;

    public FirstPanel() {
        panel = new JPanel();
        
        panel.add(new JLabel("EXPENSES"));
        // Add other components as needed
    }

    public JPanel getPanel() {
        return panel;
    }
}

// Second GUI class
class SecondPanel {
    private JPanel panel;

    public SecondPanel() {
        panel = new JPanel();
        
        panel.add(new JLabel("INCOME"));
        
        // Add other components as needed
    }

    public JPanel getPanel() {
        return panel;
    }
}
