package hust.soict.dsai.aims.screen.manager;

import java.awt.Button;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Color;

import hust.soict.dsai.aims.media.Book;
import hust.soict.dsai.aims.store.Store;
import javafx.scene.control.Dialog;

public class AddBookToStore extends AddItemToStore{

	public AddBookToStore(Store store) {
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
		
		JButton addBookButton = new JButton("Add book");
		addBookButton.setPreferredSize(new Dimension(100, 50));
		addBookButton.setMaximumSize(new Dimension(100, 50));
		// Add book to the store
		addBookButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				taTitleInput.setText("");
				taCostInput.setText("");
				taCategoryInput.setText("");
				store.addMedia(new Book(taTitleInput.getText(), taCategoryInput.getText(), Float.parseFloat(taCostInput.getText())));
				JOptionPane.showMessageDialog(null, "The book has been added to the store");
			}
		});
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
		header.add(storeButton);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(addBookButton);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		return header;
	}

}
