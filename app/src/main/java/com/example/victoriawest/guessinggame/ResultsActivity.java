package com.example.victoriawest.guessinggame;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class ResultsActivity extends AppCompatActivity {

    private Button playAgainButton;
    private TextView correctNumberBTextview;
    private TextView resultsTextView;
    private ImageView resultsImageview;
    protected Intent intent;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);


        playAgainButton = findViewById(R.id.replay_button);
        correctNumberBTextview = findViewById(R.id.number_textview);
        resultsTextView = findViewById(R.id.results_textview);
        resultsImageview = findViewById(R.id.winning_imageview);

        setListener();

        intent = getIntent();
        if(intent.hasExtra("WINNING_NUMBER"))
            setLosingData();
    }

    private void setLosingData(){
        int winningNumber = intent.getIntExtra("WINNING_NUMBER",0);
        resultsTextView.setText("You Lost!");
        correctNumberBTextview.setText(getString(R.string.winning_number, winningNumber));
        correctNumberBTextview.setVisibility(View.VISIBLE);
        resultsImageview.setImageResource(R.drawable.losingsadface);
    }


    private void setListener() {
        playAgainButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();

            }
        });
    }
}
