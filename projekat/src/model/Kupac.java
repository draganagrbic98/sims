package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Kupac.java
 * Author:  Dragana
 * Purpose: Defines the Class Kupac
 ***********************************************************************/

import java.util.*;

/** @pdOid d47d1a7a-9b9a-4257-bfc1-5791630b8ef6 */
public class Kupac implements Serializable {
	/** @pdOid b3ce8ecf-564e-407c-ae09-f3db49b337a8 */
	private String ime;
	/** @pdOid 7ab68305-e501-4e5b-b173-6cd815837fc2 */
	private String prezime;
	/** @pdOid 3b862386-45a2-43b8-9b74-61ba7fae59a4 */
	private String email;
	/** @pdOid 3f891db1-356e-46db-a825-118f5f7d791b */
	private String adresa;

	/** @pdOid 753ff223-d150-45f8-ae84-fb001dd5bbd5 */
	private int brojNarudzbenica;
	
	/**
	 * @pdRoleInfo migr=no name=Narudzbenica assc=association7
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	private java.util.Collection<Narudzbenica> narudzbenice;
	/**
	 * @pdRoleInfo migr=no name=Artikal assc=association10 coll=java.util.Collection
	 *             impl=java.util.HashSet mult=0..*
	 */
	private java.util.Collection<Artikal> preporuke;
	/** @pdRoleInfo migr=no name=Mesto assc=association16 mult=1..1 */
	private Mesto mesto;
	/** @pdRoleInfo migr=no name=Korisnik assc=association2 mult=1..1 side=A */
	private Korisnik korisnik;

	public Kupac() {
		super();
		this.narudzbenice = new ArrayList<>();
		this.preporuke = new ArrayList<>();
	}

	public Kupac(String ime, String prezime, String email, String adresa, Mesto mesto) {
		this();
		this.ime = ime;
		this.prezime = prezime;
		this.email = email;
		this.adresa = adresa;
		this.mesto = mesto;
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
		if (!this.narudzbenice.contains(newNarudzbenica)) {
			this.narudzbenice.add(newNarudzbenica);
			newNarudzbenica.setKupac(this);
		}
		this.brojNarudzbenica++;	//JEL OVO OK?????????
	}

	/**
	 * @pdGenerated default remove
	 * @param oldNarudzbenica
	 */
	public void removeNarudzbenice(Narudzbenica oldNarudzbenica) {
		if (oldNarudzbenica == null)
			return;
		if (this.narudzbenice != null)
			if (this.narudzbenice.contains(oldNarudzbenica)) {
				this.narudzbenice.remove(oldNarudzbenica);
				oldNarudzbenica.setKupac((Kupac) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllNarudzbenice() {
		if (narudzbenice != null) {
			Narudzbenica oldNarudzbenica;
			for (java.util.Iterator iter = getIteratorNarudzbenice(); iter.hasNext();) {
				oldNarudzbenica = (Narudzbenica) iter.next();
				iter.remove();
				oldNarudzbenica.setKupac((Kupac) null);
			}
		}
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Artikal> getPreporuke() {
		if (preporuke == null)
			preporuke = new java.util.HashSet<Artikal>();
		return preporuke;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorPreporuke() {
		if (preporuke == null)
			preporuke = new java.util.HashSet<Artikal>();
		return preporuke.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newPreporuke
	 */
	public void setPreporuke(java.util.Collection<Artikal> newPreporuke) {
		removeAllPreporuke();
		for (java.util.Iterator iter = newPreporuke.iterator(); iter.hasNext();)
			addPreporuke((Artikal) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newArtikal
	 */
	public void addPreporuke(Artikal newArtikal) {
		if (newArtikal == null)
			return;
		if (this.preporuke == null)
			this.preporuke = new java.util.HashSet<Artikal>();
		if (!this.preporuke.contains(newArtikal))
			this.preporuke.add(newArtikal);
	}

	/**
	 * @pdGenerated default remove
	 * @param oldArtikal
	 */
	public void removePreporuke(Artikal oldArtikal) {
		if (oldArtikal == null)
			return;
		if (this.preporuke != null)
			if (this.preporuke.contains(oldArtikal))
				this.preporuke.remove(oldArtikal);
	}

	/** @pdGenerated default removeAll */
	public void removeAllPreporuke() {
		if (preporuke != null)
			preporuke.clear();
	}
	
	public void dodajNarudzbenicu(Narudzbenica narudzbenica) {
		this.narudzbenice.add(narudzbenica);
	}
	
	public void obrisiNarudzbenicu(Narudzbenica narudzbenica) {
		this.narudzbenice.remove(narudzbenica);
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

	public Korisnik getKorisnik() {
		return korisnik;
	}

	public void setKorisnik(Korisnik korisnik) {
		this.korisnik = korisnik;
	}

	public int getBrojNarudzbenica() {
		return brojNarudzbenica;
	}
	

}