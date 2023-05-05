package com.example.gradeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class RatingsActivity extends AppCompatActivity {

    Button btnHome;
    RatingBar ratingStar;
    float myRating = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ratings);

        btnHome = findViewById(R.id.btnRating);
        ratingStar = findViewById(R.id.ratingBar);

        ratingStar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {

                int ratingApp = (int) rating;
                String Message = null;

                myRating =  ratingBar.getRating();

                switch(ratingApp) {
                    case 1:
                        Message = "Sorry to hear that! :(";
                        break;
                    case 2:
                        Message = "Thanks For the Suggestion";
                        break;
                    case 3:
                        Message = "Good Enough";
                        break;
                    case 4:
                        Message = "Great! Thank You!";
                        break;
                    case 5:
                        Message = "Awesome! You are the best!";
                        break;
                }
                Toast.makeText(RatingsActivity.this,Message,Toast.LENGTH_SHORT).show();
            }
        });

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(RatingsActivity.this,"Your given rating is :"+myRating,Toast.LENGTH_SHORT).show();
                startActivity(new Intent(RatingsActivity.this,HomeActivity.class));
            }
        });
    }
}