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
public class VistaEmpleado extends javax.swing.JFrame {

    /**
     * Creates new form VistaEmpleado
     */
    public VistaEmpleado() {
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

        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jLabel14 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jFormattedTextField2 = new javax.swing.JFormattedTextField();
        jLabel1 = new javax.swing.JLabel();
        jFormattedTextField1 = new javax.swing.JFormattedTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jFormattedTextField3 = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jFormattedTextField4 = new javax.swing.JFormattedTextField();
        jLabel5 = new javax.swing.JLabel();
        jFormattedTextField5 = new javax.swing.JFormattedTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(750, 480));
        getContentPane().setLayout(null);

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
        jScrollPane1.setBounds(60, 50, 610, 210);

        jLabel14.setText("EMPLEADOS");
        getContentPane().add(jLabel14);
        jLabel14.setBounds(320, 20, 80, 16);

        jLabel2.setText("Nombre");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(20, 260, 50, 16);
        getContentPane().add(jFormattedTextField2);
        jFormattedTextField2.setBounds(20, 280, 340, 20);

        jLabel1.setText("DNI");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(20, 310, 90, 16);
        getContentPane().add(jFormattedTextField1);
        jFormattedTextField1.setBounds(20, 330, 150, 20);

        jButton1.setText("Añadir");
        getContentPane().add(jButton1);
        jButton1.setBounds(360, 380, 67, 32);

        jButton2.setText("Modificar");
        getContentPane().add(jButton2);
        jButton2.setBounds(440, 380, 83, 32);

        jButton3.setText("Eliminar");
        getContentPane().add(jButton3);
        jButton3.setBounds(540, 380, 76, 32);

        jButton4.setText("Volver");
        getContentPane().add(jButton4);
        jButton4.setBounds(630, 380, 66, 32);

        jLabel3.setText("Fecha Nacimiento");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(20, 360, 110, 16);
        getContentPane().add(jFormattedTextField3);
        jFormattedTextField3.setBounds(20, 380, 150, 20);

        jLabel4.setText("Sexo");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(440, 260, 90, 16);
        getContentPane().add(jFormattedTextField4);
        jFormattedTextField4.setBounds(440, 280, 150, 20);

        jLabel5.setText("Sucursal");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(440, 320, 90, 16);
        getContentPane().add(jFormattedTextField5);
        jFormattedTextField5.setBounds(440, 340, 150, 20);

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
            java.util.logging.Logger.getLogger(VistaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(VistaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(VistaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(VistaEmpleado.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new VistaEmpleado().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JButton jButton1;
    public javax.swing.JButton jButton2;
    public javax.swing.JButton jButton3;
    public javax.swing.JButton jButton4;
    public javax.swing.JFormattedTextField jFormattedTextField1;
    public javax.swing.JFormattedTextField jFormattedTextField2;
    public javax.swing.JFormattedTextField jFormattedTextField3;
    public javax.swing.JFormattedTextField jFormattedTextField4;
    public javax.swing.JFormattedTextField jFormattedTextField5;
    public javax.swing.JLabel jLabel1;
    public javax.swing.JLabel jLabel14;
    public javax.swing.JLabel jLabel2;
    public javax.swing.JLabel jLabel3;
    public javax.swing.JLabel jLabel4;
    public javax.swing.JLabel jLabel5;
    public javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
