package com.example.sanyi.scorekeeper;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {


    String playerA = "";
    String playerB = "";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button button = (Button) findViewById(R.id.send);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
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
                Log.v("Valus PLayer A: ",playerA);
                Log.v("Valus Player B:",playerB);

                Intent newActivity = new Intent(MainActivity.this,Play.class);
                newActivity.putExtra("playera", playerA);
                newActivity.putExtra("playerb", playerB);
                startActivity(newActivity);

            }
        });
    }

}
