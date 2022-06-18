package hust.soict.dsai.swing;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class LookAndFeelDemo extends JFrame {
	public LookAndFeelDemo() {
		
		addDemoComponents();
		addLookAndFeelComboBox();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(380, 100);
		setVisible(true);
	}
	
	void addDemoComponents() {
		Container cp = getContentPane();
		cp.setLayout(new FlowLayout());
		cp.add(new JLabel("Label: "));
		cp.add(new JTextField("Text field"));
		cp.add(new JRadioButton("Radio button"));
		cp.add(new JButton("Button"));
	}
	
	void addLookAndFeelComboBox() {
		int i;
		Container cp = getContentPane();
		cp.add(new JLabel("Change Look and Feel Here: "));
		
		// create the combo box
		LookAndFeelInfo[] lafInfos = UIManager.getInstalledLookAndFeels();
		String[] lafNames = new String[lafInfos.length + 2];
		for (i = 0; i < lafInfos.length; i++) {
			lafNames[i]	= lafInfos[i].getName();
		}
		lafNames[i] = "Java";
		lafNames[i + 1] = "System";
		JComboBox cbLookAndFeel = new JComboBox(lafNames);
		cp.add(cbLookAndFeel);
		
		// handle change look and feel
		JFrame frame = this;
		cbLookAndFeel.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent ae) {
				// TODO Auto-generated method stub
				int index = cbLookAndFeel.getSelectedIndex();
				try {
					if (lafNames[index].equals("Java")) {
						UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
					}
					else if (lafNames[index].equals("System")) {
						UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
					}
					else UIManager.setLookAndFeel(lafInfos[index].getClassName());
				} catch (Exception e) {
					e.printStackTrace();
				}
				SwingUtilities.updateComponentTreeUI(frame);
				setTitle(lafNames[index] + " Look And Feel");
			}
		});
	}
	
	public static void main(String[] args) {
		new LookAndFeelDemo();
	}
}
