package com.jgmayer.mascotas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class PetAdapter extends RecyclerView.Adapter<PetAdapter.PetViewHolder> {

    private List<PetModel> petModelList;

    public PetAdapter(List<PetModel> petModelList) {
        this.petModelList = petModelList;
    }

    @NonNull
    @Override
    public PetViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_pet, parent, false);
        return new PetViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PetViewHolder holder, int position) {
        final PetModel petModel = petModelList.get(position);
        holder.imagePet.setImageResource(petModel.getImage());
        holder.textPetName.setText(petModel.getName());
        holder.textTotalRating.setText(String.valueOf(petModel.getRating()));
        holder.imageRate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                petModel.setRating(petModel.getRating() + 1);
                petModel.setFavorite();
                notifyDataSetChanged();
            }
        });
    }

    @Override
    public int getItemCount() {
        return petModelList.size();
    }

    public static class PetViewHolder extends RecyclerView.ViewHolder {

        private ImageView imagePet;
        private ImageView imageRate;
        private TextView textPetName;
        private TextView textTotalRating;

        public PetViewHolder(@NonNull View itemView) {
            super(itemView);
            imagePet = itemView.findViewById(R.id.imagePet);
            imageRate = itemView.findViewById(R.id.imageRate);
            textPetName = itemView.findViewById(R.id.textPetName);
            textTotalRating = itemView.findViewById(R.id.textTotalRating);
            itemView.findViewById(R.id.imageTotalRating);
        }
    }
}
