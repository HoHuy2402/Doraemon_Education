package com.example.myapplication.Adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication.R;
import com.example.myapplication.ViewModel.AnimalViewModel;

import java.util.List;

public class AnimalSliderAdapter extends RecyclerView.Adapter<AnimalSliderAdapter.AnimalViewHolder> {

    private final List<AnimalViewModel.Animal> animals;
    private final OnAnimalClickListener onAnimalClickListener;

    public interface OnAnimalClickListener {
        void onAnimalClick(AnimalViewModel.Animal animal);
    }

    public AnimalSliderAdapter(List<AnimalViewModel.Animal> animals, OnAnimalClickListener listener) {
        this.animals = animals;
        this.onAnimalClickListener = listener;
    }

    @NonNull
    @Override
    public AnimalViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_animal_image, parent, false);
        return new AnimalViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AnimalViewHolder holder, int position) {
        AnimalViewModel.Animal animal = animals.get(position);
        holder.bind(animal, onAnimalClickListener);
    }

    @Override
    public int getItemCount() {
        return animals.size();
    }

    public static class AnimalViewHolder extends RecyclerView.ViewHolder {
        private final ImageView animalImage;

        public AnimalViewHolder(@NonNull View itemView) {
            super(itemView);
            animalImage = itemView.findViewById(R.id.animalImage);
        }

        public void bind(final AnimalViewModel.Animal animal, final OnAnimalClickListener listener) {
            animalImage.setImageResource(animal.getImageResId());
            animalImage.setOnClickListener(v -> listener.onAnimalClick(animal));
        }
    }
}