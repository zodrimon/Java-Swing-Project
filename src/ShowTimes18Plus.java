import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ShowTimes18Plus extends JFrame {

    public ShowTimes18Plus() {
        // Set the title of the window
        setTitle("Movie Theater");
        
        // Set the size of the window
        setSize(1100, 650);
        
        // Center the window on the screen
        setLocationRelativeTo(null);
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        
        // Set background color to RGB (192, 178, 143)
        mainPanel.setBackground(new Color(192, 178, 143));
        
        // Create images
        JLabel image1 = createImage("image4.jpg");
        JLabel image2 = createImage("image5.jpg");
        JLabel image3 = createImage("image6.jpg");
        
        // Set image positions and sizes using setBounds
        image1.setBounds(50, 50, 250, 350);
        image2.setBounds(390, 50, 250, 350);
        image3.setBounds(780, 50, 250, 350);
        
        // Add images to the main panel
        mainPanel.add(image1);
        mainPanel.add(image2);
        mainPanel.add(image3);
        
        // Create text labels
        JLabel textLabel11 = createTextLabel("Black Panther ");
        JLabel textLabel22 = createTextLabel("IMDB : 7.00");
        JLabel textLabel33 = createTextLabel("Inception");
        
        // Create text labels
        JLabel textLabel44 = createTextLabel("IMDB : 8.00");
        JLabel textLabel55 = createTextLabel("Avengers");
        JLabel textLabel66 = createTextLabel("IMDB : 8.5");
        
        // Set text label positions and sizes using setBounds
        textLabel11.setBounds(50, 405, 400, 50);
        textLabel22.setBounds(50, 435, 400, 50);
        textLabel33.setBounds(450, 405, 400, 50);
        textLabel44.setBounds(450, 435, 400, 50);
        textLabel55.setBounds(850, 405, 400, 50);
        textLabel66.setBounds(850, 435, 400, 50);
        
        // Add text labels to the main panel
        mainPanel.add(textLabel11);
        mainPanel.add(textLabel22);
        mainPanel.add(textLabel33);
        mainPanel.add(textLabel44);
        mainPanel.add(textLabel55);
        mainPanel.add(textLabel66);
        
        // Create "More Details" buttons
        JButton moreDetailsButton1 = createButton("More Details");
        JButton moreDetailsButton2 = createButton("More Details");
        JButton moreDetailsButton3 = createButton("More Details");
        
        // Set button positions and sizes using setBounds
        moreDetailsButton1.setBounds(50, 500, 150, 50);
        moreDetailsButton2.setBounds(450, 500, 150, 50);
        moreDetailsButton3.setBounds(850, 500, 150, 50);
        
        // Set button background color to RGB (41, 1, 51) and text color to white
        moreDetailsButton1.setBackground(new Color(41, 1, 51));
        moreDetailsButton1.setForeground(Color.WHITE);
        moreDetailsButton2.setBackground(new Color(41, 1, 51));
        moreDetailsButton2.setForeground(Color.WHITE);
        moreDetailsButton3.setBackground(new Color(41, 1, 51));
        moreDetailsButton3.setForeground(Color.WHITE);
        
        // Add buttons to the main panel
        mainPanel.add(moreDetailsButton1);
        mainPanel.add(moreDetailsButton2);
        mainPanel.add(moreDetailsButton3);
        
        // Add action listeners to "More Details" buttons
        moreDetailsButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                new MoreDetails3().setVisible(true); // Open MoreDetails page
            }
        });
        
        moreDetailsButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                new MoreDetails4().setVisible(true); // Open MoreDetails page
            }
        });
        
        moreDetailsButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                new MoreDetails5().setVisible(true); // Open MoreDetails page
            }
        });
        
        // Create back button
        JButton backButton = createButton("Back");
        backButton.setBounds(920, 572, 125, 35);
        backButton.setBackground(Color.BLACK); // Set background color to black
        backButton.setForeground(Color.WHITE); // Set text color to white
        mainPanel.add(backButton);
        
        // Add action listener to back button
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Close current window
                new MovieTheaterGUI().setVisible(true); // Show the main menu
            }
        });
        
        // Add the main panel to the frame
        add(mainPanel);
        
        // Make the window not resizable
        setResizable(false);
        
        // Make the window visible
        setVisible(true);
    }
    
    private JLabel createImage(String imageName) {
        // Load the image
        ImageIcon icon = new ImageIcon(imageName);
        JLabel imageLabel = new JLabel(icon);
        return imageLabel;
    }
    
    private JLabel createTextLabel(String text) {
        JLabel label = new JLabel(text);
        label.setPreferredSize(new Dimension(400, 50));
        return label;
    }
    
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        return button;
    }

    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new ShowTimes18Plus();
            }
        });
    }
}
