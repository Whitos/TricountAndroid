package com.example.tricount;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class TricountAdapter extends RecyclerView.Adapter<TricountAdapter.TricountViewHolder> {

    private List<Tricount> tricountList;
    private Context context;


    public TricountAdapter(Context context, List<Tricount> tricountList) {
        this.context = context;
        this.tricountList = tricountList;
    }

    @NonNull
    @Override
    public TricountViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_tricount, parent, false);
        return new TricountViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TricountViewHolder holder, int position) {
        Tricount tricount = tricountList.get(position);
        holder.textViewTitle.setText(tricount.getTitle());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, ExpenseActivity.class);
            intent.putExtra("tricountTitle", tricount.getTitle());
            intent.putStringArrayListExtra("participants", new ArrayList<>(tricount.getParticipants()));
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return tricountList.size();
    }

    static class TricountViewHolder extends RecyclerView.ViewHolder {
        TextView textViewTitle;

        public TricountViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewTitle = itemView.findViewById(R.id.textViewTitle);
        }
    }
}
