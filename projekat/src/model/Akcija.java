package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Akcija.java
 * Author:  Dragana
 * Purpose: Defines the Class Akcija
 ***********************************************************************/

import java.util.*;

/** @pdOid 526e8e5f-142d-428c-ab67-57026a469e90 */
public class Akcija implements Serializable {
	/** @pdOid 1ec6a279-1cca-4649-a488-5198bc6892a8 */
	private Date pocetak;
	/** @pdOid 3ca9ea89-48cb-4ac2-b1ac-4dfbd8a2fea5 */
	private Date kraj;

	/**
	 * @pdRoleInfo migr=no name=StavkaAkcije assc=association14
	 *             coll=java.util.Collection impl=java.util.HashSet mult=0..*
	 *             type=Aggregation
	 */
	private java.util.Collection<StavkaAkcije> stavke;

	public Akcija() {
		super();
		this.stavke = new ArrayList<>();

	}

	public Akcija(Date pocetak, Date kraj) {
		this();
		this.pocetak = pocetak;
		this.kraj = kraj;
	}

	/** @pdGenerated default getter */
	public java.util.Collection<StavkaAkcije> getStavke() {
		if (stavke == null)
			stavke = new java.util.HashSet<StavkaAkcije>();
		return stavke;
	}

	/** @pdGenerated default iterator getter */
	public java.util.Iterator getIteratorStavke() {
		if (stavke == null)
			stavke = new java.util.HashSet<StavkaAkcije>();
		return stavke.iterator();
	}

	/**
	 * @pdGenerated default setter
	 * @param newStavke
	 */
	public void setStavke(java.util.Collection<StavkaAkcije> newStavke) {
		removeAllStavke();
		for (java.util.Iterator iter = newStavke.iterator(); iter.hasNext();)
			addStavke((StavkaAkcije) iter.next());
	}

	/**
	 * @pdGenerated default add
	 * @param newStavkaAkcije
	 */
	public void addStavke(StavkaAkcije newStavkaAkcije) {
		if (newStavkaAkcije == null)
			return;
		if (this.stavke == null)
			this.stavke = new java.util.HashSet<StavkaAkcije>();
		if (!this.stavke.contains(newStavkaAkcije)) {
			this.stavke.add(newStavkaAkcije);
			newStavkaAkcije.setAkcije(this);
		}
	}

	/**
	 * @pdGenerated default remove
	 * @param oldStavkaAkcije
	 */
	public void removeStavke(StavkaAkcije oldStavkaAkcije) {
		if (oldStavkaAkcije == null)
			return;
		if (this.stavke != null)
			if (this.stavke.contains(oldStavkaAkcije)) {
				this.stavke.remove(oldStavkaAkcije);
				oldStavkaAkcije.setAkcije((Akcija) null);
			}
	}

	/** @pdGenerated default removeAll */
	public void removeAllStavke() {
		if (stavke != null) {
			StavkaAkcije oldStavkaAkcije;
			for (java.util.Iterator iter = getIteratorStavke(); iter.hasNext();) {
				oldStavkaAkcije = (StavkaAkcije) iter.next();
				iter.remove();
				oldStavkaAkcije.setAkcije((Akcija) null);
			}
		}
	}

	public Date getPocetak() {
		return pocetak;
	}

	public void setPocetak(Date pocetak) {
		this.pocetak = pocetak;
	}

	public Date getKraj() {
		return kraj;
	}

	public void setKraj(Date kraj) {
		this.kraj = kraj;
	}

}