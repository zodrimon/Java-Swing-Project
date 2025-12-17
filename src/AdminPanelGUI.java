import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;

public class AdminPanelGUI extends JFrame implements ActionListener {
    private JTextField addUserField, removeUserField, tempNameField;
    private JButton addButton, removeButton, logoutButton;

    public AdminPanelGUI() {
        super("Admin Panel");

        setLayout(null);
        setSize(700, 600);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(192, 178, 138)); // Set background color

        JLabel adminInfoLabel = new JLabel("Admin Info:");
        adminInfoLabel.setFont(new Font("Serif", Font.BOLD, 18));
        adminInfoLabel.setBounds(50, 20, 200, 30);

        JTextArea adminInfoArea = new JTextArea();
        adminInfoArea.setEditable(false);
        adminInfoArea.setText(getAdminInfo());
        JScrollPane scrollPane = new JScrollPane(adminInfoArea);
        scrollPane.setBounds(50, 60, 300, 200);

        JLabel addUserLabel = new JLabel("Add Staff:");
        addUserLabel.setBounds(400, 60, 100, 30);
        addUserField = new JTextField();
        addUserField.setBounds(500, 60, 150, 30);
        addButton = new JButton("Add");
        addButton.setBounds(500, 100, 150, 30);
        addButton.setBackground(Color.BLACK); // Set button background color
        addButton.setForeground(Color.WHITE); // Set button text color

        JLabel removeUserLabel = new JLabel("Remove Staff:");
        removeUserLabel.setBounds(400, 160, 100, 30);
        removeUserField = new JTextField();
        removeUserField.setBounds(500, 160, 150, 30);
        removeButton = new JButton("Remove");
        removeButton.setBounds(500, 200, 150, 30);
        removeButton.setBackground(Color.BLACK); // Set button background color
        removeButton.setForeground(Color.WHITE); // Set button text color

        JLabel tempNameLabel = new JLabel("Temporary Name:");
        tempNameLabel.setBounds(400, 260, 150, 30);
        tempNameField = new JTextField();
        tempNameField.setBounds(500, 260, 150, 30);

        logoutButton = new JButton("Logout");
        logoutButton.setBounds(500, 500, 150, 30);
        logoutButton.setBackground(Color.BLACK); // Set button background color
        logoutButton.setForeground(Color.WHITE); // Set button text color

        addButton.addActionListener(this);
        removeButton.addActionListener(this);
        logoutButton.addActionListener(this);

        add(adminInfoLabel);
        add(scrollPane);
        add(addUserLabel);
        add(addUserField);
        add(addButton);
        add(removeUserLabel);
        add(removeUserField);
        add(removeButton);
        add(tempNameLabel);
        add(tempNameField);
        add(logoutButton);

        setVisible(true);
    }

    private String getAdminInfo() {
        StringBuilder adminInfo = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader("admin_users.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                adminInfo.append("Name: ").append(parts[0]).append("\n");
                adminInfo.append("Contact: ").append(parts[1]).append("\n\n");
            }
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(this, "Error reading file.");
        }
        return adminInfo.toString();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == addButton) {
            String newUser = addUserField.getText();
            String tempName = tempNameField.getText(); // Get temporary name
            addUser(newUser, tempName); // Pass temporary name to addUser method
        } else if (e.getSource() == removeButton) {
            String removeUser = removeUserField.getText();
            removeUser(removeUser);
        } else if (e.getSource() == logoutButton) {
            dispose();
            new LoginGUI().setVisible(true);
        }
    }

    private void addUser(String username, String tempName) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("staff_users.txt", true))) {
            writer.write(username + "," + tempName + ",password"); // Include temporary name in the data
            writer.newLine();
            JOptionPane.showMessageDialog(this, "Staff added successfully!");
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(this, "Error writing to file.");
        }
    }

    private void removeUser(String username) {
        File inputFile = new File("staff_users.txt");
        File tempFile = new File("staff_users_temp.txt");

        try (BufferedReader reader = new BufferedReader(new FileReader(inputFile));
             BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile))) {

            String line;
            while ((line = reader.readLine()) != null) {
                String[] parts = line.split(",");
                if (!parts[0].equals(username)) {
                    writer.write(line);
                    writer.newLine();
                }
            }

            if (!inputFile.delete()) {
                JOptionPane.showMessageDialog(this, "Error deleting original file.");
                return;
            }
            if (!tempFile.renameTo(inputFile)) {
                JOptionPane.showMessageDialog(this, "Error renaming temp file.");
            } else {
                JOptionPane.showMessageDialog(this, "Staff removed successfully!");
            }
        } catch (IOException ioException) {
            JOptionPane.showMessageDialog(this, "Error processing file.");
        }
    }

    public static void main(String[] args) {
        new AdminPanelGUI();
    }
}
