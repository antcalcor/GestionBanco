/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

/**
 *
 * @author carde
 */
public class VistaCuenta extends javax.swing.JFrame {

    /**
     * Creates new form VistaCuenta
     */
    public VistaCuenta() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jFormattedTextField6 = new javax.swing.JFormattedTextField();
        jLabel8 = new javax.swing.JLabel();
        jFormattedTextField7 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextField8 = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jFormattedTextField9 = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jCheckBox1 = new javax.swing.JCheckBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(730, 490));
        getContentPane().setLayout(null);

        jFormattedTextField3.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(jFormattedTextField3);
        jFormattedTextField3.setBounds(70, 360, 140, 20);

        jLabel3.setText("Codigo Sucursal");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(70, 340, 100, 16);

        jFormattedTextField4.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(jFormattedTextField4);
        jFormattedTextField4.setBounds(70, 310, 140, 20);

        jLabel7.setText("Codigo Banco");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(70, 290, 110, 16);

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane1.setViewportView(jTable1);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(40, 50, 620, 210);

        jButton4.setText("Volver");
        getContentPane().add(jButton4);
        jButton4.setBounds(580, 400, 66, 32);

        jButton3.setText("Eliminar");
        getContentPane().add(jButton3);
        jButton3.setBounds(490, 400, 76, 32);

        jButton2.setText("Modificar");
        getContentPane().add(jButton2);
        jButton2.setBounds(390, 400, 83, 32);

        jButton1.setText("Añadir");
        getContentPane().add(jButton1);
        jButton1.setBounds(310, 400, 67, 32);

        jFormattedTextField6.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(jFormattedTextField6);
        jFormattedTextField6.setBounds(260, 310, 140, 20);

        jLabel8.setText("Codigo Cliente");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(260, 290, 110, 16);

        jFormattedTextField7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(jFormattedTextField7);
        jFormattedTextField7.setBounds(450, 360, 140, 20);

        jLabel5.setText("Saldo Medio");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(450, 340, 80, 16);

        jFormattedTextField8.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(jFormattedTextField8);
        jFormattedTextField8.setBounds(450, 310, 140, 20);

        jLabel9.setText("Saldo Actual");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(450, 290, 110, 16);

        jFormattedTextField9.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(jFormattedTextField9);
        jFormattedTextField9.setBounds(70, 410, 140, 20);

        jLabel6.setText("Codigo Cuenta");
        getContentPane().add(jLabel6);
        jLabel6.setBounds(70, 390, 90, 16);

        jLabel1.setText("CUENTAS");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(300, 20, 60, 16);

        jCheckBox1.setText("Cuenta Ahorro");
        getContentPane().add(jCheckBox1);
        jCheckBox1.setBounds(260, 350, 120, 24);

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
            java.util.logging.Logger.getLogger(VistaCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaCuenta.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaCuenta().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JCheckBox jCheckBox1;
    public javax.swing.JFormattedTextField jFormattedTextField3;
    public javax.swing.JFormattedTextField jFormattedTextField4;
    public javax.swing.JFormattedTextField jFormattedTextField6;
    public javax.swing.JFormattedTextField jFormattedTextField7;
    public javax.swing.JFormattedTextField jFormattedTextField8;
    public javax.swing.JFormattedTextField jFormattedTextField9;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel6;
    public javax.swing.JLabel jLabel7;
    public javax.swing.JLabel jLabel8;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
