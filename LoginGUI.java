import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.border.Border;


public class LoginGUI extends JFrame {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JPanel cardPanel;
    private CardLayout cardLayout;

    public LoginGUI() {
        setTitle("Login Form");
        setSize(800, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        JPanel loginPanel = createLoginPanel();
        WelcomePanel welcomePanel = new WelcomePanel();  // Using the WelcomePanel class

        cardPanel.add(loginPanel, "login");
        cardPanel.add(welcomePanel, "welcome");

        getContentPane().setLayout(new BorderLayout());

        add(cardPanel, BorderLayout.CENTER);

        setVisible(true);

        // Center the frame on the screen
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (screenSize.width - getWidth()) / 2;
        int y = (screenSize.height - getHeight()) / 2;
        setLocation(x, y);
    }

    private JPanel createLoginPanel() {
        JPanel loginPanel = new JPanel(new BorderLayout());

        // Left side panel for username and password
        JPanel leftPanel = new JPanel(new GridBagLayout());
        leftPanel.setBackground(Color.WHITE);

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 7, 7, 7);

        Font sansSerifFont = new Font("SansSerif", Font.PLAIN, 14);
        Font userlgFont = new Font("SansSerif", Font.BOLD, 25);
        
        JLabel userlgLabel = new JLabel("User Login");
        JLabel usernameLabel = new JLabel("Username:");
        JLabel passwordLabel = new JLabel("Password:");
        usernameField = new JTextField(20);
        passwordField = new JPasswordField(20);
        JButton loginButton = new JButton("Login");
        
        userlgLabel.setFont(userlgFont);
        userlgLabel.setForeground(new Color(144, 238, 144));
        usernameLabel.setFont(sansSerifFont);
        passwordLabel.setFont(sansSerifFont);
        usernameField.setFont(sansSerifFont);
        passwordField.setFont(sansSerifFont);
        loginButton.setFont(sansSerifFont);
        
        loginButton.setBackground(new Color(144, 238, 144)); // Set the background color
        loginButton.setForeground(Color.WHITE); // Set the text color
        loginButton.setFocusPainted(true); // Remove the focus border
        loginButton.setPreferredSize(new Dimension(140, 40));

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
        leftPanel.add(loginButton, gbc);

        loginButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                char[] passwordChars = passwordField.getPassword();
                String password = new String(passwordChars);

                if (username.equals("admin") && password.equals("pass")) {
                    cardLayout.show(cardPanel, "welcome");
                } else {
                    JOptionPane.showMessageDialog(LoginGUI.this, "Invalid username or password", "Error", JOptionPane.ERROR_MESSAGE);
                }
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
        loginPanel.add(leftPanel, BorderLayout.WEST);
        loginPanel.add(rightPanel, BorderLayout.CENTER);

        return loginPanel;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(LoginGUI::new);
    }
}
