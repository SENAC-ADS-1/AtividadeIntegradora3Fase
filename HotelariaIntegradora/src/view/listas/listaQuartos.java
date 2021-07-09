package view.listas;

import controller.daoQuarto;
import enums.TipoQuartos;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JOptionPane;
import model.Quarto;
import view.MyTableModel;
import view.cadastros.cadastroQuartos;

/*
 * @author Tramontina Cromada
 */

public class listaQuartos extends javax.swing.JDialog {

    private final daoQuarto dao = new daoQuarto();
    
    private void carregarTabela() throws SQLException {
        tbDados.setModel(new MyTableModel(Quarto.class, dao.read(), tbDados));
    }
    
    private void carregarTabela(TipoQuartos tipo) throws SQLException {
        tbDados.setModel(new MyTableModel(Quarto.class, dao.read(tipo), tbDados));
    }
    
    private void listarDados() {
        try {
            if (rbNenhum.isSelected()) {
                carregarTabela();
            } else if (rbTipo.isSelected()) {
                carregarTabela((TipoQuartos)cbTipoQuartos.getSelectedItem());
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao listar os dados!" + 
                                                System.lineSeparator() + 
                                                "Detalhes do erro: " + e.getMessage());
        }
    }
    
    private void carregarTipos() {
        DefaultComboBoxModel<TipoQuartos> model = new DefaultComboBoxModel<>(TipoQuartos.values());
        cbTipoQuartos.setModel(model);
    }
    
    private void abreCadastro(Quarto quarto) {
        new cadastroQuartos(
                null, 
                true,
                quarto == null ? null : quarto
        ).setVisible(true);
    }
    
    public listaQuartos(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgFiltros = new javax.swing.ButtonGroup();
        pnBackground = new javax.swing.JPanel();
        pnLista = new javax.swing.JPanel();
        spTabela = new javax.swing.JScrollPane();
        tbDados = new javax.swing.JTable();
        lbFiltros = new javax.swing.JLabel();
        rbTipo = new javax.swing.JRadioButton();
        cbTipoQuartos = new javax.swing.JComboBox<>();
        rbNenhum = new javax.swing.JRadioButton();
        btListar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de quartos");
        setBackground(new java.awt.Color(51, 51, 51));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnBackground.setBackground(new java.awt.Color(51, 51, 51));

        pnLista.setBackground(new java.awt.Color(51, 51, 51));

        tbDados.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tbDados.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbDadosMouseClicked(evt);
            }
        });
        spTabela.setViewportView(tbDados);

        lbFiltros.setForeground(new java.awt.Color(255, 255, 255));
        lbFiltros.setText("Filtros");

        bgFiltros.add(rbTipo);
        rbTipo.setForeground(new java.awt.Color(255, 255, 255));
        rbTipo.setText("Tipo");

        bgFiltros.add(rbNenhum);
        rbNenhum.setForeground(new java.awt.Color(255, 255, 255));
        rbNenhum.setSelected(true);
        rbNenhum.setText("Nenhum");

        javax.swing.GroupLayout pnListaLayout = new javax.swing.GroupLayout(pnLista);
        pnLista.setLayout(pnListaLayout);
        pnListaLayout.setHorizontalGroup(
            pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(spTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 572, Short.MAX_VALUE)
                    .addGroup(pnListaLayout.createSequentialGroup()
                        .addGroup(pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFiltros)
                            .addGroup(pnListaLayout.createSequentialGroup()
                                .addComponent(rbNenhum)
                                .addGap(18, 18, 18)
                                .addGroup(pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbTipo)
                                    .addComponent(cbTipoQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnListaLayout.setVerticalGroup(
            pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFiltros)
                .addGap(7, 7, 7)
                .addGroup(pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbTipo)
                    .addComponent(rbNenhum))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cbTipoQuartos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(spTabela, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                .addContainerGap())
        );

        btListar.setText("Listar registros");
        btListar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btListarActionPerformed(evt);
            }
        });

        btNovo.setText("Novo registro");
        btNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btNovoActionPerformed(evt);
            }
        });

        btEditar.setText("Editar registro");
        btEditar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btEditarActionPerformed(evt);
            }
        });

        btExcluir.setText("Excluir registro");
        btExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btExcluirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBackgroundLayout = new javax.swing.GroupLayout(pnBackground);
        pnBackground.setLayout(pnBackgroundLayout);
        pnBackgroundLayout.setHorizontalGroup(
            pnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addGroup(pnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btListar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(btEditar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(btExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(pnLista, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        pnBackgroundLayout.setVerticalGroup(
            pnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnLista, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btListar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btNovo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btEditar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btExcluir)
                .addContainerGap(363, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pnBackground, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void tbDadosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbDadosMouseClicked
        if (evt.getClickCount() == 2) {
            btEditar.doClick();
        }
    }//GEN-LAST:event_tbDadosMouseClicked

    private void btListarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btListarActionPerformed
        listarDados();
    }//GEN-LAST:event_btListarActionPerformed

    private void btNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btNovoActionPerformed
        abreCadastro(null);
    }//GEN-LAST:event_btNovoActionPerformed

    private void btEditarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btEditarActionPerformed
        if (tbDados.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum registro disponível para editar!");
            return;
        }
        
        if (tbDados.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum registro selecionado para editar!");
            return;
        }
        
        String valor = tbDados.getValueAt(tbDados.getSelectedRow(), 0).toString();
        
        try {
            int codigo = Integer.parseInt(valor);

            Quarto quarto = dao.read(codigo);

            abreCadastro(quarto);
            
            listarDados();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao selecionar os dados dos quartos!" +
                System.lineSeparator() +
                "Detalhes do erro: " + e);
        }
    }//GEN-LAST:event_btEditarActionPerformed

    private void btExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btExcluirActionPerformed
        if (tbDados.getRowCount() == 0) {
            JOptionPane.showMessageDialog(this, "Nenhum registro disponível para excluir!");
            return;
        }
        
        if (tbDados.getSelectionModel().isSelectionEmpty()) {
            JOptionPane.showMessageDialog(this, "Nenhum registro selecionado para excluir!");
            return;
        }
        
        String valor = tbDados.getValueAt(tbDados.getSelectedRow(), 0).toString();
        
        try {
            int codigo = Integer.parseInt(valor);

            Quarto quarto = dao.read(codigo);

            dao.delete(quarto);
            
            JOptionPane.showMessageDialog(this, "Registro excluído!");
            
            listarDados();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Ocorreu um erro ao selecionar os dados dos quartos!" +
                System.lineSeparator() +
                "Detalhes do erro: " + e);
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        carregarTipos();
    }//GEN-LAST:event_formWindowOpened

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
            java.util.logging.Logger.getLogger(listaQuartos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listaQuartos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listaQuartos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listaQuartos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                listaQuartos dialog = new listaQuartos(new javax.swing.JFrame(), true);
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

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgFiltros;
    private javax.swing.JButton btEditar;
    private javax.swing.JButton btExcluir;
    private javax.swing.JButton btListar;
    private javax.swing.JButton btNovo;
    private javax.swing.JComboBox<TipoQuartos> cbTipoQuartos;
    private javax.swing.JLabel lbFiltros;
    private javax.swing.JPanel pnBackground;
    private javax.swing.JPanel pnLista;
    private javax.swing.JRadioButton rbNenhum;
    private javax.swing.JRadioButton rbTipo;
    private javax.swing.JScrollPane spTabela;
    private javax.swing.JTable tbDados;
    // End of variables declaration//GEN-END:variables

}
