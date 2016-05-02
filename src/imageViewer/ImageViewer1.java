package imageViewer;

import java.awt.Container;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class ImageViewer1 {
	private JFrame frame;

	public ImageViewer1() {
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
		fileMenu.add(openItem);
		JMenuItem quitItem = new JMenuItem("Quit");
		fileMenu.add(quitItem);
		JLabel label = new JLabel("I am a label.");
		contentPane.add(label);
		frame.pack();
		frame.setVisible(true);
	}
	public static void main(String[] args) {
		new ImageViewer1();
	}
}
