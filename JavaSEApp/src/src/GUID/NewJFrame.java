/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUID;

import DTO.ConectionTesteDTO;
import MDJ.TreeNodes;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import help.Conection;
import help.Defs;
import help.Emuns;
import help.StringListDeserializer;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

/**
 *
 * @author BRAVANTIC
 */
public class NewJFrame extends javax.swing.JFrame {

    /**
     * Creates new form NewJFrame
     */
    private String Sgbd = "SQLServer";
    byte[] bytes;
    private DefaultMutableTreeNode root;
    private File fileRoot;

    public NewJFrame() {
        initComponents();
        initDefaultsElements();
    }

    private void initDefaultsElements() {
        jTree1.setModel(null);
        jComboBox1.addItem("SQLServer");
        jComboBox1.addItem("Mysql");
        jComboBox1.addItem("Postgres");
        jComboBox1.addItem("MongoDb");

        jTfDatabase.setText(Defs.SQlDataBase);
        jTfPorta.setText(Defs.SQlPort);
        jTfServer.setText(Defs.SQlHost);
        jTfUsuario.setText(Defs.SQlUsername);

    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jDialog1 = new javax.swing.JDialog();
        jFileChooser2 = new javax.swing.JFileChooser();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jTfDatabase = new javax.swing.JTextField();
        jTfServer = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jTfPorta = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jTfUsuario = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPasswordField1 = new javax.swing.JPasswordField();
        jCheckBox1 = new javax.swing.JCheckBox();
        jPanel2 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTree1 = new javax.swing.JTree();
        jPanel3 = new javax.swing.JPanel();
        jbtnAddFile = new javax.swing.JButton();

        jDialog1.setSize(new java.awt.Dimension(600, 550));

        jFileChooser2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jFileChooser2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jFileChooser2, javax.swing.GroupLayout.DEFAULT_SIZE, 911, Short.MAX_VALUE)
                .addContainerGap())
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jDialog1Layout.createSequentialGroup()
                .addComponent(jFileChooser2, javax.swing.GroupLayout.PREFERRED_SIZE, 474, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 58, Short.MAX_VALUE))
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Gerenciador de Banco de Dados");

        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jLabel2.setText("Database");

        jTfServer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTfServerActionPerformed(evt);
            }
        });

        jLabel3.setText("Server");

        jLabel4.setText("Porta");

        jLabel5.setText("Usuário");

        jLabel6.setText("Password");

        jButton1.setText("Teste Conexão");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Generate DB");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jCheckBox1.setToolTipText("");
        jCheckBox1.setMaximumSize(new java.awt.Dimension(50, 50));
        jCheckBox1.setMinimumSize(new java.awt.Dimension(40, 40));
        jCheckBox1.setPreferredSize(new java.awt.Dimension(50, 50));
        jCheckBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jCheckBox1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jPasswordField1)
                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2))
                    .addComponent(jComboBox1, javax.swing.GroupLayout.Alignment.LEADING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jTfDatabase, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTfServer, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTfPorta, javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTfUsuario, javax.swing.GroupLayout.Alignment.LEADING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfDatabase, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfServer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfPorta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTfUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jCheckBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
                    .addComponent(jPasswordField1, javax.swing.GroupLayout.DEFAULT_SIZE, 33, Short.MAX_VALUE))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jTree1.setModel(null);
        jScrollPane1.setViewportView(jTree1);

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 404, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 446, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        jbtnAddFile.setText("Adicionar Ficheiro (*.jar, *.dll)");
        jbtnAddFile.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtnAddFileActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jbtnAddFile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addComponent(jbtnAddFile)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(82, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 11, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(47, 47, 47))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtnAddFileActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtnAddFileActionPerformed
        // TODO add your handling code here:
        //Definir extensões permitidas
        FileNameExtensionFilter filter = new FileNameExtensionFilter("*.jar,*.dll", "jar", "dll");
        jFileChooser2.setFileFilter(filter);
        int x = jFileChooser2.showSaveDialog(null);
        if (x == JFileChooser.APPROVE_OPTION) {
            GetFileSelected();
            if (fileRoot.getName().contains("jar")) {
                TreeNodes.createChildrenJar(fileRoot, root);
            } else {
                try {
                    String resposta = Conection.RequestConectionApiPost(bytes, null, Emuns.DLLCONTENT);

                    // Criando um objeto GsonBuilder e registrando o deserializador personalizado
                    Gson gson = new GsonBuilder()
                            .registerTypeAdapter(List.class, new StringListDeserializer())
                            .create();

                    // Convertendo a string JSON em uma lista de strings
                    List<String> listaDeStrings = gson.fromJson(resposta, List.class);

                    TreeNodes.createChildrenDll(listaDeStrings, root);

                } catch (Exception e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
                }

            }
        }
    }//GEN-LAST:event_jbtnAddFileActionPerformed

    private void GetFileSelected() {
        if (jFileChooser2.getSelectedFile() != null) {
            fileRoot = jFileChooser2.getSelectedFile();
            root = new DefaultMutableTreeNode(fileRoot.getName());
            DefaultTreeModel model = new DefaultTreeModel(root);
            jTree1.setModel(model);
            generateByte(fileRoot);
        } else {
            JOptionPane.showMessageDialog(null, "Nenhum ficheiro adicionado");
        }

    }

    private void generateByte(File file) {
        bytes = new byte[(int) file.length()];
        try (FileInputStream fis = new FileInputStream(file)) {
            fis.read(bytes);
        } catch (IOException ex) {
            Logger.getLogger(NewJFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
    }


    private void jFileChooser2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jFileChooser2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jFileChooser2ActionPerformed

    private void jTfServerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTfServerActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTfServerActionPerformed

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        // TODO add your handling code here:
        jComboBox1.addItemListener((ItemEvent evento) -> {
            if (evento.getStateChange() == ItemEvent.SELECTED) {
                if (evento.getItem().equals(Emuns.Postgres.toString())) {
                    jTfDatabase.setText(Defs.PgDataBase);
                    jTfPorta.setText(Defs.PgPort);
                    jTfServer.setText(Defs.PgHost);
                    jTfUsuario.setText(Defs.PgUsername);
                } else if (evento.getItem().equals(Emuns.Mysql.toString())) {
                    jTfDatabase.setText(Defs.MyDataBase);
                    jTfPorta.setText(Defs.MyPort);
                    jTfServer.setText(Defs.MyHost);
                    jTfUsuario.setText(Defs.MyUsername);
                } else if (evento.getItem().equals(Emuns.SQLServer.toString())) {
                    jTfDatabase.setText(Defs.SQlDataBase);
                    jTfPorta.setText(Defs.SQlPort);
                    jTfServer.setText(Defs.SQlHost);
                    jTfUsuario.setText(Defs.SQlUsername);
                } else if (evento.getItem().equals(Emuns.MongoDb.toString())) {
                    jTfDatabase.setText(Defs.MongoDBDataBase);
                    jTfPorta.setText(Defs.MongoDBPort);
                    jTfServer.setText(Defs.MongoDBHost);
                    jTfUsuario.setText(Defs.MongoDBUsername);
                }
                Sgbd = evento.getItem().toString();
            }
        });
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        try {
            ConectionTesteDTO conectionDto = refactorDTO();
            if (validarCampos()) {
                String resposta = Conection.RequestConectionApiPost(null, conectionDto, Emuns.TESTCONECTION);
                boolean resp = Boolean.parseBoolean(resposta);
                JOptionPane.showMessageDialog(null, resp ? "Teste efectuado com sucesso !"
                        : "Não foi possivel se conectar, verifique se a base de dados existe ou a password", "Status",
                        resp ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Precisa preencher os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        try {
            boolean isJar = false;
            if (fileRoot == null) {
                JOptionPane.showMessageDialog(null, "Nenhum ficheiro foi adicionado", "Erro", JOptionPane.ERROR_MESSAGE);
                return;
            }
            if (fileRoot.getName().contains("jar")) {
                File file = new File("Files.zip");
                isJar = true;
                generateByte(file);
            }
            ConectionTesteDTO conectionDto = refactorDTO();
            if (validarCampos()) {
                String resposta = Conection.RequestConectionApiPost(null, conectionDto, isJar ? Emuns.GenerateDatabaseByJar : Emuns.GenerateDatabase);
                boolean resp = Boolean.parseBoolean(resposta);
                JOptionPane.showMessageDialog(null, resp ? "Base de dados criada com sucesso !"
                        : "Erro ao criar a base de dados", "Status",
                        resp ? JOptionPane.INFORMATION_MESSAGE : JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, "Precisa preencher os campos", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    private void jCheckBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jCheckBox1ActionPerformed
        // TODO add your handling code here:
        jPasswordField1.setEchoChar(jCheckBox1.isSelected() ? '\0' : '*');
    }//GEN-LAST:event_jCheckBox1ActionPerformed

    private ConectionTesteDTO refactorDTO() {
        return new ConectionTesteDTO(
                jTfServer.getText(),
                jTfPorta.getText(),
                jTfDatabase.getText(),
                jTfUsuario.getText(),
                new String(jPasswordField1.getPassword()),
                Sgbd,
                bytes
        );
    }

    private boolean validarCampos() {
        if (jTfDatabase.getText() != null
                && jTfPorta.getText() != null
                && jTfServer.getText() != null
                && jTfUsuario.getText() != null) {
            return true;
        }
        return false;
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
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JCheckBox jCheckBox1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JFileChooser jFileChooser2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPasswordField jPasswordField1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTfDatabase;
    private javax.swing.JTextField jTfPorta;
    private javax.swing.JTextField jTfServer;
    private javax.swing.JTextField jTfUsuario;
    private javax.swing.JTree jTree1;
    private javax.swing.JButton jbtnAddFile;
    // End of variables declaration//GEN-END:variables
}
