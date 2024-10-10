package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Spinner;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NewTricountActivity extends AppCompatActivity {

    private EditText editTextTitre;
    private Spinner spinnerDevise;
    private LinearLayout participantsContainer;
    private ImageButton buttonAddParticipant;
    private Button buttonCreerTricount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_tricount);

        // Initialize views
        editTextTitre = findViewById(R.id.editTextTitre);
        spinnerDevise = findViewById(R.id.spinnerDevise);
        participantsContainer = findViewById(R.id.participantsContainer);
        buttonAddParticipant = findViewById(R.id.buttonAddParticipant);
        buttonCreerTricount = findViewById(R.id.buttonCreerTricount);

        // Set click listener for add participant button
        buttonAddParticipant.setOnClickListener(v -> addParticipantField());

        // Set click listener for "Créer un Tricount" button
        buttonCreerTricount.setOnClickListener(v -> {
            String titre = editTextTitre.getText().toString().trim();
            String devise = spinnerDevise.getSelectedItem().toString();
            ArrayList<String> participants = new ArrayList<>();

            // Collect all participants entered
            for (int i = 0; i < participantsContainer.getChildCount(); i++) {
                View participantView = participantsContainer.getChildAt(i);
                if (participantView instanceof EditText) {
                    String participantName = ((EditText) participantView).getText().toString().trim();
                    if (!participantName.isEmpty()) {
                        participants.add(participantName);
                    }
                }
            }

            if (!titre.isEmpty() && !participants.isEmpty()) {
                // Proceed to create a Tricount or pass the data to another activity
                Intent resultIntent = new Intent();
                resultIntent.putExtra("tricountTitle", titre);
                resultIntent.putExtra("tricountDevise", devise);
                resultIntent.putStringArrayListExtra("participants", participants);
                setResult(RESULT_OK, resultIntent);
                finish(); // Close the activity and return the result
            } else {
                // Show error messages if necessary fields are empty
                if (titre.isEmpty()) {
                    editTextTitre.setError("Title is required");
                }
                if (participants.isEmpty()) {
                    // Optionally show an error message to inform user about participants
                }
            }
        });
    }

    private void addParticipantField() {
        EditText newParticipantField = new EditText(this);
        newParticipantField.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        newParticipantField.setBackground(getResources().getDrawable(R.drawable.rounded_button));
        newParticipantField.setHint("Enter participant name");
        participantsContainer.addView(newParticipantField);
    }
}
