/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class Alunos extends javax.swing.JFrame {

    int global;

    DefaultTableModel model;
    int x = 0;

    Conexao con;
    Statement st;
    
    public Alunos() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void consulta() {
        int x = 0;
        model.setNumRows(0);
        String consulta = "select * from alunos";

        int v1 = 0, v2 = 0, v3 = 0, v4 = 0;
       
        if (!campoNome.getText().equals("")) {
            v1 = 1;
        }
        if (!campoMatricula.getText().equals("")) {
            v2 = 1;
        }   
        if (!campoEndereco.getText().equals("")) {
            v3 = 1;
        }
        if (!campoCidade.getText().equals("")) {
            v4 = 1;
        }
        if (v1 == 1 || v2 == 1 || v3 == 1 || v4 == 1) {
            consulta = consulta + " where ";
        }
        if (v1 == 1) {
            x++;
            consulta = consulta + "nome like '%" + campoNome.getText() + "%'";
        }
        if (v2 == 1) {
            if (x != 0) {
                consulta = consulta + " and ";
            }
            consulta = consulta + "mat like '%" + campoMatricula.getText() + "%'";
            x++;
        }
        if (v3 == 1) {
            if (x != 0) {
                consulta = consulta + " and ";
            }
            consulta = consulta + "endereco like '%" + campoEndereco.getText() + "%'";
            x++;
        }
        if (v4 == 1) {
            if (x != 0) {
                consulta = consulta + " and ";
            }
            consulta = consulta + "cidade like '%" + campoCidade.getText() + "%'";
            x++;
        }
        try {
            st.executeQuery(consulta);
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                String nome = rs.getString("nome");
                String mat = rs.getString("mat");
                String endereco = rs.getString("endereco");
                String cidade = rs.getString("cidade");
                model.addRow(new Object[]{nome, mat, endereco, cidade});

            }

        } catch (SQLException ex) {
            System.err.println("Deu pau no MYSQL!");
        }

        limpacampos();
    }
    
    public void mudabotoes(boolean btcadastrar, boolean bteditar, boolean btsalvar, boolean btexcluir, boolean btconsultar, boolean editis) {
        btCadastrar.setEnabled(btcadastrar);
        btEditar.setEnabled(bteditar);
        btSalvar.setEnabled(btsalvar);
        btExcluir.setEnabled(btexcluir);
        btConsultar.setEnabled(btconsultar);
        campoNome.setEnabled(true);
        campoMatricula.setEnabled(editis);
        campoCidade.setEnabled(true);
        campoEndereco.setEnabled(true);
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton1 = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        btBack = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoNome = new javax.swing.JTextField();
        campoMatricula = new javax.swing.JTextField();
        campoEndereco = new javax.swing.JTextField();
        campoCidade = new javax.swing.JTextField();
        btCadastrar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();

        jButton1.setText("jButton1");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Nome:");

        btBack.setText("<<");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        jLabel2.setText("Matricula:");

        jLabel3.setText("Endereço:");

        jLabel4.setText("Cidade:");

        btCadastrar.setText("Cadastrar");
        btCadastrar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btCadastrarMouseClicked(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        btCancelar.setText("Cancelar");
        btCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCancelarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        btConsultar.setText("Consultar");
        btConsultar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btConsultarMouseClicked(evt);
            }
        });

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
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btBack)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel3)
                            .addComponent(jLabel2)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoNome)
                            .addComponent(campoMatricula)
                            .addComponent(campoEndereco)
                            .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 289, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 452, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCancelar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btExcluir)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btConsultar)))))
                .addContainerGap(27, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(btBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoMatricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(6, 6, 6)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4)
                    .addComponent(campoCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btEditar)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar)
                    .addComponent(btExcluir)
                    .addComponent(btConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(30, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        campoNome.setEnabled(true);

        int p = jTable1.getSelectedRow();
        campoNome.setText((String) jTable1.getValueAt(p, 0));
        campoMatricula.setText((String) jTable1.getValueAt(p, 1));
        campoEndereco.setText((String) jTable1.getValueAt(p, 2));
        campoCidade.setText((String) jTable1.getValueAt(p, 3));
    }//GEN-LAST:event_jTable1MouseClicked

    private void btConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConsultarMouseClicked
        consulta();
    }//GEN-LAST:event_btConsultarMouseClicked

    private void btCadastrarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btCadastrarMouseClicked
        mudabotoes(false, false, true, false, false, true);
        global = 1;
        limpacampos();
        campoNome.requestFocus();
    }//GEN-LAST:event_btCadastrarMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int conf = 0;
        try {
            st.executeQuery("select * from historico where mat = " + Integer.parseInt(campoMatricula.getText()));
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                conf = 1;
            }
        } catch (SQLException ex) {
            System.err.println("Deu pau no MYSQL!");
        }

        if (conf == 0) {
            int opcao=JOptionPane.showConfirmDialog(null, "Deseja realmente apagar " + campoNome.getText() + " ?");
            if (opcao == 0) { //if 1
                try {
                    st.executeUpdate("delete from alunos where mat = " + campoMatricula.getText());
                    mudabotoes(true, true, false, true, true, false);
                    limpacampos();
                    consulta();
                } catch (SQLException ex) {
                    System.out.println("deu erro no DELETS ");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Este aluno contem dados no histórico, logo nao pode ser apagado.");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        mudabotoes(false, false, true, false, false, false);
        global = 2;
        jTable1.setEnabled(false);
    }//GEN-LAST:event_btEditarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (global == 1) {
            if (campoNome.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um nome, nao pode ser nulo");
            } else if (campoCidade.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite uma cidade, nao pode ser nula");
            } else if (campoEndereco.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um endereco.");
            } else if (campoMatricula.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite uma matricula");
            } else {
                try {
                    st.executeUpdate("insert into alunos (mat,nome,endereco,cidade) values (" + Integer.parseInt(campoMatricula.getText()) + ",'" + campoNome.getText() + "','" + campoEndereco.getText() + "','" + campoCidade.getText() + "');");
                    mudabotoes(true, true, false, true, true, false);
                    jTable1.setEnabled(true);
                } catch (SQLException ex) {
                    System.out.println("deu erro no inserte ");
                }
            }

        } else {
            if (campoNome.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um nome, nao pode ser nulo");
            } else if (campoMatricula.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite uma matricula");
            } else if (campoEndereco.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um endereco.");
            } else if (campoCidade.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite uma cidade, nao pode ser nula");
            } else {
                try {
                    st.executeUpdate("update alunos set nome = '" + campoNome.getText() + "' , cidade = '" + campoCidade.getText() + "', endereco = '" + campoEndereco.getText() + "' where mat like " + campoMatricula.getText() + ";");
                    mudabotoes(true, true, false, true, true, false);
                    jTable1.setEnabled(true);
                } catch (SQLException ex) {
                    System.out.println("deu erro no Update ");
                }
            }

        }
        limpacampos();
        consulta();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        mudabotoes(true, true, false, true, true, false);
        limpacampos();
        jTable1.setEnabled(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        Principal p = new Principal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btBackActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Conexao con;
        try {
            con = new Conexao();
            st = con.conexao.createStatement();
        } catch (SQLException ex) {
            System.out.println("Deu erro no mysql.");
        }

        model = (DefaultTableModel) jTable1.getModel();
        model.setNumRows(0);

        mudabotoes(true, true, false, true, true, false);
        consulta();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(Alunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Alunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Alunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Alunos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Alunos().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btBack;
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JTextField campoCidade;
    private javax.swing.JTextField campoEndereco;
    private javax.swing.JTextField campoMatricula;
    private javax.swing.JTextField campoNome;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
    private void limpacampos() {
        campoCidade.setText("");
        campoEndereco.setText("");
        campoMatricula.setText("");
        campoNome.setText("");
    }
}
