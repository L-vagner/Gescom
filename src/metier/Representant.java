package metier;

import java.util.*;

public class Representant {

    private int idRepresentant;
    private String prenom;
    private String nom;
    private List<Client> lesClients;

    public Representant(int idRepresentant, String prenom, String nom, List<Client> lesClients) {
        setIdRepresentant(idRepresentant);
        setPrenom(prenom);
        setNom(nom);
        setLesClients(lesClients);
    }

    /**
     * Recherche un Client sur son id dans la
     * liste des clients.
     * Retourne le Client si trouvé, sinon retourne null
     *
     * @param idClient
     * @return Client
     */
    public Client getClientById(int idClient) {
        Client client = null;
        for (Client unClient : lesClients) {
            if (unClient.getIdClient() == idClient) {
                client = unClient;
            }
        }
        return client;
    }

    public int getIdRepresentant() {
        return idRepresentant;
    }

    public void setIdRepresentant(int idRepresentant) {
        this.idRepresentant = idRepresentant;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<Client> getLesClients() {
        return lesClients;
    }

    public void setLesClients(List<Client> lesClients) {
        this.lesClients = lesClients;
    }

    public void listerClients() {
        for (Client unClient : getLesClients()) {
            System.out.println(unClient.getIdClient()+" "+ unClient.getRaisonSociale());
            unClient.afficherCommandes();
            System.out.println();
        }
    }
}
