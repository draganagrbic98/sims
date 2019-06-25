package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Artikal;
import model.Narudzbenica;

public class ArtikalBuyPanel extends JPanel{

	private Artikal artikal;

	private Narudzbenica order;
	
	public ArtikalBuyPanel(Artikal artikal, Narudzbenica order) {
		super();
		this.artikal = artikal;
		this.order = order;
		
		
		this.setLayout(new BorderLayout());
		
		JLabel nl = new JLabel(this.artikal.getNaziv());
		this.add(nl, BorderLayout.NORTH);
		
		JButton ab = new JButton("Dodaj");
		this.add(ab, BorderLayout.SOUTH);
		
		ab.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				order.dodajStavku(artikal);
			}
		});
		
		
		
		
	}
	
	
	
}
