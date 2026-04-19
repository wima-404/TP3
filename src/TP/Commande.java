package TP;

import TP.Produit;

import javax.xml.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlAccessorOrder(XmlAccessOrder.ALPHABETICAL)

public class Commande {

    @XmlAttribute
    private int ID;
    private String Nom_Client;
    @XmlElement(name="Date_Achat")
    private String Date;
    @XmlElementWrapper(name = "Produits")
    private List<Produit> produit;
    @XmlTransient
    private float Total;

    // Constructeur vide
    public Commande() {
        // Initialisation de la liste pour éviter les NullPointerException

    }

    // Constructeur avec paramètres

    public Commande(int ID, String nom_Client, String date, List<Produit> produit, float total) {
        this.ID = ID;
        Nom_Client = nom_Client;
        Date = date;
        this.produit = produit;
        Total = total;
    }
    public List<Produit> getProduit() {
        return produit;
    }

    // Getters et Setters

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getNom_Client() {
        return Nom_Client;
    }

    public void setNom_Client(String Nom_Client) {
        this.Nom_Client = Nom_Client;
    }

    public String getDate() {
        return Date;
    }

    public void setDate(String Date) {
        this.Date = Date;
    }



    public float getTotal() {
        return Total;
    }

    public void setTotal(float Total) {
        this.Total = Total;
    }


}