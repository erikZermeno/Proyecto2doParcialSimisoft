/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ViewLayer;

import BussinesModelLayer.Clientes;
import BussinesModelLayer.Contactos;
import BussinesModelLayer.Estados;
import BussinesModelLayer.Localidades;
import BussinesModelLayer.Municipios;
import java.text.ParseException;
import java.util.LinkedList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;


/**
 *
 * @author zerme
 */
public class frmNMCliente extends javax.swing.JDialog {

    private int idCliente = 0;
    private Clientes cliente = new Clientes();
    private Contactos contacto = new Contactos();
    private Localidades localidad = new Localidades();
    private Municipios municipio = new Municipios();
    private Estados estado = new Estados();
    private LinkedList<Integer> idContacto = new LinkedList<>();
    /**
     * Creates new form frmNMProducto
     */
    
    public frmNMCliente(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        setLocationRelativeTo(null);
        
    }
    
    public frmNMCliente() {
        initComponents();
        llenarComboBoxContactos();
        setLocationRelativeTo(null);
        contacto.setIdContacto(idContacto.getFirst());
        contacto.GetById();
        comboCalle.setSelectedItem(contacto.getCalle());
        localidad.setIdLocalidad(contacto.getIdLocalidad());
        localidad.GetById();
        txtLocalidad.setText(String.valueOf(localidad.getLocalidad()));
        municipio.setIdMunicipio(contacto.getIdMunicipio());
        municipio.GetById();
        txtMunicipio.setText(String.valueOf(municipio.getMunicipio()));
        estado.setIdEstado(contacto.getIdEstado());
        estado.GetById();
        txtEstado.setText(estado.getEstado());
    }
    
    //Constructor para modificar
    public frmNMCliente(int idCliente) throws ParseException {
        initComponents();
        setLocationRelativeTo(null);
        
        this.idCliente = idCliente;//Guardar el id mandado
        
        cliente.setIdCliente(idCliente);
        cliente.GetById();//Consulta por id
        
        //Llenado de los campos con la consulta hecha
        txtNombre.setText(cliente.getNombre());
        

        //Llenado del combo box y seleccion
        llenarComboBoxContactos();
        contacto.setIdContacto(cliente.getIdContacto());
        contacto.GetById();
        comboCalle.setSelectedItem(contacto.getCalle());
        localidad.setIdLocalidad(contacto.getIdLocalidad());
        localidad.GetById();
        txtLocalidad.setText(String.valueOf(localidad.getLocalidad()));
        municipio.setIdMunicipio(contacto.getIdMunicipio());
        municipio.GetById();
        txtMunicipio.setText(String.valueOf(municipio.getMunicipio()));
        estado.setIdEstado(contacto.getIdEstado());
        estado.GetById();
        txtEstado.setText(estado.getEstado());
        

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        comboCalle = new javax.swing.JComboBox<>();
        btnCancelar = new javax.swing.JButton();
        btnGuardar = new javax.swing.JButton();
        btnAgregarDireccion = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtMunicipio = new javax.swing.JTextField();
        txtLocalidad = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtEstado = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Nombre:");

        jLabel2.setText("Estado:");

        jLabel4.setText("Calle:");

        comboCalle.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboCalleActionPerformed(evt);
            }
        });

        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnAgregarDireccion.setText("+");
        btnAgregarDireccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarDireccionActionPerformed(evt);
            }
        });

        jLabel6.setText("<html><body>  Nueva<br>Direccion</body></html>");

        jLabel7.setText("Localidad:");

        jLabel9.setText("Municipio:");

        txtMunicipio.setEditable(false);

        txtLocalidad.setEditable(false);

        jLabel3.setText("Dirección");

        txtEstado.setEditable(false);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(83, 83, 83)
                        .addComponent(btnCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnGuardar)
                        .addGap(71, 71, 71))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(29, 40, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel4))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(comboCalle, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnAgregarDireccion)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNombre)))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addGap(18, 18, 18)
                                .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel9)
                                .addGap(18, 18, 18)
                                .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addGap(35, 35, 35))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(181, 181, 181))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(comboCalle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(btnAgregarDireccion)
                        .addComponent(jLabel4)))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtLocalidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtMunicipio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(33, 33, 33)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnCancelar)
                    .addComponent(btnGuardar))
                .addGap(15, 15, 15))
        );

        jLabel6.getAccessibleContext().setAccessibleName("<html><body>Nueva<br>Direccion</body></html>");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed

        if (txtNombre.getText().isEmpty()) {
            JOptionPane.showMessageDialog(rootPane, "Ingresa todos los campos");
        } else {

            if (idCliente == 0) {
                if (new Clientes(0, txtNombre.getText(), 
                        idContacto.get(comboCalle.getSelectedIndex())).Add()) {
                    JOptionPane.showMessageDialog(rootPane, "Cliente agregado correctamente!");
                    this.dispose();
                }
            } else {
                cliente.setNombre(txtNombre.getText());
                cliente.setIdContacto(idContacto.get(comboCalle.getSelectedIndex()));
                
                if (cliente.Update()) {
                    JOptionPane.showMessageDialog(rootPane, "Cliente actualizado correctamente!");
                    this.dispose();
                }

            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnAgregarDireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarDireccionActionPerformed
        frmNMContacto obj = new frmNMContacto();
        obj.setTitle("Nueva Direccion");
        obj.setModal(true);
        obj.setVisible(true);
        idContacto.clear();
        comboCalle.removeAllItems();
        llenarComboBoxContactos();
    }//GEN-LAST:event_btnAgregarDireccionActionPerformed

    private void comboCalleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboCalleActionPerformed
        if (!idContacto.isEmpty()) {
            contacto.setIdContacto(idContacto.get(comboCalle.getSelectedIndex()));
            contacto.GetById();
            localidad.setIdLocalidad(contacto.getIdLocalidad());
            localidad.GetById();
            txtLocalidad.setText(String.valueOf(localidad.getLocalidad()));
            municipio.setIdMunicipio(contacto.getIdMunicipio());
            municipio.GetById();
            txtMunicipio.setText(String.valueOf(municipio.getMunicipio()));
            estado.setIdEstado(contacto.getIdEstado());
            estado.GetById();
            txtEstado.setText(estado.getEstado());
        }
    }//GEN-LAST:event_comboCalleActionPerformed

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
            java.util.logging.Logger.getLogger(frmNMCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(frmNMCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(frmNMCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(frmNMCliente.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                frmNMCliente dialog = new frmNMCliente(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    public void llenarComboBoxContactos(){
        DefaultTableModel res = contacto.GetAllModel();
        for (int i = 0; i < res.getRowCount(); i++) {
            comboCalle.addItem(String.valueOf(res.getValueAt(i, 3)));
            idContacto.add(Integer.parseInt(String.valueOf(res.getValueAt(i, 0))));
        }
    }
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgregarDireccion;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JComboBox<String> comboCalle;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JTextField txtEstado;
    private javax.swing.JTextField txtLocalidad;
    private javax.swing.JTextField txtMunicipio;
    private javax.swing.JTextField txtNombre;
    // End of variables declaration//GEN-END:variables
}
