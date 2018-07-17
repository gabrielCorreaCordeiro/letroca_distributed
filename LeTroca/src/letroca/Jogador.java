/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letroca;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/**
 *
 * @author gabriel
 */
public class Jogador {
    ObjectInputStream in;
    ObjectOutputStream out;

    Jogador(ObjectInputStream in, ObjectOutputStream out){
        this.in = in;
        this.out = out;
    }
    
    public ObjectInputStream getIn() {
        return in;
    }

    public void setIn(ObjectInputStream in) {
        this.in = in;
    }

    public ObjectOutputStream getOut() {
        return out;
    }

    public void setOut(ObjectOutputStream out) {
        this.out = out;
    }
    
    
}
