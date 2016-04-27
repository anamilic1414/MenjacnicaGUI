package menjacnica.gui;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Dimension;
import javax.swing.JButton;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class DodajKursGUI extends JFrame {

	private JPanel contentPane;
	private JLabel lblifra;
	private JLabel lblNaziv;
	private JTextField txtsifra;
	private JTextField txtNaziv;
	private JLabel lblProdajniKurs;
	private JTextField txtProdajniKurs;
	private JLabel lblKupovniKurs;
	private JTextField txtKupovniKurs;
	private JLabel lblSrednjiKurs;
	private JTextField txtSrednjiKurs;
	private JLabel lblSkraeniNaziv;
	private JTextField txtSkraceniNaziv;
	private JButton btnDodaj;
	private JButton btnOdustani;

	/**
	 * Create the frame.
	 */
	public DodajKursGUI() {
		setResizable(false);
		setTitle("Dodaj kurs");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 319, 252);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new GridLayout(7, 2, 5, 5));
		contentPane.add(getLblifra());
		contentPane.add(getLblNaziv());
		contentPane.add(getTxtsifra());
		contentPane.add(getTxtNaziv());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getTxtProdajniKurs());
		contentPane.add(getTxtKupovniKurs());
		contentPane.add(getLblSrednjiKurs());
		contentPane.add(getLblSkraeniNaziv());
		contentPane.add(getTxtSrednjiKurs());
		contentPane.add(getTxtSkraceniNaziv());
		contentPane.add(getBtnDodaj());
		contentPane.add(getBtnOdustani());
	}

	private JLabel getLblifra() {
		if (lblifra == null) {
			lblifra = new JLabel("\u0160ifra");
		}
		return lblifra;
	}

	private JLabel getLblNaziv() {
		if (lblNaziv == null) {
			lblNaziv = new JLabel("Naziv");
		}
		return lblNaziv;
	}

	private JTextField getTxtsifra() {
		if (txtsifra == null) {
			txtsifra = new JTextField();
			txtsifra.setColumns(10);
		}
		return txtsifra;
	}

	private JTextField getTxtNaziv() {
		if (txtNaziv == null) {
			txtNaziv = new JTextField();
			txtNaziv.setColumns(10);
		}
		return txtNaziv;
	}

	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
		}
		return lblProdajniKurs;
	}

	private JTextField getTxtProdajniKurs() {
		if (txtProdajniKurs == null) {
			txtProdajniKurs = new JTextField();
			txtProdajniKurs.setColumns(10);
		}
		return txtProdajniKurs;
	}

	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
		}
		return lblKupovniKurs;
	}

	private JTextField getTxtKupovniKurs() {
		if (txtKupovniKurs == null) {
			txtKupovniKurs = new JTextField();
			txtKupovniKurs.setColumns(10);
		}
		return txtKupovniKurs;
	}

	private JLabel getLblSrednjiKurs() {
		if (lblSrednjiKurs == null) {
			lblSrednjiKurs = new JLabel("Srednji kurs");
		}
		return lblSrednjiKurs;
	}

	private JTextField getTxtSrednjiKurs() {
		if (txtSrednjiKurs == null) {
			txtSrednjiKurs = new JTextField();
			txtSrednjiKurs.setPreferredSize(new Dimension(6, 10));
			txtSrednjiKurs.setColumns(10);
		}
		return txtSrednjiKurs;
	}

	private JLabel getLblSkraeniNaziv() {
		if (lblSkraeniNaziv == null) {
			lblSkraeniNaziv = new JLabel("Skra\u0107eni naziv");
		}
		return lblSkraeniNaziv;
	}

	private JTextField getTxtSkraceniNaziv() {
		if (txtSkraceniNaziv == null) {
			txtSkraceniNaziv = new JTextField();
			txtSkraceniNaziv.setPreferredSize(new Dimension(5, 10));
			txtSkraceniNaziv.setColumns(10);
		}
		return txtSkraceniNaziv;
	}


	private JButton getBtnDodaj() {
		if (btnDodaj == null) {
			btnDodaj = new JButton("Dodaj");
			btnDodaj.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					double sifra = Double.parseDouble(txtsifra.getText());
					String naziv = txtNaziv.getText();
					double prodajni = Double.parseDouble(txtProdajniKurs.getText());
					double kupovni = Double.parseDouble(txtKupovniKurs.getText());
					double srednji = Double.parseDouble(txtSrednjiKurs.getText());
					String skraceniNaziv = txtSkraceniNaziv.getText();
					GUIKontroler.dodajKurs(sifra, naziv, prodajni, kupovni, srednji, skraceniNaziv);
					GUIKontroler.ubaciKursUPolje(sifra, naziv, prodajni, kupovni, srednji, skraceniNaziv);					
					
				}
			});
		}
		return btnDodaj;
	}

	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toBack();
				}
			});
		}
		return btnOdustani;
	}
}
