package com.laro.laroflashcard;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView question;
    private TextView response;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.flascard_ui);

        // link to xml view
        question = findViewById(R.id.questionId);
        response = findViewById(R.id.resposeId);
        response.setVisibility(View.GONE);

        showAnswer();
        resetView();
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
}