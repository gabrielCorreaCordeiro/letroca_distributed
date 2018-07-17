/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letroca;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

/**
 *
 * @author gabriel
 */
public class GamingReceivePlayer2 extends Thread{
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
    
    public GamingReceivePlayer2(ArrayList<Jogador> jogadores, Vector<String> palavras, Vector<Integer> placar) throws IOException{
        this.jogadores = jogadores;
        this.palavras = palavras;
        this.placar = placar;
        
        this.out = jogadores.get(1).getOut();
        out.flush();
        
        this.out2 = jogadores.get(0).getOut();
        out2.flush();
        
        this.in = jogadores.get(1).getIn();
        
    }
    
    @Override
    public void run() {
        Protocol aux;
        while(true){
            try {
                aux = (Protocol) in.readObject();
                System.out.println("chegou pra mim! 2");
                if(!aux.getPalavra().equals("")){
                    if(palavras.contains(aux.getPalavra())){
                        palavras.remove(aux.getPalavra());
                        aux.setContains(true);
                        int i = placar.get(1) +1;
                        placar.set(1, i);
                        aux.setPontuacao1(placar.get(1));
                        out.writeObject(aux);
                        out.flush();
                        aux.setPontuacao1(placar.get(0));
     
                        aux.setPontuacao2(placar.get(1));
                        out2.writeObject(aux);
                        out2.flush();
                    }
                    else if(aux.isSair()){
                        break;
                    }
                }
                
            } catch (IOException ex) {
                Logger.getLogger(GamingReceivePlayer2.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(GamingReceivePlayer2.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
    }
}
