package model;

import java.io.Serializable;

import model.enumi.Uloga;

/***********************************************************************
 * Module:  Korisnik.java
 * Author:  Dragana
 * Purpose: Defines the Class Korisnik
 ***********************************************************************/

/** @pdOid 79b28b6a-35e4-488a-8ba1-7a602ac4392d */
public class Korisnik implements Serializable {
	/** @pdOid b3478983-caf7-40ab-9e47-81d8ab8459e9 */
	private String korisnickoIme;
	/** @pdOid dd938f71-e10a-473f-ad64-3f0076aa244b */
	private String lozinka;
	/** @pdOid 90ac0945-8142-413e-87c5-1ee86018d908 */
	private Uloga uloga;

	/** @pdRoleInfo migr=no name=Kupac assc=association2 mult=0..1 */
	private Kupac kupac;

	public Korisnik() {
		super();
	}

	public Korisnik(String korisnickoIme, String lozinka, Uloga uloga) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.uloga = uloga;
	}

	public Korisnik(String korisnickoIme, String lozinka, Uloga uloga, Kupac kupac) {
		super();
		this.korisnickoIme = korisnickoIme;
		this.lozinka = lozinka;
		this.uloga = uloga;
		this.kupac = kupac;
		this.kupac.setKorisnik(this);
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnickoIme) {
		this.korisnickoIme = korisnickoIme;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	public Uloga getUloga() {
		return uloga;
	}

	public void setUloga(Uloga uloga) {
		this.uloga = uloga;
	}

	public Kupac getKupac() {
		return kupac;
	}

	public void setKupac(Kupac kupac) {
		this.kupac = kupac;
	}

}
