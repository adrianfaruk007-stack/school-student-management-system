/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JFrame.java to edit this template
 */
package com.mycompany.project2;

/**
 *
 * @author MR.Chief
 */
public class SchoolStudentManagementSystem extends javax.swing.JFrame {
    
    private static final java.util.logging.Logger logger = java.util.logging.Logger.getLogger(SchoolStudentManagementSystem.class.getName());

    /**
     * Creates new form SchoolStudentManagementSystem
     */
    public SchoolStudentManagementSystem() {
        try {
    javax.swing.UIManager.setLookAndFeel(javax.swing.UIManager.getCrossPlatformLookAndFeelClassName());
} catch (Exception e) { }
    initComponents();
    setTitle("School Student Management System");
    setSize(1350, 790);
    setLocationRelativeTo(null);
    
    
    java.util.Calendar cal = java.util.Calendar.getInstance();
    cal.set(2010, 0, 1);
    spnDob.setModel(new javax.swing.SpinnerDateModel(cal.getTime(), null, new java.util.Date(), java.util.Calendar.DAY_OF_MONTH));
 spnDob.setEditor(new javax.swing.JSpinner.DateEditor(spnDob, "dd/MM/yyyy"));
 loadStudents();
 styleUI();
     // ---- spacing ----
    java.awt.Color light2 = new java.awt.Color(244, 246, 249);

    // outer margin around everything
    jPanel1.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 20, 10, 20));

    // keep form fields a normal height by pinning the form to the top
    javax.swing.JPanel formWrapper = new javax.swing.JPanel(new java.awt.BorderLayout());
    formWrapper.setBackground(light2);
    formWrapper.setBorder(javax.swing.BorderFactory.createEmptyBorder(10, 0, 0, 20));
    jPanel1.remove(pnlForm);
    pnlForm.setPreferredSize(new java.awt.Dimension(340, 8 * 48));
    ((java.awt.GridLayout) pnlForm.getLayout()).setVgap(12);
    formWrapper.add(pnlForm, java.awt.BorderLayout.NORTH);
    jPanel1.add(formWrapper, java.awt.BorderLayout.LINE_START);

    // padding inside the text boxes
    javax.swing.border.Border fieldBorder = javax.swing.BorderFactory.createCompoundBorder(
            javax.swing.BorderFactory.createLineBorder(new java.awt.Color(190, 198, 210)),
            javax.swing.BorderFactory.createEmptyBorder(4, 8, 4, 8));
    for (java.awt.Component c : pnlForm.getComponents()) {
        if (c instanceof javax.swing.JTextField) {
            ((javax.swing.JTextField) c).setBorder(fieldBorder);
        }
    }
    txtSearch.setBorder(fieldBorder);

    // breathing room for search bar, table and buttons
    pnllSearch.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 0, 10, 0));
    jScrollPane1.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(210, 215, 222)));
    pnlButtons.setBorder(javax.swing.BorderFactory.createEmptyBorder(12, 0, 4, 0));
    ((java.awt.FlowLayout) pnlButtons.getLayout()).setHgap(15);
 
}
    private final StudentDAO dao = new StudentDAO();

private void loadStudents() {
    try {
        javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblStudents.getModel();
        model.setRowCount(0);
        for (Student s : dao.getAllStudents()) {
            model.addRow(new Object[]{
                s.getAdmissionNo(), s.getFullName(), s.getGender(), s.getDob(),
                s.getClassName(), s.getGuardianName(), s.getGuardianPhone(), s.getAddress()
            });
        }
    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Could not load students: " + e.getMessage());
    }
}
 
    private void clearForm() {
        spnDob.setValue(new java.util.GregorianCalendar(2010, 0, 1).getTime());
    txtAdmissionNo.setText("");
    txtFullName.setText("");
    cmbGender.setSelectedIndex(0);
    cmbClass.setSelectedIndex(0);
    txtGuardianName.setText("");
    txtGuardianPhone.setText("");
    txtAddress.setText("");
    txtAdmissionNo.requestFocus();
}
    private void styleButton(javax.swing.JButton b, java.awt.Color bg) {
    b.setBackground(bg);
    b.setForeground(java.awt.Color.WHITE);
    b.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14));
    b.setFocusPainted(false);
    b.setOpaque(true);
    b.setBorderPainted(false);
    b.setPreferredSize(new java.awt.Dimension(110, 36));
}

