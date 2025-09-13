package com.laro.laroflashcard;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private TextView response;
    private ImageView plusBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flascard_ui);

        question = findViewById(R.id.questionId);
        response = findViewById(R.id.resposeId);
        plusBtn = findViewById(R.id.plusBtn);
        response.setVisibility(View.GONE);

        showAnswer();
        resetView();
        launchQuestionForm();
    }

    private void showAnswer()
    {
        //adding click event listener on question textview
        question.setOnClickListener(v -> {
            response.setVisibility(View.VISIBLE);
            question.setVisibility(View.GONE);
        });
    }

    private void resetView()
    {
        View rootview = findViewById(android.R.id.content);
        rootview.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                //reset all views
                question.setVisibility(View.VISIBLE);
                response.setVisibility(View.GONE);
                return false;
            }
        });
    }

    private void launchQuestionForm()
    {
        plusBtn.setOnClickListener(v -> {
            startActivity(new Intent(MainActivity.this, AddQuestion.class));
        });
    }
}