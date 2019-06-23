package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Skladistenje.java
 * Author:  Dragana
 * Purpose: Defines the Class Skladistenje
 ***********************************************************************/

import java.util.*;

/** @pdOid 35c7b535-f138-4493-834c-4745d74e8852 */
public class Skladistenje implements Serializable{
   /** @pdOid 743d1d49-92c5-4b2f-b283-e3aaa20602ee */
   private int kolicina;
   
   /** @pdRoleInfo migr=no name=Artikal assc=association17 mult=1..1 side=A */
   private Artikal artikal;
   /** @pdRoleInfo migr=no name=Objekat assc=association18 mult=1..1 side=A */
   private Objekat objekat;
   
   public Skladistenje() {
	   super();
   }
   
   public Skladistenje(int kolicina, Artikal artikal, Objekat objekat) {
	   super();
	   this.kolicina = kolicina;
	   this.artikal = artikal;
	   this.objekat = objekat;
   }

/** @pdGenerated default parent getter */
   public Artikal getArtikal() {
      return artikal;
   }
   
   /** @pdGenerated default parent setter
     * @param newArtikal */
   public void setArtikal(Artikal newArtikal) {
      if (this.artikal == null || !this.artikal.equals(newArtikal))
      {
         if (this.artikal != null)
         {
            Artikal oldArtikal = this.artikal;
            this.artikal = null;
            oldArtikal.removeSkladista(this);
         }
         if (newArtikal != null)
         {
            this.artikal = newArtikal;
            this.artikal.addSkladista(this);
         }
      }
   }
   /** @pdGenerated default parent getter */
   public Objekat getObjekat() {
      return objekat;
   }
   
   /** @pdGenerated default parent setter
     * @param newObjekat */
   public void setObjekat(Objekat newObjekat) {
      if (this.objekat == null || !this.objekat.equals(newObjekat))
      {
         if (this.objekat != null)
         {
            Objekat oldObjekat = this.objekat;
            this.objekat = null;
            oldObjekat.removeArtikli(this);
         }
         if (newObjekat != null)
         {
            this.objekat = newObjekat;
            this.objekat.addArtikli(this);
         }
      }
   }

public int getKolicina() {
	return kolicina;
}

public void setKolicina(int kolicina) {
	this.kolicina = kolicina;
}

}