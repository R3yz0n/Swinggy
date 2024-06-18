import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class Form {
	public static void main(String[] args) throws SQLException {
		JFrame frame = new JFrame("Flood Fill the Form");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 420);
		frame.setResizable(false);

		// Main panel with BorderLayout and outer padding
		JPanel mainPanel = new JPanel(new BorderLayout());
		mainPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30)); // Outer padding

		// Center panel to hold form fields with inner padding
		JPanel centerPanel = new JPanel();
		centerPanel.setLayout(new BoxLayout(centerPanel, BoxLayout.Y_AXIS));
		centerPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 10, 0)); // Top padding for the first panel

		// Name panel
		JPanel namePanel = new JPanel(new BorderLayout());
		JLabel nameLabel = new JLabel("Name:");
		JTextField nameField = new JTextField(20);
		namePanel.add(nameLabel, BorderLayout.NORTH);
		namePanel.add(nameField, BorderLayout.CENTER);
		centerPanel.add(namePanel);

		// Email panel
		JPanel emailPanel = new JPanel(new BorderLayout());
		JLabel emailLabel = new JLabel("Email:");
		JTextField emailField = new JTextField(20);
		emailPanel.add(emailLabel, BorderLayout.NORTH);
		emailPanel.add(emailField, BorderLayout.CENTER);
		centerPanel.add(emailPanel);

		// Password panel
		JPanel passwordPanel = new JPanel(new BorderLayout());
		JLabel passwordLabel = new JLabel("Password:");
		JPasswordField passwordField = new JPasswordField(20);
		passwordPanel.add(passwordLabel, BorderLayout.NORTH);
		passwordPanel.add(passwordField, BorderLayout.CENTER);
		centerPanel.add(passwordPanel);

		// Gender panel with radio buttons
		JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		JLabel genderLabel = new JLabel("Gender:");
		genderPanel.add(genderLabel);

		ButtonGroup genderGroup = new ButtonGroup();
		JRadioButton male = new JRadioButton("Male");
		JRadioButton female = new JRadioButton("Female");
		JRadioButton other = new JRadioButton("Others");

		genderGroup.add(male);
		genderGroup.add(female);
		genderGroup.add(other);

		genderPanel.add(male);
		genderPanel.add(female);
		genderPanel.add(other);

		centerPanel.add(genderPanel);

		// Desc
		JPanel descriptionPanel = new JPanel(new BorderLayout());
		JLabel descriptionLabel = new JLabel("Description:");
		JTextArea descriptionArea = new JTextArea(5, 20);
		descriptionArea.setLineWrap(true);
		JScrollPane scrollPane = new JScrollPane(descriptionArea);
		descriptionPanel.add(descriptionLabel, BorderLayout.NORTH);
		descriptionPanel.add(scrollPane, BorderLayout.CENTER);
		centerPanel.add(descriptionPanel);

		// Add centerPanel to mainPanel
		mainPanel.add(centerPanel, BorderLayout.CENTER);

		// Button panel
		JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
		JButton submitBtn = new JButton("Submit");

		// ActionListener for Submit button
		submitBtn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// Retrieve input values
				String name = nameField.getText();
				String email = emailField.getText();
				String password = new String(passwordField.getPassword());

				String gender = "";
				if (male.isSelected()) {
					gender = "male";
				} else if (female.isSelected()) {
					gender = "female";
				} else if (other.isSelected()) {
					gender = "others";
				}

				String message = descriptionArea.getText();

				Person p = new Person(name, email, password, gender, message);
				p.connect();
				p.insertPerson();

			}
		});

		buttonPanel.add(submitBtn);

		mainPanel.add(buttonPanel, BorderLayout.SOUTH);

		frame.add(mainPanel);
		frame.setVisible(true);
	}
}
