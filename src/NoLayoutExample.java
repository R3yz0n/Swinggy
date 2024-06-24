import javax.swing.*;
import java.awt.*;

public class NoLayoutExample {
	public static void main(String[] args) {
		// Create the frame
		JFrame frame = new JFrame("No Layout Manager Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 400);

		// for no layout to work we need to pass null on set layout
//        frame.setLayout(null);  //without using a Panel
		JPanel mainPanel = new JPanel();
		mainPanel.setLayout(null);
		mainPanel.setBounds(0, 0, 400, 400);

		// Create buttons
		JButton button1 = new JButton("Button 1");
		JButton button2 = new JButton("Button 2");
		JButton button3 = new JButton("Button 3");

		// first two are x & y cords and the rest two are height and width
		button1.setBounds(100, 50, 100, 30);
		button2.setBounds(100, 150, 100, 30);
		button3.setBounds(100, 250, 100, 30);

		mainPanel.add(button1);
		mainPanel.add(button2);
		mainPanel.add(button3);

//        Without using a panel
//        frame.add(button1);
//        frame.add(button2);
//        frame.add(button3);
		frame.add(mainPanel);
		// Make the frame visible
		frame.setVisible(true);
	}
}
