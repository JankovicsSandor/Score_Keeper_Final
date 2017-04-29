package com.example.sanyi.scorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class Play extends AppCompatActivity {

    static Random r = new Random();
    int pointsA = 0;
    int pointsB = 0;
    int turnA = 10;
    int turnB = 10;
    int redstick = 10;
    int blue_stick = 5;
    int yellow_stick = 1;

    // Setting onclick listeners so we can reuse them
    private View.OnClickListener plus3Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.plus3A) {
                if (turnA > 0) {
                    display("A", 3);
                } else {
                    Toast.makeText(Play.this, "The game has already ended, Try again", Toast.LENGTH_LONG).show();
                }

            } else {
                if (turnB > 0) {
                    display("B", 3);
                } else {
                    Toast.makeText(Play.this, "The game has already ended, Try again", Toast.LENGTH_LONG).show();
                }
            }
        }
    };
    private View.OnClickListener plus2Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v.getId() == R.id.plus2A) {
                if (turnA > 0) {
                    display("A", 2);
                } else {
                    Toast.makeText(Play.this, "The game has already ended, Try again", Toast.LENGTH_LONG).show();
                }
            } else {
                if (turnB > 0) {
                    display("B", 2);
                } else {
                   Toast.makeText(Play.this, "The game has already ended, Try again", Toast.LENGTH_LONG).show();
                }

            }
        }
    };
    private View.OnClickListener plus1Listener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (v.getId() == R.id.plus1A) {
                if (turnA > 0) {
                    display("A", 1);
                } else {
                    Toast.makeText(Play.this, "The game has already ended, Try again", Toast.LENGTH_SHORT).show();
                }
            } else {
                if (turnB > 0) {
                    display("B", 1);
                } else {
                    Toast.makeText(Play.this, "The game has already ended, Try again", Toast.LENGTH_SHORT).show();
                }

            }
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.play);
        Intent name = getIntent();
        String nameA = name.getStringExtra("playera");
        String nameB = name.getStringExtra("playerb");
        TextView first = (TextView) findViewById(R.id.teamA_label);
        TextView second = (TextView) findViewById(R.id.teamB_label);
        first.setText(nameA);
        second.setText(nameB);

        // Setting onclick listeners for buttons
        Button plus3A = (Button) findViewById(R.id.plus3A);
        Button plus3B = (Button) findViewById(R.id.plus3B);
        Button plus2A = (Button) findViewById(R.id.plus2A);
        Button plus2B = (Button) findViewById(R.id.plus2B);
        Button plus1A = (Button) findViewById(R.id.plus1A);
        Button plus1B = (Button) findViewById(R.id.plus1B);
        plus3A.setOnClickListener(plus3Listener);
        plus3B.setOnClickListener(plus3Listener);
        plus2A.setOnClickListener(plus2Listener);
        plus2B.setOnClickListener(plus2Listener);
        plus1A.setOnClickListener(plus1Listener);
        plus1B.setOnClickListener(plus1Listener);
        Button reset = (Button) findViewById(R.id.reset);
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pointsA = 0;
                pointsB = 0;
                turnA = 10;
                turnB = 10;
                display("A", 0);
                display("B", 0);
            }
        });
    }

    /***
     *
     * @param team we have team A and team B stored in a string variable
     * @param point Integer variable stroing how much we have to give to the certaing team
     */
    public void display(String team, int point) {
        // Random variable not to always win every chanche
        int rand = r.nextInt(11 - 1) + 1;
        // Getting the textviews which has to be setted
        TextView resultA = (TextView) findViewById(R.id.teamA_points);
        TextView resultB = (TextView) findViewById(R.id.teamB_points);
        // Indicating how much we had left
        TextView labelA = (TextView) findViewById(R.id.turnA);
        TextView labelB = (TextView) findViewById(R.id.turnB);
        // Switch to handle multiple point cases condidition is points because this we can minimalise the conditions
        switch (point) {
            // Adding 3 points
            case 3: {
                if (team.equals("A")) {
                    turnA--;
                    if (rand > 6) {
                        pointsA += redstick;
                        resultA.setText(String.valueOf(pointsA));
                        labelA.setText("Turns: "+String.valueOf(turnA));
                    } else {
                        pointsA -= redstick;
                        resultA.setText(String.valueOf(pointsA));
                        labelA.setText("Turns: "+String.valueOf(turnA));
                    }
                } else {
                    turnB--;
                    if (rand > 6) {
                        pointsB += redstick;
                        resultB.setText(String.valueOf(pointsB));
                        labelB.setText("Turns: "+String.valueOf(turnB));
                    } else {
                        pointsB -= redstick;
                        resultB.setText(String.valueOf(pointsB));
                        labelB.setText("Turns: "+String.valueOf(turnB));
                    }
                }
                break;
            }
            // Adding 2 points
            case 2: {
                // Team A scores
                if (team.equals("A")) {
                    turnA--;
                    if (rand > 3) {
                        pointsA += blue_stick;
                        resultA.setText(String.valueOf(pointsA));
                        labelA.setText("Turns: "+String.valueOf(turnA));
                    } else {
                        pointsA -= blue_stick;
                        resultA.setText(String.valueOf(pointsA));
                        labelA.setText("Turns: "+String.valueOf(turnA));
                    }
                } else {
                    // Team B scores
                    turnB--;
                    if (rand > 3) {
                        pointsB += blue_stick;
                        resultB.setText(String.valueOf(pointsB));
                        labelB.setText("Turns: "+String.valueOf(turnB));
                    } else {
                        pointsB -= blue_stick;
                        resultB.setText(String.valueOf(pointsB));
                        labelB.setText("Turns: "+String.valueOf(turnB));
                    }
                }
                break;
            }
            // Adding 1 points
            case 1: {
                // Team A scores
                if (team.equals("A")) {
                    //Subtracting from remaining round
                    turnA--;
                    // Checking if we got the actual chance we wanted
                    if (rand > 1) {
                        pointsA += yellow_stick;
                        resultA.setText(String.valueOf(pointsA));
                        labelA.setText("Turns: "+String.valueOf(turnA));
                    } else {
                        pointsA -= yellow_stick;
                        resultA.setText(String.valueOf(pointsA));
                        labelA.setText("Turns: "+String.valueOf(turnA));
                    }
                    // Team B scores
                } else {
                    turnB--;
                    if (rand > 1) {
                        pointsB += yellow_stick;
                        resultB.setText(String.valueOf(pointsB));
                        labelB.setText("Turns: "+String.valueOf(turnB));
                    } else {
                        pointsA -= yellow_stick;
                        resultB.setText(String.valueOf(pointsB));
                        labelB.setText("Turns: "+String.valueOf(turnB));
                    }
                }
                break;
            }
            // Indicating how much turn we had left
            case 0: {
                resultA.setText(String.valueOf(pointsA));
                labelA.setText(String.valueOf(turnA));
                resultB.setText(String.valueOf(pointsB));
                labelB.setText(String.valueOf(turnB));
                break;
            }
        }
    }
}
