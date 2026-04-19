package TP2;

import java.util.List;
// Importation des classes générées à partir du WSDL
import TP.Commande;
import TP.Produit;
import TP.Commande_Service;
import TP.Serveur;

public class Client {

    public static void main(String[] args) {
        try {
            // Initialisation du service et du port
            Commande_Service service = new Commande_Service();
            Serveur port = service.getCommande_Service();

            // --- Création des Produits ---
            Produit p1 = new Produit();
            p1.setID(1);
            p1.setNom("PC");
            p1.setPrix(1200);

            Produit p2 = new Produit();
            p2.setID(2);
            p2.setNom("Souris");
            p2.setPrix(50);

            // --- Création de la Commande ---
            Commande c = new Commande();
            c.setID(1);
            c.setNom_Client("Wiam blk");

            // Solution adaptée pour la liste des produits (Wrapper JAXB)
            Commande.Produit listeProduits = new Commande.Produit();
            listeProduits.get().add(p1);
            listeProduits.getProduit().add(p2);
            c.setProduit(listeProduits);

            // --- Appel du Service Web ---
            String resultat = port.ajouterCommande(c);
            System.out.println(resultat);

            System.out.println("=== Liste des commandes ===");

            // Récupération de la liste depuis le serveur
            List<Commande> commandes = port.listerCommandes();

            for (Commande cmd : commandes) {
                System.out.println("Commande ID: " + cmd.getID());
                System.out.println("Client: " + cmd.getNom_Client());

                if (cmd.getProduit() != null) {
                    try {
                        // Parcours de la liste des produits de la commande
                        for (Produit p : cmd.getProduit().getProduit()) {
                            System.out.println(" - " + p.getNom() + " : " + p.getPrix());
                        }
                    } catch (Exception e) {
                        // Bloc de secours (identique dans votre image originale)
                        for (Produit p : cmd.getProduit().getProduit()) {
                            System.out.println(" - " + p.getNom() + " : " + p.getPrix());
                        }
                    }
                }
                System.out.println("---------------------------");
            }

        } catch (Exception e) {
            // Affichage de l'erreur en cas de problème de connexion ou autre
            e.printStackTrace();
        }
    }
}