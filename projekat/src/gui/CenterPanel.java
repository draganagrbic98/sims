package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
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
import model.Narudzbenica;
import model.StavkaCenovnika;
import model.WebShop;
import model.enumi.Uloga;
import net.miginfocom.swing.MigLayout;

public class CenterPanel extends JPanel {
	private static int minw_l = 100;
	private static int minh_l = 25;
	private static int minw_tf = 200;
	private static int minh_tf = 25;
	private NorthPanel northPanel;
	private WebShop webShop;
	private Korisnik currentUser;

	public Korisnik getCurrentUser() {
		return currentUser;
	}

	public WebShop getWebShop() {
		return webShop;
	}

	public void setWebShop(WebShop webShop) {
		this.webShop = webShop;
	}

	public void refresh() {

		this.revalidate();
		this.repaint();
		// public da bi ga zvao narudbenica frame

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
		BufferedImage main_pic = null;

		try {
			main_pic = ImageIO.read(new File("main_img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(main_pic));
		this.add(picLabel, "left, push, grow");
		this.refresh();

	}

	private void setSignedUpMessage() {

		this.setDefault();
		BufferedImage logon_pic = null;

		try {
			logon_pic = ImageIO.read(new File("logon_img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(logon_pic));
		this.add(picLabel, "left, push, grow");
		this.refresh();

	}

	public void setOrder(Narudzbenica order) {

		// OVO OVDE URADIIIIIIIIIIII

		this.setDefault();

		NarudzbenicaFrame nf = new NarudzbenicaFrame(order, this);
		System.out.println(order);
		this.add(nf, "growx, growy");

		this.refresh();

	}

	public void setProduct(Artikal product) {

		// ovde ces sve o artiklu da napises...

		this.setDefault();

		BufferedImage art_pic = null;

		try {
			art_pic = ImageIO.read(new File("art_default_img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(art_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel anl = new JLabel("Naziv: ");
		anl.setSize(minw_l, minh_l);
		anl.setMinimumSize(anl.getSize());
		this.add(anl, "al center, pushx, split2");

		JTextField atf = new JTextField();
		atf.setText(product.getNaziv());
		atf.setEditable(false);
		atf.setSize(minw_tf, minh_tf);
		atf.setMinimumSize(atf.getSize());
		this.add(atf, "al center, pushx, wrap");

		JLabel dl = new JLabel("Opis: ");
		dl.setSize(minw_l, minh_l);
		dl.setMinimumSize(dl.getSize());
		this.add(dl, "al center, pushx, split2");

		JTextField dtf = new JTextField();
		dtf.setText(product.getOpis());
		dtf.setEditable(false);
		dtf.setSize(minw_tf, minh_tf);
		dtf.setMinimumSize(dtf.getSize());
		this.add(dtf, "al center, pushx, wrap");

		JLabel pl = new JLabel("Cena: ");
		pl.setSize(minw_l, minh_l);
		pl.setMinimumSize(pl.getSize());
		this.add(pl, "al center, pushx, split2");

		JTextField ptf = new JTextField();
		ptf.setText(product.getCena() == null ? "nema" : product.getCena().getCena() + "");
		ptf.setEditable(false);
		ptf.setSize(minw_tf, minh_tf);
		ptf.setMinimumSize(ptf.getSize());
		this.add(ptf, "al center, pushx, wrap");

		this.refresh();

	}

	public void setProducts(Collection<Artikal> products) {

		if (products.isEmpty()) {
			this.setDefault();
			this.add(new JLabel("Nema artikala!"), "align center, wrap");
			this.refresh();
			return;
		}

		this.removeAll();

		this.setLayout(new MigLayout("gap 5px 10px"));

		int brojac = 0;

		for (Artikal a : products) {
			if (brojac == 1) {
				this.add(new ArtikalPanel(a, this), "al center, pushx, split 2, wrap");
				brojac = 0;
				continue;
			} else {
				this.add(new ArtikalPanel(a, this), "al center, pushx, split 2");
			}
			++brojac;
		}

		this.refresh();

	}

	private boolean emptyTextField(JTextField... textFields) {

		for (JTextField jtf : textFields) {
			if (jtf.getText().equals(""))
				return true;
		}
		return false;

	}

	public void setSignUpPanel() {

		this.setDefault();

		BufferedImage reg_pic = null;

		try {
			reg_pic = ImageIO.read(new File("reg_img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(reg_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel nl = new JLabel("Ime: ");
		nl.setSize(minw_l, minh_l);
		nl.setMinimumSize(nl.getSize());
		this.add(nl, "al center, pushx, split2");

		JTextField ntf = new JTextField();
		ntf.setSize(minw_tf, minh_tf);
		ntf.setMinimumSize(ntf.getSize());
		this.add(ntf, "al center, pushx, wrap");

		JLabel sl = new JLabel("Prezime");
		sl.setSize(minw_l, minh_l);
		sl.setMinimumSize(sl.getSize());
		this.add(sl, "al center, pushx, split2");

		JTextField stf = new JTextField();
		stf.setSize(minw_tf, minh_tf);
		stf.setMinimumSize(stf.getSize());
		this.add(stf, "al center, pushx, wrap");

		JLabel el = new JLabel("Email: ");
		el.setSize(minw_l, minh_l);
		el.setMinimumSize(el.getSize());
		this.add(el, "al center, pushx, split2");

		JTextField etf = new JTextField();
		etf.setSize(minw_tf, minh_tf);
		etf.setMinimumSize(etf.getSize());
		this.add(etf, "al center, pushx, wrap");

		JLabel al = new JLabel("Adresa: ");
		al.setSize(minw_l, minh_l);
		al.setMinimumSize(al.getSize());
		this.add(al, "al center, pushx, split2");

		JTextField atf = new JTextField();
		atf.setSize(minw_tf, minh_tf);
		atf.setMinimumSize(atf.getSize());
		this.add(atf, "al center, pushx, wrap");

		JLabel pl = new JLabel("Mesto: ");
		pl.setSize(minw_l, minh_l);
		pl.setMinimumSize(pl.getSize());
		this.add(pl, "al center, pushx, split2");

		JTextField ptf = new JTextField();
		ptf.setSize(minw_tf, minh_tf);
		ptf.setMinimumSize(ptf.getSize());
		this.add(ptf, "al center, pushx, wrap");

		JLabel unl = new JLabel("Korisnicko ime: ");
		unl.setSize(minw_l, minh_l);
		unl.setMinimumSize(unl.getSize());
		this.add(unl, "al center, pushx, split2");

		JTextField untf = new JTextField();
		untf.setSize(minw_tf, minh_tf);
		untf.setMinimumSize(untf.getSize());
		this.add(untf, "al center, pushx, wrap");

		JLabel psl = new JLabel("Lozinka: ");
		psl.setSize(minw_l, minh_l);
		psl.setMinimumSize(psl.getSize());
		this.add(psl, "al center, pushx, split2");

		JTextField pstf = new JTextField();
		pstf.setSize(minw_tf, minh_tf);
		pstf.setMinimumSize(pstf.getSize());
		this.add(pstf, "al center, pushx, wrap");

		JButton sub = new JButton("Registruj se");
		this.add(sub, "al center, pushx, wrap");

		sub.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				if (emptyTextField(ntf, stf, etf, atf, untf, pstf, ptf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);

				else if (webShop.nadjiKorisnika(untf.getText()) != null)
					JOptionPane.showMessageDialog(null, "Uneto korisnicko ime vec postoji!", "Greska",
							JOptionPane.ERROR_MESSAGE);

				else {
					webShop.dodajKorisnika(untf.getText(), pstf.getText(), Uloga.kupac, new Kupac(ntf.getText(),
							stf.getText(), etf.getText(), atf.getText(), new Mesto(ptf.getText())));

					logIn(Uloga.kupac);
					currentUser = webShop.nadjiKorisnika(untf.getText());
					System.out.println(currentUser.getKorisnickoIme());

				}

			}
		});

		this.refresh();

	}

	private void logIn(Uloga uloga) {

		switch (uloga) {
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

		BufferedImage login_pic = null;

		try {
			login_pic = ImageIO.read(new File("login_img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(login_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel unl = new JLabel("Korisnicko ime: ");
		unl.setSize(minw_l, minh_l);
		unl.setMinimumSize(unl.getSize());
		this.add(unl, "al center, pushx, split2");

		JTextField untf = new JTextField();
		untf.setSize(minw_tf, minh_tf);
		untf.setMinimumSize(untf.getSize());
		this.add(untf, "al center, pushx, wrap");

		JLabel psl = new JLabel("Lozinka: ");
		psl.setSize(minw_l, minh_l);
		psl.setMinimumSize(psl.getSize());
		this.add(psl, "al center, pushx, split2");

		JTextField pstf = new JTextField();
		pstf.setSize(minw_tf, minh_tf);
		pstf.setMinimumSize(pstf.getSize());
		this.add(pstf, "al center, pushx, wrap");

		JButton sib = new JButton("Prijavi se");
		this.add(sib, "al center, pushx, wrap");

		sib.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emptyTextField(untf, pstf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);

				else {
					Korisnik k = webShop.nadjiKorisnika(untf.getText(), pstf.getText());
					if (k == null)
						JOptionPane.showMessageDialog(null, "Nepostojec korisnik!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					else {
						logIn(k.getUloga());
						currentUser = webShop.nadjiKorisnika(untf.getText());
						System.out.println(currentUser.getKorisnickoIme());

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

		BufferedImage men_add_pic = null;

		try {
			men_add_pic = ImageIO.read(new File("men_add_img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(men_add_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel unl = new JLabel("Korisnicko ime: ");
		unl.setSize(minw_l, minh_l);
		unl.setMinimumSize(unl.getSize());
		this.add(unl, "al center, pushx, split2");

		JTextField untf = new JTextField();
		untf.setSize(minw_tf, minh_tf);
		untf.setMinimumSize(untf.getSize());
		this.add(untf, "al center, pushx, wrap");

		JLabel psl = new JLabel("Lozinka: ");
		psl.setSize(minw_l, minh_l);
		psl.setMinimumSize(psl.getSize());
		this.add(psl, "al center, pushx, split2");

		JTextField pstf = new JTextField();
		pstf.setSize(minw_tf, minh_tf);
		pstf.setMinimumSize(pstf.getSize());
		this.add(pstf, "al center, pushx, wrap");

		JButton cmb = new JButton("Kreiraj menadzera");
		this.add(cmb, "al center, pushx, wrap");

		cmb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emptyTextField(untf, pstf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);

				else if (webShop.nadjiKorisnika(untf.getText()) != null)
					JOptionPane.showMessageDialog(null, "Uneto korisnicko ime vec postoji!", "Greska",
							JOptionPane.ERROR_MESSAGE);

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

		BufferedImage men_del_pic = null;

		try {
			men_del_pic = ImageIO.read(new File("men_del_img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(men_del_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel unl = new JLabel("Korisnicko ime: ");
		unl.setSize(minw_l, minh_l);
		unl.setMinimumSize(unl.getSize());
		this.add(unl, "al center, pushx, split2");

		JTextField untf = new JTextField();
		untf.setSize(minw_tf, minh_tf);
		untf.setMinimumSize(untf.getSize());
		this.add(untf, "al center, pushx, wrap");

		JButton cmb = new JButton("Obrisi menadzera");
		this.add(cmb, "al center, pushx, wrap");

		cmb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emptyTextField(untf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				else {
					Korisnik k = webShop.nadjiKorisnika(untf.getText());
					if (k == null || k.getUloga() != Uloga.menadzer)
						JOptionPane.showMessageDialog(null, "Unet menadzer ne postoji!", "Greska",
								JOptionPane.ERROR_MESSAGE);
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

		BufferedImage art_add_pic = null;

		try {
			art_add_pic = ImageIO.read(new File("art_add_img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(art_add_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel cl = new JLabel("Sifra: ");
		cl.setSize(minw_l, minh_l);
		cl.setMinimumSize(cl.getSize());
		this.add(cl, "al center, pushx, split2");

		JTextField ctf = new JTextField();
		ctf.setSize(minw_tf, minh_tf);
		ctf.setMinimumSize(ctf.getSize());
		this.add(ctf, "al center, pushx, wrap");

		JLabel nl = new JLabel("Naziv: ");
		nl.setSize(minw_l, minh_l);
		nl.setMinimumSize(nl.getSize());
		this.add(nl, "al center, pushx, split2");

		JTextField ntf = new JTextField();
		ntf.setSize(minw_tf, minh_tf);
		ntf.setMinimumSize(ntf.getSize());
		this.add(ntf, "al center, pushx, wrap");

		JLabel dl = new JLabel("Opis: ");
		dl.setSize(minw_l, minh_l);
		dl.setMinimumSize(dl.getSize());
		this.add(dl, "al center, pushx, split2");

		JTextField dtf = new JTextField();
		dtf.setSize(minw_tf, minh_tf);
		dtf.setMinimumSize(dtf.getSize());
		this.add(dtf, "al center, pushx, wrap");

		JButton cpb = new JButton("Kreiraj artikal");
		this.add(cpb, "al center, pushx, wrap");

		// dodaj proveru da li je unet ceo broj za sifru artikla

		cpb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emptyTextField(ctf, ntf, dtf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				else {
					Artikal a = webShop.nadjiArtikal(ctf.getText());
					if (a != null)
						JOptionPane.showMessageDialog(null, "Artikal vec postoji!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					else {
						webShop.dodajArtikal(ctf.getText(), ntf.getText(), dtf.getText());
						JOptionPane.showMessageDialog(null, "Artikal kreiran!", "", JOptionPane.INFORMATION_MESSAGE);

					}
				}
			}
		});

		this.refresh();

	}

	public void setDeleteProductPanel() {

		this.setDefault();

		BufferedImage art_del_pic = null;

		try {
			art_del_pic = ImageIO.read(new File("art_del_img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(art_del_pic));
		this.add(picLabel, "pushx, growx, wrap");

		JLabel cl = new JLabel("Sifra: ");
		cl.setSize(minw_l, minh_l);
		cl.setMinimumSize(cl.getSize());
		this.add(cl, "al center, pushx, split2");

		JTextField ctf = new JTextField();
		ctf.setSize(minw_tf, minh_tf);
		ctf.setMinimumSize(ctf.getSize());
		this.add(ctf, "al center, pushx, wrap");

		JButton dpb = new JButton("Obrisi artikal");
		this.add(dpb, "al center, pushx, wrap");

		dpb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emptyTextField(ctf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				else {
					// dodaj da proverava da li je unet ceo broj za sifru artikla
					Artikal a = webShop.nadjiArtikal(ctf.getText());
					if (a == null)
						JOptionPane.showMessageDialog(null, "Unet artikal ne postoji!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					else {
						// u modelu pre brisanja artikla mi fale sve metode
						webShop.obrisiArtikal(ctf.getText());
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
			this.add(new JLabel("Nema cenovnika!"), "al center, wrap");
			this.refresh();
			return;

		}

		BufferedImage cen_art_add_pic = null;

		try {
			cen_art_add_pic = ImageIO.read(new File("cen_art_add_img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(cen_art_add_pic));
		this.add(picLabel, "pushx, growx, wrap");

		String[] array = new String[this.webShop.artikliSaStaromCenom().size()];

		int i = 0;
		for (Artikal a : this.webShop.artikliSaStaromCenom())
			array[i++] = a.getSifra() + "";

		JLabel cbl = new JLabel("Izaberite artikal: ");
		cbl.setSize(minw_l, minh_l);
		cbl.setMinimumSize(cbl.getSize());
		this.add(cbl, "al center, pushx, split2");

		JComboBox<String> cb = new JComboBox<String>(array);
		cb.setSize(minw_tf, minh_tf);
		cb.setMinimumSize(cb.getSize());
		cb.setMaximumSize(new Dimension(minw_tf * 2, minh_tf));
		this.add(cb, "al center, pushx, wrap");

		// dodaj da se ne moze dodati cena ako ne postoji cenovnik
		Cenovnik cenovnik = this.webShop.getCenovnik();
		Collection<StavkaCenovnika> stavke = new ArrayList<>();

		this.setPricePanel(cb, stavke, cenovnik);

		cenovnik.dodajStavke(stavke);

		this.refresh();

	}

	private void setPricePanel(JComboBox<String> cb, Collection<StavkaCenovnika> stavke, Cenovnik cenovnik) {

		JLabel cl = new JLabel("Sifra: ");
		cl.setSize(minw_l, minh_l);
		cl.setMinimumSize(cl.getSize());
		this.add(cl, "al center, pushx, split2");

		JTextField ctf = new JTextField();
		ctf.setEditable(false);
		ctf.setSize(minw_tf, minh_tf);
		ctf.setMinimumSize(ctf.getSize());
		this.add(ctf, "al center, pushx, wrap");

		JLabel pl = new JLabel("Cena: ");
		// dodaj proveru da je unet broj
		pl.setSize(minw_l, minh_l);
		pl.setMinimumSize(pl.getSize());
		this.add(pl, "al center, pushx, split2");

		JTextField ptf = new JTextField();
		ptf.setSize(minw_tf, minh_tf);
		ptf.setMinimumSize(ptf.getSize());
		this.add(ptf, "al center, pushx, wrap");

		JButton apb = new JButton("Dodaj cenu");
		this.add(apb, "al center, pushx, wrap");

		apb.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if (emptyTextField(ctf, ptf))
					JOptionPane.showMessageDialog(null, "Morate popuniti sva polja!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				else {
					StavkaCenovnika sc = new StavkaCenovnika(webShop.nadjiArtikal(ctf.getText()),
							Double.parseDouble(ptf.getText()), cenovnik);
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
				ctf.setText((String) ((JComboBox) e.getSource()).getSelectedItem());
			}
		});

	}

	public void setCreatePriceListPanel() {

		this.setDefault();

		BufferedImage cen_add_pic = null;

		try {
			cen_add_pic = ImageIO.read(new File("cen_add_img.png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		JLabel picLabel = new JLabel(new ImageIcon(cen_add_pic));
		this.add(picLabel, "pushx, growx, wrap");

		String[] array = new String[this.webShop.getArtikli().size()];

		int i = 0;
		for (Artikal a : this.webShop.getArtikli())
			array[i++] = a.getSifra() + "";

		JLabel cbl = new JLabel("Izaberite artikal: ");
		cbl.setSize(minw_l, minh_l);
		cbl.setMinimumSize(cbl.getSize());
		this.add(cbl, "al center, pushx, split2");

		JComboBox<String> cb = new JComboBox<String>(array);
		cb.setSize(minw_tf, minh_tf);
		cb.setMinimumSize(cb.getSize());
		cb.setMaximumSize(new Dimension(minw_tf * 2, minh_tf));
		this.add(cb, "al center, pushx, growx, wrap");

		Cenovnik cenovnik = new Cenovnik();
		Collection<StavkaCenovnika> stavke = new ArrayList<>();

		this.setPricePanel(cb, stavke, cenovnik);

		JButton cplb = new JButton("Kreiraj cenovnik");
		this.add(cplb, "al center, pushx, wrap");

		cplb.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

				cenovnik.dodajStavke(stavke);

				webShop.dodajCenovnik(cenovnik);
				JOptionPane.showMessageDialog(null, "Cenovnik kreiran!", "", JOptionPane.INFORMATION_MESSAGE);
				setDefault();
				refresh(); // VAU
			}
		});

		this.refresh();

	}

	public void setOrdersPanel() {

		System.out.println("HURA");

		// OVO JE SAMO PROBNI GUI, TREBA GA SREDITI

		Kupac customer = this.currentUser.getKupac();
		Collection<Narudzbenica> orders = customer.getNarudzbenice();

		this.removeAll();

		this.setLayout(new MigLayout("gap 5px 10px"));

		JPanel sveNarudzbenice = new JPanel(new MigLayout("gap 5px 10px"));
		JScrollPane scrollCenterPanel = new JScrollPane(sveNarudzbenice);

		scrollCenterPanel.getVerticalScrollBar().setUnitIncrement(10);
		scrollCenterPanel.getHorizontalScrollBar().setUnitIncrement(10);

		int brojac = 0;

		for (Narudzbenica o : orders) {
			if (brojac == 2) {
				sveNarudzbenice.add(new NarudzbenicaPanel(o, this), "al center, pushx, split 3, wrap");
				brojac = 0;
				continue;
			} else {
				sveNarudzbenice.add(new NarudzbenicaPanel(o, this), "al center, pushx, split 3");
			}
			++brojac;
		}

		JButton co = new JButton("Dodaj narudzbenicu");
		this.add(co, "al left, top");

		this.add(scrollCenterPanel, "al left, grow, push");

		CenterPanel temp = this; // MORAM OVO DA NAPISEM

		co.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("KLIK");

				Object retval = JOptionPane.showInputDialog(null, "Unesite adresu isporuke", "Adresa narudzbenice",
						JOptionPane.QUESTION_MESSAGE, null, null, "");
				// dodaj proveru da li je za adresu unet prazan string!!!!!!!!!! i da li je
				// pritisnut cancel

				if (retval != null) {
					String adresa = (String) retval;

					if (!adresa.trim().isEmpty()) {
						Narudzbenica order = new Narudzbenica(customer.getBrojNarudzbenica(), new Date(), adresa,
								customer);

						webShop.dodajNarudzbenicu(order);
						sveNarudzbenice.add(new NarudzbenicaPanel(order, temp));
						refresh();
					} else {
						JOptionPane.showMessageDialog(null, "Nije uneta adresa!", "Greska",
								JOptionPane.ERROR_MESSAGE);
					}
				} else {
					JOptionPane.showMessageDialog(null, "Nije uneta adresa!", "Greska",
							JOptionPane.ERROR_MESSAGE);
				}
			}
		});

		this.refresh();

	}

	/*
	 * public void setBusketPanel() {
	 * 
	 * }
	 * 
	 * public void setBoughtPanel() {
	 * 
	 * }
	 * 
	 * public void setCreateOrderPanel() {
	 * 
	 * }
	 */

}
