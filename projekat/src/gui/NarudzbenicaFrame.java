package gui;

import java.awt.BorderLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;

import model.Artikal;
import model.Kupac;
import model.Narudzbenica;
import model.StavkaNarudzbenice;
import model.enumi.ButtonEnabled;
import net.miginfocom.swing.MigLayout;

public class NarudzbenicaFrame extends JPanel implements Observer {

	private static int minw_l = 150;
	private static int minh_l = 25;
	private static int minw_tf = 200;
	private static int minh_tf = 25;
	
	private Narudzbenica order;
	private JTextField productsNumber;
	private JTextField totalPrice;
	private JButton addProductButton;
	private JButton removeProductButton;
	private JButton finishButton;
	private JButton buyButton;
	private CenterPanel centerPanel;
	private JTextField stateName;
	private JButton deleteOrderButton;
	

	public NarudzbenicaFrame(Narudzbenica order, CenterPanel centerPanel) {

		this.order = order;
		this.centerPanel = centerPanel;

		this.order.addObserver(this);

		this.setLayout(new MigLayout("fill"));

		JLabel nl = new JLabel("Broj narudzbenice: ");
		nl.setSize(minw_l, minh_l);
		nl.setMinimumSize(nl.getSize());
		this.add(nl, "al center, pushx, split2");
		
		JTextField ntf = new JTextField();
		ntf.setText(order.getBroj() + "");
		ntf.setEditable(false);
		ntf.setSize(minw_tf, minh_tf);
		ntf.setMinimumSize(ntf.getSize());
		this.add(ntf, "al center, pushx, wrap");

		JLabel pnl = new JLabel("Ukupan broj artikala: ");
		pnl.setSize(minw_l, minh_l);
		pnl.setMinimumSize(pnl.getSize());
		this.add(pnl, "al center, pushx, split2");
		
		productsNumber = new JTextField();
		productsNumber.setText(order.getBrojArtikala() + "");
		productsNumber.setEditable(false);
		productsNumber.setSize(minw_tf, minh_tf);
		productsNumber.setMinimumSize(productsNumber.getSize());
		this.add(productsNumber, "al center, pushx, wrap");
		
		JLabel cnl = new JLabel("Ukupana cena: ");
		cnl.setSize(minw_l, minh_l);
		cnl.setMinimumSize(cnl.getSize());
		this.add(cnl, "al center, pushx, split2");
		
		totalPrice = new JTextField();
		totalPrice.setText(order.getUkupnaCenaNarudzbenice() + "");
		totalPrice.setEditable(false);
		totalPrice.setSize(minw_tf, minh_tf);
		totalPrice.setMinimumSize(totalPrice.getSize());
		this.add(this.totalPrice, "al center, pushx, wrap");
		
		JLabel al = new JLabel("Adresa isporuke: ");
		al.setSize(minw_l, minh_l);
		al.setMinimumSize(al.getSize());
		this.add(al, "al center, pushx, split2");

		JTextField atf = new JTextField();
		atf.setText(order.getAdresa() + "");
		atf.setEditable(false);
		atf.setSize(minw_tf, minh_tf);
		atf.setMinimumSize(atf.getSize());
		this.add(atf, "al center, pushx, wrap");
		
		JLabel sl = new JLabel("Stanje narudzbenice: ");
		sl.setSize(minw_l, minh_l);
		sl.setMinimumSize(sl.getSize());
		this.add(sl, "al center, pushx, split2");
		
		stateName = new JTextField();
		stateName.setText(order.getStanje().getClass().getSimpleName() + "");
		stateName.setEditable(false);
		stateName.setSize(minw_tf, minh_tf);
		stateName.setMinimumSize(stateName.getSize());
		this.add(this.stateName, "al center, pushx, wrap");

		this.addProductButton = new JButton("Dodaj artikal");
		this.add(this.addProductButton, "al center, pushx, split2");

		this.removeProductButton = new JButton("Obrisi artikal");
		this.add(this.removeProductButton, "al center, pushx, wrap, gapx 10px");

		this.finishButton = new JButton("Zavrsi");
		this.add(this.finishButton, "al center, pushx, split2");

		this.buyButton = new JButton("Kupi");
		this.add(this.buyButton, "al center, pushx, wrap, gapx 10px");

		switch (this.order.getStanje().getClass().getSimpleName()) {
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
				
				JPanel sviArtikli = new JPanel(new MigLayout("gap 5px 10px"));
				JScrollPane scrollSviArtikli = new JScrollPane(sviArtikli);
				
				scrollSviArtikli.getVerticalScrollBar().setUnitIncrement(10);
				scrollSviArtikli.getHorizontalScrollBar().setUnitIncrement(10);
				
				int brojac = 0;

				for (Artikal a : centerPanel.getWebShop().getArtikli()) {
					if (brojac == 1) {
						sviArtikli.add(new ArtikalBuyPanel(a, order), "al center, pushx, split 2, wrap");
						brojac = 0;
						continue;
					} else {
						sviArtikli.add(new ArtikalBuyPanel(a, order), "al center, pushx, split 2");
					}
					++brojac;
				}
				
				temp.setLayout(new BorderLayout());
				temp.setSize(550, 550);
				temp.setLocationRelativeTo(null);

				temp.add(scrollSviArtikli, BorderLayout.CENTER);
				
				temp.setVisible(true);
			}
		});

		this.removeProductButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				JFrame temp = new JFrame();
				
				JPanel sveStavke = new JPanel(new MigLayout("gap 5px 10px"));
				JScrollPane scrollSveStavke = new JScrollPane(sveStavke);
				
				scrollSveStavke.getVerticalScrollBar().setUnitIncrement(10);
				scrollSveStavke.getHorizontalScrollBar().setUnitIncrement(10);
				
				int brojac = 0;

				for (StavkaNarudzbenice sn : order.getStavke()) {
					if (brojac == 1) {
						sveStavke.add(new StavkaNarudbenicePanel(order, sn), "al center, pushx, split 2, wrap");
						brojac = 0;
						continue;
					} else {
						sveStavke.add(new StavkaNarudbenicePanel(order, sn), "al center, pushx, split 2");
					}
					++brojac;
				}
				
				temp.setLayout(new BorderLayout());
				temp.setSize(550, 550);
				temp.setLocationRelativeTo(null);

				temp.add(scrollSveStavke, BorderLayout.CENTER);
				
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
				// dodaj dijalog za unos para itd...
			}
		});

		this.deleteOrderButton = new JButton("Obrisi narudzbenicu");
		this.add(this.deleteOrderButton, "al center, pushx, wrap");
		
		this.deleteOrderButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int dialogButton = JOptionPane.YES_NO_OPTION;
				int dialogResult = JOptionPane.showConfirmDialog (null, "Da li ste sigurni?","Upozorenje",dialogButton);
				
				if(dialogResult == JOptionPane.YES_OPTION){
					Kupac customer = centerPanel.getCurrentUser().getKupac();
					customer.removeNarudzbenice(order);
					centerPanel.getWebShop().removeNarudzbenice(order);
					// JEL OVO OK???????
					centerPanel.setOrdersPanel();
				}
			}
		});
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		if (arg instanceof ButtonEnabled) {
			ButtonEnabled be = (ButtonEnabled) arg;
			switch (be) {
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
		} else if (arg instanceof String) {
			this.stateName.setText((String) arg);

		} else {
			int pn = (Integer) arg;
			this.productsNumber.setText(pn + "");
			this.totalPrice.setText(order.getUkupnaCenaNarudzbenice() + "");
		}

		this.centerPanel.refresh();
	}

}
