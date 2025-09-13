package com.laro.laroflashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

public class AddQuestion extends AppCompatActivity {

    private ImageView backButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_question);

        backButton = findViewById(R.id.back_btn);

        returnToMain();
    }

    //return to main activity
    private void returnToMain()
    {
        backButton.setOnClickListener(v -> {
            startActivity(new Intent(AddQuestion.this, MainActivity.class));
            this.finish();
        });
    }
}