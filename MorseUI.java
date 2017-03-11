import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.event.KeyEvent;

public class MorseUI extends JFrame {
	
	private JMenuBar menuBar;
	private JMenu fileMenu, convertMenu, exitMenu;
	private JMenuItem fileItem, convertItem;
	
	private JTextArea codeArea;
	
	public MorseUI(){
		
		super("Morse code converter");
		
		// Create the menu bar
		menuBar = new JMenuBar();
		
		// Build the file menu
		fileMenu = new JMenu("File");
		fileMenu.setMnemonic(KeyEvent.VK_F);				// sets key "F" that can call on menu "File"
		
		menuBar.add(fileMenu);			// add menu to menu bar
		
		// Build the convert menu
		convertMenu = new JMenu("Convert");
		
		menuBar.add(convertMenu);						// add menu to menu bar
		menuBar.setBackground(Color.lightGray);			// set menu bar colour to light_gray
		
		// Build the convert items
		convertItem = new JMenuItem("To Morse Code");
		convertItem.setMnemonic(KeyEvent.VK_M);			// sets key "M" that can call "To Morse Code"
		
		convertMenu.add(convertItem);					// add menu item to a menu
		
		convertItem = new JMenuItem("To English");
		convertItem.setMnemonic(KeyEvent.VK_E);			// sets key "E" that can call "To English"
		
		convertMenu.add(convertItem);
		
		// Build the exitMenu
		exitMenu = new JMenu("Exit");
		exitMenu.setMnemonic(KeyEvent.VK_X);			// sets key "X" to call "Exit"
		
		menuBar.add(exitMenu);
		
		setJMenuBar(menuBar);							// sets the menu Bar to JFrame
		
		getContentPane().setBackground(Color.DARK_GRAY);		// change the color of the JFrame content panel.
		
		
		codeArea = new JTextArea();						// create a text area
		
		codeArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		add(codeArea);
		
	}
}