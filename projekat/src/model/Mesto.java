package model;

import java.io.Serializable;

/***********************************************************************
 * Module:  Mesto.java
 * Author:  Dragana
 * Purpose: Defines the Class Mesto
 ***********************************************************************/

/** @pdOid 4eab939c-3b5c-4817-9dd2-9bd4015a148a */
public class Mesto implements Serializable {
	/** @pdOid c9f573a0-d7cf-462c-acb1-97202551b949 */
	private String ime;
	/** @pdOid d5e15c5e-99b3-47bd-8c20-fb16a0556aac */
	private int ppt;

	public Mesto() {
		super();
	}

	public Mesto(String ime, int ppt) {
		super();
		this.ime = ime;
		this.ppt = ppt;
	}

	public Mesto(String ime) {
		super();
		this.ime = ime;
	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public int getPpt() {
		return ppt;
	}

	public void setPpt(int ppt) {
		this.ppt = ppt;
	}

}