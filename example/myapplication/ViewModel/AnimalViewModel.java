package com.example.myapplication.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AnimalViewModel extends ViewModel {
    public static class Animal {
        private final String name;
        private final String description;
        private final int imageResId;

        public Animal(String name, String description, int imageResId) {
            this.name = name;
            this.description = description;
            this.imageResId = imageResId;
        }

        public String getName() { return name; }
        public String getDescription() { return description; }
        public int getImageResId() { return imageResId; }
    }

    private final MutableLiveData<Animal> selectedAnimal = new MutableLiveData<>();

    public LiveData<Animal> getSelectedAnimal() {
        return selectedAnimal;
    }

    public void selectAnimal(Animal animal) {
        selectedAnimal.setValue(animal);
    }
}