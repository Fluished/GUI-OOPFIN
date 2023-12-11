import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class RegisterPanel extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public static String username;
    public static ArrayList<String> registeredUser = new ArrayList<>();
    private ArrayList<String> registeredPass = new ArrayList<>();

    public RegisterPanel() {
        setTitle("Carbon Footprint Tracker");
        // setSize(800, 600);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel registerPanel = createRegisterPanel();
        cardPanel.add(registerPanel, "register");

        getContentPane().setLayout(new BorderLayout());

        add(cardPanel, BorderLayout.CENTER);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);

        setVisible(true);
    }

    public JPanel createRegisterPanel() {
        JPanel registerPanel = new JPanel(new BorderLayout());

        // Left side panel for username and password
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);// 7, 7, 7, 7

        Font sansSerifFont = new Font("SansSerif", Font.PLAIN, 14);
        Font userlgFont = new Font("SansSerif", Font.BOLD, 25);

        JLabel userlgLabel = new JLabel("User Registration");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton registerButton = new JButton("Register");

        userlgLabel.setFont(userlgFont);
        userlgLabel.setForeground(new Color(144, 238, 144));
        usernameLabel.setFont(sansSerifFont);
        passwordLabel.setFont(sansSerifFont);
        usernameField.setFont(sansSerifFont);
        passwordField.setFont(sansSerifFont);
        registerButton.setFont(sansSerifFont);

        registerButton.setBackground(new Color(144, 238, 144)); // Set the background color
        registerButton.setForeground(Color.WHITE); // Set the text color
        registerButton.setFocusPainted(true); // Remove the focus border
        registerButton.setPreferredSize(new Dimension(140, 40));

        gbc.gridx = 1;
        gbc.gridy = 0;
        gbc.anchor = GridBagConstraints.WEST;
        leftPanel.add(userlgLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        leftPanel.add(usernameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.weightx = 100.0; // Make the usernameField take up more horizontal space
        leftPanel.add(usernameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        leftPanel.add(passwordLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        leftPanel.add(passwordField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        leftPanel.add(registerButton, gbc);

        registerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setUsername(usernameField.getText());
                String username = getUsername();
                char[] pass = passwordField.getPassword();
                String password = pass.toString();

                registeredUser.add(username);
                registeredPass.add(password);

                // Using the WelcomePanel class
                // *open the welcome panel when button is pressed *************
                WelcomePanel welcomePanel = new WelcomePanel();
                cardPanel.add(welcomePanel, "welcome");
                cardLayout.show(cardPanel, "welcome");

                // removed account verification **************
            }
        });

        // Right side panel for empty space with a green background
        JPanel rightPanel = new JPanel(new GridBagLayout());
        rightPanel.setBackground(new Color(144, 238, 144));

        JLabel welcomeLabel = new JLabel("Welcome, friend!");
        JLabel signInLabel = new JLabel("Enter your personal details to get started");

        Font bigFont = new Font("SansSerif", Font.BOLD, 30);
        Font smallFont = new Font("SansSerif", Font.PLAIN, 14);
        welcomeLabel.setFont(bigFont);
        welcomeLabel.setForeground(Color.WHITE);
        signInLabel.setFont(smallFont);
        signInLabel.setForeground(Color.WHITE);

        GridBagConstraints gbc1 = new GridBagConstraints();
        gbc1.gridx = 0;
        gbc1.gridy = 0;
        rightPanel.add(welcomeLabel, gbc);

        gbc.gridy = 1;
        rightPanel.add(Box.createRigidArea(new Dimension(20, 20))); // Add some space between labels

        gbc.gridy = 4;
        rightPanel.add(signInLabel, gbc);

        // Add the left and right panels to the main login panel
        registerPanel.add(leftPanel, BorderLayout.WEST);
        registerPanel.add(rightPanel, BorderLayout.CENTER);

        return registerPanel;
    }

    public void setUsername(String username) {
        LoginGUI.username = username;
    }

    public static String getUsername() {
        return username;
    }
}