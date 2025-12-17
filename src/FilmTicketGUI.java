import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FilmTicketGUI extends JFrame {
    private JLabel showDateLabel;
    private JLabel showTimeLabel;
    private JLabel fullNameLabel;
    private JLabel mobileNumberLabel;
    private JLabel seatNumberLabel;

    private String fullName;
    private String mobileNumber;

    public FilmTicketGUI(String fullName, String mobileNumber) {
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;

        // Set the title of the window
        setTitle("Film Ticket Summary");

        // Set the size of the window
        setSize(600, 400);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Create a main panel with BorderLayout and set the background color
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(192, 178, 143)); // Set background color

        // Create title panel
        JLabel titleLabel = new JLabel("Ticket Summary");
        titleLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 20));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        mainPanel.add(titleLabel, BorderLayout.NORTH);

        // Create the panel for ticket information
        JPanel ticketPanel = new JPanel();
        ticketPanel.setLayout(new GridLayout(5, 2, 10, 10));
        ticketPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        ticketPanel.setBackground(new Color(192, 178, 143)); // Set background color

        // Create and add labels for ticket information
        showDateLabel = new JLabel("Show Date: ");
        ticketPanel.add(showDateLabel);

        showTimeLabel = new JLabel("Show Time: ");
        ticketPanel.add(showTimeLabel);

        fullNameLabel = new JLabel("Full Name: " + fullName);
        ticketPanel.add(fullNameLabel);

        mobileNumberLabel = new JLabel("Mobile Number: " + mobileNumber);
        ticketPanel.add(mobileNumberLabel);

        // Generate random seat number
        int seatNumber = (int) (Math.random() * 100) + 1;
        seatNumberLabel = new JLabel("Seat Number: " + seatNumber);
        ticketPanel.add(seatNumberLabel);

        // Create the panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        buttonPanel.setBackground(new Color(192, 178, 143)); // Set background color

        // Create buy ticket button
        JButton buyTicketButton = new JButton("Buy Ticket");
        buyTicketButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your buy ticket handling code here
                JOptionPane.showMessageDialog(FilmTicketGUI.this, "Ticket bought successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        buyTicketButton.setBackground(Color.BLACK); // Set background color to black
        buyTicketButton.setForeground(Color.WHITE); // Set text color to white
        buttonPanel.add(buyTicketButton);

        // Create back button
        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Add your back handling code here
                dispose();
            }
        });
        backButton.setBackground(Color.BLACK); // Set background color to black
        backButton.setForeground(Color.WHITE); // Set text color to white
        buttonPanel.add(backButton);

        // Add panels to the main panel
        mainPanel.add(ticketPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Add the main panel to the frame
        add(mainPanel);

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Simulating a signup process
        String fullName = "user"; // Get this from the signup form
        String mobileNumber = "+880 *********"; // Get this from the signup form

        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FilmTicketGUI(fullName, mobileNumber);
            }
        });
    }
}

