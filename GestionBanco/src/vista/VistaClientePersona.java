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
public class VistaClientePersona extends javax.swing.JFrame {

    /**
     * Creates new form VistaCliente
     */
    public VistaClientePersona() {
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

        jDialog1 = new javax.swing.JDialog();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        jButton9 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable3 = new javax.swing.JTable();
        jLabel10 = new javax.swing.JLabel();
        jFormattedTextField8 = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jFormattedTextField9 = new javax.swing.JFormattedTextField();
        jLabel12 = new javax.swing.JLabel();
        jFormattedTextField10 = new javax.swing.JFormattedTextField();
        jLabel13 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextField5 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextField7 = new javax.swing.JFormattedTextField();
        jLabel9 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jFormattedTextField12 = new javax.swing.JFormattedTextField();
        jFormattedTextField13 = new javax.swing.JFormattedTextField();

        jDialog1.setMinimumSize(new java.awt.Dimension(380, 380));
        jDialog1.getContentPane().setLayout(null);

        jButton6.setText("Añadir");
        jDialog1.getContentPane().add(jButton6);
        jButton6.setBounds(10, 280, 80, 32);

        jButton7.setText("Modificar");
        jDialog1.getContentPane().add(jButton7);
        jButton7.setBounds(100, 280, 90, 32);

        jButton8.setText("Eliminar");
        jDialog1.getContentPane().add(jButton8);
        jButton8.setBounds(200, 280, 80, 32);

        jButton9.setText("Volver");
        jDialog1.getContentPane().add(jButton9);
        jButton9.setBounds(290, 280, 70, 32);

        jTable3.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable3);

        jDialog1.getContentPane().add(jScrollPane4);
        jScrollPane4.setBounds(40, 50, 280, 110);

        jLabel10.setText("Direcciones");
        jDialog1.getContentPane().add(jLabel10);
        jLabel10.setBounds(140, 20, 70, 16);
        jDialog1.getContentPane().add(jFormattedTextField8);
        jFormattedTextField8.setBounds(180, 240, 150, 20);

        jLabel11.setText("Ciudad");
        jDialog1.getContentPane().add(jLabel11);
        jLabel11.setBounds(180, 220, 120, 16);

        jFormattedTextField9.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        jDialog1.getContentPane().add(jFormattedTextField9);
        jFormattedTextField9.setBounds(30, 240, 130, 20);

        jLabel12.setText("Codigo Postal");
        jDialog1.getContentPane().add(jLabel12);
        jLabel12.setBounds(30, 220, 90, 16);
        jDialog1.getContentPane().add(jFormattedTextField10);
        jFormattedTextField10.setBounds(30, 190, 290, 20);

        jLabel13.setText("Calle");
        jDialog1.getContentPane().add(jLabel13);
        jLabel13.setBounds(30, 170, 40, 16);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(740, 510));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

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

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 40, 610, 210));

        jFormattedTextField1.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(jFormattedTextField1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 330, 150, -1));

        jLabel1.setText("Codigo Cliente");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 310, 90, -1));
        getContentPane().add(jFormattedTextField2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 270, 380, -1));

        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 50, -1));
        getContentPane().add(jFormattedTextField3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 380, 150, -1));

        jLabel3.setText("Sexo");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 360, -1, -1));

        jFormattedTextField5.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(jFormattedTextField5, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 310, 100, -1));

        jLabel5.setText("Telefono");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 270, 60, -1));

        jFormattedTextField7.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.DateFormatter(new java.text.SimpleDateFormat("yyyy-MM-dd"))));
        getContentPane().add(jFormattedTextField7, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 330, 160, -1));

        jLabel9.setText("Fecha Nacimiento");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 110, -1));

        jButton1.setText("Añadir");
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 420, -1, -1));

        jButton2.setText("Modificar");
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(454, 420, -1, -1));

        jButton3.setText("Eliminar");
        getContentPane().add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 420, -1, -1));

        jButton4.setText("Volver");
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 420, -1, -1));

        jButton5.setText("DIRECCIONES");
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 370, 110, -1));

        jLabel14.setText("PERSONA FISICA");
        getContentPane().add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(60, 10, 100, -1));

        jFormattedTextField12.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(jFormattedTextField12, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 270, 100, -1));

        jFormattedTextField13.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.NumberFormatter(new java.text.DecimalFormat("#0"))));
        getContentPane().add(jFormattedTextField13, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 290, 100, -1));

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
            java.util.logging.Logger.getLogger(VistaClientePersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaClientePersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaClientePersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaClientePersona.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaClientePersona().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JButton jButton5;
    public javax.swing.JButton jButton6;
    public javax.swing.JButton jButton7;
    public javax.swing.JButton jButton8;
    public javax.swing.JButton jButton9;
    public javax.swing.JDialog jDialog1;
    public javax.swing.JFormattedTextField jFormattedTextField1;
    public javax.swing.JFormattedTextField jFormattedTextField10;
    public javax.swing.JFormattedTextField jFormattedTextField12;
    public javax.swing.JFormattedTextField jFormattedTextField13;
    public javax.swing.JFormattedTextField jFormattedTextField2;
    public javax.swing.JFormattedTextField jFormattedTextField3;
    public javax.swing.JFormattedTextField jFormattedTextField5;
    public javax.swing.JFormattedTextField jFormattedTextField7;
    public javax.swing.JFormattedTextField jFormattedTextField8;
    public javax.swing.JFormattedTextField jFormattedTextField9;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel10;
    public javax.swing.JLabel jLabel11;
    public javax.swing.JLabel jLabel12;
    public javax.swing.JLabel jLabel13;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JLabel jLabel9;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JScrollPane jScrollPane4;
    public javax.swing.JTable jTable1;
    public javax.swing.JTable jTable3;
    // End of variables declaration//GEN-END:variables
}
