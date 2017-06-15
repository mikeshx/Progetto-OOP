package presentation.general;

import business.model.Utente;
import controller.eventsListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.image.ImageProducer;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;

public class review extends starEdit {

    private JFrame frmUntitledGaming;

    Utente utente;
    int gioco_id;

    /* Create the application */
    public review(Utente c, int g) {
this.gioco_id = g;
        this.utente = c;
        initialize();
    }

    /* Initialize the contents of the frame */
    private void initialize() {

        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setTitle("   Untitled Gaming  -  Scrivi Recensione");
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setBounds(100, 100, 950, 700);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);

        JLabel lblValutaQuestoGioco = new JLabel("Valuta");
        lblValutaQuestoGioco.setForeground(SystemColor.textInactiveText);
        lblValutaQuestoGioco.setHorizontalAlignment(SwingConstants.RIGHT);
        lblValutaQuestoGioco.setFont(new Font("Georgia", Font.ITALIC, 30));
        lblValutaQuestoGioco.setBounds(10, 63, 401, 52);
        frmUntitledGaming.getContentPane().add(lblValutaQuestoGioco);

        JLabel lblScriviUnCommento = new JLabel("Scrivi Commento:");
        lblScriviUnCommento.setHorizontalAlignment(SwingConstants.CENTER);
        lblScriviUnCommento.setForeground(SystemColor.textInactiveText);
        lblScriviUnCommento.setFont(new Font("Georgia", Font.ITALIC, 30));
        lblScriviUnCommento.setBounds(10, 229, 924, 52);
        frmUntitledGaming.getContentPane().add(lblScriviUnCommento);

        JEditorPane dtrpnLasciaQuIl = new JEditorPane();
        dtrpnLasciaQuIl.setToolTipText("Scrivi un Commento...");

        //listen for focus
        dtrpnLasciaQuIl.addFocusListener(new FocusListener() {
            public void focusGained(FocusEvent e) {
                dtrpnLasciaQuIl.setText("  ");
            }

            public void focusLost(FocusEvent e) {
                if (dtrpnLasciaQuIl.getText().isEmpty())
                    dtrpnLasciaQuIl.setText("   Lascia qu\u00EC il Tuo Commento");
            }
        });

        dtrpnLasciaQuIl.setText("   Lascia qu\u00EC il Tuo Commento");
        dtrpnLasciaQuIl.setFont(new Font("Oregano", Font.PLAIN, 25));
        dtrpnLasciaQuIl.setBackground(new Color(220, 220, 220));
        dtrpnLasciaQuIl.setBounds(124, 313, 696, 223);
        frmUntitledGaming.getContentPane().add(dtrpnLasciaQuIl);

        JPanel panel = new JPanel();
        panel.setBounds(115, 127, 696, 90);

        // Star rating panel
        ImageIcon defaultIcon = new ImageIcon(getClass().getResource("imgs/31g_1.png"));
        ImageProducer ip = defaultIcon.getImage().getSource();
        List<ImageIcon>
                list = Arrays.asList(
                makeStarImageIcon(ip, .6f, .6f, 0f),
                makeStarImageIcon(ip, .7f, .7f, 0f),
                makeStarImageIcon(ip, .8f, .8f, 0f),
                makeStarImageIcon(ip, .9f, .9f, 0f),
                makeStarImageIcon(ip, 1f, 1f, 0f));

        LevelBarEdit lb = new LevelBarEdit(defaultIcon, list, 2);
        panel.add(makeStarRatingPanel("", lb));
        frmUntitledGaming.getContentPane().add(panel);

        JButton btnInviaRecensione = new JButton("Invia Recensione");
        btnInviaRecensione.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            }
        });
        btnInviaRecensione.setToolTipText("Invia Recensione");
        btnInviaRecensione.setFont(new Font("MV Boli", Font.ITALIC, 17));
        btnInviaRecensione.setBounds(355, 573, 234, 52);
        frmUntitledGaming.getContentPane().add(btnInviaRecensione);

        btnInviaRecensione.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.setVisible(false);

                try {
                    int vote = lb.getLevel();
                    controller.eventsListener.newReview(utente, dtrpnLasciaQuIl.getText(),gioco_id, vote + 1);
                    new reviewList(utente, 0, gioco_id);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });


        JLabel lblnomeGioco = new JLabel("-Nome Gioco-");
        lblnomeGioco.setHorizontalAlignment(SwingConstants.LEFT);
        lblnomeGioco.setForeground(SystemColor.textInactiveText);
        lblnomeGioco.setFont(new Font("Georgia", Font.ITALIC, 30));
        lblnomeGioco.setBounds(421, 63, 489, 52);
        frmUntitledGaming.getContentPane().add(lblnomeGioco);

        JButton button = new JButton("");
        button.setIcon(new ImageIcon(".src/presentation/general/imgs/back_icon.png"));
        button.setToolTipText("Torna Indietro");
        button.setBounds(10, 11, 45, 45);

        // Go back
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.setVisible(false);
                new reviewList(utente, 0, gioco_id);

            }
        });

        frmUntitledGaming.getContentPane().add(button);

        JButton btnTornaAllaHome = new JButton("Torna alla Home");
        btnTornaAllaHome.setToolTipText("Torna alla Home");
        btnTornaAllaHome.setFont(new Font("MV Boli", Font.ITALIC, 15));
        btnTornaAllaHome.setBounds(758, 26, 161, 35);
        frmUntitledGaming.getContentPane().add(btnTornaAllaHome);

        // Go back to home
        btnTornaAllaHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.setVisible(false);
               eventsListener.changePage("logged", utente);

            }
        });


        frmUntitledGaming.setVisible(true
        );
    }
}