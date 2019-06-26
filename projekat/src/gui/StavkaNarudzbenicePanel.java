package gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import model.Narudzbenica;
import model.StavkaNarudzbenice;
import net.miginfocom.swing.MigLayout;

public class StavkaNarudzbenicePanel extends JPanel {

	private Narudzbenica narudzbenica;
	private StavkaNarudzbenice stavka;

	public StavkaNarudzbenicePanel(Narudzbenica narudzbenica, StavkaNarudzbenice stavka) {
		
		super();
		this.narudzbenica = narudzbenica;
		this.stavka = stavka;

		this.setLayout(new MigLayout("fill"));
		this.setSize(250, 150);
		this.setMinimumSize(this.getSize());
		this.setMaximumSize(this.getSize());

		Border raisedbevel = BorderFactory.createRaisedBevelBorder();
		Border loweredbevel = BorderFactory.createLoweredBevelBorder();
		this.setBorder(BorderFactory.createCompoundBorder(raisedbevel, loweredbevel));

		JLabel nl = new JLabel(this.stavka.getArtikal().getNaziv());
		this.add(nl, "al center, wrap");

		JLabel al = new JLabel("Kolicina: ");
		this.add(al, "al center, split2");

		JTextField atf = new JTextField();
		atf.setText(stavka.getKolicina() + "");
		atf.setEditable(false);
		this.add(atf);

		JButton rb = new JButton("Obrisi");
		this.add(rb, "al center, wrap");

		rb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				narudzbenica.obrisiStavku(stavka);
			}
		});

	}

}
