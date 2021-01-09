/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package contactmanagementsoftware;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author ritz619
 */
public class MUI extends javax.swing.JFrame {

    /**
     * Creates new form MUI
     */
    private static MUI mg;  //static variable for singleton pattern
    //private MUI mg;
    private ArrayList<ArrayList<Acquaintances>> a;
    private ArrayList<ArrayList<Acquaintances>> temp;
    private int x;
    private int num;
    private boolean flag;
    private boolean dflag;
    private String op;
    private String str;

    public void setMg(MUI mg) {
        this.mg = mg;
    }

    public void setA(ArrayList<ArrayList<Acquaintances>> a) {
        this.a = a;
    }

    public void setDescription() {
        name.setText("");
        mobile.setText("");
        email.setText("");
        one.setText("");
        two.setText("");
        three.setText("");
        if (!dflag) {
            name.setEditable(true);
            mobile.setEditable(true);
            email.setEditable(true);
            one.setEditable(true);
            two.setEditable(true);
            three.setEditable(true);
        }
        if (flag) {
            op = "Add";
        } else {
            op = "Edit";
        }
        if (!flag) {
            jButton10.setText("Save");
            Acquaintances e = a.get(x).get(num);
            name.setText(e.getName());
            mobile.setText(e.getMobileNo());
            email.setText(e.getEmail());

            //Factory method pattern
            AcquaintanceFactory fcaller = new FriendsCaller();
            AcquaintanceFactory rcaller = new RelativesCaller();
            AcquaintanceFactory cacaller = new CasualAcquaintanceCaller();
            switch (x) {
                case 0:
                    Acquaintances perF = fcaller.callAcquaintance("PersonalFriends");
                    perF = (PersonalFriends) e;
                    one.setText((((PersonalFriends) perF).getEvents()));
                    two.setText((((PersonalFriends) perF).getAContext()));
                    three.setText((((PersonalFriends) perF).getADate()));
                    break;
                case 1:
                    Acquaintances rel = fcaller.callAcquaintance("Relatives");
                    rel = (Relatives) e;
                    one.setText((((Relatives) rel).getBDate()));
                    two.setText((((Relatives) rel).getLDate()));
                    break;
                case 2:
                    Acquaintances proF = fcaller.callAcquaintance("ProfessionalFriends");
                    proF = (ProfessionalFriends) e;
                    one.setText((((ProfessionalFriends) proF).getCommonInterests()));
                    break;
                case 3:
                    Acquaintances ca = fcaller.callAcquaintance("CasualAcquaintances");
                    ca = (CasualAcquaintances) e;
                    one.setText((((CasualAcquaintances) ca).getWhenWhere()));
                    two.setVisible(true);
                    three.setVisible(true);
                    two.setText((((CasualAcquaintances) ca).getCircumstances()));
                    three.setText((((CasualAcquaintances) ca).getOtherInfo()));
                    break;
                default:
                    break;
            }
        }
        jButton10.setVisible(true);
        jButton11.setVisible(true);
        if (flag) {
            jButton10.setText("Add");
        }
        switch (x) {
            case 0:
                two.setVisible(true);
                three.setVisible(true);
                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Personal Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
                jLabel7.setText("Specific Events:");
                jLabel8.setText("First Acquaintance Context:");
                jLabel9.setVisible(true);
                jLabel3.setVisible(true);
                jLabel8.setVisible(true);
                jLabel7.setVisible(true);
                jScrollPane5.setVisible(true);
                jScrollPane4.setVisible(true);
                jLabel9.setText("<html>First Acquaintance Date:<br>(dd/mm/yyyy)</html>");
                break;
            case 1:
                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Relatives Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
                jLabel7.setText("<html>Relatives Birthday:<br> (dd/mm/yyyy)</html>");
                jLabel8.setVisible(true);
                jLabel7.setVisible(true);
                two.setVisible(true);
                jLabel8.setText("<html>Last Date met:<br> (dd/mm/yyyy)</html>");
                jLabel9.setVisible(false);
                three.setVisible(false);
                jScrollPane4.setVisible(true);
                jScrollPane5.setVisible(false);
                break;
            case 2:
                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Professional Friends Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
                jLabel7.setText("Common Interests: ");
                jLabel7.setVisible(true);
                jLabel8.setVisible(false);
                two.setVisible(false);
                jScrollPane4.setVisible(false);
                jLabel9.setVisible(false);
                three.setVisible(false);
                jScrollPane5.setVisible(false);
                break;
            case 3:
                jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, op + " Casual Acquaintances Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
                jScrollPane5.setVisible(true);
                jScrollPane4.setVisible(true);
                two.setVisible(true);
                three.setVisible(true);
                jLabel7.setVisible(true);
                jLabel8.setVisible(true);
                jLabel9.setVisible(true);
                jLabel7.setText("First meeting time & location:");
                jLabel8.setText("First meeting CIrcumstances:");
                jLabel9.setText("Other useful information:");
                break;
            default:
                break;
        }
        if (dflag) {
            name.setEditable(false);
            mobile.setEditable(false);
            email.setEditable(false);
            one.setEditable(false);
            two.setEditable(false);
            three.setEditable(false);
            jButton10.setText("Back to main menu");
            jButton11.setVisible(false);
            jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Display Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16)));
        }
    }

    //Made private constructor so that only singleton can instantiate the class
    private MUI() {
        initComponents();
        String[] columnNames = {"S.No", "Name", "Mobile", " Email"};
        DefaultTableModel model = new DefaultTableModel(null, columnNames);
        jXTable1.setModel(model);
        setUpTableData();
    }

    //method for getting unique instance following singleton pattern.
    public static MUI getMUIInstance() {
        if (mg == null) {
            mg = new MUI();
        }
        return mg;
    }

    public final void setUpTableData() {
        DefaultTableModel tableModel = (DefaultTableModel) jXTable1.getModel();
        tableModel.setRowCount(0);
        ArrayList<Acquaintances> list;
        try {
            list = a.get(jList1.getSelectedIndex());
            System.out.println(jList1.getSelectedIndex());
        } catch (Exception e) {
            return;
        }
        for (int i = 0; i < list.size(); i++) {
            String[] data = new String[4];
            data[0] = Integer.toString(i + 1);
            data[1] = list.get(i).getName();
            data[2] = list.get(i).getMobileNo();
            data[3] = list.get(i).getEmail();
            tableModel.addRow(data);
        }
        jXTable1.setModel(tableModel);
        tableModel.fireTableDataChanged();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jList1 = new javax.swing.JList();
        jScrollPane2 = new javax.swing.JScrollPane();
        jXTable1 = new org.jdesktop.swingx.JXTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        details = new javax.swing.JTextPane();
        jButton9 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        name = new javax.swing.JTextField();
        email = new javax.swing.JTextField();
        jScrollPane4 = new javax.swing.JScrollPane();
        two = new javax.swing.JTextArea();
        jScrollPane5 = new javax.swing.JScrollPane();
        three = new javax.swing.JTextArea();
        jButton10 = new javax.swing.JButton();
        mobile = new javax.swing.JTextField();
        jScrollPane6 = new javax.swing.JScrollPane();
        one = new javax.swing.JTextArea();
        jButton11 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.CardLayout());

        jPanel1.setBackground(new java.awt.Color(237, 240, 247));

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newexit.png"))); // NOI18N
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jLabel2.setFont(new java.awt.Font("Arial", 1, 32)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(64, 64, 64));
        jLabel2.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        jLabel2.setText("<html>Contact Management System</html>");

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newadd.png"))); // NOI18N
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/newdelete.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/search.png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.setMaximumSize(new java.awt.Dimension(57, 33));
        jButton3.setMinimumSize(new java.awt.Dimension(57, 33));
        jButton3.setPreferredSize(new java.awt.Dimension(57, 33));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        jList1.setBackground(new java.awt.Color(240, 240, 240));
        jList1.setFont(new java.awt.Font("Tahoma", 1, 13)); // NOI18N
        jList1.setModel(new javax.swing.AbstractListModel() {
            String[] strings = { "Personal Friends", "Relatives", "Professional Friends", "Casual Acquaintances" };
            public int getSize() { return strings.length; }
            public Object getElementAt(int i) { return strings[i]; }
        });
        jList1.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                jList1ValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(jList1);

        jXTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "S.No", "Name", "Mobile No", "Email"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jXTable1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jScrollPane2.setViewportView(jXTable1);

        jLabel1.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel1.setText("Select Category:");

        jLabel3.setFont(new java.awt.Font("Arial", 1, 18)); // NOI18N
        jLabel3.setText("Details:");

        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/edit.png"))); // NOI18N
        jButton5.setActionCommand("");
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/userinformation.png"))); // NOI18N
        jButton6.setText("View Details");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        jButton7.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/read.png"))); // NOI18N
        jButton7.setText("Read from file");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });

        jButton8.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/save.png"))); // NOI18N
        jButton8.setText("Save as file");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 172, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addComponent(jScrollPane2))
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 494, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 34, Short.MAX_VALUE)
                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jButton7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 165, Short.MAX_VALUE)
                                    .addComponent(jButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                        .addGap(21, 21, 21))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton4, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 44, Short.MAX_VALUE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jButton6, javax.swing.GroupLayout.DEFAULT_SIZE, 42, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 12, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 306, Short.MAX_VALUE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addContainerGap())
        );

        getContentPane().add(jPanel1, "card2");

        jPanel2.setBackground(new java.awt.Color(237, 240, 247));

        details.setEditable(false);
        jScrollPane3.setViewportView(details);

        jButton9.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton9.setText("Back to main menu");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 642, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 228, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(218, 218, 218))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 488, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        getContentPane().add(jPanel2, "card3");

        jPanel3.setBackground(new java.awt.Color(237, 240, 247));
        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Add Casual Acquaintance Details", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("DialogInput", 1, 16))); // NOI18N

        jLabel4.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel4.setText("Name:");

        jLabel5.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel5.setText("Mobile No:");

        jLabel6.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel6.setText("Email:");

        jLabel7.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel7.setText("First meeting time & location:");

        jLabel8.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel8.setText("First meeting CIrcumstances:");

        jLabel9.setFont(new java.awt.Font("Arial", 1, 13)); // NOI18N
        jLabel9.setText("Other useful information:");

        name.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nameActionPerformed(evt);
            }
        });

        two.setColumns(20);
        two.setRows(5);
        two.setAutoscrolls(false);
        jScrollPane4.setViewportView(two);

        three.setColumns(20);
        three.setRows(5);
        jScrollPane5.setViewportView(three);

        jButton10.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton10.setText("Add");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });

        one.setColumns(20);
        one.setRows(5);
        jScrollPane6.setViewportView(one);

        jButton11.setFont(new java.awt.Font("Arial", 1, 14)); // NOI18N
        jButton11.setText("Cancel");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel9)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5)
                    .addComponent(jLabel4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jButton10, javax.swing.GroupLayout.DEFAULT_SIZE, 138, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 146, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(159, 159, 159))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, 262, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(name, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel5)
                    .addComponent(mobile, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(email, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7)
                    .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(jLabel8))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(17, 17, 17)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 33, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3))
        );

        getContentPane().add(jPanel3, "card4");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        int index = jList1.getSelectedIndex();
        if (index < 0) {
            JOptionPane.showMessageDialog(mg, "Select a category!");
            return;
        }

        //----------------------------------------Command Pattern-------------------------------------------
        AddDeleteManager adm = new AddDeleteManager();
        AcquaintanceVendor advendor = new AcquaintanceVendor(mg, index);

        AddCommand acommand = new AddCommand(advendor);
        adm.setCommand(acommand);
        adm.buttonWasPressed();

    }//GEN-LAST:event_jButton1ActionPerformed

    public void setjPanel1(JPanel jPanel1) {
        this.jPanel1 = jPanel1;
    }

    public void setjPanel3(JPanel jPanel3) {
        this.jPanel3 = jPanel3;
    }

    public void setX(int x) {
        this.x = x;
    }

    public void setFlag(boolean flag) {
        this.flag = flag;
    }

    public void setDflag(boolean dflag) {
        this.dflag = dflag;
    }

    public int getXX() {
        return x;
    }

    public boolean getFlag() {
        return flag;
    }

    public boolean getDflag() {
        return dflag;
    }

    public JList getjList1() {
        return jList1;
    }

    public JPanel getjPanel1() {
        return jPanel1;
    }

    public JPanel getjPanel3() {
        return jPanel3;
    }

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        int index = jList1.getSelectedIndex();
        if (index < 0) {
            JOptionPane.showMessageDialog(mg, "Select a category!");
            return;
        }
        int tindex = jXTable1.getSelectedRow();
        if (tindex < 0) {
            JOptionPane.showMessageDialog(mg, "Select an entry!");
            return;
        }
        //----------------------------------------Command Pattern-------------------------------------------
        AddDeleteManager adm = new AddDeleteManager();
        AcquaintanceVendor advendor = new AcquaintanceVendor(mg, index, tindex);

        DeleteCommand dcommand = new DeleteCommand(advendor);
        adm.setCommand(dcommand);
        adm.buttonWasPressed();
    }//GEN-LAST:event_jButton2ActionPerformed

    public ArrayList<ArrayList<Acquaintances>> getA() {
        return a;
    }

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String s = (String) JOptionPane.showInputDialog(
                mg,
                "Enter name: ",
                "Input",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "");
        if (s == null) {
            return;
        }
        jPanel1.setVisible(false);
        jPanel2.setVisible(true);
        str = s;
        details.setContentType("text/html");
        runn();
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jList1ValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_jList1ValueChanged
        setUpTableData();
    }//GEN-LAST:event_jList1ValueChanged

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        int index = jList1.getSelectedIndex();
        if (index < 0) {
            JOptionPane.showMessageDialog(mg, "Select a category!");
            return;
        }
        int tindex = jXTable1.getSelectedRow();
        if (tindex < 0) {
            JOptionPane.showMessageDialog(mg, "Select an entry!");
            return;
        }
        num = tindex;
        flag = false;
        dflag = false;
        x = index;
        setDescription();
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        int index = jList1.getSelectedIndex();
        if (index < 0) {
            JOptionPane.showMessageDialog(mg, "Select a category!");
            return;
        }
        int tindex = jXTable1.getSelectedRow();
        if (tindex < 0) {
            JOptionPane.showMessageDialog(mg, "Select an entry!");
            return;
        }
        num = tindex;
        flag = false;
        x = index;
        jPanel1.setVisible(false);
        jPanel3.setVisible(true);
        dflag = true;
        setDescription();
    }//GEN-LAST:event_jButton6ActionPerformed

    public void runn() {
        String s = "<html> <b>Search results:</b><br>Found!<br><br>Acquaintance Details: <br>";
        int j = 0;
        for (int i = 0; i < a.get(0).size(); i++) {
            if (a.get(0).get(i).getName().matches(str)) {
                j++;
                PersonalFriends perF = (PersonalFriends) a.get(0).get(i);
                if (j == 1) {
                    s = s.concat("<br>I. Personal Friends<br>");
                }
                s = s.concat(j + ". Name: " + perF.getName() + "<br>");
                s = s.concat("Mobile No: " + perF.getMobileNo() + "<br>");
                s = s.concat("Email: " + perF.getEmail() + "<br>");
                s = s.concat("Specific events: " + perF.getEvents() + "<br>");
                s = s.concat("First Acquaintance context: " + perF.getAContext() + "<br>");
                s = s.concat("First Acquaintance date: " + perF.getADate() + "<br>");
            }
        }
        j = 0;
        for (int i = 0; i < a.get(1).size(); i++) {
            if (a.get(1).get(i).getName().matches(str)) {
                j++;
                Relatives rel = (Relatives) a.get(1).get(i);
                if (j == 1) {
                    s = s.concat("<br>II. Relatives<br>");
                }
                s = s.concat(j + ". Name: " + rel.getName() + "<br>");
                s = s.concat("Mobile No: " + rel.getMobileNo() + "<br>");
                s = s.concat("Email: " + rel.getEmail() + "<br>");
                s = s.concat("Relatives Birthday: " + rel.getBDate() + "<br>");
                s = s.concat("Last met date: " + rel.getLDate() + "<br>");
            }
        }
        j = 0;
        for (int i = 0; i < a.get(2).size(); i++) {
            if (a.get(2).get(i).getName().matches(str)) {
                j++;
                ProfessionalFriends proF = (ProfessionalFriends) a.get(2).get(i);
                if (j == 1) {
                    s = s.concat("<br>III. Professional Friends<br>");
                }
                s = s.concat(j + ". Name: " + proF.getName() + "<br>");
                s = s.concat("Mobile No: " + proF.getMobileNo() + "<br>");
                s = s.concat("Email: " + proF.getEmail() + "<br>");
                s = s.concat("Common Interests: " + proF.getCommonInterests() + "<br>");
            }
        }
        j = 0;
        for (int i = 0; i < a.get(3).size(); i++) {
            if (a.get(3).get(i).getName().matches(str)) {
                j++;
                CasualAcquaintances ca = (CasualAcquaintances) a.get(3).get(i);
                if (j == 1) {
                    s = s.concat("<br>IV. Casual Acquaintances<br>");
                }
                s = s.concat(j + ". Name: " + ca.getName() + "<br>");
                s = s.concat("Mobile No: " + ca.getMobileNo() + "<br>");
                s = s.concat("Email: " + ca.getEmail() + "<br>");
                s = s.concat("First met location & time: " + ca.getWhenWhere() + "<br>");
                s = s.concat("First met circumstances: " + ca.getCircumstances() + "<br>");
                s = s.concat("Other useful information: " + ca.getOtherInfo() + "<br>");
            }
        }
        if (s.matches("<html> <b>Search results:</b><br>Found!<br><br>Acquaintance Details: <br>")) {
            s = "<html>No result found</html>";
        } else {
            s = s.concat("</html>");
        }
        details.setText(s);
    }

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.dir")));
        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            try {
                temp = (ArrayList<ArrayList<Acquaintances>>) SerializationUtil.deserialize(selectedFile);
            } catch (ClassNotFoundException | IOException e) {
                JOptionPane.showMessageDialog(mg, "Error");
                return;
            }
        } else {
            return;
        }
        try {
            for (int i = 0; i < 4; i++) {
                for (int j = 0; j < temp.get(i).size(); j++) {
                    a.get(i).add(temp.get(i).get(j));
                }
            }
        } catch (Exception e) {

        }
        mg.setUpTableData();
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String s = (String) JOptionPane.showInputDialog(
                mg,
                "Enter file name: (*.ser)",
                "Input",
                JOptionPane.PLAIN_MESSAGE,
                null,
                null,
                "output.ser");
        if (s == null) {
            return;
        }
        if (!s.endsWith(".ser")) {
            JOptionPane.showMessageDialog(mg, "File name should end with .ser");
            return;
        }
        File[] fileList = (new File(".")).listFiles((File pathname) -> pathname.getName().endsWith(".ser"));
        boolean flag = false;
        for (File f : fileList) {
            if (f.getName().matches(s)) {
                flag = true;
            }
        }
        if (flag) {
            int q = JOptionPane.showConfirmDialog(mg, s + " already exists:\nAre you sure you want to overwrite?");
            if (q != 0) {
                return;
            }
        }
        try {
            SerializationUtil.serialize(a, s);
        } catch (IOException e) {
            return;
        }
        JOptionPane.showMessageDialog(mg, s + " saved successfully");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        jPanel2.setVisible(false);
        jPanel1.setVisible(true);
    }//GEN-LAST:event_jButton9ActionPerformed

    private void nameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_nameActionPerformed

    public boolean MobileNoChecker(String str) {
        int x;
        if (str.isEmpty() || str.length() < 6 || str.length() > 15) {
            return false;
        }
        for (int j = 0; j < str.length(); j++) {
            x = (int) str.charAt(j);
            if (x < 48 || x > 57) {
                return false;
            }
        }
        return true;
    }

    public boolean validDate(String Date) {
        String pattern = "[0-3][0-9]/[0-1][0-9]/[0-9]{4}";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(Date);
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        if (!m.find()) {
            JOptionPane.showMessageDialog(mg, "Enter a valid date");
            return false;
        } else {
            return true;
        }
    }

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        dflag = true;
        String Name = name.getText();
        if (Name.isEmpty()) {
            JOptionPane.showMessageDialog(mg, "Enter a name");
            return;
        }
        String Mobile = mobile.getText();
        if (!MobileNoChecker(Mobile)) {
            JOptionPane.showMessageDialog(mg, "Enter a valid mobile number (6-15 digits)");
            return;
        }
        String Email = email.getText();
        if (!Email.contains("@")) {
            JOptionPane.showMessageDialog(mg, "Enter a valid email");
            return;
        }
        String One, Two, Three;
        switch (x) {
            case 0: //perF
                One = one.getText();
                if (One.isEmpty() || One.length() > 300) {
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Two = two.getText();
                if (Two.isEmpty() || Two.length() > 300) {
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Three = three.getText();
                if (!validDate(Three)) {
                    return;
                }
                if (Three.isEmpty() || Three.length() > 300) {
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                PersonalFriends perF;
                if (flag) {
                    perF = new PersonalFriends();
                } else {
                    perF = (PersonalFriends) a.get(x).get(num);
                }
                //Template method pattern
                perF.createAcquaintances(Name, Mobile, Email, One, Two, Three);

                if (flag) {
                    a.get(x).add(perF);
                }
                //this.a.get(x).add(perF);
                break;
            case 1: //rel
                One = one.getText();
                if (One.isEmpty() || One.length() > 300) {
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                if (!validDate(One)) {
                    return;
                }
                Two = two.getText();
                if (Two.isEmpty() || Two.length() > 300) {
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                if (!validDate(Two)) {
                    return;
                }
                Relatives rel;
                if (flag) {
                    rel = new Relatives();
                } else {
                    rel = (Relatives) a.get(x).get(num);
                }

                //Template method pattern
                rel.createAcquaintances(Name, Mobile, Email, One, Two, "");

                if (flag) {
                    a.get(x).add(rel);
                }
                break;
            case 2: //proF
                One = one.getText();
                if (One.isEmpty() || One.length() > 300) {
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                ProfessionalFriends proF;
                if (flag) {
                    proF = new ProfessionalFriends();
                } else {
                    proF = (ProfessionalFriends) a.get(x).get(num);
                }

                //Template method pattern
                proF.createAcquaintances(Name, Mobile, Email, One, "", "");

                if (flag) {
                    a.get(x).add(proF);
                }
                break;
            case 3: //ca
                One = one.getText();
                if (One.isEmpty() || One.length() > 300) {
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Two = two.getText();
                if (Two.isEmpty() || Two.length() > 300) {
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                Three = three.getText();
                if (Three.isEmpty() || Three.length() > 300) {
                    JOptionPane.showMessageDialog(mg, "Enter a valid value ( 1 to 300 chars)");
                    return;
                }
                CasualAcquaintances ca;
                if (flag) {
                    ca = new CasualAcquaintances();
                } else {
                    ca = (CasualAcquaintances) a.get(x).get(num);
                }
                //Template method pattern
                ca.createAcquaintances(Name, Mobile, Email, One, Two, Three);

                if (flag) {
                    a.get(x).add(ca);
                }
                break;
            default:
                break;
        }
        jPanel1.setVisible(true);
        jPanel3.setVisible(false);
        mg.setUpTableData();
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        jPanel1.setVisible(true);
        jPanel3.setVisible(false);
    }//GEN-LAST:event_jButton11ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MUI.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MUI().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextPane details;
    private javax.swing.JTextField email;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JList jList1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private org.jdesktop.swingx.JXTable jXTable1;
    private javax.swing.JTextField mobile;
    private javax.swing.JTextField name;
    private javax.swing.JTextArea one;
    private javax.swing.JTextArea three;
    private javax.swing.JTextArea two;
    // End of variables declaration//GEN-END:variables
}
