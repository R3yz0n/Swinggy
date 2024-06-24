import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.*;
import java.awt.event.*;
import java.sql.SQLException;

public class Example {
  public static void main(String[] args) {

    JFrame jf = new JFrame("Form");
    jf.setSize(460, 500);

    JPanel panel = new JPanel();

    JLabel lable = new JLabel("name:");
    panel.add(lable);

    JTextField textfield = new JTextField(20);
    panel.add(textfield);

    JLabel password = new JLabel("password:");
    panel.add(password);

    JPasswordField passwordField = new JPasswordField(20);
    panel.add(passwordField);

    JLabel email = new JLabel("email:");
    panel.add(email);

    JTextField emailField = new JTextField(20);
    panel.add(emailField);

    JLabel TArea = new JLabel("message");
    panel.add(TArea);

    JTextArea textarea = new JTextArea(10, 20);
    textarea.setLineWrap(true); 
    textarea.setWrapStyleWord(true);

    JScrollPane scrollPane = new JScrollPane(textarea);
    panel.add(scrollPane);

    JButton btn = new JButton("submit");
    btn.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        String name = textfield.getText();
        String password = new String(passwordField.getPassword());
        String email = emailField.getText();
        String message = textarea.getText();

        System.out.println("Name: " + name);
        System.out.println("Password: " + password);
        System.out.println("Email: " + email);
        System.out.println("Text: " + message);


      }
    });

    panel.add(btn);

    jf.setVisible(true);
    jf.add(panel);
  }
}