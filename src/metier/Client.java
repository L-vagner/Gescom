package metier;

import java.util.*;

public class Client {

    private int idClient;
    private String raisonSociale;
    private double caClient;
    private Categorie uneCategorie;
    private List<Commande> lesCommandes;

    public int getIdClient() {
        return idClient;
    }

    public void setIdClient(int idClient) {
        this.idClient = idClient;
    }

    public String getRaisonSociale() {
        return raisonSociale;
    }

    public void setRaisonSociale(String raisonSociale) {
        this.raisonSociale = raisonSociale;
    }

    public double getCaClient() {
        cumulCA();
        return caClient;
    }

    public void setCaClient(double caClient) {
        this.caClient = caClient;
    }

    public Categorie getUneCategorie() {
        return uneCategorie;
    }

    public void setUneCategorie(Categorie uneCategorie) {
        this.uneCategorie = uneCategorie;
    }

    public List<Commande> getLesCommandes() {
        return lesCommandes;
    }

    public void setLesCommandes(List<Commande> lesCommandes) {
        this.lesCommandes = lesCommandes;
    }

    public Client(int idClient, String raisonSociale, Categorie uneCategorie) {
        setIdClient(idClient);
        setRaisonSociale(raisonSociale);
        setUneCategorie(uneCategorie);
    }

    /**
     * Ajoute une commande à la liste des commandes
     * du client. Prendre la précaution de vérifier
     * que la liste a bien été instanciée
     *
     * @param uneCommande
     */
    public void ajouterCommande(Commande uneCommande) {
        if (getLesCommandes() == null) {
            setLesCommandes(new ArrayList<Commande>());
        }
        if (!getLesCommandes().contains(uneCommande)) {
            this.lesCommandes.add(uneCommande);
        }
    }

    /**
     * Affecte la somme des valorisations des commandes
     * au CA du client. Prendre la précaution de
     * l'initialiser avant de commencer
     */
    public void cumulCA() {
        double caClient = 0.0;
        for (Commande uneCommande : getLesCommandes()) {
            caClient += uneCommande.valoriserCommande();

        }
        setCaClient(caClient);
    }

    /**
     * Recherche une commande sur son numéro en
     * parcourant la liste des commandes, Retourne
     * une Commande si trouvée, sinon retourne null
     *
     * @param idCommande
     * @return Commande
     */
    public Commande getCommandeById(int idCommande) {
        Commande commande = null;
        for (Commande uneCommande : getLesCommandes()) {
            if (uneCommande.getIdCommande() == idCommande) {
                commande = uneCommande;
                break;
            }
        }
        return commande;
    }

    /**
     * Retire une commande la liste des commandes.
     * Remarque : en supprimant une commande on supprime
     * aussi ses lignes (Composition)
     *
     * @param uneCommande
     */
    public void supprimerCommande(Commande uneCommande) {
        lesCommandes.remove(uneCommande);
    }

    public void afficherCommandes() {
        for (Commande uneCommande : getLesCommandes()) {
            uneCommande.afficherCommande();

        }
    }


}
