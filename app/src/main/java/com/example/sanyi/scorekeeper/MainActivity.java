package com.example.sanyi.scorekeeper;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    static Random r = new Random();
    String playerA = "";
    String playerB = "";
    int pointsA = 0;
    int pointsB = 0;
    int turnA = 10;
    int turnB = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Send(View v) {
        EditText playeA = (EditText) findViewById(R.id.playerA);
        EditText playeB = (EditText) findViewById(R.id.playerB);
        playerA = playeA.getText().toString();
        playerB = playeB.getText().toString();
        if (playerA.equals("")) {
            playerA = "Player A";
        }
        if (playerB.equals("")) {
            playerB = "Player B";
        }
        setContentView(R.layout.play);
        TextView findA = (TextView) findViewById(R.id.teamA_label);
        TextView findB = (TextView) findViewById(R.id.teamB_label);
        findA.setText(playerA);
        findB.setText(playerB);
    }
    public  void reset(View v){
         pointsA = 0;
         pointsB = 0;
         turnA = 10;
         turnB = 10;
        display("A",0);
        display("B",0);
    }
    public void plus3(View v) {

        if (v.getId() == R.id.plus3A) {
            if(turnA>0){ display("A", 3);}
            else  Toast.makeText(this,"The game has already ended, Try again",Toast.LENGTH_LONG).show();
        } else {
            if(turnB>0){ display("B", 3);}
            else  Toast.makeText(this,"The game has already ended, Try again",Toast.LENGTH_LONG).show();
        }
    }

    public void plus2(View v) {
        if (v.getId() == R.id.plus2A) {
            if(turnA>0){ display("A", 2);}
            else  Toast.makeText(this,"The game has already ended, Try again",Toast.LENGTH_LONG).show();
        } else {
            if(turnB>0){ display("B", 2);}
            else  Toast.makeText(this,"The game has already ended, Try again",Toast.LENGTH_LONG).show();
        }

    }

    public void plus1(View v) {
        if (v.getId() == R.id.plus1A) {
            if(turnA>0){ display("A", 1);}
            else  Toast.makeText(this,"The game has already ended, Try again",Toast.LENGTH_LONG).show();
        } else {
            if(turnB>0){ display("B", 1);}
            else  Toast.makeText(this,"The game has already ended, Try again",Toast.LENGTH_LONG).show();
        }
    }

    public void display(String team, int point) {
        int rand = r.nextInt(11 - 1) + 1;
        TextView resultA = (TextView) findViewById(R.id.teamA_points);
        TextView resultB = (TextView) findViewById(R.id.teamB_points);
        TextView labelA = (TextView) findViewById(R.id.turnA);
        TextView labelB= (TextView) findViewById(R.id.turnB);
        switch (point) {
            case 3: {
                if (team == "A") {
                    turnA--;
                    if (rand > 6) {
                        pointsA += 10;
                        resultA.setText(String.valueOf(pointsA));
                        labelA.setText("Turns : "+String.valueOf(turnA));
                    } else {
                        pointsA -= 10;
                        resultA.setText(String.valueOf(pointsA));
                        labelA.setText("Turns : "+String.valueOf(turnA));
                    }

                } else {
                    turnB--;
                    if (rand > 6) {
                        pointsB += 10;
                        resultB.setText(String.valueOf(pointsB));
                        labelB.setText("Turns : "+String.valueOf(turnB));
                    } else {
                        pointsB -= 10;
                        resultB.setText(String.valueOf(pointsB));
                        labelB.setText("Turns : "+String.valueOf(turnB));
                    }
                }
                break;
            }
            case 2: {
                turnA--;
                if (team == "A") {
                    if (rand > 3) {
                        pointsA += 5;
                        resultA.setText(String.valueOf(pointsA));
                        labelA.setText("Turns : "+String.valueOf(turnA));
                    } else {
                        pointsA -= 5;
                        resultA.setText(String.valueOf(pointsA));
                        labelA.setText("Turns : "+String.valueOf(turnA));
                    }
                } else {
                    turnB--;
                    if (rand > 3) {
                        pointsB += 5;
                        resultB.setText(String.valueOf(pointsB));
                        labelB.setText("Turns : "+String.valueOf(turnB));
                    } else {
                        pointsB -= 5;
                        resultB.setText(String.valueOf(pointsB));
                        labelB.setText("Turns : "+String.valueOf(turnB));
                    }
                }
                break;
            }
            case 1: {
                turnA--;
                if (team == "A") {
                    if (rand > 1) {
                        pointsA += 1;
                        resultA.setText(String.valueOf(pointsA));
                        labelA.setText("Turns : "+String.valueOf(turnA));
                    } else {
                        pointsA -= 1;
                        resultA.setText(String.valueOf(pointsA));
                        labelA.setText("Turns : "+String.valueOf(turnA));
                    }
                } else {
                    turnB--;
                    if (rand > 1) {
                        pointsB += 1;
                        resultB.setText(String.valueOf(pointsB));
                        labelB.setText("Turns : "+String.valueOf(turnB));
                    } else {
                        pointsA -= 1;
                        resultB.setText(String.valueOf(pointsB));
                        labelB.setText("Turns : "+String.valueOf(turnB));
                    }
                }
                break;
            }
            case 0: {
                   resultA.setText(String.valueOf(pointsA));
                   labelA.setText("Turns : "+String.valueOf(turnA));
                   resultB.setText(String.valueOf(pointsB));
                   labelB.setText("Turns : "+String.valueOf(turnB));
                break;
            }
        }
    }


}
