import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PaymentGUI extends JFrame implements ActionListener {
    JPanel panel;
    JLabel titleLabel, cardNumberLabel, nameLabel, expirationLabel, cvvLabel;
    JTextField cardNumberField, nameField, expirationField, cvvField;
    JButton payButton, backButton;
    Font titleFont, labelFont, buttonFont;
    String fullName;
    String mobileNumber;

    public PaymentGUI(String fullName, String mobileNumber) {
        super("Payment");
        this.fullName = fullName;
        this.mobileNumber = mobileNumber;

        setSize(800, 600);
        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Panel
        panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(192, 178, 143)); // Set background color
        add(panel);

        // Fonts
        titleFont = new Font("Arial", Font.BOLD, 30);
        labelFont = new Font("Arial", Font.PLAIN, 20);
        buttonFont = new Font("Arial", Font.BOLD, 20);

        // Labels
        titleLabel = new JLabel("Online Payment");
        titleLabel.setBounds(280, 30, 300, 40);
        titleLabel.setFont(titleFont);
        panel.add(titleLabel);

        cardNumberLabel = new JLabel("Card Number:");
        cardNumberLabel.setBounds(200, 120, 150, 30);
        cardNumberLabel.setFont(labelFont);
        panel.add(cardNumberLabel);

        nameLabel = new JLabel("Name on Card:");
        nameLabel.setBounds(200, 170, 150, 30);
        nameLabel.setFont(labelFont);
        panel.add(nameLabel);

        expirationLabel = new JLabel("Expiration Date:");
        expirationLabel.setBounds(200, 220, 150, 30);
        expirationLabel.setFont(labelFont);
        panel.add(expirationLabel);

        cvvLabel = new JLabel("CVV:");
        cvvLabel.setBounds(200, 270, 150, 30);
        cvvLabel.setFont(labelFont);
        panel.add(cvvLabel);

        // Textfields
        cardNumberField = new JTextField();
        cardNumberField.setBounds(400, 120, 200, 30);
        panel.add(cardNumberField);

        nameField = new JTextField();
        nameField.setBounds(400, 170, 200, 30);
        panel.add(nameField);

        expirationField = new JTextField();
        expirationField.setBounds(400, 220, 100, 30);
        panel.add(expirationField);

        cvvField = new JTextField();
        cvvField.setBounds(400, 270, 100, 30);
        panel.add(cvvField);

        // Buttons
        payButton = new JButton("Pay");
        payButton.setBounds(280, 350, 100, 40);
        payButton.setFont(buttonFont);
        payButton.setBackground(new Color(34, 139, 34)); // Dark Green
        payButton.setForeground(Color.WHITE);
        payButton.addActionListener(this);
        panel.add(payButton);

        backButton = new JButton("Back");
        backButton.setBounds(620, 470, 100, 40);
        backButton.setFont(buttonFont);
        backButton.setBackground(Color.BLACK);
        backButton.setForeground(Color.WHITE);
        backButton.addActionListener(this);
        panel.add(backButton);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == payButton) {
            String cardNumber = cardNumberField.getText();
            String nameOnCard = nameField.getText();
            String expirationDate = expirationField.getText();
            String cvv = cvvField.getText();

            if (cardNumber.isEmpty() || nameOnCard.isEmpty() || expirationDate.isEmpty() || cvv.isEmpty()) {
                JOptionPane.showMessageDialog(null, "Fill in all the fields.");
            } else {
                int response = JOptionPane.showConfirmDialog(null, "Payment Successful.", "Success", JOptionPane.DEFAULT_OPTION);
                if (response == JOptionPane.OK_OPTION) {
                    // Redirect to FilmTicketGUI with fullName and mobileNumber
                    FilmTicketGUI lin = new FilmTicketGUI(fullName, mobileNumber);
                    lin.setVisible(true);
                    dispose();
                }
            }
        }

        if (ae.getSource() == backButton) {
            MoreDetails U1 = new MoreDetails();
            U1.setVisible(true);
            this.setVisible(false);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new PaymentGUI("John Doe", "1234567890").setVisible(true);
        });
    }
}
