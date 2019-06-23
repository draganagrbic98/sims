package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Cenovnik.java
 * Author:  Dragana
 * Purpose: Defines the Class Cenovnik
 ***********************************************************************/

import java.util.*;

/** @pdOid 7ac1868c-5371-47c4-9000-3c9d18ef36d7 */
public class Cenovnik implements Serializable{
   /** @pdOid 057ddd4a-f2fa-4ade-95b3-cc6d0c730151 */
   private int broj;
   /** @pdOid fbdf02a2-ccf2-491b-b66e-f765acf4db50 */
   private Date datum;
   
   /** @pdRoleInfo migr=no name=StavkaCenovnika assc=association5 coll=java.util.Collection impl=java.util.HashSet mult=0..* type=Aggregation */
   private java.util.Collection<StavkaCenovnika> stavke;
      
   public Cenovnik() {
	   super();
	   this.stavke = new ArrayList<>();
	   
   }
   
   public Cenovnik(int broj, Date datum) {
	   this();
	   this.broj = broj;
	   this.datum = datum;
   }
   
   

public Cenovnik(int broj, Date datum, Collection<StavkaCenovnika> stavke) {
	super();
	this.broj = broj;
	this.datum = datum;
	this.stavke = stavke;
}

/** @pdGenerated default getter */
   public java.util.Collection<StavkaCenovnika> getStavke() {
      if (stavke == null)
         stavke = new java.util.HashSet<StavkaCenovnika>();
      return stavke;
   }
   
   /** @pdGenerated default iterator getter */
   public java.util.Iterator getIteratorStavke() {
      if (stavke == null)
         stavke = new java.util.HashSet<StavkaCenovnika>();
      return stavke.iterator();
   }
   
   /** @pdGenerated default setter
     * @param newStavke */
   public void setStavke(java.util.Collection<StavkaCenovnika> newStavke) {
      removeAllStavke();
      for (java.util.Iterator iter = newStavke.iterator(); iter.hasNext();)
         addStavke((StavkaCenovnika)iter.next());
   }
   
   /** @pdGenerated default add
     * @param newStavkaCenovnika */
   public void addStavke(StavkaCenovnika newStavkaCenovnika) {
      if (newStavkaCenovnika == null)
         return;
      if (this.stavke == null)
         this.stavke = new java.util.HashSet<StavkaCenovnika>();
      if (!this.stavke.contains(newStavkaCenovnika))
      {
         this.stavke.add(newStavkaCenovnika);
         newStavkaCenovnika.setCenovnik(this);      
      }
   }
   
   /** @pdGenerated default remove
     * @param oldStavkaCenovnika */
   public void removeStavke(StavkaCenovnika oldStavkaCenovnika) {
      if (oldStavkaCenovnika == null)
         return;
      if (this.stavke != null)
         if (this.stavke.contains(oldStavkaCenovnika))
         {
            this.stavke.remove(oldStavkaCenovnika);
            oldStavkaCenovnika.setCenovnik((Cenovnik)null);
         }
   }
   
   /** @pdGenerated default removeAll */
   public void removeAllStavke() {
      if (stavke != null)
      {
         StavkaCenovnika oldStavkaCenovnika;
         for (java.util.Iterator iter = getIteratorStavke(); iter.hasNext();)
         {
            oldStavkaCenovnika = (StavkaCenovnika)iter.next();
            iter.remove();
            oldStavkaCenovnika.setCenovnik((Cenovnik)null);
         }
      }
   }
   
   /** @param artikal 
    * @param cena
    * @pdOid 151f9daa-5654-4b11-a70e-2e27c494ed61 */
   public void dodajStavku(Artikal artikal, double cena) {
      // TODO: implement
	   this.stavke.add(new StavkaCenovnika(artikal, cena));
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

	public void dodajStavke(Collection<StavkaCenovnika> stavke) {
		
		this.stavke = stavke;
		//for (StavkaCenovnika sc: this.stavke)
			//sc.setCenovnik(this);
		
	}

}