package TP;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;

@XmlAccessorType(XmlAccessType.FIELD)
public class Produit {
    @XmlAttribute
    private int ID;
    private String Nom;
    @XmlElement(name="Prix_Produit")
    private float Prix;

    public Produit() {
    }

    public Produit(int ID, String nom, float prix) {
        this.ID = ID;
        Nom = nom;
        Prix = prix;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom() {
        return Nom;
    }

    public void setNom(String nom) {
        Nom = nom;
    }

    public float getPrix() {
        return Prix;
    }

    public void setPrix(float prix) {
        Prix = prix;
    }
}