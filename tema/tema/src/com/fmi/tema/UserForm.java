package com.fmi.tema;

import Services.AuditAngajati;
import Services.ServiciuAngajati;
import Services.ServiciuScriereCitireAsistente;

import javax.swing.*;
import javax.swing.text.Document;
import javax.swing.text.StyledDocument;
import java.awt.event.*;

public class UserForm extends JDialog {
    private JPanel contentPane;
    private JButton buttonOK;
    private JButton buttonCancel;
    private JTextPane afisajAngajati;
    private JTextArea afisaj;
    private JTextField numeDoctor1;

    public UserForm() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(buttonOK);

        buttonOK.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onOK();
            }
        });

        buttonCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

        // call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

        // call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);
    }

    private void onOK() {
        System.out.println("Ok button");
        this.setVisible(false);
        //dispose();
    }

    private void onCancel() {
        System.out.println("Cancel button");
        dispose();
    }

    public void showUserForm(){
        UserForm dialog = new UserForm();

        dialog.pack();
        dialog.setVisible(true);
    }

    public String getUserByForm(){
        return "userul este aici ca paramentru";
    }

    public static void main(String[] args) {
        UserForm dialog = new UserForm();
        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }
}
