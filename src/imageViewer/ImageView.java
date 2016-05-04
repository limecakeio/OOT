package imageViewer;

import java.awt.Container;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class ImageView extends JPanel implements Observer {
	public JFrame parent;
	public JLabel label;
	
	public ImageView(JFrame parent) {
		this.parent = parent;
		label = new JLabel();
		
		Container contentPane = parent.getContentPane();
		contentPane.add(new ImageView(parent));
		contentPane.add(label);
	}
	
	@Override
	public void update(ImageModel model) {
		label.setIcon(new ImageIcon(model.getFile().getAbsolutePath()));
		}
	}