private void styleUI() {
    java.awt.Color navy = new java.awt.Color(31, 58, 95);
    java.awt.Color light = new java.awt.Color(244, 246, 249);
    java.awt.Color teal = new java.awt.Color(46, 134, 171);
    java.awt.Font normal = new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 14);
    java.awt.Font bold = new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 14);

    // backgrounds
    jPanel1.setBackground(light);
    pnlForm.setBackground(light);
    pnlButtons.setBackground(light);
    pnllSearch.setBackground(light);

    // form labels and fields
    for (java.awt.Component c : pnlForm.getComponents()) {
        c.setFont(normal);
        if (c instanceof javax.swing.JLabel) {
            c.setForeground(navy);
            c.setFont(bold);
        }
    }
    lblSearch.setForeground(navy);
    lblSearch.setFont(bold);
    txtSearch.setFont(normal);

    // table
    tblStudents.setFont(normal);
    tblStudents.setRowHeight(26);
    tblStudents.setSelectionBackground(teal);
    tblStudents.setSelectionForeground(java.awt.Color.WHITE);
    tblStudents.setGridColor(new java.awt.Color(220, 224, 230));
    javax.swing.table.JTableHeader header = tblStudents.getTableHeader();
    header.setBackground(navy);
    header.setForeground(java.awt.Color.WHITE);
    header.setFont(bold);

    // column widths
    int[] widths = {115, 170, 65, 95, 65, 140, 125, 190};
    for (int i = 0; i < widths.length; i++) {
        tblStudents.getColumnModel().getColumn(i).setPreferredWidth(widths[i]);
    }

    // buttons
    styleButton(btnAdd, new java.awt.Color(46, 139, 87));
    styleButton(btnUpdate, new java.awt.Color(41, 128, 185));
    styleButton(btnClear, new java.awt.Color(127, 140, 141));
    styleButton(btnDelete, new java.awt.Color(192, 57, 43));
    
    cmbGender.setBackground(java.awt.Color.WHITE);
