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

   
    public static void main(String[] args) {
        
        /**
         * dichiarazione delle variabili
         */
        
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
        
        Pilota pilotaUser = new Pilota(username, sceltaScuderia);
        
        int velocitaUser = pilotaUser.velocitaAuto();
        
        System.out.println("con quante macchine vorresti gareggiare?\n");
        try {
           String numero = keyboard.readLine();
           nMacchine = Integer.valueOf(numero).intValue();
        } catch (IOException ex) {
           System.err.println("errore in input!");
        }
        
        
        /**
         * si istanzia un array di tipo Pilota, di grandezza pari al numero di automobili
         */
        Pilota [] piloti = new Pilota[nMacchine];
        
        /**
         * questo ciclo consente di istanziare tanti oggetti della classe Pilota quanti sono richiesti
         * dal giocatore, assegnando come nome una stringa concatenata alla variabile i, che incrementa
         * ad ogni ciclo effettuato, mentre come velocità assegna un valore randomico che va da 200 a 310
         */
        for (int i = 0; i < nMacchine; i++){
            String nomeCPU = "giocatore" + i;
            int velocitaCPU = (int)Math.floor(Math.random() * (200 - 310 + 1) + 200);
            piloti[i] = new Pilota(nomeCPU, velocitaCPU);
        }
        
        
            
    }
    
}
