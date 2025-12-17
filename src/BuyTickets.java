import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class BuyTickets extends JFrame {

    public BuyTickets() {
        // Set the title of the window
        setTitle("Image Gallery");

        // Set the size of the window
        setSize(820, 850);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set the layout to null for absolute positioning
        setLayout(null);

        // Create an array of image file names
        String[] imageFiles = {"image1.jpeg", "image2.jpeg", "image3.jpeg", "image4.jpeg", "image5.jpeg", "image6.jpeg"};
        String[] descriptions = {"Description 1", "Description 2", "Description 3", "Description 4", "Description 5", "Description 6"};

        // Load and add images and descriptions
        for (int i = 0; i < 6; i++) {
            // Calculate the x and y positions
            int x = (i % 3) * 260 + 10;
            int y = (i / 3) * 330 + 10;

            // Create a label for the image
            ImageIcon imageIcon = new ImageIcon(imageFiles[i]);
            Image image = imageIcon.getImage().getScaledInstance(180, 280, Image.SCALE_SMOOTH);
            JLabel imageLabel = new JLabel(new ImageIcon(image));
            imageLabel.setBounds(x, y, 250, 350);

            // Add mouse listener to the image label
            imageLabel.addMouseListener(new MouseAdapter() {
                public void mouseClicked(MouseEvent e) {
                    new MainFrame().setVisible(true);
                    dispose();
                }
            });

            // Create a label for the description
            JLabel descriptionLabel = new JLabel(descriptions[i], SwingConstants.CENTER);
            descriptionLabel.setBounds(x, y + 330, 250, 30);

            // Add the image and description to the frame
            add(imageLabel);
            add(descriptionLabel);
        }

        // Create the back button
        JButton backButton = new JButton("Back");
        backButton.setBounds(650, 730, 130, 35);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);

        // Add mouse listener to the back button
        backButton.addActionListener(e -> {
            // Add your back handling code here if necessary
            new MainFrame().setVisible(true);
            dispose();
        });

        // Add the back button to the frame
        add(backButton);

        // Make the window not resizable
        setResizable(false);

        // Make the window visible
        setVisible(true);
    }

    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(BuyTickets::new);
    }
}

