package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.tricount.databinding.ActivityAfficheRecyclerViewBinding;

public class PageAccueilActivity extends AppCompatActivity {

    private ActivityAfficheRecyclerViewBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAfficheRecyclerViewBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        binding.buttonAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(PageAccueilActivity.this, NewTricountActivity.class);
                startActivity(intent);
            }
        });
    }
}