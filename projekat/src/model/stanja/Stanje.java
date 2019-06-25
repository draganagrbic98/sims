package model.stanja;

import java.io.Serializable;

import model.Narudzbenica;

/***********************************************************************
 * Module:  Stanje.java
 * Author:  Dragana
 * Purpose: Defines the Class Stanje
 ***********************************************************************/

/** @pdOid 474537ed-4d12-462f-a222-83ca48cb62c0 */
public abstract class Stanje implements Serializable {
	 /** @pdRoleInfo migr=no name=Narudzbenica assc=association21 mult=0..1 side=A */
	   protected Narudzbenica narudzbenica;
	   
	   /** @pdOid 436f31d0-9bc5-4840-ba27-05b009c6be9c */
	   public void entry() {
	      // TODO: implement
		   //BACI IZUZETAK
	   }
	   
	   /** @pdOid 70992fae-4399-436d-8a90-f8a5525fdc4b */
	   public void dodatArtikal() {
	      // TODO: implement
		   
		   
	   }
	   
	   /** @param kolicina
	    * @pdOid eb3c71b2-549b-4b36-a0ec-8b4254749f09 */
	   public void obrisanArtikal(int kolicina) {
	      // TODO: implement
	   }
	   
	   /** @pdOid f677f27b-6a4e-44e7-b418-9b0e56f3892d */
	   public void aktiviranZavrsetak() {
	      // TODO: implement
	   }
	   
	   /** @pdOid 20ec244e-ecf0-45a2-a7d8-b65e2c6930ab */
	   public void obavljenoPlacanje() {
	      // TODO: implement
	   }
	   
	   /** @pdOid fa7a452a-f471-4c76-b96c-8cde65c3c781 */
	   public void omoguciKupovinu() {
	      // TODO: implement
	   }
	   
	   
	   /** @pdOid 110fbd22-2e8d-4e18-be7b-a109114318de */
	   public void onemoguciBrisanjeNarudzbenice() {
	      // TODO: implement
	   }


	public Stanje(Narudzbenica narudzbenica) {
		super();
		this.narudzbenica = narudzbenica;
	}
	   
	   

}