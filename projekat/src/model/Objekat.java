package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Objekat.java
 * Author:  Dragana
 * Purpose: Defines the Class Objekat
 ***********************************************************************/

import java.util.*;

import model.enumi.TipObjekta;

/** @pdOid 723f5bc4-0135-429c-b97e-b21412d77f9e */
public class Objekat implements Serializable {
	/** @pdOid e3e192fc-2131-4f15-b4fc-6e3a5fe66f85 */
	private String ime;
	/** @pdOid 2ad4d4d6-4b39-48ca-8c7e-3cd41c680529 */
	private String adresa;
	/** @pdOid 25323989-f299-487e-9dad-89f0cc074ec0 */
	private TipObjekta tip;

	/** @pdRoleInfo migr=no name=Mesto assc=association11 mult=1..1 */
	private Mesto mesto;
	/**
	 * @pdRoleInfo migr=no name=Skladistenje assc=association18
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 */
	private java.util.Collection<Skladistenje> artikli;

	public Objekat() {
		super();
		this.artikli = new ArrayList<>();
	}

	public Objekat(String ime, String adresa, TipObjekta tip, Mesto mesto) {
		this();
		this.ime = ime;
		this.adresa = adresa;
		this.tip = tip;
		this.mesto = mesto;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<Skladistenje> getArtikli() {
		if (artikli == null)
			artikli = new java.util.HashSet<Skladistenje>();
		return artikli;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorArtikli() {
		if (artikli == null)
			artikli = new java.util.HashSet<Skladistenje>();
		return artikli.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newArtikli
	 */
	public void setArtikli(java.util.Collection<Skladistenje> newArtikli) {
		removeAllArtikli();
		for (java.util.Iterator iter = newArtikli.iterator(); iter.hasNext();)
			addArtikli((Skladistenje) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newSkladistenje
	 */
	public void addArtikli(Skladistenje newSkladistenje) {
		if (newSkladistenje == null)
			return;
		if (this.artikli == null)
			this.artikli = new java.util.HashSet<Skladistenje>();
		if (!this.artikli.contains(newSkladistenje)) {
			this.artikli.add(newSkladistenje);
			newSkladistenje.setObjekat(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldSkladistenje
	 */
	public void removeArtikli(Skladistenje oldSkladistenje) {
		if (oldSkladistenje == null)
			return;
		if (this.artikli != null)
			if (this.artikli.contains(oldSkladistenje)) {
				this.artikli.remove(oldSkladistenje);
				oldSkladistenje.setObjekat((Objekat) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllArtikli() {
		if (artikli != null) {
			Skladistenje oldSkladistenje;
			for (java.util.Iterator iter = getIteratorArtikli(); iter.hasNext();) {
				oldSkladistenje = (Skladistenje) iter.next();
				iter.remove();
				oldSkladistenje.setObjekat((Objekat) null);
			}
		}
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public TipObjekta getTip() {
		return tip;
	}

	public void setTip(TipObjekta tip) {
		this.tip = tip;
	}

	public Mesto getMesto() {
		return mesto;
	}

	public void setMesto(Mesto mesto) {
		this.mesto = mesto;
	}

}