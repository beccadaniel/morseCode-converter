import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JMenu;

import java.awt.GridLayout;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;

public class MorseUI extends JFrame {
	
	private JMenuBar menuBar;
	private JMenu fileMenu, convertMenu, exitMenu;
	private JMenuItem fileItem, convertItemA, convertItemB;
	
	private JPanel container;
	
	private JTextArea codeArea, convertedCodeArea;
		
	String text;
	
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
		convertItemA = new JMenuItem("To Morse Code");
		convertItemA.setMnemonic(KeyEvent.VK_M);			// sets key "M" that can call "To Morse Code"
		
		convertMenu.add(convertItemA);					// add menu item to a menu
		
		convertItemB = new JMenuItem("To English");
		convertItemB.setMnemonic(KeyEvent.VK_E);			// sets key "E" that can call "To English"
		
		convertMenu.add(convertItemB);
		
		// Build the exitMenu
		exitMenu = new JMenu("Exit");
		exitMenu.setMnemonic(KeyEvent.VK_X);			// sets key "X" to call "Exit"
		
		menuBar.add(exitMenu);
		
		setJMenuBar(menuBar);							// sets the menu Bar to JFrame
	
		
		// create panel
		container = new JPanel(new GridLayout(0,1));
		
		Font font = new Font("Comic Sans MS", Font.PLAIN, 18);
		
		codeArea = new JTextArea();						// create a text area
		convertedCodeArea = new JTextArea();
		convertedCodeArea.setEditable(false);
		convertedCodeArea.setBorder(BorderFactory.createTitledBorder(null, "Morse Code", 0, 0, font, Color.DARK_GRAY));
		
		codeArea.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
		container.add(codeArea);
		container.add(convertedCodeArea);
		add(container);									// add codeArea to JFrame
		
		Morse handler = new Morse();
		convertItemA.addActionListener(handler);
		convertItemA.addKeyListener(handler);
		
	}
	
	// Class to listen for action events
	private class Morse implements ActionListener, KeyListener {
		
		public void actionPerformed(ActionEvent e){
			
			if(e.getSource() == convertItemA){
				
				text = convertToMorse(codeArea.getText());
				convertedCodeArea.setText(text);
				
			}
			
		}
		
		public void keyPressed(KeyEvent e) {
			if(e.getKeyCode() == KeyEvent.VK_M){
				
				text = convertToMorse(codeArea.getText());
				convertedCodeArea.setText(text);
				
			}
		}
		
		public void keyTyped(KeyEvent e){
			
		}
		
		public void keyReleased(KeyEvent e){
			
		}
		
	}
	
	public String convertToMorse(String text){
		
		text = text.toLowerCase();
		char[] textArr = text.toCharArray();
		StringBuilder buffer = new StringBuilder();
		
		for(int i= 0; i < textArr.length; i++){			// loop through the array of characters.
			
			char letter = textArr[i];				// using this to test
			String result = textArr[i]+"";
			
			switch (letter){
			case ' ':
				result = "   ";
				break;
			
			case 'a':
				result = ".- ";
				break;
				
			case 'b':
				result = "-... ";
				break;
				
			case 'c':
				result = "-.-. ";
				break;
				
			case 'd':
				result = "-.. ";
				break;
				
			case 'e':
				result = ". ";
				break;
				
			case 'f':
				result = "..-. ";
				break;
				
			case 'g':
				result = "--. ";
				break;
				
			case 'h':
				result = ".... ";
				break;
				
			case 'i':
				result = ".. ";
				break;
				
			case 'j':
				result = ".--- ";
				break;
				
			case 'k':
				result = "-.- ";
				break;
				
			case 'l':
				result = ".-.. ";
				break;
				
			case 'm':
				result = "-- ";
				break;
				
			case 'n':
				result = "-. ";
				break;
				
			case 'o':
				result = "--- ";
				break;
				
			case 'p':
				result = ".--. ";
				break;
				
			case 'q':
				result = "--.- ";
				break;
				
			case 'r':
				result = ".-. ";
				break;
				
			case 's':
				result = "... ";
				break;
				
			case 't':
				result = "- ";
				break;
				
			case 'u':
				result = "..- ";
				break;
				
			case 'v':
				result = "...- ";
				break;
				
			case 'w':
				result = ".-- ";
				break;
				
			case 'x':
				result = "-..- ";
				break;
				
			case 'y':
				result = "-.-- ";
				break;
				
			case 'z':
				result = "--.. ";
				break;
				
			case '1':
				result = ".---- ";
				break;
			
			case '2':
				result = "..--- ";
				break;
				
			case '3':
				result = "...-- ";
				break;
				
			case '4':
				result = "....- ";
				break;
				
			case '5':
				result = "..... ";
				break;
				
			case '6':
				result = "-.... ";
				break;
				
			case '7':
				result = "--... ";
				break;
				
			case '8':
				result = "---.. ";
				break;
				
			case '9':
				result = "----. ";
				break;
				
			case '0':
				result = "----- ";
				break;
			}
			
			// concatenate the string from the switch case. If the character that entered the switch case
			// is not found in the switch, it appends the character as a String to buffer.
			buffer.append(result);			
		}
		
		return buffer.toString();
				
	}
	
	public static void main(String[] args) {
		
		MorseUI comp = new MorseUI();
		comp.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		comp.setSize(600, 480);
		comp.setVisible(true);
	}
}