package com.example.tricount;

import java.util.Date;

public class Depense {
    private String titre;
    private double montant;
    private Date date;
    private CategorieDepense categorieDepense;
    private Participant payeur;


    public Depense(String titre, double montant, Date date, CategorieDepense categorieDepense, Participant payeur) {
        this.titre = titre;
        this.montant = montant;
        this.date = date;
        this.categorieDepense = categorieDepense;
        this.payeur = payeur;
        validerMontant(montant);
    }

    public String getTitre() {
        return titre;
    }

    public double getMontant() {
        return montant;
    }

    public Date getDate() {
        return date;
    }
    
    public CategorieDepense getCategorieDepense() {
        return categorieDepense;
    }

    public Participant getPayeur() {
        return payeur;
    }

    public void modifierMontant(double montant) {
        validerMontant(montant);
        this.montant = montant;
    }

    public void modifierCategorie(CategorieDepense categorieDepense) {
        this.categorieDepense = categorieDepense;
    }

    public void modifierPayerPar(Participant payeur) {
        this.payeur = payeur;
    }

    public String toString() {
        return "Dépense: " + titre + ", Montant: " + montant + " EUR, Payée par: " + payeur.getName() + ", Catégorie: " + categorieDepense.getNom() + ", Date: " + date;
    }

    private void validerMontant(double montant) {
        if (montant < 0) {
            throw new IllegalArgumentException("Le montant ne peut pas être négatif.");
        }
    }

}
