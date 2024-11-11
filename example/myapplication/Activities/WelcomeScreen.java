// WelcomeScreen.java
package com.example.myapplication.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;

import com.example.myapplication.R;

public class WelcomeScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome_screen);

        ImageView bellImage = findViewById(R.id.bellImage);

        // Load the entry animation
        Animation entryAnimation = AnimationUtils.loadAnimation(this, R.anim.bell_entry_animation);
        // Load the swinging (ringing) animation for later use
        Animation swingAnimation = AnimationUtils.loadAnimation(this, R.anim.bell_swing_animation);

        // Start the entry animation
        bellImage.startAnimation(entryAnimation);

        // Wait until the entry animation is complete
        entryAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                // Set the click listener after the entry animation completes
                bellImage.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Start the swinging (ringing) animation
                        bellImage.startAnimation(swingAnimation);

                        // Transition to MainActivity after swinging animation ends
                        swingAnimation.setAnimationListener(new Animation.AnimationListener() {
                            @Override
                            public void onAnimationStart(Animation animation) {}

                            @Override
                            public void onAnimationEnd(Animation animation) {
                                Intent intent = new Intent(WelcomeScreen.this, MainActivity.class);
                                startActivity(intent);
                                finish();
                            }

                            @Override
                            public void onAnimationRepeat(Animation animation) {}
                        });
                    }
                });
            }

            @Override
            public void onAnimationRepeat(Animation animation) {}
        });
    }
}
