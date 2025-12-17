import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class SignUpGUI extends JFrame implements ActionListener {
    private JTextField nameField, contactField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton signUpButton, backButton;

    public SignUpGUI() {
        super("Sign Up");

        setLayout(null);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(192, 178, 143)); // Set background color

        JLabel titleLabel = new JLabel("Sign Up", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(250, 20, 200, 50);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(100, 100, 200, 30);
        nameField = new JTextField();
        nameField.setBounds(300, 100, 300, 30);

        JLabel contactLabel = new JLabel("Contact:");
        contactLabel.setBounds(100, 150, 200, 30);
        contactField = new JTextField();
        contactField.setBounds(300, 150, 300, 30);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(100, 200, 200, 30);
        emailField = new JTextField();
        emailField.setBounds(300, 200, 300, 30);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 250, 200, 30);
        passwordField = new JPasswordField();
        passwordField.setBounds(300, 250, 300, 30);

        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordLabel.setBounds(100, 300, 200, 30);
        confirmPasswordField = new JPasswordField();
        confirmPasswordField.setBounds(300, 300, 300, 30);

        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(200, 350, 100, 30);
        signUpButton.setBackground(new Color(41, 1, 51)); // Set background color for sign up button
        signUpButton.setForeground(Color.WHITE); // Set text color to white
        backButton = new JButton("Back");
        backButton.setBounds(400, 350, 100, 30);
        backButton.setBackground(new Color(41, 1, 51)); // Set background color for back button
        backButton.setForeground(Color.WHITE); // Set text color to white

        signUpButton.addActionListener(this);
        backButton.addActionListener(this);

        add(titleLabel);
        add(nameLabel);
        add(nameField);
        add(contactLabel);
        add(contactField);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(signUpButton);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == signUpButton) {
            String name = nameField.getText();
            String contact = contactField.getText();
            String email = emailField.getText();
            String password = new String(passwordField.getPassword());
            String confirmPassword = new String(confirmPasswordField.getPassword());

            if (password.equals(confirmPassword)) {
                // Save user information to file
                saveUserToFile(name, contact, email, password);
                JOptionPane.showMessageDialog(this, "User registered successfully.");
                dispose();
                new LoginGUI().setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Passwords do not match. Please try again.");
            }
        } else if (e.getSource() == backButton) {
            dispose();
            new LoginGUI().setVisible(true);
        }
    }

    private void saveUserToFile(String name, String contact, String email, String password) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("admin_users.txt", true))) {
            writer.write(name + "," + contact + "," + email + "," + password);
            writer.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignUpGUI();
    }
}
