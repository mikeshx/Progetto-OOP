import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JPopupMenu;
import java.awt.Component;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Dimension;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Registrazione {

	private JFrame frmUntitledGaming;
	private JTextField txtNome;
	private JTextField txtNickname;
	private JTextField txtCognome;
	private JTextField txtEmil;
	private JTextField txtEt;
	private JPasswordField passwordField;
	private JButton button;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Registrazione window = new Registrazione();
					window.frmUntitledGaming.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Registrazione() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setTitle("   Untitled Gaming  -  Registrati");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 750, 500);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Registrati Qui!");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 30));
		lblNewLabel.setBounds(0, 27, 734, 37);
		frmUntitledGaming.getContentPane().add(lblNewLabel);
		
		txtNome = new JTextField();
		txtNome.setToolTipText("Nome");
		txtNome.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent arg0) {
				System.out.println ("Enter Name");
			}
		});
		txtNome.setFont(new Font("Georgia", Font.ITALIC, 15));
		txtNome.setForeground(Color.GRAY);
		txtNome.setText("Nome");
		txtNome.setHorizontalAlignment(SwingConstants.CENTER);
		txtNome.setBounds(54, 159, 133, 37);
		frmUntitledGaming.getContentPane().add(txtNome);
		txtNome.setColumns(10);
		
		JButton btnNewButton = new JButton("Registarti");
		btnNewButton.setToolTipText("Registrati");
		btnNewButton.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent arg0) {
				System.out.println ("Sei Registrato!");
			}
		});
		btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 14));
		btnNewButton.setBounds(299, 377, 133, 37);
		frmUntitledGaming.getContentPane().add(btnNewButton);
		
		txtNickname = new JTextField();
		txtNickname.setToolTipText("Username");
		txtNickname.setFont(new Font("Georgia", Font.ITALIC, 15));
		txtNickname.setForeground(Color.GRAY);
		txtNickname.setHorizontalAlignment(SwingConstants.CENTER);
		txtNickname.setText("Username");
		txtNickname.setBounds(54, 261, 133, 37);
		frmUntitledGaming.getContentPane().add(txtNickname);
		txtNickname.setColumns(10);
		
		txtCognome = new JTextField();
		txtCognome.setToolTipText("Cognome");
		txtCognome.setFont(new Font("Georgia", Font.ITALIC, 15));
		txtCognome.setForeground(Color.GRAY);
		txtCognome.setHorizontalAlignment(SwingConstants.CENTER);
		txtCognome.setText("Cognome");
		txtCognome.setBounds(299, 159, 133, 37);
		frmUntitledGaming.getContentPane().add(txtCognome);
		txtCognome.setColumns(10);
		
		txtEmil = new JTextField();
		txtEmil.setToolTipText("E-m@il");
		txtEmil.setFont(new Font("Georgia", Font.ITALIC, 15));
		txtEmil.setForeground(Color.GRAY);
		txtEmil.setHorizontalAlignment(SwingConstants.CENTER);
		txtEmil.setText("E-m@il");
		txtEmil.setBounds(299, 261, 133, 37);
		frmUntitledGaming.getContentPane().add(txtEmil);
		txtEmil.setColumns(10);
		
		txtEt = new JTextField();
		txtEt.setToolTipText("Et\u00E0");
		txtEt.setFont(new Font("Georgia", Font.ITALIC, 15));
		txtEt.setForeground(Color.GRAY);
		txtEt.setText("Et\u00E0");
		txtEt.setHorizontalAlignment(SwingConstants.CENTER);
		txtEt.setBounds(541, 159, 133, 37);
		frmUntitledGaming.getContentPane().add(txtEt);
		txtEt.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBackground(new Color(255, 255, 255));
		passwordField.setToolTipText("Password");
		passwordField.setFont(new Font("Georgia", Font.ITALIC, 15));
		passwordField.setHorizontalAlignment(SwingConstants.CENTER);
		passwordField.setForeground(Color.GRAY);
		passwordField.setBounds(541, 261, 133, 37);
		frmUntitledGaming.getContentPane().add(passwordField);
		
		button = new JButton("");
		button.setIcon(new ImageIcon("C:\\Users\\Filippo S\\Desktop\\logo_Untitled_Gaming\\back_icon.png"));
		button.setToolTipText("torna indietro");
		button.setBounds(10, 10, 37, 31);
		frmUntitledGaming.getContentPane().add(button);
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
}