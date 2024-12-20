package metier;

import java.util.*;

public class Tva {

    private int idTva;
    private double tauxTva;

    public Tva(int idTva, double tauxTva) {
        setIdTva(idTva);
        setTauxTva(tauxTva);
    }

    public int getIdTva() {
        return idTva;
    }
    public void setIdTva(int idTva) {
        this.idTva = idTva;
    }

    public double getTauxTva() {
        return tauxTva;
    }

    public void setTauxTva(double tauxTva) {
        this.tauxTva = tauxTva;
    }
}
