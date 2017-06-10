import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.EtchedBorder;

public class timelineView {

	private JFrame frmUntitledGaming;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					timelineView window = new timelineView();
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
	public timelineView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmUntitledGaming = new JFrame();
		frmUntitledGaming.setTitle("   Untitled Gaming  -  Cronologia di Gioco");
		frmUntitledGaming.setResizable(false);
		frmUntitledGaming.setBounds(100, 100, 950, 700);
		frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmUntitledGaming.getContentPane().setLayout(null);
		
		JButton button = new JButton("");
		button.setIcon(new ImageIcon("imgs/back_icon.png"));
		button.setToolTipText("torna indietro");
		button.setBounds(10, 11, 45, 45);
		frmUntitledGaming.getContentPane().add(button);
		
		JLabel lblCronologiaDiGioco = new JLabel("Cronologia di Gioco");
		lblCronologiaDiGioco.setHorizontalAlignment(SwingConstants.CENTER);
		lblCronologiaDiGioco.setFont(new Font("Vivaldi", Font.BOLD, 40));
		lblCronologiaDiGioco.setBounds(0, 51, 944, 61);
		frmUntitledGaming.getContentPane().add(lblCronologiaDiGioco);
		
		JLabel lblUltimogiocoGiocato = new JLabel("Ultimo Gioco Giocato :");
		lblUltimogiocoGiocato.setForeground(Color.GRAY);
		lblUltimogiocoGiocato.setFont(new Font("Georgia", Font.ITALIC, 17));
		lblUltimogiocoGiocato.setBounds(61, 210, 240, 30);
		frmUntitledGaming.getContentPane().add(lblUltimogiocoGiocato);
		
		JLabel lblUltimasessione = new JLabel("Data Ultima Sessione :");
		lblUltimasessione.setForeground(Color.GRAY);
		lblUltimasessione.setFont(new Font("Georgia", Font.ITALIC, 17));
		lblUltimasessione.setBounds(61, 354, 240, 30);
		frmUntitledGaming.getContentPane().add(lblUltimasessione);
		
		JLabel lblPuntiXpGuadagnati = new JLabel("Punti XP Guadagnati nell'Ultima Sessione :");
		lblPuntiXpGuadagnati.setForeground(Color.GRAY);
		lblPuntiXpGuadagnati.setFont(new Font("Georgia", Font.ITALIC, 17));
		lblPuntiXpGuadagnati.setBounds(61, 508, 387, 30);
		frmUntitledGaming.getContentPane().add(lblPuntiXpGuadagnati);
		
		JPanel panel = new JPanel();
		panel.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192), new Color(192, 192, 192)));
		panel.setBackground(Color.CYAN);
		panel.setBounds(311, 178, 90, 90);
		frmUntitledGaming.getContentPane().add(panel);
		
		JLabel label = new JLabel("");
		panel.add(label);
		
		JLabel lblNewLabel = new JLabel("- Inserire qui NOME GIOCO-");
		lblNewLabel.setForeground(Color.DARK_GRAY);
		lblNewLabel.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblNewLabel.setBounds(450, 202, 306, 45);
		frmUntitledGaming.getContentPane().add(lblNewLabel);
		
		JLabel lblInserireQui = new JLabel("- Inserire qui la DATA-");
		lblInserireQui.setForeground(Color.DARK_GRAY);
		lblInserireQui.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblInserireQui.setBounds(311, 346, 306, 45);
		frmUntitledGaming.getContentPane().add(lblInserireQui);
		
		JLabel lblInserireQui_1 = new JLabel("1234  -Inserire qui  XP ULTIMA SESSIONE-");
		lblInserireQui_1.setForeground(Color.DARK_GRAY);
		lblInserireQui_1.setFont(new Font("Georgia", Font.ITALIC, 18));
		lblInserireQui_1.setBounds(436, 500, 402, 45);
		frmUntitledGaming.getContentPane().add(lblInserireQui_1);
	}
}
