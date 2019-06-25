package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Narudzbenica.java
 * Author:  Dragana
 * Purpose: Defines the Class Narudzbenica
 ***********************************************************************/

import java.util.*;

import model.stanja.Formiranje;
import model.stanja.Stanje;

/** @pdOid 841a9edc-6a7d-4f68-8d7f-489ea357ad9e */
public class Narudzbenica implements Serializable {
	/** @pdOid fbb8f5e5-59fe-4aa9-bb64-3dfd1ce8540d */
	private int broj;
	/** @pdOid 7ed5fd8b-22c3-4707-8c09-bba99805281e */
	private Date datum;
	/** @pdOid 722b4ca5-65ce-4c21-b835-610a2e455dad */
	private String adresa;

	/**
	 * @pdRoleInfo migr=no name=StavkaNarudzbenice assc=association8
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	private java.util.Collection<StavkaNarudzbenice> stavke;
	/** @pdRoleInfo migr=no name=Stanje assc=association21 mult=1..1 */
	private Stanje stanje;
	/** @pdRoleInfo migr=no name=Kupac assc=association7 mult=1..1 side=A */
	private Kupac kupac;

	public Narudzbenica() {
		super();
		this.stanje = new Formiranje();
		this.stavke = new ArrayList<>();
	}

	public Narudzbenica(int broj, Date datum, String adresa, Kupac kupac) {
		this();
		this.broj = broj;
		this.datum = datum;
		this.adresa = adresa;
		this.kupac = kupac;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<StavkaNarudzbenice> getStavke() {
		if (stavke == null)
			stavke = new java.util.HashSet<StavkaNarudzbenice>();
		return stavke;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorStavke() {
		if (stavke == null)
			stavke = new java.util.HashSet<StavkaNarudzbenice>();
		return stavke.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newStavke
	 */
	public void setStavke(java.util.Collection<StavkaNarudzbenice> newStavke) {
		removeAllStavke();
		for (java.util.Iterator iter = newStavke.iterator(); iter.hasNext();)
			addStavke((StavkaNarudzbenice) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newStavkaNarudzbenice
	 */
	public void addStavke(StavkaNarudzbenice newStavkaNarudzbenice) {
		if (newStavkaNarudzbenice == null)
			return;
		if (this.stavke == null)
			this.stavke = new java.util.HashSet<StavkaNarudzbenice>();
		if (!this.stavke.contains(newStavkaNarudzbenice)) {
			this.stavke.add(newStavkaNarudzbenice);
			newStavkaNarudzbenice.setNarudzbenica(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldStavkaNarudzbenice
	 */
	public void removeStavke(StavkaNarudzbenice oldStavkaNarudzbenice) {
		if (oldStavkaNarudzbenice == null)
			return;
		if (this.stavke != null)
			if (this.stavke.contains(oldStavkaNarudzbenice)) {
				this.stavke.remove(oldStavkaNarudzbenice);
				oldStavkaNarudzbenice.setNarudzbenica((Narudzbenica) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllStavke() {
		if (stavke != null) {
			StavkaNarudzbenice oldStavkaNarudzbenice;
			for (java.util.Iterator iter = getIteratorStavke(); iter.hasNext();) {
				oldStavkaNarudzbenice = (StavkaNarudzbenice) iter.next();
				iter.remove();
				oldStavkaNarudzbenice.setNarudzbenica((Narudzbenica) null);
			}
		}
	}

	/** @pdGenerated default parent getter */
	public Kupac getKupac() {
		return kupac;
	}

	/**
	 * @pdGenerated default parent setter
	 * @param newKupac
	 */
	public void setKupac(Kupac newKupac) {
		if (this.kupac == null || !this.kupac.equals(newKupac)) {
			if (this.kupac != null) {
				Kupac oldKupac = this.kupac;
				this.kupac = null;
				oldKupac.removeNarudzbenice(this);
			}
			if (newKupac != null) {
				this.kupac = newKupac;
				this.kupac.addNarudzbenice(this);
			}
		}
	}

	public int getBroj() {
		return broj;
	}

	public void setBroj(int broj) {
		this.broj = broj;
	}

	public Date getDatum() {
		return datum;
	}

	public void setDatum(Date datum) {
		this.datum = datum;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public Stanje getStanje() {
		return stanje;
	}

	public void setStanje(Stanje stanje) {
		this.stanje = stanje;
	}

}