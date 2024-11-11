package com.example.myapplication.Activities;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.widget.TextView;
//import androidx.activity.viewModels;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewpager2.widget.ViewPager2;

import com.example.myapplication.Adapters.AnimalSliderAdapter;
import com.example.myapplication.R;
import com.example.myapplication.ViewModel.AnimalViewModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class AnimalsActivity extends AppCompatActivity {

    private AnimalViewModel animalViewModel;
    private TextToSpeech textToSpeech;
    private TextView animalInfoText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animals);

        animalViewModel = new ViewModelProvider(this).get(AnimalViewModel.class);
        animalInfoText = findViewById(R.id.animalInfoText);
        ViewPager2 animalImageSlider = findViewById(R.id.animalImageSlider);

        // Initialize TextToSpeech
        textToSpeech = new TextToSpeech(this, status -> {
            if (status == TextToSpeech.SUCCESS) {
                textToSpeech.setLanguage(Locale.US);
            }
        });

        // Dummy data - Replace with your own images and descriptions
        List<AnimalViewModel.Animal> animals = new ArrayList<>();
        animals.add(new AnimalViewModel.Animal("Lion", "The lion is known as the king of the jungle.", R.drawable.lion));
        animals.add(new AnimalViewModel.Animal("Elephant", "Elephants are the largest land animals on Earth.", R.drawable.elephant));
        animals.add(new AnimalViewModel.Animal("Tiger", "The tiger is a powerful carnivorous animal.", R.drawable.tiger));

        // Set up the ViewPager2 with an adapter
        AnimalSliderAdapter adapter = new AnimalSliderAdapter(animals, animal -> animalViewModel.selectAnimal(animal));
        animalImageSlider.setAdapter(adapter);

        // Observe selected animal in the ViewModel
        animalViewModel.getSelectedAnimal().observe(this, animal -> {
            animalInfoText.setText(animal.getName() + ": " + animal.getDescription());
            animalInfoText.setVisibility(TextView.VISIBLE);

            // Speak out the description
            textToSpeech.speak(animal.getDescription(), TextToSpeech.QUEUE_FLUSH, null, null);
        });
    }

    @Override
    protected void onDestroy() {
        if (textToSpeech != null) {
            textToSpeech.stop();
            textToSpeech.shutdown();
        }
        super.onDestroy();
    }
}
