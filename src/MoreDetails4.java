import javax.swing.*;
import java.awt.*;

public class MoreDetails4 extends JFrame {

    public MoreDetails4() {
        // Set the title of the window
        setTitle("Movie Theater");

        // Set the size of the window
        setSize(1000, 650);

        // Center the window on the screen
        setLocationRelativeTo(null);

        // Set the default close operation
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Set background color
        Color backgroundColor = new Color(192, 178, 143);

        // Create the main panel
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(null);
        mainPanel.setBackground(backgroundColor);

        // Create image
        JLabel movieImage = createImage("image5.jpg");
        movieImage.setBounds(50, 30, 250, 350);
        mainPanel.add(movieImage);

        // Create text information
        JLabel nameLabel = createTextLabel("Movie Name: Avengers: Endgame");
        JLabel categoryLabel = createTextLabel("Category: Action");
        JLabel genreLabel = createTextLabel("Genre: Sci-Fi, Superhero");
        JLabel launchDateLabel = createTextLabel("Launch Date: April 26, 2019");
        JLabel ratingLabel = createTextLabel("Rating: PG-13");
        JLabel castLabel = createTextLabel("Cast: Robert Downey Jr., Chris Evans, ...");

        // Set text label positions
        nameLabel.setBounds(380, 50, 500, 30);
        categoryLabel.setBounds(380, 90, 500, 30);
        genreLabel.setBounds(380, 130, 500, 30);
        launchDateLabel.setBounds(380, 170, 500, 30);
        ratingLabel.setBounds(380, 210, 500, 30);
        castLabel.setBounds(380, 250, 500, 30);

        mainPanel.add(nameLabel);
        mainPanel.add(categoryLabel);
        mainPanel.add(genreLabel);
        mainPanel.add(launchDateLabel);
        mainPanel.add(ratingLabel);
        mainPanel.add(castLabel);

        // Create time stamps
        JLabel time1Label = createTextLabel("10 AM - 12 PM");
        JLabel time2Label = createTextLabel("02 PM - 04 PM");
        JLabel time3Label = createTextLabel("07 PM - 09 PM");

        // Set time label positions
        int timeY = 425;
        int timeWidth = 200;
        int timeX = 50;
        int timeSpacing = 150;

        time1Label.setBounds(timeX + 20, timeY, timeWidth, 30);
        time2Label.setBounds(timeX + 20 + timeWidth + timeSpacing, timeY, timeWidth, 30);
        time3Label.setBounds(timeX + 20 + 2 * (timeWidth + timeSpacing), timeY, timeWidth, 30);

        mainPanel.add(time1Label);
        mainPanel.add(time2Label);
        mainPanel.add(time3Label);

        // Create "Get Ticket" buttons
        JButton getTicketButton1 = createButton("Get Ticket");
        JButton getTicketButton2 = createButton("Get Ticket");
        JButton getTicketButton3 = createButton("Get Ticket");

        // Set button positions
        int buttonY = 470;
        int buttonWidth = 150;
        int buttonSpacing = 80;

        getTicketButton1.setBounds(timeX + 20, buttonY, buttonWidth, 30);
        getTicketButton2.setBounds(timeX + 20 + timeWidth + timeSpacing, buttonY, buttonWidth, 30);
        getTicketButton3.setBounds(timeX + 20 + 2 * (timeWidth + timeSpacing), buttonY, buttonWidth, 30);

        // Set button colors
        Color buttonColor = new Color(41, 1, 51);
        getTicketButton1.setBackground(buttonColor);
        getTicketButton2.setBackground(buttonColor);
        getTicketButton3.setBackground(buttonColor);

        // Set text color for the buttons
        Color textColor = Color.WHITE;
        getTicketButton1.setForeground(textColor);
        getTicketButton2.setForeground(textColor);
        getTicketButton3.setForeground(textColor);

        getTicketButton1.addActionListener(e -> navigateToLogin());
        getTicketButton2.addActionListener(e -> navigateToLogin());
        getTicketButton3.addActionListener(e -> navigateToLogin());

        mainPanel.add(getTicketButton1);
        mainPanel.add(getTicketButton2);
        mainPanel.add(getTicketButton3);

        // Create back button panel
        JPanel backButtonPanel = new JPanel();
        backButtonPanel.setLayout(new FlowLayout(FlowLayout.RIGHT));
        backButtonPanel.setBounds(0, 550, 850, 50);
        backButtonPanel.setBackground(backgroundColor); // Set background color

        JButton backButton = createButton("Back");
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.setPreferredSize(new Dimension(100, 40));
        backButton.addActionListener(e -> {
            dispose();
            new ShowTimes18Plus().setVisible(true);
        });

        backButtonPanel.add(backButton);
        mainPanel.add(backButtonPanel);

        add(mainPanel);
        setResizable(false);
        setVisible(true);
    }

    private JLabel createImage(String imageName) {
        ImageIcon icon = new ImageIcon(imageName);
        return new JLabel(icon);
    }

    private JLabel createTextLabel(String text) {
        return new JLabel(text);
    }

    private JButton createButton(String text) {
        return new JButton(text);
    }

    private void navigateToLogin() {
        dispose();
        new MainFrame().setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(MoreDetails4::new);
    }
}
