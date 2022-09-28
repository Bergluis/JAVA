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

public class Historico extends javax.swing.JFrame {

    int global;
    DefaultTableModel model,modelProf,modelDisc,modelAluno,modelTurma;
    
    int x = 0;

    Conexao con;
    Statement st;

    public Historico() {
        initComponents();
        this.setLocationRelativeTo(null);
    }
    
    public void consulta(){
        int x = 0;
        model.setNumRows(0);
        modelDisc.setNumRows(0);
        modelProf.setNumRows(0);
        String consulta = "select * from historico";

        int v1 = 0, v2 = 0, v3 = 0, v4 = 0, v5 = 0, v6 = 0, v7 = 0;
         
        if (!campoCodAluno.getText().equals("")) {
            v1 = 1;
        }
        if (!campoCodTurma.getText().equals("")) {
            v2 = 1;
        }
        if (!campoCodDisc.getText().equals("")){
            v3 = 1;
        }
        if (!campoCodProf.getText().equals("")){
            v4 = 1;
        }
        if (!campoAno.getText().equals("")){
            v5 = 1;
        }
        if (!campoFrequencia.getText().equals("")){
            v6 = 1;
        }
        if (!campoNota.getText().equals("")){
            v7 = 1;
        }
        
        if (v1 == 1 || v2 == 1 || v3 == 1 || v4 == 1 || v5 == 1 || v6 == 1 || v7 == 1) {
            consulta = consulta + " where ";
        }
        if (v1 == 1) {
            consulta = consulta + "MAT like '%" + Integer.parseInt(campoCodAluno.getText()) + "%'";
            x++;
        }
        if (v2 == 1) {
            if (x != 0) {
                consulta = consulta + " and ";
            }
            consulta = consulta + "COD_TURMA like '%" + Integer.parseInt(campoCodTurma.getText()) + "%'";
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
            consulta = consulta + "COD_PROF like '%" + Integer.parseInt(campoCodProf.getText()) + "%'";
            x++;
        }
        if (v5 == 1) {
            if (x != 0) {
                consulta = consulta + " and ";
            }
            consulta = consulta + "ANO like '%" + Integer.parseInt(campoAno.getText()) + "%'";
            x++;
        }
        if (v6 == 1) {
            if (x != 0) {
                consulta = consulta + " and ";
            }
            consulta = consulta + "frequencia like '%" + Float.parseFloat(campoFrequencia.getText()) + "%'";
            x++;
        }
        if (v7 == 1) {
            if (x != 0) {
                consulta = consulta + " and ";
            }
            consulta = consulta + "nota like '%" + Float.parseFloat(campoNota.getText()) + "%'";
            x++;
        }

        try {
            st.executeQuery(consulta);
            ResultSet rs = st.getResultSet();
            SimpleDateFormat anoDaBagaca = new SimpleDateFormat("yyyy");
            while (rs.next()) {
                String cod = rs.getString("COD_HISTORICO");
                String matricula = rs.getString("MAT");
                String disciplina = rs.getString("COD_DISC");
                String turma = rs.getString("COD_TURMA");
                String professor = rs.getString("COD_PROF");
                Date ano = rs.getDate("ANO");
                String frequencia = rs.getString("frequencia");
                String nota = rs.getString("nota");
                String anoPronto = anoDaBagaca.format(ano);
                model.addRow(new Object[]{cod, matricula, disciplina, turma, professor, anoPronto, frequencia, nota});

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
        
        try {
            st.executeQuery("select * from alunos;");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                String nome = rs.getString("nome");
                modelAluno.addRow(new Object[]{nome});

            }
        } catch (SQLException ex) {
            Logger.getLogger(Turma.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        try {
            st.executeQuery("select * from turma;");
            ResultSet rs = st.getResultSet();
            while (rs.next()) {
                String nome = rs.getString("COD_TURMA");
                String disc = rs.getString("COD_DISC");
                String prof = rs.getString("COD_PROF");
                modelTurma.addRow(new Object[]{nome, disc, prof});

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
        campoCodTurma.setEnabled(false);
        campoCodAluno.setEnabled(false);

    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaDisciplina = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaProfessores = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        campoCodAluno = new javax.swing.JTextField();
        campoCodDisc = new javax.swing.JTextField();
        campoCodProf = new javax.swing.JTextField();
        campoCodTurma = new javax.swing.JTextField();
        campoAno = new javax.swing.JTextField();
        campoFrequencia = new javax.swing.JTextField();
        campoNota = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        tabelaAluno = new javax.swing.JTable();
        jScrollPane6 = new javax.swing.JScrollPane();
        tabelaTurma = new javax.swing.JTable();
        jScrollPane7 = new javax.swing.JScrollPane();
        tabelaHistorico = new javax.swing.JTable();
        btCadastrar = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btSalvar = new javax.swing.JButton();
        btCancelar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();
        btConsultar = new javax.swing.JButton();
        btBack = new javax.swing.JButton();

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
        jScrollPane3.setViewportView(jTable1);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane4.setViewportView(jTable2);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

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

        jLabel1.setText("Aluno:");

        jLabel2.setText("Disciplina:");

        jLabel3.setText("Professor:");

        jLabel4.setText("Turma:");

        jLabel5.setText("Ano:");

        jLabel6.setText("Frequência:");

        jLabel7.setText("Nota:");

        jLabel8.setText("%");

        tabelaAluno.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null},
                {null},
                {null},
                {null}
            },
            new String [] {
                "Nome do Aluno"
            }
        ));
        tabelaAluno.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaAlunoMouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(tabelaAluno);

        tabelaTurma.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Codigo da Turma", "Disciplina", "Professor"
            }
        ));
        tabelaTurma.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaTurmaMouseClicked(evt);
            }
        });
        jScrollPane6.setViewportView(tabelaTurma);

        tabelaHistorico.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Codigo", "Matricula", "Disciplinas", "Turma", "Professor", "Ano", "Frequencia", "Nota"
            }
        ));
        tabelaHistorico.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaHistoricoMouseClicked(evt);
            }
        });
        jScrollPane7.setViewportView(tabelaHistorico);

        btCadastrar.setText("Cadastrar");
        btCadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btCadastrarActionPerformed(evt);
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

        btBack.setText("<<");
        btBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btBackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(47, 47, 47)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(21, 21, 21)
                        .addComponent(campoCodDisc))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(37, 37, 37)
                        .addComponent(campoCodAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoCodProf)
                            .addComponent(campoCodTurma)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btCadastrar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btEditar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btSalvar)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btCancelar)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(campoFrequencia, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 40, Short.MAX_VALUE)
                            .addComponent(campoAno, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(campoNota))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel8)
                        .addGap(90, 90, 90))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btExcluir)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btConsultar)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(jScrollPane5, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jScrollPane6))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(btBack)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(btBack)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel5)
                    .addComponent(campoCodAluno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoAno, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel6)
                    .addComponent(campoCodDisc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoFrequencia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(jLabel7)
                    .addComponent(campoCodProf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(campoNota, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(campoCodTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btCadastrar)
                    .addComponent(btEditar)
                    .addComponent(btSalvar)
                    .addComponent(btCancelar)
                    .addComponent(btExcluir)
                    .addComponent(btConsultar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane6, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 97, javax.swing.GroupLayout.PREFERRED_SIZE)
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
 
        model = (DefaultTableModel) tabelaHistorico.getModel();
        model.setNumRows(0);
        modelDisc = (DefaultTableModel) tabelaDisciplina.getModel();
        modelDisc.setNumRows(0);
        modelProf = (DefaultTableModel) tabelaProfessores.getModel();
        modelProf.setNumRows(0);
        modelAluno = (DefaultTableModel) tabelaAluno.getModel();
        modelAluno.setNumRows(0);
        modelTurma = (DefaultTableModel) tabelaTurma.getModel();
        modelTurma.setNumRows(0);

        mudabotoes(true, false, true, true, true, true);
        consulta();
        
    }//GEN-LAST:event_formWindowOpened

    private void tabelaDisciplinaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaDisciplinaMouseClicked
        try {
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

    private void tabelaHistoricoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaHistoricoMouseClicked
        int p = tabelaHistorico.getSelectedRow();
                campoCodAluno.setText((String) tabelaHistorico.getValueAt(p, 1));
                campoCodDisc.setText((String) tabelaHistorico.getValueAt(p, 2));
                campoCodTurma.setText((String) tabelaHistorico.getValueAt(p, 3));
                campoCodProf.setText((String) tabelaHistorico.getValueAt(p, 4));
                campoAno.setText((String) tabelaHistorico.getValueAt(p, 5));
                campoFrequencia.setText((String) tabelaHistorico.getValueAt(p, 6));
                campoNota.setText((String) tabelaHistorico.getValueAt(p, 7));
    }//GEN-LAST:event_tabelaHistoricoMouseClicked

    private void tabelaAlunoMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaAlunoMouseClicked
        try{
            int p = tabelaAluno.getSelectedRow();
            try {
                st.executeQuery("select * from alunos where nome like '" + tabelaAluno.getValueAt(p, 0) + "';");
                ResultSet rs = st.getResultSet();
                while(rs.next()){
                    campoCodAluno.setText(rs.getString("MAT"));
                }
            } catch (SQLException ex) {
                System.err.println("Pau no MYSQL!");
            }
        } catch (ArrayIndexOutOfBoundsException ex){ 
            
        }   
    }//GEN-LAST:event_tabelaAlunoMouseClicked

    private void tabelaTurmaMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaTurmaMouseClicked
        try{
            int p = tabelaTurma.getSelectedRow();
                campoCodTurma.setText((String) tabelaTurma.getValueAt(p, 0));
        } catch (ArrayIndexOutOfBoundsException ex){
            
        }    
    }//GEN-LAST:event_tabelaTurmaMouseClicked

    private void btConsultarMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btConsultarMouseClicked
        consulta();
    }//GEN-LAST:event_btConsultarMouseClicked

    private void btBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btBackActionPerformed
        Principal p = new Principal();
        p.setVisible(true);
        this.dispose();
    }//GEN-LAST:event_btBackActionPerformed

    private void btCadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCadastrarActionPerformed
        mudabotoes(false, true, false, true, true, false);
        global = 1;
    }//GEN-LAST:event_btCadastrarActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        mudabotoes(false, true, false, true, false, false);
        global = 2;
        tabelaDisciplina.setEnabled(false);
        tabelaProfessores.setEnabled(false);
        tabelaTurma.setEnabled(false);
        tabelaAluno.setEnabled(false);
        tabelaHistorico.setEnabled(false);
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        int p = tabelaHistorico.getSelectedRow();
            int opcao=JOptionPane.showConfirmDialog(null, "Deseja realmente apagar o historico" + tabelaHistorico.getValueAt(p, 0) + " ?");
                if (opcao == 0) { //if 1
                    try {
                        st.executeUpdate("delete from historico where COD_HISTORICO = '" + tabelaHistorico.getValueAt(p, 0) + "';");
                        limpacampos();
                        consulta();
                    } catch (SQLException ex) {
                        System.out.println("deu erro no DELETS ");
                    }
                }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void btCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btCancelarActionPerformed
        mudabotoes(true, false, true, true, true, true);
        limpacampos();
        tabelaDisciplina.setEnabled(true);
        tabelaProfessores.setEnabled(true);
        tabelaTurma.setEnabled(true);
        tabelaAluno.setEnabled(true);
        tabelaHistorico.setEnabled(true);
    }//GEN-LAST:event_btCancelarActionPerformed

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if(global == 1){
            if (campoCodDisc.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione uma disciplina, nao pode ser nula");
            } else if (campoCodProf.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione um professor, nao pode ser nulo");
            } else if (campoCodTurma.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione a turma.");
            } else if (campoCodAluno.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Selecione um aluno.");
            } else if (campoAno.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um ano.");
            } else if (campoFrequencia.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite uma frequencia.");
            } else if (campoNota.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite uma nota.");
            } else {
                try {
                    st.executeUpdate("insert into historico (MAT,COD_DISC,COD_TURMA,COD_PROF,ANO,frequencia,nota) values(" + Integer.parseInt(campoCodAluno.getText()) + ",'" + campoCodDisc.getText() + "'," + Integer.parseInt(campoCodTurma.getText()) + "," + Integer.parseInt(campoCodProf.getText()) + "," + Integer.parseInt(campoAno.getText()) + "," + Float.parseFloat(campoFrequencia.getText()) + "," + Float.parseFloat(campoNota.getText()) + ");");
                } catch (SQLException ex) {
                    System.err.println("Deu pau no MYSQL!");
                }
                mudabotoes(true, false, true, true, true, true);
                tabelaTurma.setEnabled(true);           
            }
        } else {
            if (campoAno.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite um ano.");
            } else if (campoFrequencia.getText().equals("")) {
                JOptionPane.showMessageDialog(null, "Digite uma frequencia");
            } else if (campoNota.getText().equals("")){
                JOptionPane.showMessageDialog(null, "Digite uma nota");
            } else {
                try {
                    int p = tabelaHistorico.getSelectedRow();
                    st.executeUpdate("update historico set ANO = " + Integer.parseInt(campoAno.getText()) + ", frequencia = " + Float.parseFloat(campoFrequencia.getText()) + ", nota = " + Float.parseFloat(campoNota.getText()) + "where COD_HISTORICO = " + tabelaHistorico.getValueAt(p, 0) + " ;");
                } catch (SQLException ex) {
                    System.err.println("Deu pau no MYSQL!");
                }
                mudabotoes(true, false, true, true, true, true);
                tabelaHistorico.setEnabled(true);
                tabelaDisciplina.setEnabled(true);
                tabelaProfessores.setEnabled(true);
                tabelaTurma.setEnabled(true);
                tabelaAluno.setEnabled(true);
            }
        }        
        
        limpacampos();
        consulta();
    }//GEN-LAST:event_btSalvarActionPerformed

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
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historico.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historico().setVisible(true);
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
    private javax.swing.JTextField campoAno;
    private javax.swing.JTextField campoCodAluno;
    private javax.swing.JTextField campoCodDisc;
    private javax.swing.JTextField campoCodProf;
    private javax.swing.JTextField campoCodTurma;
    private javax.swing.JTextField campoFrequencia;
    private javax.swing.JTextField campoNota;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JTable jTable1;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable tabelaAluno;
    private javax.swing.JTable tabelaDisciplina;
    private javax.swing.JTable tabelaHistorico;
    private javax.swing.JTable tabelaProfessores;
    private javax.swing.JTable tabelaTurma;
    // End of variables declaration//GEN-END:variables
private void limpacampos() {
        campoCodDisc.setText("");
        campoCodProf.setText("");
        campoCodAluno.setText("");
        campoCodTurma.setText("");
        campoAno.setText("");
        campoFrequencia.setText("");
        campoNota.setText("");
    }

}
