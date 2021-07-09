package view.cadastros;

import controller.daoCliente;
import controller.daoFuncionario;
import controller.daoQuarto;
import controller.daoReserva;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;
import model.Cliente;
import model.Funcionario;
import model.Quarto;
import model.Reserva;

/*
 * @author Tramontina Cromada
 */

public class cadastroReservas extends javax.swing.JDialog {

    private Reserva reserva = new Reserva();
    private daoReserva dao = new daoReserva();
    private final DateTimeFormatter dateParser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public cadastroReservas(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tfCodigoQuarto.requestFocus();
    }
    
    public cadastroReservas(java.awt.Frame parent, boolean modal, Reserva reserva) {
        super(parent, modal);
        initComponents();
        
        if (reserva != null) {
            this.reserva = reserva;
            preencherCampos();
        }
        
        tfCodigoQuarto.requestFocus();
    }
    
    private void limparCampos() {
        tfCodigo.setText("");
        tfCodigoCliente.setText("");
        tfNomeCliente.setText("");
        tfCodigoFuncionario.setText("");
        tfNomeFuncionario.setText("");
        tfCodigoQuarto.setText("");
        tfValor.setText("");
        ftData.setText("");
        this.reserva = null;
    }
    
    private void atualizarValores() {
        try {
            this.reserva.setId(tfCodigo.getText().trim().isEmpty() ? 0 : Integer.parseInt(tfCodigo.getText().trim()));
            this.reserva.setFuncionario(new daoFuncionario().read(Integer.parseInt(tfCodigoFuncionario.getText().trim())));
            this.reserva.setCliente(new daoCliente().read(Integer.parseInt(tfCodigoCliente.getText().trim())));
            this.reserva.setQuarto(new daoQuarto().read(Integer.parseInt(tfCodigoQuarto.getText().trim())));
            this.reserva.setValor(Double.parseDouble(tfValor.getText().trim()));
            this.reserva.setData(LocalDate.parse(ftData.getText().trim(), dateParser));
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(this, "Erro ao atualizar os valores locais do cliente!" + System.lineSeparator() + 
                                                "Detalhes: " + e.getMessage());
            return;
        }
    }
    
