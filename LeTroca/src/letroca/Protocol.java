/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letroca;

import com.sun.org.apache.xml.internal.serializer.Serializer;
import com.sun.org.apache.xml.internal.serializer.SerializerBase;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author gabriel
 */
public class Protocol implements Serializable{
    private String palavra;
    private int tipoDeJogo;
    
    private int pontuacao1;
    private int pontuacao2;
    
    private boolean contains;
    private boolean sair;
    
    private ArrayList<String> palavras;
    private String letras;

    public ArrayList<String> getPalavras() {
        return palavras;
    }

    public void setPalavras(ArrayList<String> palavras) {
        this.palavras = palavras;
    }
    
    public Protocol(String palavra, int tipoDeJogo, int pontuacao1, int pontuacao2) {
        this.palavra = palavra;
        this.tipoDeJogo = tipoDeJogo;
        this.pontuacao1 = pontuacao1;
        this.pontuacao2 = pontuacao2;
        
        this.contains = false;
        this.sair = false;
        
    }

    public boolean isSair() {
        return sair;
    }

    public void setSair(boolean sair) {
        this.sair = sair;
    }
    
    
    
    public String getLetras() {
        return letras;
    }

    public void setLetras(String letras) {
        this.letras = letras;
    }
    
    public boolean isContains() {
        return contains;
    }

    public void setContains(boolean contains) {
        this.contains = contains;
    }
    
    public int getPontuacao1() {
        return pontuacao1;
    }

    public void setPontuacao1(int pontuacao1) {
        this.pontuacao1 = pontuacao1;
    }

    public int getPontuacao2() {
        return pontuacao2;
    }

    public void setPontuacao2(int pontuação2) {
        this.pontuacao2 = pontuação2;
    }
    
    public String getPalavra() {
        return palavra;
    }

    public void setPalavra(String palavra) {
        this.palavra = palavra;
    }

    public int getTipoDeJogo() {
        return tipoDeJogo;
    }

    public void setTipoDeJogo(int tipoDeJogo) {
        this.tipoDeJogo = tipoDeJogo;
    }
    
    
}
