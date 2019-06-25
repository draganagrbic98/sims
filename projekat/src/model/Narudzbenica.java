package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Narudzbenica.java
 * Author:  Dragana
 * Purpose: Defines the Class Narudzbenica
 ***********************************************************************/

import java.util.*;

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
		//this.stanje = new Formiranje();
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
	
	
	  
	   /** @param stanje
	    * @pdOid 991b789d-2de6-4ac0-af54-ca5310c47327 */
	   public void promeniStanje(Stanje stanje) {
	      // TODO: implement
	   }
	   
	   /** @pdOid d2169036-121b-46a8-b1f9-da38321f8d90 */
	   public void blokirajDodavanje() {
	      // TODO: implement
	   }
	   
	   /** @pdOid 585f3f45-74a5-4b68-a8f9-0b011abc681a */
	   public void blokirajBrisanje() {
	      // TODO: implement
	   }
	   
	   /** @pdOid 2561f36e-77f6-4433-86c2-0627513f5d8e */
	   public void blokirajZavrsetak() {
	      // TODO: implement
	   }
	   
	   /** @pdOid e99b87af-b977-4992-8ab8-248b79a3058e */
	   public void blokirajKupovinu() {
	      // TODO: implement
	   }
	   
	   /** @pdOid 478404de-4c71-4ef9-b5ec-e56ecc5f3375 */
	   public void omoguciBrisanje() {
	      // TODO: implement
	   }
	   
	   /** @pdOid e0f80957-5a89-472e-b286-470c391cc881 */
	   public void omoguciZavrsetak() {
	      // TODO: implement
	   }
	   
	   /** @pdOid a393f354-6472-4f49-bb97-4a8948ec543e */
	   public void osveziPrikaz() {
	      // TODO: implement
	   }
	   
	   /** @pdOid c107dc71-5e26-411a-922d-160b9570d73a */
	   public void posaljiRobu() {
	      // TODO: implement
	   }
	   
	   /** @param artikal
	    * @pdOid 9a2a52de-2724-4e1c-9023-0bd6f9f55038 */
	   public void dodajStavku(Artikal artikal) {
	      // TODO: implement
	   }
	   
	   /** @param stavka
	    * @pdOid 46a89f67-befe-4c1c-841e-c22c63ae32d8 */
	   public void obrisiStavku(StavkaNarudzbenice stavka) {
	      // TODO: implement
	   }
	   
	   /** @pdOid 4e84ebd3-3f30-423f-84fb-0a274f791698 */
	   public void aktiviranZavrsetak() {
	      // TODO: implement
	   }
	   
	   /** @pdOid 5c12eb01-e259-40d3-83ca-0a5d75f212d6 */
	   public void obavljenoPlacanje() {
	      // TODO: implement
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