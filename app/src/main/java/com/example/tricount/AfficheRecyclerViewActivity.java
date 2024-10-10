package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class AfficheRecyclerViewActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private TricountAdapter adapter;
    private List<Tricount> tricountList;
    private ImageButton buttonAdd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_affiche_recycler_view);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        tricountList = new ArrayList<>();
        // Add any initialization or dummy data to tricountList if needed

        adapter = new TricountAdapter(this, tricountList);
        recyclerView.setAdapter(adapter);

        buttonAdd = findViewById(R.id.buttonAdd);
        buttonAdd.setOnClickListener(v -> {
            Intent intent = new Intent(AfficheRecyclerViewActivity.this, NewTricountActivity.class);
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == 1 && resultCode == RESULT_OK) {
            // Handle the new Tricount that was created in NewTricountActivity
            String newTitle = data.getStringExtra("tricountTitle");
            List<String> participants = data.getStringArrayListExtra("participants");
            Tricount newTricount = new Tricount(newTitle, participants);
            tricountList.add(0, newTricount);
            adapter.notifyItemInserted(0);
        }
    }
}
