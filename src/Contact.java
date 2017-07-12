/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
/*  @author Denis */


import javax.swing.ImageIcon;

public class Contact extends javax.swing.JPanel {

    /** Creates new form Contact */

    public Contact(String [] liste, int id) {
          
        setVisible(true);
        initComponents();
        setListeInfos(liste);
        setId(id);
        afficheInfos();
        colorierIdPair(id);
        
    }
 
    // Méthodes métier
    
    private void afficheInfos(){
        prenomLbl.setText(listeInfos[0]);
        nomLbl.setText(listeInfos[1]);
        affichePhoto();
    }
    
    private void affichePhoto() throws NullPointerException {
        // Créer une icône
        ImageIcon iconPhoto;
        if (listeInfos[2].equals("/images/photo0.png") || listeInfos[2].equals("null")) {
            java.net.URL imageURL = CarnetDadresses.class.getResource("/images/photo0.png");
            iconPhoto = new ImageIcon(imageURL);
        }
        else {
            String imageURL=listeInfos[2] ;
            iconPhoto = new ImageIcon(imageURL);
        }

        java.awt.Image imagePhoto=iconPhoto.getImage();
        imagePhoto=imagePhoto.getScaledInstance(-50, 50,java.awt.Image.SCALE_SMOOTH);
        iconPhoto.setImage(imagePhoto);
        photoLbl.setIcon(iconPhoto);
    }

    
    private void colorierIdPair(int indice){
        if (indice%2 == 0){
            setBackground(new java.awt.Color(153, 153, 153));
        }
        photoLbl.setOpaque(false);
        prenomLbl.setOpaque(false);   
        nomLbl.setOpaque(false);
    }


     /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        photoLbl = new javax.swing.JLabel();
        prenomLbl = new javax.swing.JLabel();
        nomLbl = new javax.swing.JLabel();

        setMaximumSize(new java.awt.Dimension(100, 50));
        setMinimumSize(new java.awt.Dimension(50, 50));
        setPreferredSize(new java.awt.Dimension(400, 50));
        setRequestFocusEnabled(false);
        setLayout(new java.awt.GridLayout(1, 3));

        photoLbl.setMaximumSize(new java.awt.Dimension(10, 10));
        photoLbl.setMinimumSize(new java.awt.Dimension(10, 10));
        photoLbl.setPreferredSize(new java.awt.Dimension(20, 20));
        add(photoLbl);

        prenomLbl.setText("prénom");
        prenomLbl.setMaximumSize(new java.awt.Dimension(40, 16));
        prenomLbl.setMinimumSize(new java.awt.Dimension(40, 16));
        prenomLbl.setPreferredSize(new java.awt.Dimension(40, 16));
        add(prenomLbl);

        nomLbl.setText("nom");
        add(nomLbl);
    }// </editor-fold>//GEN-END:initComponents

    private String nom, prenom, url;
    private String [] listeInfos;
    private int id;

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel nomLbl;
    private javax.swing.JLabel photoLbl;
    private javax.swing.JLabel prenomLbl;
    // End of variables declaration//GEN-END:variables

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String[] getListeInfos() {
        return listeInfos;
    }

    public void setListeInfos(String[] listeInfos) {
        this.listeInfos = listeInfos;
    }

}
