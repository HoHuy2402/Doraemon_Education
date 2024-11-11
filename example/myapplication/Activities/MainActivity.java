// MainActivity.java
package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView imageViewLearnColors = findViewById(R.id.imgColors);
        ImageView imageViewChores = findViewById(R.id.imgChores);
        ImageView imageViewAnimals = findViewById(R.id.imgAnimals);
        ImageView imageViewQuiz = findViewById(R.id.imgQuiz);

        imageViewLearnColors.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, LearnColorsActivity.class);
                startActivity(intent);
            }
        });

        imageViewChores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HouseholdActivity.class);
                startActivity(intent);
            }
        });

        imageViewAnimals.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, AnimalsActivity.class);
                startActivity(intent);
            }
        });
        imageViewQuiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);
            }
        });
    }
}
