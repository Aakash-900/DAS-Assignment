package Project.src.GUI;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class RegisterForm extends JFrame implements ActionListener {

    private JLabel nameLabel, emailLabel, passwordLabel, confirmPasswordLabel;
    private JTextField nameField, emailField;
    private JPasswordField passwordField, confirmPasswordField;
    private JButton registerButton;

    public RegisterForm() {

        // Set title of frame
        setTitle("Registration Form");

        // Create components
        nameLabel = new JLabel("Name:");
        emailLabel = new JLabel("Email:");
        passwordLabel = new JLabel("Password:");
        confirmPasswordLabel = new JLabel("Confirm Password:");

        nameField = new JTextField();
        emailField = new JTextField();

        passwordField = new JPasswordField();
        confirmPasswordField = new JPasswordField();

        registerButton = new JButton("Register");
        registerButton.addActionListener(this);

        // Set layout of frame
        setLayout(new GridLayout(5, 2, 5, 5));

        // Add components to frame
        add(nameLabel);
        add(nameField);
        add(emailLabel);
        add(emailField);
        add(passwordLabel);
        add(passwordField);
        add(confirmPasswordLabel);
        add(confirmPasswordField);
        add(new JLabel(""));
        add(registerButton);

        // Set size and visibility of frame
        setSize(300, 200);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        // Get user input
        String name = nameField.getText();
        String email = emailField.getText();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        // Check if password and confirm password match
        if (!password.equals(confirmPassword)) {
            JOptionPane.showMessageDialog(this, "Password and Confirm Password do not match.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        // Save user data to database or file
        // ...
        // Display confirmation message
        JOptionPane.showMessageDialog(this, "Registration successful.", "Success", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        RegisterForm registerForm = new RegisterForm();
        registerForm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
