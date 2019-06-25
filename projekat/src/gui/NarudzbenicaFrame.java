package gui;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.Artikal;
import model.Kupac;
import model.Narudzbenica;
import model.StavkaNarudzbenice;
import net.miginfocom.swing.MigLayout;

public class NarudzbenicaFrame extends JPanel implements Observer{

	private Narudzbenica order;
	private JTextField productsNumber;
	private JButton addProductButton;
	private JButton removeProductButton;
	private JButton finishButton;
	private JButton buyButton;
	private CenterPanel centerPanel;
	private JLabel stateNameLabel;
	private JButton deleteOrderButton;
	
	
	

	public NarudzbenicaFrame(Narudzbenica order, CenterPanel centerPanel) {
		
		this.order = order;
		this.centerPanel = centerPanel;
		
		this.order.addObserver(this);

		
		this.setLayout(new MigLayout("fill"));
		
		JLabel nl = new JLabel(order.getBroj() + "");
		this.add(nl);
		JLabel al = new JLabel(order.getAdresa() + "");
		this.add(al);
		
		

		//System.out.println(order.getStanje());
		this.stateNameLabel = new JLabel(order.getStanje().getClass().getSimpleName() + "");
		this.add(this.stateNameLabel, "growx, wrap");
				
		
		JLabel pnl = new JLabel("Ukupan broj artikala: ");
		this.add(pnl);
		this.productsNumber = new JTextField();
		this.productsNumber.setText(order.getBrojArtikala() + "");
		this.productsNumber.setEnabled(false);
		this.add(this.productsNumber, "growx, wrap");
		

		
		this.addProductButton = new JButton("Dodaj artikal");
		this.add(this.addProductButton);
				
		this.removeProductButton = new JButton("Obrisi artikal");
		this.add(this.removeProductButton);
				
		this.finishButton = new JButton("Zavrsi");
		this.add(this.finishButton);
				
		this.buyButton = new JButton("Kupi");
		this.add(this.buyButton, "wrap");

		switch(this.order.getStanje().getClass().getSimpleName()) {
		case "Zavrsetak":
			this.addProductButton.setEnabled(false);
			this.removeProductButton.setEnabled(false);
			this.finishButton.setEnabled(false);


			break;
		case "Naruceno":
			this.addProductButton.setEnabled(false);
			this.removeProductButton.setEnabled(false);
			this.finishButton.setEnabled(false);
			this.buyButton.setEnabled(false);
			System.out.println(this.buyButton);
			this.deleteOrderButton.setEnabled(false);

			break;
		default:
			this.buyButton.setEnabled(false);
			if (this.order.getBrojArtikala() == 0) {
				this.removeProductButton.setEnabled(false);
				this.finishButton.setEnabled(false);
				
			}
		}

		
		this.addProductButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame temp = new JFrame();
				temp.setLayout(new MigLayout("fill"));
				temp.setSize(500, 500);
				temp.setLocationRelativeTo(null);
				for (Artikal a: centerPanel.getWebShop().getArtikli())
					temp.add(new ArtikalBuyPanel(a, order));
				temp.setVisible(true);
			}
		});
		
		
		this.removeProductButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame temp = new JFrame();
				temp.setLayout(new MigLayout("fill"));
				temp.setSize(500, 500);
				temp.setLocationRelativeTo(null);
				
				for (StavkaNarudzbenice sn: order.getStavke())
					temp.add(new StavkaNarudbenicePanel(order, sn));
				
				temp.setVisible(true);
				
			}
		});
		
		this.finishButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				order.aktiviranZavrsetak();
			}
		});
		
		this.buyButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				order.obavljenoPlacanje();
				//dodaj dijalog za unos para itd...
			}
		});
		
		this.deleteOrderButton = new JButton("Obrisi narudzbenicu");
		this.add(this.deleteOrderButton);
		//dodaj proveru da li je siguran da oce da obrise narudzbenicu
		
		
		this.deleteOrderButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				Kupac customer = centerPanel.getCurrentUser().getKupac();
				customer.removeNarudzbenice(order);
				centerPanel.getWebShop().removeNarudzbenice(order);
				//JEL OVO OK???????
				centerPanel.setOrdersPanel();
				
			}
		});
		
	}



	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof ButtonEnabled) {
			ButtonEnabled be = (ButtonEnabled) arg;
			switch(be) {
			case ADD_PRODUCT_DISABLE:
				this.addProductButton.setEnabled(false);
				break;
			case REMOVE_PRODUCT_ENABLE:
				this.removeProductButton.setEnabled(true);
				break;
			case REMOVE_PRODUCT_DISABLE:
				this.removeProductButton.setEnabled(false);
				break;
			case FINISH_ENABLE:
				this.finishButton.setEnabled(true);
				break;
			case FINISH_DISABLE:
				this.finishButton.setEnabled(false);
				break;
			case BUY_ENABLE:
				this.buyButton.setEnabled(true);
				break;
			case BUY_DISABLE:
				this.buyButton.setEnabled(false);
				break;
			default:
				this.deleteOrderButton.setEnabled(false);
				
			}
		}
		else if (arg instanceof String) {
			this.stateNameLabel.setText((String) arg);
			
		}
		else {
			int pn = (Integer) arg;
			this.productsNumber.setText(pn + "");
		}
		
		this.centerPanel.refresh();
	}
	
	
	

}
