package metier;

import dao.BdD;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.*;

public class Commande {

    private int idCommande;
    private Date dateCommande;
    private List<Ligne> lesLignes;

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public String getDateCommande() {
        DateFormat df = new SimpleDateFormat("dd/MM/yyyy");
        return df.format(dateCommande);
    }

    public void setDateCommande(Date dateCommande) {
        this.dateCommande = dateCommande;
    }

    public List<Ligne> getLesLignes() {
        return lesLignes;
    }

    public void setLesLignes(List<Ligne> lesLignes) {
        this.lesLignes = lesLignes;
    }

    public Commande(int idCommande, Date dateCommande) {
        setIdCommande(idCommande);
        setDateCommande(dateCommande);
    }

    /**
     * Ajoute une ligne à une commande.
     * Si la liste des lignes n'est pas instanciée,
     * l'instancier
     * Si l'article n'est pas dans la liste des
     * lignes, créer la ligne et l'ajouter à la liste
     *
     * @param unArticle
     * @param qteCde
     */
    public void ajouterLigne(Article unArticle, int qteCde) {
        if (getLesLignes() == null) {
            setLesLignes(new ArrayList<Ligne>());
        }
        Ligne uneLigne = new Ligne(unArticle, qteCde);
        this.lesLignes.add(uneLigne);
    }

    /**
     * Supprime la ligne passée en paramètre
     *
     * @param ligneASupprimer Ligne à supprimer
     */
    public void supprimerLigne(Ligne ligneASupprimer) {
        this.lesLignes.remove(ligneASupprimer);
    }

    /**
     * Recherche la ligne contenant l'article ayant
     * l'id passé en paramètre.
     * Utiliser la méthode equals() pour comparer deux objets.
     *
     * @param idArticle identifiant de l'article à chercher
     * @param bdd       objet Base de Données contenant la liste des articles
     */
    public Ligne chercherLigne(int idArticle, BdD bdd) {
        Ligne ligne = null;
        for (Client unClient : bdd.getClientsBdD()) {
            for (Commande uneCommande : unClient.getLesCommandes()) {
                for (Ligne uneLigne : uneCommande.getLesLignes()) {
                    if (uneLigne.getUnArticle().getIdArticle() == idArticle) {
                        ligne = uneLigne;
                    }
                }
            }
        }
        return ligne;
    }

    /**
     * Calcule le montant total HT de la commande
     * à partir du prix des articles présents dans
     * les lignes de commande
     *
     * @return Montant total HT de la commande
     */
    public double valoriserCommande() {
        double montant = 0.0;
        for (Ligne uneLigne : getLesLignes()) {
            montant += uneLigne.getUnArticle().getPrix() * uneLigne.getQteCommande();
        }
        return montant;
    }

    private void afficherLigne() {
        for (Ligne uneLigne : getLesLignes()) {
            System.out.println("\t" + uneLigne.getUnArticle().getIdArticle()
                    + " " + uneLigne.getUnArticle().getDesignation()
                    + ", quantité : " + uneLigne.getQteCommande());
        }
    }

    public void afficherCommande() {
        System.out.println("Commande : " + getIdCommande()
                + " du : " + getDateCommande());
        afficherLigne();
        System.out.print('\n');
    }

    public Article getArticle(int idArticle) {
        Article article = null;
        for (Ligne uneLigne : getLesLignes()) {
            if (uneLigne.getUnArticle().getIdArticle() == idArticle) {
                article = uneLigne.getUnArticle();
            }
        }
        return article;
    }


}
