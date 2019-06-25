package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Artikal;
import net.miginfocom.swing.MigLayout;

public class ArtikalPanel extends JPanel {

	private Artikal artikal;
	private CenterPanel centerPanel;

	public ArtikalPanel(Artikal artikal, CenterPanel centerPanel) {

		this.artikal = artikal;
		this.centerPanel = centerPanel;
		this.setLayout(new BorderLayout());
		this.add(new JLabel(this.artikal.getNaziv()), BorderLayout.NORTH);
		JPanel picture = new JPanel(new MigLayout("fill"));
		picture.setBackground(Color.DARK_GRAY);
		JTextField pictureName = new JTextField("Slika");
		pictureName.setEditable(false);
		picture.add(pictureName, "growx, growy");
		this.add(picture, BorderLayout.CENTER);
		JButton ob = new JButton("Open");
		this.add(ob, BorderLayout.SOUTH);

		ob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				centerPanel.setProduct(artikal);
			}
		});

	}

}
