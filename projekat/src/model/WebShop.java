package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  WebShop.java
 * Author:  Dragana
 * Purpose: Defines the Class WebShop
 ***********************************************************************/

import java.util.*;

import model.enumi.TipObjekta;
import model.enumi.Uloga;

/** @pdOid 0a6da2d8-1515-4699-bdaf-3b371e06ceb7 */
public class WebShop implements Serializable {
	/** @pdOid beb3ee91-b5c6-48b4-8f66-818337325fd5 */
	private String naziv;
	/** @pdOid dc61ea26-355e-4714-8cdf-c28c765d7202 */
	private int brojCenovnika;

	/**
	 * @pdRoleInfo migr=no name=Povratak assc=association24
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Aggregation
	 */
	private java.util.Collection<Povratak> povracenaRoba;
	/**
	 * @pdRoleInfo migr=no name=Korisnik assc=association1 coll=java.util.Collection
	 *             impl=java.util.HashSet mult=0..* type=Aggregation
	 */
	private java.util.Collection<Korisnik> korisnici;
	/**
	 * @pdRoleInfo migr=no name=Artikal assc=association3 coll=java.util.Collection
	 *             impl=java.util.HashSet mult=0..* type=Aggregation
	 */
	private java.util.Collection<Artikal> artikli;
	/**
	 * @pdRoleInfo migr=no name=Cenovnik assc=association4 coll=java.util.Collection
	 *             impl=java.util.HashSet mult=0..* type=Aggregation
	 */
	private java.util.Collection<Cenovnik> cenovnici;
	/**
	 * @pdRoleInfo migr=no name=Objekat assc=association12 coll=java.util.Collection
	 *             impl=java.util.HashSet mult=0..* type=Aggregation
	 */
	private java.util.Collection<Objekat> objekti;
	/**
	 * @pdRoleInfo migr=no name=Akcija assc=association13 coll=java.util.Collection
	 *             impl=java.util.HashSet mult=0..* type=Aggregation
	 */
	private java.util.Collection<Akcija> akcije;
	/**
	 * @pdRoleInfo migr=no name=Narudzbenica assc=association19
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Aggregation
	 */
	private java.util.Collection<Narudzbenica> narudzbenice;

	private WebShop() {
		super();
		this.povracenaRoba = new ArrayList<>();
		this.korisnici = new ArrayList<>();
		this.artikli = new ArrayList<>();
		this.cenovnici = new ArrayList<>();
		this.objekti = new ArrayList<>();
		this.akcije = new ArrayList<>();
		this.narudzbenice = new ArrayList<>();

	}

