package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import model.Artikal;
import model.Cenovnik;
import model.Korisnik;
import model.Kupac;
import model.Mesto;
import model.StavkaCenovnika;
import model.Uloga;
import model.WebShop;
import net.miginfocom.swing.MigLayout;

public class CenterPanel extends JPanel{

	private NorthPanel northPanel;
	private WebShop webShop;
	
	
	
	public WebShop getWebShop() {
		return webShop;
	}

	public void setWebShop(WebShop webShop) {
		this.webShop = webShop;
	}

	private void refresh() {
		
		this.revalidate();
		this.repaint();
		
	}
	
	public NorthPanel getNorthPanel() {
		return northPanel;
	}

	public void setNorthPanel(NorthPanel northPanel) {
		this.northPanel = northPanel;
	}

	public CenterPanel(WebShop webShop) {
		super();
		this.webShop = webShop;
		this.northPanel = new NorthPanel(this);
	}

	private void setDefault() {
		
		this.removeAll();
		this.setLayout(new MigLayout("fill"));
		
	}
	
	public void setWelcomeMessage() {
		
		this.setDefault();
		this.add(new JLabel("DOBRODOSLI!!"), "align center, wrap");
		this.add(new JLabel("Web Shop"), "align center, wrap");
		this.add(new JLabel("Povoljne cene!!"), "align center, wrap");
		this.add(new JLabel("Povoljne akcije!!"), "align center, wrap");
		this.add(new JLabel("Sve sto Vam treba!"), "align center, wrap");
		this.add(new JLabel("Tu smo za Vas!"), "align center, wrap");
		this.refresh();
		
	}
	
	
	
	private void setSignedUpMessage() {
		
		this.setDefault();
		this.add(new JLabel("DOBRODOSLI!!"), "align center, wrap");
		this.add(new JLabel("Uspesno ste se ulogovali"), "align center, wrap");
		this.refresh();

		
	}
	
	public void setProduct(Artikal product) {
		
		//ovde ces sve o artiklu da napises...
		
		this.setDefault();
		
		
		JLabel anl = new JLabel(product.getNaziv());
		this.add(anl, "growx, wrap");
		
		JPanel picture = new JPanel(new MigLayout("fill"));
		picture.setBackground(Color.DARK_GRAY);
		JTextField pictureName = new JTextField("Slika");
		pictureName.setEditable(false);
		picture.add(pictureName, "growx, growy");
		this.add(picture, "growx, growy, wrap");
		
		JLabel dl = new JLabel("Opis: ");
		this.add(dl);
		
		JTextField dtf = new JTextField();
		dtf.setText(product.getOpis());
		dtf.setEditable(false);
		this.add(dtf, "growx, wrap");
		
		
		JLabel pl = new JLabel("Cena: ");
		this.add(pl);
		JTextField ptf = new JTextField();
		ptf.setText(product.getCena() == null ? "nema" : product.getCena().getCena() + "");
		ptf.setEditable(false);
		this.add(ptf, "growx, wrap");
		
		
		this.refresh();
		
	}
	
	public void setProducts(Collection<Artikal> products) {
		
		

		
		if (products.isEmpty()) {
			this.setDefault();
			this.add(new JLabel("NEMA ARTIKALA"), "align center, wrap");
			this.refresh();
			return;
		}

		this.removeAll();

		this.setLayout(new GridLayout(0, 4));
		
		for (Artikal a: products)
			this.add(new ArtikalPanel(a, this));
		
		this.refresh();
		
	}
	
	private boolean emptyTextField(JTextField... textFields) {
		
		for (JTextField jtf: textFields) {
			if (jtf.getText().equals(""))
				return true;
		}
		return false;
		
	}
	
