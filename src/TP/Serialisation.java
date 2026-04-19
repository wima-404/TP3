package TP;

import TP.Commande;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

public class Serialisation {
    public static void main(String[] args) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(Commande.class);

        Produit p1 = new Produit(1, "Ordinateur", 5000);
        Produit p2 = new Produit(2, "Tablet", 3000);

        ArrayList<Produit> liste = new ArrayList<>();
        liste.add(p1);
        liste.add(p2);

        Commande cmd = new Commande(1, "Wiam belkentaoui", "12/03/2026", liste, 8000);

        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

        marshaller.marshal(cmd, System.out);
        marshaller.marshal(cmd, new File("Commande.xml"));
    }
}