	public WebShop(String naziv) {
		this();
		this.naziv = naziv;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Povratak> getPovracenaRoba() {
		if (povracenaRoba == null)
			povracenaRoba = new java.util.HashSet<Povratak>();
		return povracenaRoba;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorPovracenaRoba() {
		if (povracenaRoba == null)
			povracenaRoba = new java.util.HashSet<Povratak>();
		return povracenaRoba.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newPovracenaRoba
	 */
	public void setPovracenaRoba(java.util.Collection<Povratak> newPovracenaRoba) {
		removeAllPovracenaRoba();
		for (java.util.Iterator iter = newPovracenaRoba.iterator(); iter.hasNext();)
			addPovracenaRoba((Povratak) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newPovratak
	 */
	public void addPovracenaRoba(Povratak newPovratak) {
		if (newPovratak == null)
			return;
		if (this.povracenaRoba == null)
			this.povracenaRoba = new java.util.HashSet<Povratak>();
		if (!this.povracenaRoba.contains(newPovratak))
			this.povracenaRoba.add(newPovratak);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldPovratak
	 */
	public void removePovracenaRoba(Povratak oldPovratak) {
		if (oldPovratak == null)
			return;
		if (this.povracenaRoba != null)
			if (this.povracenaRoba.contains(oldPovratak))
				this.povracenaRoba.remove(oldPovratak);
	}

	/** @pdGenerated default removeAll */
	public void removeAllPovracenaRoba() {
		if (povracenaRoba != null)
			povracenaRoba.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Korisnik> getKorisnici() {
		if (korisnici == null)
			korisnici = new java.util.HashSet<Korisnik>();
		return korisnici;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorKorisnici() {
		if (korisnici == null)
			korisnici = new java.util.HashSet<Korisnik>();
		return korisnici.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newKorisnici
	 */
	public void setKorisnici(java.util.Collection<Korisnik> newKorisnici) {
		removeAllKorisnici();
		for (java.util.Iterator iter = newKorisnici.iterator(); iter.hasNext();)
			addKorisnici((Korisnik) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newKorisnik
	 */
	public void addKorisnici(Korisnik newKorisnik) {
		if (newKorisnik == null)
			return;
		if (this.korisnici == null)
			this.korisnici = new java.util.HashSet<Korisnik>();
		if (!this.korisnici.contains(newKorisnik))
			this.korisnici.add(newKorisnik);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldKorisnik
	 */
	public void removeKorisnici(Korisnik oldKorisnik) {
		if (oldKorisnik == null)
			return;
		if (this.korisnici != null)
			if (this.korisnici.contains(oldKorisnik))
				this.korisnici.remove(oldKorisnik);
	}

	/** @pdGenerated default removeAll */
	public void removeAllKorisnici() {
		if (korisnici != null)
			korisnici.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Artikal> getArtikli() {
		if (artikli == null)
			artikli = new java.util.HashSet<Artikal>();
		return artikli;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorArtikli() {
		if (artikli == null)
			artikli = new java.util.HashSet<Artikal>();
		return artikli.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newArtikli
	 */
	public void setArtikli(java.util.Collection<Artikal> newArtikli) {
		removeAllArtikli();
		for (java.util.Iterator iter = newArtikli.iterator(); iter.hasNext();)
			addArtikli((Artikal) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newArtikal
	 */
	public void addArtikli(Artikal newArtikal) {
		if (newArtikal == null)
			return;
		if (this.artikli == null)
			this.artikli = new java.util.HashSet<Artikal>();
		if (!this.artikli.contains(newArtikal))
			this.artikli.add(newArtikal);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldArtikal
	 */
	public void removeArtikli(Artikal oldArtikal) {
		if (oldArtikal == null)
			return;
		if (this.artikli != null)
			if (this.artikli.contains(oldArtikal))
				this.artikli.remove(oldArtikal);
	}

	/** @pdGenerated default removeAll */
	public void removeAllArtikli() {
		if (artikli != null)
			artikli.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Cenovnik> getCenovnici() {
		if (cenovnici == null)
			cenovnici = new java.util.HashSet<Cenovnik>();
		return cenovnici;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorCenovnici() {
		if (cenovnici == null)
			cenovnici = new java.util.HashSet<Cenovnik>();
		return cenovnici.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newCenovnici
	 */
	public void setCenovnici(java.util.Collection<Cenovnik> newCenovnici) {
		removeAllCenovnici();
		for (java.util.Iterator iter = newCenovnici.iterator(); iter.hasNext();)
			addCenovnici((Cenovnik) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newCenovnik
	 */
	public void addCenovnici(Cenovnik newCenovnik) {
		if (newCenovnik == null)
			return;
		if (this.cenovnici == null)
			this.cenovnici = new java.util.HashSet<Cenovnik>();
		if (!this.cenovnici.contains(newCenovnik))
			this.cenovnici.add(newCenovnik);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldCenovnik
	 */
	public void removeCenovnici(Cenovnik oldCenovnik) {
		if (oldCenovnik == null)
			return;
		if (this.cenovnici != null)
			if (this.cenovnici.contains(oldCenovnik))
				this.cenovnici.remove(oldCenovnik);
	}

	/** @pdGenerated default removeAll */
	public void removeAllCenovnici() {
		if (cenovnici != null)
			cenovnici.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Objekat> getObjekti() {
		if (objekti == null)
			objekti = new java.util.HashSet<Objekat>();
		return objekti;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorObjekti() {
		if (objekti == null)
			objekti = new java.util.HashSet<Objekat>();
		return objekti.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newObjekti
	 */
	public void setObjekti(java.util.Collection<Objekat> newObjekti) {
		removeAllObjekti();
		for (java.util.Iterator iter = newObjekti.iterator(); iter.hasNext();)
			addObjekti((Objekat) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newObjekat
	 */
	public void addObjekti(Objekat newObjekat) {
		if (newObjekat == null)
			return;
		if (this.objekti == null)
			this.objekti = new java.util.HashSet<Objekat>();
		if (!this.objekti.contains(newObjekat))
			this.objekti.add(newObjekat);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldObjekat
	 */
	public void removeObjekti(Objekat oldObjekat) {
		if (oldObjekat == null)
			return;
		if (this.objekti != null)
			if (this.objekti.contains(oldObjekat))
				this.objekti.remove(oldObjekat);
	}

	/** @pdGenerated default removeAll */
	public void removeAllObjekti() {
		if (objekti != null)
			objekti.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Akcija> getAkcije() {
		if (akcije == null)
			akcije = new java.util.HashSet<Akcija>();
		return akcije;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorAkcije() {
		if (akcije == null)
			akcije = new java.util.HashSet<Akcija>();
		return akcije.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newAkcije
	 */
	public void setAkcije(java.util.Collection<Akcija> newAkcije) {
		removeAllAkcije();
		for (java.util.Iterator iter = newAkcije.iterator(); iter.hasNext();)
			addAkcije((Akcija) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newAkcija
	 */
	public void addAkcije(Akcija newAkcija) {
		if (newAkcija == null)
			return;
		if (this.akcije == null)
			this.akcije = new java.util.HashSet<Akcija>();
		if (!this.akcije.contains(newAkcija))
			this.akcije.add(newAkcija);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldAkcija
	 */
	public void removeAkcije(Akcija oldAkcija) {
		if (oldAkcija == null)
			return;
		if (this.akcije != null)
			if (this.akcije.contains(oldAkcija))
				this.akcije.remove(oldAkcija);
	}

	/** @pdGenerated default removeAll */
	public void removeAllAkcije() {
		if (akcije != null)
			akcije.clear();
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Narudzbenica> getNarudzbenice() {
		if (narudzbenice == null)
			narudzbenice = new java.util.HashSet<Narudzbenica>();
		return narudzbenice;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorNarudzbenice() {
		if (narudzbenice == null)
			narudzbenice = new java.util.HashSet<Narudzbenica>();
		return narudzbenice.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newNarudzbenice
	 */
	public void setNarudzbenice(java.util.Collection<Narudzbenica> newNarudzbenice) {
		removeAllNarudzbenice();
		for (java.util.Iterator iter = newNarudzbenice.iterator(); iter.hasNext();)
			addNarudzbenice((Narudzbenica) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newNarudzbenica
	 */
	public void addNarudzbenice(Narudzbenica newNarudzbenica) {
		if (newNarudzbenica == null)
			return;
		if (this.narudzbenice == null)
			this.narudzbenice = new java.util.HashSet<Narudzbenica>();
		if (!this.narudzbenice.contains(newNarudzbenica))
			this.narudzbenice.add(newNarudzbenica);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldNarudzbenica
	 */
	public void removeNarudzbenice(Narudzbenica oldNarudzbenica) {
		if (oldNarudzbenica == null)
			return;
		if (this.narudzbenice != null)
			if (this.narudzbenice.contains(oldNarudzbenica))
				this.narudzbenice.remove(oldNarudzbenica);
	}

	/** @pdGenerated default removeAll */
	public void removeAllNarudzbenice() {
		if (narudzbenice != null)
			narudzbenice.clear();
	}

	/**
	 * @param korisnickoIme
	 * @param lozinka
	 * @param uloga
	 * @pdOid 962467a9-d5d6-4b0c-a114-f12f106ba20c
	 */
	public void dodajKorisnika(String korisnickoIme, String lozinka, Uloga uloga) {
		// TODO: implement
		this.korisnici.add(new Korisnik(korisnickoIme, lozinka, uloga));

	}

	/**
	 * @param korisnickoIme
	 * @param lozinka
	 * @param uloga
	 * @param kupac
	 * @pdOid 85021002-be21-4668-9d66-6f777c6b1524
	 */
	public void dodajKorisnika(String korisnickoIme, String lozinka, Uloga uloga, Kupac kupac) {
		// TODO: implement
		this.korisnici.add(new Korisnik(korisnickoIme, lozinka, uloga, kupac));
	}

	/**
	 * @param korisnickoIme
	 * @pdOid ebb3bc17-daa5-4fba-aef2-9e8efc9bbfe5
	 */
	public void obrisiKorisnika(String korisnickoIme) {
		// TODO: implement

		Korisnik k = this.nadjiKorisnika(korisnickoIme);
		this.korisnici.remove(k);

	}

	/**
	 * @param korisnickoIme
	 * @pdOid 5e445a0f-31fa-4635-b2fc-f3601908c9d1
	 */
	public Korisnik nadjiKorisnika(String korisnickoIme) {
		// TODO: implement
		for (Korisnik k : this.korisnici) {
			if (k.getKorisnickoIme().equals(korisnickoIme))
				return k;
		}
		return null;
	}

	/**
	 * @param datum
	 * @pdOid e384b34c-40a0-4bcd-922f-d7b9322cf078
	 */
	public void dodajCenovnik(Date datum) {
		// TODO: implement
	}

	/**
	 * @param datum
	 * @param stavke
	 * @pdOid 0de84aad-b57d-48c3-b8c3-509db90622d7
	 */
	public void dodajCenovnik(Date datum, Collection<StavkaCenovnika> stavke) {
		// TODO: implement
		this.cenovnici.add(new Cenovnik(++this.brojCenovnika, datum, stavke));

	}

	public void dodajCenovnik(Cenovnik cenovnik) {
		cenovnik.setDatum(new Date());
		cenovnik.setBroj(++this.brojCenovnika);
		this.cenovnici.add(cenovnik);

	}

	/**
	 * @param broj
	 * @pdOid 461fcd7c-17c9-436b-b65a-1f78d0147967
	 */
	public void obrisiCenovnik(int broj) {
		// TODO: implement
	}

	/**
	 * @param broj
	 * @pdOid 4604a205-dcdf-4a12-bf60-d57966c355a4
	 */
	public Cenovnik nadjiCenovnik(int broj) {
		// TODO: implement
		return null;
	}

	/**
	 * @param ime
	 * @param adresa
	 * @param tip
	 * @param mesto
	 * @pdOid 95a61985-ef4b-4db4-ad71-d3ef5be03fa8
	 */
	public void dodajObjekat(String ime, String adresa, TipObjekta tip, Mesto mesto) {
		// TODO: implement
	}

	/**
	 * @param naziv
	 * @pdOid 59c1edcc-12bd-41ec-aaeb-eb243237c05e
	 */
	public void obrisiObjekat(String naziv) {
		// TODO: implement
	}

	/**
	 * @param naziv
	 * @pdOid 00bde53b-7d13-432f-97ff-4a540f61e386
	 */
	public Objekat nadjiObjekat(String naziv) {
		// TODO: implement
		return null;
	}

	/** @pdOid dcd1c3ca-e08b-4f0d-847d-d5b7d81c0bb3 */
	public boolean imaAdmina() {
		// TODO: implement
		for (Korisnik k : this.korisnici) {
			if (k.getUloga() == Uloga.administrator)
				return true;
		}
		return false;

	}

	/** @pdOid af18f8bd-5f4f-4743-a709-49163840e69b */
	public void dodajPodrazumevanogAdmina() {
		// TODO: implement
		this.korisnici.add(new Korisnik("admin", "admin", Uloga.administrator));
	}

	/**
	 * @param korisnickoIme
	 * @param lozinka
	 * @pdOid e901f61a-633b-47b1-9532-43a72fc05361
	 */
	public Korisnik nadjiKorisnika(String korisnickoIme, String lozinka) {
		// TODO: implement
		for (Korisnik k : this.korisnici) {
			if (k.getKorisnickoIme().equals(korisnickoIme) && k.getLozinka().equals(lozinka))
				return k;
		}
		return null;
	}

	public List<Korisnik> getMenadzeri() {

		List<Korisnik> menadzeri = new ArrayList<>();
		for (Korisnik k : this.korisnici) {
			if (k.getUloga().equals(Uloga.menadzer))
				menadzeri.add(k);
		}
		return menadzeri;

	}

	/**
	 * @param parametar
	 * @pdOid 2ad7e49f-afe7-4c48-a443-f8f5fe463fbf
	 */
	public Collection<Artikal> pretraziArtikle(String parametar) {
		// TODO: implement
		Collection<Artikal> artikli2 = new ArrayList<>();
		for (Artikal a : this.artikli) {
			if (a.getNaziv().contains(parametar) || a.getOpis().contains(parametar))
				// if (a.getNaziv().equalsIgnoreCase(parametar))
				artikli2.add(a);
		}
		return artikli2;

	}

	/**
	 * @param sifra
	 * @param naziv
	 * @param opis
	 * @pdOid 909f803c-69c3-44f4-9229-87ee119a8a87
	 */
	public void dodajArtikal(String sifra, String naziv, String opis) {
		// TODO: implement
		this.artikli.add(new Artikal(sifra, naziv, opis));

	}

	/**
	 * @param sifra
	 * @pdOid b0b09465-5902-4507-a047-437fe4938254
	 */
	public Artikal nadjiArtikal(String sifra) {
		// TODO: implement
		for (Artikal a : this.artikli) {
			if (a.getSifra().equals(sifra))
				return a;
		}
		return null;

	}

	/**
	 * @param sifra
	 * @pdOid ade9fb63-23ca-4f2e-ba4a-71eedfe8e53c
	 */
	public void obrisiArtikal(String sifra) {
		// TODO: implement
		Artikal a = this.nadjiArtikal(sifra);
		this.artikli.remove(a);
	}

	public Collection<Artikal> artikliSaStaromCenom() {

		// ovo nemas u modelu

		Collection<Artikal> artikli = new ArrayList<>();

		for (Artikal a : this.artikli) {
			// dodaj proveru da li postoji cenovnik

			if (a.getCena() == null) {
				artikli.add(a);
				System.out.println("Lele, nema artikli!");
			} else if (a.getCena().getCenovnik().getBroj() != this.brojCenovnika)
				artikli.add(a);
		}
		return artikli;

	}

	public int getBrojCenovnika() {
		return brojCenovnika;
	}

	public Cenovnik getCenovnik() {

		if (this.cenovnici.isEmpty())
			return null;

		return ((List<Cenovnik>) this.cenovnici).get(this.cenovnici.size() - 1);

	}

	  
	   /** @param broj 
	    * @param datum 
	    * @param adresa 
	    * @param kupac
	    * @pdOid b7cf08f2-32df-4531-af79-0327ab88ad91 */
	   public void dodajNarudzbenicu(int broj, Date datum, String adresa, Kupac kupac) {
	      // TODO: implement
		   this.narudzbenice.add(new Narudzbenica(kupac.getBrojNarudzbenica(), new Date(), adresa, kupac));
	   }
	   
	   public void dodajNarudzbenicu(Narudzbenica narudbenica) {
		   this.narudzbenice.add(narudbenica);
		   
	   }
	   
	   public void obrisiNarudzbenicu(Narudzbenica narudzbenica) {
		   this.narudzbenice.remove(narudzbenica);
		   
	   }
	
}
