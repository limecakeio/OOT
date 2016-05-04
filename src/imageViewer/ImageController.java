package imageViewer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFileChooser;

public class ImageController implements ActionListener {
	private ImageModel model;
	private ImageView view;
	
	public ImageController(ImageModel model, ImageView view) {
		this.model = model;
		this.view = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		final JFileChooser fileChooser = new JFileChooser();
		if(fileChooser.showOpenDialog(view.parent) == JFileChooser.APPROVE_OPTION) {
			model.setFile(fileChooser.getSelectedFile());
		}
	}

}
