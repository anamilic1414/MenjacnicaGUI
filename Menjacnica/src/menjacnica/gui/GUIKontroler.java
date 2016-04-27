package menjacnica.gui;

import java.awt.EventQueue;
import java.util.LinkedList;

import javax.swing.JOptionPane;

import kurs.Kurs;

public class GUIKontroler {

	private static MenjacnicaGUI glavniProzor;
	private static LinkedList<Kurs> kurs;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kurs = new LinkedList<Kurs>();
					glavniProzor = new MenjacnicaGUI();
					glavniProzor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public static void ugasiAplikaciju() {
		int opcija = JOptionPane.showConfirmDialog(glavniProzor.getContentPane(),
				"Da li zelite da zatvorite aplikaciju?", "Izlazak", JOptionPane.YES_NO_OPTION);

		if (opcija == JOptionPane.YES_OPTION) {
			System.exit(0);
		}
	}
	
	public static void ubaciKursUPolje(double sifra,String naziv,double prodajni,double kupovni,double srednji,String skraceniNaziv){
		
			glavniProzor.upisiUPolje(sifra, naziv, prodajni, kupovni, srednji, skraceniNaziv);	
			glavniProzor.osveziTabelu();
	}
	
	public static void dodajKurs(double sifra,String naziv,double prodajni,double kupovni,double srednji,String skraceniNaziv){
		Kurs k = new Kurs();
		k.setSifra(sifra);
		k.setNaziv(naziv);
		k.setProdajni(prodajni);
		k.setKupovni(kupovni);
		k.setSrednji(srednji);
		k.setSkraceni(skraceniNaziv);
		kurs.add(k);
		glavniProzor.osveziTabelu();
		
	}
	
	public static LinkedList<Kurs> getKurs() {
		return kurs;
	}
	
	public static void pokreniDodajKursProzor(){
		DodajKursGUI prozor = new DodajKursGUI();
		prozor.setVisible(true);
		prozor.setLocationRelativeTo(null);
	}
}
