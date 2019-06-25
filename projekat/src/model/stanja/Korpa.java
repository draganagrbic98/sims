package model.stanja;

/***********************************************************************
 * Module:  Korpa.java
 * Author:  Dragana
 * Purpose: Defines the Class Korpa
 ***********************************************************************/

import java.util.*;

import model.Narudzbenica;

/** @pdOid 04e0b605-2315-4f50-8423-9d1319ff4e90 */
public class Korpa extends Stanje {
   public Korpa(Narudzbenica narudzbenica) {
		super(narudzbenica);
		// TODO Auto-generated constructor stub
	}

/** @pdOid 6325bcf7-496c-49e6-881d-f7150ec9773f */
   @Override
	public void entry() {
		// TODO Auto-generated method stub
		this.narudzbenica.osveziPrikaz();
		
	}
   
   /** @pdOid f2696c27-b638-425c-b50c-8564b908c9af */
   @Override
	public void dodatArtikal() {
		// TODO Auto-generated method stub
	   this.narudzbenica.omoguciBrisanje();
	   this.narudzbenica.omoguciZavrsetak();
	   this.narudzbenica.promeniStanje(this);

	}
   
   /** @param kolicina
    * @pdOid ba27d326-e316-46d6-9f6a-eba1a25801a6 */
   @Override
	public void obrisanArtikal(int kolicina) {
		// TODO Auto-generated method stub

	   if (kolicina > 0) {
		   
		   this.narudzbenica.promeniStanje(this);
		   
	   }
	   else {
		   
		   this.narudzbenica.blokirajBrisanje();
		   this.narudzbenica.blokirajZavrsetak();
		   this.narudzbenica.promeniStanje(this);
		   
	   }
	   
	}
   
   /** @pdOid 9791475b-4c5b-45c3-821d-fd5fa1ab6ff5 */
   @Override
	public void aktiviranZavrsetak() {
		// TODO Auto-generated method stub

	   Stanje novo = new Zavrsetak(this.narudzbenica);
	   this.narudzbenica.promeniStanje(novo);
	   
	   
	}
   
   /** @pdOid bb0e8dea-106a-4fec-b048-3b0ffc492f9b */
   @Override
	public void obavljenoPlacanje() {
		// TODO Auto-generated method stub
		super.obavljenoPlacanje();
	}
   
   /** @pdOid be7cadcb-8960-4443-a60b-6173cb31d2df */
   @Override
	public void omoguciKupovinu() {
		// TODO Auto-generated method stub
		super.omoguciKupovinu();
	}

   
   /** @pdOid 110fbd22-2e8d-4e18-be7b-a109114318de */
   @Override
	public void onemoguciBrisanjeNarudzbenice() {
		// TODO Auto-generated method stub
		super.onemoguciBrisanjeNarudzbenice();
	}


}