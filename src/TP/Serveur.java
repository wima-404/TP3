package TP;

import javax.xml.ws.Endpoint;

public class Serveur {
    public static void main(String[] args) {
        Endpoint.publish("http://localhost:8080/CommandeWS", new Commande_Service());
        System.out.println("Web Service démarré sur http://localhost:8080/CommandeWS?wsdl");
    }
}
