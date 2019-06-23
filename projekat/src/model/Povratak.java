package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Povratak.java
 * Author:  Dragana
 * Purpose: Defines the Class Povratak
 ***********************************************************************/

import java.util.*;

/** @pdOid 44b11464-a191-407e-a91b-be9c87b48edf */
public class Povratak implements Serializable{
   /** @pdOid 3dc7465e-00a9-4501-bc7f-b0b1f2522aed */
   private Date datum;
   /** @pdOid 97db674e-1c91-4bd3-9003-5eca366d3393 */
   private RazlogPovratka razlog;
   
   /** @pdRoleInfo migr=no name=Skladistenje assc=association23 mult=1..1 */
   private Skladistenje skladiste;
   /** @pdRoleInfo migr=no name=StavkaNarudzbenice assc=association22 mult=1..1 side=A */
   private StavkaNarudzbenice stavka;
   
   public Povratak() {
	   super();
   }

   public Povratak(Date datum, RazlogPovratka razlog, Skladistenje skladiste, StavkaNarudzbenice stavka) {
	   super();
	   this.datum = datum;
	   this.razlog = razlog;
	   this.skladiste = skladiste;
	   this.stavka = stavka;
   }

public Date getDatum() {
	return datum;
}

public void setDatum(Date datum) {
	this.datum = datum;
}

public RazlogPovratka getRazlog() {
	return razlog;
}

public void setRazlog(RazlogPovratka razlog) {
	this.razlog = razlog;
}

public Skladistenje getSkladiste() {
	return skladiste;
}

public void setSkladiste(Skladistenje skladiste) {
	this.skladiste = skladiste;
}

public StavkaNarudzbenice getStavka() {
	return stavka;
}

public void setStavka(StavkaNarudzbenice stavka) {
	this.stavka = stavka;
}
   
}
