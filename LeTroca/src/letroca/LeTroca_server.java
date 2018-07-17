/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letroca;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;
import java.util.stream.Collectors;



/**
 *
 * @author gabriel
 */
public class LeTroca_server {
    
    public static String shuffle(String s) {
        List<Character> letters = s.chars().boxed().map(c -> (char) c.intValue()).collect(Collectors.toList());
        Collections.shuffle(letters);
        StringBuilder t = new StringBuilder(s.length());
        letters.forEach(t::append);
        return t.toString();
    }
    
    
    public static void main(String[] args) throws IOException {
                   
        int serverPort = 6666; // porta do servidor
        


         /* cria um socket e mapeia a porta para aguardar conexao */
        ServerSocket listenSocket = new ServerSocket(serverPort);
        
        
        ArrayList<Jogador> listaEspera = new ArrayList<>();
        
        while(true){
            Vector<String> palavras = new Vector<>();
            Vector<Integer> placar = new Vector<>();
            System.out.println("Servidor aguardando conexao ...\n");
                
            /* aguarda conexoes */
            Socket clientsSocket = listenSocket.accept();
            
            ObjectOutputStream out = new ObjectOutputStream(clientsSocket.getOutputStream());
            out.flush();
            ObjectInputStream in = new ObjectInputStream(clientsSocket.getInputStream());
            
            Jogador j = new Jogador(in, out);
            
            listaEspera.add(j);
            System.out.println("conectou");
            if(listaEspera.size() == 2){
                ArrayList<Jogador> jogadores = new ArrayList<>();
                
                jogadores.add(listaEspera.get(0));
                jogadores.add(listaEspera.get(1));
                
                listaEspera.clear();
                
                ArrayList<String> pa = OpenFileAndGetWords.getWords();
                for(String a : pa){
                    palavras.add(a);
                    System.out.println(a);
                }
                
                Protocol primeiro = new Protocol("", 0, 0, 0);
                placar.add(0);
                placar.add(0);
                ArrayList<String> pa2 = new ArrayList<>();
                for(String a : palavras){
                    pa2.add(a);
                }
                primeiro.setPalavras(pa2);
                primeiro.setLetras(shuffle(pa.get(pa.size() -1)));
                System.out.println(primeiro.getLetras());
                
                jogadores.get(0).getOut().writeObject(primeiro);
                jogadores.get(0).getOut().flush();
                
                jogadores.get(1).getOut().writeObject(primeiro);
                jogadores.get(1).getOut().flush();
                
                GamingReceivePlayer1 threadGamer1 = new GamingReceivePlayer1(jogadores, palavras, placar);
                GamingReceivePlayer2 threadGamer2 = new GamingReceivePlayer2(jogadores, palavras, placar);
                
                threadGamer1.start();
                threadGamer2.start();
            }
            
        }
        
        
    }
    
}
