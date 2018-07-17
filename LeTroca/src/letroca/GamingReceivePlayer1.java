/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letroca;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author gabriel
 */
public class GamingReceivePlayer1 extends Thread{
    ObjectInputStream in;
    ObjectOutputStream out;
    
    ObjectOutputStream out2;
    
    
    ArrayList<Jogador> jogadores;
    Vector<String> palavras;
    Vector<Integer> placar;
    /**
     *
     * @param jogadores
     * @param palavras
     */
    public GamingReceivePlayer1(ArrayList<Jogador> jogadores, Vector<String> palavras, Vector<Integer>  placar) throws IOException{
        this.jogadores = jogadores;
        this.palavras = palavras;
        this.placar = placar;
        
        this.out = jogadores.get(0).getOut();
        out.flush();
        this.out2 = jogadores.get(1).getOut();
        out2.flush();
        this.in = jogadores.get(0).getIn();
    }
    
    @Override
    public void run() {
        
        
        while(true){
            try {
                Protocol aux = (Protocol) in.readObject();
                System.out.println("chegou pra mim! 1");
                if( !aux.getPalavra().equals("")){
                    if(palavras.contains(aux.getPalavra())){
                        palavras.remove(aux.getPalavra());
                        aux.setContains(true);
                        int i = placar.get(0) +1;
                        placar.set(0, i);
                        
                        aux.setPontuacao1(placar.get(0));
                        out.writeObject(aux);
                        out.flush();
                        
                        aux.setPontuacao1(placar.get(1));
                        
                        aux.setPontuacao2(placar.get(0));
                        out2.writeObject(aux);
                        out2.flush();
                    }
                }else if(aux.isSair()){
                    
                    break;
                }
                
                
                
            } catch (IOException ex) {
                Logger.getLogger(GamingReceivePlayer1.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GamingReceivePlayer1.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }
        
    }
}
