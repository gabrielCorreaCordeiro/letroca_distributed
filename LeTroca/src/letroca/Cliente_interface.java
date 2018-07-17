/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letroca;

import java.awt.event.KeyEvent;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

/**
 *
 * @author gabriel
 */
public class Cliente_interface extends javax.swing.JFrame {
    static Socket clientSocket = null; // socket do cliente
    static int serverPort = 6666;
    static InetAddress serverAddr = null;
    static String apelido = "";
    static ObjectOutputStream out;
    static ObjectInputStream in;
    
    
    
    public Cliente_interface() {
        initComponents();
        ThreadReader tr = new ThreadReader(in);
        tr.setDaemon(true);
        tr.start();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Frame = new javax.swing.JFrame();
        jDialog1 = new javax.swing.JDialog();
        jDialog2 = new javax.swing.JDialog();
        enviarPalavra = new javax.swing.JTextField();
        enviar = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        entradaPalavras = new javax.swing.JTextArea();
        sair = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        pontosJogador1 = new javax.swing.JTextPane();
        jScrollPane3 = new javax.swing.JScrollPane();
        pontosJogador2 = new javax.swing.JTextPane();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        letras = new javax.swing.JTextPane();

        javax.swing.GroupLayout FrameLayout = new javax.swing.GroupLayout(Frame.getContentPane());
        Frame.getContentPane().setLayout(FrameLayout);
        FrameLayout.setHorizontalGroup(
            FrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        FrameLayout.setVerticalGroup(
            FrameLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog1Layout = new javax.swing.GroupLayout(jDialog1.getContentPane());
        jDialog1.getContentPane().setLayout(jDialog1Layout);
        jDialog1Layout.setHorizontalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog1Layout.setVerticalGroup(
            jDialog1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jDialog2Layout = new javax.swing.GroupLayout(jDialog2.getContentPane());
        jDialog2.getContentPane().setLayout(jDialog2Layout);
        jDialog2Layout.setHorizontalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        jDialog2Layout.setVerticalGroup(
            jDialog2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        enviarPalavra.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarPalavraActionPerformed(evt);
            }
        });
        enviarPalavra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                enviarPalavraKeyPressed(evt);
            }
        });

        enviar.setText("Enviar");
        enviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                enviarActionPerformed(evt);
            }
        });

        entradaPalavras.setColumns(20);
        entradaPalavras.setRows(10);
        entradaPalavras.setEditable(false);
        jScrollPane1.setViewportView(entradaPalavras);

        sair.setText("Sair");
        sair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                sairActionPerformed(evt);
            }
        });

        jLabel1.setText("Você:");

        jLabel2.setText("Adversário:");

        jScrollPane2.setViewportView(pontosJogador1);

        jScrollPane3.setViewportView(pontosJogador2);

        jLabel3.setText("Letras:");

        jScrollPane4.setViewportView(letras);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 502, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(enviarPalavra, javax.swing.GroupLayout.PREFERRED_SIZE, 273, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(enviar, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(44, 44, 44)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, 93, Short.MAX_VALUE)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(2, 2, 2)
                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addGap(1, 1, 1)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(259, 259, 259)
                                .addComponent(sair, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1)
                        .addContainerGap())
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(sair))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jLabel2))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 6, Short.MAX_VALUE)))
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(jLabel3))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 24, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(257, 257, 257)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(enviarPalavra, javax.swing.GroupLayout.DEFAULT_SIZE, 34, Short.MAX_VALUE)
                            .addComponent(enviar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void enviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarActionPerformed
        String palavra = enviarPalavra.getText();
        enviarPalavra.setText("");
        int pontuacao1 = Integer.parseInt(pontosJogador1.getText());
        int pontuacao2 = Integer.parseInt(pontosJogador2.getText());
        Protocol novo = new Protocol(palavra, 0, pontuacao1, pontuacao2);

        try {
            out.writeObject(novo);
        } catch (IOException ex) {
            Logger.getLogger(Cliente_interface.class.getName()).log(Level.SEVERE, null, ex);
        }

        enviarPalavra.setText("");
    }//GEN-LAST:event_enviarActionPerformed

    private void sairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_sairActionPerformed
        Protocol aux = new Protocol("",0,0,0);
        aux.setSair(true);
        try {
            out.writeObject(aux);
        } catch (IOException ex) {
            Logger.getLogger(Cliente_interface.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        System.exit(0);
    }//GEN-LAST:event_sairActionPerformed

    private void enviarPalavraKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_enviarPalavraKeyPressed

        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            String palavra = enviarPalavra.getText();
            enviarPalavra.setText("");
            int pontuacao1 = Integer.parseInt(pontosJogador1.getText());
            int pontuacao2 = Integer.parseInt(pontosJogador2.getText());
            Protocol novo = new Protocol(palavra, 0, pontuacao1, pontuacao2);

            try {
                out.writeObject(novo);
            } catch (IOException ex) {
                Logger.getLogger(Cliente_interface.class.getName()).log(Level.SEVERE, null, ex);
            }

            enviarPalavra.setText("");

        }

    }//GEN-LAST:event_enviarPalavraKeyPressed

    private void enviarPalavraActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_enviarPalavraActionPerformed

    }//GEN-LAST:event_enviarPalavraActionPerformed
    

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
        try {

            String ip = "";
            ip = JOptionPane.showInputDialog("Qual o Ip do servidor?");
            serverAddr = InetAddress.getByName(ip);

            clientSocket = new Socket(serverAddr,serverPort);
           
            out = new ObjectOutputStream(clientSocket.getOutputStream());
            out.flush();
            
            in = new ObjectInputStream(clientSocket.getInputStream());
           

            
           
        } catch (UnknownHostException ex) {
            Logger.getLogger(Cliente_interface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Cliente_interface.class.getName()).log(Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                 new Cliente_interface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFrame Frame;
    private javax.swing.JTextArea entradaPalavras;
    private javax.swing.JButton enviar;
    private javax.swing.JTextField enviarPalavra;
    private javax.swing.JDialog jDialog1;
    private javax.swing.JDialog jDialog2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTextPane letras;
    private javax.swing.JTextPane pontosJogador1;
    private javax.swing.JTextPane pontosJogador2;
    private javax.swing.JButton sair;
    // End of variables declaration//GEN-END:variables


public void criarEEditarPontos(ArrayList<String> palavrasUsadas, ArrayList<String> palavras, int i){
        entradaPalavras.setText("");
        String pontos = "";
        for(String palavra2 : palavras){
            pontos = "";

            if(palavrasUsadas.contains(palavra2) ){
                pontos = palavra2;
            }else{
                for(int j=0; j < palavra2.length(); j++){
                    pontos = pontos+"-";
                }
                     
            }

            
            entradaPalavras.append(pontos+"\n");
        }
        
        
}
    
public class ThreadReader extends Thread{
    ObjectInputStream in;
    ArrayList<String> p;
    ArrayList<String> palavrasUsadas;
    
    
    public ThreadReader(ObjectInputStream in) {
        this.in = in;
        palavrasUsadas = new ArrayList<>();
    }

    @Override
    public void run(){
        
     
            
        try {
            Protocol primeiro = (Protocol) in.readObject();
            criarEEditarPontos(palavrasUsadas, primeiro.getPalavras(), 0);
            p = primeiro.getPalavras();
            letras.setText(primeiro.getLetras());
            pontosJogador1.setText(Integer.toString(primeiro.getPontuacao1()));
            pontosJogador2.setText(Integer.toString(primeiro.getPontuacao2()));
        } catch (IOException ex) {
            Logger.getLogger(Cliente_interface.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Cliente_interface.class.getName()).log(Level.SEVERE, null, ex);
        }

            
            

        
        
        
        while(true){
          
              
            try {
                Protocol primeiro = (Protocol) in.readObject();
                if(primeiro.getPontuacao1() == 10){
                   JOptionPane.showMessageDialog(Frame,"Você ganhou!");
                   Protocol aux = new Protocol("",0,0,0);
                   aux.setSair(true);
                   try {
                        out.writeObject(aux);
                   } catch (IOException ex) {
                        Logger.getLogger(Cliente_interface.class.getName()).log(Level.SEVERE, null, ex);
                   }

                   System.exit(0);
                }else if(primeiro.getPontuacao2() == 10){
                    JOptionPane.showMessageDialog(Frame,"Você Perdeu!");
                    Protocol aux = new Protocol("",0,0,0);
                    aux.setSair(true);
                    try {
                         out.writeObject(aux);
                    } catch (IOException ex) {
                         Logger.getLogger(Cliente_interface.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    System.exit(0);
                
                }
                if(primeiro.isContains()){
                    palavrasUsadas.add(primeiro.getPalavra());
                    criarEEditarPontos(palavrasUsadas, p, 1);
                    pontosJogador1.setText(Integer.toString(primeiro.getPontuacao1()));
                    pontosJogador2.setText(Integer.toString(primeiro.getPontuacao2()));
                }
            } catch (IOException ex) {
                Logger.getLogger(Cliente_interface.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Cliente_interface.class.getName()).log(Level.SEVERE, null, ex);
            }

                

                

        
        }   
    }
}


}