    private void preencherCampos() {
        tfCodigo.setText(String.valueOf(this.reserva.getId()));
        tfCodigoCliente.setText(String.valueOf(this.reserva.getCliente().getId()));
        tfNomeCliente.setText(this.reserva.getCliente().getNome());
        tfCodigoFuncionario.setText(String.valueOf(this.reserva.getFuncionario().getId()));
        tfNomeFuncionario.setText(this.reserva.getFuncionario().getNome());
        tfCodigoQuarto.setText(String.valueOf(this.reserva.getQuarto().getId()));
        tfValor.setText(String.valueOf(this.reserva.getValor()));
        ftData.setText(this.reserva.getData().format(dateParser));
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBackground = new javax.swing.JPanel();
        pnCampos = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        lbQuarto = new javax.swing.JLabel();
        tfCodigoQuarto = new javax.swing.JTextField();
        lbCliente = new javax.swing.JLabel();
        tfCodigoCliente = new javax.swing.JTextField();
        tfNomeCliente = new javax.swing.JTextField();
        lbFuncionario = new javax.swing.JLabel();
        tfCodigoFuncionario = new javax.swing.JTextField();
        tfNomeFuncionario = new javax.swing.JTextField();
        lbValor = new javax.swing.JLabel();
        tfValor = new javax.swing.JTextField();
        lbData = new javax.swing.JLabel();
        ftData = new javax.swing.JFormattedTextField();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de reserva");
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pnBackground.setBackground(new java.awt.Color(51, 51, 51));

        pnCampos.setBackground(new java.awt.Color(51, 51, 51));

        lbCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lbCodigo.setText("Código");

        tfCodigo.setEditable(false);

        lbQuarto.setForeground(new java.awt.Color(255, 255, 255));
        lbQuarto.setText("Quarto");

        tfCodigoQuarto.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodigoQuartoFocusLost(evt);
            }
        });

        lbCliente.setForeground(new java.awt.Color(255, 255, 255));
        lbCliente.setText("Cliente");

        tfCodigoCliente.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodigoClienteFocusLost(evt);
            }
        });

        tfNomeCliente.setEditable(false);

        lbFuncionario.setForeground(new java.awt.Color(255, 255, 255));
        lbFuncionario.setText("Colaborador responsável");

        tfCodigoFuncionario.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                tfCodigoFuncionarioFocusLost(evt);
            }
        });

        tfNomeFuncionario.setEditable(false);

        lbValor.setForeground(new java.awt.Color(255, 255, 255));
        lbValor.setText("Valor");

        tfValor.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tfValorKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tfValorKeyReleased(evt);
            }
        });

        lbData.setForeground(new java.awt.Color(255, 255, 255));
        lbData.setText("Data");

        try {
            ftData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        javax.swing.GroupLayout pnCamposLayout = new javax.swing.GroupLayout(pnCampos);
        pnCampos.setLayout(pnCamposLayout);
        pnCamposLayout.setHorizontalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCodigo))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftData, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbData)))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(tfCodigoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNomeFuncionario, javax.swing.GroupLayout.DEFAULT_SIZE, 450, Short.MAX_VALUE))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfNomeCliente))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(pnCamposLayout.createSequentialGroup()
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(tfCodigoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, 115, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lbQuarto))
                                .addGap(18, 18, 18)
                                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lbValor)
                                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(lbFuncionario)
                            .addComponent(lbCliente))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnCamposLayout.setVerticalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbCodigo)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbData)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbQuarto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tfCodigoQuarto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbValor)
                        .addGap(28, 28, 28))
                    .addComponent(tfValor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigoCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNomeCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lbFuncionario)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tfCodigoFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tfNomeFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        btSalvar.setText("Salvar");
        btSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnBackgroundLayout = new javax.swing.GroupLayout(pnBackground);
        pnBackground.setLayout(pnBackgroundLayout);
        pnBackgroundLayout.setHorizontalGroup(
            pnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnBackgroundLayout.setVerticalGroup(
            pnBackgroundLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnBackgroundLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btSalvar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(pnCampos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
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

    private void btSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btSalvarActionPerformed
        if (ftData.getText().replace("/", "").trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite a data da reserva!");
            ftData.requestFocus();
            return;
        }
        
        if (tfValor.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o valor da reserva!");
            tfValor.requestFocus();
            return;
        }
        
        if (tfCodigoQuarto.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o quarto!");
            tfCodigoQuarto.requestFocus();
            return;
        }
        
        if (tfCodigoCliente.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o cliente!");
            tfCodigoCliente.requestFocus();
            return;
        }
        
        if (tfCodigoFuncionario.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Informe o funcionário!");
            tfCodigoFuncionario.requestFocus();
            return;
        }
        
        atualizarValores();
        
        try {
            if (tfCodigo.getText().trim().isEmpty()) {
                dao.create(this.reserva);
            } else {
                dao.update(this.reserva);
            }
            
            limparCampos();

            JOptionPane.showMessageDialog(this, "Os dados do cliente foram salvos!");

            dispose();
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(this, "Ocorreu um erro ao salvar os dados do cliente!" + 
                                               System.lineSeparator() + 
                                               "Detalhes do erro: " + e);
        }
    }//GEN-LAST:event_btSalvarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened

    }//GEN-LAST:event_formWindowOpened

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

        if (tfValor.getText().trim().isEmpty()) {
            tfValor.setText(String.valueOf(quarto.getValor()));
        }
    }//GEN-LAST:event_tfCodigoQuartoFocusLost

    private void tfCodigoClienteFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodigoClienteFocusLost
        if (tfCodigoCliente.getText().trim().isEmpty()) {
            return;
        }

        Cliente cliente = null;

        try {
            int codigo = Integer.parseInt(tfCodigoCliente.getText().trim());

            try {
                cliente = new daoCliente().read(codigo);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao selecionar os dados do cliente!" +
                    System.lineSeparator() +
                    "Detalhes do erro: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido!");
            tfCodigoCliente.requestFocus();
            return;
        }

        if (cliente == null) {
            JOptionPane.showMessageDialog(this, "Este cliente não existe!");
            tfCodigoCliente.setText("");
            tfNomeCliente.setText("");
            tfCodigoCliente.requestFocus();
            return;
        }

        tfNomeCliente.setText(cliente.getNome());
    }//GEN-LAST:event_tfCodigoClienteFocusLost

    private void tfCodigoFuncionarioFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tfCodigoFuncionarioFocusLost
        if (tfCodigoFuncionario.getText().trim().isEmpty()) {
            return;
        }

        Funcionario funcionario = null;

        try {
            int codigo = Integer.parseInt(tfCodigoFuncionario.getText().trim());

            try {
                funcionario = new daoFuncionario().read(codigo);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(this, "Ocorreu um erro ao selecionar os dados do funcionário!" +
                    System.lineSeparator() +
                    "Detalhes do erro: " + e.getMessage());
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Código inválido!");
            tfCodigoFuncionario.requestFocus();
            return;
        }

        if (funcionario == null) {
            JOptionPane.showMessageDialog(this, "Este funcionário não existe!");
            tfCodigoFuncionario.setText("");
            tfNomeFuncionario.setText("");
            tfCodigoFuncionario.requestFocus();
            return;
        }

        tfNomeFuncionario.setText(funcionario.getNome());
    }//GEN-LAST:event_tfCodigoFuncionarioFocusLost

    private void tfValorKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorKeyPressed
        if (tfValor.getText().trim().isEmpty()) {
            return;
        }
        
        tfValor.setText(tfValor.getText().trim().replace(",", "."));
        
        try {
            double valida = Double.parseDouble(tfValor.getText().trim());
            if (valida <= 0) { 
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido!");
            tfValor.setText("");
            tfValor.requestFocus();
        }
    }//GEN-LAST:event_tfValorKeyPressed

    private void tfValorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tfValorKeyReleased
        if (tfValor.getText().trim().isEmpty()) {
            return;
        }

        tfValor.setText(tfValor.getText().trim().replace(",", "."));

        try {
            double valida = Double.parseDouble(tfValor.getText().trim());
            if (valida <= 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Valor inválido!");
            tfValor.setText("");
            tfValor.requestFocus();
        }
    }//GEN-LAST:event_tfValorKeyReleased

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
            java.util.logging.Logger.getLogger(cadastroReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroReservas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                cadastroReservas dialog = new cadastroReservas(new javax.swing.JFrame(), true);
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
    private javax.swing.JButton btSalvar;
    private javax.swing.JFormattedTextField ftData;
    private javax.swing.JLabel lbCliente;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbData;
    private javax.swing.JLabel lbFuncionario;
    private javax.swing.JLabel lbQuarto;
    private javax.swing.JLabel lbValor;
    private javax.swing.JPanel pnBackground;
    private javax.swing.JPanel pnCampos;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfCodigoCliente;
    private javax.swing.JTextField tfCodigoFuncionario;
    private javax.swing.JTextField tfCodigoQuarto;
    private javax.swing.JTextField tfNomeCliente;
    private javax.swing.JTextField tfNomeFuncionario;
    private javax.swing.JTextField tfValor;
    // End of variables declaration//GEN-END:variables

}
