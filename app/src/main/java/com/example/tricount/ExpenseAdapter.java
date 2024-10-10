package com.example.tricount;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExpenseAdapter extends RecyclerView.Adapter<ExpenseAdapter.ExpenseViewHolder> {

    private List<Expense> expenseList;

    public ExpenseAdapter(List<Expense> expenseList) {
        this.expenseList = expenseList;
    }

    @NonNull
    @Override
    public ExpenseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_expense, parent, false);
        return new ExpenseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpenseViewHolder holder, int position) {
        Expense expense = expenseList.get(position);
        holder.textViewExpenseTitle.setText(expense.getTitle());
        holder.textViewExpenseAmount.setText(String.format("%.2f €", expense.getAmount()));
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public static class ExpenseViewHolder extends RecyclerView.ViewHolder {
        TextView textViewExpenseTitle;
        TextView textViewExpenseAmount;

        public ExpenseViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewExpenseTitle = itemView.findViewById(R.id.textViewExpenseTitle);
            textViewExpenseAmount = itemView.findViewById(R.id.textViewExpenseAmount);
        }
    }
}
