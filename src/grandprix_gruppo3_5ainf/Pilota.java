/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix_gruppo3_5ainf;

import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Pilota extends Thread {
    String nome;
    String scuderia;
    int velocita;
    Circuito circuito;
    ArrayList<String> classifica = new ArrayList<String>();
    
    /**
     * 
     * @param nome
     * @param scuderia
     * 
     */
    
    public Pilota (String nome, String scuderia){
        this.nome = nome;
        this.scuderia = scuderia;
    }
    
    public Pilota (String nome, String scuderia, int velocita, Circuito circuito){
        this.nome = nome;
        this.scuderia = scuderia;
        this.velocita = velocita;
        this.circuito = circuito;
    }
    
    public Pilota (String nome, int velocita, Circuito circuito){
        this.nome = nome;
        this.velocita = velocita;
        this.circuito = circuito;
    }
    
    
    public ArrayList getClassifica(){
        return classifica;
    }

    
    @Override
    public void run(){
        gareggia(circuito);
    }
    
    
    
    
    /**
     * 
     * @return velocita
     * Il metodo riceve il nome della scuderia scelto dal giocatore, trasforma
     * i caratteri della stringa in caratteri maiuscoli, rimuove eventuali spazi
     * inseriti dall'utente e successivamente ricava la velocità della macchina, ritornando
     * il valore di essa
     */
    public int velocitaAuto (){
        String scuderiaSelezionata = this.scuderia;
        
        String scuderiaUtente = scuderiaSelezionata.toUpperCase();
        scuderiaUtente = scuderiaUtente.replaceAll(" ", "");
        
        System.out.println(scuderiaUtente);
        
        switch (scuderiaUtente) {
            case "FERRARI" -> velocita = 280;
            case "MERCEDES" -> velocita = 275;
            case "REDBULL" -> velocita = 300 ;
            case "MCLAREN" -> velocita = 265;
            case "ALPHATAURI" -> velocita = 260;
            case "ASTONMARTIN" -> velocita = 255;
            case "ALPINE" -> velocita = 250;
            case "ALFAROMEO" -> velocita = 245;
            case "HAAS" -> velocita = 240;
            case "WILLIAMS" -> velocita = 235;
            default -> System.out.println("Scuderia non riconosciuta, velocità non definita.");
        }
        return velocita;
    }
    
    /**
     *
     * @param circuito
     */
    public void gareggia(Circuito circuito){
        int progressione = 0;
        float percentage = 0;
        int totDistanza;
        totDistanza = circuito.lunghezza * circuito.nGiri;
        while(progressione < totDistanza){
            try {
                sleep(1000);
            } catch (InterruptedException ex) {
                Logger.getLogger(Pilota.class.getName()).log(Level.SEVERE, null, ex);
            }
            progressione += this.velocita;
            
            if(progressione > totDistanza){
                progressione = totDistanza;
            }
            
            percentage = (progressione*100)/totDistanza;
            
            Pilota.stampa(this.nome, progressione, percentage, classifica);
            
        }
        
    }
    
    public void classifica(){
        System.out.println("dddddddddddddddddddddd\n");
        for (int i = 0; i < classifica.size(); i++) {
            System.out.println(classifica.get(i));
        }
    }
    
    public static synchronized void stampa(String nome, int progressione, float percentuale, ArrayList classifica){
        System.out.println("----------------------");
            System.out.println("Pilota: " + nome);
            System.out.println("Progressione: " + progressione);
            System.out.println("Percentuale di completamento: " + percentuale);
            if(percentuale == 100){
                System.out.println(nome + " HA TERMINATO LA GARA\n"); 
                classifica.add(nome);
            }
        System.out.println("-----------------------");
        
    }
    
    
    
}
