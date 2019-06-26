package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import model.WebShop;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {

		/*
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out"));
		out.writeObject(new WebShop("WAU")); out.flush(); out.close();
		 */
		
		ObjectInputStream in = new ObjectInputStream(new FileInputStream("out"));
		WebShop ws = (WebShop) in.readObject();
		in.close();

		if (!ws.imaAdmina())
			ws.dodajPodrazumevanogAdmina();

		MainFrame mw = new MainFrame(ws);
		mw.setVisible(true);
		
	}
}
