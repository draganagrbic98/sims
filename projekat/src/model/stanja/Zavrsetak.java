package model.stanja;

/***********************************************************************
 * Module:  Zavrsetak.java
 * Author:  Dragana
 * Purpose: Defines the Class Zavrsetak
 ***********************************************************************/

import java.util.*;

import model.Narudzbenica;

/** @pdOid b93c6d2b-6a1b-4113-af7e-84317386d5d2 */
public class Zavrsetak extends Stanje {
   public Zavrsetak(Narudzbenica narudzbenica) {
		super(narudzbenica);
		// TODO Auto-generated constructor stub
	}

/** @pdOid be41bea3-d693-4fa6-a610-ad3883b3b4ff */
   @Override
	public void entry() {
		// TODO Auto-generated method stub

	   this.narudzbenica.blokirajDodavanje();
	   this.narudzbenica.blokirajBrisanje();
	   this.narudzbenica.blokirajZavrsetak();
	   this.narudzbenica.omoguciKupovinu();
	   
	}
   
   /** @pdOid 6bc7b73f-a8e8-4991-93a8-ada5bbacd24d */
   @Override
	public void dodatArtikal() {
		// TODO Auto-generated method stub
		super.dodatArtikal();
	}
   
   /** @param kolicina
    * @pdOid 3bd632bf-86d9-4a54-bba9-096972fcab7c */
   @Override
	public void obrisanArtikal(int kolicina) {
		// TODO Auto-generated method stub
		super.obrisanArtikal(kolicina);
	}
   
   /** @pdOid c02d27a6-44d3-45d9-bd5b-4494f0063694 */
   @Override
	public void aktiviranZavrsetak() {
		// TODO Auto-generated method stub
		super.aktiviranZavrsetak();
	}
   
   /** @pdOid 75e989bd-ef5a-4183-9920-388c0936bbd7 */
   @Override
	public void obavljenoPlacanje() {
		// TODO Auto-generated method stub

	   Stanje novo = new Naruceno(this.narudzbenica);
	   this.narudzbenica.promeniStanje(novo);
	   
	   
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