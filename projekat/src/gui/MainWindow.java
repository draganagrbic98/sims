package gui;

import java.awt.BorderLayout;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import javax.swing.JFrame;

import model.WebShop;

public class MainWindow extends JFrame {
	private WebShop webShop;
	private CenterPanel centerPanel; // mozda ne mora da ima referencu ni na ovo
	private NorthPanel northPanel;// mozda ne mora da ima referencu ni na ovo

	public MainWindow(WebShop webShop) {
		super();
		this.centerPanel = new CenterPanel(webShop);
		this.webShop = webShop;

		this.setTitle("WebShop");
		this.setSize(1024, 768);
		this.setLocationRelativeTo(null);
		this.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		this.setLayout(new BorderLayout());

		this.add(this.centerPanel.getNorthPanel(), BorderLayout.NORTH);
		this.add(this.centerPanel, BorderLayout.CENTER);

		this.centerPanel.setWelcomeMessage();
		this.northPanel = this.centerPanel.getNorthPanel();
		this.northPanel.setUserPanel();

		this.addWindowListener(new WindowListener() {

			@Override
			public void windowOpened(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowIconified(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowDeiconified(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowDeactivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowClosing(WindowEvent e) {
				// TODO Auto-generated method stub
				ObjectOutputStream out;
				try {
					out = new ObjectOutputStream(new FileOutputStream("out"));
					out.writeObject(webShop);
					out.flush();
					out.close();
					System.out.println(webShop.getKorisnici().size());
					setVisible(false);
				} catch (FileNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}

			@Override
			public void windowClosed(WindowEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void windowActivated(WindowEvent e) {
				// TODO Auto-generated method stub
			}
		});
	}
}
