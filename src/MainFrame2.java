/*import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class MainFrame2 extends JFrame {
    public MainFrame2() {
        // Set the title of the window
        setTitle("Login Page");

        // Set the size of the window
        setSize(900, 500);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel with BorderLayout
        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create the left panel with an image
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(173, 216, 230));
        JLabel imageLabel = new JLabel(new ImageIcon("your-image-path.jpg")); // Replace with actual image path
        leftPanel.add(imageLabel);

        // Create the right panel for login components
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255, 255, 255));
        rightPanel.setLayout(null);

        // Create and position components
        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(100, 100, 100, 35);
        JTextField usernameField = new JTextField();
        usernameField.setBounds(200, 100, 200, 35);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 150, 100, 35);
        JPasswordField passwordField = new JPasswordField();
        passwordField.setBounds(200, 150, 200, 35);

        JButton loginButton = new JButton("Login");
        loginButton.setBounds(125, 235, 250, 35);
        loginButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String username = usernameField.getText();
                String password = new String(passwordField.getPassword());

                // Check credentials from users.txt
               /* if (checkCredentials(username, password)) {
                    dispose(); // Close the current window
                    new PaymentGUI().setVisible(true); // Open PaymentGUI window
                

				if {
                    // Show an error message
                    JOptionPane.showMessageDialog(MainFrame2.this, "Invalid username or password", "Login Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JLabel newUserLabel = new JLabel("New user?");
        newUserLabel.setBounds(50, 400, 100, 25);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(130, 400, 100, 25);
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new SignupFrame2();
                dispose();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(320, 400, 100, 35);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close the current window
                new MovieTheaterGUI().setVisible(true); // Open MovieTheaterGUI window
            }
        });

        // Add components to the right panel
        rightPanel.add(usernameLabel);
        rightPanel.add(usernameField);
        rightPanel.add(passwordLabel);
        rightPanel.add(passwordField);
        rightPanel.add(loginButton);
        rightPanel.add(newUserLabel);
        rightPanel.add(signupButton);
        rightPanel.add(backButton);

        // Add panels to the main panel
        mainPanel.add(leftPanel, BorderLayout.WEST);
        mainPanel.add(rightPanel, BorderLayout.CENTER);

        // Set a preferred size for the left panel
        leftPanel.setPreferredSize(new Dimension(450, 600));

        // Add the main panel to the frame
        add(mainPanel);

        // Make the window visible
        setVisible(true);
    }

    private boolean checkCredentials(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] userDetails = line.split(":");
                if (userDetails.length == 5 && userDetails[0].equals(username) && userDetails[4].equals(password)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MainFrame2::new);
    }
}

*/