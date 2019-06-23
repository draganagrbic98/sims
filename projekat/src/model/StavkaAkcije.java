package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  StavkaAkcije.java
 * Author:  Dragana
 * Purpose: Defines the Class StavkaAkcije
 ***********************************************************************/

import java.util.*;

/** @pdOid 9b7dcf82-8bcf-495d-a814-8763b4fe0282 */
public class StavkaAkcije implements Serializable{
   /** @pdOid d50f0555-e860-422e-bbba-9deb5843e63d */
   private int snizenje;
   
   /** @pdRoleInfo migr=no name=Akcija assc=association14 mult=1..1 side=A */
   private Akcija akcija;
   /** @pdRoleInfo migr=no name=Artikal assc=association15 mult=1..1 side=A */
   private Artikal artikal;
   
   public StavkaAkcije() {
	   super();
   }
   
   public StavkaAkcije(int snizenje, Akcija akcija, Artikal artikal) {
	   super();
	   this.snizenje = snizenje;
	   this.akcija = akcija;
	   this.artikal = artikal;
   }

/** @pdGenerated default parent getter */
   public Akcija getAkcije() {
      return akcija;
   }
   
   /** @pdGenerated default parent setter
     * @param newAkcija */
   public void setAkcije(Akcija newAkcija) {
      if (this.akcija == null || !this.akcija.equals(newAkcija))
      {
         if (this.akcija != null)
         {
            Akcija oldAkcija = this.akcija;
            this.akcija = null;
            oldAkcija.removeStavke(this);
         }
         if (newAkcija != null)
         {
            this.akcija = newAkcija;
            this.akcija.addStavke(this);
         }
      }
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
            oldArtikal.removeAkcije(this);
         }
         if (newArtikal != null)
         {
            this.artikal = newArtikal;
            this.artikal.addAkcije(this);
         }
      }
   }

public int getSnizenje() {
	return snizenje;
}

public void setSnizenje(int snizenje) {
	this.snizenje = snizenje;
}

public Akcija getAkcija() {
	return akcija;
}

public void setAkcija(Akcija akcija) {
	this.akcija = akcija;
}

}