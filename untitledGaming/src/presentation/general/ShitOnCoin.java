package presentation.general;

import business.implementation.DBManager;
import business.model.Utente;
import controller.eventsListener;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

public class ShitOnCoin {

    private JFrame frmUntitledGaming;
    Utente utente = null;
    int esp = 0;

    /* Create the application */
    public ShitOnCoin(Utente c) {
        this.utente = c;
        initialize();
    }

    /* Initialize the contents of the frame*/
    private void initialize() {
        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setVisible(true);

        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setTitle("Untitled Gaming - Username!");
        frmUntitledGaming.setBounds(100, 100, 750, 500);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);
        frmUntitledGaming.setLocationRelativeTo(null);

        JLabel label = new JLabel("");
        label.setBounds(0, 0, 46, 14);
        frmUntitledGaming.getContentPane().add(label);

        JLabel lblNewLabel = new JLabel("Hello,");
        lblNewLabel.setForeground(Color.GRAY);
        lblNewLabel.setFont(new Font("Oregano", Font.PLAIN, 15));
        lblNewLabel.setBounds(559, 22, 52, 25);
        frmUntitledGaming.getContentPane().add(lblNewLabel);

        JLabel lblusernameHere = new JLabel(utente.getUsername());
        lblusernameHere.setForeground(Color.DARK_GRAY);
        lblusernameHere.setFont(new Font("Oregano", Font.PLAIN, 15));
        lblusernameHere.setBounds(598, 25, 126, 19);
        frmUntitledGaming.getContentPane().add(lblusernameHere);

        JLabel lblNewLabel_1 = new JLabel("ShitOnCoin");
        lblNewLabel_1.setFont(new Font("Vivaldi", Font.BOLD, 30));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 68, 734, 37);
        frmUntitledGaming.getContentPane().add(lblNewLabel_1);


        JButton btnLogOut = new JButton("Save and quit");
        btnLogOut.setToolTipText("Log Out");
        btnLogOut.setFont(new Font("MV Boli", Font.PLAIN, 12));
        btnLogOut.setBounds(587, 58, 150, 23);
        frmUntitledGaming.getContentPane().add(btnLogOut);

        btnLogOut.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();


                try {
                    eventsListener.updateTimeline(utente.getUserId(),
                            DBManager.getCurrentData(), esp, 5);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }



                controller.eventsListener.changePage("allGames", utente);
            }
        });


        JButton btnGiocaOra = new JButton("Play");
        btnGiocaOra.setToolTipText("Gioca Ora");
        btnGiocaOra.setFont(new Font("MV Boli", Font.ITALIC, 17));
        btnGiocaOra.setBounds(452, 320, 193, 64);
        frmUntitledGaming.getContentPane().add(btnGiocaOra);

        btnGiocaOra.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                try {
                    esp = esp + controller.eventsListener.ShitOnCoin(utente);
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

    }
}
