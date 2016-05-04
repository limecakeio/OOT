package imageViewer;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import aboutDialog.About;

public class Main {
	private JFrame frame;
	private JFileChooser fileChooser;

	public Main() {
		makeFrame();
	}
	private void makeFrame() {
		ImageModel model = new ImageModel();
		ImageView view = new ImageView(frame);
		ImageController controller = new ImageController(model, view);
		
		
		frame = new JFrame("ImageViewer");
		fileChooser = new JFileChooser(System.getProperty("user.dir"));
		fileChooser.showOpenDialog(frame);
		String filename = fileChooser.getSelectedFile().getName();
		ImageIcon image = new ImageIcon(filename);
		//label.setIcon(image);
		frame.pack();
		frame.setVisible(true);
		
		// Add menu items to menubar
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		JMenuItem openItem = new JMenuItem("Open");
		fileMenu.add(openItem);
		JMenuItem quitItem = new JMenuItem("Quit");
		fileMenu.add(quitItem);
		
		JMenu helpMenu = new JMenu("Help");
		menubar.add(helpMenu);
		JMenuItem aboutItem = new JMenuItem("About");
		helpMenu.add(aboutItem);
		
		//Add functionality to menu items
//		openItem.addActionListener(new OpenActionListener() {});
//		quitItem.addActionListener(new QuitActionListener());
//		aboutItem.addActionListener(new AboutActionListener());
		
		//DO it via anonymous classes
		openItem.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("(Anonymous) Open clicked");
					}
				});
		quitItem.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						System.out.println("(Anonymous) Quit clicked");
					}
				});
		aboutItem.addActionListener(
				new ActionListener() {
					public void actionPerformed(ActionEvent e) {
						About dialog = new About();
						dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
						dialog.setVisible(true);
					}
				});
		
	}
	public static void main(String[] args) {
		new Main();
	}
	
	public void actionPerformed(ActionEvent event) {
		System.out.println("Menu item: " + event.getActionCommand());
	}
	
	// Inner class button implementation
//	private class OpenActionListener implements ActionListener {
//			public void actionPerformed(ActionEvent event) {
//				System.out.println("Open clicked");
//		}
//	}
//	
//	private class QuitActionListener implements ActionListener {
//		public void actionPerformed(ActionEvent event) {
//			System.out.println("Quit clicked");
//			}
//	}
//	
//	private class AboutActionListener implements ActionListener {
//		public void actionPerformed(ActionEvent event) {
//			System.out.println("About clicked");
//			}
//	}
	
	
	
	
	
	
	
	
	
}
