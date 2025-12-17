import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ImageGalleryGUI extends JFrame {

    public ImageGalleryGUI() {
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

        // Set the background color
        getContentPane().setBackground(new Color(192, 178, 143));

        // Create an array of image file names
        String[] imageFiles = {"image6.jpg", "image5.jpg", "image4.jpg", "image3.jpg", "image2.jpg", "image1.jpg"};
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
            int finalI = i;

            // Add action listener based on image number
            if (i < 3) {
                imageLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        int option = JOptionPane.showConfirmDialog(ImageGalleryGUI.this, "Are you 18+?", "Age Confirmation", JOptionPane.YES_NO_OPTION);
                        if (option == JOptionPane.YES_OPTION) {
                            switch (finalI + 1) { // Index starts from 1
                                case 1:
								dispose();
                                    new MoreDetails5().setVisible(true);
                                    break;
                                case 2:
								dispose();
                                    new MoreDetails4().setVisible(true);
                                    break;
                                case 3:
								dispose();
                                    new MoreDetails4().setVisible(true);
                                    break;
                            }
                        }
                    }
                });
            } else {
                imageLabel.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        super.mouseClicked(e);
                        switch (finalI + 1) { // Index starts from 1
                            case 4:
							dispose();
                                new MoreDetails2().setVisible(true);
                                break;
                            case 5:
							dispose();
                                new MoreDetails1().setVisible(true);
                                break;
                            case 6:
							dispose(); 
                                new MoreDetails().setVisible(true);
                                break;
                        }
                    }
                });
            }

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
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                // Navigate to the previous frame (adjust accordingly)
                new MovieTheaterGUI().setVisible(true);
            }
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
        SwingUtilities.invokeLater(ImageGalleryGUI::new);
    }
}
