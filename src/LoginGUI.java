import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class LoginGUI extends JFrame implements ActionListener {
    private JTextField usernameField;
    private JPasswordField passwordField;
    private JButton loginButton, backButton, signUpButton;

    public LoginGUI() {
        super("Login");

        setLayout(null);
        setSize(700, 500);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(192, 178, 143)); // Set background color

        JLabel titleLabel = new JLabel("Admin Login", JLabel.CENTER);
        titleLabel.setFont(new Font("Serif", Font.BOLD, 24));
        titleLabel.setBounds(200, 20, 300, 50);

        JLabel usernameLabel = new JLabel("Username:");
        usernameLabel.setBounds(100, 100, 200, 30);
        usernameField = new JTextField();
        usernameField.setBounds(300, 100, 300, 30);

        JLabel passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(100, 150, 200, 30);
        passwordField = new JPasswordField();
        passwordField.setBounds(300, 150, 300, 30);

        loginButton = new JButton("Login");
        loginButton.setBounds(350, 250, 100, 30);
        loginButton.setBackground(new Color(41, 1, 51)); // Set background color for login button
        loginButton.setForeground(Color.WHITE); // Set text color to white
        signUpButton = new JButton("Sign Up");
        signUpButton.setBounds(100, 400, 100, 30);
        signUpButton.setBackground(new Color(41, 1, 51)); // Set background color for sign up button
        signUpButton.setForeground(Color.WHITE); // Set text color to white
        backButton = new JButton("Back");
        backButton.setBounds(500, 400, 100, 30);
        backButton.setBackground(new Color(41, 1, 51)); // Set background color for back button
        backButton.setForeground(Color.WHITE); // Set text color to white

        loginButton.addActionListener(this);
        signUpButton.addActionListener(this);
        backButton.addActionListener(this);

        add(titleLabel);
        add(usernameLabel);
        add(usernameField);
        add(passwordLabel);
        add(passwordField);
        add(loginButton);
        add(signUpButton);
        add(backButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String username = usernameField.getText();
            String password = new String(passwordField.getPassword());

            if (authenticate(username, password)) {
                dispose();
                AdminPanelGUI adminPanelGUI = new AdminPanelGUI();
                adminPanelGUI.setVisible(true);
            } else {
                JOptionPane.showMessageDialog(this, "Invalid username or password.");
            }
        } else if (e.getSource() == backButton) {
            dispose();
            MovieTheaterGUI movieTheaterGUI = new MovieTheaterGUI();
            movieTheaterGUI.setVisible(true);
        } else if (e.getSource() == signUpButton) {
            dispose();
            SignUpGUI signUpGUI = new SignUpGUI();
            signUpGUI.setVisible(true);
        }
    }

    private boolean authenticate(String username, String password) {
        try (BufferedReader reader = new BufferedReader(new FileReader("admin_users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (parts.length >= 4 && parts[0].equals(username) && parts[3].equals(password)) {
                    return true;
                }
            }
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(this, "Error reading file.");
        }
        return false;
    }

    public static void main(String[] args) {
        new LoginGUI();
    }
}
