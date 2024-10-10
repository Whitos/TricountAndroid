package com.example.tricount;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class ExpenseActivity extends AppCompatActivity {

    private List<String> participants;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expense);

        participants = getIntent().getStringArrayListExtra("participants");

        Button newExpenseButton = findViewById(R.id.buttonNouveauDepense);
        newExpenseButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExpenseActivity.this, AddExpenseActivity.class);
            intent.putStringArrayListExtra("participants", new ArrayList<>(participants));
            startActivityForResult(intent, 1);
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        // Handle the result from AddExpenseActivity
    }
}
