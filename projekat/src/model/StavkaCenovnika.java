package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  StavkaCenovnika.java
 * Author:  Dragana
 * Purpose: Defines the Class StavkaCenovnika
 ***********************************************************************/

import java.util.*;

/** @pdOid 39075697-00d2-40e8-9631-873e1951f495 */
public class StavkaCenovnika implements Serializable{
   /** @pdOid 5c7c0488-7254-4d35-a34c-9ff7585189d7 */
   private double cena;
   
   /** @pdRoleInfo migr=no name=Cenovnik assc=association5 mult=1..1 side=A */
   private Cenovnik cenovnik;
   /** @pdRoleInfo migr=no name=Artikal assc=association6 mult=1..1 side=A */
   private Artikal artikal;
   
   public StavkaCenovnika() {
	   super();
   }

   public StavkaCenovnika(Artikal artikal, double cena) {
	   // TODO Auto-generated constructor stub
	   this.artikal = artikal;
	   this.cena = cena;
	   this.artikal.dodajCenu(this);
   }

public StavkaCenovnika(Artikal artikal, double cena, Cenovnik cenovnik) {
	// TODO Auto-generated constructor stub
	this.artikal = artikal;
	this.cena = cena;
	this.cenovnik = cenovnik;
	this.artikal.dodajCenu(this);
}

/** @pdGenerated default parent getter */
   public Cenovnik getCenovnik() {
      return cenovnik;
   }
   
   /** @pdGenerated default parent setter
     * @param newCenovnik */
   public void setCenovnik(Cenovnik newCenovnik) {
	   /*
      if (this.cenovnik == null || !this.cenovnik.equals(newCenovnik))
      {
         if (this.cenovnik != null)
         {
            Cenovnik oldCenovnik = this.cenovnik;
            this.cenovnik = null;
            oldCenovnik.removeStavke(this);
         }
         if (newCenovnik != null)
         {
            this.cenovnik = newCenovnik;
            this.cenovnik.addStavke(this);
         }
      }*/
	   this.cenovnik = newCenovnik;
	   
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
            oldArtikal.removeCene(this);
         }
         if (newArtikal != null)
         {
            this.artikal = newArtikal;
            this.artikal.addCene(this);
         }
      }
   }

public double getCena() {
	return cena;
}

public void setCena(double cena) {
	this.cena = cena;
}

}