package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Korisnik;

public class MenadzerModel extends AbstractTableModel {

	private String[] columnNames = { "Korisnicko ime", "Lozinka" };
	private List<Korisnik> managers;

	public MenadzerModel(List<Korisnik> managers) {
		super();
		this.managers = managers;
	}

	@Override
	public int getRowCount() {
		// TODO Auto-generated method stub
		return this.managers.size();
	}

	@Override
	public int getColumnCount() {
		// TODO Auto-generated method stub
		return this.columnNames.length;
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		Korisnik user = this.managers.get(rowIndex);
		if (columnIndex == 0)
			return user.getKorisnickoIme();
		return user.getLozinka();
	}

	@Override
	public boolean isCellEditable(int rowIndex, int columnIndex) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public String getColumnName(int column) {
		// TODO Auto-generated method stub
		return this.columnNames[column];
	}

}