	public void setSignUpPanel() {
		
		this.setDefault();
		
		JLabel sul = new JLabel("REGISTRACIJA");
		this.add(sul, "growx, wrap");
		
		JLabel nl = new JLabel("Ime: ");
		this.add(nl);
		JTextField ntf = new JTextField();
		this.add(ntf, "growx, wrap");
		
		JLabel sl = new JLabel("Prezime");
		this.add(sl);
		JTextField stf = new JTextField();
		this.add(stf, "growx, wrap");
		
		JLabel el = new JLabel("Email: ");
		this.add(el);
		JTextField etf = new JTextField();
		this.add(etf, "growx, wrap");
		
		JLabel al = new JLabel("Adresa: ");
		this.add(al);
		JTextField atf = new JTextField();
		this.add(atf, "growx, wrap");
		
		JLabel unl = new JLabel("Korisnicko ime: ");
		this.add(unl);
		JTextField untf = new JTextField();
		this.add(untf, "growx, wrap");
		
		JLabel psl = new JLabel("Lozinka: ");
		this.add(psl);
		JTextField pstf = new JTextField();
		this.add(pstf, "growx, wrap");
		
		JLabel pl = new JLabel("Mesto: ");
		this.add(pl);
		JTextField ptf = new JTextField();
		this.add(ptf, "growx, wrap");
		
		JButton sub = new JButton("Registruj se");
		this.add(sub);
		
		sub.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (emptyTextField(ntf, stf, etf, atf, untf, pstf, ptf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska", JOptionPane.ERROR_MESSAGE);
				
				else if (webShop.nadjiKorisnika(untf.getText()) != null)
					JOptionPane.showMessageDialog(null, "Uneto korisnicko ime vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);

				else {
					webShop.dodajKorisnika(untf.getText(), pstf.getText(), Uloga.kupac, new Kupac(ntf.getText(), stf.getText(), etf.getText(), atf.getText(), new Mesto(ptf.getText())));


					logIn(Uloga.kupac);
				}
				
					

			}
		});
		
		this.refresh();

		
	}
	
	private void logIn(Uloga uloga) {
		
		switch(uloga) {
		case administrator:
			northPanel.setAdministratorPanel();
			break;
		case menadzer:
			northPanel.setManagerPanel();
			break;
		default:
			northPanel.setCustomerPanel();
		}
		setSignedUpMessage();
		
		
		
	}
	
