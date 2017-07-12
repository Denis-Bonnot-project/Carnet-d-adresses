/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Level;
import java.util.logging.Logger;

/* @author Denis */
public class FichierAdresses {
    private BufferedReader bufR;
    private BufferedWriter bufW;
    private String urlFichier;
    
    public boolean ouvrirEnLecture(String chemin) throws IOException   {
        try {
            setUrlFichier(chemin);
            File fichier=new File(chemin);
            //fichier.createNewFile();

            bufR=new BufferedReader(new FileReader(fichier));
            bufW=null;
            return true;
        } 
        catch (FileNotFoundException ex) {
            System.out.println(urlFichier+": erreur à l'ouverture du fichier en lecture.");
            Logger.getLogger(FichierAdresses.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public boolean ouvrirEnEcriture(String chemin) {
        try {
            setUrlFichier(chemin);
            File fichier=new File(urlFichier);
            bufR=null;
            bufW=new BufferedWriter(new FileWriter(fichier));
            return true;
        } catch (IOException  ex) {
            System.out.println(urlFichier+": erreur à l'ouverture du fichier en écriture.");
            Logger.getLogger(FichierAdresses.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
    
    public String lire(){
        try {
            String nouvelleLigne=  bufR.readLine() ;
            return nouvelleLigne;
        } catch (IOException ex) {
            System.out.println(urlFichier+": erreur de lecture.");
            Logger.getLogger(FichierAdresses.class.getName()).log(Level.SEVERE, null, ex);
            return  null;
        }
    }
 
    public boolean ecrire(String txttmp){
        try {
            if (txttmp!=null){
                bufW.write(txttmp,0,txttmp.length());
                bufW.newLine();
            }
            return true;
        } catch (IOException ex) {
            System.out.println(urlFichier+": erreur d'écriture.");
            Logger.getLogger(FichierAdresses.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }
 
    public String [] extraireDonnees(String ligneFichier){
        if (ligneFichier!=null){
            StringTokenizer ligneSep=new StringTokenizer(ligneFichier,";");
            String chaine[] = new String[ligneSep.countTokens()];
            int i=0;
            while(ligneSep.hasMoreTokens()) {
                chaine[i]=ligneSep.nextToken();
                i++;
            }
            return chaine ;
        }
        else return null;
    }

    // Fermer le fichier ouvert en lecture ou en écriture
    public boolean fermer()  {
        try {
          if (bufR != null) bufR.close();
          else  if (bufW != null) bufW.close();
          return true;
        }
         // Si une erreur est détéctée (le fichier n'existe pas, n'est pas ouvert, ...)
        catch (IOException err) {
            // afficher le message d'erreur
           System.out.println(urlFichier+" : erreur  à la fermeture ");
           return false;
        }
    }    
    
    public BufferedReader getBufR() {
        return bufR;
    }

    public void setBufR(BufferedReader bufR) {
        this.bufR = bufR;
    }

    public BufferedWriter getBufW() {
        return bufW;
    }

    public void setBufW(BufferedWriter bufW) {
        this.bufW = bufW;
    }

    public String getUrlFichier() {
        return urlFichier;
    }

    public void setUrlFichier(String urlFichier) {
        this.urlFichier = urlFichier;
    }
    
}
