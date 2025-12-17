import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class SignupFrame extends JFrame {
    private JTextField nameField;
    private JTextField ageField;
    private JTextField emailField;
    private JTextField contactNumberField;
    private JTextField usernameField;  // Added
    private JPasswordField passwordField;
    private JPasswordField confirmPasswordField;

    public SignupFrame() {
        setTitle("Sign Up");
        setSize(1000, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());

        // Create the left panel with an image
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(255, 255, 255));
        JLabel imageLabel = new JLabel(new ImageIcon("signup11.jpg")); // Replace with actual image path
        leftPanel.add(imageLabel);

        // Create the right panel for sign-up components
        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(192, 178, 143)); // Set background color
        rightPanel.setLayout(null);

        // Create and position components
        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 50, 100, 25);
        nameField = new JTextField();
        nameField.setBounds(250, 50, 200, 25);

        JLabel ageLabel = new JLabel("Age:");
        ageLabel.setBounds(100, 100, 100, 25);
        ageField = new JTextField();
        ageField.setBounds(250, 100, 200, 25);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, 150, 100, 25);
        emailField = new JTextField();
        emailField.setBounds(250, 150, 200, 25);

        JLabel contactNumberLabel = new JLabel("Contact Number:");
        contactNumberLabel.setBounds(100, 200, 150, 25);
        contactNumberField = new JTextField();
        contactNumberField.setBounds(250, 200, 200, 25);

        JLabel usernameLabel = new JLabel("Username:");  // Added
        usernameLabel.setBounds(100, 250, 100, 25);
        usernameField = new JTextField();
        usernameField.setBounds(250, 250, 200, 25);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 300, 100, 25);
        passwordField = new JPasswordField();
        passwordField.setBounds(250, 300, 200, 25);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(100, 350, 150, 25);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(250, 350, 200, 25);

        JButton signupButton = new JButton("Sign Up");
        signupButton.setBounds(210, 400, 200, 35);
        signupButton.setBackground(new Color(41, 1, 51)); // Set button color
        signupButton.setForeground(Color.WHITE); // Set text color
        signupButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                handleSignup();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.setBounds(360, 480, 100, 35);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                new MainFrame();
                dispose();
            }
        });

        // Add components to the right panel
        rightPanel.add(nameLabel);
        rightPanel.add(nameField);
        rightPanel.add(ageLabel);
        rightPanel.add(ageField);
        rightPanel.add(emailLabel);
        rightPanel.add(emailField);
        rightPanel.add(contactNumberLabel);
        rightPanel.add(contactNumberField);
        rightPanel.add(usernameLabel);  // Added
        rightPanel.add(usernameField);  // Added
        rightPanel.add(passwordLabel);
        rightPanel.add(passwordField);
        rightPanel.add(confirmPasswordLabel);
        rightPanel.add(confirmPasswordField);
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

    private void handleSignup() {
        String name = nameField.getText();
        String age = ageField.getText();
        String email = emailField.getText();
        String contactNumber = contactNumberField.getText();
        String username = usernameField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (name.isEmpty() || age.isEmpty() || email.isEmpty() || contactNumber.isEmpty() || username.isEmpty() || password.isEmpty() || confirmPassword.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill in all fields", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Passwords do not match", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        String hashedPassword = hashPassword(password);
        if (hashedPassword == null) {
            JOptionPane.showMessageDialog(this, "Error hashing password", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("users.txt", true))) {
            writer.write(username + ":" + hashedPassword + ":" + name + ":" + age + ":" + email + ":" + contactNumber);
            writer.newLine();
            JOptionPane.showMessageDialog(this, "User registered successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            dispose();
            new MainFrame().setVisible(true); // Automatically go to the login page after signup
        } catch (IOException e) {
            JOptionPane.showMessageDialog(this, "An error occurred while saving user data", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private String hashPassword(String password) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(password.getBytes());
            StringBuilder hexString = new StringBuilder();
            for (byte b : hash) {
                String hex = Integer.toHexString(0xff & b);
                if (hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(SignupFrame::new);
    }
}
