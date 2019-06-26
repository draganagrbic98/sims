package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  StavkaNarudzbenice.java
 * Author:  Dragana
 * Purpose: Defines the Class StavkaNarudzbenice
 ***********************************************************************/

/** @pdOid 7fe4d36a-5984-446d-9f53-a6b9470cf73b */
public class StavkaNarudzbenice implements Serializable {
	/** @pdOid 6a95b3ec-cd3b-4635-a451-aa5d51ef62a5 */
	private double cena;
	/** @pdOid 6f06bb09-639f-4c24-a3a9-8798f2574de5 */
	private int kolicina;
	/** @pdOid ba10710f-f72f-4822-893c-c7e6983e18bd */
	private double ukupnaCena;

	/** @pdRoleInfo migr=no name=Artikal assc=association9 mult=1..1 */
	private Artikal artikal;

	/** @pdRoleInfo migr=no name=Povratak assc=association22 mult=0..1 */
	private Povratak povracaj;
	/** @pdRoleInfo migr=no name=Narudzbenica assc=association8 mult=1..1 side=A */
	private Narudzbenica narudzbenica;

	public StavkaNarudzbenice() {
		super();
	}




	public StavkaNarudzbenice(Artikal artikal, Narudzbenica narudzbenica) {
		super();
		this.artikal = artikal;
		this.narudzbenica = narudzbenica;
		this.cena = this.artikal.getCena();
		
		
		this.kolicina = 1;
		this.ukupnaCena = this.cena * this.kolicina;
		
	}




	/** @pdGenerated default parent getter */
	public Narudzbenica getNarudzbenica() {
		return narudzbenica;
	}

	/**
	 * @pdGenerated default parent setter
	 * @param newNarudzbenica
	 */
	public void setNarudzbenica(Narudzbenica newNarudzbenica) {
		if (this.narudzbenica == null || !this.narudzbenica.equals(newNarudzbenica)) {
			if (this.narudzbenica != null) {
				Narudzbenica oldNarudzbenica = this.narudzbenica;
				this.narudzbenica = null;
				oldNarudzbenica.removeStavke(this);
			}
			if (newNarudzbenica != null) {
				this.narudzbenica = newNarudzbenica;
				this.narudzbenica.addStavke(this);
			}
		}
	}

	public double getCena() {
		return cena;
	}

	public void setCena(double cena) {
		this.cena = cena;
	}

	public int getKolicina() {
		return kolicina;
	}

	public void setKolicina(int kolicina) {
		this.kolicina = kolicina;
	}

	public double getUkupnaCena() {
		return ukupnaCena;
	}

	public void setUkupnaCena(double ukupnaCena) {
		this.ukupnaCena = ukupnaCena;
	}

	public Artikal getArtikal() {
		return artikal;
	}

	public void setArtikal(Artikal artikal) {
		this.artikal = artikal;
	}



	public Povratak getPovracaj() {
		return povracaj;
	}

	public void setPovracaj(Povratak povracaj) {
		this.povracaj = povracaj;
	}

	public void povecajKolicinu() {
		
		++this.kolicina;
		this.ukupnaCena = this.kolicina * this.cena;
		
		
	}
	
}