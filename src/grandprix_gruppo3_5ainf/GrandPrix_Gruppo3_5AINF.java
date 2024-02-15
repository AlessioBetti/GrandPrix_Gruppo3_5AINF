/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grandprix_gruppo3_5ainf;

import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author user
 */
public class GrandPrix_Gruppo3_5AINF {

    /**
     * @param args the command line arguments
     */
   
    public static void main(String[] args) {
        
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(input);
        int lunghezzaTracciato;
        int nPitstop;
        int nGiri;
        int nMacchine = 0;
        String username = "";
        String password = "";
        String sceltaScuderia = "";
        Random random = new Random();
        
        
        System.out.println("Ciao! Benvenuto al Grand Prix del 2024!\n\n");
        System.out.println("Inserisci le tue credenziali di accesso:\n");
        System.out.println("Username: \n");
        try {
            username = keyboard.readLine();
        } catch (IOException ex) {
           System.err.println("errore in input!");
        }
        
        System.out.println("Password:\n\n");
        try {
            password = keyboard.readLine();
        } catch (IOException ex) {
           System.err.println("errore in input!");
        }
        
        Giocatore giocatore1 = new Giocatore(username, password);
        
        System.out.println("DEFINIZIONE DEL TRACCIATO\n");       
        System.out.println("Inserisci quanto desideri che il tracciato sia lungo\n");
        System.out.println("Unita' di misura: metri\n");

        try {
            String numero = keyboard.readLine();
            lunghezzaTracciato = Integer.valueOf(numero).intValue();
        } catch (IOException ex) {
           System.err.println("errore in input!");
        }
        
        System.out.println("Numero di giri: \n");
        
        try {
            String numero = keyboard.readLine();
            nGiri = Integer.valueOf(numero).intValue();
        } catch (IOException ex) {
           System.err.println("errore in input!");
        }
        
        System.out.println("Numero di pitstop: \n");
        
        try {
            String numero = keyboard.readLine();
            nPitstop = Integer.valueOf(numero).intValue();
        } catch (IOException ex) {
           System.err.println("errore in input!");
        }
        
        System.out.println("__________________________________________________________________________ \n");
        System.out.println("SELEZIONE AUTOMOBILI\n");
        System.out.println("Quale scuderia vuoi utilizzare? \n");
        
        try {
            sceltaScuderia = keyboard.readLine();
        } catch (IOException ex) {
           System.err.println("errore in input!");
        }
        
        Pilota pilotaUser = new Pilota(username, sceltaScuderia);
        
        int velocitaUser = pilotaUser.velocitaAuto();
        
        System.out.println("con quante macchine vorresti gareggiare?\n");
        try {
           String numero = keyboard.readLine();
           nMacchine = Integer.valueOf(numero).intValue();
        } catch (IOException ex) {
           System.err.println("errore in input!");
        }
        
        Pilota [] piloti = new Pilota[nMacchine];
        
        for (int i = 0; i < nMacchine; i++){
            String nomeCPU = "giocatore" + i;
            int velocitaCPU = random.nextInt(310);
            piloti[i] = new Pilota(nomeCPU, velocitaCPU);
        }
        
        
            
    }
    
}
