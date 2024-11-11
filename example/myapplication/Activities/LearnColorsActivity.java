// LearnColorsActivity.java
package com.example.myapplication.Activities;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

import java.util.Locale;

public class LearnColorsActivity extends AppCompatActivity {

    private TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_learn_colors);

        // Initialize Text-to-Speech
        textToSpeech = new TextToSpeech(this, new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int status) {
                if (status != TextToSpeech.ERROR) {
                    textToSpeech.setLanguage(Locale.ENGLISH);
                }
            }
        });

        // Setup color buttons with click listeners
        Button colorRed = findViewById(R.id.colorRed);
        Button colorBlue = findViewById(R.id.colorBlue);
        Button colorGreen = findViewById(R.id.colorGreen);
        Button colorYellow = findViewById(R.id.colorYellow);

        colorRed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakColor("Red");
            }
        });

        colorBlue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakColor("Blue");
            }
        });

        colorGreen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakColor("Green");
            }
        });

        colorYellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                speakColor("Yellow");
            }
        });
    }

    private void speakColor(String color) {
        if (textToSpeech != null) {
            textToSpeech.speak(color, TextToSpeech.QUEUE_FLUSH, null, null);
        }
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
