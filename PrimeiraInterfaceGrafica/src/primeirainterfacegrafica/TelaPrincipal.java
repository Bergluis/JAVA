
package primeirainterfacegrafica;

import java.util.LinkedList;
import javax.swing.JOptionPane;

public class TelaPrincipal extends javax.swing.JFrame {
    LinkedList <Cliente> listaClientes = new LinkedList<>();
    
    public TelaPrincipal() {
        initComponents();
        //carregar a combo box com as opções desejadas
        jCBsexo.addItem("Selecione");
        jCBsexo.addItem("Masculino");
        jCBsexo.addItem("Feminino");

        //carregando a combo a a partir da lista
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLnome = new javax.swing.JLabel();
        jTFidade = new javax.swing.JTextField();
        jLidade = new javax.swing.JLabel();
        jTFnome1 = new javax.swing.JTextField();
        jLsexo = new javax.swing.JLabel();
        jTFaltura = new javax.swing.JTextField();
        jLaltura = new javax.swing.JLabel();
        jLtitulo = new javax.swing.JLabel();
        jBsalvar = new javax.swing.JButton();
        jBcancelar = new javax.swing.JButton();
        jBTamanho = new javax.swing.JButton();
        jCBsexo = new javax.swing.JComboBox<>();
        jLnomes = new javax.swing.JLabel();
        jCBNomes = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tela principal");

        jLnome.setText("Nome:");
        jLnome.setToolTipText("");

        jTFidade.setToolTipText("Informe a idade do aluno");

        jLidade.setText("Idade:");
        jLidade.setToolTipText("");

        jTFnome1.setToolTipText("Informe o nome do aluno");

        jLsexo.setText("Sexo:");

        jTFaltura.setToolTipText("Informe a altura do aluno");

        jLaltura.setText("Altura: ");

        jLtitulo.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        jLtitulo.setText("Dados dos alunos");

        jBsalvar.setText("Salvar");
        jBsalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBsalvarActionPerformed(evt);
            }
        });

        jBcancelar.setText("Cancelar");
        jBcancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBcancelarActionPerformed(evt);
            }
        });

        jBTamanho.setText("Tamanho");
        jBTamanho.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jBTamanhoActionPerformed(evt);
            }
        });

        jLnomes.setText("Nomes:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(jBsalvar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBcancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jBTamanho))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLnome)
                                    .addGap(18, 18, 18)
                                    .addComponent(jTFnome1))
                                .addGroup(layout.createSequentialGroup()
                                    .addGap(60, 60, 60)
                                    .addComponent(jLtitulo))
                                .addGroup(layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLidade)
                                        .addComponent(jLsexo)
                                        .addComponent(jLaltura))
                                    .addGap(13, 13, 13)
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jTFidade)
                                        .addComponent(jCBsexo, 0, 186, Short.MAX_VALUE)
                                        .addComponent(jTFaltura)
                                        .addComponent(jCBNomes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                            .addComponent(jLnomes))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLtitulo)
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLnome)
                    .addComponent(jTFnome1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLidade)
                    .addComponent(jTFidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(12, 12, 12)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLsexo)
                    .addComponent(jCBsexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLaltura)
                    .addComponent(jTFaltura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLnomes)
                    .addComponent(jCBNomes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jBsalvar)
                    .addComponent(jBcancelar)
                    .addComponent(jBTamanho))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void jBsalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBsalvarActionPerformed
        if(!jTFnome1.getText().equals("")){
                if(!jTFidade.getText().equals("")){ 
                    if(jCBsexo.getSelectedIndex() != 0){
                        if(!jTFaltura.getText().equals("")){       
                            String nome = jTFnome1.getText();
                            int idade = Integer.parseInt(jTFidade.getText());
                            String sexo = (String)jCBsexo.getSelectedItem();
                            float altura = Float.parseFloat(jTFaltura.getText());
                            Cliente novoCliente = new Cliente(nome, idade, sexo, altura);
                            listaClientes.add(novoCliente);
                            JOptionPane.showMessageDialog(rootPane, "Nome: " + nome + "\n Idade: " + idade +" \n Sexo: " + sexo + "\n Altura: " + altura, "Dados informados pelo usuário", JOptionPane.INFORMATION_MESSAGE );
                            limpaCampos();
                        } else{
                            JOptionPane.showMessageDialog(rootPane, "Informe a altura.", "Erro", JOptionPane.ERROR_MESSAGE);
                        }
                    } else{
                        JOptionPane.showMessageDialog(rootPane, "Informe o sexo.", "Erro", JOptionPane.ERROR_MESSAGE);
                    }
                } else{
                    JOptionPane.showMessageDialog(rootPane, "Informe a idade.", "Erro", JOptionPane.ERROR_MESSAGE);
               }
         } else{
            JOptionPane.showMessageDialog(rootPane, "Informe o nome.", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jBsalvarActionPerformed

    private void jBcancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBcancelarActionPerformed
        limpaCampos();
    }//GEN-LAST:event_jBcancelarActionPerformed

    private void jBTamanhoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jBTamanhoActionPerformed
        // TODO add your handling code here:
        JOptionPane.showMessageDialog(rootPane, "Tamanho da lista: "+listaClientes.size());
        for (int x=0; x<listaClientes.size(); x++){
        Cliente meuCliente = listaClientes.get(x);
        jCBNomes.addItem(meuCliente.getNome());
    }
    }//GEN-LAST:event_jBTamanhoActionPerformed

       public void limpaCampos(){
        jTFnome1.setText("");
        jTFidade.setText("");
        jCBsexo.setSelectedIndex(0);
        jTFaltura.setText("");
       }
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
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jBTamanho;
    private javax.swing.JButton jBcancelar;
    private javax.swing.JButton jBsalvar;
    private javax.swing.JComboBox<String> jCBNomes;
    private javax.swing.JComboBox<String> jCBsexo;
    private javax.swing.JLabel jLaltura;
    private javax.swing.JLabel jLidade;
    private javax.swing.JLabel jLnome;
    private javax.swing.JLabel jLnomes;
    private javax.swing.JLabel jLsexo;
    private javax.swing.JLabel jLtitulo;
    private javax.swing.JTextField jTFaltura;
    private javax.swing.JTextField jTFidade;
    private javax.swing.JTextField jTFnome1;
    // End of variables declaration//GEN-END:variables
}
