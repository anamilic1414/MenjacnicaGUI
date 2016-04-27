package menjacnica.gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import java.awt.Dimension;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JScrollBar;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.border.TitledBorder;
import javax.swing.plaf.FileChooserUI;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import kurs.Kurs;
import menjacnica.gui.model.KursTableModel;

import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.KeyStroke;
import java.awt.event.KeyEvent;
import java.awt.event.InputEvent;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.util.LinkedList;
import java.util.List;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.ComponentOrientation;
import javax.swing.DropMode;
import org.eclipse.wb.swing.FocusTraversalOnArray;

public class MenjacnicaGUI extends JFrame {

	private static JPanel contentPane;
	private JPanel panel;
	private JButton btnDodajKurs;
	private JButton btnIzmeni;
	private JButton btnIzvriZamenu;
	private JScrollPane scrollPane;
	private static JTextArea textArea;
	private JScrollPane scrollPane_1;
	private JTable table;
	private JMenuBar menuBar;
	private JMenu mnFile;
	private JMenu mnHelp;
	private JMenuItem mntmOpen;
	private JMenuItem mntmSave;
	private JMenuItem mntmExit;
	private JMenuItem mntmAbout;
	private JPopupMenu popupMenu;
	private JMenuItem mntmDodajKurs;
	private JMenuItem mntmIymeni;
	private JMenuItem mntmIzvriZamenu;



