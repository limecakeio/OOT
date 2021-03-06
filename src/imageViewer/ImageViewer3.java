package imageViewer;

import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImageViewer3 implements ActionListener {
	private JFrame frame;

	public ImageViewer3() {
		makeFrame();
	}

	private void makeFrame() {
		frame = new JFrame("ImageViewer");
		Container contentPane = frame.getContentPane();
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		JMenu fileMenu = new JMenu("File");
		menubar.add(fileMenu);
		JMenuItem openItem = new JMenuItem("Open");
		openItem.addActionListener(this);
		fileMenu.add(openItem);
		JMenuItem quitItem = new JMenuItem("Quit");
		fileMenu.add(quitItem);
		JLabel label = new JLabel("I am a label.");
		contentPane.add(label);
		frame.pack();
		frame.setVisible(true);
	}

	public void actionPerformed(ActionEvent event) {
		System.out.println("Menu item: " + event.getActionCommand());
	}

	public static void main(String[] args) {
		new ImageViewer3();
	}
}