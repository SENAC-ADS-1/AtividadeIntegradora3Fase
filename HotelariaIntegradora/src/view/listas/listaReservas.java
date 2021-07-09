package view.listas;

import controller.daoQuarto;
import controller.daoReserva;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import model.Quarto;
import model.Reserva;
import view.MyTableModel;
import view.cadastros.cadastroReservas;

/*
 * @author Tramontina Cromada
 */

public class listaReservas extends javax.swing.JDialog {

    private final daoReserva dao = new daoReserva();
    private final DateTimeFormatter dateParser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    private void carregarTabela() throws SQLException {
        tbDados.setModel(new MyTableModel(Reserva.class, dao.read(), tbDados));
    }
    
    private void carregarTabela(Quarto quarto) throws SQLException {
        tbDados.setModel(new MyTableModel(Reserva.class, dao.read(quarto), tbDados));
    }
    
    private void carregarTabela(LocalDate data) throws SQLException {
        tbDados.setModel(new MyTableModel(Reserva.class, dao.read(data), tbDados));
    }
    
    private void listarDados() {
        if (rbCodigoQuarto.isSelected()) {
            try {
                if (tfCodigoQuarto.getText().trim().isEmpty()) {
                    carregarTabela();
                } else {
                    carregarTabela(new daoQuarto().read(Integer.parseInt(tfCodigoQuarto.getText().trim())));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao listar os dados!" + 
                                                    System.lineSeparator() + 
                                                    "Detalhes do erro: " + e.getMessage());
            }
        } else if (rbData.isSelected()) {
            try {
                if (ftData.getText().replace("/", "").trim().isEmpty()) {
                    carregarTabela();
                } else {
                    carregarTabela(LocalDate.parse(ftData.getText().trim(), dateParser));
                }
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao listar os dados!" + 
                                                    System.lineSeparator() + 
                                                    "Detalhes do erro: " + e.getMessage());
            }
        }
    }
    
    private void abreCadastro(Reserva reserva) {
        new cadastroReservas(
                null, 
                true,
                reserva == null ? null : reserva
        ).setVisible(true);
    }
    
    public listaReservas(java.awt.Frame parent, boolean modal) {
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
        rbCodigoQuarto = new javax.swing.JRadioButton();
        tfCodigoQuarto = new javax.swing.JTextField();
        rbData = new javax.swing.JRadioButton();
        ftData = new javax.swing.JFormattedTextField();
        btListar = new javax.swing.JButton();
        btNovo = new javax.swing.JButton();
        btEditar = new javax.swing.JButton();
        btExcluir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Lista de reservas");
        setBackground(new java.awt.Color(51, 51, 51));

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

        bgFiltros.add(rbCodigoQuarto);
        rbCodigoQuarto.setForeground(new java.awt.Color(255, 255, 255));
        rbCodigoQuarto.setSelected(true);
        rbCodigoQuarto.setText("Código do Quarto");

        tfCodigoQuarto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodigoQuartoFocusLost(evt);
            }
        });

        bgFiltros.add(rbData);
        rbData.setForeground(new java.awt.Color(255, 255, 255));
        rbData.setText("Data da reserva");

        try {
            ftData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftData.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftDataFocusLost(evt);
            }
        });

        javax.swing.GroupLayout pnListaLayout = new javax.swing.GroupLayout(pnLista);
        pnLista.setLayout(pnListaLayout);
        pnListaLayout.setHorizontalGroup(
            pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnListaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(spTabela)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnListaLayout.createSequentialGroup()
                        .addGroup(pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(tfCodigoQuarto, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lbFiltros, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbCodigoQuarto, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbData, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(ftData))
                        .addGap(356, 356, 356)))
                .addContainerGap())
        );
        pnListaLayout.setVerticalGroup(
            pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnListaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbFiltros)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rbCodigoQuarto)
                    .addComponent(rbData))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnListaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(ftData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(spTabela, javax.swing.GroupLayout.DEFAULT_SIZE, 378, Short.MAX_VALUE)
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

            Reserva reserva = dao.read(codigo);

            abreCadastro(reserva);
            
            listarDados();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Não foi possível editar esta reserva!" +
                System.lineSeparator() +
                "Detalhes do erro: " + e.getMessage());
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

            Reserva reserva = dao.read(codigo);

            dao.delete(reserva);
            
            JOptionPane.showMessageDialog(this, "Registro excluído!");
            
            listarDados();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Não foi possível excluir esta reserva!" +
                System.lineSeparator() +
                "Detalhes do erro: " + e.getMessage());
        }
    }//GEN-LAST:event_btExcluirActionPerformed

    private void tfCodigoQuartoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodigoQuartoFocusLost
        if (tfCodigoQuarto.getText().trim().isEmpty()) {
            return;
        }

        Quarto quarto = null;

        try {
            int codigo = Integer.parseInt(tfCodigoQuarto.getText().trim());

            try {
                quarto = new daoQuarto().read(codigo);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao selecionar os dados do quarto!" +
                    System.lineSeparator() +
                    "Detalhes do erro: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido!");
            tfCodigoQuarto.requestFocus();
            return;
        }

        if (quarto == null) {
            JOptionPane.showMessageDialog(this, "Este quarto não existe!");
            tfCodigoQuarto.setText("");
            tfCodigoQuarto.requestFocus();
            return;
        }
    }//GEN-LAST:event_tfCodigoQuartoFocusLost

    private void ftDataFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftDataFocusLost
        if (ftData.getText().replace("/", "").trim().isEmpty()) {
            return;
        }
        
        try { 
            LocalDate data = LocalDate.parse(ftData.getText(), dateParser);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida!");
            ftData.setText("");
        }
    }//GEN-LAST:event_ftDataFocusLost

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
            java.util.logging.Logger.getLogger(listaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(listaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(listaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(listaReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                listaReservas dialog = new listaReservas(new javax.swing.JFrame(), true);
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
    private javax.swing.JFormattedTextField ftData;
    private javax.swing.JLabel lbFiltros;
    private javax.swing.JPanel pnBackground;
    private javax.swing.JPanel pnLista;
    private javax.swing.JRadioButton rbCodigoQuarto;
    private javax.swing.JRadioButton rbData;
    private javax.swing.JScrollPane spTabela;
    private javax.swing.JTable tbDados;
    private javax.swing.JTextField tfCodigoQuarto;
    // End of variables declaration//GEN-END:variables

}
