import javax.swing.*;
import java.awt.*;

public class ScrollPaneExample {
	public static void main(String[] args) {
		// Create the frame
		JFrame frame = new JFrame("JList with JScrollPane Demo");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(400, 300);
		

		DefaultListModel<String> listModel = new DefaultListModel<>();
		for (int i = 0; i < 20; i++) {
			listModel.addElement("Item" + i);
		}

		// Create a JList with the list model
		JList<String> list = new JList<>(listModel);
//		list.setLayoutOrientation(JList.HORIZONTAL_WRAP); // For horizontal scrolling


		// To make it scrolable we need to pass the list to the JscrolLpaen
		JScrollPane scrollPane = new JScrollPane(list);

		frame.add(scrollPane);  


//		frame.add(list); // Doing this would not make it scrollable

		// Make the frame visible
		frame.setVisible(true);
	}
}