cmbClass.setBackground(java.awt.Color.WHITE);

    // ---- title banner ----
    javax.swing.JLabel title = new javax.swing.JLabel("School Student Management System");
    title.setForeground(java.awt.Color.WHITE);
    title.setFont(new java.awt.Font("Segoe UI", java.awt.Font.BOLD, 24));

    javax.swing.JLabel subtitle = new javax.swing.JLabel("Register, search and manage student records");
    subtitle.setForeground(new java.awt.Color(190, 205, 225));
    subtitle.setFont(new java.awt.Font("Segoe UI", java.awt.Font.PLAIN, 13));

    javax.swing.JPanel titleText = new javax.swing.JPanel(new java.awt.GridLayout(2, 1, 0, 2));
    titleText.setOpaque(false);
    titleText.add(title);
    titleText.add(subtitle);

    javax.swing.JPanel banner = new javax.swing.JPanel(new java.awt.BorderLayout());
    banner.setBackground(navy);
    banner.setBorder(javax.swing.BorderFactory.createEmptyBorder(14, 24, 14, 24));
    banner.add(titleText, java.awt.BorderLayout.WEST);

    // put the banner above the search bar
    jPanel1.remove(pnllSearch);
    javax.swing.JPanel top = new javax.swing.JPanel(new java.awt.BorderLayout());
    top.setBackground(light);
    top.add(banner, java.awt.BorderLayout.NORTH);
    top.add(pnllSearch, java.awt.BorderLayout.CENTER);
    jPanel1.add(top, java.awt.BorderLayout.PAGE_START);

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
        pnlForm = new javax.swing.JPanel();
        lblAdmissionNo = new javax.swing.JLabel();
        txtAdmissionNo = new javax.swing.JTextField();
        lblFullName = new javax.swing.JLabel();
        txtFullName = new javax.swing.JTextField();
        lblGender = new javax.swing.JLabel();
        cmbGender = new javax.swing.JComboBox<>();
        lblDob = new javax.swing.JLabel();
        spnDob = new javax.swing.JSpinner();
        lblClass = new javax.swing.JLabel();
        cmbClass = new javax.swing.JComboBox<>();
        lblGuardianName = new javax.swing.JLabel();
        txtGuardianName = new javax.swing.JTextField();
        lblGuardianPhone = new javax.swing.JLabel();
        txtGuardianPhone = new javax.swing.JTextField();
        lblAddress = new javax.swing.JLabel();
        txtAddress = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStudents = new javax.swing.JTable();
        pnlButtons = new javax.swing.JPanel();
        btnAdd = new javax.swing.JButton();
        btnUpdate = new javax.swing.JButton();
        btnClear = new javax.swing.JButton();
        btnDelete = new javax.swing.JButton();
        pnllSearch = new javax.swing.JPanel();
        lblSearch = new javax.swing.JLabel();
        txtSearch = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setPreferredSize(new java.awt.Dimension(1000, 600));
        jPanel1.setLayout(new java.awt.BorderLayout());

        pnlForm.setPreferredSize(new java.awt.Dimension(380, 400));
        pnlForm.setLayout(new java.awt.GridLayout(0, 2, 10, 10));

        lblAdmissionNo.setText("Admission No.");
        pnlForm.add(lblAdmissionNo);
        pnlForm.add(txtAdmissionNo);

        lblFullName.setText("Full Name");
        pnlForm.add(lblFullName);
        pnlForm.add(txtFullName);

        lblGender.setText("Gender");
        pnlForm.add(lblGender);

        cmbGender.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Male", "Female" }));
        pnlForm.add(cmbGender);

        lblDob.setText("Date of Birth");
        pnlForm.add(lblDob);
        pnlForm.add(spnDob);

        lblClass.setText("Class");
        pnlForm.add(lblClass);

        cmbClass.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Form 1", "Form 2", "Form 3", "Form 4" }));
        pnlForm.add(cmbClass);

        lblGuardianName.setText("Guardian Name");
        pnlForm.add(lblGuardianName);
        pnlForm.add(txtGuardianName);

        lblGuardianPhone.setText("Guardian Phone");
        pnlForm.add(lblGuardianPhone);
        pnlForm.add(txtGuardianPhone);

        lblAddress.setText("Address");
        pnlForm.add(lblAddress);
        pnlForm.add(txtAddress);

        jPanel1.add(pnlForm, java.awt.BorderLayout.LINE_START);

        jScrollPane1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jScrollPane1MouseClicked(evt);
            }
        });

        tblStudents.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Admission No", "Full Name", "Gender", "Date of Birth", "Class", "Guardian Name", "Guardian Phone", "Address"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblStudents.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_SELECTION);
        tblStudents.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblStudentsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblStudents);

        jPanel1.add(jScrollPane1, java.awt.BorderLayout.CENTER);

        btnAdd.setText("Add");
        btnAdd.addActionListener(this::btnAddActionPerformed);
        pnlButtons.add(btnAdd);

        btnUpdate.setText("Update");
        btnUpdate.addActionListener(this::btnUpdateActionPerformed);
        pnlButtons.add(btnUpdate);

        btnClear.setText("Clear");
        btnClear.addActionListener(this::btnClearActionPerformed);
        pnlButtons.add(btnClear);

        btnDelete.setText("Delete");
        btnDelete.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnDeleteMouseClicked(evt);
            }
        });
        btnDelete.addActionListener(this::btnDeleteActionPerformed);
        pnlButtons.add(btnDelete);

        jPanel1.add(pnlButtons, java.awt.BorderLayout.PAGE_END);

        lblSearch.setText("Search");
        pnllSearch.add(lblSearch);

        txtSearch.setColumns(20);
        txtSearch.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSearchKeyReleased(evt);
            }
        });
        pnllSearch.add(txtSearch);

        jPanel1.add(pnllSearch, java.awt.BorderLayout.PAGE_START);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1149, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 582, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
     
        
        String admNo = txtAdmissionNo.getText().trim();
    String name  = txtFullName.getText().trim();
    String gName = txtGuardianName.getText().trim();
    String address = txtAddress.getText().trim();
    String gPhone =txtGuardianPhone.getText().trim();
    
    if (admNo.isEmpty() || name.isEmpty() ||address.isEmpty() ||
    gName.isEmpty() || gPhone.isEmpty() )
    {javax.swing.JOptionPane.showMessageDialog
    (this, "Please fill in all required fields.");
        return;}
    
    javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblStudents.getModel();

