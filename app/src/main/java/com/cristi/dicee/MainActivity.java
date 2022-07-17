package com.cristi.dicee;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button rollButton = (Button) findViewById(R.id.rollButton);
        final ImageView leftDice = (ImageView) findViewById(R.id.image_leftDice);
        final ImageView rightDice = (ImageView) findViewById(R.id.image_rightDice);
        TextView jackpotText = (TextView) findViewById(R.id.jackpot_text);
        jackpotText.setVisibility(View.INVISIBLE);

        final ArrayList<Integer> diceArray = new ArrayList<>();
        Collections.addAll(diceArray,
                R.drawable.dice1,
                R.drawable.dice2,
                R.drawable.dice3,
                R.drawable.dice4,
                R.drawable.dice5,
                R.drawable.dice6);

        Random randomNumberGenerator = new Random();

        // sets initial random images
        leftDice.setImageResource(diceArray.get(randomNumberGenerator.nextInt(6)));
        rightDice.setImageResource(diceArray.get(randomNumberGenerator.nextInt(6)));

        View.OnClickListener rollButtonOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int rand1 = randomNumberGenerator.nextInt(6);
                int rand2 = randomNumberGenerator.nextInt(6);

                leftDice.setImageResource(diceArray.get(rand1));
                rightDice.setImageResource(diceArray.get(rand2));

                if (rand1 == rand2) {
                    jackpotText.setVisibility(View.VISIBLE);
                }
                else {
                    jackpotText.setVisibility(View.INVISIBLE);
                }
            }
        };
        rollButton.setOnClickListener(rollButtonOnClickListener);
    }
}