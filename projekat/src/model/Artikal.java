package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Artikal.java
 * Author:  Dragana
 * Purpose: Defines the Class Artikal
 ***********************************************************************/

import java.util.*;

/** @pdOid a6868f78-7b2b-4ea1-8767-d4af7347d667 */
public class Artikal implements Serializable {
	/** @pdOid db0b4a63-1fa4-43e7-8e37-51983d4ffa78 */
	private String sifra;
	/** @pdOid 8927bc9a-730e-4d6b-bd51-5be1390c7d61 */
	private String naziv;
	/** @pdOid 1936dfe9-a9d1-42c9-bd41-ddddde8b9b2e */
	private String opis;

	/**
	 * @pdRoleInfo migr=no name=StavkaCenovnika assc=association6
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Aggregation
	 */
	private java.util.Collection<StavkaCenovnika> cene;
	/**
	 * @pdRoleInfo migr=no name=StavkaAkcije assc=association15
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	private java.util.Collection<StavkaAkcije> akcije;
	/**
	 * @pdRoleInfo migr=no name=Skladistenje assc=association17
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	private java.util.Collection<Skladistenje> skladista;

	public Artikal() {
		super();
		this.cene = new ArrayList<>();
		this.akcije = new ArrayList<>();
		this.skladista = new ArrayList<>();

	}

	public Artikal(String sifra, String naziv, String opis) {
		this();
		this.sifra = sifra;
		this.naziv = naziv;
		this.opis = opis;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<StavkaCenovnika> getCene() {
		if (cene == null)
			cene = new java.util.HashSet<StavkaCenovnika>();
		return cene;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorCene() {
		if (cene == null)
			cene = new java.util.HashSet<StavkaCenovnika>();
		return cene.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newCene
	 */
	public void setCene(java.util.Collection<StavkaCenovnika> newCene) {
		removeAllCene();
		for (java.util.Iterator iter = newCene.iterator(); iter.hasNext();)
			addCene((StavkaCenovnika) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newStavkaCenovnika
	 */
	public void addCene(StavkaCenovnika newStavkaCenovnika) {
		if (newStavkaCenovnika == null)
			return;
		if (this.cene == null)
			this.cene = new java.util.HashSet<StavkaCenovnika>();
		if (!this.cene.contains(newStavkaCenovnika)) {
			this.cene.add(newStavkaCenovnika);
			newStavkaCenovnika.setArtikal(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldStavkaCenovnika
	 */
	public void removeCene(StavkaCenovnika oldStavkaCenovnika) {
		if (oldStavkaCenovnika == null)
			return;
		if (this.cene != null)
			if (this.cene.contains(oldStavkaCenovnika)) {
				this.cene.remove(oldStavkaCenovnika);
				oldStavkaCenovnika.setArtikal((Artikal) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllCene() {
		if (cene != null) {
			StavkaCenovnika oldStavkaCenovnika;
			for (java.util.Iterator iter = getIteratorCene(); iter.hasNext();) {
				oldStavkaCenovnika = (StavkaCenovnika) iter.next();
				iter.remove();
				oldStavkaCenovnika.setArtikal((Artikal) null);
			}
		}
	}

	/** @pdGenerated default getter */
	public java.util.Collection<StavkaAkcije> getAkcije() {
		if (akcije == null)
			akcije = new java.util.HashSet<StavkaAkcije>();
		return akcije;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorAkcije() {
		if (akcije == null)
			akcije = new java.util.HashSet<StavkaAkcije>();
		return akcije.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newAkcije
	 */
	public void setAkcije(java.util.Collection<StavkaAkcije> newAkcije) {
		removeAllAkcije();
		for (java.util.Iterator iter = newAkcije.iterator(); iter.hasNext();)
			addAkcije((StavkaAkcije) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newStavkaAkcije
	 */
	public void addAkcije(StavkaAkcije newStavkaAkcije) {
		if (newStavkaAkcije == null)
			return;
		if (this.akcije == null)
			this.akcije = new java.util.HashSet<StavkaAkcije>();
		if (!this.akcije.contains(newStavkaAkcije)) {
			this.akcije.add(newStavkaAkcije);
			newStavkaAkcije.setArtikal(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldStavkaAkcije
	 */
	public void removeAkcije(StavkaAkcije oldStavkaAkcije) {
		if (oldStavkaAkcije == null)
			return;
		if (this.akcije != null)
			if (this.akcije.contains(oldStavkaAkcije)) {
				this.akcije.remove(oldStavkaAkcije);
				oldStavkaAkcije.setArtikal((Artikal) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllAkcije() {
		if (akcije != null) {
			StavkaAkcije oldStavkaAkcije;
			for (java.util.Iterator iter = getIteratorAkcije(); iter.hasNext();) {
				oldStavkaAkcije = (StavkaAkcije) iter.next();
				iter.remove();
				oldStavkaAkcije.setArtikal((Artikal) null);
			}
		}
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Skladistenje> getSkladista() {
		if (skladista == null)
			skladista = new java.util.HashSet<Skladistenje>();
		return skladista;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorSkladista() {
		if (skladista == null)
			skladista = new java.util.HashSet<Skladistenje>();
		return skladista.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newSkladista
	 */
	public void setSkladista(java.util.Collection<Skladistenje> newSkladista) {
		removeAllSkladista();
		for (java.util.Iterator iter = newSkladista.iterator(); iter.hasNext();)
			addSkladista((Skladistenje) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newSkladistenje
	 */
	public void addSkladista(Skladistenje newSkladistenje) {
		if (newSkladistenje == null)
			return;
		if (this.skladista == null)
			this.skladista = new java.util.HashSet<Skladistenje>();
		if (!this.skladista.contains(newSkladistenje)) {
			this.skladista.add(newSkladistenje);
			newSkladistenje.setArtikal(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldSkladistenje
	 */
	public void removeSkladista(Skladistenje oldSkladistenje) {
		if (oldSkladistenje == null)
			return;
		if (this.skladista != null)
			if (this.skladista.contains(oldSkladistenje)) {
				this.skladista.remove(oldSkladistenje);
				oldSkladistenje.setArtikal((Artikal) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllSkladista() {
		if (skladista != null) {
			Skladistenje oldSkladistenje;
			for (java.util.Iterator iter = getIteratorSkladista(); iter.hasNext();) {
				oldSkladistenje = (Skladistenje) iter.next();
				iter.remove();
				oldSkladistenje.setArtikal((Artikal) null);
			}
		}
	}

	public String getSifra() {
		return sifra;
	}

	public void setSifra(String sifra) {
		this.sifra = sifra;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public String getOpis() {
		return opis;
	}

	public void setOpis(String opis) {
		this.opis = opis;
	}

	public void dodajCenu(StavkaCenovnika sc) {
		this.cene.add(sc);

	}

	public StavkaCenovnika getStavkaCenovnika() {

		if (this.cene.isEmpty())
			return null;
		return ((List<StavkaCenovnika>) this.cene).get(this.cene.size() - 1);
		// OVO MALO SREDI!!

	}
	
	public double getCena() {
		
		if (this.getStavkaCenovnika() == null)
			return 0;
		return this.getStavkaCenovnika().getCena();
		
		
	}


}
