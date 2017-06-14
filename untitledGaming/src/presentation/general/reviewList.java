package presentation.general;

import business.model.Utente;
import controller.eventsListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.ImageProducer;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.List;


public class reviewList extends starView {

    private JFrame frmUntitledGaming;
    Utente utente;
    int row;

    public reviewList(Utente c, int a) {

        this.utente = c;
        this.row = a;
        initialize();
    }

    private void initialize() {


        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setTitle("   Untitled Gaming  -  Lista Commenti ");
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setBounds(100, 100, 950, 700);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);
        frmUntitledGaming.setLocationRelativeTo(null);

        JButton button = new JButton("");
        button.setIcon(new ImageIcon(getClass().getResource("imgs/back_icon.png")));
        button.setToolTipText("torna indietro");
        button.setBounds(10, 11, 45, 45);
        frmUntitledGaming.getContentPane().add(button);

        button.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                frmUntitledGaming.setVisible(false);
                eventsListener.changePage("logged", utente);

            }
        });

        JLabel lblListaGiochi = null;
        try {
            int fineLista = eventsListener.getApprovedReviews().getRowCount();
            int inizioLista = row + 4;
            if ((row + 4) >= fineLista)
                inizioLista = fineLista;
            lblListaGiochi = new JLabel("Lista Commenti" + "(" + (inizioLista) + " / " + (fineLista) + ")");
        } catch (SQLException e) {
            e.printStackTrace();
        }
        lblListaGiochi.setHorizontalAlignment(SwingConstants.CENTER);
        lblListaGiochi.setFont(new Font("Vivaldi", Font.BOLD, 40));
        lblListaGiochi.setBounds(0, 23, 944, 61);
        frmUntitledGaming.getContentPane().add(lblListaGiochi);

        JPanel panel = new JPanel();
        panel.setBackground(Color.YELLOW);
        panel.setBounds(66, 88, 90, 90);
        frmUntitledGaming.getContentPane().add(panel);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(Color.BLUE);
        panel_1.setBounds(66, 208, 90, 90);
        frmUntitledGaming.getContentPane().add(panel_1);

        JPanel panel_2 = new JPanel();
        panel_2.setBackground(Color.GREEN);
        panel_2.setBounds(66, 326, 90, 90);
        frmUntitledGaming.getContentPane().add(panel_2);

        JPanel panel_3 = new JPanel();
        panel_3.setBackground(Color.RED);
        panel_3.setBounds(66, 445, 90, 90);
        frmUntitledGaming.getContentPane().add(panel_3);

        //bottone pagina successiva
        JButton btnSuccessiva = new JButton("");
        btnSuccessiva.setIcon(new ImageIcon(getClass().getResource("imgs/Rounded_next.png")));
        btnSuccessiva.setFont(new Font("MV Boli", Font.ITALIC, 13));
        btnSuccessiva.setToolTipText("Pagina Successiva");
        btnSuccessiva.setBounds(830, 581, 45, 45);

        try {
            if (row + 4
                    >= eventsListener.getApprovedReviews().getRowCount()) {
                btnSuccessiva.setEnabled(false);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        frmUntitledGaming.getContentPane().add(btnSuccessiva);


        btnSuccessiva.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                frmUntitledGaming.setVisible(false);
                new reviewList(utente, row + 4);

            }
        });

        // bottone pagina precedente
        JButton button_4 = new JButton("");
        button_4.setIcon(new ImageIcon(getClass().getResource("imgs/Rounded_back_1.png")));
        button_4.setToolTipText("Pagina Precedente");
        button_4.setFont(new Font("MV Boli", Font.ITALIC, 13));
        button_4.setBounds(68, 581, 45, 45);
        if (row == 0) button_4.setEnabled(false);

        frmUntitledGaming.getContentPane().add(button_4);
        button_4.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {

                frmUntitledGaming.setVisible(false);
                new reviewList(utente, row - 4);


            }
        });


        JLabel label = null;
        try {


            String a = String.valueOf(eventsListener.getApprovedReviews().getValueAt(row, 0));


            int b = Integer.parseInt(a);
            label = new JLabel(eventsListener.getUsername(b));


            JButton btnRecensione = new JButton("Leggi Commento");
            btnRecensione.setToolTipText("Leggi Commento");
            btnRecensione.setFont(new Font("MV Boli", Font.ITALIC, 17));
            btnRecensione.setBounds(710, 119, 180, 30);
            frmUntitledGaming.getContentPane().add(btnRecensione);

            btnRecensione.addActionListener(new ActionListener() {


                public void actionPerformed(ActionEvent e) {

                    frmUntitledGaming.setVisible(false);
                    new viewReview(utente, row, b);

                }
            });

        } catch (SQLException e) {
            e.printStackTrace();
        }


        label.setHorizontalAlignment(SwingConstants.CENTER);
        label.setForeground(Color.DARK_GRAY);
        label.setFont(new Font("Oregano", Font.PLAIN, 21));
        label.setBounds(166, 119, 211, 30);
        frmUntitledGaming.getContentPane().add(label);

        JLabel label_1 = null;
        try {
            if (row + 1 >= eventsListener.getApprovedReviews().getRowCount()) {
                label_1 = new JLabel("vuoto");

            } else {
                String a = String.valueOf(eventsListener.getApprovedReviews().getValueAt(row + 1, 0));
                int b = Integer.parseInt(a);
                label_1 = new JLabel(eventsListener.getUsername(b));


                JButton btnGioca = new JButton("Leggi Commento");
                btnGioca.setToolTipText("Leggi Commento");
                btnGioca.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnGioca.setBounds(710, 242, 180, 30);
                frmUntitledGaming.getContentPane().add(btnGioca);
                btnGioca.addActionListener(new ActionListener() {


                    public void actionPerformed(ActionEvent e) {

                        frmUntitledGaming.setVisible(false);
                        new viewReview(utente, row, b);

                    }
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        label_1.setHorizontalAlignment(SwingConstants.CENTER);
        label_1.setForeground(Color.DARK_GRAY);
        label_1.setFont(new Font("Oregano", Font.PLAIN, 21));
        label_1.setBounds(166, 242, 211, 30);
        frmUntitledGaming.getContentPane().add(label_1);


        JLabel label_2 = null;
        try {
            if (row + 2 >= eventsListener.getApprovedReviews().getRowCount()) {
                label_2 = new JLabel("vuoto");
            } else {
                String a = String.valueOf(eventsListener.getApprovedReviews().getValueAt(row + 2, 0));
                int b = Integer.parseInt(a);
                label_2 = new JLabel(eventsListener.getUsername(b));


                JButton btnGioca_1 = new JButton("Leggi Commento");
                btnGioca_1.setToolTipText("Leggi Commento");
                btnGioca_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnGioca_1.setBounds(710, 357, 180, 30);
                frmUntitledGaming.getContentPane().add(btnGioca_1);
                btnGioca_1.addActionListener(new ActionListener() {


                    public void actionPerformed(ActionEvent e) {

                        frmUntitledGaming.setVisible(false);
                        new viewReview(utente, row, b);

                    }
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        label_2.setHorizontalAlignment(SwingConstants.CENTER);
        label_2.setForeground(Color.DARK_GRAY);
        label_2.setFont(new Font("Oregano", Font.PLAIN, 21));
        label_2.setBounds(166, 357, 211, 30);
        frmUntitledGaming.getContentPane().add(label_2);

        JLabel label_3 = null;
        try {
            if (row + 3 >= eventsListener.getApprovedReviews().getRowCount()) {
                label_3 = new JLabel("vuoto");
            } else {

                String a = String.valueOf(eventsListener.getApprovedReviews().getValueAt(row + 3, 0));
                int b = Integer.parseInt(a);
                label_3 = new JLabel(eventsListener.getUsername(b));


                JButton btnGioca_2 = new JButton("Leggi Commento");
                btnGioca_2.setToolTipText("Leggi Commento");
                btnGioca_2.setFont(new Font("MV Boli", Font.ITALIC, 17));
                btnGioca_2.setBounds(710, 475, 180, 30);
                frmUntitledGaming.getContentPane().add(btnGioca_2);
                btnGioca_2.addActionListener(new ActionListener() {


                    public void actionPerformed(ActionEvent e) {

                        frmUntitledGaming.setVisible(false);
                        new viewReview(utente, row, b);

                    }
                });
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
        label_3.setHorizontalAlignment(SwingConstants.CENTER);
        label_3.setForeground(Color.DARK_GRAY);
        label_3.setFont(new Font("Oregano", Font.PLAIN, 21));
        label_3.setBounds(166, 475, 211, 30);
        frmUntitledGaming.getContentPane().add(label_3);

        // TODO: METTERE LA VALUTAZIONE FISSA E NON EDITABILE

        JPanel panel_4 = new JPanel();
        panel_4.setToolTipText("Valutazione");
        panel_4.setBounds(384, 112, 311, 45);
        ImageIcon defaultIcon = new ImageIcon(getClass().getResource("imgs/31g.png"));
        ImageProducer ip = defaultIcon.getImage().getSource();
        List<ImageIcon>
                list = Arrays.asList(
                makeStarImageIcon(ip, .6f, .6f, 0f),
                makeStarImageIcon(ip, .7f, .7f, 0f),
                makeStarImageIcon(ip, .8f, .8f, 0f),
                makeStarImageIcon(ip, .9f, .9f, 0f),
                makeStarImageIcon(ip, 1f, 1f, 0f));
        panel_4.add(makeStarRatingPanel("", new LevelBar(defaultIcon, list, 2)));
        frmUntitledGaming.getContentPane().add(panel_4);

        // Attenzione a modificare perchè le List,ImageIcon e ip sotto ereditano le dichiarazioni fatte nella prima starRating
        JPanel panel_5 = new JPanel();
        panel_5.setToolTipText("Valutazione");
        panel_5.setBounds(384, 236, 311, 45);
        defaultIcon = new ImageIcon(getClass().getResource("imgs/31g.png"));
        ip = defaultIcon.getImage().getSource();
        list = Arrays.asList(
                makeStarImageIcon(ip, .6f, .6f, 0f),
                makeStarImageIcon(ip, .7f, .7f, 0f),
                makeStarImageIcon(ip, .8f, .8f, 0f),
                makeStarImageIcon(ip, .9f, .9f, 0f),
                makeStarImageIcon(ip, 1f, 1f, 0f));
        panel_5.add(makeStarRatingPanel("", new LevelBar(defaultIcon, list, 2)));
        frmUntitledGaming.getContentPane().add(panel_5);

        // Attenzione a modificare perchè le List,ImageIcon e ip sotto ereditano le dichiarazioni fatte nella prima starRating
        JPanel panel_6 = new JPanel();
        panel_6.setToolTipText("Valutazione");
        panel_6.setBounds(384, 351, 311, 45);
        defaultIcon = new ImageIcon(getClass().getResource("imgs/31g.png"));
        ip = defaultIcon.getImage().getSource();
        list = Arrays.asList(
                makeStarImageIcon(ip, .6f, .6f, 0f),
                makeStarImageIcon(ip, .7f, .7f, 0f),
                makeStarImageIcon(ip, .8f, .8f, 0f),
                makeStarImageIcon(ip, .9f, .9f, 0f),
                makeStarImageIcon(ip, 1f, 1f, 0f));
        panel_6.add(makeStarRatingPanel("", new LevelBar(defaultIcon, list, 2)));
        frmUntitledGaming.getContentPane().add(panel_6);

        // Attenzione a modificare perchè le List,ImageIcon e ip sotto ereditano le dichiarazioni fatte nella prima starRating
        JPanel panel_7 = new JPanel();
        panel_7.setToolTipText("Valutazione");
        panel_7.setBounds(384, 468, 311, 45);
        defaultIcon = new ImageIcon(getClass().getResource("imgs/31g.png"));
        ip = defaultIcon.getImage().getSource();
        list = Arrays.asList(
                makeStarImageIcon(ip, .6f, .6f, 0f),
                makeStarImageIcon(ip, .7f, .7f, 0f),
                makeStarImageIcon(ip, .8f, .8f, 0f),
                makeStarImageIcon(ip, .9f, .9f, 0f),
                makeStarImageIcon(ip, 1f, 1f, 0f));
        panel_7.add(makeStarRatingPanel("", new LevelBar(defaultIcon, list, 2)));
        frmUntitledGaming.getContentPane().add(panel_7);

        JButton btnLaTuaRecensione = new JButton("La Tua Recensione");
        btnLaTuaRecensione.setToolTipText("La Tua Recensione");
        btnLaTuaRecensione.setFont(new Font("MV Boli", Font.ITALIC, 17));
        btnLaTuaRecensione.setBounds(375, 570, 198, 45);
        frmUntitledGaming.getContentPane().add(btnLaTuaRecensione);
        frmUntitledGaming.setVisible(true);


        btnLaTuaRecensione.addActionListener(new ActionListener() {


            public void actionPerformed(ActionEvent e) {
                try {
                    if (eventsListener.reviewFoundOnProfile(utente.getUserId())) {
                        frmUntitledGaming.setVisible(false);
                        new viewReview(utente, 0, utente.getUserId()
                        );
                    } else {
                        frmUntitledGaming.setVisible(false);
                        eventsListener.changePage("review", utente);
                    }
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });
    }
}
