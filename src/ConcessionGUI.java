import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class ConcessionGUI extends JFrame implements ActionListener {
    JPanel panel;
    JButton popcornButton, sodaButton, hotDogButton, nachosButton, candyButton, iceCreamButton, pizzaButton, burgerButton;
    JLabel popcornLabel, sodaLabel, hotDogLabel, nachosLabel, candyLabel, iceCreamLabel, pizzaLabel, burgerLabel;
    JButton feedbackButton, backButton;

    public ConcessionGUI() {
        super("Concession Stand");
        setSize(865, 700);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Initialize panel
        panel = new JPanel();
        panel.setLayout(null); // Use absolute layout
        panel.setPreferredSize(new Dimension(865, 800)); // Set preferred size
        panel.setBackground(new Color(192, 178, 143)); // Set background color
        add(panel);

        // Initialize popcorn button and label
        popcornButton = new JButton();
        popcornButton.setIcon(new ImageIcon("food1.jpg"));
        popcornButton.setBounds(50, 50, 150, 150);
        popcornButton.addActionListener(this);
        panel.add(popcornButton);

        popcornLabel = new JLabel("Popcorn - $5.00");
        popcornLabel.setBounds(50, 220, 150, 30);
        panel.add(popcornLabel);

        // Initialize soda button and label
        sodaButton = new JButton();
        sodaButton.setIcon(new ImageIcon("food2.jpg"));
        sodaButton.setBounds(250, 50, 150, 150);
        sodaButton.addActionListener(this);
        panel.add(sodaButton);

        sodaLabel = new JLabel("Soda - $3.00");
        sodaLabel.setBounds(250, 220, 150, 30);
        panel.add(sodaLabel);

        // Initialize hot dog button and label
        hotDogButton = new JButton();
        hotDogButton.setIcon(new ImageIcon("food3.jpg"));
        hotDogButton.setBounds(450, 50, 150, 150);
        hotDogButton.addActionListener(this);
        panel.add(hotDogButton);

        hotDogLabel = new JLabel("Hot Dog - $4.50");
        hotDogLabel.setBounds(450, 220, 150, 30);
        panel.add(hotDogLabel);

        // Initialize nachos button and label
        nachosButton = new JButton();
        nachosButton.setIcon(new ImageIcon("food4.jpg"));
        nachosButton.setBounds(650, 50, 150, 150);
        nachosButton.addActionListener(this);
        panel.add(nachosButton);

        nachosLabel = new JLabel("Nachos - $6.00");
        nachosLabel.setBounds(650, 220, 150, 30);
        panel.add(nachosLabel);

        // Additional row

        // Initialize candy button and label
        candyButton = new JButton();
        candyButton.setIcon(new ImageIcon("food5.jpg"));
        candyButton.setBounds(50, 300, 150, 150);
        candyButton.addActionListener(this);
        panel.add(candyButton);

        candyLabel = new JLabel("Candy - $2.50");
        candyLabel.setBounds(50, 470, 150, 30);
        panel.add(candyLabel);

        // Initialize ice cream button and label
        iceCreamButton = new JButton();
        iceCreamButton.setIcon(new ImageIcon("food6.jpg"));
        iceCreamButton.setBounds(250, 300, 150, 150);
        iceCreamButton.addActionListener(this);
        panel.add(iceCreamButton);

        iceCreamLabel = new JLabel("Ice Cream - $4.00");
        iceCreamLabel.setBounds(250, 470, 150, 30);
        panel.add(iceCreamLabel);

        // Initialize pizza button and label
        pizzaButton = new JButton();
        pizzaButton.setIcon(new ImageIcon("food7.jpg"));
        pizzaButton.setBounds(450, 300, 150, 150);
        pizzaButton.addActionListener(this);
        panel.add(pizzaButton);

        pizzaLabel = new JLabel("Pizza - $8.00");
        pizzaLabel.setBounds(450, 470, 150, 30);
        panel.add(pizzaLabel);

        // Initialize burger button and label
        burgerButton = new JButton();
        burgerButton.setIcon(new ImageIcon("food8.jpg"));
        burgerButton.setBounds(650, 300, 150, 150);
        burgerButton.addActionListener(this);
        panel.add(burgerButton);

        burgerLabel = new JLabel("Burger - $6.50");
        burgerLabel.setBounds(650, 470, 150, 30);
        panel.add(burgerLabel);

        // Additional row buttons and labels

        // Initialize feedback button
        feedbackButton = new JButton("Feedback");
        feedbackButton.setFont(new Font("Arial", Font.PLAIN, 14));
        feedbackButton.setBounds(50, 550, 200, 40);
        feedbackButton.setBackground(new Color(41, 1, 51)); // Set feedback button color
        feedbackButton.setForeground(Color.WHITE); // Set text color
        feedbackButton.addActionListener(this);
        panel.add(feedbackButton);

        // Initialize back button
        backButton = new JButton("Back");
        backButton.setFont(new Font("Arial", Font.PLAIN, 14));
        backButton.setBounds(550, 550, 200, 40);
        backButton.setBackground(Color.BLACK); // Set back button color
        backButton.setForeground(Color.WHITE); // Set text color
        backButton.addActionListener(this);
        panel.add(backButton);
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == feedbackButton) {
            dispose();
            // Open feedback GUI
            FeedbackGUI WW = new FeedbackGUI();
            WW.setVisible(true);
        } else if (e.getSource() == backButton) {
            MovieTheaterGUI feedbackGUI = new MovieTheaterGUI();
            feedbackGUI.setVisible(true);
            // Close current frame and return to previous frame
            dispose();
            // For testing purposes, here I'm just printing a message
            System.out.println("Back button clicked, returning to previous frame...");
        } else {
            // If a food button is clicked, show message that it's available
            JButton clickedButton = (JButton) e.getSource();
            String foodName = clickedButton.getIcon().toString();
            JOptionPane.showMessageDialog(this, foodName + " is available!", "Available", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new ConcessionGUI().setVisible(true);
        });
    }
}
