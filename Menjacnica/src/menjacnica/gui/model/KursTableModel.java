package menjacnica.gui.model;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import kurs.Kurs;

public class KursTableModel extends AbstractTableModel {

	private final String[] kolone = new String[] { "Sifra", "Skraceni naziv", "Prodajni", "Srednji", "Kupovni",
			"Naziv" };
	private List<Kurs> kurs;

	public KursTableModel(List<Kurs> kurs) {
		this.kurs = kurs;
	}

	@Override
	public int getColumnCount() {
		return kolone.length;
	}

	@Override
	public int getRowCount() {
		try{
			return kurs.size();
		}catch(Exception e){
			return 0;
		}
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Kurs k = kurs.get(rowIndex);
		switch (columnIndex) {
		case 0:
			return k.getSifra();
		case 1:
			return k.getSkraceni();
		case 2:
			return k.getProdajni();
		case 3:
			return k.getSrednji();
		case 4:
			return k.getKupovni();
		case 5:
			return k.getNaziv();
		default:
			return 0;
		}
	}

	@Override
	public String getColumnName(int column) {
		return kolone[column];
	}

	public void staviSveKurseve(List<Kurs> kursevi) {
		this.kurs = kursevi;
		fireTableDataChanged();
	}

	public Kurs vratiKurs(int index) {
		return kurs.get(index);

	}
}
