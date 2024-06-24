import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CardLayoutExample {
	public static void main(String[] args) {

		JFrame frame = new JFrame("CardLayout Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);

		// creation of cardPanel with setting card layout
		JPanel cardPanel = new JPanel(new CardLayout());

		// Create individual panels for each card
		JPanel card1 = new JPanel();
		card1.add(new JLabel("Card 1"));
		card1.setBackground(Color.RED);

		JPanel card2 = new JPanel();
		card2.add(new JLabel("Card 2"));
		card2.setBackground(Color.GREEN);

		JPanel card3 = new JPanel();
		card3.add(new JLabel("Card 3"));
		card3.setBackground(Color.BLUE);

		// Add the cards to the card panel
		cardPanel.add(card1, "Card 1");
		cardPanel.add(card2, "Card 2");
		cardPanel.add(card3, "Card 3");

		// creting buttons for each panels
		JPanel buttonPanel = new JPanel();
		JButton button1 = new JButton("Show Card 1");
		JButton button2 = new JButton("Show Card 2");
		JButton button3 = new JButton("Show Card 3");

		// adding event listeners
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cardPanel.getLayout());
				cl.show(cardPanel, "Card 1");
			}
		});

		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cardPanel.getLayout());
				cl.show(cardPanel, "Card 2");
			}
		});

		button3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CardLayout cl = (CardLayout) (cardPanel.getLayout());
				cl.show(cardPanel, "Card 3");
			}
		});

		// Add buttons to the button panel
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);

		// Add the card panel and button panel to the frame
		frame.getContentPane().add(cardPanel, BorderLayout.CENTER);
		frame.getContentPane().add(buttonPanel, BorderLayout.PAGE_END);

		// At last make set visible true for the frame
		frame.setVisible(true);
	}
}
