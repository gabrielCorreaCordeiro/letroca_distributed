/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package letroca;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author gabriel
 */
public class OpenFileAndGetWords {
    
    public static ArrayList<String> getWords() throws FileNotFoundException{
           
        Random random = new Random();
        int a =  random.nextInt((5 - 1) + 1) + 1;
        
        
        File f = new File("/home/gabriel/Documentos/faculdade/Sistemas_distribuidos/atividades/LeTroca_distribuido/LeTroca/palavras/"+Integer.toHexString(a)+".txt");
        Scanner arq = new Scanner(f);
        ArrayList<String> temp = new ArrayList<>();
        while(arq.hasNext()){
           temp.add(arq.nextLine());

        }
        
        
        return temp;
    }
    
    
}
