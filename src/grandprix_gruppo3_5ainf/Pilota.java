/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grandprix_gruppo3_5ainf;

/**
 *
 * @author user
 */
public class Pilota extends Thread {
    String nome;
    String scuderia;
    int velocita;
    
    public Pilota (String nome, String scuderia){
        this.nome = nome;
        this.scuderia = scuderia;
    }
    
    public Pilota (String nome, int velocita){
        this.nome = nome;
        this.velocita = velocita;
    }
    
    @Override
    public void run(){
    }
    
    public int velocitaAuto (){
        String scuderiaSelezionata = this.scuderia;
        
        String scuderiaUtente = scuderiaSelezionata.toUpperCase();
        scuderiaUtente = scuderiaUtente.replaceAll(" ", "");
        
        System.out.println(scuderiaUtente);
        
        switch (scuderiaUtente) {
            case "FERRARI":
                velocita = 280;
                break;
            case "MERCEDES":
                velocita = 275;
                break;
            case "RED BULL":
                velocita = 300 ;
                break;
            case "MCLAREN":
                velocita = 265;
                break;
            case "ALPHATAURI":
                velocita = 260;
                break;
            case "ASTON MARTIN":
                velocita = 255;
                break;
            case "ALPINE":
                velocita = 250;
                break;
            case "ALFA ROMEO":
                velocita = 245;
                break;
            case "HAAS":
                velocita = 240;
                break;
            case "WILLIAMS":
                velocita = 235;
                break;
            default:
                System.out.println("Scuderia non riconosciuta, velocità non definita.");
                break;
        }
        return velocita;
    }
    
}
