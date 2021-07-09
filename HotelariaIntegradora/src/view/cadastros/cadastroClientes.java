package view.cadastros;

import controller.daoCliente;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import javax.swing.JOptionPane;
import model.Cliente;

/*
 * @author Tramontina Cromada
 */

public class cadastroClientes extends javax.swing.JDialog {

    private Cliente cliente = new Cliente();
    private daoCliente dao = new daoCliente();
    private final DateTimeFormatter dateParser = DateTimeFormatter.ofPattern("dd/MM/yyyy");
    
    public cadastroClientes(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        tfNome.requestFocus();
    }
    
    public cadastroClientes(java.awt.Frame parent, boolean modal, Cliente cliente) {
        super(parent, modal);
        initComponents();
        
        if (cliente != null) {
            this.cliente = cliente;
            preencherCampos();
        }
        
        tfNome.requestFocus();
    }
    
    private void limparCampos() {
        tfCodigo.setText("");
        tfNome.setText("");
        
        this.cliente = null;
    }
    
    private void atualizarValores() {
        this.cliente.setId(tfCodigo.getText().trim().isEmpty() ? 0 : Integer.parseInt(tfCodigo.getText().trim()));
        this.cliente.setNome(tfNome.getText().trim());
        this.cliente.setCpf(ftCPF.getText().trim());
        this.cliente.setDataNascimento(LocalDate.parse(ftDataNascimento.getText().trim(), dateParser));
        this.cliente.setEmail(tfEmail.getText().trim());
        this.cliente.setTelefone(ftTelefone.getText().trim());
    }
    
    private void preencherCampos() {
        tfCodigo.setText(String.valueOf(this.cliente.getId()));
        tfNome.setText(this.cliente.getNome());
        ftCPF.setText(this.cliente.getCpf());
        ftDataNascimento.setText(this.cliente.getDataNascimento().format(dateParser));
        tfEmail.setText(this.cliente.getEmail());
        ftTelefone.setText(this.cliente.getTelefone());
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnBackground = new javax.swing.JPanel();
        pnCampos = new javax.swing.JPanel();
        lbCodigo = new javax.swing.JLabel();
        tfCodigo = new javax.swing.JTextField();
        tfNome = new javax.swing.JTextField();
        lbNome = new javax.swing.JLabel();
        ftCPF = new javax.swing.JFormattedTextField();
        lbCPF = new javax.swing.JLabel();
        lbDataNascimento = new javax.swing.JLabel();
        ftDataNascimento = new javax.swing.JFormattedTextField();
        lbTelefone = new javax.swing.JLabel();
        ftTelefone = new javax.swing.JFormattedTextField();
        lbEmail = new javax.swing.JLabel();
        tfEmail = new javax.swing.JTextField();
        btSalvar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("Cadastro de clientes");

        pnBackground.setBackground(new java.awt.Color(51, 51, 51));

        pnCampos.setBackground(new java.awt.Color(51, 51, 51));

        lbCodigo.setForeground(new java.awt.Color(255, 255, 255));
        lbCodigo.setText("Código");

        tfCodigo.setEditable(false);

        lbNome.setForeground(new java.awt.Color(255, 255, 255));
        lbNome.setText("Nome");

        try {
            ftCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbCPF.setForeground(new java.awt.Color(255, 255, 255));
        lbCPF.setText("CPF");

        lbDataNascimento.setForeground(new java.awt.Color(255, 255, 255));
        lbDataNascimento.setText("Data de Nascimento");

        try {
            ftDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        ftDataNascimento.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                ftDataNascimentoFocusLost(evt);
            }
        });

        lbTelefone.setForeground(new java.awt.Color(255, 255, 255));
        lbTelefone.setText("Telefone");

        try {
            ftTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        lbEmail.setForeground(new java.awt.Color(255, 255, 255));
        lbEmail.setText("Email");

        javax.swing.GroupLayout pnCamposLayout = new javax.swing.GroupLayout(pnCampos);
        pnCampos.setLayout(pnCamposLayout);
        pnCamposLayout.setHorizontalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftCPF, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbCPF))
                        .addGap(108, 108, 108)
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbDataNascimento))
                        .addGap(99, 99, 99)
                        .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(ftTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 127, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lbTelefone)))
                    .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lbCodigo)
                        .addComponent(lbNome)
                        .addComponent(lbEmail)
                        .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 588, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnCamposLayout.setVerticalGroup(
            pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnCamposLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lbCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tfCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbNome)
                        .addGap(29, 29, 29))
                    .addComponent(tfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.CENTER)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbCPF)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnCamposLayout.createSequentialGroup()
                        .addComponent(lbDataNascimento)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, pnCamposLayout.createSequentialGroup()
                        .addComponent(lbTelefone)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(ftTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnCamposLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(pnCamposLayout.createSequentialGroup()
                        .addComponent(lbEmail)
                        .addGap(29, 29, 29))
                    .addComponent(tfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                .addContainerGap(225, Short.MAX_VALUE))
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
        if (tfNome.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o nome do cliente!");
            tfNome.requestFocus();
            return;
        }
        
        if (ftCPF.getText().replaceAll("[.-]", "").trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o CPF!");
            ftCPF.requestFocus();
            return;
        }
        
        if (ftDataNascimento.getText().replace("/", "").trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite a data de nascimento!");
            ftDataNascimento.requestFocus();
            return;
        }
        
        if (ftTelefone.getText().replaceAll("[()-]", "").trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o telefone!");
            ftTelefone.requestFocus();
            return;
        }
        
        if (tfEmail.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Digite o email do cliente!");
            tfEmail.requestFocus();
            return;
        }
        
        atualizarValores();
        
        try {
            if (tfCodigo.getText().trim().isEmpty()) {
                dao.create(this.cliente);
            } else {
                dao.update(this.cliente);
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

    private void ftDataNascimentoFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_ftDataNascimentoFocusLost
        if (ftDataNascimento.getText().replace("/", "").trim().isEmpty()) {
            return;
        }
        
        try { 
            LocalDate data = LocalDate.parse(ftDataNascimento.getText(), dateParser);
        } catch (DateTimeParseException e) {
            JOptionPane.showMessageDialog(this, "Data inválida!");
            ftDataNascimento.setText("");
        }
    }//GEN-LAST:event_ftDataNascimentoFocusLost

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
            java.util.logging.Logger.getLogger(cadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(cadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(cadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(cadastroClientes.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                cadastroClientes dialog = new cadastroClientes(new javax.swing.JFrame(), true);
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
    private javax.swing.JFormattedTextField ftCPF;
    private javax.swing.JFormattedTextField ftDataNascimento;
    private javax.swing.JFormattedTextField ftTelefone;
    private javax.swing.JLabel lbCPF;
    private javax.swing.JLabel lbCodigo;
    private javax.swing.JLabel lbDataNascimento;
    private javax.swing.JLabel lbEmail;
    private javax.swing.JLabel lbNome;
    private javax.swing.JLabel lbTelefone;
    private javax.swing.JPanel pnBackground;
    private javax.swing.JPanel pnCampos;
    private javax.swing.JTextField tfCodigo;
    private javax.swing.JTextField tfEmail;
    private javax.swing.JTextField tfNome;
    // End of variables declaration//GEN-END:variables

}
