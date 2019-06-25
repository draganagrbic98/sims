package gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import model.Narudzbenica;

public class NarudzbenicaPanel extends JPanel{
	
	private Narudzbenica narudzbenica;
	private CenterPanel centerPanel;
	
	public NarudzbenicaPanel(Narudzbenica narudzbenica, CenterPanel centerPanel) {
		
		this.narudzbenica = narudzbenica;
		this.centerPanel = centerPanel;
		this.setLayout(new BorderLayout());
		

		JLabel nl = new JLabel(this.narudzbenica.getBroj() + "");
		this.add(nl, BorderLayout.NORTH);
		JButton ob = new JButton("Vise informacija");
		this.add(ob, BorderLayout.SOUTH);
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
