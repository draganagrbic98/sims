package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;

import model.Narudzbenica;
import net.miginfocom.swing.MigLayout;

public class NarudzbenicaPanel extends JPanel {

	private Narudzbenica narudzbenica;
	private CenterPanel centerPanel;

	public NarudzbenicaPanel(Narudzbenica narudzbenica, CenterPanel centerPanel) {

		this.narudzbenica = narudzbenica;
		this.centerPanel = centerPanel;
		this.setLayout(new MigLayout("fill"));

		this.setSize(250, 250);
		this.setMinimumSize(this.getSize());
		this.setMaximumSize(this.getSize());
		
		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		this.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));

		JLabel nl = new JLabel("Broj narudzbenice: " + this.narudzbenica.getBroj());
		nl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		this.add(nl, "al center, wrap");
		
		JLabel pnl = new JLabel("Ukupan broj artikala: " + this.narudzbenica.getBrojArtikala());
		pnl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		this.add(pnl, "al center, wrap");
		
		JLabel cnl = new JLabel("Ukupana cena: " + this.narudzbenica.getUkupnaCenaNarudzbenice());
		cnl.setFont(new Font("Times New Roman", Font.BOLD, 18));
		this.add(cnl, "al center, wrap");
		
		JButton ob = new JButton("Vise informacija");
		this.add(ob, "al center, wrap");
		
		ob.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println(centerPanel);
				centerPanel.setOrder(narudzbenica);
			}
		});

	}

}
