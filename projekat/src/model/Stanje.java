package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Stanje.java
 * Author:  Dragana
 * Purpose: Defines the Class Stanje
 ***********************************************************************/

import java.util.*;

/** @pdOid 474537ed-4d12-462f-a222-83ca48cb62c0 */
public abstract class Stanje implements Serializable{
   /** @pdRoleInfo migr=no name=Narudzbenica assc=association21 mult=0..1 side=A */
   private Narudzbenica narudzbenica;

   public Stanje() {
	   super();
   }

   public Stanje(Narudzbenica narudzbenica) {
	   super();
	   this.narudzbenica = narudzbenica;
   }

public Narudzbenica getNarudzbenica() {
	return narudzbenica;
}

public void setNarudzbenica(Narudzbenica narudzbenica) {
	this.narudzbenica = narudzbenica;
}

}