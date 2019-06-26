package model.stanja;

/***********************************************************************
 * Module:  Naruceno.java
 * Author:  Dragana
 * Purpose: Defines the Class Naruceno
 ***********************************************************************/

import java.util.*;

import model.Narudzbenica;

/** @pdOid 75b155e7-3cb7-451e-85f1-77159ae3bc83 */
public class Kupljeno extends Stanje {
   public Kupljeno(Narudzbenica narudzbenica) {
		super(narudzbenica);
		// TODO Auto-generated constructor stub
	}

/** @pdOid d2de1930-6502-4222-8b03-0f9437c0bd65 */
   @Override
	public void entry() {
		// TODO Auto-generated method stub

	   this.narudzbenica.blokirajKupovinu();
	   this.narudzbenica.posaljiRobu();
	   this.narudzbenica.onemoguciBrisanjeNarudzbenice();
	   
	}
   
   /** @pdOid e1f443e6-9e4c-4379-b29b-f22ad71d5e11 */
   @Override
	public void dodatArtikal() {
		// TODO Auto-generated method stub
		super.dodatArtikal();
	}
   
   /** @param kolicina
    * @pdOid e0fb2b98-7b4d-4d2a-99b4-314a95600fd3 */
   @Override
	public void obrisanArtikal(int kolicina) {
		// TODO Auto-generated method stub
		super.obrisanArtikal(kolicina);
	}
   
   /** @pdOid b94b3db5-ab25-42bc-b8a7-a339c532ac16 */
   @Override
	public void aktiviranZavrsetak() {
		// TODO Auto-generated method stub
		super.aktiviranZavrsetak();
	}
   
   /** @pdOid 233b4bf7-5cc3-448d-b2c5-9c31d576e3f0 */
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