	/**
	 * Create the frame.
	 */
	public MenjacnicaGUI() {
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("D:\\sa c\\Desktop\\sp-cukaricki-navijaci_620x0.jpg"));
		setTitle("Menja\u010Dnica");
		setBounds(100, 100, 659, 388);
		setJMenuBar(getMenuBar_1());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		contentPane.add(getPanel(), BorderLayout.EAST);
		contentPane.add(getScrollPane(), BorderLayout.SOUTH);
		contentPane.add(getScrollPane_1());
		addWindowListener(new WindowAdapter() {

			@Override
			public void windowClosing(WindowEvent e) {
				GUIKontroler.ugasiAplikaciju();

			}

		});
	}

	private JPanel getPanel() {
		if (panel == null) {
			panel = new JPanel();
			panel.setAutoscrolls(true);
			panel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
			panel.setPreferredSize(new Dimension(120, 10));
			panel.add(getBtnDodajKurs());
			panel.add(getBtnIzmeni());
			panel.add(getBtnIzvriZamenu());
		}
		return panel;
	}

	private JButton getBtnDodajKurs() {
		if (btnDodajKurs == null) {
			btnDodajKurs = new JButton("Dodaj kurs");
			btnDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					GUIKontroler.pokreniDodajKursProzor();
				}
			});
			btnDodajKurs.setPreferredSize(new Dimension(115, 25));
		}
		return btnDodajKurs;
	}
	
	
	public void osveziTabelu(){
		KursTableModel model = (KursTableModel) table.getModel();
		model.staviSveKurseve(GUIKontroler.getKurs());
	}
	

	private JButton getBtnIzmeni() {
		if (btnIzmeni == null) {
			btnIzmeni = new JButton("Izmeni");
			btnIzmeni.setPreferredSize(new Dimension(115, 25));
		}
		return btnIzmeni;
	}

	private JButton getBtnIzvriZamenu() {
		if (btnIzvriZamenu == null) {
			btnIzvriZamenu = new JButton("Izvr\u0161i zamenu");
			btnIzvriZamenu.setPreferredSize(new Dimension(115, 25));
		}
		return btnIzvriZamenu;
	}

	private JScrollPane getScrollPane() {
		if (scrollPane == null) {
			scrollPane = new JScrollPane();
			scrollPane.setBackground(Color.LIGHT_GRAY);
			scrollPane.setPreferredSize(new Dimension(2, 75));
			scrollPane.setViewportView(getTextArea());
		}
		return scrollPane;
	}

	private JTextArea getTextArea() {
		if (textArea == null) {
			textArea = new JTextArea();
			textArea.setEditable(false);
			textArea.setForeground(Color.GRAY);
			textArea.setBackground(Color.WHITE);
			textArea.setBorder(new TitledBorder(new LineBorder(new Color(0, 0, 0)), "STATUS", TitledBorder.LEADING,
					TitledBorder.TOP, null, new Color(0, 0, 0)));
		}
		return textArea;
	}

	public static void upisiUPolje(double sifra, String naziv, double prodajni, double kupovni, double srednji,
			String skraceni) {
		Kurs k = new Kurs();
		k.setSifra(sifra);
		k.setNaziv(naziv);
		k.setProdajni(prodajni);
		k.setKupovni(kupovni);
		k.setSrednji(srednji);
		k.setSkraceni(skraceni);
		
		try{
			textArea.setText(textArea.getText() + k + "\n");}
		catch(Exception e){
			textArea.setText(textArea.getText() + ""+e.getMessage());
		}
	}

	private JScrollPane getScrollPane_1() {
		if (scrollPane_1 == null) {
			scrollPane_1 = new JScrollPane();
			scrollPane_1.setRequestFocusEnabled(false);
			scrollPane_1.setOpaque(false);
			scrollPane_1.setViewportView(getTable_1());
		}
		return scrollPane_1;
	}

	private JTable getTable_1() {
		if (table == null) {
			table = new JTable();
			table.setEnabled(false);
			table.setModel(new KursTableModel(GUIKontroler.getKurs()));
			table.setFillsViewportHeight(true);
			addPopup(table, getPopupMenu());
		}
		return table;
	}

	private JMenuBar getMenuBar_1() {
		if (menuBar == null) {
			menuBar = new JMenuBar();
			menuBar.add(getMnFile());
			menuBar.add(getMnHelp());
		}
		return menuBar;
	}

	private JMenu getMnFile() {
		if (mnFile == null) {
			mnFile = new JMenu("File");
			mnFile.add(getMntmOpen());
			mnFile.add(getMntmSave());
			mnFile.add(getMntmExit());
		}
		return mnFile;
	}

	private JMenu getMnHelp() {
		if (mnHelp == null) {
			mnHelp = new JMenu("Help");
			mnHelp.add(getMntmAbout());
		}
		return mnHelp;
	}

	private JMenuItem getMntmOpen() {
		if (mntmOpen == null) {
			mntmOpen = new JMenuItem("Open");
			mntmOpen.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser fc = new JFileChooser();
					int povratnaVrednost = fc.showOpenDialog(getTextArea());
					if (povratnaVrednost == JFileChooser.APPROVE_OPTION) {
						File fajl = fc.getSelectedFile();
						textArea.setText(textArea.getText() + "Ucitan fajl " + fajl + "\n");
					}

				}
			});
			mntmOpen.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_O, InputEvent.CTRL_MASK));
			mntmOpen.setIcon(new ImageIcon(
					MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/directory.gif")));
		}
		return mntmOpen;
	}

	private JMenuItem getMntmSave() {
		if (mntmSave == null) {
			mntmSave = new JMenuItem("Save");
			mntmSave.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					JFileChooser fc = new JFileChooser();
					int povratnaVrednost = fc.showSaveDialog(getTextArea());
					if (povratnaVrednost == JFileChooser.APPROVE_OPTION) {
						File fajl = fc.getSelectedFile();
						textArea.setText(textArea.getText() + "Sacuvan fajl " + fajl + "\n");
					}
				}
			});

			mntmSave.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
			mntmSave.setIcon(
					new ImageIcon(MenjacnicaGUI.class.getResource("/javax/swing/plaf/metal/icons/ocean/floppy.gif")));
		}
		return mntmSave;
	}


	private JMenuItem getMntmExit() {
		if (mntmExit == null) {
			mntmExit = new JMenuItem("Exit");
			mntmExit.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.ugasiAplikaciju();
				}
			});
			mntmExit.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_X, InputEvent.ALT_MASK));
		}
		return mntmExit;
	}

	private JMenuItem getMntmAbout() {
		if (mntmAbout == null) {
			mntmAbout = new JMenuItem("About");
			mntmAbout.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					// JOptionPane.showInternalMessageDialog(contentPane, "Ana
					// Milic \t FON \t 14/14");
					JOptionPane.showMessageDialog(contentPane, "Ana Milic \t FON \t 14/14");
				}
			});
		}
		return mntmAbout;
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}

			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}

	private JPopupMenu getPopupMenu() {
		if (popupMenu == null) {
			popupMenu = new JPopupMenu();
			popupMenu.add(getMntmDodajKurs());
			popupMenu.add(getMntmIymeni());
			popupMenu.add(getMntmIzvriZamenu());
		}
		return popupMenu;
	}

	private JMenuItem getMntmDodajKurs() {
		if (mntmDodajKurs == null) {
			mntmDodajKurs = new JMenuItem("Dodaj kurs");
			mntmDodajKurs.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					GUIKontroler.pokreniDodajKursProzor();
				}
			});
		}
		return mntmDodajKurs;
	}

	private JMenuItem getMntmIymeni() {
		if (mntmIymeni == null) {
			mntmIymeni = new JMenuItem("Izmeni");
		}
		return mntmIymeni;
	}

	private JMenuItem getMntmIzvriZamenu() {
		if (mntmIzvriZamenu == null) {
			mntmIzvriZamenu = new JMenuItem("Izvrši zamenu");
		}
		return mntmIzvriZamenu;
	}
}
