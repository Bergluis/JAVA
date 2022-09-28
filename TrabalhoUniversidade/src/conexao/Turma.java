/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conexao;

import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Luis
 */
public class Turma extends javax.swing.JFrame {
    
    int global;

    DefaultTableModel model,modelProf,modelDisc;
    int x = 0,cont = 0;

    Conexao con;
    Statement st;
    
    public Turma() {
        initComponents();
        this.setLocationRelativeTo(null);
    }

    public void consulta() {
        int x = 0;
        model.setNumRows(0);
        modelDisc.setNumRows(0);
        modelProf.setNumRows(0);
        String consulta = "select * from turma";

        int v1 = 0, v2 = 0, v3 = 0, v4 = 0;
         
        if (!campoAno.getText().equals("")) {
            v1 = 1;
        }
        if (!campoHorario.getText().equals("")) {
            v2 = 1;
        }
        if (!campoCodDisc.getText().equals("")){
            v3 = 1;
        }
        if (!campoCodProf.getText().equals("")){
            v4 = 1;
        }
        if (v1 == 1 || v2 == 1 || v3 == 1 || v4 == 1) {
            consulta = consulta + " where ";
        }
        if (v1 == 1) {
            consulta = consulta + "ANO like '%" + Integer.parseInt(campoAno.getText()) + "%'";
            x++;
        }
        if (v2 == 1) {
            if (x != 0) {
                consulta = consulta + " and ";
            }
            consulta = consulta + "horario like '%" + campoHorario.getText() + "%'";
            x++;
        }
        if (v3 == 1) {
            if (x != 0) {
                consulta = consulta + " and ";
            }
            consulta = consulta + "COD_DISC like '%" + campoCodDisc.getText() + "%'";
            x++;
        }
        if (v4 == 1) {
            if (x != 0) {
                consulta = consulta + " and ";
            }
            consulta = consulta + "COD_PROF like '%" + campoCodProf.getText() + "%'";
            x++;
        }
        try {
            st.executeQuery(consulta);
            ResultSet rs = st.getResultSet();
            SimpleDateFormat anoDaBagaca = new SimpleDateFormat("yyyy");
            while (rs.next()) {
                String cod = rs.getString("COD_TURMA");
                String codDisc = rs.getString("COD_DISC");
                String codProf = rs.getString("COD_PROF");
                Date ano = rs.getDate("ANO");
                String horario = rs.getString("horario");
                String anoPronto = anoDaBagaca.format(ano);
                model.addRow(new Object[]{cod, codDisc, codProf, anoPronto, horario});

            }

        } catch (SQLException ex) {
            System.err.println("Deu pau no MYSQL!");
        }
        
        try {
            st.executeQuery("select * from professores;");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                String nome = rs.getString("nome");
                modelProf.addRow(new Object[]{nome});

            }
        } catch (SQLException ex) {
            Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            st.executeQuery("select * from disciplinas;");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                String nome = rs.getString("nome_disc");
                modelDisc.addRow(new Object[]{nome});

            }
        } catch (SQLException ex) {
            Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
        }

        limpacampos();
    }
    
    public void mudabotoes(boolean btcadastrar, boolean btsalvar, boolean btexcluir, boolean btcancelar, boolean btconsultar, boolean bteditar) {
        btCadastrar.setEnabled(btcadastrar);
        btSalvar.setEnabled(btsalvar);
        btExcluir.setEnabled(btexcluir);
        btConsultar.setEnabled(btconsultar);
        btCancelar.setEnabled(btcancelar);
        btEditar.setEnabled(bteditar);
        campoCodDisc.setEnabled(false);
        campoCodProf.setEnabled(false);
        campoAno.setEnabled(true);
        campoHorario.setEnabled(true);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        campoCodDisc = new javax.swing.JTextField();
        campoCodProf = new javax.swing.JTextField();
        campoAno = new javax.swing.JTextField();
        campoHorario = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDisciplina = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProfessores = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        tabelaTurma = new javax.swing.JTable();
        btCadastrar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        cbBack = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setText("Codigo da Disciplina:");

        jLabel2.setText("Codigo do Professor:");

        jLabel3.setText("Ano:");

        jLabel4.setText("Horario:");

        tabelaDisciplina.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nome da Disciplina"
            }
        ));
        tabelaDisciplina.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaDisciplinaMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaDisciplina);

        tabelaProfessores.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nome do Professor"
            }
        ));
        tabelaProfessores.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaProfessoresMouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaProfessores);

        tabelaTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Codigo da Turma", "Disciplina", "Professor", "Ano", "Horário"
            }
        ));
        tabelaTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTurmaMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(tabelaTurma);

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
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

        cbBack.setText("<<");
        cbBack.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                cbBackMouseClicked(evt);
            }
        });

        btEditar.setText("Editar");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(132, Short.MAX_VALUE)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(129, 129, 129))
            .addGroup(layout.createSequentialGroup()
                .addComponent(cbBack)
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btCadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(btEditar)
                        .addGap(18, 18, 18)
                        .addComponent(btSalvar)
                        .addGap(18, 18, 18)
                        .addComponent(btCancelar)
                        .addGap(18, 18, 18)
                        .addComponent(btExcluir)
                        .addGap(18, 18, 18)
                        .addComponent(btConsultar))
                    .addComponent(jLabel4)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(campoCodDisc)
                            .addComponent(campoCodProf)
                            .addComponent(campoAno)
                            .addComponent(campoHorario, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(campoCodDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(cbBack))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(campoCodProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btExcluir)
                    .addComponent(btConsultar)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar)
                    .addComponent(btEditar)
                    .addComponent(btCadastrar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        Conexao con;
        try {
            con = new Conexao();
            st = con.conexao.createStatement();
        } catch (SQLException ex) {
            System.out.println("Deu erro no mysql.");
        }
 
        model = (DefaultTableModel) tabelaTurma.getModel();
        model.setNumRows(0);
        modelDisc = (DefaultTableModel) tabelaDisciplina.getModel();
        modelDisc.setNumRows(0);
        modelProf = (DefaultTableModel) tabelaProfessores.getModel();
        modelProf.setNumRows(0);

        mudabotoes(true, false, true, true, true, true);
        consulta();
    }//GEN-LAST:event_formWindowOpened

    private void btConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConsultarMouseClicked
        consulta();
    }//GEN-LAST:event_btConsultarMouseClicked

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        mudabotoes(false, true, false, true, true, false);
        global = 1;
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if(global == 1){
            String codigoTurma="";
            try {
                st.executeQuery("select * from turma;");
                ResultSet rs = st.getResultSet();
                while (rs.next()) {
                    codigoTurma = rs.getString("COD_TURMA");
                }
            } catch (SQLException ex) {
                Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
            }

            if (campoCodDisc.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione uma disciplina, nao pode ser nula");
            } else if (campoCodProf.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione um professor, nao pode ser nulo");
            } else if (campoAno.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um ano.");
            } else if (campoHorario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um horario");
            } else {
                try {
                    int queGambiarra = Integer.parseInt(codigoTurma) + 1;
                    st.executeUpdate("insert into turma (COD_TURMA,COD_DISC,COD_PROF,ANO,horario) values (" + queGambiarra + ",'" + campoCodDisc.getText() + "','" + Integer.parseInt(campoCodProf.getText()) + "','" + Integer.parseInt(campoAno.getText()) + "','" + campoHorario.getText() +"');");
                } catch (SQLException ex) {
                    System.err.println("Deu pau no MYSQL!");
                }
                mudabotoes(true, false, true, true, true, true);
                tabelaTurma.setEnabled(true);           
            }
        } else {
            if (campoAno.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um ano.");
            } else if (campoHorario.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um horario");
            } else {
                try {
                    int p = tabelaTurma.getSelectedRow();
                    st.executeUpdate("update turma set ANO = '" + Integer.parseInt(campoAno.getText()) + "', horario = '" + campoHorario.getText() + "' where COD_TURMA like " + tabelaTurma.getValueAt(p, 0) + " ;");
                } catch (SQLException ex) {
                    System.err.println("Deu pau no MYSQL!");
                }
                mudabotoes(true, false, true, true, true, true);
                tabelaTurma.setEnabled(true);
                tabelaDisciplina.setEnabled(true);
                tabelaProfessores.setEnabled(true);
            }
        }        
        
        limpacampos();
        consulta();
    }//GEN-LAST:event_btSalvarActionPerformed

    private void tabelaDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDisciplinaMouseClicked
        try{
           int p = tabelaDisciplina.getSelectedRow();
            try {
                st.executeQuery("select * from disciplinas where nome_disc like '" + tabelaDisciplina.getValueAt(p, 0) + "';");
                ResultSet rs = st.getResultSet();
                while(rs.next()){
                    campoCodDisc.setText(rs.getString("COD_DISC"));
                }          
            } catch (SQLException ex) {
                System.err.println("Pau no MYSQL!");
            }    
        } catch (ArrayIndexOutOfBoundsException ex){
            
        }        
    }//GEN-LAST:event_tabelaDisciplinaMouseClicked

    private void tabelaProfessoresMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaProfessoresMouseClicked
        try{
            int p = tabelaProfessores.getSelectedRow();
            try {
                st.executeQuery("select * from professores where nome like '" + tabelaProfessores.getValueAt(p, 0) + "';");
                ResultSet rs = st.getResultSet();
                while(rs.next()){
                    campoCodProf.setText(rs.getString("COD_PROF"));
                }     
            } catch (SQLException ex) {
                System.err.println("Pau no MYSQL!");
            }
        } catch (ArrayIndexOutOfBoundsException ex){
            
        }
    }//GEN-LAST:event_tabelaProfessoresMouseClicked

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int p = tabelaTurma.getSelectedRow();
        int conf = 0;
        try {
            st.executeQuery("select * from historico where COD_TURMA = " + tabelaTurma.getValueAt(p, 0));
            ResultSet rs = st.getResultSet();

            while (rs.next()) {
                conf = 1;
            }
        } catch (SQLException ex) {
            System.err.println("Deu pau no MYSQL!");
        }
        if (conf == 0) {
            int opcao=JOptionPane.showConfirmDialog(null, "Deseja realmente apagar a turma" + tabelaTurma.getValueAt(p, 0) + " ?");
                if (opcao == 0) { //if 1
                    try {
                        st.executeUpdate("delete from turma where COD_TURMA = '" + tabelaTurma.getValueAt(p, 0) + "';");
                        limpacampos();
                        consulta();
                    } catch (SQLException ex) {
                        System.out.println("deu erro no DELETS ");
                    }
                }
        } else {
            JOptionPane.showMessageDialog(null, "Esta turma contem dados no histórico, logo nao pode ser apagado.");
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        mudabotoes(true, false, true, true, true, true);
        limpacampos();
        tabelaDisciplina.setEnabled(true);
        tabelaProfessores.setEnabled(true);
        tabelaTurma.setEnabled(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void cbBackMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_cbBackMouseClicked
        Principal p = new Principal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_cbBackMouseClicked

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        mudabotoes(false, true, false, true, false, false);
        global = 2;
        tabelaDisciplina.setEnabled(false);
        tabelaProfessores.setEnabled(false);
        tabelaTurma.setEnabled(false);
    }//GEN-LAST:event_btEditarActionPerformed

    private void tabelaTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTurmaMouseClicked
        int p = tabelaTurma.getSelectedRow();
        try {
            st.executeQuery("select * from turma where COD_TURMA like '" + tabelaTurma.getValueAt(p, 0) + "';");
            ResultSet rs = st.getResultSet();
            while(rs.next()){
                campoAno.setText((String) tabelaTurma.getValueAt(p, 3));
                campoHorario.setText(rs.getString("horario"));
                campoCodDisc.setText(rs.getString("COD_DISC"));
                campoCodProf.setText(rs.getString("COD_PROF"));
            }     
        } catch (SQLException ex) {
            System.err.println("Pau no MYSQL!");
        }
    }//GEN-LAST:event_tabelaTurmaMouseClicked

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
            java.util.logging.Logger.getLogger(Turma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Turma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Turma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Turma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Turma().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btCadastrar;
    private javax.swing.JButton btCancelar;
    private javax.swing.JButton btConsultar;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btSalvar;
    private javax.swing.JTextField campoAno;
    private javax.swing.JTextField campoCodDisc;
    private javax.swing.JTextField campoCodProf;
    private javax.swing.JTextField campoHorario;
    private javax.swing.JButton cbBack;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTable tabelaDisciplina;
    private javax.swing.JTable tabelaProfessores;
    private javax.swing.JTable tabelaTurma;
    // End of variables declaration//GEN-END:variables
    private void limpacampos() {
        campoCodDisc.setText("");
        campoCodProf.setText("");
        campoAno.setText("");
        campoHorario.setText("");
    }
}
