package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tricount.databinding.ActivityDepensesTricountBinding;

public class DepensesTricountActivity extends AppCompatActivity {

    private ActivityDepensesTricountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDepensesTricountBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        String titreRecu = getIntent().getStringExtra("titre");
        binding.textViewTitre.setText(titreRecu);

        binding.buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titre = binding.textViewTitre.getText().toString();
                Intent intent = new Intent(DepensesTricountActivity.this, PageAccueilActivity.class);
                intent.putExtra("titre", titre);

                startActivity(intent);
            }
        });
    }
}