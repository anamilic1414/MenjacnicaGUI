package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
			rdKupovina.setSelected(true);
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
			slider.setPaintTicks(true);
			slider.setPaintLabels(true);
			slider.setMinorTickSpacing(5);
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
					if(getRdProdaja().isSelected()){
						izbor = "Prodaja";
					}else{
						izbor = "Kupovina";
						}
					
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
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((btnIzvriZamenu == null) ? 0 : btnIzvriZamenu.hashCode());
		result = prime * result + ((btnOdustani == null) ? 0 : btnOdustani.hashCode());
		result = prime * result + ((buttonGroup == null) ? 0 : buttonGroup.hashCode());
		result = prime * result + ((comboBox == null) ? 0 : comboBox.hashCode());
		result = prime * result + ((contentPane == null) ? 0 : contentPane.hashCode());
		result = prime * result + ((lblIznos == null) ? 0 : lblIznos.hashCode());
		result = prime * result + ((lblKupovniKurs == null) ? 0 : lblKupovniKurs.hashCode());
		result = prime * result + ((lblProdajniKurs == null) ? 0 : lblProdajniKurs.hashCode());
		result = prime * result + ((lblVrstaTransakcije == null) ? 0 : lblVrstaTransakcije.hashCode());
		result = prime * result + ((rdKupovina == null) ? 0 : rdKupovina.hashCode());
		result = prime * result + ((rdProdaja == null) ? 0 : rdProdaja.hashCode());
		result = prime * result + ((slider == null) ? 0 : slider.hashCode());
		result = prime * result + ((txtIznos == null) ? 0 : txtIznos.hashCode());
		result = prime * result + ((txtKupovni == null) ? 0 : txtKupovni.hashCode());
		result = prime * result + ((txtProdajni == null) ? 0 : txtProdajni.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		IzvrsiZamenuProzor other = (IzvrsiZamenuProzor) obj;
		if (btnIzvriZamenu == null) {
			if (other.btnIzvriZamenu != null)
				return false;
		} else if (!btnIzvriZamenu.equals(other.btnIzvriZamenu))
			return false;
		if (btnOdustani == null) {
			if (other.btnOdustani != null)
				return false;
		} else if (!btnOdustani.equals(other.btnOdustani))
			return false;
		if (buttonGroup == null) {
			if (other.buttonGroup != null)
				return false;
		} else if (!buttonGroup.equals(other.buttonGroup))
			return false;
		if (comboBox == null) {
			if (other.comboBox != null)
				return false;
		} else if (!comboBox.equals(other.comboBox))
			return false;
		if (contentPane == null) {
			if (other.contentPane != null)
				return false;
		} else if (!contentPane.equals(other.contentPane))
			return false;
		if (lblIznos == null) {
			if (other.lblIznos != null)
				return false;
		} else if (!lblIznos.equals(other.lblIznos))
			return false;
		if (lblKupovniKurs == null) {
			if (other.lblKupovniKurs != null)
				return false;
		} else if (!lblKupovniKurs.equals(other.lblKupovniKurs))
			return false;
		if (lblProdajniKurs == null) {
			if (other.lblProdajniKurs != null)
				return false;
		} else if (!lblProdajniKurs.equals(other.lblProdajniKurs))
			return false;
		if (lblVrstaTransakcije == null) {
			if (other.lblVrstaTransakcije != null)
				return false;
		} else if (!lblVrstaTransakcije.equals(other.lblVrstaTransakcije))
			return false;
		if (rdKupovina == null) {
			if (other.rdKupovina != null)
				return false;
		} else if (!rdKupovina.equals(other.rdKupovina))
			return false;
		if (rdProdaja == null) {
			if (other.rdProdaja != null)
				return false;
		} else if (!rdProdaja.equals(other.rdProdaja))
			return false;
		if (slider == null) {
			if (other.slider != null)
				return false;
		} else if (!slider.equals(other.slider))
			return false;
		if (txtIznos == null) {
			if (other.txtIznos != null)
				return false;
		} else if (!txtIznos.equals(other.txtIznos))
			return false;
		if (txtKupovni == null) {
			if (other.txtKupovni != null)
				return false;
		} else if (!txtKupovni.equals(other.txtKupovni))
			return false;
		if (txtProdajni == null) {
			if (other.txtProdajni != null)
				return false;
		} else if (!txtProdajni.equals(other.txtProdajni))
			return false;
		return true;
	}
	
	
}
