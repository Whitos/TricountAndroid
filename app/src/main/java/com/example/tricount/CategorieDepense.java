package com.example.tricount;

import androidx.recyclerview.widget.RecyclerView;
import java.util.List;
import android.view.LayoutInflater;
import android.view.View;

public enum CategorieDepense {
    LOGEMENT("Logement"),
    DIVERTISSEMENT("Divertissement"),
    ALIMENTATION("Alimentation"),
    LOYER_CHARGES("Loyer & charges"),
    SHOPPING("Shopping"),
    TRANSPORT("Transport");

    private final String nom;

    CategorieDepense(String nom) {
        this.nom = nom;
    }

    public String getNom() {
        return nom;
    }

    @Override
    public String toString() {
        return nom;
    }
}
