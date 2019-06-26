package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Artikal;
import model.Narudzbenica;
import net.miginfocom.swing.MigLayout;

public class ArtikalBuyPanel extends JPanel{

	private Artikal artikal;

	private Narudzbenica order;
	
	public ArtikalBuyPanel(Artikal artikal, Narudzbenica order) {
		super();
		this.artikal = artikal;
		this.order = order;
		
		this.setLayout(new MigLayout("fill"));

		this.setSize(250, 150);
		this.setMinimumSize(this.getSize());
		this.setMaximumSize(this.getSize());
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		this.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));
		
		JLabel nl = new JLabel("Naziv artikla: " + this.artikal.getNaziv());
		this.add(nl, "al center, wrap");
		
		JButton ab = new JButton("Dodaj");
		this.add(ab, "al center, wrap");
		
		ab.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				order.dodajStavku(artikal);
			}
		});
		
		
		
		
	}
	
	
	
}
