package GUI;

import javax.swing.*;
import java.awt.event.*;

public class LoginForm extends JFrame implements ActionListener {

    private JPanel panel;
    private JLabel userLabel, passwordLabel, messageLabel;
    private JTextField userText;
    private JPasswordField passwordText;
    private JButton loginButton, cancelButton;

    public LoginForm() {

        // Set up the JFrame
        setTitle("Login Form");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Create the panel
        panel = new JPanel();
        panel.setLayout(null);

        // Create the user label and text field
        userLabel = new JLabel("Username:");
        userLabel.setBounds(10, 20, 80, 25);
        panel.add(userLabel);
        userText = new JTextField(20);
        userText.setBounds(100, 20, 165, 25);
        panel.add(userText);

        // Create the password label and text field
        passwordLabel = new JLabel("Password:");
        passwordLabel.setBounds(10, 50, 80, 25);
        panel.add(passwordLabel);
        passwordText = new JPasswordField(20);
        passwordText.setBounds(100, 50, 165, 25);
        panel.add(passwordText);

        // Create the login and cancel buttons
        loginButton = new JButton("Login");
        loginButton.setBounds(10, 90, 80, 25);
        loginButton.addActionListener(this);
        panel.add(loginButton);
        cancelButton = new JButton("Cancel");
        cancelButton.setBounds(100, 90, 80, 25);
        cancelButton.addActionListener(this);
        panel.add(cancelButton);

        // Create the message label
        messageLabel = new JLabel("");
        messageLabel.setBounds(10, 120, 300, 25);
        panel.add(messageLabel);

        // Add the panel to the JFrame
        add(panel);

        // Show the JFrame
        setVisible(true);
    }

    // Handle button clicks
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == loginButton) {
            String user = userText.getText();
            String password = new String(passwordText.getPassword());
            if (user.equals("username") && password.equals("password")) {
                messageLabel.setText("Login successful!");
            } else {
                messageLabel.setText("Invalid username or password.");
            }
        } else if (e.getSource() == cancelButton) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new LoginForm();
    }
}
