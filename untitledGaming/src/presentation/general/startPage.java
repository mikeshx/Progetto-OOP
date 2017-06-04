package presentation.general;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.sql.SQLException;

public class startPage {

    private JFrame frmUntitledGaming;
    private JTextField txtIndirizzoEmail;
    private JPasswordField passwordField;

    /* Create the application */
    public startPage() {
        initialize();
    }


    /* Initialize the contents of the frame */
    private void initialize() {

        frmUntitledGaming = new JFrame();


        frmUntitledGaming.setIconImage(Toolkit.getDefaultToolkit().getImage("logo.png"));
        frmUntitledGaming.setTitle("Untitled Gaming");
        frmUntitledGaming.setResizable(false);
        frmUntitledGaming.setBounds(100, 100, 750, 500);
        frmUntitledGaming.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frmUntitledGaming.getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("Untitled Gaming");
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setFont(new Font("Vivaldi", Font.BOLD, 30));
        lblNewLabel.setBounds(0, 27, 734, 38);
        frmUntitledGaming.getContentPane().add(lblNewLabel);

        txtIndirizzoEmail = new JTextField();
        txtIndirizzoEmail.setToolTipText("e-mail");
        txtIndirizzoEmail.setFont(new Font("Georgia", Font.ITALIC, 15));
        txtIndirizzoEmail.setForeground(Color.GRAY);
        txtIndirizzoEmail.setHorizontalAlignment(SwingConstants.CENTER);
        txtIndirizzoEmail.setText("e-mail");
        txtIndirizzoEmail.setBounds(71, 157, 200, 38);
        txtIndirizzoEmail.setColumns(10);
        frmUntitledGaming.getContentPane().add(txtIndirizzoEmail);


        // Listen for focus
        txtIndirizzoEmail.addFocusListener(new FocusListener() {

            @Override
            // Empty the text field when it receives focus
            public void focusGained(FocusEvent e) {
                txtIndirizzoEmail.setText(null);
            }

            @Override
            // Do something when the focus id lost
            public void focusLost(FocusEvent e) {
            }

        });

        JButton btnNewButton = new JButton("Log In");

        btnNewButton.setToolTipText("Log In");
        btnNewButton.setFont(new Font("MV Boli", Font.ITALIC, 14));
        btnNewButton.setBounds(116, 338, 110, 35);

        // Login
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    String passText = new String(passwordField.getPassword());

                    // Check if the login was successful
                    if (controller.eventsListener.userAuth(txtIndirizzoEmail.getText(), passText)) {
                        frmUntitledGaming.dispose();
                        controller.eventsListener.changePage("logged");

                    } else JOptionPane.showMessageDialog(frmUntitledGaming, "Login failed");
                } catch (SQLException e1) {
                    e1.printStackTrace();
                }
            }
        });

        frmUntitledGaming.getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("Registrati");
        btnNewButton_1.setToolTipText("Registrati");
        btnNewButton_1.setFont(new Font("MV Boli", Font.ITALIC, 14));
        btnNewButton_1.setBounds(503, 223, 110, 35);

        // Rquest the focus to unfocus the textbutton lol
        btnNewButton.requestFocusInWindow();

        // Go to the registration page
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                frmUntitledGaming.dispose();
                controller.eventsListener.changePage("registration");
            }
        });

        frmUntitledGaming.getContentPane().add(btnNewButton_1);

        JLabel lblNewLabel_1 = new JLabel("Se non sei ancora");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setFont(new Font("Georgia", Font.ITALIC, 11));
        lblNewLabel_1.setBounds(488, 284, 149, 14);
        frmUntitledGaming.getContentPane().add(lblNewLabel_1);

        JLabel lblRegistratoPuoiFarlo = new JLabel("registrato puoi farlo");
        lblRegistratoPuoiFarlo.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegistratoPuoiFarlo.setFont(new Font("Georgia", Font.ITALIC, 11));
        lblRegistratoPuoiFarlo.setBounds(488, 304, 149, 14);
        frmUntitledGaming.getContentPane().add(lblRegistratoPuoiFarlo);

        JLabel lblQui = new JLabel("qui!");
        lblQui.setHorizontalAlignment(SwingConstants.CENTER);
        lblQui.setFont(new Font("Georgia", Font.ITALIC, 11));
        lblQui.setBounds(488, 324, 149, 14);
        frmUntitledGaming.getContentPane().add(lblQui);

        passwordField = new JPasswordField();
        passwordField.setBackground(new Color(255, 255, 255));
        passwordField.setToolTipText("Password");
        passwordField.setFont(new Font("Georgia", Font.ITALIC, 15));
        passwordField.setHorizontalAlignment(SwingConstants.CENTER);
        passwordField.setForeground(Color.GRAY);
        passwordField.setBounds(71, 242, 200, 38);
        frmUntitledGaming.getContentPane().add(passwordField);

        frmUntitledGaming.setVisible(true);

        // frmUntitledGaming.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{frmUntitledGaming.getContentPane(), lblNewLabel, txtIndirizzoEmil, btnNewButton, btnNewButton_1, lblNewLabel_1, lblRegistratoPuoiFarlo, lblQui, passwordField}));
    }

}





