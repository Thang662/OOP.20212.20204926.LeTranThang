package hust.soict.dsai.aims.screen.manager;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.Window;
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

public class StoreManagerScreen extends JFrame{
	Store store;
	
	// Constructor with store
	public StoreManagerScreen(Store store) {
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
//		Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
//		setLocation((int) ((dimension.getWidth() - this.getWidth()) / 2), (int) ((dimension.getHeight() - this.getHeight()) / 2));
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
		
		JMenu smUpdateStore = new JMenu("Update Store");
		JMenuItem addBook = new JMenuItem("Add Book");
		JMenuItem addCD = new JMenuItem("Add CD");
		JMenuItem addDVD = new JMenuItem("Add DVD");
		smUpdateStore.add(addBook);
		smUpdateStore.add(addCD);
		smUpdateStore.add(addDVD);
		
		// Switch to add book panel
		addBook.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				setContentPane(new AddItemToStore(store)); //panel = panel you want to change too.
//				repaint();             //Ensures that the frame swaps to the next panel and doesn't get stuck.
//				revalidate();          //Ensures that the frame swaps to the next panel and doesn't get stuck.
				dispose();
				new AddBookToStore(store);
			}
		});
		
		// Switch to add cd panel
		addCD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new AddCompactDiscToStore(store);
			}
		});
		
		// Switch to add dvd panel
		addDVD.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
				new AddDigitalVideoDiscToStore(store);
			}
		});
		
		menu.add(smUpdateStore);
		menu.add(new JMenuItem("View store"));
		menu.add(new JMenuItem("View cart"));
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setLayout(new FlowLayout(FlowLayout.LEFT));
		menuBar.add(menu);
		return menuBar;
	}
	
	JPanel createHeader() {
		JPanel header = new JPanel();
		header.setLayout(new BoxLayout(header, BoxLayout.X_AXIS));

		JLabel title = new JLabel("AIMS:");
		title.setFont(new Font(title.getFont().getName(), Font.PLAIN, 50));
		title.setForeground(Color.CYAN);
		
//		JButton cart = new JButton("View cart");
//		cart.setPreferredSize(new Dimension(100, 50));
//		cart.setMaximumSize(new Dimension(100, 50));
		
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		header.add(title);
		header.add(Box.createHorizontalGlue());
//		header.add(cart);
		header.add(Box.createRigidArea(new Dimension(10, 10)));
		return header;
	}
	
	JPanel createCenter() {
		
		JPanel center = new JPanel();
		center.setLayout(new GridLayout(3, 3, 2, 2));
		
		ArrayList<Media> mediaInStore = store.getItemsInStore();
		for (int i = 0; i < 9; i++) {
			MediaStore cell = new MediaStore(mediaInStore.get(i));
			center.add(cell);
		}
		
		return center;
	}
}
