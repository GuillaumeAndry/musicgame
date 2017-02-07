package fr.univartois.iutlens.mmi.web2.musicgame;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        int score= getIntent().getIntExtra("SCORE",-1);

        TextView scoreLabel = (TextView) findViewById(R.id.scoreLabel);
        scoreLabel.setText(""+score);
        TextView highScoreLabel = (TextView) findViewById(R.id.highScoreLabel);

        SharedPreferences settings = getSharedPreferences("GAME_DATA", Context.MODE_PRIVATE);
        int highScore = settings.getInt("HIGH_SCORE", 0);

        if (score > highScore) {
            highScoreLabel.setText("High Score : " + score);

            SharedPreferences.Editor editor = settings.edit();
            editor.putInt("HIGH SCORE",score);
            editor.commit();
        } else {
            highScoreLabel.setText("High Score : " + highScore);
        }
    }
}
