package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.TextArea;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import hust.soict.dsai.aims.media.Media;
import hust.soict.dsai.aims.store.Store;

public abstract class AddItemToStore extends JFrame{
	Store store;
	TextArea taTitleInput, taCostInput, taCategoryInput;
	
	// Constructor with store
	public AddItemToStore(Store store) {
		this.store = store;
		Container cp = getContentPane();
		cp.setLayout(new BorderLayout());
		
		cp.add(createNorth(), BorderLayout.NORTH);
		cp.add(createCenter(), BorderLayout.CENTER);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setTitle("Store");
		setSize(1024, 768);
		setLocationRelativeTo(null);
	}
	
	JPanel createNorth() {
		JPanel north = new JPanel();
		north.setLayout(new BoxLayout(north, BoxLayout.Y_AXIS));
		north.add(createMenuBar());
		north.add(createHeader());
		return north;
	}
	
	JMenuBar createMenuBar() {
		JMenu menu = new JMenu("Options");
		JMenuItem viewStore = new JMenuItem("View store");
		// Switch to store menu
		viewStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new StoreManagerScreen(store);
			}
		});
		menu.add(viewStore);
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	
	abstract JPanel createHeader();
	
	JPanel createCenter() {
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 2, 2, 2));
		center.add(new Label("Title: ", Label.CENTER));
		taTitleInput = new TextArea(15, 20);
		center.add(taTitleInput);
		center.add(new Label("Cost: ", Label.CENTER));
		taCostInput = new TextArea(15, 20);
		center.add(taCostInput);
		center.add(new Label("Category: ", Label.CENTER));
		taCategoryInput = new TextArea(15, 20);
		center.add(taCategoryInput);
		return center;
	};
}
