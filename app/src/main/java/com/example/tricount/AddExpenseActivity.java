package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tricount.R;

import java.util.List;
import java.util.ArrayList;

public class AddExpenseActivity extends AppCompatActivity {

    private EditText editTextTitreDepense;
    private EditText editTextMontant;
    private Spinner spinnerPaidBy;
    private EditText editTextDate;
    private Button buttonAjouterDepense;
    private List<String> participants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_expense);

        editTextTitreDepense = findViewById(R.id.editTextTitreDepense);
        editTextMontant = findViewById(R.id.editTextMontant);
        spinnerPaidBy = findViewById(R.id.spinnerPaidBy);
        editTextDate = findViewById(R.id.editTextDate);
        buttonAjouterDepense = findViewById(R.id.buttonAjouterDepense);

        // Get participants from the intent
        participants = getIntent().getStringArrayListExtra("participants");

        if (participants != null) {
            // Set up the spinner with the participants
            ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, participants);
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
            spinnerPaidBy.setAdapter(adapter);
        }

        buttonAjouterDepense.setOnClickListener(v -> {
            String titre = editTextTitreDepense.getText().toString().trim();
            String montant = editTextMontant.getText().toString().trim();
            String paidBy = (String) spinnerPaidBy.getSelectedItem();
            String date = editTextDate.getText().toString().trim();

            if (!titre.isEmpty() && !montant.isEmpty() && !date.isEmpty()) {
                Intent resultIntent = new Intent();
                resultIntent.putExtra("titre", titre);
                resultIntent.putExtra("montant", montant);
                resultIntent.putExtra("paidBy", paidBy);
                resultIntent.putExtra("date", date);
                setResult(RESULT_OK, resultIntent);
                finish();
            } else {
                if (titre.isEmpty()) {
                    editTextTitreDepense.setError("Titre ne peut pas être vide");
                }
                if (montant.isEmpty()) {
                    editTextMontant.setError("Montant ne peut pas être vide");
                }
                if (date.isEmpty()) {
                    editTextDate.setError("Date ne peut pas être vide");
                }
            }
        });
    }
}
