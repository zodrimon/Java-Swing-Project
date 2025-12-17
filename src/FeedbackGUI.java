import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FeedbackGUI extends JFrame {
    private JTextArea feedbackArea;
    private JCheckBox[] starCheckBoxes;

    public FeedbackGUI() {
        setTitle("Concession Feedback");
        setSize(400, 350);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(192, 178, 138)); // Set background color

        feedbackArea = new JTextArea();
        feedbackArea.setBackground(Color.GRAY); // Set text field background color
        feedbackArea.setForeground(Color.WHITE); // Set text color
        feedbackArea.setFocusable(true); // Set the text area to be focusable
        JScrollPane scrollPane = new JScrollPane(feedbackArea);

        JPanel ratingPanel = new JPanel(new GridLayout(1, 5));
        ratingPanel.setBackground(new Color(192, 178, 138)); // Set background color
        starCheckBoxes = new JCheckBox[5];
        for (int i = 0; i < 5; i++) {
            starCheckBoxes[i] = new JCheckBox((i + 1) + " star");
            ratingPanel.add(starCheckBoxes[i]);
        }

        JButton submitButton = new JButton("Submit");
        submitButton.setBackground(new Color(41, 1, 51)); // Set submit button color
        submitButton.setForeground(Color.WHITE); // Set text color
        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                submitFeedback();
            }
        });

        JButton backButton = new JButton("Back");
        backButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                ConcessionGUI concessionGUI = new ConcessionGUI();
                concessionGUI.setVisible(true);
                dispose();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.add(submitButton);
        buttonPanel.add(backButton);

        mainPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(ratingPanel, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        setVisible(true);
    }

    private void submitFeedback() {
        String feedback = feedbackArea.getText();
        int rating = getRating();
        if (rating == 0) {
            JOptionPane.showMessageDialog(this, "Please select a rating.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        if (!feedback.isEmpty()) {
            // Code to save feedback and rating
            JOptionPane.showMessageDialog(this, "Feedback submitted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        } else {
            JOptionPane.showMessageDialog(this, "Please enter your feedback.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private int getRating() {
        for (int i = 0; i < 5; i++) {
            if (starCheckBoxes[i].isSelected()) {
                return i + 1;
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                new FeedbackGUI();
            }
        });
    }
}
