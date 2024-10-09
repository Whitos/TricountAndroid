package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;


//import androidx.activity.result.ActivityResult;
//import androidx.activity.result.ActivityResultCallback;
//import androidx.activity.result.ActivityResultLauncher;
//import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;


import com.example.tricount.databinding.ActivityNewTricountBinding;

public class NewTricountActivity extends AppCompatActivity {

    private ActivityNewTricountBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityNewTricountBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.buttonCreerTricount.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String titre = binding.editTextTitre.getText().toString();
                Intent intent = new Intent(NewTricountActivity.this, DepensesTricountActivity.class);
                //Intent intent1 = new Intent(NewTricountActivity.this, PageAccueilActivity.class); // RECYCLER VIEW
                intent.putExtra("titre", titre);

                startActivity(intent);
            }
        });
    }
}