	public void setSignInPanel() {
		
		this.setDefault();
		
		JLabel sil = new JLabel("PRIJAVA");
		this.add(sil, "growx, wrap");
		
		JLabel unl = new JLabel("Korisnicko ime: ");
		this.add(unl);
		JTextField untf = new JTextField();
		this.add(untf, "growx, wrap");
		
		JLabel psl = new JLabel("Lozinka: ");
		this.add(psl);
		JTextField pstf = new JTextField();
		this.add(pstf, "growx, wrap");

		JButton sib = new JButton("Prijavi se");
		this.add(sib);
		
		
		sib.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emptyTextField(untf, pstf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska", JOptionPane.ERROR_MESSAGE);
				
				else {
					Korisnik k = webShop.nadjiKorisnika(untf.getText(), pstf.getText());
					if (k == null)
						JOptionPane.showMessageDialog(null, "Nepostojec korisnik!", "Greska", JOptionPane.ERROR_MESSAGE);
					else {
						logIn(k.getUloga());

					}
				}

				
			}
		});
		
		this.refresh();

	}
	
	public void setManagersPanel() {
		

		this.removeAll();
		this.setLayout(new BorderLayout());
		
		JTable table = new JTable(new ManagerModel(this.webShop.getMenadzeri()));
		table.setAutoCreateRowSorter(true);
		JScrollPane sp = new JScrollPane(table);
		this.add(sp);
		this.refresh();
		
	}
	
	public void setCreateManagerPanel() {
		
		this.setDefault();
		
		JLabel cml = new JLabel("KREIRANJE MENADZERA");
		this.add(cml, "growx, wrap");
		
		JLabel unl = new JLabel("Korisnicko ime: ");
		this.add(unl);
		JTextField untf = new JTextField();
		this.add(untf, "growx, wrap");
		
		JLabel psl = new JLabel("Lozinka: ");
		this.add(psl);
		JTextField pstf = new JTextField();
		this.add(pstf, "growx, wrap");
		
		JButton cmb = new JButton("Kreiraj menadzera");
		this.add(cmb);
		
		cmb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emptyTextField(untf, pstf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska", JOptionPane.ERROR_MESSAGE);
				
				else if (webShop.nadjiKorisnika(untf.getText()) != null)
					JOptionPane.showMessageDialog(null, "Uneto korisnicko ime vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);

				else {
					webShop.dodajKorisnika(untf.getText(), pstf.getText(), Uloga.menadzer);

					JOptionPane.showMessageDialog(null, "Menadzer kreiran", "", JOptionPane.INFORMATION_MESSAGE);


				}
			}
		});
		
		this.refresh();
		
	}
	
	public void setDeleteManagerPanel() {
		
		this.setDefault();
		
		JLabel dml = new JLabel("BRISANJE MENADZERA");
		this.add(dml, "growx, wrap");
		
		JLabel unl = new JLabel("Korisnicko ime: ");
		JTextField untf = new JTextField();
		this.add(unl);
		this.add(untf, "growx, wrap");
		
		JButton cmb = new JButton("Obrisi menadzera");
		this.add(cmb);
		
		cmb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emptyTextField(untf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska", JOptionPane.ERROR_MESSAGE);
				else {
					Korisnik k = webShop.nadjiKorisnika(untf.getText());
					if (k == null || k.getUloga() != Uloga.menadzer)
						JOptionPane.showMessageDialog(null, "Unet menadzer ne postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
					else {
						webShop.obrisiKorisnika(untf.getText());
						JOptionPane.showMessageDialog(null, "Menadzer obrisan", "", JOptionPane.INFORMATION_MESSAGE);

					}
				}
			}
		});
		
		this.refresh();
		
	}
			
	public void setCreateProductPanel() {
		
		this.setDefault();
		
		JLabel cpl = new JLabel("KREIRANJE ARTIKLA");
		this.add(cpl, "growx, wrap");
		
		JLabel cl = new JLabel("Sifra: ");
		this.add(cl);
		JTextField ctf = new JTextField();
		this.add(ctf, "growx, wrap");
		
		JLabel nl = new JLabel("Naziv: ");
		this.add(nl);
		JTextField ntf = new JTextField();
		this.add(ntf, "growx, wrap");
		
		JLabel dl = new JLabel("Opis: ");
		this.add(dl);
		JTextField dtf = new JTextField();
		this.add(dtf, "growx, wrap");
		
		JButton cpb = new JButton("Kreiraj artikal");
		this.add(cpb);
		
		//dodaj proveru da li je unet ceo broj za sifru artikla
		
		
		cpb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emptyTextField(ctf, ntf, dtf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska", JOptionPane.ERROR_MESSAGE);
				else {
					Artikal a = webShop.nadjiArtikal(Integer.parseInt(ctf.getText()));
					if (a != null)
						JOptionPane.showMessageDialog(null, "Artikal vec postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
					else {
						webShop.dodajArtikal(Integer.parseInt(ctf.getText()), ntf.getText(), dtf.getText());
						JOptionPane.showMessageDialog(null, "Artikal kreiran!", "", JOptionPane.INFORMATION_MESSAGE);

					}
				}
			}
		});
		
		this.refresh();
		
	}
	
	public void setDeleteProductPanel() {
		
		this.setDefault();
		
		JLabel dpl = new JLabel("BRISANJE ARTIKLA");
		this.add(dpl, "growx, wrap");
		
		JLabel cl = new JLabel("Sifra: ");
		this.add(cl);
		JTextField ctf = new JTextField();
		this.add(ctf, "growx, wrap");
		
		JButton dpb = new JButton("Obrisi artikal");
		this.add(dpb);
		
		dpb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emptyTextField(ctf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska", JOptionPane.ERROR_MESSAGE);
				else {
					//dodaj da proverava da li je unet ceo broj za sifru artikla
					Artikal a = webShop.nadjiArtikal(Integer.parseInt(ctf.getText()));
					if (a == null)
						JOptionPane.showMessageDialog(null, "Unet artikal ne postoji!", "Greska", JOptionPane.ERROR_MESSAGE);
					else {
						//u modelu pre brisanja artikla mi fale sve metode
						webShop.obrisiArtikal(Integer.parseInt(ctf.getText()));
						JOptionPane.showMessageDialog(null, "Artikal obrisan!", "", JOptionPane.INFORMATION_MESSAGE);

					}
				}
			}
		});
		
		this.refresh();
		
	}
	
	public void setAddPricePanel() {
		
		
		this.setDefault();
		
		if (webShop.getCenovnici().isEmpty()) {
			this.add(new JLabel("NEMA CENOVNIKA"), "align center");
			this.refresh();
			return;
			
		}
		
		String[] array = new String[this.webShop.artikliSaStaromCenom().size()];
		int i = 0;
		for (Artikal a: this.webShop.artikliSaStaromCenom())
			array[i++] = a.getSifra() + "";
		JComboBox<String> cb = new JComboBox<String>(array);
		this.add(cb, "growx, wrap");
		//dodaj da se ne moze dodati cena ako ne postoji cenovnik
		Cenovnik cenovnik = this.webShop.getCenovnik();
		Collection<StavkaCenovnika> stavke = new ArrayList<>();

		this.setPricePanel(cb, stavke, cenovnik);
		
		cenovnik.dodajStavke(stavke);
		
		
		this.refresh();
		
	}
	
	private void setPricePanel(JComboBox<String> cb, Collection<StavkaCenovnika> stavke, Cenovnik cenovnik) {
		
		JLabel cl = new JLabel("Sifra: ");
		this.add(cl);
		JTextField ctf = new JTextField();
		ctf.setEditable(false);
		this.add(ctf, "growx, wrap");
		
		JLabel pl = new JLabel("Cena: ");
		//dodaj proveru da je unet broj
		this.add(pl);
		JTextField ptf = new JTextField();
		this.add(ptf, "growx, wrap");
		
		JButton apb = new JButton("Dodaj cenu");
		this.add(apb, "growx, wrap");
		

		
		
		apb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emptyTextField(ctf, ptf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska", JOptionPane.ERROR_MESSAGE);
				else {
					StavkaCenovnika sc = new StavkaCenovnika(webShop.nadjiArtikal(Integer.parseInt(ctf.getText())), Double.parseDouble(ptf.getText()), cenovnik);
					stavke.add(sc);
					cb.removeItemAt(cb.getSelectedIndex());
					JOptionPane.showMessageDialog(null, "Cena dodata!", "", JOptionPane.INFORMATION_MESSAGE);

				}
			}
		});
		
		
		cb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				ctf.setText((String) ((JComboBox)e.getSource()).getSelectedItem());
			}
		});

		
	}
	
	public void setCreatePriceListPanel() {
		
		this.setDefault();
		String[] array = new String[this.webShop.getArtikli().size()];
		int i = 0;
		for (Artikal a: this.webShop.getArtikli())
			array[i++] = a.getSifra() + "";
		JComboBox<String> cb = new JComboBox<String>(array);
		this.add(cb, "growx, wrap");
		Cenovnik cenovnik = new Cenovnik();
		Collection<StavkaCenovnika> stavke = new ArrayList<>();
		
		
		

		
		
		this.setPricePanel(cb, stavke, cenovnik);
		
		JButton cplb = new JButton("Kreiraj cenovnik");
		this.add(cplb, "growx, wrap");
		cplb.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				cenovnik.dodajStavke(stavke);
				
				webShop.dodajCenovnik(cenovnik);
				JOptionPane.showMessageDialog(null, "Cenovnik kreiran!", "", JOptionPane.INFORMATION_MESSAGE);
				setDefault();
				refresh();	//VAU
			}
		});
		
		
		this.refresh();
		
		
		
	}
	
	
	
	public void setBusketPanel() {
		
		
		
	}
	
	public void setBoughtPanel() {
		
		
		
	}


	public void setCreateOrderPanel() {
		
	}
	
			
	
}
