/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package grandprix_gruppo3_5ainf;

import java.io.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.Random;

/**
 *
 * @author user
 */
public class GrandPrix_Gruppo3_5AINF {

   
    public static void main(String[] args) {
        
        /**
         * dichiarazione delle variabili
         */
        
        InputStreamReader input = new InputStreamReader(System.in);
        BufferedReader keyboard = new BufferedReader(input);
        int lunghezzaTracciato = 0;
        int nPitstop = 0;
        int nGiri = 0;
        int nMacchine = 0;
        String username = "";
        String password = "";
        String sceltaScuderia = "";
        Random random = new Random();
        ArrayList<String> classificaFinale = new ArrayList<String>();
        
        
        /**
         * inserimento credenziali
         */
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
        
        
        /**
         * porzione dedicata alla selezione delle caratteristiche del circuito
         */
        
        System.out.println("DEFINIZIONE DEL TRACCIATO\n");       
        System.out.println("Inserisci quanto desideri che il tracciato sia lungo\n");
        System.out.println("Unita' di misura: metri\n");

        try {
            String numero = keyboard.readLine();
            lunghezzaTracciato = Integer.parseInt(numero);
        } catch (IOException ex) {
           System.err.println("errore in input!");
        }
        
        System.out.println("Numero di giri: \n");
        
        try {
            String numero = keyboard.readLine();
            nGiri = Integer.parseInt(numero);
        } catch (IOException ex) {
           System.err.println("errore in input!");
        }
        
        System.out.println("Numero di pitstop: \n");
        
        try {
            String numero = keyboard.readLine();
            nPitstop = Integer.parseInt(numero);
        } catch (IOException ex) {
           System.err.println("errore in input!");
        }
        
        
        
        /**
         * selezione della scuderia con cui gareggiare da parte dell'utente e anche 
         * del numero di macchine contro cui gareggiare
         */
        System.out.println("__________________________________________________________________________ \n");
        System.out.println("SELEZIONE AUTOMOBILI\n");
        System.out.println("Quale scuderia vuoi utilizzare? \n");
        
        try {
            sceltaScuderia = keyboard.readLine();
        } catch (IOException ex) {
           System.err.println("errore in input!");
        }
        
        Pilota pilotaSetter = new Pilota(username, sceltaScuderia);
        
        /*
        pilotaSetter.setLunghezza(lunghezzaTracciato);
        pilotaSetter.setGiri(nGiri);
        pilotaSetter.setPitStop(nPitstop);*/
        
        int velocitaUser = pilotaSetter.velocitaAuto();
        
        
        
        
        
        System.out.println("con quante macchine vorresti gareggiare?\n");
        try {
           String numero = keyboard.readLine();
           nMacchine = Integer.parseInt(numero);
        } catch (IOException ex) {
           System.err.println("errore in input!");
        }
        
        Circuito c1 = new Circuito(lunghezzaTracciato, nGiri, nPitstop, nMacchine);
        Pilota pilotaUser = new Pilota (username, sceltaScuderia, velocitaUser, c1);
        /**
         * si istanzia un array di tipo Pilota, di grandezza pari al numero di automobili
         */
        Pilota [] piloti = new Pilota[nMacchine];
        
        /**
         * questo ciclo consente di istanziare tanti oggetti della classe Pilota quanti sono richiesti
         * dal giocatore, assegnando come nome una stringa concatenata alla variabile i, che incrementa
         * ad ogni ciclo effettuato, mentre come velocità assegna un valore randomico che va da 220 a 310
         */
        System.out.println("\nLista piloti:\n");
        for (int i = 0; i < nMacchine; i++){
            String nomeCPU = "pilotaCPU-" + (i+1);
            int velocitaCPU = random.nextInt(100)+210;
            piloti[i] = new Pilota(nomeCPU, velocitaCPU, c1);
            System.out.println(nomeCPU + " - " + velocitaCPU);
        }
        
        
        /**
         * inizio della gara
         * attraverso questo ciclo, viene iniziata l'esecuzione di ogni thread della classe Pilota
         */
        System.out.println("\nINIZIO DELLA COMPETIZIONE!\n");
        pilotaUser.start(); 
        for (int i = 0; i < nMacchine; i++){
            piloti[i].start();
        }
        
        try {
            pilotaUser.join();
        } catch (InterruptedException ex) {
            Logger.getLogger(GrandPrix_Gruppo3_5AINF.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        for (int i = 0; i < nMacchine; i++){
            try {
                piloti[i].join();
            } catch (InterruptedException ex) {
                Logger.getLogger(GrandPrix_Gruppo3_5AINF.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        
        
        
        
        System.out.println("\nCLASSIFICA FINALE\n");
        pilotaSetter.classifica(); 
                
        
        
    }
    
}
