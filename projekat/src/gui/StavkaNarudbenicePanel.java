package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Narudzbenica;
import model.StavkaNarudzbenice;

public class StavkaNarudbenicePanel extends JPanel{
	
	private Narudzbenica order;
	private StavkaNarudzbenice stavka;
	
	public StavkaNarudbenicePanel(Narudzbenica order, StavkaNarudzbenice stavka) {
		super();
		this.order = order;
		this.stavka = stavka;
		
		this.setLayout(new BorderLayout());
		
		JLabel nl = new JLabel(this.stavka.getArtikal().getNaziv());
		this.add(nl, BorderLayout.NORTH);
		
		
		JLabel al = new JLabel("Kolicina: ");
		this.add(al);
		JTextField atf = new JTextField();
		atf.setText(stavka.getKolicina() + "");
		atf.setEditable(false);
		this.add(atf);
		
		
		JButton rb = new JButton("Obrisi");
		this.add(rb, BorderLayout.SOUTH);

		rb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				order.obrisiStavku(stavka);
			}
		});
		
		
	}
	
	

}
