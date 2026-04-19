package TP;

import TP.Commande;
import TP.Produit;

import java.io.File;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class Deserialisation {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Commande.class);
        Unmarshaller umarshaller = context.createUnmarshaller();
        Commande cmd = (Commande) umarshaller.unmarshal(new File("Commande.xml"));
        System.out.println("Debug - Nom_Client value: " + cmd.getNom_Client());
        System.out.println("Fait");
        System.out.println("ID:" + cmd.getID());
        System.out.println("Nom_Client:" + cmd.getNom_Client());
        System.out.println("Date:" + cmd.getDate());
        for (Produit p : cmd.getProduit()){
            System.out.println("ID: " + p.getID());
            System.out.println("Nom: " + p.getNom());
            System.out.println("Prix: " + p.getPrix());
        }
        System.out.println("Total:" + cmd.getTotal());
    }
}