for (int i = 0; i < model.getRowCount(); i++) {
    if (model.getValueAt(i, 0).equals(admNo)) {
        javax.swing.JOptionPane.showMessageDialog(this, "That admission number already exists.");
        return;
    }
}

String dob = new java.text.SimpleDateFormat("dd/MM/yyyy").format((java.util.Date) spnDob.getValue());

Student s = new Student(admNo, name, cmbGender.getSelectedItem().toString(), dob,
        cmbClass.getSelectedItem().toString(), gName, gPhone, address);

try {
    dao.addStudent(s);
    loadStudents();
    clearForm();
    javax.swing.JOptionPane.showMessageDialog(this, "Student saved.");
} catch (java.sql.SQLException e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Could not save student: " + e.getMessage());
}
    
clearForm();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnClearActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnClearActionPerformed
    
        
        
        clearForm();
        tblStudents.clearSelection();
        
        
    }//GEN-LAST:event_btnClearActionPerformed

    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDeleteActionPerformed
      int row = tblStudents.getSelectedRow();

if (row == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please select a student to delete.");
    return;
}

row = tblStudents.convertRowIndexToModel(row);
javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblStudents.getModel();
String admNo = model.getValueAt(row, 0).toString();

int confirm = javax.swing.JOptionPane.showConfirmDialog(
        this, "Delete this student record?", "Confirm Delete",
        javax.swing.JOptionPane.YES_NO_OPTION);

if (confirm == javax.swing.JOptionPane.YES_OPTION) {
    try {
        dao.deleteStudent(admNo);
        loadStudents();
        clearForm();
    } catch (java.sql.SQLException e) {
        javax.swing.JOptionPane.showMessageDialog(this, "Could not delete student: " + e.getMessage());
    }
}
        


        
        
    }//GEN-LAST:event_btnDeleteActionPerformed

    private void btnDeleteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnDeleteMouseClicked
   
    }//GEN-LAST:event_btnDeleteMouseClicked

    private void tblStudentsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblStudentsMouseClicked
          int row = tblStudents.getSelectedRow();
          row = tblStudents.convertRowIndexToModel(row);
if (row == -1) {
    return;
}

javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblStudents.getModel();

txtAdmissionNo.setText(model.getValueAt(row, 0).toString());
txtFullName.setText(model.getValueAt(row, 1).toString());
cmbGender.setSelectedItem(model.getValueAt(row, 2).toString());

try {
    java.util.Date dob = new java.text.SimpleDateFormat("dd/MM/yyyy")
            .parse(model.getValueAt(row, 3).toString());
    spnDob.setValue(dob);
} catch (java.text.ParseException e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Could not read the date of birth.");
}

