package presentation.user;

import javax.swing.*;
import java.awt.*;

public class userLogged {

    private JFrame frmUntitledGaming;

    /**
     * Create the application.
     */
    public userLogged() {
        initialize();
    }

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    userLogged window = new userLogged();
                    window.frmUntitledGaming.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frmUntitledGaming = new JFrame();
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setTitle("   Untitled Gaming  -  (Username Here!)");
        frmUntitledGaming.setBounds(100, 100, 750, 500);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);

        JLabel label = new JLabel("");
        label.setBounds(0, 0, 46, 14);
        frmUntitledGaming.getContentPane().add(label);

        JLabel lblNewLabel = new JLabel("Hello,");
        lblNewLabel.setForeground(Color.GRAY);
        lblNewLabel.setFont(new Font("Oregano", Font.PLAIN, 15));
        lblNewLabel.setBounds(559, 22, 52, 25);
        frmUntitledGaming.getContentPane().add(lblNewLabel);

        JLabel lblusernameHere = new JLabel("-Username Here!-");
        lblusernameHere.setForeground(Color.DARK_GRAY);
        lblusernameHere.setFont(new Font("Oregano", Font.PLAIN, 15));
        lblusernameHere.setBounds(598, 25, 126, 19);
        frmUntitledGaming.getContentPane().add(lblusernameHere);

        JLabel lblNewLabel_1 = new JLabel("Untitled Gaming");
        lblNewLabel_1.setFont(new Font("Vivaldi", Font.BOLD, 30));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(0, 68, 734, 37);
        frmUntitledGaming.getContentPane().add(lblNewLabel_1);

        JButton btnNewButton = new JButton("Il Tuo Profilo");
        btnNewButton.setToolTipText("Il Tuo Profilo");
        btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 17));
        btnNewButton.setBounds(82, 232, 174, 64);
        frmUntitledGaming.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Gioca Ora");
        btnNewButton_1.setToolTipText("Gioca Ora");
        btnNewButton_1.setFont(new Font("MV Boli", Font.ITALIC, 17));
        btnNewButton_1.setBounds(471, 232, 174, 64);
        frmUntitledGaming.getContentPane().add(btnNewButton_1);

        JButton btnLogOut = new JButton("Log Out");
        btnLogOut.setToolTipText("Log Out");
        btnLogOut.setFont(new Font("MV Boli", Font.PLAIN, 12));
        btnLogOut.setBounds(587, 58, 85, 23);
        frmUntitledGaming.getContentPane().add(btnLogOut);
    }
}