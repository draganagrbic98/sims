package gui;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import model.WebShop;

public class Main {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
		// konstukotere sredi tako da kad postavis jedan postavi i drugog (povratne
		// veze)

		/*
		 * ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("out"));
		 * out.writeObject(new WebShop("WAU")); out.flush(); out.close();
		 */

		ObjectInputStream in = new ObjectInputStream(new FileInputStream("out"));
		WebShop ws = (WebShop) in.readObject();
		in.close();

		if (!ws.imaAdmina())
			ws.dodajPodrazumevanogAdmina();

		MainWindow mw = new MainWindow(ws);
		mw.setVisible(true);
	}
}