cmbClass.setSelectedItem(model.getValueAt(row, 4).toString());
txtGuardianName.setText(model.getValueAt(row, 5).toString());
txtGuardianPhone.setText(model.getValueAt(row, 6).toString());
txtAddress.setText(model.getValueAt(row, 7).toString());
    }//GEN-LAST:event_tblStudentsMouseClicked

    private void btnUpdateActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUpdateActionPerformed
      int row = tblStudents.getSelectedRow();

if (row == -1) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please select a student to update.");
    return;
}

row = tblStudents.convertRowIndexToModel(row);
javax.swing.table.DefaultTableModel model = (javax.swing.table.DefaultTableModel) tblStudents.getModel();
String originalAdmNo = model.getValueAt(row, 0).toString();

String admNo = txtAdmissionNo.getText().trim();
String name = txtFullName.getText().trim();
String gName = txtGuardianName.getText().trim();
String gPhone = txtGuardianPhone.getText().trim();
String address = txtAddress.getText().trim();

if (admNo.isEmpty() || name.isEmpty() || gName.isEmpty() || gPhone.isEmpty() || address.isEmpty()) {
    javax.swing.JOptionPane.showMessageDialog(this, "Please fill in all required fields.");
    return;
}

String dob = new java.text.SimpleDateFormat("dd/MM/yyyy").format((java.util.Date) spnDob.getValue());

Student s = new Student(admNo, name, cmbGender.getSelectedItem().toString(), dob,
        cmbClass.getSelectedItem().toString(), gName, gPhone, address);

try {
    dao.updateStudent(originalAdmNo, s);
    loadStudents();
    tblStudents.clearSelection();
    clearForm();
    javax.swing.JOptionPane.showMessageDialog(this, "Student updated.");
} catch (java.sql.SQLException e) {
    javax.swing.JOptionPane.showMessageDialog(this, "Could not update student: " + e.getMessage());
}
    }//GEN-LAST:event_btnUpdateActionPerformed

    private void txtSearchKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSearchKeyReleased
        String text = txtSearch.getText().trim();

javax.swing.table.TableRowSorter<javax.swing.table.TableModel> sorter =
        new javax.swing.table.TableRowSorter<>(tblStudents.getModel());
tblStudents.setRowSorter(sorter);

if (text.isEmpty()) {
    sorter.setRowFilter(null);
} else {
    sorter.setRowFilter(javax.swing.RowFilter.regexFilter(
            "(?i)" + java.util.regex.Pattern.quote(text), 0, 1));
}
    }//GEN-LAST:event_txtSearchKeyReleased

    private void jScrollPane1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jScrollPane1MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_jScrollPane1MouseClicked
 

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
        } catch (ReflectiveOperationException | javax.swing.UnsupportedLookAndFeelException ex) {
            logger.log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(() -> new SchoolStudentManagementSystem().setVisible(true));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnClear;
    private javax.swing.JButton btnDelete;
    private javax.swing.JButton btnUpdate;
    private javax.swing.JComboBox<String> cmbClass;
    private javax.swing.JComboBox<String> cmbGender;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblAddress;
    private javax.swing.JLabel lblAdmissionNo;
    private javax.swing.JLabel lblClass;
    private javax.swing.JLabel lblDob;
    private javax.swing.JLabel lblFullName;
    private javax.swing.JLabel lblGender;
    private javax.swing.JLabel lblGuardianName;
    private javax.swing.JLabel lblGuardianPhone;
    private javax.swing.JLabel lblSearch;
    private javax.swing.JPanel pnlButtons;
    private javax.swing.JPanel pnlForm;
    private javax.swing.JPanel pnllSearch;
    private javax.swing.JSpinner spnDob;
    private javax.swing.JTable tblStudents;
    private javax.swing.JTextField txtAddress;
    private javax.swing.JTextField txtAdmissionNo;
    private javax.swing.JTextField txtFullName;
    private javax.swing.JTextField txtGuardianName;
    private javax.swing.JTextField txtGuardianPhone;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}
