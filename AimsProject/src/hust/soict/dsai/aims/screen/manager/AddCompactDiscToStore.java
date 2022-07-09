package hust.soict.dsai.aims.screen.manager;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.media.CompactDisc;
import hust.soict.dsai.aims.store.Store;

public class AddCompactDiscToStore extends AddItemToStore{
	public AddCompactDiscToStore(Store store) {
		super(store);
		// TODO Auto-generated constructor stub
	}

	@Override
	JPanel createHeader() {
		// TODO Auto-generated method stub
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS:");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
		JButton storeButton = new JButton("View store");
		storeButton.setPreferredSize(new Dimension(100, 50));
		storeButton.setMaximumSize(new Dimension(100, 50));
		// Switch to store menu
		storeButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new StoreManagerScreen(store);
			}
		});
		
		
		JButton addCDButton = new JButton("Add CD");
		addCDButton.setPreferredSize(new Dimension(100, 50));
		addCDButton.setMaximumSize(new Dimension(100, 50));
		addCDButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				taTitleInput.setText("");
				taCostInput.setText("");
				taCategoryInput.setText("");
				store.addMedia(new CompactDisc(taTitleInput.getText(), taCategoryInput.getText(), Float.parseFloat(taCostInput.getText())));
				JOptionPane.showMessageDialog(null, "The CD has been added to the store");
			}
		});
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(storeButton);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(addCDButton);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		return header;
	}
}
