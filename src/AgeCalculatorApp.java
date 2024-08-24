import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.Period;

public class AgeCalculatorApp {

    public static void main(String[] args) {
        // Create the main JFrame
        JFrame frame = new JFrame("Age Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 150);

        // Create a JPanel to hold components
        JPanel panel = new JPanel();

        // Create and add JLabel and JTextField for the birthdate input
        JLabel label = new JLabel("Enter your birthdate (YYYY-MM-DD):");
        JTextField birthdateField = new JTextField(10);
        panel.add(label);
        panel.add(birthdateField);

        // Create a JButton for calculating age
        JButton calculateButton = new JButton("Calculate Age");
        panel.add(calculateButton);

        // Create a JLabel to display the result
        JLabel resultLabel = new JLabel("Your age will be displayed here.");
        panel.add(resultLabel);

        // Add ActionListener to the button
        calculateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get the birthdate from the text field
                String birthdateStr = birthdateField.getText();

                try {
                    // Convert the string to LocalDate
                    LocalDate birthdate = LocalDate.parse(birthdateStr);
                    LocalDate currentDate = LocalDate.now();

                    // Calculate the age
                    int age = Period.between(birthdate, currentDate).getYears();

                    // Display the age
                    resultLabel.setText("Your age is: " + age + " years");
                } catch (Exception ex) {
                    // Handle invalid input
                    resultLabel.setText("Invalid date format. Please use YYYY-MM-DD.");
                }
            }
        });

        // Add the JPanel to the JFrame
        frame.add(panel);

        // Make the frame visible
        frame.setVisible(true);
    }
}
