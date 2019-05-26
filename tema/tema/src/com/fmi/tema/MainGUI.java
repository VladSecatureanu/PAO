package com.fmi.tema;

import Models.Angajat;
import Models.User;
import Services.ServiciuAngajati;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.concurrent.ExecutionException;

public class MainGUI {
    private JPanel mainPanel;
    private JButton showButten;
    private JScrollPane mainJScrollPane;
    private JTable mainTable;
    private JButton arataMediciButton;
    private JButton arataAsistenteButton;
    private JButton arataTotiAngajatiiButton;

    public MainGUI() {
        showButten.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                UserForm userForm = new UserForm();
                userForm.showUserForm();

                System.out.println("Returnat de la buton:" + userForm.getUserByForm());
                userForm.dispose();
            }
        });

        arataMediciButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingWorker<String, String> stringSwingWorker = new SwingWorker<String, String>() {
                    @Override
                    protected String doInBackground() throws Exception {
                        return ServiciuAngajati.getInstance().returneazaMedici();
                    }

                    @Override
                    protected void done() {
                        try {
                            String medici = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };
                                    defaultTableModel.addColumn("Id");
                                    defaultTableModel.addColumn("Nume");
                                    defaultTableModel.addColumn("Prenume");
                                    defaultTableModel.addColumn("Salariu");
                                    defaultTableModel.addColumn("Specializare");
                                    defaultTableModel.addColumn("Vechime");

                                    String[] aux = medici.split("\n");

                                    for(int i =0 ; i < aux.length;  i++){
                                        String[] aux2 = aux[i].split(" ");
                                        defaultTableModel.addRow(new Object[] {aux2[0], aux2[1], aux2[2], aux2[3], aux2[4], aux2[5]});
                                    }

                                    mainTable.setModel(defaultTableModel);
                                }
                            });

                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }
                    }
                };

                stringSwingWorker.execute();

            }
        });

        arataAsistenteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingWorker<String, String> stringSwingWorker = new SwingWorker<String, String>() {
                    @Override
                    protected String doInBackground() throws Exception {
                        return ServiciuAngajati.getInstance().returneazaAsistente();
                    }

                    @Override
                    protected void done() {
                        try {
                            String asistente = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };
                                    defaultTableModel.addColumn("Id");
                                    defaultTableModel.addColumn("Nume");
                                    defaultTableModel.addColumn("Prenume");
                                    defaultTableModel.addColumn("Salariu");
                                    defaultTableModel.addColumn("Sectie");
                                    defaultTableModel.addColumn("Medic");

                                    String[] aux = asistente.split("\n");

                                    for(int i =0 ; i < aux.length;  i++){
                                        String[] aux2 = aux[i].split(" ");
                                        defaultTableModel.addRow(new Object[] {aux2[0], aux2[1], aux2[2], aux2[3], aux2[4], aux2[5]});
                                    }

                                    mainTable.setModel(defaultTableModel);
                                }
                            });

                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }
                    }
                };

                stringSwingWorker.execute();

            }
        });

        arataTotiAngajatiiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                SwingWorker<String, String> stringSwingWorker = new SwingWorker<String, String>() {
                    @Override
                    protected String doInBackground() throws Exception {
                        return ServiciuAngajati.getInstance().returneazaTotiAngajatii();
                    }

                    @Override
                    protected void done() {
                        try {
                            String Angajati = get();

                            SwingUtilities.invokeLater(new Runnable() {
                                @Override
                                public void run() {
                                    DefaultTableModel defaultTableModel = new DefaultTableModel() {
                                        @Override
                                        public boolean isCellEditable(int row, int column) {
                                            return false; //super.isCellEditable(row, column);
                                        }
                                    };
                                    defaultTableModel.addColumn("Id");
                                    defaultTableModel.addColumn("Nume");
                                    defaultTableModel.addColumn("Prenume");
                                    defaultTableModel.addColumn("Salariu");
                                    //defaultTableModel.addColumn("Sectie/Specializare");
                                    //defaultTableModel.addColumn("Medic/Vechime");

                                    String[] aux = Angajati.split("\n");

                                    for(int i =0 ; i < aux.length;  i++){
                                        String[] aux2 = aux[i].split(" ");
                                        defaultTableModel.addRow(new Object[] {aux2[0], aux2[1], aux2[2], aux2[3]}); //, aux2[4], aux2[5]});
                                    }

                                    mainTable.setModel(defaultTableModel);
                                }
                            });

                        } catch (InterruptedException ex) {
                            ex.printStackTrace();
                        } catch (ExecutionException ex) {
                            ex.printStackTrace();
                        }
                    }
                };

                stringSwingWorker.execute();

            }
        });
    }

    private void initFrameWithMenu(){
        JFrame jFrame = new JFrame("Spital");

        jFrame.setPreferredSize(new Dimension(800, 600));
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setContentPane(this.mainPanel);

        JMenuBar jMenuBar = new JMenuBar();
        JMenu jMenu = new JMenu("File");

        JMenuItem exitMenuItem = new JMenuItem("exit");
        exitMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        jMenu.add(exitMenuItem);
        jMenuBar.add(jMenu);

        jFrame.setJMenuBar(jMenuBar);

        jFrame.pack();
        jFrame.setVisible(true);


    }

    public static void main(String[] args){

        MainGUI mainGUI = new MainGUI();

        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                mainGUI.initFrameWithMenu();
            }
        });
    }
}
