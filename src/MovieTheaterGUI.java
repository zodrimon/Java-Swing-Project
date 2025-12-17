import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MovieTheaterGUI extends JFrame implements ActionListener {

    public MovieTheaterGUI() {
        // Set the title of the window
        setTitle("Movie Theater");
        
        // Set the size of the window
        setSize(790, 472);
        
        // Center the window on the screen
        setLocationRelativeTo(null);
        
        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        // Create a panel with a background image
        ImagePanel backgroundPanel = new ImagePanel();
        backgroundPanel.setLayout(null);
        
        // Create buttons
     //   JButton homeButton = createButton("HOME");
        JButton showTimeButton = createButton("SHOW TIME");
        JButton buyTicketsButton = createButton("BUY TICKETS");
        JButton concessionButton = createButton("CONCESSION");
        JButton contactUsButton = createButton("CONTACT US");
        
        // Set button positions and sizes using setBounds
    //    homeButton.setBounds(60, 140, 250, 35);
        showTimeButton.setBounds(60, 140, 250, 45);
        buyTicketsButton.setBounds(60, 210,  250, 45);
        concessionButton.setBounds(60, 280, 250, 45);
        contactUsButton.setBounds(60, 350, 250, 45);
        
        // Set button colors
        Color buttonColor = new Color(28, 43, 87);
     //   homeButton.setBackground(buttonColor);
        showTimeButton.setBackground(buttonColor);
        buyTicketsButton.setBackground(buttonColor);
        concessionButton.setBackground(buttonColor);
        contactUsButton.setBackground(buttonColor);
        
        // Set text color
        Color textColor = Color.WHITE;
    //    homeButton.setForeground(textColor);
        showTimeButton.setForeground(textColor);
        buyTicketsButton.setForeground(textColor);
        concessionButton.setForeground(textColor);
        contactUsButton.setForeground(textColor);
        
        // Add buttons to the background panel
   //     backgroundPanel.add(homeButton);
        backgroundPanel.add(showTimeButton);
        backgroundPanel.add(buyTicketsButton);
        backgroundPanel.add(concessionButton);
        backgroundPanel.add(contactUsButton);
        
        // Add action listeners to buttons
        showTimeButton.addActionListener(this);
        buyTicketsButton.addActionListener(this);
        concessionButton.addActionListener(this); // Add action listener for concessionButton
        contactUsButton.addActionListener(this); // Add action listener for contactUsButton

        // Add the background panel to the frame
        add(backgroundPanel);
        
        // Make the window not resizable
        setResizable(false);
        
        // Make the window visible
        setVisible(true);
    }
    
    private JButton createButton(String text) {
        JButton button = new JButton(text);
        button.setPreferredSize(new Dimension(150, 50));
        return button;
    }
    
    // Custom JPanel to handle background image
    class ImagePanel extends JPanel {
        private Image img;

        public ImagePanel() {
            // Load the background image
            ImageIcon icon = new ImageIcon("THEATER41.PNG");
            img = icon.getImage();
            Dimension size = new Dimension(icon.getIconWidth(), icon.getIconHeight());
            setPreferredSize(size);
            setMinimumSize(size);
            setMaximumSize(size);
            setSize(size);
            setLayout(null);
        }

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            // Draw the background image
            g.drawImage(img, 0, 0, this);
        }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() instanceof JButton) {
            JButton button = (JButton) e.getSource();
            if (button.getText().equals("SHOW TIME")) {
                int choice = JOptionPane.showConfirmDialog(null, "Are you 18+?", "Confirmation", JOptionPane.YES_NO_CANCEL_OPTION);
                if (choice == JOptionPane.YES_OPTION) {
                    dispose(); // Close current window
                    ShowTimes18Plus showTimes18Plus = new ShowTimes18Plus();
                    showTimes18Plus.setVisible(true);
                } else if (choice == JOptionPane.NO_OPTION) {
                    dispose(); // Close current window
                    ShowTimes showTimes = new ShowTimes();
                    showTimes.setVisible(true);
                } else {
                    // Do nothing or reopen MovieTheaterGUI
                    setVisible(true);
                }
            } else if (button.getText().equals("BUY TICKETS")) {
                dispose(); // Close current window
                ImageGalleryGUI as = new ImageGalleryGUI();
                as.setVisible(true);
            } else if (button.getText().equals("CONCESSION")) {
                dispose(); // Close current window
                ConcessionGUI aZ = new ConcessionGUI();
                aZ.setVisible(true);
            } else if (button.getText().equals("CONTACT US")) {
                dispose(); // Close current window
                ContactUsGUI zZ = new ContactUsGUI();
                zZ.setVisible(true);
            }
        }
    }

    public static void main(String[] args) {
        // Run the GUI in the Event Dispatch Thread
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new MovieTheaterGUI();
            }
        });
    }
}
