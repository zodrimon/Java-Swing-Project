import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactUsGUI extends JFrame implements ActionListener {
    JButton backButton;
    JButton adminLoginButton;

    public ContactUsGUI() {
        super("Contact Us");
        setSize(650, 420); // Decreased the height
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        getContentPane().setBackground(new Color(192, 178, 143)); // Set background color for the remaining components

        // Left panel for contact information
        JPanel contactInfoPanel = new JPanel();
        contactInfoPanel.setLayout(new BoxLayout(contactInfoPanel, BoxLayout.Y_AXIS));
        contactInfoPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        contactInfoPanel.setBackground(new Color(192, 178, 143)); // Set background color

        JLabel contactLabel = new JLabel("Contact Information:");
        contactLabel.setFont(new Font("Arial", Font.BOLD, 18));
        contactLabel.setForeground(new Color(192, 178, 138)); // Set text color

        JLabel addressLabel1 = new JLabel("Address: 123 Movie St, Filmtown, CA 94016");
        JLabel phoneLabel1 = new JLabel("Phone: (123) 456-7890");
        JLabel emailLabel1 = new JLabel("Email: info@movietheater.com");

        JLabel addressLabel2 = new JLabel("Address: 456 Film Blvd, Cinemaville, NY 10001");
        JLabel phoneLabel2 = new JLabel("Phone: (456) 789-0123");
        JLabel emailLabel2 = new JLabel("Email: support@cinemaville.com");

        JLabel addressLabel3 = new JLabel("Address: 789 Cinema Ave, Movietown, TX 77001");
        JLabel phoneLabel3 = new JLabel("Phone: (789) 012-3456");
        JLabel emailLabel3 = new JLabel("Email: contact@movietown.com");

        contactInfoPanel.add(contactLabel);
        contactInfoPanel.add(Box.createVerticalStrut(20)); // Add space between elements
        contactInfoPanel.add(addressLabel1);
        contactInfoPanel.add(phoneLabel1);
        contactInfoPanel.add(emailLabel1);
        contactInfoPanel.add(Box.createVerticalStrut(20)); // Add space between addresses
        contactInfoPanel.add(addressLabel2);
        contactInfoPanel.add(phoneLabel2);
        contactInfoPanel.add(emailLabel2);
        contactInfoPanel.add(Box.createVerticalStrut(20)); // Add space between addresses
        contactInfoPanel.add(addressLabel3);
        contactInfoPanel.add(phoneLabel3);
        contactInfoPanel.add(emailLabel3);

        // Add Admin Login button
        adminLoginButton = new JButton("Admin Login");
        adminLoginButton.addActionListener(this);
        adminLoginButton.setBackground(new Color(41, 1, 51)); // Set button background color
        adminLoginButton.setForeground(Color.WHITE); // Set button text color
        adminLoginButton.setAlignmentX(Component.CENTER_ALIGNMENT);

        // Create a panel to hold the adminLoginButton
        JPanel adminButtonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER)); // Adjusted layout
        adminButtonPanel.setBackground(new Color(192, 178, 143)); // Set background color
        adminButtonPanel.add(adminLoginButton); // Added button to panel

        contactInfoPanel.add(adminButtonPanel); // Added adminButtonPanel to contactInfoPanel
        contactInfoPanel.add(Box.createVerticalStrut(30)); // Add space before button

        // Right panel for images
        JPanel imagePanel = new JPanel();
        imagePanel.setLayout(new BoxLayout(imagePanel, BoxLayout.Y_AXIS));
        imagePanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        imagePanel.setBackground(new Color(192, 178, 143)); // Set background color

        JLabel mapImage1 = new JLabel(new ImageIcon("Image900.jpg"));
        imagePanel.add(mapImage1);

        // Bottom panel for buttons
        JPanel bottomPanel = new JPanel(new FlowLayout(FlowLayout.RIGHT));
        bottomPanel.setBackground(new Color(192, 178, 143)); // Set background color

        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.addActionListener(this);
        backButton.setBackground(Color.BLACK); // Set button background color
        backButton.setForeground(Color.WHITE); // Set button text color
        bottomPanel.add(backButton);

        // Add panels to the frame
        add(contactInfoPanel, BorderLayout.WEST);
        add(imagePanel, BorderLayout.CENTER);
        add(bottomPanel, BorderLayout.SOUTH);

        setResizable(false);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == backButton) {
            dispose(); // Close current window
            new MovieTheaterGUI().setVisible(true); // Return to MovieTheaterGUI
        } else if (e.getSource() == adminLoginButton) {
            dispose(); // Close current window
            new LoginGUI().setVisible(true); // Open LoginGUI
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ContactUsGUI();
        });
    }
}

