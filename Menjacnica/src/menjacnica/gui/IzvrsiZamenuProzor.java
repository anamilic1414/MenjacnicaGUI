package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ButtonGroup;
import javax.swing.event.AncestorListener;
import javax.swing.event.AncestorEvent;
import javax.swing.event.ChangeListener;
import javax.swing.event.ChangeEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class IzvrsiZamenuProzor extends JFrame {

	private JPanel contentPane;
	private JLabel lblKupovniKurs;
	private JLabel lblProdajniKurs;
	private JTextField txtKupovni;
	private JTextField txtProdajni;
	private JComboBox comboBox;
	private JLabel lblIznos;
	private JTextField txtIznos;
	private JLabel lblVrstaTransakcije;
	private JRadioButton rdKupovina;
	private JRadioButton rdProdaja;
	private JSlider slider;
	private JButton btnIzvriZamenu;
	private JButton btnOdustani;
	private final ButtonGroup buttonGroup = new ButtonGroup();

	/**
	 * Create the frame.
	 */
	public IzvrsiZamenuProzor() {
		setResizable(false);
		setTitle("Izvr\u0161i zamenu");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 327);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.add(getLblKupovniKurs());
		contentPane.add(getLblProdajniKurs());
		contentPane.add(getTxtKupovni());
		contentPane.add(getTxtProdajni());
		contentPane.add(getComboBox());
		contentPane.add(getLblIznos());
		contentPane.add(getTxtIznos());
		contentPane.add(getLblVrstaTransakcije());
		contentPane.add(getRdKupovina());
		contentPane.add(getRdProdaja());
		contentPane.add(getSlider());
		contentPane.add(getBtnIzvriZamenu());
		contentPane.add(getBtnOdustani());
	}
	private JLabel getLblKupovniKurs() {
		if (lblKupovniKurs == null) {
			lblKupovniKurs = new JLabel("Kupovni kurs");
			lblKupovniKurs.setBounds(43, 11, 79, 19);
		}
		return lblKupovniKurs;
	}
	private JLabel getLblProdajniKurs() {
		if (lblProdajniKurs == null) {
			lblProdajniKurs = new JLabel("Prodajni kurs");
			lblProdajniKurs.setBounds(262, 11, 79, 19);
		}
		return lblProdajniKurs;
	}
	private JTextField getTxtKupovni() {
		if (txtKupovni == null) {
			txtKupovni = new JTextField();
			txtKupovni.setEditable(false);
			txtKupovni.setBounds(35, 35, 99, 28);
			txtKupovni.setColumns(10);
		}
		return txtKupovni;
	}
	private JTextField getTxtProdajni() {
		if (txtProdajni == null) {
			txtProdajni = new JTextField();
			txtProdajni.setEditable(false);
			txtProdajni.setBounds(254, 35, 99, 28);
			txtProdajni.setColumns(10);
		}
		return txtProdajni;
	}
	private JComboBox getComboBox() {
		if (comboBox == null) {
			comboBox = new JComboBox();
			comboBox.setModel(new DefaultComboBoxModel(new String[] {"EUR", "USD", "CHF"}));
			comboBox.setBounds(161, 39, 67, 20);
			comboBox.setSelectedIndex(0);
			getContentPane().add(comboBox);
		}
		return comboBox;
	}
	private JLabel getLblIznos() {
		if (lblIznos == null) {
			lblIznos = new JLabel("Iznos");
			lblIznos.setBounds(43, 90, 46, 14);
		}
		return lblIznos;
	}
	private JTextField getTxtIznos() {
		if (txtIznos == null) {
			txtIznos = new JTextField();
			txtIznos.setBounds(35, 115, 141, 28);
			txtIznos.setColumns(10);
		}
		return txtIznos;
	}
	private JLabel getLblVrstaTransakcije() {
		if (lblVrstaTransakcije == null) {
			lblVrstaTransakcije = new JLabel("Vrsta transakcije");
			lblVrstaTransakcije.setBounds(223, 88, 118, 19);
		}
		return lblVrstaTransakcije;
	}
	private JRadioButton getRdKupovina() {
		if (rdKupovina == null) {
			rdKupovina = new JRadioButton("Kupovina");
			buttonGroup.add(rdKupovina);
			rdKupovina.setBounds(229, 118, 109, 23);
		}
		return rdKupovina;
	}
	private JRadioButton getRdProdaja() {
		if (rdProdaja == null) {
			rdProdaja = new JRadioButton("Prodaja");
			buttonGroup.add(rdProdaja);
			rdProdaja.setBounds(229, 140, 112, 23);
		}
		return rdProdaja;
	}
	private JSlider getSlider() {
		if (slider == null) {
			slider = new JSlider();
			slider.addChangeListener(new ChangeListener() {
				public void stateChanged(ChangeEvent arg0) {
					txtIznos.setText(""+slider.getValue());
				}
			});
			slider.setSnapToTicks(true);
			slider.setValueIsAdjusting(true);
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			slider.setMinorTickSpacing(1);
			slider.setMajorTickSpacing(10);
			slider.setBounds(35, 180, 318, 45);
		}
		return slider;
	}
	private JButton getBtnIzvriZamenu() {
		if (btnIzvriZamenu == null) {
			btnIzvriZamenu = new JButton("Izvr\u0161i zamenu");
			btnIzvriZamenu.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					String valuta = (String) comboBox.getSelectedItem();
					double iznos = Double.parseDouble(txtIznos.getText());
					String izbor;
					if(buttonGroup.getSelection().equals(getRdKupovina())){
						izbor = "Kupovina";
					}else
						izbor = "Prodaja";
					GUIKontroler.ispisiZamenu(valuta, iznos, izbor);
					
				}
			});
			btnIzvriZamenu.setBounds(35, 250, 129, 28);
		}
		return btnIzvriZamenu;
	}
	private JButton getBtnOdustani() {
		if (btnOdustani == null) {
			btnOdustani = new JButton("Odustani");
			btnOdustani.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					toBack();
				}
			});
			btnOdustani.setBounds(223, 248, 130, 28);
		}
		return btnOdustani;
	}
}
